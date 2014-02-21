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
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.core;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.emf.facet.custom.sdk.core.internal.CustomizationCommandFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization;

/**
 * This interface provide a command factory. A command modify the editingDomain.
 * 
 * @since 0.3
 * @see CustomizationCommandFactory
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationCommandFactory {

	/**
	 * Create the command to add a eClassCustomization to an existing
	 * customization (parent).
	 * 
	 * @param Customization
	 *            the parent of the eClassCustomization to add.
	 * @param eClassCustom
	 *            the eClassCustomization to add.
	 * @return the command.
	 */
	Command createEClassCustomization(Customization parent,
			EClassCustomization eClassCustom);

	/**
	 * Create the command to add a facetCustomization to an existing
	 * customization (parent).
	 * 
	 * @param parent
	 *            the parent of the facetCustomization to add.
	 * @param facetCustom
	 *            the facetCustomization to add.
	 * @return the command.
	 */
	Command createFacetCustomization(Customization parent,
			FacetCustomization facetCustom);

	Command addValueInCase(final ETypedElementCase elementCase,
			final Query value);
}
