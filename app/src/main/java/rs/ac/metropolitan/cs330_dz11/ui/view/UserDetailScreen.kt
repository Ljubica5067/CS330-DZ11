package rs.ac.metropolitan.cs330_dz11.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import rs.ac.metropolitan.cs330_dz11.common.UserItem

@Composable
fun UserDetailScreen(
    userItem: UserItem?,
    goBack:()->Unit,
    deleteUser:()->Unit
){
    UserBasicData(user = userItem, goBack = goBack,deleteUser=deleteUser)
}
@Composable
fun UserBasicData(user:UserItem?,goBack: () -> Unit,deleteUser: () -> Unit){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ){
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
            Text(text = "User details", style = MaterialTheme.typography.titleLarge, modifier = Modifier.align(Alignment.Center))
            IconButton(
                modifier = Modifier
                    .scale(1.5f)
                    .align(Alignment.BottomEnd),
                onClick = { deleteUser() }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
        user?.let{
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                AsyncImage(
                    model = it.picture,
                    contentDescription = null,
                    modifier = Modifier
                        .size(240.dp)
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
}

@Preview
@Composable
fun UserDetailScreenPreview(){
    UserDetailScreen(userItem =
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
        goBack = {},
        deleteUser = {}
    )
}