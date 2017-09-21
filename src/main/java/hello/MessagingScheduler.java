
package hello;

import java.util.Date;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.converter.StringMessageConverter;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * 
 * 알림 스케줄러
 * 
 */

public class MessagingScheduler {

	private static final Logger logger = LoggerFactory.getLogger(MessagingScheduler.class);

	private SimpMessagingTemplate messagingTemplate;

	@Autowired

	public void setMessagingTemplate(SimpMessagingTemplate messagingTemplate) {

		this.messagingTemplate = messagingTemplate;

	}

	/**
	 * 
	 * minute, hour, day of month, month and day of week. e.g. "0 * * * *
	 * MON-FRI"
	 * 
	 */

	@Scheduled(cron = "*/5 * * * * *") // 5초마다 수행하도록 설정

	public void checkNotice() {

		logger.info("checkNotice call");

		try {

			messagingTemplate.setMessageConverter(new StringMessageConverter());

			messagingTemplate.convertAndSend("/topic/notice", new Date().toString() + " : 이것은 서버 메시지이빈다.");

		} catch (Exception ex) {

			logger.error(ex.getMessage());

		}

	}

}
