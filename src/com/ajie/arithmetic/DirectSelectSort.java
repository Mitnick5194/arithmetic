package com.ajie.arithmetic;

/**
 * 直接选择排序，基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；<br>
 * 然后在剩下的数当中再找最小的与第二个位置的数交换， 如此循环到倒数第二个数和最后一个数比较为止。
 * 
 * @author niezhenjie
 */
public class DirectSelectSort {

	public static void main(String[] args) {
		int[] data = { 49, 38, 55, 97, 76, 13, -27, 49, 78, 34, 12, 64, -13, 0, 4321, -3124, 1 };
		sort(data);
		for (int i : data) {
			System.out.println(i);
		}
	}

	public static void sort(int[] data) {
		if (null == data || data.length <= 1) {
			return;
		}
		for (int i = 0; i < data.length; i++) {
			int min = data[i];
			int idx = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < min) {
					min = data[j];
					idx = j;
				}
			}
			data[idx] = data[i];
			data[i] = min;
		}
	}
}
