/**
 * This class is a mail message that can be
 * added to a MessageQueue.
 */
package Recitation9;

/**
 * This class represents an instant message to send.
 * 
 * @author phil
 * @since 2020-02-20
 */
public final class InstantMessage extends Message {
	/** recipient of the message */
	final private String recipient;
	
	/** sender of the message */
	final private String sender;
	
	/** text string of message */
	final private String text;
	
	
	/**
	 * Create instance of instant message.
	 * 
	 * @param recipient the recipient phone no.
	 * @param sender the sender phone no.
	 * @param text the text
	 */
	public InstantMessage(String recipient, String sender, String text) {
		this.recipient = recipient;
		this.sender = sender;
		this.text = text;
	}
	
	/**
	 * Returns a instance message name :
	 * "InstantMessage(%d)".
	 */
	@Override
	public String getName() {
		return "InstantMessage(" + getMessageID() + ")";
	}
	
	/**
	 * Returns recipient phone no. of instant message
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	
	/**
	 * Returns sender phone no. of instant message
	 * @return the recipient
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * Returns text of instant message
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
}
