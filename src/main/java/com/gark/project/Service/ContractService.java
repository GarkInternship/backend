package com.gark.project.Service;

import com.gark.project.Entity.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> getAllContracts() ;
    public Contract getContractById(String id) ;
    public Contract saveContract(Contract contract) ;
    public void deleteContract(String id) ;
}
