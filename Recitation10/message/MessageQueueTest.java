package Recitation10.message;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import Recitation10.demo.Queue;
import Recitation10.demo.ArrayQueue;

import java.util.Date;

/**
 * Tests the Queue<Message> and Message class implementations using JUNIT.
 */
public final class MessageQueueTest {

	/**
	 * This class represents an unknown class type
	 * @author phil
	 * @since 2020-02-20
	 */
	private class UnknownMessage extends Message {

		/**
		 * Returns a unknown message name using messageID:
		 * "PrintMessage(%d)".
		 */
		@Override
		public String getName() {
			return "UnknownMessage(" + getMessageID() + ")";
		}
	}
	
	/** Reset next message ID before each test */
	@Before
	public void beforeTest() {
		Message.resetID();
	}
	
	/** Test base Message using unknown message subclass */
	@SuppressWarnings("deprecation")
	@Test
	public void testMessage() {
		Message m = new UnknownMessage();
		assertEquals("messageID", 1, m.getMessageID());
		assertEquals("name", "UnknownMessage(1)", m.getName());
		assertEquals("toString", "UnknownMessage(1)", m.toString());
		
		// make sure data matches current date (using deprecated date functions)
		Date date = m.getMessageDate();
		assertEquals("date.year", new Date().getYear(), date.getYear());
		assertEquals("date.month", new Date().getMonth(), date.getMonth());
		assertEquals("date.day", new Date().getDay(), date.getDay());
		
		// make sure getMessageDate() returns copy
		// (using deprecated Date.getYear(), Date.setYear())
		date.setYear(date.getYear()+1); // changes date returned next time?
		date = m.getMessageDate();
		assertEquals("date", new Date().getYear(), date.getYear());

		// make sure messageID increments
		m = new UnknownMessage();
		assertEquals("messageID", 2, m.getMessageID());

		
	}
	
	/** Test MailMessage class */
	@Test
	public void testMailMessage() {
		MailMessage m = new MailMessage("joe@dokes.com", "bob@dobbs.com", "meeting", "Please attend a meeting.");
		assertEquals("recipient", "joe@dokes.com", m.getRecipient());
		assertEquals("sender", "bob@dobbs.com", m.getSender());
		assertEquals("subject", "meeting", m.getSubject());
		assertEquals("body", "Please attend a meeting.", m.getBody());
		assertEquals("name", "MailMessage(1)", m.getName());
	}
	
	/** Test InstantMessage class */
	@Test
	public void testInstantMessage() {
		InstantMessage m =	new InstantMessage("14085551212", "16505551212", "hello!");
		assertEquals("recipient", "14085551212", m.getRecipient());
		assertEquals("sender", "16505551212", m.getSender());
		assertEquals("body", "hello!", m.getText());
		assertEquals("name", "InstantMessage(1)", m.getName());
	}
	
	/** Test PrinterMessage class */
	@Test
	public void testPrinterMessage() {
		PrinterMessage m =	new PrinterMessage("hpcolorjet-lobby", "This is a color document.");
		assertEquals("printerName", "hpcolorjet-lobby", m.getPrinterName());
		assertEquals("content", "This is a color document.", m.getContent());
		assertEquals("name", "PrinterMessage(1)", m.getName());
	}
	
