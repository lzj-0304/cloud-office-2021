package com.lzj.cloud.office.mail;

import com.lzj.cloud.office.constants.MailConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 *
 * @author zhoubin
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class,args);
	}

	@Bean
	public Queue queue(){
		return new Queue(MailConstants.MAIL_QUEUE_NAME);
	}

}