package com.hstc.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Page<T> {
	private int start;     //当前需要进行显示的页面
	private int count;     //每个页面显示的数据条数
	private int total;     //数据库中的条目总数，用于计算共有多少页
	private int totalPage; //通过total计算总页数
	private List<T> rows;  //数据列表

	public boolean isHasPreviouse(){
		if(start==0)
			return false;
		return true;
	}
	public boolean isHasNext(){
		if(start==totalPage-1)
			return false;
		return true;
	}

	public int getTotalPage(){
		if (0 == total % count)
			totalPage = total /count;
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
		if (0 == total % count)
			last = total - count;
		else
			last = total - total % count;
		last = last<0?0:last;
		return last;
	}

}
