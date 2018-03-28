package com.prosegur.rulesEngine.services.soapService.model.mapper;

import java.util.List;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;
import com.prosegur.rulesEngine.factsmodel.costeo.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.costeo.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.costeo.FactItemDeCosto;
import com.prosegur.rulesEngine.factsmodel.costeo.FactMedioAuxiliar;
import com.prosegur.rulesEngine.factsmodel.costeo.FactOT;
import com.prosegur.rulesEngine.factsmodel.costeo.FactRequest;
import com.prosegur.rulesEngine.services.soapService.model.EscalaXCategoria;
import com.prosegur.rulesEngine.services.soapService.model.ItemDeCosto;
import com.prosegur.rulesEngine.services.soapService.model.MedioAuxiliar;
import com.prosegur.rulesEngine.services.soapService.model.RequestCosteo;
import com.prosegur.rulesEngine.services.soapService.model.ResponseCosteo;


public class Mapper {
	
	public static FactRequest parse(RequestCosteo request) {
		FactRequest factRequest = new FactRequest();
		/**
		 * Llamada a metodo mapper; clase origen, clase destino y mapper usado en dozerMapping
		 */
		MapeoEntidades.getMapper().map(request, factRequest, "request");
		/**
		 * Copia de objetos
		 */
	//	Mapper.parseEsquemasOperativos(factRequest.getOt(), factRequest.getEsquemasOperativos());
	//	Mapper.parseEscalasXcategorias(request.getEscalasXcategorias(), factRequest.getEscalasXcategorias());
	//	Mapper.parseItemsDeCosto(request.getItemsDeCosto(), factRequest.getItemsDeCosto());
	//	Mapper.parseMediosAuxiliares(request.getMediosAuxiliares(), factRequest.getMediosAuxiliares());
		return factRequest;
	}
	
	public static ResponseCosteo formatResponse (RequestCosteo requestCosteo, List<DetalleCosteo> detallesCosteo) {
    	ResponseCosteo response = new ResponseCosteo();
    	/**
		 * Llamada a metodo mapper; clase origen, clase destino y mapper usado en dozerMapping
		 */
		MapeoEntidades.getMapper().map(requestCosteo, response, "response");
		
		//response.setDetallesCosteo (detallesCosteo);
		
    	return response;
    }
	
	public static void parseEsquemasOperativos(FactOT factOt, List<FactEsquemaOperativo> esquemasOperativos) {
    	for (int i=0;i<esquemasOperativos.size();i++) {
    		esquemasOperativos.get(i).setOt(factOt);
    	}
	}
	
	public static void parseEscalasXcategorias(List<EscalaXCategoria> escalasXcategorias,List<FactEscalaXCategoria> factsEscalasXcategorias) {
    	for (int i=0;i<factsEscalasXcategorias.size();i++) {
    		factsEscalasXcategorias.get(i).setIdEscala(escalasXcategorias.get(i).getEscala().getId());
    		factsEscalasXcategorias.get(i).setIdTipoPuesto(escalasXcategorias.get(i).getTipoPuesto().getId());
    		factsEscalasXcategorias.get(i).setIdCategoriaSalarial(escalasXcategorias.get(i).getCategoriaSalarial().getId());
    	}
    }
	
	public static void parseItemsDeCosto(List<ItemDeCosto> itemsDeCosto,List<FactItemDeCosto> factItemDeCostoDetalle) {
 
    	for (int i=0;i<itemsDeCosto.size();i++) {
	    	
	    	factItemDeCostoDetalle.get(i).setId(itemsDeCosto.get(i).getId());
	    	factItemDeCostoDetalle.get(i).setDescripcion(itemsDeCosto.get(i).getDescripcion());
    	}
    }
	
	 public static void parseMediosAuxiliares(List<MedioAuxiliar> mediosAuxiliares,List<FactMedioAuxiliar> factsMediosAuxiliares) {

	    	for (int i=0;i<mediosAuxiliares.size();i++) {
	    		factsMediosAuxiliares.get(i).setId (mediosAuxiliares.get(i).getId());
	        	factsMediosAuxiliares.get(i).setDescripcion (mediosAuxiliares.get(i).getDescripcion());
	    	}
	    	
	    }
    
}

