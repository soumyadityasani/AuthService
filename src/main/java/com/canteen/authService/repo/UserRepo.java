package com.canteen.authService.repo;

import com.canteen.authService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
     Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
