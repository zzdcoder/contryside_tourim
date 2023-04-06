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
@TableName("user")
@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class UserEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    public Integer userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    public String userName;

    /**
     * 用户电话号码
     */
    @TableField("user_telephone")
    public String userTelephone;

    /**
     * 用户密码
     */
    @TableField("`password`")
    public String password;

    /**
     * 用户头像
     */
    @TableField("user_header")
    public String userHeader;

    @TableField("user_gender")
    public String userGender;
    @TableField("user_birthday")
    public String userBirthday;

    @TableField("user_idiograph")
    public String userIdiograph;

    @TableField("loc_city")
    public String locCity;

}
