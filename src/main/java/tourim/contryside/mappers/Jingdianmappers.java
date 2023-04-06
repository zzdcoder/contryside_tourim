package tourim.contryside.mappers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tourim.contryside.pojo.JingdianEntity;
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
public interface Jingdianmappers extends BaseMapper<JingdianEntity> {
   /*
    *
    * @author zhouzunda
    * @date 2023/3/29 22:11
    * @param page
    * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<tourim.contryside.pojo.JingdianEntity>
    * @description  不通过条件查询并分页
    **/
   Page<JingdianEntity> getallscenic(Page<JingdianEntity> page);

   int updateByJingDianName(JingdianEntity jingdianEntity);

   JingdianEntity getJingDianByName(String name);

}
