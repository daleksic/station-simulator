package com.evbox.everon.ocpp.simulator.station.evse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Represents EVSE transaction. It consists of transactionId and status.
 */
@Getter
@Setter
@AllArgsConstructor
public class EvseTransaction {

    /**
     * Transaction contains only status.
     */
    public static final EvseTransaction NONE = new EvseTransaction(EvseTransactionStatus.NONE);

    private String transactionId;
    private EvseTransactionStatus status;

    /**
     * Create transaction with the given identity.
     * By default set the status to IN_PROGRESS.
     *
     * @param transactionId transaction identity
     */
    public EvseTransaction(String transactionId) {
        Objects.requireNonNull(transactionId);

        this.transactionId = transactionId;
        this.status = EvseTransactionStatus.IN_PROGRESS;
    }

    /**
     * Create transaction with the given status.
     *
     * @param status transaction status
     */
    private EvseTransaction(EvseTransactionStatus status) {
        Objects.requireNonNull(status);

        this.status = status;
    }

    @Override
    public String toString() {
        return transactionId;
    }

    EvseTransactionView createView() {
        return new EvseTransactionView(this.transactionId, this.status);
    }

    @Getter
    @AllArgsConstructor
    public class EvseTransactionView {

        private final String transactionId;
        private final EvseTransactionStatus status;
    }
}
