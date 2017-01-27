package jms;

import java.io.StringWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXB;

import domain.DataToBeSent;

public class MQProducer {

	public static void main(String[] args) throws NamingException, JMSException, InterruptedException {

		InitialContext context = new InitialContext();

		ConnectionFactory cf = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = cf.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = (Destination) context.lookup("queueForDataToBeSent");
		MessageProducer messageProducer = session.createProducer(destination);
		boolean i = true;
		
		while(i){
			DataToBeSent dataToBeSent = new DataToBeSent();
			dataToBeSent.defaultData();
			StringWriter writer = new StringWriter();
			JAXB.marshal(dataToBeSent, writer);
			Message message = session.createTextMessage(writer.toString());
			messageProducer.send(message);
			Thread.sleep(1000);
		}

		session.close();
		connection.close();
		context.close();
	}
}
