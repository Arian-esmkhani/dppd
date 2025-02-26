package com.example.dppd.repository;

import com.example.dppd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // جستجوی کاربر بر اساس نام کاربری (مطابق users_name در دیتابیس)
    Optional<User> findByUsername(String username);

    // جستجوی کاربر بر اساس ایمیل (مطابق users_email در دیتابیس)
    Optional<User> findByEmail(String email);

    // بررسی وجود کاربر با نام کاربری خاص
    boolean existsByUsername(String username);

    // بررسی وجود کاربر با ایمیل خاص
    boolean existsByEmail(String email);
}
