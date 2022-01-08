package com.zhaokun;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class RabbittestApplicationTests {

	@Autowired
	AmqpAdmin amqpAdmin;
	@Autowired
	RabbitTemplate rabbitTemplate;

	String exchangeName = "hello-java-exchange";
	String queueName = "hello-java-queue";
	String routeKey = "hello.java";
	@Test
	void testCreateExchange() {
		/**
		 * DirectExchange(String name, boolean durable,
		 * boolean autoDelete, Map<String, Object> arguments)
		 */
		DirectExchange directExchange = new DirectExchange(exchangeName, true, false);
		amqpAdmin.declareExchange(directExchange);
		log.info("创建交换机[{}] 成功", exchangeName);
	}

	@Test
	void testCreateQueue() {

		/**
		 * Queue(String name, boolean durable, boolean exclusive, boolean autoDelete,
		 *                        @Nullable Map<String, Object> arguments)
		 */
		Queue queue = new Queue(
				queueName,
				true,
				false,
				false, null);
		String s = amqpAdmin.declareQueue(queue);
		log.info("创建队列成功[{}] , 返回结果 = {}", queueName, s);
	}

	@Test
	void testBindQueue() {
		/**
		 * String destination, 目的地
		 * DestinationType destinationType 目的地类型,
		 * String exchange,交换机
		 * String routingKey, 绑定路由件
		 * @Nullable Map<String, Object> arguments) 传参
		 */
		Binding queue = new Binding(queueName,
				Binding.DestinationType.QUEUE,
				exchangeName,
				routeKey, null);

		amqpAdmin.declareBinding(queue);
		log.info("Binding[{}] 创建成功", "hello-binding");
	}

	@Test
	public void testPublishMessage() {
		String msg = "Hello World!";
		CorrelationData correlationData = new CorrelationData();
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu", msg, correlationData);
		log.info("消息发送成功{}", msg);
	}
}
