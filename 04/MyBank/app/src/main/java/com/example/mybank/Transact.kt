package com.example.mybank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Transact : AppCompatActivity() {

    companion object {
        val BANK_ACCOUNT = "BANK_ACCOUNT"
        val NAME = "NAME"
        val AMOUNT = "AMOUNT"
    }

    private lateinit var bankAccount: EditText
    private lateinit var name: EditText
    private lateinit var amount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transact)
        bankAccount = findViewById(R.id.bankAccount)
        name = findViewById(R.id.name)
        amount = findViewById(R.id.amount)
    }

    fun sendHandler(view: View){
        // https://kotlinlang.org/docs/scope-functions.html#apply
        setResult(RESULT_OK, Intent().apply{
            putExtra(BANK_ACCOUNT, bankAccount.text.toString())
            putExtra(NAME, name.text.toString())
            putExtra(AMOUNT, amount.text.toString().toInt())
        })
        finish()
    }
}