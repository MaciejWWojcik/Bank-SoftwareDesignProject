package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InterBankPaymentAgencyTest {


    private InterBankPaymentAgency paymentAgency;
    private Bank bank1;
    private Bank bank2;

    @BeforeAll
    public void init() {
        bank1 = new Bank(1);
        Transfer transfer = new Transfer(1, 2);
        bank1.addTransfer(transfer);

        bank2 = new Bank(2);
        Transfer transfer2 = new Transfer(2, 1);
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
        Assertions.assertEquals(1, bank1Transfer.getReceiverBankId());
        Assertions.assertEquals(2, bank1Transfer.getSenderBankId());
        Assertions.assertEquals(1, bank2.receivedTransfers.size());
        Transfer bank2Transfer = bank2.receivedTransfers.get(0);
        Assertions.assertEquals(2, bank2Transfer.getReceiverBankId());
        Assertions.assertEquals(1, bank2Transfer.getSenderBankId());
    }

}
