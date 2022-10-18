package pl.put.bugfarm.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.put.bugfarm.localdata.dao.UserRepository
import pl.put.bugfarm.localdata.dao.UserRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val userRepository: UserRepositoryImpl):ViewModel(){
    fun signUp(name:String,pass:String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                userRepository.addUser(name,pass)
            }
            catch (e:Exception){
                Log.d("apap",e.message.toString())
            }
        }
    }
}