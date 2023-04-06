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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("dingdan_fangwu")
public class DingdanFangwuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房屋订单id
     */
    @TableId(value = "df_id", type = IdType.AUTO)
    private Integer dfId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 房屋id
     */
    @TableField("fw_id")
    private Integer fwId;

    /**
     * 下单时间
     */
    @TableField("order_time")
    private String orderTime;

    @TableField("contact_name")
    private String contactName;

    @TableField("contact_phone")
    private String contactPhone;

    @TableField("month_num")
    private String monthNum;

    @TableField("total_price")
    private String totalPrice;


}
