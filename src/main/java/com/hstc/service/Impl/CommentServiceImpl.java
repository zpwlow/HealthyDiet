package com.hstc.service.Impl;

import com.hstc.dao.CommentMapper;
import com.hstc.pojo.Comment;
import com.hstc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zpwlow
 * @date 2021年05月27  9:50
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Integer addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}
