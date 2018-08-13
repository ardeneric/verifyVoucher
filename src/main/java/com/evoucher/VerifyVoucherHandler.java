package com.evoucher;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.evoucher.model.RequestClass;
import com.evoucher.model.ResponseClass;
import com.evoucher.service.VerifyEvoucherService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VerifyVoucherHandler implements RequestHandler<RequestClass, ResponseClass>{
	public final VerifyEvoucherService verifyEvoucherService;
	
	@Override
	public ResponseClass handleRequest(RequestClass input, Context context) {
		context.getLogger().log("creating " + input + " vouchers");
		return verifyEvoucherService.verifyEvoucher(input.getVoucher());
	}

}
