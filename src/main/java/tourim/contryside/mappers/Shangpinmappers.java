package tourim.contryside.mappers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tourim.contryside.pojo.ShangpinEntity;
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
public interface Shangpinmappers extends BaseMapper<ShangpinEntity> {
  /*
   *
   * @author zhouzunda
   * @date 2023/3/30 12:33
   * @param page
   * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<tourim.contryside.pojo.ShangpinEntity>
   * @description  商品分页
   **/
  Page<ShangpinEntity> getAllgoods(Page<ShangpinEntity> page);
  ShangpinEntity getshangpingbyname(String name);
  void updateGoodsByname(String name,Integer num);
}
