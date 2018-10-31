package com.lexus.demo.repositories;

import com.lexus.demo.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepositoryRequest extends JpaRepository<Request, Long> {
    List<Request> findByClient_UserId(Long clientId);
    List<Request> findByAdviser_UserId(Long adviderId);
}
