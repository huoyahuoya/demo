package com.example.demo.repository;

import com.example.demo.domain.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationLogRepository extends JpaRepository<OperationLog, Integer>, JpaSpecificationExecutor<OperationLog> {
}
