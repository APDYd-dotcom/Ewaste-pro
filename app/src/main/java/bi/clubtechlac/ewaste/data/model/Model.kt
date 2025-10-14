package bi.clubtechlac.ewaste.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
  val id: Int,
  @SerialName("phone_number") val phone: String,
  @SerialName("full_name") val fullName: String
)