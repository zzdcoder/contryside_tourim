package tourim.contryside.mappers;

import tourim.contryside.pojo.FangwuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface Fangwumappers extends BaseMapper<FangwuEntity> {
    FangwuEntity getFangwuImgById(Integer fw_id);
    FangwuEntity getFangWuHuodongById(Integer fw_id);
}
