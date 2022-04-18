package com.krish.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.krish.borutoapp.util.Constants.HERO_REMOTE_KEYS_DATABASE_TABLE

/**
 * we use remote key are the keys which remote mediator uses
 * to tell the backend server which data to load next
 * when we use pagination with database we need this
 *
 * This remote keys will be used to fetch data from the api
 * whenever we need to load more data
 * */

@Entity(tableName = HERO_REMOTE_KEYS_DATABASE_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)
