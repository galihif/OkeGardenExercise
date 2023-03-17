package com.example.okegardenexercise.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun CityNameDropdown(
    modifier: Modifier = Modifier,
    options: List<String> = listOf("Kuala Lumpur", "Singapore"),
    selectedOption: String = "",
    onOptionSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        // text field
        OutlinedTextField(
            value = if (selectedOption == "") "" else selectedOption,
            onValueChange = {},
            placeholder = { Text(text = "City Name") },
            readOnly = true,
            label = { Text(text = "City Name") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth()
        )
        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { selected ->
                // menu item
                DropdownMenuItem(onClick = {
                    onOptionSelected(selected)
                    expanded = false
                }) {
                    Text(text = selected)
                }
            }
        }
    }
}