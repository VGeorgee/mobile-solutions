package com.example.mybank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    companion object{
        public val TRANSACTION_ACTIVITY = 1
    }

    lateinit var list: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.textView)
    }


    fun newTransactionHandler(view: View){
        val transaction = Intent(this, Transact::class.java)
        startActivityForResult(transaction, TRANSACTION_ACTIVITY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            TRANSACTION_ACTIVITY -> {
                if(resultCode == RESULT_OK){
                    list.text = list.text.toString() + "\nBank account: ${data!!.getStringExtra(Transact.BANK_ACCOUNT)}\nName: ${data!!.getStringExtra(Transact.NAME)}\nAmount:${data!!.getIntExtra(Transact.AMOUNT, 0)}"
                }
            }
        }
    }
}