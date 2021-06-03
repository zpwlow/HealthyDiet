package com.hstc.pojo;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zpwlow
 * @date 2021年06月01  22:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenId {
    @Expose
    private  String appId;
    @Expose
    private String secret;
    @Expose
    private String grant_type;
    @Expose
    private String js_code;
}
