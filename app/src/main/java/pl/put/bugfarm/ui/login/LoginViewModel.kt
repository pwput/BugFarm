package pl.put.bugfarm.ui.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.put.bugfarm.localdata.dao.UserRepository
import pl.put.bugfarm.localdata.dao.UserRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepositoryImpl):ViewModel() {

    val isLogged = mutableStateOf(false)

    fun validateUser(name: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            isLogged.value = (userRepository.validateUser(name, password) == name)
        }
    }
}


