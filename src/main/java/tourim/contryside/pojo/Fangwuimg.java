package tourim.contryside.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @TableName fangwuimg
 */
@TableName(value ="fangwuimg")
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Fangwuimg implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer imgId;

    /**
     * 
     */
    private Integer fwId;

    /**
     * 
     */
    private String imgPath;

    @TableField(exist = false)
    private FangwuEntity fangwuEntity;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}