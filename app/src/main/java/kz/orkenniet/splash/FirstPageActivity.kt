package kz.orkenniet.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.ActivityFirstPageBinding
import java.lang.Boolean

class FirstPageActivity : AppCompatActivity(R.layout.activity_first_page) {

    private val binding: ActivityFirstPageBinding by viewBinding(ActivityFirstPageBinding::bind)
    private var prevStarted = "yes"

    override fun onResume() {
        super.onResume()
        val sharedpreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            val editor = sharedpreferences.edit()
            editor.putBoolean(prevStarted, Boolean.TRUE)
            editor.apply()
        } else {
            if (binding.imgNext!!.isEnabled) {
                moveToSecondary()
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.imgNext.setOnClickListener {
            onResume()
        }
    }

    fun moveToSecondary() {
        val intent = Intent(this, SecondPageActivity::class.java)
        startActivity(intent)
    }
}
