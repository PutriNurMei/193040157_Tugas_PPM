package com.example.fungsionalcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import id.ac.unpas.modul4.model.SetoranSampah
import id.ac.unpas.modul4.model.screens.FormPencatatanSampah
import id.ac.unpas.modul4.persistences.AppDatabase
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun PengelolaanDataPenduduk() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pengelolaan-data-penduduk"
    ).build()
    val dataPendudukDao = db.dataPendudukDao()

    val list : LiveData<List<DataPenduduk>> = dataPendudukDao.loadAll()
    val items: List<DataPenduduk> by list.observeAsState(initial = listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        FormPencatatanDataPenduduk(dataPendudukDao)

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->

                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Kelurahan", fontSize = 14.sp)
                        Text(text = item.kelurahan, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Laki-laki", fontSize = 14.sp)
                        Text(text = item.lakilaki, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Perempuan", fontSize = 14.sp)
                        Text(text = item.perempuan, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Jumlah", fontSize = 14.sp)
                        Text(text = item.jumlah, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                }

                Divider(modifier = Modifier.fillMaxWidth())

            })
        }
    }

}