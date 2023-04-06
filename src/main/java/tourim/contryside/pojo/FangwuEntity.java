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
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("fangwu")
public class FangwuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房屋id
     */
    @TableId(value = "fw_id", type = IdType.AUTO)
    private Integer fwId;

    /**
     * 户主id
     */
    @TableField("hz_id")
    private Integer hzId;

    /**
     * 房屋简介
     */
    @TableField("fw_intro")
    private String fwIntro;

    /**
     * 房屋价格
     */
    @TableField("fw_price")
    private Integer fwPrice;

    /**
     * 房屋地址
     */
    @TableField("fw_loction")
    private String fwLoction;

    /**
     * 发布时间
     */
    @TableField("publish_time")
    private String publishTime;

    @TableField(exist = false)
    private List<Fangwuimg> fangwuimgs;

    @TableField(exist = false)
    private List<HuodongEntity> huodongEntities;
}
