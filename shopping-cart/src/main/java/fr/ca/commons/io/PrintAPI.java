package fr.ca.commons.io;

public abstract class PrintAPI {
	protected Printer printer;
	
	
	protected abstract void print(Printer printer)  throws Exception;
	
	protected void printLine(CharSequence line) throws Exception {
		this.printer.printLine(line.toString());
	}
}
