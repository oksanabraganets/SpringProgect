package com.example.simple.repositary;

import com.example.simple.entity.AccountDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountDAO, Long> {

}
