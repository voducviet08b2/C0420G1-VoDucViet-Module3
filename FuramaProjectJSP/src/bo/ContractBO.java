package bo;

import model.Contract;

import java.util.List;


public interface ContractBO {
    void create(Contract contract);
    List<Contract> findAll();
}
