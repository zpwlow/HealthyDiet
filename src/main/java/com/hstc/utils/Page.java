package com.hstc.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Page<T> {
	private int total;    // 总条数
	private int page;     // 当前页
	private int size;     // 每页数
	private List<T> rows; // 结果集

}
