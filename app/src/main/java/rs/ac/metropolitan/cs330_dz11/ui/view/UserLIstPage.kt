package rs.ac.metropolitan.cs330_dz11.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import coil.compose.AsyncImage
import rs.ac.metropolitan.cs330_dz11.common.UserItem

@Composable
fun UserListPage(
    userList: LiveData<List<UserItem>>,
    paddingValues: PaddingValues,
    loadUser: () -> Unit,
    goToDetails: (String) -> Unit
){
    val userZ=userList.observeAsState()

    LaunchedEffect(Unit) {
        loadUser()

    }
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        userZ.value?.let {
            items (it){ user->
                UserCardView(user){
                    goToDetails(it)
                }

            }
        }
    }
}
@Composable
fun UserCardView(user:UserItem,onSelected:(String)->Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onSelected(user.id) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = user.picture,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .width(250.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${user.username} ",
                    fontSize = 18.sp
                )
                Text(
                    text = "Sex: ${user.sex}", color = Color.Gray,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = "Preference: ${user.preference}", color = Color.Gray,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = "From: ${user.city}, ${user.state}", color = Color.Gray,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = "Description: ${user.description}", color = Color.Gray,
                    modifier = Modifier.padding(4.dp)
                )
            }


        }
    }
}

@Preview
@Composable
fun UserListViewPreview() {
    UserListPage(
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
                )
            )),
        paddingValues = PaddingValues(8.dp),
        loadUser = {},
        goToDetails = {}
    )
}