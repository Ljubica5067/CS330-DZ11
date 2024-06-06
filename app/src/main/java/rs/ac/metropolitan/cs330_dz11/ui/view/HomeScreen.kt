package rs.ac.metropolitan.cs330_dz11.ui.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import rs.ac.metropolitan.cs330_dz11.common.UserItem
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    userList: LiveData<List<UserItem>>,
    loadUser: () -> Unit,
    goToNewUser: () -> Unit,
    goToDetails: (String) -> Unit

) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Users") })
    },
        floatingActionButton = {
            FloatingActionButton(onClick = { goToNewUser() }) {
                Icon(Icons.Filled.Add, contentDescription = "Add student")
            }
        }) { innerPadding ->
        UserListPage(
            userList = userList,
            paddingValues = innerPadding,
            loadUser = loadUser,
            goToDetails = goToDetails
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        userList = MutableLiveData(
            listOf(
                UserItem(
                    "1",
                    "",
                    "johnDoe",
                    "Belgrade",
                    "Serbia",
                    "Male",
                    "Female",
                    "Very Handsome,Fun,Loving"
                ),
                UserItem(
                    "2",
                    "",
                    "janeDoe",
                    "Belgrade",
                    "Serbia",
                    "Female",
                    "Male",
                    "Smart,Fun,Loving"
                ))),
        loadUser = {},
        goToNewUser = {},
        goToDetails = {}
    )
}