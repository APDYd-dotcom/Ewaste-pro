package bi.clubtechlac.ewaste.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bi.clubtechlac.ewaste.data.TokenManager
import bi.clubtechlac.ewaste.data.remote.dto.AuthLogin
import bi.clubtechlac.ewaste.data.remote.dto.AuthRegister
import bi.clubtechlac.ewaste.data.remote.dto.AuthResponse
import bi.clubtechlac.ewaste.data.repo.AuthRepo
import bi.clubtechlac.ewaste.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
  private val repository: AuthRepo,
  private val tokenManager: TokenManager
): ViewModel() {

  private val _registerUiState = MutableStateFlow<UiState<Unit>>(UiState.Idle)
  val registerUiState : StateFlow<UiState<Unit>> = _registerUiState

  private val _loginUiState = MutableStateFlow<UiState<AuthResponse>>(UiState.Idle)
  val loginUiState : StateFlow<UiState<AuthResponse>> = _loginUiState


  private val _fullName = MutableStateFlow<String?>(null)
  val fullName = _fullName.asStateFlow()

  private val _phoneNumber = MutableStateFlow<String?>(null)
  val phoneNumber = _phoneNumber.asStateFlow()

  private val _password = MutableStateFlow<String?>(null)
  val password = _password.asStateFlow()

  private val _confirmPassword = MutableStateFlow<String?>(null)
  val confirmPassword = _confirmPassword.asStateFlow()

  fun setFullName(value: String) = run { _fullName.value = value }

  fun setPhone(value: String) = run { _phoneNumber.value = value }

  fun setPassword(value: String) = run { _password.value =value }

  fun setConfirmPassword(value: String) = run { _confirmPassword.value = value }



  fun login(request: AuthLogin) {
    viewModelScope.launch {
      _loginUiState.value = UiState.Loading
      val result = repository.login(request)
      result.fold(
        onSuccess = { respo ->
          tokenManager.saveAccessToken(respo.access)
          tokenManager.saveRefreshToken(respo.refresh)
          _loginUiState.value = UiState.Success(respo)
        },
        onFailure = { e ->
          Log.d("AuthViewModel","Login failed: ${e.message}", e)
          _loginUiState.value = UiState.Error("Check connection")

        }
      )
    }
  }




  fun register(
    registerData: AuthRegister,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
  ) {
    viewModelScope.launch {
      if (
        registerData.phone.isBlank() ||
        registerData.fullName.isBlank() ||
        registerData.password.isBlank()
      ) {
        onError("Please fill in required fields.")
        return@launch
      }


      _registerUiState.value = UiState.Loading

      val result = repository.register(registerData)
      result.fold(
        onSuccess = {
          _registerUiState.value = UiState.Success(Unit)
          onSuccess()
        },
        onFailure = { e ->
          _registerUiState.value = UiState.Error(e.message ?: "Unknown error")
          onError(e.message ?: "Unknown error")
        }
      )
    }
  }

  val accessToken = tokenManager.accessToken.stateIn(
    viewModelScope,
    SharingStarted.Lazily,
    null
  )



}