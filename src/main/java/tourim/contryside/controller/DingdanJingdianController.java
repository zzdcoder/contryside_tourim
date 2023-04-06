package tourim.contryside.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tourim.contryside.pojo.DingdanJingdianEntity;
import tourim.contryside.pojo.JingdianEntity;
import tourim.contryside.pojo.UserEntity;
import tourim.contryside.service.DingdanJingdianService;
import tourim.contryside.service.JingdianService;
import tourim.contryside.service.UserService;
import tourim.contryside.service.impl.DingdanJingdianServiceImpl;
import tourim.contryside.vo.JingDian_order_pay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Controller
@Slf4j
public class DingdanJingdianController {
    @Autowired
    private DingdanJingdianService dingdanJingdianService;
    @Autowired
    private JingdianService jingdianService;
    @Autowired
    private UserService userService;

    @PostMapping("/confirm_order")
    public String  submitOrder(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response, RedirectAttributes redirectAttributes) throws IOException {
        //或取用户名
        String username = (String) httpSession.getAttribute("username");
        //获取用户id
        UserEntity user = userService.getUserByname(username);
        Integer userId = user.getUserId();
        //获取表单数据
        String contactName = request.getParameter("contactName");
        String contactPhone = request.getParameter("contactPhone");
        String jdName = request.getParameter("jdName");
        String orderTime = request.getParameter("orderTime");
        String totalPrice = request.getParameter("totalPrice");
        String jd_num = request.getParameter("jd_num");
        //获取景点id
        JingdianEntity jingdian = jingdianService.getJingDianByName(jdName);
        Integer jdId = jingdian.getJdId();

       /* DingdanJingdianEntity dingdanJingdianEntity = dingdanJingdianService.getDingdanJingdianByJdid(jdId);
        //以前表里的数量
        String odernum = dingdanJingdianEntity.getJdNum();
        String  ordertotalprice =dingdanJingdianEntity.getTotalPrice();
        //先判断表里面有没有数据有就更新数据没有就新增
        if (dingdanJingdianEntity!=null){
             int totalnum=Integer.parseInt(odernum)+ Integer.parseInt(odernum);
             int newtotalprice=Integer.parseInt(ordertotalprice)+Integer.parseInt(totalPrice);
            DingdanJingdianEntity DingdanJingdianEntity2 = new DingdanJingdianEntity(null, userId, jdId,orderTime,contactPhone,contactName,String.valueOf(newtotalprice),String.valueOf(totalnum));
            int result = dingdanJingdianService.updateduplicateorder(DingdanJingdianEntity2);
        }*/

            //增加数据
            DingdanJingdianEntity DingdanJingdianEntity1 = new DingdanJingdianEntity(null, userId, jdId,orderTime,contactPhone,contactName,totalPrice,jd_num);
            dingdanJingdianService.save(DingdanJingdianEntity1);


        //可以通过Model来获取
        redirectAttributes.addFlashAttribute("jdId", jdId);  //会一直携带数据直到下一次请求
         return  "redirect:/dealpay_order";
    }

    @GetMapping("/dealpay_order")
    public String gotoPay(Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //获取重定向携带的参数
        Integer jdId = (Integer) model.getAttribute("jdId");
        JingDian_order_pay jingDian_order_pay = userService.getorderpay(jdId);
        model.addAttribute("order",jingDian_order_pay);
       return "confirm_order2";
    }
}
