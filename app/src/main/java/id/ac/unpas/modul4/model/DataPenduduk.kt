package id.ac.unpas.modul4.model

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity
data class DataPenduduk(
    @PrimaryKey val id: String,
    val kelurahan: String,
    val lakilaki: String,
    val perempuan: String,
    val jumlah: String
)
