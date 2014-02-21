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
 */
package org.eclipse.emf.facet.efacet.ui.internal.exported.wizard;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.facet.efacet.FacetSet;

/**
 * 
 * @deprecated This interface has been replaced by ICreateFacetInFacetSetWizard2. No tracking bug needed because this API has not been released yet.
 * @since 0.2
 */
@Deprecated
public interface ICreateFacetInFacetSetWizard {

	public void setFacetSet(FacetSet facetSet);

	public void canChangeFacetSet(boolean canChange);

	public void setExtendedMetaClass(EClass extendedMetaClass);

	public void canChangeExtendedMetaClass(boolean canChange);

	public int open();
}
