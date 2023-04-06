package tourim.contryside.mappers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tourim.contryside.pojo.HuzhuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tourim.contryside.vo.contryside_list;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface Huzhumappers extends BaseMapper<HuzhuEntity> {
    Page<HuzhuEntity> getAllContrySide(Page<HuzhuEntity> page);
}
