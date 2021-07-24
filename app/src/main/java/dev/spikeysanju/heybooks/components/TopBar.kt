package dev.spikeysanju.heybooks.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.spikeysanju.heybooks.R
import dev.spikeysanju.heybooks.navigation.MainActions
import dev.spikeysanju.heybooks.ui.theme.typography

@Composable
fun TopBar(title:String, action: MainActions){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 16.dp, end = 16.dp),horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(R.string.text_back_button), modifier = Modifier.clickable(onClick = action.upPress))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title, style = typography.h5, color = MaterialTheme.colors.primaryVariant)

    }
}