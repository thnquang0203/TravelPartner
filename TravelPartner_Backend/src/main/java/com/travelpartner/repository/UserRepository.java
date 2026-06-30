package com.travelpartner.repository;

import com.travelpartner.entity.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
}
