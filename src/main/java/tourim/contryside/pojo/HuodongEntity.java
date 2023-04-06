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
@AllArgsConstructor
@ToString
@NoArgsConstructor
@TableName("huodong")
public class HuodongEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    @TableId(value = "hd_id", type = IdType.AUTO)
    private Integer hdId;

    /**
     * 活动简介
     */
    @TableField("hd_intro")
    private String hdIntro;

    /**
     * 活动图片
     */
    @TableField("hd_picture")
    private String hdPicture;

    @TableField("fw_id")
    private String fwId;
}
