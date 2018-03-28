package com.prosegur.rulesEngine.services.restService.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.prosegur.rulesEngine.services.restService.VersionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VersionServiceImpl implements VersionService {
	
	public final static String MANIFEST_FILE="../../META-INF/MANIFEST.MF";

	@Value("${engine.name}") String engineName;
	@Value("#{'${engine.countries}'.split(',')}") String[] countries;
	
	@Override
	public String getVersion() {
		String message = new String();
		
		/**
		 * Componemos la salida del fichero Manifest del servicio
		 */
		URL ulrManifest = this.getClass().getClassLoader().getResource(MANIFEST_FILE);
		 
		if ( ulrManifest == null) {
			message = "Unable to find "+ MANIFEST_FILE + "\n";
		} else {
			try {
				InputStream inputStream = ulrManifest.openStream();
						
				Manifest manifest = new Manifest(inputStream);
				Attributes attributes = manifest.getMainAttributes();
				message = "Manifest Entries\n";
				for (Object entry : attributes.entrySet()) {
					message += "[ "+ entry + " ]\n";
				}
			} catch (IOException ex) {
				message = "Unable to read "+ MANIFEST_FILE + "\n";
				log.error(message, ex);
			}
		}
		message += "\n";
		
		/**
		 * Componemos la salida por cada uno de los agentes de conocimiento
		 */
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = null;
		try {
			db = dbFactory.newDocumentBuilder();
		
			for (String countryAndSimulator : countries) {
	    		String country = countryAndSimulator.split("@")[0];
	    		String simulator = (countryAndSimulator.split("@").length>1)?countryAndSimulator.split("@")[1]:null;
	    		
	    		String knowledgeAgentName = country + "." + engineName;
	    		if (simulator!=null && !simulator.isEmpty()) {
	    			knowledgeAgentName += ("." + simulator);
	    		}
	    		
				message += "Knowledge Agent: " + knowledgeAgentName + "\n";
				
				URL urlChangeSet = this.getClass().getClassLoader().getResource("/change-set/change-set-"+knowledgeAgentName+".xml");
				if ( urlChangeSet == null) {
					message = "Unable to find the configuration file for knowledge agent '"+ knowledgeAgentName + "'\n";
				} else {
					try {
						InputStream inputStream = urlChangeSet.openStream();
						
						Document docChangeSet = db.parse(inputStream);
		
					    NodeList resources = docChangeSet.getElementsByTagName("resource");
					    for(int i=0; i<resources.getLength(); i++) {
					    	Node resource = resources.item(i);
					    	NamedNodeMap atributes = resource.getAttributes();
					    	String source = atributes.getNamedItem("source").getNodeValue();
					    	String type = atributes.getNamedItem("type").getNodeValue();
					    	
					    	message += "[ "+ type + " ] " + source + "\n";
					    }
					    message += "\n";
					} catch (SAXException ex) {
						message = "Unable to read '"+ urlChangeSet.getPath() + "'. The format is not correct.\n";
						log.error(message, ex);
					} catch (IOException ex) {
						message = "Unable to find '"+ urlChangeSet.getPath() + "'\n";
						log.error(message, ex);
					}
				}
			}
		} catch (ParserConfigurationException ex) {
			message += "Could not create the XML document builder and can not read the configuration files of knowledge agents.\n";
			log.error(message, ex);
		}
		
		return message;
	}	
}
