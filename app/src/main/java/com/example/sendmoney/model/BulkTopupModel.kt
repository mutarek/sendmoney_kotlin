package com.example.sendmoney.model

data class BulkTopupModel(
    val number: String,
    val operator: String,
    val amount: String,
    val logo: Int
)
