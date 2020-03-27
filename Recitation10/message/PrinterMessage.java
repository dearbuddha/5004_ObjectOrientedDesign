/**
 * This class is a printer message that can be
 * added to a MessageQueue.
 */
package message;

/**
 * This class represents content to print
 * to a printer.
 * 
 * @author phil
 * @since 2020-02-20
 */
public final class PrinterMessage extends Message {

	/** Name of printer */
	final private String printerName;
	
	/** Content to print */
	final private String content;
	
	/**
	 * Create print message to enqueue.
	 * 
	 * @param printerName name of printer
	 * @param content content to print
	 */
	public PrinterMessage(String printerName, String content) {
		this.printerName = printerName;
		this.content = content;
	}
	
	/**
	 * Returns a print message name using messageID:
	 * "PrintMessage(%d)".
	 */
	@Override
	public String getName() {
		return "PrinterMessage(" + getMessageID() + ")";
	}
	
	/**
	 * Get name of printer for this message.
	 * 
	 * @return name of printer for this message
	 */
	public String getPrinterName() {
		return printerName;
	}
	
	/**
	 * Get content to print.
	 * 
	 * @return content to print
	 */
	public String getContent() {
		return content;
	}

}
