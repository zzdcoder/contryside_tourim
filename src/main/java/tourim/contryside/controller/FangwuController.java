package tourim.contryside.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tourim.contryside.pojo.FangwuEntity;
import tourim.contryside.pojo.HuzhuEntity;
import tourim.contryside.service.CommentService;
import tourim.contryside.service.FangwuService;
import tourim.contryside.service.HuzhuService;
import tourim.contryside.vo.User_Comment;

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
public class FangwuController {
    @Autowired
    private HuzhuService huzhuService;
    @Autowired
    private FangwuService fangwuService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/gotoexperence")
   public String gotoexperence(String hzName, Model model, HttpSession session){
        //根据条件构造器得到户主id
        LambdaQueryWrapper<HuzhuEntity> huzhuEntityQueryWrapper = new LambdaQueryWrapper<>();
        huzhuEntityQueryWrapper.eq(HuzhuEntity::getHzName,hzName);
        HuzhuEntity huzhuEntity = huzhuService.getOne(huzhuEntityQueryWrapper);
        Integer hzId = huzhuEntity.getHzId();
        //根据户主id查到房子
        LambdaQueryWrapper<FangwuEntity> fangwuEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        fangwuEntityLambdaQueryWrapper.eq(FangwuEntity::getHzId,hzId);
        FangwuEntity fangwuEntity = fangwuService.getOne(fangwuEntityLambdaQueryWrapper);
        //房屋id
        Integer fwId = fangwuEntity.getFwId();
        //根据房屋id查询房屋图片
        FangwuEntity fangwu = fangwuService.getFangwuImgById(fwId);
        //根据房屋id查询房屋活动
        FangwuEntity fangwuHuodong = fangwuService.getFangWuHuodongById(fwId);

        //查询出当前房屋的评论
        List<User_Comment> allCommentByFidAndType = commentService.getAllCommentByFidAndType(fwId, 1);
        model.addAttribute("comments", allCommentByFidAndType);
        model.addAttribute("fangwu",fangwu);
        model.addAttribute("huzhuEntity",huzhuEntity);
        model.addAttribute("fangwuHuodong",fangwuHuodong);
        session.setAttribute("huzhuEntity",huzhuEntity);
        session.setAttribute("comments",allCommentByFidAndType);
        session.setAttribute("fangwuimg",fangwu);
        session.setAttribute("fangwuHuodong",fangwuHuodong);
        return "note";
    }
}
