package tourim.contryside.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import tourim.contryside.pojo.Comment;
import tourim.contryside.service.CommentService;
import tourim.contryside.mappers.CommentMapper;
import org.springframework.stereotype.Service;
import tourim.contryside.vo.User_Comment;

import java.util.List;

/**
 *
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{
   @Autowired
   private CommentMapper commentMapper;
    @Override
    public List<User_Comment> getAllCommentByJdidAndType(Integer jdid, Integer typeid) {
        List<User_Comment> allCommentByJdidAndType = commentMapper.getAllCommentByJdidAndType(jdid, typeid);
        return allCommentByJdidAndType;
    }

    @Override
    public List<User_Comment> getAllCommentByFidAndType(Integer fid, Integer typeid) {
        List<User_Comment> allCommentByFidAndType = commentMapper.getAllCommentByFidAndType(fid, typeid);
        return allCommentByFidAndType;
    }

    @Override
    public List<User_Comment> getAllCommentByGidAndType(Integer gid, Integer typeid) {
        List<User_Comment> allCommentByGidAndType = commentMapper.getAllCommentByGidAndType(gid, typeid);
        return allCommentByGidAndType;
    }
}




