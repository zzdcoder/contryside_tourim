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
 * @TableName comment
 */
@TableName(value ="comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer coId;

    /**
     * 
     */
    private Integer jdId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String coTime;

    /**
     * 
     */
    private String coContent;

    /**
     * 
     */
    private Integer coType;
    private Integer gId;
    private Integer fwId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}