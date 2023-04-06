package tourim.contryside.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tourim.contryside.pojo.JingdianEntity;

/**
 * @author zhouzunda
 * @date 2023年03月23日 17:05
 * @description
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class JingDian_order_pay extends JingdianEntity {

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户电话号码
     */
    @TableField("user_telephone")
    private String userTelephone;

    /**
     * 用户密码
     */
    @TableField("`password`")
    private String password;

    /**
     * 用户头像
     */
    @TableField("user_header")
    private String userHeader;


    private static final long serialVersionUID = 1L;

    @TableId(value = "df_id", type = IdType.AUTO)
    private Integer dfId;

    @TableField("jd_id")
    private Integer jdId;

    @TableField("order_time")
    private String orderTime;

    @TableField("cont_phone")
    private String contPhone;

    @TableField("cont_name")
    private String contName;

    @TableField("total_price")
    private String totalPrice;

    @TableField("jd_num")
    private String jdNum;


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
