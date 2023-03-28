package com.carlease.lease.service;

import com.carlease.lease.service.dto.LeaseCalculationRequest;
import com.carlease.lease.service.dto.LeaseCalculationResponse;

public interface LeaseService {

  /**
   * Calculates the Lease amount based on the input parameters.
   *
   * @param make The make of the vehicle
   * @param model The model of the vehicle
   * @param request The request object that has the other values required for the calulation
   * @return A response object that includes the result of the calculation
   */
  LeaseCalculationResponse calculate(String make, String model, LeaseCalculationRequest request);

}
