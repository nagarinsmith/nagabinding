package com.nagabinding.repository

import com.nagabinding.model.Person
import com.nagabinding.model.PersonDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PersonsRepository {

    private val personDetails = listOf(
        PersonDetails(
            1,
            "Paul-Claudiu Orha",
            "https://avatars1.githubusercontent.com/u/24562704?s=400&v=4",
            "+40745616223"
        ),
        PersonDetails(
            2,
            "Cezar Ciulei",
            "https://imgix.ranker.com/user_node_img/50089/1001775474/original/take-advantage-photo-u1?w=650&q=50&fm=pjpg&fit=crop&crop=faces",
            "+40123456789"
        ),
        PersonDetails(
            3,
            "Sanda Micu",
            "https://vignette.wikia.nocookie.net/naruto/images/6/64/Sakura_Part_1.png/revision/latest?cb=20170726101444",
            "+40123456789"
        ),
        PersonDetails(
            4,
            "Stefan Lupascu",
            "https://cdn.vox-cdn.com/thumbor/kekFmwYZkODx1o7GXA-CnvtWMNc=/0x0:1920x1080/1820x1213/filters:focal(807x387:1113x693):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/53851595/death_note.0.jpg",
            "+40123456789"
        )
    )

    private val persons = personDetails.map { Person(it.id, it.name, it.avatar) }

    fun getPersons(): Flow<List<Person>> = flowOf(persons)

    fun getPersonDetailById(id: Int): Flow<PersonDetails?> = flowOf(personDetails.firstOrNull { it.id == id })
}