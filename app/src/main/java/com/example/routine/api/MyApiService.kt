package com.example.routine.api
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MyApiService {
    // CRUD endpoints for User
    @POST("users")
    suspend fun createUser(@Body user: User): User

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): User

    @PUT("users/{username}")
    suspend fun updateUser(@Path("username") username: String, @Body user: User): User

    @DELETE("users/{username}")
    suspend fun deleteUser(@Path("username") username: String)

    // CRUD endpoints for Event
    @POST("events")
    suspend fun createEvent(@Body event: Event): Event

    @GET("events")
    suspend fun getEvents(): List<Event>

    @GET("events/{id}")
    suspend fun getEvent(@Path("id") title: String): Event

    @PUT("events/{id}")
    suspend fun updateEvent(@Path("title") title: String, @Body event: Event): Event

    @DELETE("events/{id}")
    suspend fun deleteEvent(@Path("title") title: String)

    // CRUD endpoints for Task
    @POST("tasks")
    suspend fun createTask(@Body task: Task): Task

    @GET("tasks")
    suspend fun getTasks(): List<Task>

    @GET("tasks/{id}")
    suspend fun getTask(@Path("id") id: Int): Task

    @PUT("tasks/{id}")
    suspend fun updateTask(@Path("id") id: String, @Body task: Boolean): Task

    @DELETE("tasks/{id}")
    suspend fun deleteTask(@Path("id") id: Int)
}