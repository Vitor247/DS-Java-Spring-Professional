package com.vitorcamilodev.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitorcamilodev.desafio.dto.SaleMinDTO;
import com.vitorcamilodev.desafio.dto.SaleReportDTO;
import com.vitorcamilodev.desafio.dto.SaleSummaryDTO;
import com.vitorcamilodev.desafio.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleReportDTO>> findSalesReport(
			@RequestParam(defaultValue = "") String minDate,
			@RequestParam(defaultValue = "") String maxDate,
			@RequestParam(name = "name", defaultValue = "") String sellerName, Pageable pageable) {
		Page<SaleReportDTO> dto = service.findSalesReport(minDate, maxDate, sellerName, pageable);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SaleSummaryDTO>> findSalesSummary(
			@RequestParam(defaultValue = "") String minDate,
			@RequestParam(defaultValue = "") String maxDate,
			@RequestParam(name = "name", defaultValue = "") String sellerName, Pageable pageable) {
		Page<SaleSummaryDTO> dto = service.findSalesSummary(minDate, maxDate, sellerName, pageable);
		return ResponseEntity.ok(dto);
	}

}
