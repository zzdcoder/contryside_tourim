package tourim.contryside.service;

import org.apache.ibatis.annotations.Param;
import tourim.contryside.pojo.DingdanJingdianEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface DingdanJingdianService extends IService<DingdanJingdianEntity> {
    int updateduplicateorder(DingdanJingdianEntity dingdanJingdianEntity);
    DingdanJingdianEntity getDingdanJingdianByJdid(Integer jdid);
}
