package tourim.contryside.controller;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tourim.contryside.pojo.HuzhuEntity;
import tourim.contryside.service.HuzhuService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Controller
public class HuzhuController {
    @Autowired
    private HuzhuService huzhuService;
    @GetMapping("/contryside")
    public String gotoContryside(Model model,Integer pagenum){
        Page<HuzhuEntity> huzhuEntityPage = new Page<>(pagenum, 4);
        huzhuService.getAllContrySide(huzhuEntityPage);
        int[] navicator = PageUtil.rainbow(pagenum, (int) huzhuEntityPage.getPages(), 5);
       model.addAttribute("huzhuEntityPage",huzhuEntityPage);
       model.addAttribute("navicator",navicator);
       return "note_list";
    }
}
