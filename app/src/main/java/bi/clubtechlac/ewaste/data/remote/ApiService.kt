package bi.clubtechlac.ewaste.data.remote

import bi.clubtechlac.ewaste.data.remote.dto.AuthRegister
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.HttpResponse


class ApiService(private val client: HttpClient) {
  val baseUrl = "https://ewaste.clubtechlac.bi/api"

  suspend fun register(request: AuthRegister) {
      val response: HttpResponse = client.post( "$baseUrl/users/"){
      contentType(ContentType.Application.Json)
      setBody(request)
    }

    if (!response.status.isSuccess()) {
      val errorBody = response.bodyAsText()
      throw Exception("Registration failed with status: ${response.status}. Details: $errorBody")
    }
  }




}