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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.edition;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation.AddParameterInOperationWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the edition of a {@link EParameter}.
 */
public class EditFacetOperationParameterWidget extends
		AddParameterInOperationWidget {

	private final EParameter initialParameter;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param properties
	 *            the properties.
	 * @param initialParameter
	 *            the {@link EParameter} to edit.
	 */
	public EditFacetOperationParameterWidget(final Composite parent,
			final EParameter initialParameter,
			final EditingDomain editingDomain,
			final PropertyElement2<FacetOperation> containerProperty,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<Integer> lowerBdProperty,
			final PropertyElement2<Integer> upperBdProperty,
			final PropertyElement2<EClassifier> typeProperty,
			final PropertyElement2<Boolean> orderedProperty,
			final PropertyElement2<Boolean> uniqueProperty) {
		super(parent, editingDomain, containerProperty, nameProperty,
				lowerBdProperty, upperBdProperty, typeProperty,
				orderedProperty, uniqueProperty);
		this.initialParameter = initialParameter;
	}

	@Override
	protected EParameter getOperationParameter() {
		return this.initialParameter;
	}

	@Override
	public Command getCommand() {
		return this.getCommandFactory().createEditOperationParameterCommand(
				this.initialParameter, this.getContainer(), this.getElementName(),
				this.getLowerBound(), this.getLowerBound(), this.getEType(),
				this.isOrdered(), this.isUnique());
	}
}
