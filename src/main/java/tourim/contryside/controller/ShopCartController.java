package tourim.contryside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourim.contryside.pojo.ShangpinEntity;
import tourim.contryside.pojo.ShopCartEntity;
import tourim.contryside.pojo.UserEntity;
import tourim.contryside.service.ShangpinService;
import tourim.contryside.service.ShopCartService;
import tourim.contryside.service.UserService;
import tourim.contryside.vo.shopcart_shangpin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-26
 */
@Controller
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShangpinService shangpinService;
    @PostMapping("/gotoCart")
    public String gotoCart(HttpServletRequest request, Model model, HttpSession session){
        String spName = request.getParameter("spName");
        String spPicture = request.getParameter("spPicture");
        String price = request.getParameter("price");
        String totalPrice = request.getParameter("totalPrice");
        String spNum = request.getParameter("spNum");
        String orderTime = request.getParameter("orderTime");
        //得到用户id
        String username = (String) session.getAttribute("username");
        UserEntity user = userService.getUserByname(username);
        Integer userId = user.getUserId();
        //得到商品id
        ShangpinEntity shangpinEntity = shangpinService.getshangpingbyname(spName);
        Integer spId = shangpinEntity.getSpId();
        ShopCartEntity shopCartEntity = new ShopCartEntity(null,spId,userId,Integer.parseInt(spNum),orderTime,Double.parseDouble(totalPrice));

        //存入数据库之前先判断同一个用户有没有相同的商品，有就更新，没有就插入
        ShopCartEntity shopCartEntity1 = shopCartService.getShopByUidAndSpid(userId, spId);
        if (shopCartEntity1!=null){
            shopCartService.updateCartByUidAndSpid(shopCartEntity);
        }else {
            boolean save = shopCartService.save(shopCartEntity);
        }
        List<shopcart_shangpin> cart_list = shopCartService.getAllCartByUid(userId);
        model.addAttribute("cart_list",cart_list);
        return "shop_car";
    }

    @GetMapping("/delete_one")
    public String delete(@RequestParam("spName") String spname,Model model,HttpSession session){
        //得到用户id
        String username = (String) session.getAttribute("username");
        UserEntity user = userService.getUserByname(username);
        Integer userId = user.getUserId();
        ShangpinEntity getshangpingbyname = shangpinService.getshangpingbyname(spname);
        Integer spId = getshangpingbyname.getSpId();
        int result = shopCartService.deleteOneByspid(spId);
        //根据用户id查询购物车
        List<shopcart_shangpin> cart_list = shopCartService.getAllCartByUid(userId);
        model.addAttribute("cart_list",cart_list);
        return "shop_car";
    }

    @GetMapping("/goto_cart")
    public String gotoCar(Model model,HttpSession session){
        //得到用户id
        String username = (String) session.getAttribute("username");
        UserEntity user = userService.getUserByname(username);
        Integer userId = user.getUserId();
        //根据用户id查询购物车
        List<shopcart_shangpin> cart_list = shopCartService.getAllCartByUid(userId);
        model.addAttribute("cart_list",cart_list);
        return "shop_car";
    }
}
