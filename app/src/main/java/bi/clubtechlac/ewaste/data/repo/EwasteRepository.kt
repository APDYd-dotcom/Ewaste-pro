package bi.clubtechlac.ewaste.data.repo


import bi.clubtechlac.ewaste.data.model.Ewaste
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import javax.inject.Inject

class EwasteRepository @Inject constructor(
  private val client: HttpClient
) {
  suspend fun getEwastes(): List<Ewaste> {
    return try {
      println("🔎 Calling ewaste API...")
      val response: HttpResponse = client.get("https://mib.vovota.bi/api/product/")
      println("✅ Response: ${response.status}")
      val rawJson = response.bodyAsText()
      println("📦 Body: $rawJson")

      val products = Json.decodeFromString<List<Ewaste>>(rawJson)
      println("✅ Ewaste loaded: ${products.size}")
      products
    } catch (e: Exception) {
      println("❌ Exception: ${e.message}")
      emptyList()
    }
  }
}
