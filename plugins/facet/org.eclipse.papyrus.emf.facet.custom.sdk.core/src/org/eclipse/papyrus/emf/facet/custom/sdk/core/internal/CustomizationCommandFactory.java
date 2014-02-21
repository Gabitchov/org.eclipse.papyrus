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
 *		Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.core.internal;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.core.ICustomizationCommandFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization;

/**
 * Concrete implementation of {@link ICustomizationCommandFactory}.
 */
public class CustomizationCommandFactory implements
		ICustomizationCommandFactory {

	private final EditingDomain editingDomain;

	public CustomizationCommandFactory(final EditingDomain editingDomain) {
		if (editingDomain == null) {
			throw new IllegalArgumentException(
					"The given EditingDomain cannot be null"); //$NON-NLS-1$
		}
		this.editingDomain = editingDomain;
	}

	/**
	 * Create an {@link AddCommand} to add the element to the owner.
	 * 
	 * @param owner
	 *            the owner.
	 * @param element
	 *            the element to add.
	 * @return the command.
	 */
	private Command createAddCommand(final Object owner, final Object element) {
		if (owner == null) {
			throw new IllegalArgumentException("The given owner cannot be null"); //$NON-NLS-1$
		}
		if (element == null) {
			throw new IllegalArgumentException(
					"The given element cannot be null"); //$NON-NLS-1$
		}
		return AddCommand.create(this.editingDomain, owner,
				getEStructuralFeature(element), element);
	}

	/**
	 * Return the {@link EStructuralFeature} for a given element.
	 * 
	 * @param element
	 *            the element.
	 * @return the eStructuralFeature for the element.
	 */
	private static EStructuralFeature getEStructuralFeature(final Object element) {
		EStructuralFeature result = null;
		if (element instanceof EClassCustomization) {
			result = EcorePackage.eINSTANCE.getEPackage_EClassifiers();
		}
		return result;
	}

	public Command createEClassCustomization(final Customization parent,
			final EClassCustomization eClassCustom) {
		return createAddCommand(parent, eClassCustom);
	}

	public Command createFacetCustomization(final Customization parent,
			final FacetCustomization facetCustom) {
		return createAddCommand(parent, facetCustom);
	}

	public Command addValueInCase(final ETypedElementCase elementCase,
			final Query value) {
		return createAddCommand(elementCase, value);
	}
}
