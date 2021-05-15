package com.hstc.pojo;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyEnergy {
    /*
    * 用户每日能量记录
    * */
    @Expose
    private String user_id;  //用户id
    @Expose
    private Double needed; //每日所需能量
    @Expose
    private Double consume; //每日消耗能量
    @Expose
    private Double intake; //每日摄入能量
    @Expose
    private int steps;  //每日步数
    @Expose
    private String time;  //时间

    public DailyEnergy(String user_id, String time) {
        this.user_id = user_id;
        this.time = time;
    }
}
