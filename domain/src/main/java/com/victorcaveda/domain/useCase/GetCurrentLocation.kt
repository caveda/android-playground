package com.victorcaveda.domain.useCase

import com.victorcaveda.domain.model.Location
import com.victorcaveda.domain.repository.LocationRepository
import javax.inject.Inject

class GetCurrentLocation @Inject constructor(private val locationRepository: LocationRepository) {

    companion object {
        val DEFAULT_LOCATION = Location(43.536900, -5.637167)
    }

    suspend operator fun invoke() =
        locationRepository.getCurrentLocation() ?: DEFAULT_LOCATION
}