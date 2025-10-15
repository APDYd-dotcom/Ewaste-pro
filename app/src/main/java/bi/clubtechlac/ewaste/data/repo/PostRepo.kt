package bi.clubtechlac.ewaste.data.repo

import bi.clubtechlac.ewaste.data.remote.dto.PostRequest

interface PostRepo {
  suspend fun post(request: PostRequest): Result<Unit>

  suspend fun getPosts(): Result<List<PostRequest>>
}