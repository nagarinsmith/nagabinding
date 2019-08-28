package com.nagabinding.main.newperson

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.observe
import com.nagabinding.NewPersonBinding
import com.nagabinding.R
import com.nagabinding.shared.NagaActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewPersonActivity : NagaActivity<NewPersonBinding, NewPersonViewModel>(R.layout.activity_new_person) {

    override val viewModel: NewPersonViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.event.observe(this) {
            when (val event = it.consume()) {
                NewPersonViewModel.Event.Success -> finish()
                is NewPersonViewModel.Event.Failure -> Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, NewPersonActivity::class.java)
    }
}
