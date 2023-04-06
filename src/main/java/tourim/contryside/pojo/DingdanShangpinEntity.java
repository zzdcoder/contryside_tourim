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
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@TableName("dingdan_shangpin")
public class DingdanShangpinEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品订单id
     */
    @TableId(value = "ds_id", type = IdType.AUTO)
    private Integer dsId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 商品id
     */
    @TableField("sp_id")
    private Integer spId;

    /**
     * 下单时间
     */
    @TableField("order_time")
    private String orderTime;

    @TableField("sp_num")
    private Integer spNum;

    @TableField("sp_totalprice")
    private double spTotalprice;

    @TableField("ad_id")
    private Integer adId;
}
