package tourim.contryside.controller;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tourim.contryside.mappers.Jingdianmappers;
import tourim.contryside.pojo.JingdianEntity;
import tourim.contryside.service.CommentService;
import tourim.contryside.service.JingdianService;
import tourim.contryside.utils.ResultUtils;
import tourim.contryside.vo.User_Comment;

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
public class JingdianController {
   @Autowired
    private JingdianService jingdianService;
   @Autowired
    private ResultUtils resultUtils;
   @Autowired
   private CommentService commentService;
   @GetMapping("/tourim")
   public String getallsecnic(Model model,Integer pagenum){
        Page<JingdianEntity> jingdianEntityPage = new Page<>(pagenum,6);
        jingdianService.getallscenic(jingdianEntityPage);
          //hutool分页工具得到导航页数
       int[] navicatnums = PageUtil.rainbow(pagenum, (int) jingdianEntityPage.getPages(), 5);
       model.addAttribute("page",jingdianEntityPage);
       model.addAttribute("navicatnums", navicatnums);
         return "scenic_list";
   }
    @GetMapping("/senicdetail")
    public String getallsecnicdetail(@ModelAttribute("jingdian") JingdianEntity jingdianEntity,Model model){
        String jdName = jingdianEntity.getJdName();
        JingdianEntity jingDianByName = jingdianService.getJingDianByName(jdName);
        Integer jdId = jingDianByName.getJdId();
        //查询出所有评论
        List<User_Comment> comments = commentService.getAllCommentByJdidAndType(jdId, 2);
        model.addAttribute("comments",comments);
        return "scenic";
    }
    @GetMapping("/jingdian_order")
    public String gotoJingdianOrder(@ModelAttribute("jingdian") JingdianEntity jingdianEntity){
       return "submit_orders";
    }
}
