package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankTest {

    Bank bank;

    @BeforeAll
    public void init() {
        bank = new Bank(1);
    }

    @Test
    public void shouldStoreIncomingTransfer() {
        Transfer transfer = new Transfer(2, 1);
        bank.receiveTransfer(transfer);

        Assertions.assertEquals(1, bank.receivedTransfers.size());
        Assertions.assertEquals(transfer, bank.receivedTransfers.get(0));
    }

    @Test
    public void shouldCorrectlyAddProduct() {
        Account account = new Account(bank, new ArrayList<>());
        bank.addProduct(account);

        Assertions.assertEquals(1, bank.products.size());
        Assertions.assertEquals(account, bank.products.get(0));
    }

    @Test
    public void shouldCorrectlyAddOperation() {
        OperationEntry operationEntry = new OperationEntry("income", "1", "2018-10-10", "Short description");
        bank.addOperation(operationEntry);

        Assertions.assertEquals(1, bank.operationsHistory.size());
        Assertions.assertEquals(operationEntry, bank.operationsHistory.get(0));
    }

}
