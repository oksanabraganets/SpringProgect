package com.example.simple.repositary;

import com.example.simple.entity.AccountDAO;
import com.example.simple.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountDAO, Long> {
    @Override
    List<AccountDAO> findAll();

    List<AccountDAO> findAllByUser(Long id);

    Optional<AccountDAO> findById(Long id);

    Optional<AccountDAO> findByIdAndType(Long id, AccountType type);

    AccountDAO save(AccountDAO account);
}
