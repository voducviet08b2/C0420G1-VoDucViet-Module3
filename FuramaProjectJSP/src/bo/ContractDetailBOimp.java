package bo;

import dao.ContractDAO;
import dao.ContractDAOimp;
import dao.ContractDetailDAO;
import dao.ContractDetailDAOimp;
import model.Contract;
import model.ContractDetail;


public class ContractDetailBOimp implements ContractDetailBO {
    private ContractDetailDAO contractDetailDAO=new ContractDetailDAOimp();
    @Override
    public void create(ContractDetail contractDetail) {
        contractDetailDAO.create(contractDetail);
    }
}
