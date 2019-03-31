package com.sophos.poc.wsrestauditoriaapi.service;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.validation.Valid;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sophos.poc.wsrestauditoriaapi.model.Accion;
import com.sophos.poc.wsrestauditoriaapi.utils.DefaultProperties;


@Service
public class ActiveMqRestClientService {

	@Autowired
	private DefaultProperties dfp;

	private String queue, endPoint, user, pass = null;
	
	private static final Logger logger = LogManager.getLogger(ActiveMqRestClientService.class);
	@Async
	public void publishMessage(@Valid Accion request) throws JMSException {
		loadConfig();	
		Connection producerConnection = null;
		Session producerSession = null;
		MessageProducer producer = null;
		PooledConnectionFactory pooledConnectionFactory = null;
		try {
			String message = request.toString();

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(getEndPoint());
			connectionFactory.setUserName(getUser());
			connectionFactory.setPassword(getPass());
			pooledConnectionFactory = new PooledConnectionFactory();
			pooledConnectionFactory.setConnectionFactory(connectionFactory);
			pooledConnectionFactory.setMaxConnections(10);
			producerConnection = pooledConnectionFactory.createConnection();

			producerConnection.start();
			producerSession = producerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination producerDestination = producerSession.createQueue(getQueue());
			producer = producerSession.createProducer(producerDestination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			TextMessage producerMessage = producerSession.createTextMessage(message);
			producer.send(producerMessage);		
		} catch (JMSException jmsex) {
			logger.error("Error JMSException jmsex: ");
			throw jmsex;
		} catch (Exception ex) {
			logger.error("Error General Exception ex: ");
			throw ex;
		}finally {
			producer.close();
			producerSession.close();
			producerConnection.close();
			pooledConnectionFactory.stop();
		}		
	}

	

	private void loadConfig() {
		setQueue(dfp.getQueue());
		setEndPoint(dfp.getEndpoint());
		setUser(dfp.getUser());
		setPass(dfp.getPass());
	}
	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
