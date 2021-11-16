package com.user.service.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class DeleteUsedOTPSEvent extends ApplicationEvent {

	public DeleteUsedOTPSEvent(Object source) {
		super(source);
	}

	public DeleteUsedOTPSEvent(Object source, Clock clock) {
		super(source, clock);
	}
}
