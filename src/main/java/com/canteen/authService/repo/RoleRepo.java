package com.canteen.authService.repo;

import com.canteen.authService.entity.Role;
import com.canteen.authService.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

    Optional<Role> findByRole(RoleEnum roleEnum);
}
