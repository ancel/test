package com.ancel.test.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Matrix {
	public static final char[] ROWS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j' };
	public static final int[] COLUMNS = { 1, 2, 3, 4, 5, 6, 7, 8 };

	public static final String SPLIT_2 = ",";
	public static final String SPLIT_3 = "@";

	/**
	 * 生成矩阵卡
	 * 
	 * @param rows
	 * @param columns
	 * @return
	 */
	public static Map<String, String> createMatrix(char[] rows, int[] columns) {
		Map<String, String> map = new HashMap<String, String>();
		Random random = new Random();
		int[][] twoArray = new int[rows.length][columns.length];
		int m = 0;
		for (char row : rows) {

			for (int i : columns) {
				int val = 10 + random.nextInt(90);
				map.put(String.valueOf(row) + i, String.valueOf(val));
				twoArray[m][i - 1] = val;
			}
			m++;
		}
		return map;
	}

	/**
	 * 从map转换为二位数组
	 * 
	 * @param rows
	 * @param columns
	 * @param map
	 * @return
	 */
	public static String[][] getMatrixArray(char[] rows, int[] columns,
			Map<String, String> map) {
		String[][] twoArray = new String[rows.length][columns.length];
		int m = 0;
		for (char row : rows) {

			for (int i : columns) {
				twoArray[m][i - 1] = map.get(String.valueOf(row) + i);
			}
			m++;
		}
		return twoArray;
	}

	/**
	 * 将密保卡矩阵转换为字符串
	 * 
	 * @param rows
	 * @param columns
	 * @param map
	 * @return
	 */
	public static String getMatrixStr(char[] rows, int[] columns,
			Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		for (char row : rows) {
			for (int i : columns) {
				sb.append(map.get(String.valueOf(row) + i));
				sb.append(SPLIT_2);
			}
			sb.append(SPLIT_3);
		}

		sb.append("*");
		String str = sb.toString().replaceAll(SPLIT_2 + SPLIT_3, SPLIT_3);
		return str.replace(SPLIT_3 + "*", "");
	}

	public static void main(String[] args) {
		Set<Entry<String, String>> set = Matrix.createMatrix(ROWS, COLUMNS)
				.entrySet();
		for (Entry<String, String> entry : set) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		System.out.println(getMatrixStr(ROWS, COLUMNS, Matrix.createMatrix(ROWS, COLUMNS)));
	}
}