package bank;


import java.util.*;

/**
 * Created by Maciej on 11.10.2018.
 */
public class InterBankPaymentAgency {

    private List<Bank> banks;
    private List<Transfer> transfers;

    public InterBankPaymentAgency(){
        this.banks = new ArrayList();
        this.transfers = new ArrayList();
        // TODO periodicaly invoke collectTranfers & sendTrasfers
    }

    public void collectTransfers(){
        // TODO iterate over banks and store trasfers in transfers
    }

    public void sendTransfers(){
        // TODO send transfers to banks
    }

    public void addBank(Bank bank){
        this.banks.add(bank);
    }


}
