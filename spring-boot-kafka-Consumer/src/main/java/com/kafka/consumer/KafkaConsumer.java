package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.bean.Message;

@Service
public class KafkaConsumer {
	
//For String Message	
//	
//	@KafkaListener(topics = "testMessage", groupId = "demoClient"  )
//    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
//        System.out.println("Received message is: " + cr.toString());
//        
//    }

	
	
	
	
//	@KafkaListener(topics = "messageTopic", groupId = "demoClient"  )
//    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
//        System.out.println("Received message is: " + cr.toString());
//        
//    }
	
	
	@KafkaListener(
			  topics = "messageTopic", 
			  containerFactory = "kafkaListenerContainerFactory")
			public void listen(Message message) {
					System.out.println("Received message is: " + message.getMessage() + " : " + message.getId());
			}
	
}
