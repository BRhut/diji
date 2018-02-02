package fr.ca.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class FilePrinter extends Printer {
	
	private File file;
	private Collection<String> lines;
	
	public FilePrinter(PrintAPI printAPI, File file) {
		super(printAPI);
		this.file = file;
	}

	@Override
	public void print() throws Exception {
		LOGGER.info("Print job starting");
		
		this.lines = new ArrayList<>();
		
		printAPI.print(this);
		
		FileUtils.writeLines(file, lines);
		
		LOGGER.info("Invoice saved under {}", file.getAbsolutePath());
	}

	@Override
	protected void printLine(String line) throws IOException {
		lines.add(line);
	}
}
