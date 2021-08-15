import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest extends TestCase {
    private Chainblock chainblock;
    private List<Transaction> transactionsList;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transactionsList = new ArrayList<>();
        prepareTransactions();
    }

    private void prepareTransactions() {
        Transaction firstTransaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.90); //0
        Transaction secondTransaction = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.80);//1
        Transaction thirdTransaction = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.70);//2
        Transaction forthTransaction = new TransactionImpl(4, TransactionStatus.FAILED, "Desi", "Pesho", 10.60);//3
        this.transactionsList.add(firstTransaction);
        this.transactionsList.add(secondTransaction);
        this.transactionsList.add(thirdTransaction);
        this.transactionsList.add(forthTransaction);
    }

    private void fillChainblock() {
        this.transactionsList.forEach(transaction -> chainblock.add(transaction));
    }

    //contains -> true
    @Test
    public void testContains() {
        Transaction transaction = this.transactionsList.get(0);
        Assert.assertFalse(this.chainblock.contains(transaction));
        this.chainblock.add(transaction);
        Assert.assertTrue(this.chainblock.contains(transaction));
    }


    //add -> valid
    @Test
    public void testAddCorrectTransaction() {
        //0 transactions
        this.chainblock.add(transactionsList.get(0));
        //1 transactions
        Assert.assertEquals(1, this.chainblock.getCount());
        this.chainblock.add(transactionsList.get(1));
        //2 transactions
        Assert.assertEquals(2, this.chainblock.getCount());
    }

    //add -> invalid (добавяме съществуващо id)
    @Test
    public void testAddExistingTransaction() {
        //0 transactions
        this.chainblock.add(transactionsList.get(0));
        //1 transaction
        Assert.assertEquals(1, this.chainblock.getCount());
        this.chainblock.add(transactionsList.get(0));
        Assert.assertEquals(1, this.chainblock.getCount());
    }

    //changeTransactionStatus
    /*@Test(expected = IllegalArgumentException.class)
    public void testChangeStatusOnInvalidTransaction () {
        //0 transactions
        int id = this.transactionsList.get(0).getId();
        this.chainblock.changeTransactionStatus(id, TransactionStatus.ABORTED);
    }*/

    //changeTransactionStatus
    @Test
    public void testChangeStatusTransaction() {
        Transaction transaction = this.transactionsList.get(0);
        //0 transactions
        this.chainblock.add(transaction);
        //1 transaction
        Assert.assertEquals(1, this.chainblock.getCount());
        this.chainblock.changeTransactionStatus(transaction.getId(), TransactionStatus.UNAUTHORIZED);
        Assert.assertEquals(TransactionStatus.UNAUTHORIZED, transaction.getStatus());
    }

    //removeTransactionById
    /*@Test(expected = IllegalArgumentException.class)
    public void testRemoveWithNoExistingId () {
        fillChainblock();
        //4 transactions
        Assert.assertEquals(4, chainblock.getCount());
        this.chainblock.removeTransactionById(this.chainblock.getCount() + 1); //5
    }*/

    //removeTransactionById
    @Test
    public void testSuccessfulRemoveById() {
        fillChainblock();
        //4 transactions
        Assert.assertEquals(4, chainblock.getCount());

        int id = this.transactionsList.get(2).getId();
        this.chainblock.removeTransactionById(id);
        //3 transaction
        Assert.assertEquals(3, chainblock.getCount());
        Assert.assertFalse(this.chainblock.contains(id));
    }


    //getById
    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdWithNonExistingId() {
        fillChainblock();
        this.chainblock.getById(this.chainblock.getCount() + 1); //5
    }

    //getById
    @Test
    public void testCorrectGetById() {
        fillChainblock(); //4 transactions
        Transaction expected = this.transactionsList.get(0);
        //id: 1, status: Successful, from: Desi, to: Pesho, amount: 10:90
        Transaction actual = this.chainblock.getById(expected.getId());
        Assert.assertEquals(expected, actual);
    }

    //getByTransactionStatus
    @Test(expected = IllegalArgumentException.class)
    public void testGetByInvalidStatus() {
        fillChainblock();//Successful, Failed
        this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatus() {
        fillChainblock();
        List<Transaction> successfulTransactions = this.transactionsList.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        Iterable<Transaction> result = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        Assert.assertNotNull(result);
        List<Transaction> resultTransactions = new ArrayList<>();
        result.forEach(resultTransactions::add);

        Assert.assertEquals(successfulTransactions.size(), resultTransactions.size());
        resultTransactions.forEach(tr -> Assert.assertEquals(TransactionStatus.SUCCESSFUL, tr.getStatus()));
        Assert.assertEquals(successfulTransactions, resultTransactions);
    }

    //getAllSendersWithTransactionStatus
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithNonExistingTransactionStatus() {
        fillChainblock();
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    //getAllSendersWithTransactionStatus
    @Test
    public void testGetAllSendersWithExistingTransactionStatus() {
        fillChainblock();
        List<String> expectedSenders = this.transactionsList.stream()
                .filter(tr -> tr.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Iterable<String> result = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        Assert.assertNotNull(result);
        List<String> resultSenders = new ArrayList<>();
        result.forEach(sender -> resultSenders.add(sender));


        Assert.assertEquals(expectedSenders.size(), resultSenders.size());
        resultSenders.forEach(sender -> Assert.assertEquals("Desi", sender));
    }

    //getAllReceiversWithTransactionStatus
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithNonExistingTransactionStatus() {
        fillChainblock(); //successful, failed
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    //getAllReceiversWithTransactionStatus
    @Test
    public void testGetAllReceiversWithExistingTransactionStatus() {
        fillChainblock();
        List<String> expectedReceivers = this.transactionsList.stream()
                .filter(tr -> tr.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Iterable<String> result = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        Assert.assertNotNull(result);
        List<String> resultReceivers = new ArrayList<>();
        result.forEach(resultReceivers::add);


        Assert.assertEquals(expectedReceivers.size(), resultReceivers.size());
        resultReceivers.forEach(receiver -> Assert.assertEquals("Pesho", receiver));
    }

    //getAllOrderedByAmountDescendingThenById
    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        fillChainblock();
        List<Transaction> expected = this.transactionsList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> result = this.chainblock.getAllOrderedByAmountDescendingThenById();
        Assert.assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        Assert.assertEquals(expected, actual);
    }
}