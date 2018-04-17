package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.bean.Message;

@Service
public class KafkaProducer {
	
	
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;
	
	@Value("${kafka.producer.topic}")
	String kafkaTopic;
	
	
	public void send(Message message) {
	    
	    kafkaTemplate.send(kafkaTopic, message);
	}

}
