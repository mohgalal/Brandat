package com.example.brandat.ordermodel

import com.example.brandat.test.DefaultAddress
import com.example.brandat.test.EmailMarketingConsent
import com.example.brandat.test.SmsMarketingConsent

data class Customer(
    val accepts_marketing: Boolean = false,
    val accepts_marketing_updated_at: String = "",
    val admin_graphql_api_id: String = "",
    val created_at: String = "",
    val currency: String = "",
    val default_address: DefaultAddress = DefaultAddress(),
    val email: String = "",
    val email_marketing_consent: EmailMarketingConsent = EmailMarketingConsent(),
    val first_name: String = "",
    val id: Long = 0,
    val last_name: String = "",
    val last_order_id: Long = 0,
    val last_order_name: String = "",
    val marketing_opt_in_level: Any = Any(),
    val multipass_identifier: Any = Any(),
    val note: Any = Any(),
    val orders_count: Int = 0,
    val phone: String = "",
    val sms_marketing_consent: SmsMarketingConsent = SmsMarketingConsent(),
    val state: String = "",
    val tags: String = "",
    val tax_exempt: Boolean = false,
    val tax_exemptions: List<Any> = listOf(),
    val total_spent: String = "",
    val updated_at: String = "",
    val verified_email: Boolean = false
)