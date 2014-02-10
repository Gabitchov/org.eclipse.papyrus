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
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.command;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.CustomFactory;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery;
import org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate.GetOperationFacetWidget;
import org.eclipse.emf.facet.efacet.core.IFacetCommandFactoryFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.AbstractCommandWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the selection of a customization property. This Widget return a
 * command ( {@link #getCommand()} for the creation of the element into the
 * model.</p>
 * 
 * This widget uses the {@link GetOperationFacetWidget} widget to display a
 * dialog where the user select the operation he wants.</p>
 * 
 * When the operation is selected, a copy of this operation is made and this one
 * will be added to the model.</p>
 * 
 * Cases are created to be added to the operation:</p>
 * 
 * <li>a <code>null</code> case</li> <li>a case for each
 * {@link EStructuralFeature} of the extended meta-class</li>
 */
public class AddCustomizationPropertyWidget extends
 AbstractCommandWidget {

	private final EClassCustomization eClassCustom;
	private final PropertyElement2<FacetOperation> facetOpProperty;
	private final EditingDomain editingDomain;
	
	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 */
	public AddCustomizationPropertyWidget(final Composite parent,
			final PropertyElement2<FacetOperation> facetOpProperty,
			final EClassCustomization eClassCustomProp,
			final EditingDomain editingDomain) {
		super(parent);
		this.facetOpProperty = facetOpProperty;
		this.eClassCustom = eClassCustomProp;
		this.editingDomain = editingDomain;
	}

	@Override
	public Command getCommand() {
		final FacetOperation customOperation = (FacetOperation) this.facetOpProperty
				.getValue();
		// Copy of the selected operation.
		final FacetOperation facetOperation = EcoreUtil
				.copy(customOperation);
		// Set the selected operation has the override operation of the new one.
		facetOperation.setOverride(customOperation);
		// Creation of the Query
		final ETypedElementSwitchQuery eTypedElementSQ = CustomFactory.eINSTANCE
				.createETypedElementSwitchQuery();
		ETypedElementCase elementCase;
		// Adding a null case
		elementCase = CustomFactory.eINSTANCE.createETypedElementCase();
		elementCase.setCase(null);
		eTypedElementSQ.getCases().add(elementCase);
		// Adding a Case for each Structural Feature.
		for (final EStructuralFeature feature : this.eClassCustom
				.getExtendedMetaclass().getEAllStructuralFeatures()) {
			elementCase = CustomFactory.eINSTANCE.createETypedElementCase();
			elementCase.setCase(feature);
			eTypedElementSQ.getCases().add(elementCase);
		}
		// Set the query created to the custom operation.
		facetOperation.setQuery(eTypedElementSQ);
		return IFacetCommandFactoryFactory.DEFAULT.createCommandFactory(
				this.editingDomain).createAddOperationInFacetCommand(
				this.eClassCustom, facetOperation);
	}

	@Override
	public void onDialogValidation() {
		// Nothing to do.
	}

	@Override
	protected void addSubWidgets() {
		final GetOperationFacetWidget widget = new GetOperationFacetWidget(
				this, this.facetOpProperty, this.eClassCustom);
		addSubWidget(widget);
	}

	@Override
	public void notifyChanged() {
		// Nothing to do.
	}

}
