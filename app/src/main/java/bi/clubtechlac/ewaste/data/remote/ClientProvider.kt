package bi.clubtechlac.ewaste.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ClientProvider {
  val client = HttpClient(CIO){
    install(ContentNegotiation){
      json(Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
      })
      defaultRequest {
       header("content-Type", "Application/Json")
      }
    }
  }
}