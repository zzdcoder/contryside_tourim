package tourim.contryside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tourim.contryside.pojo.UserEntity;
import tourim.contryside.mappers.Usermappers;
import tourim.contryside.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tourim.contryside.utils.ResultUtils;
import tourim.contryside.vo.JingDian_order_pay;

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
@Transactional
public class UserServiceImpl extends ServiceImpl<Usermappers, UserEntity> implements UserService {
    @Autowired
    private Usermappers usermappers;
    @Autowired
    private ResultUtils resultUtils;
    @Override
    public ResultUtils getOneUserByPhone(String phone) {
            String password = usermappers.getOneUserByPhone(phone);
            if (password==null){
              resultUtils.setStatus(404);
              resultUtils.setData("用户不存在");
              return resultUtils;
             }
            resultUtils.setStatus(200);
            resultUtils.setData(password);
            return resultUtils;
        }

    @Override
    public UserEntity getUserByPhone(String phone) {
        UserEntity user = usermappers.getUserByPhone(phone);
        return user;
    }

    @Override
    public UserEntity getUserByname(String name) {
        UserEntity userByname = usermappers.getUserByname(name);
        return userByname;
    }

    @Override
    public JingDian_order_pay getorderpay(Integer id) {
        JingDian_order_pay jingDian_order_pays = usermappers.getorderpay(id);
        return jingDian_order_pays;
    }
}

