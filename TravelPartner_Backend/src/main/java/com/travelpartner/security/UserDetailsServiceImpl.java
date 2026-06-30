package com.travelpartner.security;

import com.travelpartner.entity.User;
import com.travelpartner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User nguoiDung = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Khong tim thay user: " + email));

        return new org.springframework.security.core.userdetails.User(
                nguoiDung.getEmail(),
                nguoiDung.getMatKhau(),
                List.of(new SimpleGrantedAuthority("ROLE_" + nguoiDung.getVaiTro().name()))
        );
    }
}