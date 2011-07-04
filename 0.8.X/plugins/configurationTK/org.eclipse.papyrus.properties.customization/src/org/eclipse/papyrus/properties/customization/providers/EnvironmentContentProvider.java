/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.customization.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.environment.Environment;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.widgets.providers.AbstractStaticContentProvider;

/**
 * A Content provider for returning objects for the registered environments
 * 
 * @author Camille Letavernier
 */
public class EnvironmentContentProvider extends AbstractStaticContentProvider {

	private Object[] contents;

	/**
	 * Constructor.
	 * 
	 * @param feature
	 *        The EStructuralFeature used to retrieve the elements from the
	 *        different environments.
	 */
	public EnvironmentContentProvider(EStructuralFeature feature) {
		List<Object> allObjects = new LinkedList<Object>();
		for(Environment environment : ConfigurationManager.instance.getPropertiesRoot().getEnvironments()) {
			allObjects.addAll((List<?>)environment.eGet(feature));
		}
		contents = allObjects.toArray();
	}

	public Object[] getElements() {
		return contents;
	}

}
