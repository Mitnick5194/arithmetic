package com.ajie.arithmetic;

/**
 * 希尔排序，实现：取得一个间隔gap（一般是length/2），将数据分成gap份，对n份进行插入排序<br>
 * gap=gap/2，进行第二次排序，当gap为1时，虽然整体还不是有序，但是基本上有序，在进行一次插入排序，<br>
 * 此时因为数据比较均匀，排序不会进行很多的移动和对比，所以可以很快的完成
 * 
 * 如：int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64}
 * gap=length/2=6，分组：<br>
 * {49,27}，{ 38 , 49}，{65 , 78}，{97 , 34}，{76 , 12}，{13 , 64}，第一次排序完：<br>
 * {27 , 38 , 65 , 34 , 12 , 13 , 49 , 49 , 78 , 97 , 76 , 64}
 * 
 * @author niezhenjie
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] data = { 49, 38, 55, 97, 76, 13, -27, 49, 78, 34, 12, 64, -13, 0, 4321, -3124, 1 };
		sortAsc(data);
		for (int a : data) {
			System.out.println(a);
		}
	}

	static public void sortAsc(int[] data) {
		if (null == data || data.length <= 1) {
			return;
		}
		int gap = data.length;
		while (true) {
			gap >>= 1;
			for (int i = 0; i < gap; i++) { // 分成gap份
				for (int j = i + gap; j < data.length; j += gap) { // 对每一份进行插入排序
					int temp = data[j];
					int k;
					for (k = j - gap; k >= 0; k -= gap) { // 插入排序
						if (data[k] > temp) {
							data[k + gap] = data[k];
						} else {
							break;
						}
					}
					data[k + gap] = temp;
				}
			}
			if (gap == 1) {
				break;
			}
		}
	}
}
