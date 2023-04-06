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
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("huzhu")
public class HuzhuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 户主id
     */
    @TableId(value = "hz_id", type = IdType.AUTO)
    private Integer hzId;

    /**
     * 户主姓名
     */
    @TableField("hz_name")
    private String hzName;

    /**
     * 户主电话
     */
    @TableField("hz_telephone")
    private String hzTelephone;


    @TableField("hz_header")
    private String hzHeader;

    @TableField("hz_bannerimg")
    private String hzBannerimg;

    @TableField("hz_banner")
    private String hzBanner;


}
