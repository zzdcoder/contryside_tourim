package tourim.contryside.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tourim.contryside.pojo.ShangpinEntity;
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
public interface ShangpinService extends IService<ShangpinEntity> {
    Page<ShangpinEntity> getAllgoods(Page<ShangpinEntity> page);
    ShangpinEntity getshangpingbyname(String name);
    void updateGoodsByname(String name,Integer num);
}
