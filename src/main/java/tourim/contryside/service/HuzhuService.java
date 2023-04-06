package tourim.contryside.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tourim.contryside.pojo.HuzhuEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import tourim.contryside.vo.contryside_list;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface HuzhuService extends IService<HuzhuEntity> {
    Page<HuzhuEntity> getAllContrySide(Page<HuzhuEntity> page);
}
