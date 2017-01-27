package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 
 * @author fsakiyama
 *
 */
public class MQListener implements MessageListener{
	
	private String consumerName;

	public MQListener(String consumerName) {
		this.consumerName = consumerName;
	}

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("@Message consumed from: " + consumerName + " : " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
