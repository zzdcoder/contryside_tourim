package tourim.contryside.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author zhouzunda
 * @date 2023年03月24日 20:53
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@TableName("adress")
public class AddressEntity {
    @TableId(value = "ad_id",type = IdType.AUTO)
    private Integer adId;
    @TableField("user_id")
    private Integer userId;
    @TableField("addre")
    private String addre;
    @TableField("post_code")
    private String postCode;
    @TableField("phone_num")
    private String phoneNum;
    @TableField("got_name")
    private String gotName;

}
