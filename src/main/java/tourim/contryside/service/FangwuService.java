package tourim.contryside.service;

import tourim.contryside.pojo.FangwuEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
public interface FangwuService extends IService<FangwuEntity> {
    FangwuEntity getFangwuImgById(Integer fw_id);
    FangwuEntity getFangWuHuodongById(Integer fw_id);
}
