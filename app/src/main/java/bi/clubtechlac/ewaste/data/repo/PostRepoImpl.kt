package bi.clubtechlac.ewaste.data.repo

import android.util.Log
import bi.clubtechlac.ewaste.data.remote.ApiService
import bi.clubtechlac.ewaste.data.remote.ClientProvider.client
import bi.clubtechlac.ewaste.data.remote.dto.PostRequest
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.contentType



class PostRepoImpl (private val api: ApiService): PostRepo {
  override suspend fun post(request: PostRequest): Result<Unit> {
    return try {
     val response = api.post(request)
      Result.success(response)
    } catch (e: Exception) {
      Log.d("Post failed","Detail: ${e.message}")
      Result.failure(e)
    }
  }


  override suspend fun getPosts(): Result<List<PostRequest>> {
    return try {
      val posts = client.get("$api.baseUlr/post/") {
        contentType(io.ktor.http.ContentType.Application.Json)
      }.body<List<PostRequest>>()
      Result.success(posts)
    } catch (e: Exception) {
      Result.failure(e)
    }
  }
}


