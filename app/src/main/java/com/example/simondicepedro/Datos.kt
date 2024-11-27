package com.example.simondicepedro

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class DataRecord(var record: Int)

class RecordRepository {
    private val _record = MutableStateFlow(DataRecord(0)) // MutableStateFlow se usa para emitir y modificar el valor.
    val record: Flow<DataRecord> get() = _record // Exponemos el flujo para que otros puedan observarlo.

    /**
     * Incrementa el valor del record actual.
     */
    fun incrementarRecord() {
        _record.value = DataRecord(_record.value.record + 1)
    }
}