/**
 * This abstract class is base class for all
 * messages that can be added to a MessageQueue. 
 */
package Recitation10.message;

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
	
	/** The date of the message */
	private final Date messageDate;
	
	/**
	 * Create new instance of message
	 * from a subclass.
	 */
	protected Message() {
		messageID = ++nextMessageID;
		messageDate = new Date();
	}
	
	/**
	 * Get ID for this message.
	 * 
	 * @return message ID
	 */
	public int getMessageID() {
		return messageID;
	}
	
	/**
	 * Get date for this message.
	 * 
	 * @return copy of creation date
	 */
	public Date getMessageDate() {
		return (Date)messageDate.clone();
	}
	
	/**
	 * Returns name of message as string representation
	 * 
	 * @return name of message
	 */
	@Override
	public String toString() {
		return getName();
	}
	
	/**
	 * Get a message specific name.
	 * 
	 * @return the message name
	 */
	abstract public String getName();
	
	/** 
	 * Reset next messsage ID (TEST ONLY) 
	 */
	static void resetID() {
		nextMessageID = 0;
	}
}
