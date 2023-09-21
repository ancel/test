package com.ancel.test.annotation.apt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

@SuppressWarnings("deprecation")
public class HibernateAnnotationProcessor implements AnnotationProcessor{

	//annotation处理环境，是该处理器与apt交互的重要途径
	private AnnotationProcessorEnvironment env;
	
	public HibernateAnnotationProcessor(AnnotationProcessorEnvironment env) {
		super();
		this.env = env;
	}

	/*
	 * 循环处理每个对象
	 * (non-Javadoc)
	 * @see com.sun.mirror.apt.AnnotationProcessor#process()
	 */
	@Override
	public void process() {
		// TODO Auto-generated method stub
		//遍历每个class对象
		for(TypeDeclaration t :env.getSpecifiedTypeDeclarations()){
			//输出额外文件
			FileOutputStream fos = null;
			PrintStream ps;
			//获取正在处理的类名
			String className = t.getSimpleName();
			//获取类定义前的persistent annotation
			Persistent per = t.getAnnotation(Persistent.class);
			if(per!=null){
				//创建文件输出流
				try {
					fos = new FileOutputStream("E:/"+className+".txt");
					ps = new PrintStream(fos);
					//执行输出
					ps.println("table="+per.table());
					for(FieldDeclaration f: t.getFields()){
						IdProperty id = f.getAnnotation(IdProperty.class);
						if(id!=null){
							ps.println("column="+id.column());
							ps.println("type="+id.type());
							ps.println("generator="+id.generator());
						}
						Property p = f.getAnnotation(Property.class);
						if(p!=null){
							ps.println("column="+id.column());
							ps.println("type="+id.type());
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(fos!=null){
						try {
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
		}
	}

}
