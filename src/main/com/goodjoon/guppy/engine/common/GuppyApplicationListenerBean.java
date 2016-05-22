package com.goodjoon.guppy.engine.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

// ContextStartedEvent 는 WAS 가 시작할 때 이벤트 오지 않는다. ContextRefreshedEvent 는 온다.
public class GuppyApplicationListenerBean implements ApplicationListener<ContextRefreshedEvent> {
	Logger logger = LoggerFactory.getLogger(GuppyApplicationListenerBean.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		try {
			logger.info("\n\n##### SYSTEM STARTUP INFORMATIONS #####");
			logger.info("HOSTNAME : " + InetAddress.getLocalHost().getHostName());
			logger.info("\n\n");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
