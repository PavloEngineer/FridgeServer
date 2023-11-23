package com.system.fridges.models.transferObjects;

import java.util.HashMap;

public class StripeCharge {

    public String stripeToken;

    public String username;

    public int amount;

    public boolean success;

    public String message;

    public String chargeId;

    public HashMap<String, Object> addictionInfo = new HashMap<>();
}
