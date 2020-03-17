/**
 * This abstract class is base class for all
 * messages that can be added to a MessageQueue. 
 */
package Recitation8;

import java.util.Date;

/**
 * This class represents a message that can
 * be enqueued in a MessageQueue.
 * 
 * @author phil
 * @since 2020-02-20
 */
public abstract class Message {
	/** The message ID for the next message */
	private static int nextMessageID = 0;
	
	/** The message ID for this message */
	private final int messageID;
	
	/**
	 * Create new instance of message
	 * from a subclass.
	 */
	protected Message() {
		messageID = ++nextMessageID;
	}
	
	/**
	 * Get ID for this message.
	 * 
	 * @return returns the internal message ID
	 */
	public int getMessageID() {
		return messageID;
	}
	
	/**
	 * Get a message specific name.
	 * 
	 * @return the message name
	 */
	abstract public String getName();

//	public Date getMessageDate() {
//
//	}
}
