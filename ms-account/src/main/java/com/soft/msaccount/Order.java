package com.soft.msaccount;

import javax.validation.constraints.Size;
import java.util.List;

public class Order {
    private long customerId;
    private int amount;
    @Size(min = 1,message = "En az bir tane yemek ismi olmalı")
    private List<String> orderItems;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final long customerIdParam) {
        customerId = customerIdParam;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amountParam) {
        amount = amountParam;
    }

    public List<String> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(final List<String> orderItemsParam) {
        orderItems = orderItemsParam;
    }
}
