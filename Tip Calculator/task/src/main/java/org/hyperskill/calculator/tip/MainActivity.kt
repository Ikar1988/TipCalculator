package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doBeforeTextChanged
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var edit_text: EditText
    private lateinit var slider: Slider
    private lateinit var text_view: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_text = findViewById(R.id.edit_text)
        slider = findViewById(R.id.slider)
        text_view = findViewById(R.id.text_view)

        fun updateTextView() {

            try {
                val percent = slider.value.toString().toDouble()
                val bill = edit_text.text.toString().toDouble()
                val res = bill * (percent / 100)
                text_view.text = "Tip amount: ${String.format("%.2f", res)}"
            }
            catch (e: NumberFormatException) {

            }

        }

        edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                val str = s.toString() ?: ""
                updateTextView()
            }
        })

        slider.addOnChangeListener(object: Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                updateTextView()
            }
        })


    }
}