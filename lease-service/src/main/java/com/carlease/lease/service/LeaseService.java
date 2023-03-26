package com.carlease.lease.service;

import com.carlease.lease.service.dto.LeaseCalculationRequest;
import com.carlease.lease.service.dto.LeaseCalculationResponse;

public interface LeaseService {

  LeaseCalculationResponse calculate(String make, String model, LeaseCalculationRequest request);

}
