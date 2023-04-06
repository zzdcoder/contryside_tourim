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
@TableName("dingdan_jingdian")
public class DingdanJingdianEntity implements Serializable {

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
     * 景点id
     */
    @TableField("jd_id")
    private Integer jdId;

    /**
     * 下单时间
     */
    @TableField("order_time")
    private String orderTime;

    @TableField("cont_phone")
    private String contactPhone;

    @TableField("cont_name")
    private String contacName;
    @TableField("total_price")
    private String totalPrice;

    @TableField("jd_num")
    private String jdNum;
}
