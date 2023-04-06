package tourim.contryside.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@TableName("shangpin")
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ShangpinEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "sp_id", type = IdType.AUTO)
    private Integer spId;

    /**
     * 商品名
     */
    @TableField("sp_name")
    private String spName;

    /**
     * 商品简介
     */
    @TableField("sp_intro")
    private String spIntro;

    /**
     * 商品价格
     */
    @TableField("sp_price")
    private Object spPrice;

    /**
     * 商品运费
     */
    @TableField("sp_freigh")
    private Object spFreigh;

    /**
     * 商品图片
     */
    @TableField("sp_picture")
    private String spPicture;



    /**
     * 商品类别
     */
    @TableField("sort_id")
    private String sortId;

    @TableField("sp_subname")
    private String spSubname;

    @TableField("reposi_num")
    private String reposiNum;
}
