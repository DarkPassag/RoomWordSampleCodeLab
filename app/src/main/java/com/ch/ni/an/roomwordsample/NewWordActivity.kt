package com.ch.ni.an.roomwordsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EdgeEffect
import android.widget.EditText
import androidx.activity.viewModels

class NewWordActivity : AppCompatActivity() {
    private lateinit var editWordView: EditText

    private val viewModel :WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editWordView = findViewById(R.id.edit_word)

        val button: Button = findViewById(R.id.save_button)
        button.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(editWordView.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }


    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}