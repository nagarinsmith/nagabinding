package com.nagabinding.main.details

import android.content.Context
import android.content.Intent
import com.nagabinding.PersonDetailBinding
import com.nagabinding.R
import com.nagabinding.shared.NagaActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PersonDetailActivity : NagaActivity<PersonDetailBinding, PersonDetailViewModel>(R.layout.activity_person_detail) {

    override val viewModel: PersonDetailViewModel by viewModel { parametersOf(intent.getStringExtra(PERSON_ID)) }

    companion object {
        private const val PERSON_ID = "personId"

        fun getStartIntent(context: Context, personId: String) = Intent(context, PersonDetailActivity::class.java).also {
            it.putExtra(PERSON_ID, personId)
        }
    }
}
