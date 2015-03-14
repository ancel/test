

import java.util.ListResourceBundle;

public class Class_en_US extends ListResourceBundle{
	/*
	 * 定义资源
	 * (non-Javadoc)
	 * @see java.util.ListResourceBundle#getContents()
	 */
	private final Object myDate[][] = {
			{"msg","{0},hello，today is {1}"}	
	};
	
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return myDate;
	}

}
