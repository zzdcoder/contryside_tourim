package tourim.contryside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import tourim.contryside.pojo.AddressEntity;
import tourim.contryside.pojo.DingdanShangpinEntity;
import tourim.contryside.pojo.ShangpinEntity;
import tourim.contryside.pojo.UserEntity;
import tourim.contryside.service.AddressService;
import tourim.contryside.service.DingdanShangpinService;
import tourim.contryside.service.ShangpinService;
import tourim.contryside.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Controller
public class DingdanShangpinController {
    @Autowired
    private UserService userService;
   @Autowired
   private AddressService addressService;
   @Autowired
   private DingdanShangpinService dingdanShangpinService;
   @Autowired
   private ShangpinService shangpinService;
   @PostMapping("/gotoOrder")
    public String gotoOrder(Model model, HttpServletRequest request){
       String spName = request.getParameter("spName");
       String spPicture = request.getParameter("spPicture");
       String price = request.getParameter("price");
       String totalPrice = request.getParameter("totalPrice");
       String spNum = request.getParameter("spNum");
       String orderTime = request.getParameter("orderTime");
       model.addAttribute("spName",spName);
       model.addAttribute("spPicture",spPicture);
       model.addAttribute("price",price);
       model.addAttribute("totalPrice",totalPrice);
       model.addAttribute("spNum",spNum);
       model.addAttribute("orderTime",orderTime);
      List<AddressEntity> topFourAddress = addressService.getTopFourAddress();
      model.addAttribute("addressList",topFourAddress);
       return "confirm_order";
   }

   @PostMapping("/save_goodsorder")
    public String saveOrder(HttpServletRequest request, HttpSession session){
       String addre = request.getParameter("addre");
       String total_price = request.getParameter("total_price");
       String order_time = request.getParameter("order_time");
       String sp_name = request.getParameter("sp_name");
       String sp_num = request.getParameter("sp_num");
       System.out.println(addre+""+total_price+""+order_time+""+sp_name+""+sp_num);
       String username = (String) session.getAttribute("username");
       UserEntity userByname = userService.getUserByname(username);
       Integer userId = userByname.getUserId();
       AddressEntity addressByName = addressService.getAddressByName(addre);
       //获取地址id
       Integer adId = addressByName.getAdId();
      ShangpinEntity getshangpingbyname = shangpinService.getshangpingbyname(sp_name);
      Integer spId = getshangpingbyname.getSpId();
      DingdanShangpinEntity dingdanShangpinEntity = new DingdanShangpinEntity(null,userId,spId,order_time,Integer.parseInt(sp_num),Double.parseDouble(total_price),adId);
      //修改商品库存
       shangpinService.updateGoodsByname(sp_name, Integer.parseInt(sp_num));
      //存入数据库
       dingdanShangpinService.save(dingdanShangpinEntity);
      return  "redirect:http://localhost:8088";
   }
}
