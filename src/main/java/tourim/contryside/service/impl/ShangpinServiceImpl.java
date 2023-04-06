package tourim.contryside.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import tourim.contryside.pojo.ShangpinEntity;
import tourim.contryside.mappers.Shangpinmappers;
import tourim.contryside.service.ShangpinService;
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
public class ShangpinServiceImpl extends ServiceImpl<Shangpinmappers, ShangpinEntity> implements ShangpinService {

    @Autowired
    private Shangpinmappers shangpinmappers;


    @Override
    public Page<ShangpinEntity> getAllgoods(Page<ShangpinEntity> page) {
        Page<ShangpinEntity> allgoods = shangpinmappers.getAllgoods(page);
        return allgoods;
    }

    @Override
    public ShangpinEntity getshangpingbyname(String name) {
        ShangpinEntity shangpinEntity = shangpinmappers.getshangpingbyname(name);
        return shangpinEntity;
    }

    @Override
    public void updateGoodsByname(String name, Integer num) {
        shangpinmappers.updateGoodsByname(name, num);
    }
}
