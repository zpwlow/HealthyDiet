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
	private int start;     // 当前页
	private int count;     // 每页数
	private List<T> rows; // 结果集

	public boolean isHasPreviouse(){
		if(start==0)
			return false;
		return true;
	}
	public boolean isHasNext(){
		if(start==getLast())
			return false;
		return true;
	}

	public int getTotalPage(){
		int totalPage;
		// 假设总数是50，是能够被5整除的，那么就有10页
		if (0 == total % count)
			totalPage = total /count;
			// 假设总数是51，不能够被5整除的，那么就有11页
		else
			totalPage = total / count + 1;

		if(0==totalPage)
			totalPage = 1;
		return totalPage;

	}

	public int getIndex(){
		int index ;
		index = start-4>0?start-4:0;
		return index;
	}

	public int getEnd(){
		int end;
		end = start-4>0?5:9-start;
		return end;
	}

	public int getLast(){
		int last;
		// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if (0 == total % count)
			last = total - count;
			// 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
		else
			last = total - total % count;
		last = last<0?0:last;
		return last;
	}

}
