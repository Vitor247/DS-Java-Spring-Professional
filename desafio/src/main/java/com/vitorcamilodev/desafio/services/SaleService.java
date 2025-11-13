package com.vitorcamilodev.desafio.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vitorcamilodev.desafio.dto.SaleMinDTO;
import com.vitorcamilodev.desafio.dto.SaleReportDTO;
import com.vitorcamilodev.desafio.dto.SaleSummaryDTO;
import com.vitorcamilodev.desafio.entities.Sale;
import com.vitorcamilodev.desafio.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleReportDTO> findSalesReport(String startDate, String endDate, String sellerName, Pageable pageable) {
		LocalDate end = endDate.isBlank() ? LocalDate.now() : LocalDate.parse(endDate);
		LocalDate start = startDate.isBlank() ? end.minusYears(1L) : LocalDate.parse(startDate);

		return repository.searchReport(start, end, sellerName, pageable);
	}

	public Page<SaleSummaryDTO> findSalesSummary(String startDate, String endDate, String sellerName, Pageable pageable) {
		LocalDate end = endDate.isBlank() ? LocalDate.now() : LocalDate.parse(endDate);
		LocalDate start = startDate.isBlank() ? end.minusYears(1L) : LocalDate.parse(startDate);

		return repository.searchSummary(start, end, sellerName, pageable);
	}

}
