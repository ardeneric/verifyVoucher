package com.evoucher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evoucher.model.RequestClass;
import com.evoucher.model.ResponseClass;

import me.ccampo.spring.aws.lambda.SpringRequestHandler;

public class MainHandler extends SpringRequestHandler<RequestClass, ResponseClass> {
	private static final ApplicationContext context =
            new AnnotationConfigApplicationContext(VerifyEvoucherApplication.class);

	@Override
	public ApplicationContext getApplicationContext() {
		return context;
	}

}
