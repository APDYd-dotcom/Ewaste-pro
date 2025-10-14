package bi.clubtechlac.ewaste.ui.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bi.clubtechlac.ewaste.ui.app.components.TextHeadComponent

@Composable
fun Profile(){
  Scaffold(
    modifier = Modifier.fillMaxSize()
      .background(color = MaterialTheme.colorScheme.background)
      .padding(8.dp)
  ) { padding ->
    Column(
      modifier = Modifier.fillMaxSize()
        .padding(padding)
    ) {
      Spacer(modifier = Modifier.height(height = 25.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
      ){
        TextHeadComponent(value = "WellCom")
      }

      Spacer(modifier = Modifier.height(height = 30.dp))
      Row(){

      }

    }

  }
}

@Preview
@Composable()
fun red(){
  Profile()
}