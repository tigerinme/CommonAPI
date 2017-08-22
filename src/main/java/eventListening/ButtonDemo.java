package eventListening;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ButtonDemo {
	// item文本文字
	private String mItemName = "";
	// 监听器哈希集合,可以注册多个监听器
	private Set<EventListener> mClickListeners = null;

	/**
	 * 构造函数
	 * 
	 */
	public ButtonDemo() {
		// 监听器列表
		mClickListeners = new HashSet<EventListener>();
		mItemName = "Defualt Item Name";
	}

	/**
	 * 构造函数
	 * 
	 * @param itemString
	 */
	public ButtonDemo(String itemString) {
		mItemName = itemString;
		mClickListeners = new HashSet<EventListener>();
	}

	/**
	 * 
	 * @Title: AddItemClickListener @Description: 添加监听器 @param listener @return
	 *         void @throws
	 */
	public void AddItemClickListener(EventListener listener) {
		// 添加到监听器列表
		this.mClickListeners.add(listener);
	}

	/**
	 * 
	 * @Title: ItemClick @Description: 模拟点击事件,触发事件则通知所有监听器 @return void @throws
	 */
	public void ButtonClick() {
		// 通知所有监听者
		Notifies();
	}

	/**
	 * 
	 * @Title: Notifies @Description: 通知所有监听者 @return void @throws
	 */
	private void Notifies() {
		Iterator<EventListener> iterator = mClickListeners.iterator();
		while (iterator.hasNext()) {
			// 获取当前的对象
			ButtonClickListenerInner listener = (ButtonClickListenerInner) iterator.next();
			// 事件触发,事件的构造函数参数为事件源
			listener.ButtonClicked(new ButtonClickEvent(this));

		}
	}

	/**
	 * 
	 * @Title: getItemString @Description: 返回该项的名字 @return String @throws
	 */
	public String getItemString() {
		return mItemName;
	}

	private static class ButtonClickListenerInner implements EventListener {
		/**
		 * 
		 * @Title: ItemClicked @Description: 点击事件 @param event @return void @throws
		 */
		public void ButtonClicked(ButtonClickEvent event) {
			// 获取事件源
			ButtonDemo source = (ButtonDemo) event.getSource();
			System.out.println("内部静态监听类@_@ 你点击的是 : " + source.getItemString());
		}
	}

	/**
	 * 
	 * @Title: main @Description: main方法 @param args @return void @throws
	 */
	public static void main(String[] args) {
		ButtonDemo buttonDemo = new ButtonDemo("Hello, I am a ButtonDemo");
		// 添加监听器
		buttonDemo.AddItemClickListener(new ButtonClickListenerInner());
		// 事件触发
		buttonDemo.ButtonClick();
	}
}
