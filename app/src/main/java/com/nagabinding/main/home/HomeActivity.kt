package com.nagabinding.main.home

import android.os.Bundle
import androidx.lifecycle.observe
import com.nagabinding.HomeBinding
import com.nagabinding.R
import com.nagabinding.main.details.PersonDetailActivity
import com.nagabinding.shared.NagaActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : NagaActivity<HomeBinding, HomeViewModel>(R.layout.activity_main) {

    override val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = PersonsAdapter {
            startActivity(PersonDetailActivity.getStartIntent(this, it.id))
        }
        binding.persons.adapter = adapter
        viewModel.persons.observe(this, adapter::submitList)
    }
}
