/***********************************************************************
 * Copyright (c) 2007-2009 Anyware Technologies, Obeo
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *    Obeo
 * 
 **********************************************************************/
package org.eclipse.papyrus.navigator.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.core.utils.DiResourceSet;

/**
 * This object computes all the loaded resources from a resource set. <br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class AdditionalResources {

	private DiResourceSet diResourceSet;

	/**
	 * Constructor
	 * 
	 * @param rSet
	 *            the ResourceSet to be used to load these Additional Resources
	 */
	public AdditionalResources(DiResourceSet diResourceSet) {
		super();
		this.diResourceSet = diResourceSet;
	}

	/**
	 * Returns all the resources without the DI and the domain resources
	 * 
	 * @return the list of additional resources
	 */
	public List<Resource> getResources() {
		List<Resource> additionnalResources = new ArrayList<Resource>();
		for (Resource resource : diResourceSet.getResourceSet().getResources()) {
			// ignore di, notation and domain resources
			if (resource == diResourceSet.getDiResource() || resource == diResourceSet.getNotationResource()
					|| resource == diResourceSet.getModelResource()) {
				continue;
			}
			additionnalResources.add(resource);
		}

		return additionnalResources;
	}
}
