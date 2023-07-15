package ui.composable

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import ui.theme.DarkBlue

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        modifier = modifier,
        value = searchText,
        leadingIcon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search Icon") },
        onValueChange = {
            searchText = it
        },
        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
        label = { Text(text = "Search") },
        placeholder = { Text(text = "Search something here...") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = DarkBlue,
            focusedLabelColor = DarkBlue,
            cursorColor = DarkBlue,
            leadingIconColor = DarkBlue
        ),
        maxLines = 1,
        singleLine = true,
    )
}