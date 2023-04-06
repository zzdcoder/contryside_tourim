package tourim.contryside.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tourim.contryside.pojo.DingdanFangwuEntity;
import tourim.contryside.pojo.FangwuEntity;
import tourim.contryside.pojo.HuzhuEntity;
import tourim.contryside.pojo.UserEntity;
import tourim.contryside.service.DingdanFangwuService;
import tourim.contryside.service.FangwuService;
import tourim.contryside.service.HuzhuService;
import tourim.contryside.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Controller
public class DingdanFangwuController {
    @Autowired
    private UserService userService;
    @Autowired
    private HuzhuService huzhuService;
    @Autowired
    private FangwuService fangwuService;
    @Autowired
    private DingdanFangwuService dingdanFangwuService;

    @GetMapping("/gotohouseorder")
   public String gotoHouseOrder(Model model, HttpSession session){
        Object huzhuEntity = session.getAttribute("huzhuEntity");
        Object fangwuimg = session.getAttribute("fangwuimg");
        Object fangwuHuodong = session.getAttribute("fangwuHuodong");
        //将字符串转换为对应的实体类对象
        HuzhuEntity huzuconvertValue = new ObjectMapper().convertValue(huzhuEntity, HuzhuEntity.class);
        FangwuEntity houdongconvertValue = new ObjectMapper().convertValue(fangwuHuodong, FangwuEntity.class);
        FangwuEntity fangwuimgconvertValue = new ObjectMapper().convertValue(fangwuimg, FangwuEntity.class);
        model.addAttribute("huzuinfo",huzuconvertValue);
        model.addAttribute("fangwuimg",fangwuimgconvertValue);
        model.addAttribute("houdong",houdongconvertValue);
        return "submit_house";
    }
    @PostMapping("/save_houseo")
    public String savahouseorder(HttpServletRequest request, HttpSession session) {
        String contactName = request.getParameter("contactName");
        String contactPhone = request.getParameter("contactPhone");
        String huzuName = request.getParameter("huzuName");
        String orderTime = request.getParameter("orderTime");
        String totalPrice = request.getParameter("totalPrice");
        String monthNum = request.getParameter("monthNum");

        //根据sessiong查用户id
        String username = (String) session.getAttribute("username");
        UserEntity userByname = userService.getUserByname(username);
        Integer userId = userByname.getUserId();

        //根据户主名查id
        LambdaQueryWrapper<HuzhuEntity> huzhuEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        huzhuEntityLambdaQueryWrapper.eq(HuzhuEntity::getHzName, huzuName);
        HuzhuEntity huzhuEntity = huzhuService.getOne(huzhuEntityLambdaQueryWrapper);
        Integer hzId = huzhuEntity.getHzId();

        //根据户主查房屋id
        LambdaQueryWrapper<FangwuEntity> fangwuEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        fangwuEntityLambdaQueryWrapper.eq(FangwuEntity::getHzId, hzId);
        FangwuEntity fangwuEntity = fangwuService.getOne(fangwuEntityLambdaQueryWrapper);
        Integer fwId = fangwuEntity.getFwId();

        //存入数据
        DingdanFangwuEntity dingdanFangwuEntity = new DingdanFangwuEntity(null, userId, fwId, orderTime, contactName, contactPhone, monthNum, totalPrice);
        boolean save = dingdanFangwuService.save(dingdanFangwuEntity);
        return "redirect:http://localhost:8088";
    }
}