	/** Test ArrayQueue<Message> class */
    @Test
    public void testMessageSingleQueueAsMessageQueue() {

        // creating the queue with the size 3.
        Queue<Message> queue = new ArrayQueue<Message>(3);

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isFull function should return false.
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size and capacity of the queue should return 0 and 5 respectively.
        assertEquals("Size of the queue", 0, queue.size());
        assertEquals("Capacity of the queue", 3, queue.capacity());
        
        // queue has no first element
        assertNull("peek", queue.peek());
        
        // string representation with capacity 3, size 0
        String testval = "[capacity: 3, size: 0, values: []]";
        assertEquals("to string", testval, queue.toString());
        
        // test values
        Message[] val = new Message[] {
        	new MailMessage("joe@dokes.com", "bob@dobbs.com", "meeting", "Please attend a meeting."),
        	new PrinterMessage("hpcolorjet-lobby", "This is a color document."),
        	new InstantMessage("14085551212", "16505551212", "hello!"),
        	new UnknownMessage()
        };

        // insert 5 elements into the queue.
        queue.enqueue(val[0]);
        queue.enqueue(val[1]);
        queue.enqueue(val[2]);
        
        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isFull function should return true, as 5 elements are entered.
        assertTrue("Is Queue Full", (queue.isFull()));

        // Size function should return 3.
        assertEquals("Size of the queue", 3, queue.size());

        // make sure capacity has not changed
        assertEquals("Capacity of the queue", 3, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", val[0], queue.peek());
        
        // string representation with capacity 3, size 3
        testval = "[capacity: 3, size: 3, values: [MailMessage(1), PrinterMessage(2), InstantMessage(3)]]";
        assertEquals("to string", testval, queue.toString());
        
        // test copy constructor and equals methods
        Queue<Message> queue2 = new ArrayQueue<Message>((ArrayQueue<Message>)queue);
        assertEquals("equals", queue, queue2);

        // insert the 4th element.
        // resize would happen to the queue at this point.
        queue.enqueue(val[3]);

        // queue and copy no longer equal
        assertNotEquals("equals", queue, queue2);

        // isEmpty function should return false
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size of the queue return 4.
        assertEquals("Size of the queue", 4, queue.size());

        // capacity of the queue should return 6.
        assertEquals("Capacity of the queue", 6, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", val[0], queue.peek());
        
        // string representation with capacity 6, size 4
        testval = "[capacity: 6, size: 4, values: [MailMessage(1), PrinterMessage(2), InstantMessage(3), UnknownMessage(4)]]";
        assertEquals("to string", testval, queue.toString());

        // Dequeue all the items in the queue and check the character values.
        Message m = queue.dequeue();
        assertEquals("Dequeue item", val[0], m);
        assertTrue(m instanceof MailMessage);
        m = queue.dequeue();
        assertEquals("Dequeue item", val[1], m);
        assertTrue(m instanceof PrinterMessage);
        m = queue.dequeue();
        assertEquals("Dequeue item", val[2], m);
        assertTrue(m instanceof InstantMessage);
        m = queue.dequeue();
        assertEquals("Dequeue item", val[3], m);
        assertTrue(m instanceof UnknownMessage);

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size of the queue should return zero.
        assertEquals("Size of the queue", 0, queue.size());

        // queue has no first element
        assertNull("peek", queue.peek());
        
        
        // If another element is dequeued, null character should be returned.
        assertNull("Dequeue item", queue.dequeue());
    }
    
	/** Test ArrayQueue<Message> class */
    @Test
    public void testMessageMultiQueueAsMessageQueue() {

        // creating the queue with the size 3.
        Queue<Message> queue = new MessageMultiQueue(3);

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isFull function should return false.
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size and capacity of the queue should return 0 and 5 respectively.
        assertEquals("Size of the queue", 0, queue.size());
        assertEquals("Capacity of the queue", 3, queue.capacity());
        
        // queue has no first element
        assertNull("peek", queue.peek());
        
        // string representation with capacity 3, size 0
        String testval = "[[capacity: 3, size: 0, values: []]]";
        assertEquals("to string", testval, queue.toString());
        
        // test values
        Message[] val = new Message[] {
        	new MailMessage("joe@dokes.com", "bob@dobbs.com", "meeting", "Please attend a meeting."),
        	new PrinterMessage("hpcolorjet-lobby", "This is a color document."),
        	new InstantMessage("14085551212", "16505551212", "hello!"),
        	new UnknownMessage()
        };

        // insert 5 elements into the queue.
        queue.enqueue(val[0]);
        queue.enqueue(val[1]);
        queue.enqueue(val[2]);
        
        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isFull function should return true, as 5 elements are entered.
        assertTrue("Is Queue Full", (queue.isFull()));

        // Size function should return 3.
        assertEquals("Size of the queue", 3, queue.size());

        // make sure capacity has not changed
        assertEquals("Capacity of the queue", 3, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", val[0], queue.peek());
        
        // string representation with capacity 3, size 3
        testval = "[[capacity: 3, size: 3, values: [MailMessage(1), PrinterMessage(2), InstantMessage(3)]]]";
        assertEquals("to string", testval, queue.toString());
        
        // test copy constructor and equals methods
        Queue<Message> queue2 = new MessageMultiQueue((MessageMultiQueue)queue);
        assertEquals("equals", queue, queue2);

        // insert the 4th element.
        // resize would happen to the queue at this point.
        queue.enqueue(val[3]);

        // queue and copy no longer equal
        assertNotEquals("equals", queue, queue2);

        // isEmpty function should return false
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size of the queue return 4.
        assertEquals("Size of the queue", 4, queue.size());

        // capacity of the queue should return 6.
        assertEquals("Capacity of the queue", 6, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", val[0], queue.peek());
        
        // string representation with capacity 6, size 4
        testval = "[[capacity: 6, size: 4, values: [MailMessage(1), PrinterMessage(2), InstantMessage(3), UnknownMessage(4)]]]";
        assertEquals("to string", testval, queue.toString());

        // Dequeue all the items in the queue and check the character values.
        Message m = queue.dequeue();
        assertEquals("Dequeue item", val[0], m);
        assertTrue(m instanceof MailMessage);
        m = queue.dequeue();
        assertEquals("Dequeue item", val[1], m);
        assertTrue(m instanceof PrinterMessage);
        m = queue.dequeue();
        assertEquals("Dequeue item", val[2], m);
        assertTrue(m instanceof InstantMessage);
        m = queue.dequeue();
        assertEquals("Dequeue item", val[3], m);
        assertTrue(m instanceof UnknownMessage);

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isFull function should return false
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size of the queue should return zero.
        assertEquals("Size of the queue", 0, queue.size());

        // queue has no first element
        assertNull("peek", queue.peek());
        
        
        // If another element is dequeued, null character should be returned.
        assertNull("Dequeue item", queue.dequeue());
    }
    
	/** Test ArrayQueue<Message> class */
    @Test
    public void testMessageMultiQueue() {
        // creating the queue with the size 3.
        MessageMultiQueue queue = new MessageMultiQueue(1,3);

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isFull function should return false.
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size and capacity of the queue should return 0 and 5 respectively.
        assertEquals("Size of the queue", 0, queue.size());
        assertEquals("Capacity of the queue", 3, queue.capacity());
        
        // queue has no first element
        assertNull("peek", queue.peek());
        
        // string representation with capacity 3, size 0
        String testval = 
        		"[[capacity: 1, size: 0, values: []]"
        	   + "[capacity: 1, size: 0, values: []]"
        	   + "[capacity: 1, size: 0, values: []]]";
        assertEquals("to string", testval, queue.toString());
        
        // test values
        Message[] val = new Message[] {
        	new MailMessage("joe@dokes.com", "bob@dobbs.com", "meeting", "Please attend a meeting."),
        	new PrinterMessage("hpcolorjet-lobby", "This is a color document."),
        	new InstantMessage("14085551212", "16505551212", "hello!"),
        	new UnknownMessage()
        };

        // insert 5 elements into the queue.
        queue.enqueue(val[0], 0);
        queue.enqueue(val[1], 1);
        queue.enqueue(val[2], 2);
        
        // isEmpty function should return false, as 5 elements are entered.
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isFull function should return true, as 3 elements are entered.
        assertTrue("Is Queue Full", (queue.isFull()));

        // Size function should return 3.
        assertEquals("Size of the queue", 3, queue.size());

        // Size function for each priority should return 1.
        assertEquals("Size of the queue 0", 1, queue.size(0));
        assertEquals("Size of the queue 1", 1, queue.size(1));
        assertEquals("Size of the queue 2", 1, queue.size(2));

        // make sure capacity has not changed
        assertEquals("Capacity of the queue", 3, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", val[0], queue.peek());
        
        // string representation with capacity 3, size 3 
        testval = 
        		"[[capacity: 1, size: 1, values: [MailMessage(1)]]"
        	   + "[capacity: 1, size: 1, values: [PrinterMessage(2)]]"
        	   + "[capacity: 1, size: 1, values: [InstantMessage(3)]]]";
        assertEquals("to string", testval, queue.toString());
        
        // test copy constructor and equals methods
        Queue<Message> queue2 = new MessageMultiQueue(queue);
        assertEquals("equals", queue, queue2);

        // insert the 4th element.
        // resize would happen to the queue at this point.
        queue.enqueue(val[3], 0);

        // queue and copy no longer equal
        assertNotEquals("equals", queue, queue2);

        // isEmpty function should return false
        assertTrue("Is Queue Empty? ", !queue.isEmpty());

        // isFull function should return true, as 4 elements are entered.
        assertTrue("Is Queue Full", queue.isFull());

        // size of the queue return 4.
        assertEquals("Size of the queue", 4, queue.size());

        // capacity of the queue should return 4.
        assertEquals("Capacity of the queue", 4, queue.capacity());

        // queue has 'h' first element
        assertEquals("peek", val[0], queue.peek());
        
        // string representation with capacity 6, size 4
        testval = 
        		"[[capacity: 2, size: 2, values: [MailMessage(1), UnknownMessage(4)]]"
        	   + "[capacity: 1, size: 1, values: [PrinterMessage(2)]]"
        	   + "[capacity: 1, size: 1, values: [InstantMessage(3)]]]";
        assertEquals("to string", testval, queue.toString());

        // Dequeue all the items in the queue and check the character values.
        Message m = queue.dequeue();
        assertEquals("Dequeue item", val[0], m);
        assertTrue(m instanceof MailMessage);
        
        m = queue.dequeue();
        assertEquals("Dequeue item", val[3], m);
        assertTrue(m instanceof UnknownMessage);
        
        m = queue.dequeue();
        assertEquals("Dequeue item", val[1], m);
        assertTrue(m instanceof PrinterMessage);

        m = queue.dequeue();
        assertEquals("Dequeue item", val[2], m);
        assertTrue(m instanceof InstantMessage);

        // isEmpty function should return true
        assertTrue("Is Queue Empty? ", queue.isEmpty());

        // isEmpty function should return false
        assertTrue("Is Queue Full", (!queue.isFull()));

        // size of the queue should return zero.
        assertEquals("Size of the queue", 0, queue.size());

        // queue has no first element
        assertNull("peek", queue.peek());
        
        
        // If another element is dequeued, null character should be returned.
        assertNull("Dequeue item", queue.dequeue());
    }
    
}
