package com.example.demo.service;

import com.example.demo.domain.OperationLog;
import com.example.demo.repository.OperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private OperationLogRepository operationLogRepository;

    public boolean save(OperationLog opsLog){
        try {
            operationLogRepository.save(opsLog);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
