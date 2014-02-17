/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.types;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.tools.util.StringHelper;

/**
 * This singleton holds a map between computer-readable notation types (e.g. 7017) and human-readable
 * types (e.g. Attribute Compartment)
 * 
 * @author Camille Letavernier
 * 
 */
public class NotationTypesMap {

	public static final NotationTypesMap instance = new NotationTypesMap();

	public static final String EXTENSION_ID = Activator.ID + ".notationTypesMapping"; //$NON-NLS-1$

	public static final String DIAGRAM_CATEGORY = "diagramMappings"; //$NON-NLS-1$

	public static final String ALL_DIAGRAMS = "Papyrus.AllDiagrams"; //$NON-NLS-1$

	public static final String MAPPING = "mapping";

	private final Map<String, TypeMap> typeMaps = new HashMap<String, TypeMap>(); //DiagramID -> TypeMap

	private NotationTypesMap() {
		readExtensionPoint();
	}

	private void readExtensionPoint() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for(IConfigurationElement diagramMappingsDefinition : configurationElements) {

			if(DIAGRAM_CATEGORY.equals(diagramMappingsDefinition.getName())) {
				String diagramID = diagramMappingsDefinition.getAttribute("diagramID");

				TypeMap typeMap = getOrCreateTypeMap(diagramID);

				for(IConfigurationElement mappingDefinition : diagramMappingsDefinition.getChildren()) {

					final String notationType = mappingDefinition.getAttribute("type");
					final String humanReadableType = StringHelper.toJavaIdentifier(mappingDefinition.getAttribute("humanReadableType"));

					if(notationType == null || humanReadableType == null) {
						Activator.log.warn(String.format("Plug-in %s contributed an invalid extension for Notation Type Mappings", mappingDefinition.getContributor().getName()));
						continue;
					}


					typeMap.getComputerToHumanTypeMapping().put(notationType, humanReadableType);
					typeMap.getHumanToComputerTypeMapping().put(humanReadableType, notationType);
				}
			} else if(MAPPING.equals(diagramMappingsDefinition.getName())) {

				TypeMap typeMap = TypeMap.defaultMap;

				final String notationType = diagramMappingsDefinition.getAttribute("type");
				final String humanReadableType = StringHelper.toJavaIdentifier(diagramMappingsDefinition.getAttribute("humanReadableType"));

				if(notationType == null || humanReadableType == null) {
					Activator.log.warn(String.format("Plug-in %s contributed an invalid extension for Notation Type Mappings", diagramMappingsDefinition.getContributor().getName()));
					continue;
				}


				typeMap.getComputerToHumanTypeMapping().put(notationType, humanReadableType);
				typeMap.getHumanToComputerTypeMapping().put(humanReadableType, notationType);
			}
		}
	}

	//Never null.
	//Used at runtime. Do not fill the map if the diagramID doesn't exist.
	private TypeMap getTypeMap(String diagramID) {
		if(typeMaps.containsKey(diagramID)) {
			return typeMaps.get(diagramID);
		}

		return TypeMap.defaultMap;
	}

	private TypeMap getTypeMap(View view) {
		if(view.getDiagram() == null) {
			return TypeMap.defaultMap;
		}

		return getTypeMap(view.getDiagram().getType());
	}

	//Never null.
	//Used during parsing of extension point. Fills the map if the diagramID doesn't exist
	private TypeMap getOrCreateTypeMap(String diagramID) {
		if(!typeMaps.containsKey(diagramID)) {
			TypeMap typeMap = new TypeMap();
			typeMaps.put(diagramID, typeMap);
		}

		return typeMaps.get(diagramID);
	}

	//////////////////////

	public String getNotationType(String humanReadableType, String diagramID) {
		return getTypeMap(diagramID).getNotationType(humanReadableType);
	}

	public String getHumanReadableType(String notationType, String diagramID) {
		return getTypeMap(diagramID).getHumanReadableType(notationType);
	}

	public Map<String, String> getComputerToHumanTypeMapping(String diagramID) {
		return getTypeMap(diagramID).getComputerToHumanTypeMapping();
	}

	public Map<String, String> getHumanToComputerTypeMapping(String diagramID) {
		return getTypeMap(diagramID).getHumanToComputerTypeMapping();
	}

	//////////////////////

	public String getNotationType(View view) {
		if(view == null) {
			return null;
		}

		return getTypeMap(view).getNotationType(view.getType());
	}

	public String getHumanReadableType(View view) {
		if(view == null) {
			return null;
		}

		return getTypeMap(view).getHumanReadableType(view.getType());
	}


	public Map<String, String> getComputerToHumanTypeMapping(Diagram diagram) {
		if(diagram == null) {
			return TypeMap.defaultMap.getComputerToHumanTypeMapping();
		}

		return getComputerToHumanTypeMapping(diagram.getType());
	}

	public Map<String, String> getHumanToComputerTypeMapping(Diagram diagram) {
		if(diagram == null) {
			return TypeMap.defaultMap.getHumanToComputerTypeMapping();
		}

		return getHumanToComputerTypeMapping(diagram.getType());
	}

	//////////////////////

	private static class TypeMap {

		public static final TypeMap defaultMap = new TypeMap();

		private final Map<String, String> computerToHumanTypeMapping = new HashMap<String, String>(); //GMF Type -> Human-readable Type

		private final Map<String, String> humanToComputerTypeMapping = new HashMap<String, String>(); //Human-readable Type -> GMF Type

		public String getNotationType(String humanReadableType) {
			if(humanToComputerTypeMapping.containsKey(humanReadableType) || defaultMap == this) {
				return humanToComputerTypeMapping.get(humanReadableType);
			}

			return defaultMap.getNotationType(humanReadableType);
		}

		public String getHumanReadableType(String notationType) {
			if(computerToHumanTypeMapping.containsKey(notationType) || defaultMap == this) {
				return computerToHumanTypeMapping.get(notationType);
			}

			return defaultMap.getHumanReadableType(notationType);
		}

		public Map<String, String> getComputerToHumanTypeMapping() {
			return computerToHumanTypeMapping;
		}

		public Map<String, String> getHumanToComputerTypeMapping() {
			return humanToComputerTypeMapping;
		}
	}
}
