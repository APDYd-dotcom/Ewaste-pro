package bi.clubtechlac.ewaste.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthRegister(
  val id: Int,
  @SerialName("phone_number") val phone: String,
  @SerialName("full_name") val fullName: String,
  val password: String
)

@Serializable
data class AuthLogin(
  @SerialName("phone_number") val phone: String,
  val password: String
)