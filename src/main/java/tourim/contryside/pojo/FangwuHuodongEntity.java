package tourim.contryside.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouzunda
 * @since 2023-03-20
 */
@TableName("fangwu_huodong")
public class FangwuHuodongEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房屋id
     */
    @TableField("fw_id")
    private Integer fwId;

    /**
     * 户主id
     */
    @TableField("hd_id")
    private Integer hdId;

    public Integer getFwId() {
        return fwId;
    }

    public void setFwId(Integer fwId) {
        this.fwId = fwId;
    }

    public Integer getHdId() {
        return hdId;
    }

    public void setHdId(Integer hdId) {
        this.hdId = hdId;
    }

    @Override
    public String toString() {
        return "FangwuHuodongEntity{" +
            "fwId = " + fwId +
            ", hdId = " + hdId +
        "}";
    }
}
