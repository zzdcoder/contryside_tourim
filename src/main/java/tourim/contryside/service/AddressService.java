package tourim.contryside.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tourim.contryside.pojo.AddressEntity;

import java.util.List;

public interface AddressService extends IService<AddressEntity> {
    List<AddressEntity> getTopFourAddress();
    AddressEntity getAddressByName(String name);
}
