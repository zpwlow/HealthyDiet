package com.hstc.pojo;

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
    Integer id;
    String user_id;
    String text;
}
