package com.prosegur.rulesEngine.factsmodel.costeo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

public class Costeo {
	private static final Logger log = LoggerFactory.getLogger(Costeo.class);
	
	@Getter
	private List<DetalleCosteo> detalles = new ArrayList<DetalleCosteo>();
	
	private HashMap<String, Agrupacion> agrupaciones = new HashMap<String, Agrupacion>();
	private HashMap<String, Double> acumuladores = new HashMap<String, Double>();

	public void setAcumulador (String clave, double valor) {
		acumuladores.put(clave, valor);
	}

	public void setAcumulador (Acum acumulador, double valor) {
		acumuladores.put(acumulador.getName(), valor);
	}

	public void setAcumulador (Acum acumulador, String idTipoPuesto, String idCategoriaSalarial, double valor) {
		setAcumulador (componeClave(acumulador, idTipoPuesto, idCategoriaSalarial), valor);
	}	

	public void setAcumulador (Acum acumulador, String idTipoPuesto, String idCategoriaSalarial, int idEsquemaOperativo, double valor) {
		setAcumulador (componeClave(acumulador, idTipoPuesto, idCategoriaSalarial, idEsquemaOperativo), valor);
	}	
	
	private void addAcumulador (String clave, double valor) {
		double valorAcum = getAcumulador(clave);
		if (log.isTraceEnabled()) {
			log.trace("KnowledgeRuntime.Costeo.addAcumulador '" + clave + "': " + valorAcum + " + " + valor + " = " + (valorAcum + valor));
		}		
		valorAcum += valor;
		acumuladores.put(clave, valorAcum);
	}
	
	public void addAcumulador (Acum acumulador, double valor) {
		addAcumulador (acumulador.getName(), valor);
	}

	public void addAcumulador (Acum acumulador, String idTipoPuesto, String idCategoriaSalarial, double valor) {
		addAcumulador (componeClave(acumulador, idTipoPuesto, idCategoriaSalarial), valor);
	}	

	public void addAcumulador (Acum acumulador, String idTipoPuesto, String idCategoriaSalarial, int idEsquemaOperativo, double valor) {
		addAcumulador (componeClave(acumulador, idTipoPuesto, idCategoriaSalarial, idEsquemaOperativo), valor);
	}	

	private double getAcumulador (String clave) {
		Double valor = acumuladores.get(clave);
		
		if(valor!=null){
			return valor.doubleValue();
		}
		
		return 0;
	}
	
	public double getAcumulador (Acum acumulador) {
		return getAcumulador (acumulador.getName());
	}	
	
	public double getAcumulador (Acum acumulador, String idTipoPuesto, String idCategoriaSalarial) {
		return getAcumulador (componeClave(acumulador, idTipoPuesto, idCategoriaSalarial));
	}
	
	public double getAcumulador (Acum acumulador, String idTipoPuesto, String idCategoriaSalarial, int idEsquemaOperativo) {
		return getAcumulador (componeClave(acumulador, idTipoPuesto, idCategoriaSalarial, idEsquemaOperativo));
	}
	
	private String componeClave (Acum acumulador, String idTipoPuesto, String idCategoriaSalarial) {
		return acumulador.getName() + "_idTipoPuesto_" + idTipoPuesto + "_idCategoria_" + idCategoriaSalarial;
	}

	private String componeClave (Acum acumulador, String idTipoPuesto, String idCategoriaSalarial, int idEsquemaOperativo) {
		return acumulador.getName() + "_idTipoPuesto_" + idTipoPuesto + "_idCategoria_" + idCategoriaSalarial + "_idEsquema_" + idEsquemaOperativo;
	}
	
	private Agrupacion getAgrupacion (String clave) {
		Agrupacion agrupacion = agrupaciones.get(clave);
		
		return agrupacion;
	}
	
	private String componeClave (String idTipoPuesto, String idCategoriaSalarial) {
		return "Agrupacion" + "_idTipoPuesto_" + idTipoPuesto + "_idCategoria_" + idCategoriaSalarial;
	}
	
	public Agrupacion getAgrupacion (String idTipoPuesto, String idCategoriaSalarial) {
		return getAgrupacion (componeClave(idTipoPuesto, idCategoriaSalarial));
	}
	
	public Agrupacion createAgrupacion (String idTipoPuesto, String idCategoriaSalarial) {
		Agrupacion agrupacion = new Agrupacion();
		agrupaciones.put(componeClave(idTipoPuesto, idCategoriaSalarial), agrupacion);
		
		return agrupacion;
	}

	public void addDetalle (DetalleCosteo detalle) {
			/*if(detalle.getCodigoAgrupacion1()!=null && detalle.getCodigoAgrupacion1().length()>15){
				detalle.setCodigoAgrupacion1(detalle.getCodigoAgrupacion1().substring(0, 15));
				System.out.println("auxiliar 1 => " + detalle.getCodigoAgrupacion1());
			}
			if(detalle.getCodigoAgrupacion2()!=null &&detalle.getCodigoAgrupacion2().length()>15){
				detalle.setCodigoAgrupacion2(detalle.getCodigoAgrupacion2().substring(0, 15));
				System.out.println("auxiliar 2 => " + detalle.getCodigoAgrupacion2());
			}
			
			if(detalle.getDescripcion()!=null &&detalle.getDescripcion().length()>100){
				detalle.setDescripcion(detalle.getDescripcion().substring(0, 100));
				System.out.println("Descripcion  => " + detalle.getDescripcion());
			}*/
			
			detalle.setValor1(Math.round(detalle.getValor1()*100)/100d);
			detalle.setValor2(Math.round(detalle.getValor2()*100)/100d);
			detalle.setValor3(Math.round(detalle.getValor3()*100)/100d);
			detalle.setTotal(Math.round(detalle.getTotal()*100)/100d);
			
			detalles.add(detalle);
			
			if (log.isTraceEnabled()) {
				log.trace("KnowledgeRuntime.Costeo.addDetalle: " + detalle.toString());
			}
	}
	
	public void log(String mensaje) {
		log.info(mensaje);
		System.out.println();
	}
	
}