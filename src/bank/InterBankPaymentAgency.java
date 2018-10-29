package bank;


import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maciej on 11.10.2018.
 */
public class InterBankPaymentAgency {

    protected List<Bank> banks;
    private List<Transfer> transfers;

    public InterBankPaymentAgency(){
        this.banks = new ArrayList<>();
        this.transfers = new ArrayList<>();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable periodicTask = () -> {
            collectTransfers();
            sendTransfers();
        };
        executor.scheduleAtFixedRate(periodicTask, 0, 1, TimeUnit.MINUTES);
    }

    public void  collectTransfers(){
        this.banks.forEach(bank -> transfers.addAll(bank.gatherTransfers()));
    }

    public void sendTransfers(){
        this.transfers.forEach(transfer -> {
            Optional<Bank> receiverBank = banks.stream().filter(bank -> bank.getId() == transfer.getReceiverBankId()).findFirst();
            receiverBank.ifPresent(bank -> bank.receiveTransfer(transfer));
        });
        this.transfers.clear();
    }

    public void addBank(Bank bank){
        this.banks.add(bank);
    }


}
