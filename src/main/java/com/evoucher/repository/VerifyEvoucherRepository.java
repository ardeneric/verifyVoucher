package com.evoucher.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.evoucher.model.Evoucher;

public interface VerifyEvoucherRepository extends JpaRepository<Evoucher, Integer> {
	public Evoucher findByEvoucher(String voucher);
}
