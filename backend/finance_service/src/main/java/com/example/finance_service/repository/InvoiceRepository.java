package com.example.finance_service.repository;

import com.example.finance_service.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    @Query("SELECT i, f FROM Invoice i JOIN i.finances f WHERE i.id = :invoiceId")
    List<Object[]> findInvoiceWithFinances(@Param("invoiceId") String invoiceId);
}
