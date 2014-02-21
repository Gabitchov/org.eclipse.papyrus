/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal.serialization;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference;

/**
 * Interface for the adapter that attaches {@link ExtendedEObjectReference} to {@link EObject}s.
 *
 * @since 0.2
 */
public interface ILinkToExtendedEObjectReference {

	/**
	 * @return the current {@link ExtendedEObjectReference}.
	 */
	public ExtendedEObjectReference getExtendedEObjectReference();

	/**
	 * Replace the current ExtendedEObjectReference by {@link ExtendedEObjectReference}.
	 */
	public void setExtendedEObjectReference(ExtendedEObjectReference extendedEObjectReference);

}
