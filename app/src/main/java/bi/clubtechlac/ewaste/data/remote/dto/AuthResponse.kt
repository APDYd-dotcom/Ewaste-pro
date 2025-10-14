package bi.clubtechlac.ewaste.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
  val access: String,
  val refresh: String
)