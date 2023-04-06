package tourim.contryside.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tourim.contryside.pojo.AddressEntity;

import java.util.List;

public interface Addressmappers extends BaseMapper<AddressEntity> {
    List<AddressEntity> getTopFourAddress();
    AddressEntity getAddressByName(String name);
}
