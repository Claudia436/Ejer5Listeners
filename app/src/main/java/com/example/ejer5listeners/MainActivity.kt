package com.example.ejer5listeners

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer5listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        binding.editText1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.button.isEnabled = binding.editText1.text.toString() != "" && binding.editText2.text.toString() != ""
            }
        })

        binding.editText2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.button.isEnabled = binding.editText1.text.isNotEmpty() && binding.editText2.text.isNotEmpty()
            }
        })

        binding.editText1.setOnFocusChangeListener{ view, focus ->
            if (focus){
                binding.textview.text = binding.editText1.tag.toString()
            }
        }

        binding.editText2.setOnFocusChangeListener{ view, focus ->
            if (focus){
                binding.textview.text = binding.editText2.tag.toString()
            }
        }

        binding.button.setOnClickListener{
            binding.editText1.setText(binding.editText1.text.toString() + binding.editText2.text.toString())
            binding.editText2.text.clear()
        }
    }
}