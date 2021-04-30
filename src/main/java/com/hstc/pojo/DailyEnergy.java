package com.hstc.pojo;

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
    private int user_id;  //用户id
    private Double needed; //每日所需能量
    private Double consume; //每日消耗能量
    private Double intake; //每日摄入能量
    private int steps;  //每日步数
    private Time time;  //时间
}
