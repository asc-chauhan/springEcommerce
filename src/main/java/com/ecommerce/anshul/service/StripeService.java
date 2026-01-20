package com.ecommerce.anshul.service;

import com.ecommerce.anshul.payload.StripePaymentDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface StripeService {
    PaymentIntent paymentIntent(StripePaymentDTO stripePaymentDTO) throws StripeException;
}
