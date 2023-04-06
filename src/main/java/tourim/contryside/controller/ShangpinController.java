package tourim.contryside.controller;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourim.contryside.pojo.Comment;
import tourim.contryside.pojo.ShangpinEntity;
import tourim.contryside.pojo.UserEntity;
import tourim.contryside.service.CommentService;
import tourim.contryside.service.ShangpinService;
import tourim.contryside.service.UserService;
import tourim.contryside.vo.User_Comment;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ShangpinController {
    @Autowired
    private ShangpinService shangpinService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @GetMapping("/foodshop")
    public String getAllGoods(Model model,Integer pagenum){
        Page<ShangpinEntity> shangpinEntityPage = new Page<>(pagenum,5);
        shangpinService.getAllgoods(shangpinEntityPage);
        int[] navicator = PageUtil.rainbow(pagenum, (int) shangpinEntityPage.getPages(), 5);
        model.addAttribute("goodspage", shangpinEntityPage);
        model.addAttribute("navicator", navicator);
        return "mall_list";
    }
    @GetMapping("/goods_detail")
    public String gotoGoodsDetails(@ModelAttribute("goods") ShangpinEntity goods,Model model){
        String spName = goods.getSpName();
        ShangpinEntity getshangpingbyname = shangpinService.getshangpingbyname(spName);
        Integer spId = getshangpingbyname.getSpId();
        List<User_Comment> allCommentByGidAndType = commentService.getAllCommentByGidAndType(spId, 4);
        model.addAttribute("comments",allCommentByGidAndType);
        return "project";
    }
    @PostMapping("/goods_savecom")
    public String savecom(Model model, HttpSession session,String spName,String content){
        ShangpinEntity shangping = shangpinService.getshangpingbyname(spName);
        Integer spId = shangping.getSpId();
        //获取用户id
        String username = (String) session.getAttribute("username");
        UserEntity user = userService.getUserByname(username);
        Integer userId = user.getUserId();

        //获取评论时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        String currentTime = simpleDateFormat.format(date);
        Comment comment = new Comment(null,null,userId,currentTime,content,4,spId,null);
        boolean save = commentService.save(comment);

        List<User_Comment> allCommentByGidAndType = commentService.getAllCommentByGidAndType(spId, 4);
        model.addAttribute("goods",shangping);
        model.addAttribute("comments",allCommentByGidAndType);
        return "project";
    }
}
