package com.prosegur.rulesEngine.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;
import com.prosegur.rulesEngine.factsmodel.costeo.FactRequest;
import com.prosegur.rulesEngine.services.exception.ServiceException;

@Service
public interface EngineServices {

	public List<DetalleCosteo> executeCosteo (FactRequest request, String pais, String simulador) throws ServiceException;
}
