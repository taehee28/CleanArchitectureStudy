package com.thk.data.model

import com.thk.domain.model.NumberModel

fun NumberEntity.toNumberModel(): NumberModel = NumberModel(this.value)

fun NumberModel.toNumberEntity(): NumberEntity = NumberEntity(value = this.value)