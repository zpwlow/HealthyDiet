package com.hstc.dao;

import com.hstc.pojo.Comment;

public interface CommentMapper {
    //添加用户评论
    Integer addComment(Comment comment);
}
