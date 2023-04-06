package tourim.contryside.service;

import tourim.contryside.pojo.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import tourim.contryside.utils.ResultUtils;
import tourim.contryside.vo.JingDian_order_pay;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface UserService extends IService<UserEntity> {
    ResultUtils getOneUserByPhone(String phone);
    UserEntity getUserByPhone(String phone);
    UserEntity getUserByname(String name);
    JingDian_order_pay getorderpay(Integer id);
}
