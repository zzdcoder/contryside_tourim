package tourim.contryside.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import tourim.contryside.pojo.*;
import tourim.contryside.service.*;
import tourim.contryside.vo.User_Comment;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhouzunda
 * @date 2023年03月31日 22:46
 * @description
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private JingdianService jingdianService;
    @Autowired
    private HuzhuService huzhuService;
    @Autowired
    private FangwuService fangwuService;
    @PostMapping("/savecomment")
    public String saveComment(Model model, String jdName,String content, HttpSession session){

        //获取用户id
        String username = (String) session.getAttribute("username");
        UserEntity user = userService.getUserByname(username);
        Integer userId = user.getUserId();

        //景点id
        JingdianEntity jingdian = jingdianService.getJingDianByName(jdName);
        Integer jdId = jingdian.getJdId();

        //获取评论时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        String currentTime = simpleDateFormat.format(date);

        Comment comment = new Comment(null,jdId,userId,currentTime,content,null,null,2);
        //将评论存入数据库
        boolean save = commentService.save(comment);

        //查询出所有评论
        List<User_Comment> comments = commentService.getAllCommentByJdidAndType(jdId, 2);
        model.addAttribute("comments",comments);
        model.addAttribute("jingdian",jingdian);
        return "scenic";
    }
    @PostMapping("/fangwu_savecomment")
    public String fangwuSaveComment(String hzName,Model model,String content, HttpSession session){
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

        //获取用户id
        String username = (String) session.getAttribute("username");
        UserEntity user = userService.getUserByname(username);
        Integer userId = user.getUserId();

        //获取评论时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        String currentTime = simpleDateFormat.format(date);

        Comment comment = new Comment(null,null,userId,currentTime,content,1,null,fwId);
        boolean save = commentService.save(comment);

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
