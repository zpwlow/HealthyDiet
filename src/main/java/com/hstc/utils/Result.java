package com.hstc.utils;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result{
    @Expose
    private int code;
    @Expose
    private String message;
    @Expose
    private Object data;

}
