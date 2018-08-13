package com.evoucher.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.evoucher.model.Evoucher;
import com.evoucher.model.ResponseClass;
import com.evoucher.model.Status;
import com.evoucher.repository.VerifyEvoucherRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VerifyEvoucherServiceImpl implements VerifyEvoucherService{
	public final VerifyEvoucherRepository verifyEvoucherRepository;

	@Override
	public ResponseClass verifyEvoucher(String voucher) {
		ResponseClass res = new ResponseClass();
		Map <String, String>  result = new HashMap<>();
		result.put("0", "VALID");
		result.put("1","USED");
		result.put("2", "INVALID");
		
		if(!voucher.matches("[A-Za-z0-9]+")) {
			res.setStatus(result.get("2"));
			return res;
		}else {
			Evoucher e = verifyEvoucherRepository.findByVoucher(voucher);
			if(Objects.nonNull(e)) {
				res.setStatus(result.get(e.getStatus().toString()));
				return res;
			}
		}
		res.setStatus(result.get("2"));
		return res;
		
	}
}
