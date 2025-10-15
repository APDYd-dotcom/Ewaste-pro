package bi.clubtechlac.ewaste.data.repo

import bi.clubtechlac.ewaste.data.remote.dto.AuthLogin
import bi.clubtechlac.ewaste.data.remote.dto.AuthRegister
import bi.clubtechlac.ewaste.data.remote.dto.AuthResponse

interface AuthRepo {
  suspend fun register(request: AuthRegister): Result<Unit>
  suspend fun login(request: AuthLogin): Result<AuthResponse>
}