package rs.ac.metropolitan.cs330_dz11.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.ac.metropolitan.cs330_dz11.common.Common
import rs.ac.metropolitan.cs330_dz11.common.UserItem
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewUserScreen(
    paddingValues: PaddingValues = PaddingValues(16.dp),
    submitUser: (UserItem) -> Unit,
    goBack: () -> Unit,
) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var sex = listOf("Male", "Female")
    var selectedSex by remember {mutableStateOf("")}
    var preference = listOf("Male", "Female")
    var selectedPreference by remember {mutableStateOf("")}
    var city by remember { mutableStateOf(TextFieldValue("")) }
    var state by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(paddingValues)
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(1.5f),
                        onClick = { goBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        text = "New user", style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            item {
                TextField(
                    value = username,
                    onValueChange = { newText ->
                        username = newText
                    },
                    label = { Text("Username") },
                    placeholder = { Text("Enter your username") },
                )
            }
            item {
                SegmentedControl(
                    items = sex,
                    defaultSelectedItemIndex = 0,
                ) { index ->
                    selectedSex = if (index == 0) "Male" else "Female"
                }
            }
            item {
                SegmentedControl(
                    items = preference,
                    defaultSelectedItemIndex = 0,
                ) { index ->
                    selectedPreference = if (index == 0) "Male" else "Female"
                }
            }
            item {
                TextField(
                    value = city,
                    onValueChange = { newText ->
                        city = newText
                    },
                    label = { Text("City") },
                    placeholder = { Text("Enter your city") },
                )
            }
            item {
                TextField(
                    value = state,
                    onValueChange = { newText ->
                        state = newText
                    },
                    label = { Text("State") },
                    placeholder = { Text("Enter your state") },
                )
            }
            item {
                TextField(
                    value = description,
                    onValueChange = { newText ->
                        description = newText
                    },
                    label = { Text("Description") },
                    placeholder = { Text("Enter your description") },
                )
            }
            item{
                Button(onClick = {
                    submitUser(
                        UserItem(
                            id= UUID.randomUUID().toString(),
                            username=username.text,
                            sex=selectedSex,
                            preference = selectedPreference,
                            city = city.text,
                            state=state.text,
                            description = description.text,
                            picture = Common.generateImage("${username.text}")
                                .toString()
                        )
                    )
                    goBack()
                }){
                    Text(text = "Submit")
                }
            }
        }

    }
}

@Preview
@Composable
fun NewUserScreenPreview() {
    NewUserScreen(
        paddingValues = PaddingValues(0.dp),
        submitUser = {},
        goBack = {}
    )
}