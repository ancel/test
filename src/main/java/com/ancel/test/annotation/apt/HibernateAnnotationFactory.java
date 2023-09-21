package com.ancel.test.annotation.apt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

@SuppressWarnings("deprecation")
public class HibernateAnnotationFactory implements AnnotationProcessorFactory{

	
	@Override
	public AnnotationProcessor getProcessorFor(
			Set<AnnotationTypeDeclaration> arg0,
			AnnotationProcessorEnvironment arg1) {
		// TODO Auto-generated method stub
		return new HibernateAnnotationProcessor(arg1);
	}

	/*
	 * 所有支持的注释类型
	 * (non-Javadoc)
	 * @see com.sun.mirror.apt.AnnotationProcessorFactory#supportedAnnotationTypes()
	 */
	@Override
	public Collection<String> supportedAnnotationTypes() {
		// TODO Auto-generated method stub
		return Arrays.asList("Persistent","IdProperty","Property");
	}

	/*
	 * 所有支持的选项
	 * (non-Javadoc)
	 * @see com.sun.mirror.apt.AnnotationProcessorFactory#supportedOptions()
	 */
	@Override
	public Collection<String> supportedOptions() {
		// TODO Auto-generated method stub
		return Arrays.asList(new String[0]);
	}

}
