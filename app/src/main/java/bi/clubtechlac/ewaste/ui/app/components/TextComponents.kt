package bi.clubtechlac.ewaste.ui.app.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

/*HeaderText Components*/
@Composable
fun TextHeadComponent(value: String){
    Text(
        text = value,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineSmall
    )
}

/*NormalText Components*/
@Composable
fun TextNormComponent(value: String){
    Text(
        text = value,
        fontWeight = FontWeight.Normal,
        style = MaterialTheme.typography.bodyLarge
    )
}

/*MediumText Components*/
@Composable
fun TextMediumComponent(value: String){
    Text(
        text = value,
        fontWeight = FontWeight.Normal,
        style = MaterialTheme.typography.headlineSmall
    )
}

/*NormalText Components Link*/
@Composable
fun TextNormComponentLink(value: String){
    Text(
        text = value,
        fontWeight = FontWeight.Normal,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.primary
    )
}


@Preview(showBackground = true)
@Composable
fun OutPreview(){
    TextMediumComponent(value = "Text")
}