package tourim.contryside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourim.contryside.pojo.UserEntity;
import tourim.contryside.service.impl.UserServiceImpl;
import tourim.contryside.utils.ResultUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zhouzunda
 * @date 2023年03月20日 10:54
 * @description
 */
@Controller
public class CheckLoginRegisterController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ResultUtils resultUtils;
    @ResponseBody
    @PostMapping("/checklogin")
    public ResultUtils gotLogin(@RequestBody Map<String,String> map){
         ResultUtils result = userService.getOneUserByPhone(map.get("phone"));
        if (result.getStatus()==404){
            resultUtils.setStatus(404);
            resultUtils.setMessage("用户不存在");
        }
        else {
            if (resultUtils.getData().equals(map.get("password"))){
                resultUtils.setStatus(200);
                resultUtils.setMessage("yes");
            }
            else {
                resultUtils.setMessage("密码错误");
                resultUtils.setStatus(500);
            }
        }
        return resultUtils;
    }
    @PostMapping("/success")
    public String LoginSuccess(@RequestParam String phone, HttpSession session){
        UserEntity oneuser= userService.getUserByPhone(phone);
        /*
         *
         * @author zhouzunda
         * @date 2023/3/22 8:45
         * @param map
         * @param session
         * @return java.lang.String
         * @description  往session域中共享数据
         **/
        session.setAttribute("username", oneuser.getUserName());
        session.setAttribute("userheader", oneuser.getUserHeader());
        session.setAttribute("usergender", oneuser.getUserGender());
        session.setAttribute("userbirthday", oneuser.getUserBirthday());
        session.setAttribute("usercity", oneuser.getLocCity());
        session.setAttribute("useridiograph", oneuser.getUserIdiograph());
        return "redirect:http://localhost:8088";
    }
    @PostMapping("/registersucc")
    public String registerSuccess(@RequestParam String phone,@RequestParam String password,@RequestParam String username){
        UserEntity userEntity = new UserEntity(null,username,phone, password, null,null,null,null,null);
        userService.save(userEntity);
        return "redirect:/gotologin";
    }
    @ResponseBody
    @PostMapping("/checkregister")
    public ResultUtils checkRegister(@RequestBody  UserEntity userEntity){
        UserEntity user = userService.getUserByPhone(userEntity.getUserTelephone());
        if (user!=null){
                resultUtils.setStatus(300);
                resultUtils.setErrorMsg("用户已存在");
            }
           return resultUtils;
    }
    @GetMapping("/quit_log")
    public String quitLog(HttpSession session){
        //清除当前用户信息
        session.removeAttribute("username");
        session.removeAttribute("userheader");
        //重定向到登录页面
        return "redirect:/gotologin";
    }
}
