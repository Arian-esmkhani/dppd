package com.example.dppd.repository;

import com.example.dppd.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {

    // یافتن تمام لاگین‌های یک کاربر خاص بر اساس users_id
    List<LoginHistory> findByUser_Id(Long userId);

    // یافتن لاگین‌ها در بازه زمانی مشخص
    List<LoginHistory> findByLoginTimeBetween(LocalDateTime start, LocalDateTime end);
}
