package tourim.contryside.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourim.contryside.mappers.Addressmappers;
import tourim.contryside.pojo.AddressEntity;
import tourim.contryside.service.AddressService;

import java.util.List;

/**
 * @author zhouzunda
 * @date 2023年03月25日 14:45
 * @description
 */
@Service
public class AddressServiceImpI extends ServiceImpl<Addressmappers, AddressEntity> implements AddressService {
    @Autowired
    private Addressmappers addressmappers;
    @Override
    public List<AddressEntity> getTopFourAddress() {
        List<AddressEntity> topFourAddress = addressmappers.getTopFourAddress();
        return topFourAddress;
    }

    @Override
    public AddressEntity getAddressByName(String name) {
        AddressEntity addressByName = addressmappers.getAddressByName(name);
        return addressByName;
    }
}
