package bi.clubtechlac.ewaste.viewmodel

import bi.clubtechlac.ewaste.data.remote.dto.PostRequest
import bi.clubtechlac.ewaste.ui.UiState
import coil.compose.AsyncImagePainter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
  private val repository: PostRequest
) {

  private val _postUiState = MutableStateFlow<UiState<List<PostRequest>>>(UiState.Idle)
  val postUiState = StateFlow<UiState<List<PostRequest>>> = _postUiState
}