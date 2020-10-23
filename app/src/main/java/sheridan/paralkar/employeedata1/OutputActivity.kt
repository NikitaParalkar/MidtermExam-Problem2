package sheridan.paralkar.employeedata1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sheridan.paralkar.employeedata1.databinding.ActivityOutputBinding



class OutputActivity : AppCompatActivity() {

    companion object {
        const val Name_TEXT_KEY = "name"
        const val IS_certified_KEY = "certified"
        const val IS_trained_KEY = "trained"

    }

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trained = intent.getBooleanExtra(IS_trained_KEY, true)
        val certified = intent.getBooleanExtra(IS_certified_KEY, true)

        binding.isTrainedOutput.text =
            getString(if (trained) R.string.trained else R.string.not_trained)

        binding.isCertifiedOutput.text =
            getString(if (certified) R.string.certified else R.string.not_certified)

        binding.messageText.text = intent.getStringExtra(Name_TEXT_KEY)

        // make the close button work
        binding.btnback.setOnClickListener {
            intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }
    }
}
