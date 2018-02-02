package fr.ca.commons.io;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Printer {
	protected static final Logger LOGGER = LoggerFactory.getLogger(Printer.class);
	protected PrintAPI printAPI;
	
	
	
	public Printer(PrintAPI printAPI) {
		super();
		this.printAPI = printAPI;
		this.printAPI.printer = this;
	}



	public abstract void print() throws Exception;
	
	protected abstract void printLine(String line) throws IOException;
}
