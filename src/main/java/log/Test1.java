package log;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * In the absence of warnings or errors, if you still wish to inspect logback's
 * internal status, then you can instruct logback to print status data by
 * invoking the print() of the StatusPrinter class. The MyApp2 application shown
 * below is identical to MyApp1 except for the addition of two lines of code for
 * printing internal status data. 可以用此来查看logback的加载是否出错，以及在哪出错
 * 
 * @author beta
 *
 */
public class Test1 {
	public static void main(String[] args) {
		// assume SLF4J is bound to logback in the current environment
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		StatusPrinter.print(lc);
		// Alternatively, packaging data can be enabled/disabled programmatically by
		// invoking the setPackagingDataEnabled(boolean) method in LoggerContext,
		lc.setPackagingDataEnabled(true);
		StatusManager statusManager = lc.getStatusManager();
		OnConsoleStatusListener onConsoleListener = new OnConsoleStatusListener();
		statusManager.add(onConsoleListener);
		lc.stop();
	}
}
