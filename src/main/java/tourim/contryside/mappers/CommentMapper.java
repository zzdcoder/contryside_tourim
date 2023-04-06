package tourim.contryside.mappers;

import org.apache.ibatis.annotations.Param;
import tourim.contryside.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tourim.contryside.vo.User_Comment;

import java.util.List;

/**
 * @Entity tourim.contryside.pojo.Comment
 */
public interface CommentMapper extends BaseMapper<Comment> {
    List<User_Comment> getAllCommentByJdidAndType(@Param("jdid") Integer jdid, @Param("type") Integer typeid);
    List<User_Comment> getAllCommentByFidAndType(@Param("fid") Integer fid, @Param("type") Integer typeid);
    List<User_Comment> getAllCommentByGidAndType(@Param("gid") Integer gid, @Param("type") Integer typeid);
}




