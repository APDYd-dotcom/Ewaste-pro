package bi.clubtechlac.ewaste.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
  val id: Int,
  @SerialName("company_name") val name: String,
  val slogan: String? = null,
  @SerialName("established_year") val year: Int? = null,
  val description: String? = null,
  val logo: String
)

@Serializable
data class Ewaste(
  val id: Int,
  @SerialName("product_name") val name: String,
  val price: String,
  val category: String,
  val company: Company,
  val tax: String? = "",
  val transport: String? = "",
  @SerialName("product_photo") val image: String,
)