package bo;

import dao.ContractDAO;
import dao.ContractDAOimp;
import model.Contract;

import java.util.List;


public class ContractBOimp implements ContractBO {
    private ContractDAO contractDAO=new ContractDAOimp();
    @Override
    public void create(Contract contract) {
        contractDAO.create(contract);
    }
    public List<Contract> findAll(){
        return contractDAO.findAll();
    }
}
