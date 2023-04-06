package tourim.contryside.mappers;

import org.apache.ibatis.annotations.Param;
import tourim.contryside.pojo.DingdanJingdianEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.lang.model.element.VariableElement;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface DingdanJingdianmappers extends BaseMapper<DingdanJingdianEntity> {
    int updateduplicateorder(DingdanJingdianEntity dingdanJingdianEntity);
     DingdanJingdianEntity getDingdanJingdianByJdid(Integer jdid);
}
