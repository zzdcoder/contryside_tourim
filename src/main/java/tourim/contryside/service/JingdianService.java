package tourim.contryside.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tourim.contryside.pojo.JingdianEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface JingdianService extends IService<JingdianEntity> {
    Page<JingdianEntity> getallscenic(Page<JingdianEntity> page);
    int updateByJingDianName(JingdianEntity jingdianEntity);
    JingdianEntity getJingDianByName(String name);
}
