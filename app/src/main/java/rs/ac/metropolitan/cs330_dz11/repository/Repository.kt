package rs.ac.metropolitan.cs330_dz11.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import rs.ac.metropolitan.cs330_dz11.common.UserItem
import rs.ac.metropolitan.cs330_dz11.data.RetrofitHelper
import rs.ac.metropolitan.cs330_dz11.data.ApiService


class Repository {

    var userzFlow: Flow<List<UserItem>> = flowOf( listOf())

    suspend fun loadUserz(){
        val apiService= RetrofitHelper.getInstance().create(ApiService::class.java)
        val result=apiService.getUserZ()
        userzFlow= flowOf(result)
    }
    suspend fun submitUser(userItem: UserItem){
        val apiService=RetrofitHelper.getInstance().create(ApiService::class.java)
        val resutlt=apiService.addUser(userItem)
    }
    suspend fun deleteUser(id: String){
        val apiService=RetrofitHelper.getInstance().create(ApiService::class.java)
        val result=apiService.deleteUser(id)
    }
}