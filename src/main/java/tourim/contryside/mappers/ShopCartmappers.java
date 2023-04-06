package tourim.contryside.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import tourim.contryside.pojo.ShopCartEntity;
import tourim.contryside.vo.shopcart_shangpin;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-26
 */
public interface ShopCartmappers extends BaseMapper<ShopCartEntity> {
  ShopCartEntity getShopByUidAndSpid(@Param("uid") Integer uid, @Param("spid") Integer spid);
  void updateCartByUidAndSpid(ShopCartEntity shopCartEntity);
  int deleteOneByspid(Integer id);
  List<ShopCartEntity> getShopByUid(Integer uid);
 List<shopcart_shangpin> getAllCartByUid(Integer uid);
}
