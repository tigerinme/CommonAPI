package javaProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigUtil {
	private static final Pattern PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");

	private ConfigUtil() {
	}

	private static class SingletonHolder {
		private static final Properties prop = init();

		private static Properties init() {
			Properties prop = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream inStream = loader.getResourceAsStream("config.properties");
			try {
				prop.load(inStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		}
	}

	public static final Properties getProperties() {
		return SingletonHolder.prop;
	}

	public static String getProperty(String name) {
		String value = SingletonHolder.prop.getProperty(name);
		Matcher matcher = PATTERN.matcher(value);
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			String matcherKey = matcher.group(1);
			String matchervalue = SingletonHolder.prop.getProperty(matcherKey);
			if (matchervalue != null) {
				matcher.appendReplacement(buffer, matchervalue);
			}
		}
		matcher.appendTail(buffer);
		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(ConfigUtil.getProperty("current"));
		System.out.println(ConfigUtil.getProperty("Beat.backtest.url"));
	}
}
