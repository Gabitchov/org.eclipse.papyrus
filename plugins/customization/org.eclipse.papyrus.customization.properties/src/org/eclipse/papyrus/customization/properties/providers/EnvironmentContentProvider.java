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
package org.eclipse.papyrus.customization.properties.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.infra.emf.providers.strategy.SemanticEMFContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.environment.Environment;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;

/**
 * A Content provider for returning objects for the registered environments
 * 
 * @author Camille Letavernier
 */
public class EnvironmentContentProvider extends SemanticEMFContentProvider implements IStaticContentProvider {

	/**
	 * Constructor.
	 * 
	 * @param feature
	 *        The EStructuralFeature used to retrieve the elements from the
	 *        different environments.
	 */
	public EnvironmentContentProvider(EStructuralFeature feature) {
		super(null, feature, getRoots(feature), Activator.getDefault().getCustomizationManager());
	}

	private static EObject[] getRoots(EStructuralFeature feature) {
		if(!(feature.getEType() instanceof EClass)) {
			Activator.log.warn("The feature " + feature + " cannot be handled by this content provider");
			return new EObject[0];
		}

		List<Object> allObjects = new LinkedList<Object>();
		for(Environment environment : ConfigurationManager.instance.getPropertiesRoot().getEnvironments()) {
			allObjects.addAll((List<?>)environment.eGet(feature));
		}
		return allObjects.toArray(new EObject[0]);
	}

}
