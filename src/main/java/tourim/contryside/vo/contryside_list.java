package tourim.contryside.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import tourim.contryside.pojo.FangwuEntity;
import tourim.contryside.pojo.Fangwuimg;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zhouzunda
 * @date 2023年03月30日 14:05
 * @description
 */
public class contryside_list {
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
    private Integer hzTelephone;


    @TableField("hz_header")
    private Integer hzHeader;

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

    @TableId
    private Integer imgId;

    /**
     *
     */
    private Integer fangwuId;

    /**
     *
     */
    private String imgPath;

    @TableField(exist = false)
    private FangwuEntity fangwuEntity;

    /**
     * 房屋简介
     */
    @TableField("fw_intro")
    private String fwIntro;

    /**
     * 房屋价格
     */
    @TableField("fw_price")
    private Integer fwPrice;

    /**
     * 房屋地址
     */
    @TableField("fw_loction")
    private String fwLoction;

    /**
     * 房屋图片
     */
    @TableField("fw_pictureid")
    private String fwPictureId;

    /**
     * 发布时间
     */
    @TableField("publish_time")
    private LocalDate publishTime;

    @TableField(exist = false)
    private List<Fangwuimg> fangwuimgs;
}
