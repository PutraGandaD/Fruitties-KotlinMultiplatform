package com.example.fruitties.kmptutorial.shared.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun appDatabase(context: Context) : AppDatabase {
    val dbFile = context.getDatabasePath("sharedfruits.db")
    return Room
        .databaseBuilder<AppDatabase>(context, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .build()
}