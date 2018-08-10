package com.evoucher.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoucher.model.Evoucher;
import com.evoucher.model.Status;
import com.evoucher.repository.VerifyEvoucherRepository;

@Service
public class VerifyEvoucherService {

	VerifyEvoucherRepository createEvoucherRepository;

	public VerifyEvoucherService(VerifyEvoucherRepository createEvoucherRepository) {
		super();
		this.createEvoucherRepository = createEvoucherRepository;
	}



	public Status verifyEvoucher(String voucher) {
		if(!voucher.matches("[A-Za-z0-9]+")) {
			return Status.INVALID;
		}else {
			Evoucher e = createEvoucherRepository.findByEvoucher(voucher);
			if(Objects.nonNull(e)) {
				return e.getStatus();
			}
		}
		return Status.INVALID;
		
	}
}
