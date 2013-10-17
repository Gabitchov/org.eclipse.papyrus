/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.constraints.runtime;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.constraints.Activator;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintEnvironment;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintType;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A singleton instance to manage constraints.
 * The available constraints can be loaded from an extension point, or
 * dynamically
 * 
 * @author Camille Letavernier
 * 
 */
public class ConstraintsManager {

	/**
	 * The Constraints extension point ID
	 */
	public final static String EXTENSION_ID = Activator.PLUGIN_ID + ".ConstraintEnvironment"; //$NON-NLS-1$

	private ResourceSet resourceSet;

	private final Set<ConstraintEnvironment> environments;

	private ConstraintsManager() {
		environments = new HashSet<ConstraintEnvironment>();
		resourceSet = new ResourceSetImpl();
		loadExtensionPoint();
	}

	private void loadExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			final String environmentResource = e.getAttribute("environmentModel"); //$NON-NLS-1$
			URI uri = URI.createPlatformPluginURI(e.getContributor().getName() + "/" + environmentResource, true); //$NON-NLS-1$ 
			try {
				addEnvironment(uri);
			} catch (IOException ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID, ex); //$NON-NLS-1$//$NON-NLS-2$
			}
		}
	}

	/**
	 * Adds a constraint environment model, which should be loaded at
	 * the given URI. The root element should be a {@link ConstraintEnvironment}
	 * 
	 * @param uri
	 *        The location of the model to load. Its root element should be a {@link ConstraintEnvironment}
	 * @throws IOException
	 *         If the model cannot be loaded
	 */
	public void addEnvironment(URI uri) throws IOException {
		EObject model = EMFHelper.loadEMFModel(resourceSet, uri);
		if(model instanceof ConstraintEnvironment) {
			addEnvironment((ConstraintEnvironment)model);
		}
	}

	/**
	 * Adds a constraint environment model to the manager
	 * 
	 * @param environment
	 *        The {@link ConstraintEnvironment} to add to the manager
	 */
	public void addEnvironment(ConstraintEnvironment environment) {
		environments.add(environment);
	}

	/**
	 * The singleton instance of {@link ConstraintsManager}
	 */
	public static ConstraintsManager instance = new ConstraintsManager();

	/**
	 * Returns all {@link ConstraintType}s contained in the {@link ConstraintEnvironment} managed by this singleton
	 * 
	 * @return
	 *         All known {@link ConstraintType}s
	 */
	public Collection<ConstraintType> getConstraintTypes() {
		Collection<ConstraintType> constraintTypes = new HashSet<ConstraintType>();
		for(ConstraintEnvironment environment : environments) {
			constraintTypes.addAll(environment.getConstraintTypes());
		}
		return constraintTypes;
	}
}
