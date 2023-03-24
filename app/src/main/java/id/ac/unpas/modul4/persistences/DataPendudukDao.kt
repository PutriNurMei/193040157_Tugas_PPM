package id.ac.unpas.modul4.persistences

import androidx.room.*
import androidx.lifecycle.LiveData
import id.ac.unpas.modul4.model.DataPenduduk

@Dao
interface DataPendudukDao {
    @Query("SELECT * FROM DataPenduduk")
    fun loadAll(): LiveData<List<DataPenduduk>>
    @Query("SELECT * FROM DataPenduduk WHERE id = :id")
    fun find(id: String): DataPenduduk?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: DataPenduduk)
    @Delete
    fun delete(item: DataPenduduk)
}