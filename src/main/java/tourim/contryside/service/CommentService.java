package tourim.contryside.service;

import org.apache.ibatis.annotations.Param;
import tourim.contryside.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import tourim.contryside.vo.User_Comment;

import java.util.List;

/**
 *
 */
public interface CommentService extends IService<Comment> {
    List<User_Comment> getAllCommentByJdidAndType(@Param("jdid") Integer jdid, @Param("type") Integer typeid);
    List<User_Comment> getAllCommentByFidAndType(@Param("fid") Integer fid, @Param("type") Integer typeid);
    List<User_Comment> getAllCommentByGidAndType(@Param("gid") Integer gid, @Param("type") Integer typeid);
}
