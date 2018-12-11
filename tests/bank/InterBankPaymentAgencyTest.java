package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InterBankPaymentAgencyTest {


    private InterBankPaymentAgency paymentAgency;
    private Bank bank1;
    private Bank bank2;
    private Account bank1Account;
    private Account bank2Account;

    @BeforeAll
    public void init() {
        bank1 = new Bank(1);
        bank1Account = new AccountFactory(bank1, new ArrayList<>()).build();
        bank1.addProduct(bank1Account);
        bank2 = new Bank(2);
        bank2Account = new AccountFactory(bank2, new ArrayList<>()).build();
        bank2.addProduct(bank2Account);
        Transfer transfer = new Transfer(bank1.getId(), bank2Account.getId());
        bank1.addTransfer(transfer);
        Transfer transfer2 = new Transfer(bank2.getId(), bank1Account.getId());
        bank2.addTransfer(transfer2);

        paymentAgency = new InterBankPaymentAgency();
        paymentAgency.addBank(bank1);
        paymentAgency.addBank(bank2);
    }

    @Test
    public void shouldCorrectlyCreatesAgency() {
        Assertions.assertEquals(2, paymentAgency.banks.size());
    }

    @Test
    public void shouldCorrectlyMakeTransfers() {
        paymentAgency.collectTransfers();
        paymentAgency.sendTransfers();
        Assertions.assertEquals(1, bank1.receivedTransfers.size());
        Transfer bank1Transfer = bank1.receivedTransfers.get(0);
        Assertions.assertEquals(bank1Account.getId(), bank1Transfer.getReceiverId());
        Assertions.assertEquals(bank2.getId(), bank1Transfer.getSenderId());
        Assertions.assertEquals(1, bank2.receivedTransfers.size());
        Transfer bank2Transfer = bank2.receivedTransfers.get(0);
        Assertions.assertEquals(bank2Account.getId(), bank2Transfer.getReceiverId());
        Assertions.assertEquals(bank1.getId(), bank2Transfer.getSenderId());
    }

}
