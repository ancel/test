package com.ancel.test.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;


public class CompileClassLoader extends ClassLoader{
	//读取文件内容
	private byte[] getBytes(String fileName){
		File file = new File(fileName);
		long len = file.length();
		byte[] raw = new byte[(int)len];
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			int r = fis.read();
			if(r!=len){
				throw new IOException("无法读取全部文件："+r+"!="+len);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return raw;
	}
	/*
	 * 定义编译指定的java
	 */
	private boolean complite(String javaFile){
		System.out.println("compliteclassloader正在编译："+javaFile+"....");
		//调用系统的javac指令
		try {
			Process p = Runtime.getRuntime().exec("javac "+javaFile);
			//其他线程都等待这个线程完成
			p.waitFor();
			//获取javac线程的退出值
			int ret = p.exitValue();
			return ret == 0 ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class<?> clazz = null;
		//将包路径中的（.）替换成（/）
		String fileStub = name.replaceAll(".", "/");
		String javaFileName = fileStub + ".java";
		String classFileName = fileStub + ".class";
		File javaFile = new File(javaFileName);
		File classFile = new File(classFileName);
		//当指定java源文件存在，且class文件不存在或者
		//java源文件修改的时间比class文件修改的时间晚时，重新编译
		if (javaFile.exists()&&(!classFile.exists()||javaFile.lastModified()>classFile.lastModified())) {
			try {
				if (!complite(javaFileName)||!classFile.exists()) {
					throw new ClassNotFoundException("ClassNotFoundException:"+javaFileName);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//如果class文件存在，系统负责将该文件转换成class对象
		if (classFile.exists()) {
			try {
				//将class文件的二进制数据读入数组
				byte[] raw = getBytes(classFileName);
				//调用classloader的defineclass方法将二进制数据转换成class对象
				clazz  = defineClass(name, raw, 0, raw.length);
			} catch (ClassFormatError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//如果class为null，表明加载失败，则抛出异常
		if (clazz == null) {
			throw new ClassNotFoundException(name);
		}
		return super.findClass(name);
	}
	
	
	public static void main(String[] args) {
		//如果运行该程序时没有参数，即没有目标类
		if (args.length<1) {
			System.out.println("缺少运行的目标类，请按如下格式运行java源文件");
			System.out.println("java CompliteClassLoader ClassName");
		}
		//第一个参数是需要运行的类
		String progClass = args[0];
		//剩下的参数将作为运行目标类时的参数，所以讲这些参数复制到一个新数组中
		String[] progArgs =new String[args.length-1];
		System.arraycopy(args, 1, progArgs, 0, args.length);
		CompileClassLoader ccl = new CompileClassLoader();
		//加载需要运行的类
		try {
			Class<?> clazz = ccl.loadClass(progClass);
			//加载需要运行的类的主方法
			Method main = clazz.getMethod("main", (new String[0]).getClass());
			Object[] argsArray = {progArgs};
			main.invoke(null, argsArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
