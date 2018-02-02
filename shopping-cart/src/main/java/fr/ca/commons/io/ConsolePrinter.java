package fr.ca.commons.io;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsolePrinter extends Printer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsolePrinter.class);
	
	public ConsolePrinter(PrintAPI printAPI) {
		super(printAPI);
	}

	@Override
	public void print() throws Exception {
		printAPI.print(this);
	}

	@Override
	protected void printLine(String line) throws IOException {
		LOGGER.info(line);
	}
}
