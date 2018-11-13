package com.ajie.arithmetic;

/**
 * 二分插入排序
 * 
 * @author niezhenjie
 */
public class BinaryInsertSort {

	/**
	 * 升序
	 * 
	 * @param data
	 */
	public static void sortAsc(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int j, temp, left = 0, right, mid;
			temp = data[i];
			right = i - 1;
			while (left <= right) { // 二分查找插入的位置
				mid = (right + left) >> 1;
				if (data[mid] > temp) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			// 插入位置到temp的位置的元素全部需要向后移一位
			for (j = i - 1; j >= left; j--) {
				data[j + 1] = data[j];
			}
			// 将temp插入合适的位置
			data[left] = temp;
		}
	}

	public static void main(String[] args) {
		int data[] = { 2, 324, 0, 1, 53, 5311, 3401, 1234, 6, -7, 568, 7, 878, 657, 987, 556, 64,
				23 };
		sortAsc(data);
		int j = 0;
		for (int i : data) {
			System.out.print(i + "\t\t");
			if (j++ % 4 == 0) {
				System.out.println();
			}

		}
	}
}
