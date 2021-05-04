package com.hstc.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Page<T> {
	private int total;    // ������
	private int start;     // ��ǰҳ
	private int count;     // ÿҳ��
	private List<T> rows; // �����

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
		// ����������50�����ܹ���5�����ģ���ô����10ҳ
		if (0 == total % count)
			totalPage = total /count;
			// ����������51�����ܹ���5�����ģ���ô����11ҳ
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
		// ����������50�����ܹ���5�����ģ���ô���һҳ�Ŀ�ʼ����45
		if (0 == total % count)
			last = total - count;
			// ����������51�����ܹ���5�����ģ���ô���һҳ�Ŀ�ʼ����50
		else
			last = total - total % count;
		last = last<0?0:last;
		return last;
	}

}
