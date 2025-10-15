package bi.clubtechlac.ewaste.data.remote

import bi.clubtechlac.ewaste.data.remote.dto.AuthLogin
import bi.clubtechlac.ewaste.data.remote.dto.AuthRegister
import bi.clubtechlac.ewaste.data.remote.dto.AuthResponse
import bi.clubtechlac.ewaste.data.remote.dto.PostRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.*

//class ApiService(private val client: HttpClient) {
//  val baseUrl = "https://ewaste.clubtechlac.bi/api"
//
//  suspend fun register(request: AuthRegister) {
//      val response: HttpResponse = client.post( "$baseUrl/users/"){
//        contentType(ContentType.Application.Json)
//      setBody(request)
//    }
//
//    if (!response.status.isSuccess()) {
//      val errorBody = response.bodyAsText()
//      throw Exception("Registration failed with status: ${response.status}. Details: $errorBody")
//    }
//  }
//
//  suspend fun login(request: AuthLogin): AuthResponse {
//    return client.post("$baseUrl/token/") {
//      contentType(ContentType.Application.Json)
//      setBody(request)
//    }.body()
//  }
//
//
//
//}

class ApiService (private val client: HttpClient) {

  val baseUlr = "https://ewaste.clubtechlac.bi/api"


  suspend fun register(request: AuthRegister) {
    val response: HttpResponse = client.post("$baseUlr/users/") {
        contentType(io.ktor.http.ContentType.Application.Json)
      setBody(request)
    }

    if(!response.status.isSuccess()){
      val errorBody = response.bodyAsText()
      throw Exception("Register failed with status: ${response.status}. Detail: ${errorBody}")
    }
  }


  suspend fun login(request: AuthLogin): AuthResponse {
    return client.post("$baseUlr/token") {
      contentType(io.ktor.http.ContentType.Application.Json)
      setBody(request)
    }.body()
  }


  suspend fun post(request: PostRequest) {
    val response: HttpResponse = client.post("$baseUlr/post/"){
      contentType(io.ktor.http.ContentType.Application.Json)
      setBody(request)
    }

    if(!response.status.isSuccess()){
      val errorBody = response.bodyAsText()
      throw Exception ("Post failed with status: ${response.status}. Detail: $$errorBody}")
    }


    suspend fun getPosts(): List<PostRequest> {
      return client.get("$baseUlr/post/") {
        contentType(io.ktor.http.ContentType.Application.Json)
      }.body()
    }




  }

}