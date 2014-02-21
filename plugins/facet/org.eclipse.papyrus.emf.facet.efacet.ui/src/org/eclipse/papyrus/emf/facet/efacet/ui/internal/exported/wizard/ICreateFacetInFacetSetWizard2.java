/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *  Gregoire Dupe (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 */
package org.eclipse.emf.facet.efacet.ui.internal.exported.wizard;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

/**
 * TODO This interface has to be renamed to ICreateFacetInFacetSetWizard before the release of 0.2
 * @since 0.2
 */
//TODO This interface has to be renamed to ICreateFacetInFacetSetWizard before the release of 0.2
public interface ICreateFacetInFacetSetWizard2 {

	public void setFacetSet(FacetSet facetSet);

	public void canChangeFacetSet(boolean canChange);

	public void setExtendedMetaClass(EClass extendedMetaClass);

	public void canChangeExtendedMetaClass(boolean canChange);

	public int open();
}
