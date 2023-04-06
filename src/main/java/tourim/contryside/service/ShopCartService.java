package tourim.contryside.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import tourim.contryside.pojo.ShopCartEntity;
import tourim.contryside.vo.shopcart_shangpin;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-26
 */
public interface ShopCartService extends IService<ShopCartEntity> {
    ShopCartEntity getShopByUidAndSpid(@Param("uid") Integer uid, @Param("spid") Integer spid);
    void updateCartByUidAndSpid(ShopCartEntity shopCartEntity);
    int deleteOneByspid(Integer id);
    List<ShopCartEntity> getShopByUid(Integer uid);
    List<shopcart_shangpin> getAllCartByUid(Integer uid);
}
