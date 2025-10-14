package bi.clubtechlac.ewaste.data.remote.dto

import bi.clubtechlac.ewaste.data.model.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
  val id: Int,
  val user: User,
  val province: String,
  val commune: String,
  val zone: String,
  val photo: String,
  @SerialName("product_name") val productName: String,
  val kilogramme: String,
  val Status: Boolean,
  val description: String
)