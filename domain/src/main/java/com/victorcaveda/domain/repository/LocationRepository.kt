package com.victorcaveda.domain.repository

import com.victorcaveda.domain.model.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location?
}