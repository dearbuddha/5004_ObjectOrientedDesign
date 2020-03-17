/**
 * This class is a mail message that can be
 * added to a MessageQueue.
 */
package Recitation8;

/**
 * This class represents a main message to send.
 * 
 * @author phil
 * @since 2020-02-20
 */
public final class MailMessage extends Message {
	/** recipient of the message */
	final private String recipient;
	
	/** sender of the message */
	final private String sender;
	
	/** subject of message */
	final private String subject;
	
	/** body of message */
	final private String body;
	
	/**
	 * Create instance of mail message.
	 * 
	 * @param recipient the recipient
	 * @param sender the sender
	 * @param subject the subject
	 * @param body the body
	 */
	public MailMessage(String recipient, String sender, String subject, String body) {
		this.recipient = recipient;
		this.sender = sender;
		this.subject = subject;
		this.body = body;
	}
	
	/**
	 * Returns a mail message name using recipient:
	 * "Mail to: %s".
	 */
	@Override
	public String getName() {
		return "MailMessage(" + getMessageID() + ")";
	}
	
	/**
	 * Returns recipient of mail message
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	
	/**
	 * Returns sender of mail message
	 * @return the recipient
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * Returns subject of mail message
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Returns body of mail message
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
}
