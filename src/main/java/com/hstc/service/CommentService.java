package com.hstc.service;

import com.hstc.pojo.Comment;

public interface CommentService {
    //添加用户评论
    Integer addComment(Comment comment);
}
