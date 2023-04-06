package tourim.contryside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tourim.contryside.pojo.DingdanJingdianEntity;
import tourim.contryside.mappers.DingdanJingdianmappers;
import tourim.contryside.service.DingdanJingdianService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Service
public class DingdanJingdianServiceImpl extends ServiceImpl<DingdanJingdianmappers, DingdanJingdianEntity> implements DingdanJingdianService {
   @Autowired
   private DingdanJingdianmappers dingdanJingdianmappers;
    @Override
    public int updateduplicateorder(DingdanJingdianEntity dingdanJingdianEntity) {
        int result = dingdanJingdianmappers.updateduplicateorder(dingdanJingdianEntity);
        return result;
    }

    @Override
    public DingdanJingdianEntity getDingdanJingdianByJdid(Integer jdid) {
        DingdanJingdianEntity dingdanJingdian = dingdanJingdianmappers.getDingdanJingdianByJdid(jdid);
        return dingdanJingdian;
    }
}
