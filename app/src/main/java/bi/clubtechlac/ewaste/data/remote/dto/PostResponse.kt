package bi.clubtechlac.ewaste.data.remote.dto

import bi.clubtechlac.ewaste.data.model.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
  val id: Int,
  val user: User,
  val province: String,
  val commune: String,
  val zone: String,
  val photo: String,
  @SerialName("product_name") val productName: String,
  val kilogramme: String,
  val status: Boolean,
  val description: String
)