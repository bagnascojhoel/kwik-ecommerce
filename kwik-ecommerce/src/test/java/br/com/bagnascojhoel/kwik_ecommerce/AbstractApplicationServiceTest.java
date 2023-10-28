package br.com.bagnascojhoel.kwik_ecommerce;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        classes = {ApplicationServiceConfiguration.class},
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
public abstract class AbstractApplicationServiceTest {

    private static String currentTransactionName;

    protected static void setupTransactionName(final String transactionName) {
        TransactionSynchronizationManager.setCurrentTransactionName(transactionName);
        currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
    }

    protected static void assertTransactionIsPropagated() {
        Assert.notNull(currentTransactionName, "You need to call setupTransactionName before assertion");

        assertThat(TransactionSynchronizationManager.getCurrentTransactionName()).isEqualTo(currentTransactionName);
    }

}
