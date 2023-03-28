package kz.orkenniet.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.orkenniet.R
import kz.orkenniet.databinding.ActivityThirdPageBinding

class ThirdPageActivity : AppCompatActivity(R.layout.activity_third_page) {

    private val binding: ActivityThirdPageBinding by viewBinding(ActivityThirdPageBinding::bind)
    private var prevStarted = "yes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        val intent = Intent(this, FourthPageActivity::class.java)
        startActivity(intent)
    }
}
