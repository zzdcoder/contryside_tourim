package tourim.contryside.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import tourim.contryside.pojo.HuzhuEntity;
import tourim.contryside.mappers.Huzhumappers;
import tourim.contryside.service.HuzhuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tourim.contryside.vo.contryside_list;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Service
public class HuzhuServiceImpl extends ServiceImpl<Huzhumappers, HuzhuEntity> implements HuzhuService {
    @Autowired
    private Huzhumappers huzhumappers;
    @Override
    public Page<HuzhuEntity> getAllContrySide(Page<HuzhuEntity> page) {
        Page<HuzhuEntity> allContrySide = huzhumappers.getAllContrySide(page);
        return allContrySide;
    }
}
