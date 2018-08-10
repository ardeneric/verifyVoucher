package com.evoucher.Handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.evoucher.model.RequestClass;
import com.evoucher.model.Status;
import com.evoucher.service.VerifyEvoucherService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VerifyEvoucherHandler implements RequestHandler<RequestClass, Status>{

	public final VerifyEvoucherService verifyEvoucherService;
	
	@Override
	public Status handleRequest(RequestClass input, Context context) {
		context.getLogger().log("creating " + input + " vouchers");
		return verifyEvoucherService.verifyEvoucher(input.getVoucher());
	}

}
