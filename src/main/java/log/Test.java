package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private static final Logger LOG = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		LOG.debug("debug");
		LOG.info("info");
		LOG.error("error");
	}
}
