package tourim.contryside.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tourim.contryside.pojo.JingdianEntity;
import tourim.contryside.mappers.Jingdianmappers;
import tourim.contryside.service.JingdianService;
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
@Transactional
public class JingdianServiceImpl extends ServiceImpl<Jingdianmappers, JingdianEntity> implements JingdianService {
   @Autowired
   private Jingdianmappers jingdianmappers;

    @Override
    public Page<JingdianEntity> getallscenic(Page<JingdianEntity> page) {
        Page<JingdianEntity> getallscenic = jingdianmappers.getallscenic(page);
        return getallscenic;
    }

    @Override
    public int updateByJingDianName(JingdianEntity jingdianEntity) {
        int result = jingdianmappers.updateByJingDianName(jingdianEntity);
        return result;
    }

    @Override
    public JingdianEntity getJingDianByName(String name) {
        JingdianEntity jingdian = jingdianmappers.getJingDianByName(name);
        return jingdian;
    }
}
