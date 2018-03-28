package com.prosegur.rulesEngine.services.soapService.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Clase que sirve para realizar los mapeos. Se utiliza
 * la utilidad Dozer que permite mapear POJOs con ficheros declarativos xml. Esta clase tiene el
 * patrónn Singleton para que no pueda ser instanciada más de una vez.
 */
public class MapeoEntidades {

	private static Mapper mapper;

	/**
	 * Carga el fichero xml donde se encuentran todos los ficheros de mapeos y los asigna al objeto
	 * Dozer de mapeo.
	 * @return Mapper datos de los mapeos.
	 */
	public final static Mapper getMapper() {
		if (mapper == null) {
			List<String> list = new ArrayList<String>();
			list.add("dozerMapping.xml");

			// Agregar a DozerMapper
			mapper = new DozerBeanMapper(list);
		}

		return mapper;
	}
}
