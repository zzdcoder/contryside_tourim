package tourim.contryside.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-26
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("shop_cart")
public class ShopCartEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
