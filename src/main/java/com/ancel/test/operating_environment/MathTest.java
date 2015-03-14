package com.ancel.test.operating_environment;

public class MathTest {
	public static void main(String[] args) {
		/*
		 * 取整运算
		 */
		//取整，返回小于目标数的最大整数（double）
		System.out.println(Math.floor(3.6));
		//取整，返回大于目标数的最大整数（double）
		System.out.println(Math.ceil(3.6));
		//四舍五入,返回整数
		System.out.println(Math.round(3.6));
		
		
		/*
		 * 乘方、开方、指数
		 */
		//平方根
		System.out.println(Math.sqrt(9));
		//e的n次幂
		System.out.println(Math.exp(5));
		//x的平方加y的平方，然后开根
		System.out.println(Math.hypot(4, 4));
		//取余
		System.out.println(Math.IEEEremainder(5, 2));
		//乘方
		System.out.println(Math.pow(2, 3));
		
		/*
		 * 绝对值
		 */
		System.out.println(Math.abs(-4.5));
		
		/*
		 * 大小运算
		 */
		//找出最大值
		System.out.println(Math.max(2.5, 6.3));
		//最小值
		System.out.println(Math.min(2.5, 3.6));
		//返回一个伪随机数，大于等于0，小于1
		System.out.println(Math.random());

		
	}
}
