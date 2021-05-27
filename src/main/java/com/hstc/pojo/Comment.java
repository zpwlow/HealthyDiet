package com.hstc.pojo;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zpwlow
 * @date 2021年05月26  21:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Expose
    int id;
    @Expose
    String user_id;
    @Expose
    String text;
}
