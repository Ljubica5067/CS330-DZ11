package rs.ac.metropolitan.cs330_dz11.data
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rs.ac.metropolitan.cs330_dz11.common.UserItem

interface ApiService {
    @GET(Constants.USERZ_URL)
    suspend fun getUserZ():List<UserItem>

    @POST(Constants.USERZ_URL)
    suspend fun addUser(@Body userItem: UserItem):UserItem

    @DELETE(Constants.USERZ_URL+"/{id}")
    suspend fun  deleteUser(@Path ("id") id:String):UserItem
}