package tourim.contryside.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourim.contryside.mappers.ShopCartmappers;
import tourim.contryside.pojo.ShopCartEntity;
import tourim.contryside.service.ShopCartService;
import tourim.contryside.vo.shopcart_shangpin;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-26
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartmappers, ShopCartEntity> implements ShopCartService {

    @Autowired
    private ShopCartmappers shopCartmappers;
    @Override
    public ShopCartEntity getShopByUidAndSpid(Integer uid, Integer spid) {
        ShopCartEntity shopByUidAndSpid = shopCartmappers.getShopByUidAndSpid(uid, spid);
        return shopByUidAndSpid;
    }

    @Override
    public void updateCartByUidAndSpid(ShopCartEntity shopCartEntity) {
         shopCartmappers.updateCartByUidAndSpid(shopCartEntity);
    }

    @Override
    public int deleteOneByspid(Integer id) {
        int result = shopCartmappers.deleteOneByspid(id);
        return result;
    }

    @Override
    public List<ShopCartEntity> getShopByUid(Integer uid) {
        List<ShopCartEntity> shopByUid = shopCartmappers.getShopByUid(uid);
        return shopByUid;
    }

    @Override
    public List<shopcart_shangpin> getAllCartByUid(Integer uid) {
        List<shopcart_shangpin> allCartByUid = shopCartmappers.getAllCartByUid(uid);
        return allCartByUid;
    }
}
