package bi.clubtechlac.ewaste.ui.app.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import bi.clubtechlac.ewaste.ui.app.components.TextHeadComponent
import bi.clubtechlac.ewaste.ui.app.components.TextNormComponent
import bi.clubtechlac.ewaste.data.model.Ewaste
import bi.clubtechlac.ewaste.ui.theme.FontSizes
import bi.clubtechlac.ewaste.ui.theme.Spacings
import bi.clubtechlac.ewaste.viewmodel.EwasteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Descr(
  onHomeClick: () -> Unit,
  ewaste: Ewaste?,
  ewasteViewModel: EwasteViewModel,
  navController: NavController

){

  Scaffold(
    topBar = {
      TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor =  MaterialTheme.colorScheme.background),
        title = {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            IconButton(onClick = onHomeClick) {
              Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "App Logo",
                modifier = Modifier.size(size = 32.dp)
              )
            }
            TextHeadComponent(value = "Detail")
          }
        }
      )
    }
  ) { innerpadding ->
    val ewastes = ewasteViewModel.ewastes
    val relatedEwastes = ewastes.filter { it.name == ewaste?.name && it.id != ewaste.id }

    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerpadding)
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
      Row {
        AsyncImage(
          model = ewaste?.image,
          contentDescription = ewaste?.name,
          contentScale = ContentScale.Crop,
          modifier = Modifier
            .weight(1f)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.weight(weight = 0.09f))
        Column(
          modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterVertically),
        ) {
          TextNormComponent(
            value = ewaste?.name ?: "Ewaste inconnu"
          )
          Spacer(modifier = Modifier.height(4.dp))
          TextNormComponent(
            value = ewaste?.category ?: "None"
          )
          Spacer(modifier = Modifier.height(8.dp))
          TextNormComponent(
            value = ewaste?.price.toString()
          )
        }

      }
      Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
      ) {
        Text(text = "Track", fontSize = FontSizes.caption())
      }
      // Divider
      Spacer(modifier = Modifier.height(32.dp))
      Text(
        text = "De la même catégorie",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(vertical = 8.dp)
      )

      // Related Products
      RelatedProducts(ewastes = relatedEwastes, navController = navController)
    }

  }
}

@Composable
fun RelatedProducts(
  navController: NavController,
  ewastes: List<Ewaste>
) {
  Column(verticalArrangement = Arrangement.spacedBy(Spacings.large())) {
    ewastes.chunked(2).forEach { rowItems ->
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Spacings.large())
      ) {
        rowItems.forEach { ewaste ->
          EwasteImageItem(
              ewaste = ewaste,
            navController = navController,
            modifier = Modifier.weight(1f)
          )
        }
        if (rowItems.size == 1) {
          Spacer(modifier = Modifier.weight(1f))
        }
      }
    }
  }
}


@Composable
fun EwasteImageItem(
  ewaste: Ewaste,
  navController: NavController,
  modifier: Modifier = Modifier
) {
  Card(
    shape = RoundedCornerShape(8.dp),
    modifier = modifier
      .aspectRatio(1f)
      .clickable {
        navController.navigate("descr/${ewaste.id}") {
          popUpTo(-1)
        }
      }
  ) {
    AsyncImage(
      model = ewaste.image,
      contentDescription = ewaste.name,
      contentScale = ContentScale.Crop,
      modifier = Modifier.fillMaxSize()
    )
  }
}
