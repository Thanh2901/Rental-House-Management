package com.example.tenant_service.service;


import com.example.tenant_service.dto.request.DepositRequest;
import com.example.tenant_service.entity.Deposit;
import com.example.tenant_service.mapper.DepositMapper;
import com.example.tenant_service.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private DepositMapper depositMapper;

    public Deposit addDeposit(DepositRequest depositRequest){
        Deposit deposit = depositMapper.toDeposit(depositRequest);
        return depositRepository.save(deposit);
    }
    public Deposit updateDeposit(int id, DepositRequest depositRequest){
        Deposit deposit = depositRepository.findById(id).orElseThrow(() -> new RuntimeException("deposit not found"));
        deposit = depositMapper.updateDeposit(deposit, depositRequest);
        return depositRepository.save(deposit);
    }

    public void deleteDepositById(int id){
        depositRepository.deleteById(id);
    }


}
