package com.ancel.test.operating_environment;

import java.util.Arrays;
import java.util.Random;
/*
 * Random专门用于生成伪随机数
 */
public class RandomTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.nextBoolean());
		byte[] buffer = new byte[16];
		System.out.println(Arrays.toString(buffer));
		
		//生成1.0-1.0之间的伪随机double
		System.out.println(random.nextDouble());
		
		//生成一个处于long范围的伪随机数
		System.out.println(random.nextInt());
		
		//生成一个0-26之间的伪随机整数
		System.out.println(random.nextInt(26));
		
		//为了避免产生相同的数字序列，可使用系统时间
		Random r = new Random(System.currentTimeMillis());
		
	}
}
