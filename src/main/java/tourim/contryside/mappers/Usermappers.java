package tourim.contryside.mappers;

import org.springframework.stereotype.Repository;
import tourim.contryside.pojo.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tourim.contryside.vo.JingDian_order_pay;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface Usermappers extends BaseMapper<UserEntity> {
    /*
     *
     * @author zhouzunda
     * @date 2023/3/20 17:39
     * @param phone
     * @return tourim.contryside.pojo.UserEntity
     * @description   根据用户手机号查询单个字段
     **/
      String getOneUserByPhone(String phone);
      /*
       *
       * @author zhouzunda
       * @date 2023/3/22 8:39
       * @param phone
       * @return tourim.contryside.pojo.UserEntity
       * @description    根据用户手机号查询全部字段
       **/
      UserEntity getUserByPhone(String phone);
      UserEntity getUserByname(String name);
      /*
       *
       * @author zhouzunda
       * @date 2023/3/23 20:44
       * @return java.util.List<tourim.contryside.vo.JingDian_order_pay>
       * @description 三表连查根据当前的景点id
       **/
      JingDian_order_pay getorderpay(Integer id);
}
