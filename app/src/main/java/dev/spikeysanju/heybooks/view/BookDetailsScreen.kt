package dev.spikeysanju.heybooks.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.spikeysanju.heybooks.R
import dev.spikeysanju.heybooks.components.BookDetailsCard
import dev.spikeysanju.heybooks.components.TopBar
import dev.spikeysanju.heybooks.navigation.MainActions
import dev.spikeysanju.heybooks.ui.theme.typography
import dev.spikeysanju.heybooks.utils.DetailViewState
import dev.spikeysanju.heybooks.viewmodel.MainViewModel


@Composable
fun BookDetailsScreen(viewModel: MainViewModel, actions: MainActions) {


    Scaffold(topBar = {
        TopBar(title = stringResource(id = R.string.text_bookDetails), action = actions)
    }) {

        BookDetails(viewModel = viewModel)
    }

}

@Composable
fun BookDetails(viewModel: MainViewModel) {
    when (val result = viewModel.bookDetails.value) {
        DetailViewState.Loading -> Text(text = "Loading")
        is DetailViewState.Error -> Text(text = "Error found: ${result.exception}")
        is DetailViewState.Success -> {
            val book = result.data

            LazyColumn {
                // Book Details Card
                item {
                    BookDetailsCard(book.title, book.authors, book.thumbnailUrl, book.categories)
                }

                // Description
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = stringResource(id = R.string.text_bookDetails),
                        style = typography.subtitle1,
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = book.longDescription,
                        style = typography.body1,
                        textAlign = TextAlign.Justify,
                        color = MaterialTheme.colors.primaryVariant.copy(0.7F),
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                    )
                }
            }

        }
        DetailViewState.Empty -> Text("No results found!")
    }
}