package com.vitorcamilodev.desafio.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vitorcamilodev.desafio.dto.SaleReportDTO;
import com.vitorcamilodev.desafio.dto.SaleSummaryDTO;
import com.vitorcamilodev.desafio.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.vitorcamilodev.desafio.dto.SaleReportDTO(obj.id, obj.date, obj.amount, obj.seller.name)"
			+ " FROM Sale obj WHERE obj.date BETWEEN :startDate AND :endDate"
			+ " AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :sellerName,'%'))")
	Page<SaleReportDTO> searchReport(LocalDate startDate, LocalDate endDate, String sellerName, Pageable pageable);

	@Query("SELECT new com.vitorcamilodev.desafio.dto.SaleSummaryDTO(obj.seller.name, SUM(obj.amount)) FROM Sale obj"
			+ " WHERE obj.date BETWEEN :startDate AND :endDate"
			+ " AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :sellerName,'%'))" + " GROUP BY obj.seller.name")
	Page<SaleSummaryDTO> searchSummary(LocalDate startDate, LocalDate endDate, String sellerName, Pageable pageable);

}