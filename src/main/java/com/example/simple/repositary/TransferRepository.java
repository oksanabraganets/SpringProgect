package com.example.simple.repositary;

import com.example.simple.entity.TransferDAO;
import com.example.simple.entity.TransferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<TransferDAO, Long> {

        TransferDAO save(TransferDAO account);

        List<TransferDAO> findAllByType(TransferType type);
}
