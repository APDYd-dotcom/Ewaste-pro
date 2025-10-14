package bi.clubtechlac.ewaste.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bi.clubtechlac.ewaste.data.model.Ewaste
import bi.clubtechlac.ewaste.data.repository.EwasteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EwasteViewModel @Inject constructor(
  private val ewasteRepository: EwasteRepository
) : ViewModel() {

  var ewastes by mutableStateOf<List<Ewaste>>(emptyList())
    private set

  var filteredEwastes by mutableStateOf<List<Ewaste>>(emptyList())
    private set

  var searchQuery by mutableStateOf("")

  var isLoading by mutableStateOf(false)
    private set

  fun loadEwaste() {
    viewModelScope.launch {
      isLoading = true
      ewastes = ewasteRepository.getEwastes()
      isLoading = false
    }
  }

  fun onSearch(query: String) {
    searchQuery = query
    filteredEwastes = if (query.isBlank()) {
      ewastes
    } else {
      ewastes.filter {
        it.name.contains(query, ignoreCase = true)
      }
    }
  }
}

