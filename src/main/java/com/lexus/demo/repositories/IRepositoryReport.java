package com.lexus.demo.repositories;

import com.lexus.demo.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IRepositoryReport extends JpaRepository<Report, Long> {
    List<Report> findByClient_UserId(Long clientId);
    List<Report> findByAdviser_UserId(Long adviserId);
}
