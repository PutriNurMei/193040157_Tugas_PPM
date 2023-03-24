package id.ac.unpas.modul4.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.modul4.model.DataPenduduk

@Database(entities = [DataPenduduk::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataPendudukDao(): DataPendudukDao
}