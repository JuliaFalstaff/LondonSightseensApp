//package com.example.londonsightseensapp.model.room
//
//import androidx.room.*
//
//@Dao
//interface PropertiesDAO {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertProperty(property: RoomProperties)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAllProperties(properties: List<RoomProperties>)
//
//    @Query("SELECT * FROM RoomProperties")
//    fun getAll(): List<RoomProperties>
//
//    @Delete
//    fun deleteProperty(property: RoomProperties)
//
//    @Delete
//    fun deletePropertiesList(properties: List<RoomProperties>)
//
//    @Update
//    fun updatePropertiesList(properties: List<RoomProperties>)
//
//    @Update
//    fun updateProperty (property: RoomProperties)
//
//    @Query("SELECT * FROM RoomProperties WHERE xid = :propertyId LIMIT 1")
//    fun findById(propertyId: String) : RoomProperties?
//
//    @Query("SELECT * FROM RoomProperties WHERE name = :propertyName LIMIT 1")
//    fun findByName(propertyName: String) : RoomProperties?
//}