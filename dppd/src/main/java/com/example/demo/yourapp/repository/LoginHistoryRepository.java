package com.example.demo.yourapp.repository;

import com.example.demo.yourapp.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    List<LoginHistory> findByUser_Id(Long userId);
    List<LoginHistory> findByLoginTimeBetween(LocalDateTime start, LocalDateTime end);
}
