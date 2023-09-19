package com.example.sendmoney.model

import java.io.Serializable

data class BulkTopupModel(
    val number: String,
    val operator: String,
    val amount: String,
    val logo: Int
) : Serializable
