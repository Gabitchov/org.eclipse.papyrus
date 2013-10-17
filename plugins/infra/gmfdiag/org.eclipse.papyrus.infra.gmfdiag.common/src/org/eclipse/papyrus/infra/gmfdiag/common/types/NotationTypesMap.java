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

	private final Map<String, String> computerToHumanTypeMapping = new HashMap<String, String>();

	private final Map<String, String> humanToComputerTypeMapping = new HashMap<String, String>();

	private NotationTypesMap() {
		readExtensionPoint();
	}

	private void readExtensionPoint() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for(IConfigurationElement mappingDefinition : configurationElements) {

			final String notationType = mappingDefinition.getAttribute("type");
			final String humanReadableType = StringHelper.toJavaIdentifier(mappingDefinition.getAttribute("humanReadableType"));

			if(notationType == null || humanReadableType == null) {
				Activator.log.warn(String.format("Plug-in %s contributed an invalid extension for Notation Type Mappings", mappingDefinition.getContributor().getName()));
				continue;
			}

			computerToHumanTypeMapping.put(notationType, humanReadableType);
			humanToComputerTypeMapping.put(humanReadableType, notationType);
		}
	}

	public String getNotationType(String humanReadableType) {
		return humanToComputerTypeMapping.get(humanReadableType);
	}

	public String getHumanReadableType(String notationType) {
		return computerToHumanTypeMapping.get(notationType);
	}

	public Map<String, String> getComputerToHumanTypeMapping() {
		return computerToHumanTypeMapping;
	}

	public Map<String, String> getHumanToComputerTypeMapping() {
		return humanToComputerTypeMapping;
	}
}
