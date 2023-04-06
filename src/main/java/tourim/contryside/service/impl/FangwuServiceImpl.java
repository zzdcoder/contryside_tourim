package tourim.contryside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tourim.contryside.pojo.FangwuEntity;
import tourim.contryside.mappers.Fangwumappers;
import tourim.contryside.service.FangwuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Service
public class FangwuServiceImpl extends ServiceImpl<Fangwumappers, FangwuEntity> implements FangwuService {
   @Autowired
   private Fangwumappers fangwumappers;
    @Override
    public FangwuEntity getFangwuImgById(Integer fw_id) {
        FangwuEntity fangwuImgById = fangwumappers.getFangwuImgById(fw_id);
        return fangwuImgById;
    }

    @Override
    public FangwuEntity getFangWuHuodongById(Integer fw_id) {
        FangwuEntity fangWuHuodongById = fangwumappers.getFangWuHuodongById(fw_id);
        return fangWuHuodongById;
    }
}
