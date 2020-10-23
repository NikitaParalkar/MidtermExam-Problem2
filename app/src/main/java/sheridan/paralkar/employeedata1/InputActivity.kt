package sheridan.paralkar.employeedata1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sheridan.paralkar.employeedata1.databinding.ActivityMainBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{showOutput()}
    }

    private fun showOutput(){
        // get urgent flag value
        val trained = binding.chkTrained.isChecked
        val certified = binding.chkCertified.isChecked
        val name = binding.edtName

        val intent = Intent(this, OutputActivity::class.java).apply {
            putExtra(OutputActivity.IS_trained_KEY, trained)
            putExtra(OutputActivity.IS_certified_KEY, certified)

        }
        startActivity(intent)
    }
}