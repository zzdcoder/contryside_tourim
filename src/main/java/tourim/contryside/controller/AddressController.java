package tourim.contryside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tourim.contryside.pojo.AddressEntity;
import tourim.contryside.pojo.UserEntity;
import tourim.contryside.service.AddressService;
import tourim.contryside.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhouzunda
 * @date 2023年03月25日 14:23
 * @description
 */
@Controller
@Transactional
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @PostMapping("/back_pay")
    public String saveAddress(@ModelAttribute AddressEntity addressEntity, HttpSession session, Model model){
        String username = (String)session.getAttribute("username");
        UserEntity user = userService.getUserByname(username);
        Integer userId = user.getUserId();
        addressEntity.setUserId(userId);
        addressService.save(addressEntity);
        List<AddressEntity> topFourAddress = addressService.getTopFourAddress();
        model.addAttribute("addressList",topFourAddress);
        Object spName = session.getAttribute("spName");
        Object orderTime = session.getAttribute("orderTime");
        Object spPicture = session.getAttribute("spPicture");
        Object price = session.getAttribute("price");
        Object spNum = session.getAttribute("spNum");
        Object totalPrice = session.getAttribute("totalPrice");
        model.addAttribute("spName",spName);
        model.addAttribute("orderTime",orderTime);
        model.addAttribute("spPicture",spPicture);
        model.addAttribute("price",price);
        model.addAttribute("spNum",spNum);
        model.addAttribute("totalPrice",totalPrice);
        return "confirm_order";
    }
    @GetMapping("/add_address")
    public String addAddress(HttpServletRequest request, HttpSession session){
            String spName = request.getParameter("spName");
            String orderTime = request.getParameter("orderTime");
            String spPicture = request.getParameter("spPicture");
            String price = request.getParameter("price");
            String spNum = request.getParameter("spNum");
            String totalPrice = request.getParameter("totalPrice");
           session.setAttribute("spName",spName);
           session.setAttribute("orderTime",orderTime);
           session.setAttribute("spPicture",spPicture);
           session.setAttribute("price",price);
           session.setAttribute("spNum",spNum);
           session.setAttribute("totalPrice",totalPrice);
           return "my_contact";
    }
}
