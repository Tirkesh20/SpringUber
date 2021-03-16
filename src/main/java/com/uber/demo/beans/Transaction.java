package com.uber.demo.beans;
import com.uber.demo.enums.TransactionStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Transaction {
    private long id;
    private TransactionStatus transactionStatus;

    private long order_id;
    private Timestamp pay_date;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrder_id(){return order_id;}

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public void setPay_date(Timestamp pay_date) {
        this.pay_date = pay_date;
    }

    public Timestamp getPay_date() {
        return pay_date;
    }

    public TransactionStatus getTransactionStatus(){
        return transactionStatus;
    }
    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

}

