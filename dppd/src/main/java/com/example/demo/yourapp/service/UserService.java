package com.example.dppd.service;

import com.example.dppd.model.LoginHistory;
import com.example.dppd.model.User;
import com.example.dppd.repository.LoginHistoryRepository;
import com.example.dppd.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final LoginHistoryRepository loginHistoryRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       LoginHistoryRepository loginHistoryRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loginHistoryRepository = loginHistoryRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ثبت کاربر جدید با رمز عبور رمزنگاری شده
    public User registerUser(User user) {
        if (existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("نام کاربری قبلاً استفاده شده است!");
        }
        if (existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("ایمیل قبلاً استفاده شده است!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // احراز هویت کاربر و ثبت تاریخچه ورود
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("کاربر یافت نشد!"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("رمز عبور نادرست!");
        }

        // ثبت تاریخچه ورود
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setLoginTime(LocalDateTime.now());
        loginHistory.setUser(user);
        loginHistoryRepository.save(loginHistory);

        return user;
    }

    // بارگیری کاربر بر اساس نام کاربری (برای Spring Security)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("کاربر یافت نشد!"));
    }

    // بررسی وجود کاربر با نام کاربری
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    // بررسی وجود کاربر با ایمیل
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // دریافت تاریخچه ورودهای یک کاربر
    public List<LoginHistory> getLoginHistory(Long userId) {
        return loginHistoryRepository.findByUser_Id(userId);
    }

    // دریافت کاربر بر اساس ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
