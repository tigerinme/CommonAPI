package chapters.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {

	private static final Logger LOGGER = LoggerFactory.getLogger(Foo.class);

	public void doIt() {
		LOGGER.debug("do it");
	}

}
