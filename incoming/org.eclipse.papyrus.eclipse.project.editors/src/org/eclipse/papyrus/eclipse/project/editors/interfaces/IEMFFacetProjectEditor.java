/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.interfaces;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.facet.FacetSet;

/**
 * 
 * This interface is used to edit the EMF-Facet project
 * 
 */
public interface IEMFFacetProjectEditor extends IJavaProjectEditor/* , IManifestEditor , IBuildEditor */{

	/** the EMF-Facet nature */
	public static final String EMF_FACET_NATURE = "org.eclipse.emf.facet.common.ProjectNature"; //$NON-NLS-1$

	/** the name of the extension point for the facet registration */
	public static final String FACET_REGISTRATION = "org.eclipse.emf.facet.infra.facet.registration"; //$NON-NLS-1$

	/** the name of the extension point for the query registration */
	public static final String QUERY_REGISTRATION = "org.eclipse.emf.facet.infra.query.registration"; //$NON-NLS-1$

	/** the build command for EMF_FACET project */
	public static final String EMF_FACET_BUILD_COMMAND = "org.eclipse.emf.facet.common.core.builder";

	public static final String FACET_SET = "facetset"; //$NON-NLS-1$

	public static final String FILE = "file"; //$NON-NLS-1$

	public static final String QUERY_SET = "modelqueryset"; //$NON-NLS-1$

	/**
	 * 
	 * @param facetSets
	 *        a list of FacetSet to register
	 */
	public void registerFacetSets(final List<FacetSet> facetSets);

	/**
	 * 
	 * @param querySets
	 *        a list of QuerySet to register
	 */
	public void registerQuerySets(final List<EObject> querySets);

	/**
	 * 
	 * @param dependency
	 *        a dependency to add to the project
	 */
	public void addDependency(final String dependency);

	/**
	 * 
	 * @param dependency
	 *        a dependency to add to the project
	 * @param version
	 *        the version of the dependency
	 */
	public void addDependency(final String dependency, final String version);


}
