package com.nagabinding.main.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.observe
import com.nagabinding.HomeBinding
import com.nagabinding.R
import com.nagabinding.main.details.PersonDetailActivity
import com.nagabinding.main.newperson.NewPersonActivity
import com.nagabinding.shared.NagaActivity
import com.nagabinding.shared.util.consume
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

    override fun onRestart() {
        super.onRestart()
        viewModel.loadPersons()
    }

    override fun onCreateOptionsMenu(menu: Menu?) = consume { menuInflater.inflate(R.menu.new_person, menu) }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.new_person -> consume { startActivity(NewPersonActivity.getStartIntent(this)) }
        else -> super.onOptionsItemSelected(item)
    }
}
