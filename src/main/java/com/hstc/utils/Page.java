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
	private int page;     // ��ǰҳ
	private int size;     // ÿҳ��
	private List<T> rows; // �����

}
