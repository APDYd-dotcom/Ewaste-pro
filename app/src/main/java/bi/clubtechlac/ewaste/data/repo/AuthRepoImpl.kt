package bi.clubtechlac.ewaste.data.repo

import android.util.Log
import bi.clubtechlac.ewaste.data.remote.ApiService
import bi.clubtechlac.ewaste.data.remote.dto.AuthLogin
import bi.clubtechlac.ewaste.data.remote.dto.AuthRegister
import bi.clubtechlac.ewaste.data.remote.dto.AuthResponse

class AuthRepoImpl(private val api: ApiService): AuthRepo {
  override suspend fun register(request: AuthRegister): Result<Unit> {
    return try {
      api.register(request)
      Result.success(Unit)
    } catch (e: Exception) {
      Log.d("Error register","Error register: ${e.message}")
      Result.failure(e)
    }
  }

  override suspend fun login(request: AuthLogin): Result<AuthResponse> {
    return try {
      val response = api.login(request)
      Result.success(response)
    } catch (e: Exception) {
      Log.d("Error register","Error register: ${e.message}")
      Result.failure(e)
    }
  }

}