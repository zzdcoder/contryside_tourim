package tourim.contryside.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author zhouzunda
 * @date 2023年03月31日 23:04
 * @description
 */
public class User_Comment {
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
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    public Integer coId;

    /**
     *
     */
    public Integer jdId;
    

    /**
     *
     */
    public String coTime;

    /**
     *
     */
    public String coContent;

    /**
     *
     */
    public Integer coType;
    public Integer gId;
    public Integer fwId;

}
