package com.gark.project.Service;

import com.gark.project.Entity.Contract;
import com.gark.project.Rpository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> getAllContracts() {
        return (List<Contract>) contractRepository.findAll();
    }

    public Contract getContractById(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteContract(String id) {
        contractRepository.deleteById(id);
    }
}