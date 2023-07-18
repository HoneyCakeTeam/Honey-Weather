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
        leadingIcon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search Icon", tint = Color.White) },
        onValueChange = {
            searchText = it
        },
        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
        label = { Text(text = "Search", color = Color.White) },
        placeholder = { Text(text = "Search something here...") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.LightGray,
            focusedLabelColor = Color.LightGray,
            cursorColor = Color.LightGray,
            leadingIconColor = Color.LightGray
        ),
        maxLines = 1,
        singleLine = true,
    )
}