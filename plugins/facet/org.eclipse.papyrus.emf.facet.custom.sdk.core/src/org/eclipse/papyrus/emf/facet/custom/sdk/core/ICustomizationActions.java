/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.core;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.emf.facet.custom.sdk.core.internal.CustomizationActionsImpl;
import org.eclipse.papyrus.emf.facet.util.emf.core.exception.InvalidFacetSetException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

/**
 * This interface provides the creation of a new customization model file.
 * 
 * @see CustomizationActionsImpl
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationActions {

	ICustomizationActions INSTANCE = new CustomizationActionsImpl();

	/**
	 * Add the given customization to the given customization model file, which
	 * will be created.
	 * 
	 * @param customization
	 *            the customization to be created. Cannot be <code>null</code>
	 * @param file
	 *            the new file in which the customization has to be created.
	 *            Cannot be <code>null</code>, and cannot already exist
	 */
	void saveCustomization(Customization customization, IFile file)
			throws IOException, InvalidFacetSetException;
}
