package tourim.contryside.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName comment_type
 */
@TableName(value ="comment_type")
@Data
public class CommentType implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer coId;

    /**
     * 
     */
    private String cpType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}