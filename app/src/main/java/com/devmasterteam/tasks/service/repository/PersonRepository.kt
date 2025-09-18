package com.devmasterteam.tasks.service.repository

import com.devmasterteam.tasks.service.model.PersonModel
import com.devmasterteam.tasks.service.repository.remote.PersonServices
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import retrofit2.Response

class PersonRepository {

    private val remote = RetrofitClient.getService(PersonServices::class.java)

    suspend fun login(email: String, password: String): Response<PersonModel> {
        return remote.login(email, password)
    }
}