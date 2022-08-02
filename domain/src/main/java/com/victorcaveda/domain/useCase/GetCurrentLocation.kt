package com.victorcaveda.domain.useCase

import com.victorcaveda.domain.model.Location
import javax.inject.Inject

class GetCurrentLocation @Inject constructor() {
    operator fun invoke() =
        Location(43.536900, -5.637167)
}