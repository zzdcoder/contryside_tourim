package tourim.contryside.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhouzunda
 * @date 2023年03月30日 15:10
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class shopcart_shangpin {

    @TableId(value = "cart_id", type = IdType.NONE)
    private Integer cartId;

    private Integer spId;

    @TableField("user_id")
    private Integer userId;

    @TableField("sp_num")
    private Integer spNum;

    @TableField("order_time")
    private String orderTime;

    @TableField("total_price")
    private Double totalPrice;

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
