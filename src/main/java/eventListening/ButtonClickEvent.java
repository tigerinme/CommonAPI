package eventListening;

import java.util.EventObject;

public class ButtonClickEvent extends EventObject {

	/**
	 * 字段：
	 */
	private static final long serialVersionUID = 1L;
	// 事件源
	private Object mSourceObject = null;
	private String mTag = "";

	/**
	 * 构造函数
	 * 
	 * @param sObject
	 */
	public ButtonClickEvent(Object sObject) {
		super(sObject);
		mSourceObject = sObject;
	}

	/**
	 * 构造函数
	 * 
	 * @param sObject
	 * @param tag
	 */
	public ButtonClickEvent(Object sObject, String tag) {
		super(sObject);
		mSourceObject = sObject;
		mTag = tag;
	}

	/**
	 * 获取事件源 (non-Javadoc)
	 * 
	 * @see java.util.EventObject#getSource()
	 */
	public Object getSource() {
		return mSourceObject;
	}

	/**
	 * 
	 * @Title: setSource @Description: 设置事件源 @param obj @return void @throws
	 */
	public void setSource(Object obj) {
		mSourceObject = obj;
	}

	/**
	 * 
	 * @Title: getTag @Description: 获得tag @return @return String @throws
	 */
	public String getTag() {
		return mTag;
	}

	/**
	 * 
	 * @Title: setTag @Description: 设置tag @param tag @return void @throws
	 */
	public void setTag(String tag) {
		mTag = tag;
	}
	
}
