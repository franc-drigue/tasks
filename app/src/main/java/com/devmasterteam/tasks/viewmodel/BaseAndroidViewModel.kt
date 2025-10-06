package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.model.PersonModel
import com.devmasterteam.tasks.service.model.ValidationModel
import com.devmasterteam.tasks.service.repository.local.PreferencesManager
import com.google.gson.Gson
import retrofit2.Response

open class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {

    private val preferencesManager = PreferencesManager(application.applicationContext)

    protected suspend fun saveUserAuthentication(personModel: PersonModel) {
        preferencesManager.store(TaskConstants.SHARED.TOKEN_KEY, personModel.token)
        preferencesManager.store(TaskConstants.SHARED.PERSON_KEY, personModel.personKey)
        preferencesManager.store(TaskConstants.SHARED.PERSON_NAME, personModel.name)
    }

    protected fun <T> errorMessage(reponse: Response<T>): ValidationModel {
        return ValidationModel(
            Gson().fromJson<String>(
                reponse.errorBody()?.string().toString(),
                String::class.java
            )
        )
    }
}