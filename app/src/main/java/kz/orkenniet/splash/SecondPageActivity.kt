package kz.orkenniet.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.ActivitySecondPageBinding

class SecondPageActivity : AppCompatActivity(R.layout.activity_second_page) {

    private val binding: ActivitySecondPageBinding by viewBinding(ActivitySecondPageBinding::bind)
    private var prevStarted = "yes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)
        binding.imgNext.setOnClickListener {
            onResume()
        }
    }

    override fun onResume() {
        super.onResume()
        val sharedpreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            val editor = sharedpreferences.edit()
            editor.putBoolean(prevStarted, true)
            editor.apply()
        } else {
            if (binding.imgNext.isEnabled) {
                moveToSecondary()
            }
        }
    }

    private fun moveToSecondary() {
        val intent = Intent(this, ThirdPage::class.java)
        startActivity(intent)
    }
}
