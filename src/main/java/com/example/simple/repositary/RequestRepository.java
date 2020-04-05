package com.example.simple.repositary;

import com.example.simple.entity.RequestDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestDAO, Long> {
}
