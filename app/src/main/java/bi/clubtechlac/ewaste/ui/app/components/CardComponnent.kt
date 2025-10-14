package bi.clubtechlac.ewaste.ui.app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import bi.clubtechlac.ewaste.data.model.Ewaste


@Composable
fun EwasteCard(
  ewaste: Ewaste,
  navController: NavController,
){
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .width(IntrinsicSize.Max)
        .clickable { navController.navigate("descr/${ewaste.id}") },
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
              model = ewaste.image,
              contentDescription = ewaste.name,
              contentScale = ContentScale.Crop,
              modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = ewaste.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = ewaste.category, fontSize = 14.sp, color = Color.Gray)
            Text(text = "Quantit: ${ewaste.price}", fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(8.dp))

            Button(
              onClick = {},
              modifier = Modifier.align(Alignment.End)
            ) {
              Text("Track")
            }
          }
        }

}

private fun NavController.Companion.navigate(string: String) {}
