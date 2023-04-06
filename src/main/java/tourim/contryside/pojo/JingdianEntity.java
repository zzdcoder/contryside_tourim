package tourim.contryside.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

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
@TableName("jingdian")
public class JingdianEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 景点id
     */
    @TableId(value = "jd_id", type = IdType.AUTO)
    private Integer jdId;

    @TableField("order_time")
    private String orderTime;

    @TableField("jd_price")
    private String jdPrice;
    /**
     * 景点名字
     */
    @TableField("jd_name")
    private String jdName;

    /**
     * 景点简介
     */
    @TableField("jd_intro")
    private String jdIntro;

    /**
     * 景点图片
     */
    @TableField("jd_picture")
    private String jdPicture;

    /**
     * 景点电话
     */
    @TableField("jd_telephone")
    private String jdTelephone;

    /**
     * 景点开放时段
     */
    @TableField("jd_time")
    private String jdTime;

    /**
     * 景点地址
     */
    @TableField("jd_location")
    private String jdLocation;

    @TableField("activites")
    private String activites;

    @TableField("advice_phone")
    private String advicePhone;

    @TableField("go_time")
    private String goTime;

    @TableField("assem_loc")
    private String assemLoc;
}
