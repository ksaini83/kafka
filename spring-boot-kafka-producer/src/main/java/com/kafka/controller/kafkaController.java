package com.kafka.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.bean.Message;
import com.kafka.producer.KafkaProducer;

@RestController
public class kafkaController {
	
	
	@Autowired
	KafkaProducer kafkaProducer;
	
	@RequestMapping(value = "/sendMessage")
	public String sendMessage(@RequestParam("message") String message, @RequestParam("id") String id) {
		
		Message msg = new Message();
		msg.setId(id);
		msg.setMessage(message);
		msg.setDate(new Date());
		
		System.out.println("Message to be sent ->" + id + ":" + msg.toString());
		kafkaProducer.send(msg);

		return "Successfully sent message to Kafka";
		
	}

}
