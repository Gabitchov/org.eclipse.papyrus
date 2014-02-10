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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.creation;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.getorcreate.GetOrCreateOperationWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.properties.name.GetOperationNameWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithButtonWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Concrete implementation of {@link AbstractAddElementWidget} for the creation
 * of an parameter in a operation.
 */
public class AddParameterInOperationWidget extends
		AbstractETypedElementWidget<EParameter, FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 */
	public AddParameterInOperationWidget(final Composite parent,
			final EditingDomain editingDomain,
			final PropertyElement2<FacetOperation> containerProperty,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<Integer> lowerBdProperty,
			final PropertyElement2<Integer> upperBdProperty,
			final PropertyElement2<EClassifier> typeProperty,
			final PropertyElement2<Boolean> orderedProperty,
			final PropertyElement2<Boolean> uniqueProperty) {
		super(parent, editingDomain, containerProperty, nameProperty,
				lowerBdProperty,
				upperBdProperty, typeProperty, orderedProperty, uniqueProperty);
	}

	@Override
	public Command getCommand() {
		final FacetOperation facetOperation = this.getContainerPropery()
				.getValue2();
		final EParameter operationParam = createOperationParameter();
		return this.getCommandFactory()
				.createAddParameterInOperationCommand(facetOperation,
						operationParam);
	}

	protected EParameter createOperationParameter() {
		final EParameter operationParam = getOperationParameter();
		operationParam.setName(getElementNamePropertyValue());
		operationParam.setLowerBound(getLowerBoundProperty().getValue2()
				.intValue());
		operationParam.setUpperBound(getUpperBoundProperty().getValue2()
				.intValue());
		operationParam.setEType(getTypeProperty().getValue2());
		operationParam.setOrdered(getOrderedProperty().getValue2()
				.booleanValue());
		operationParam
				.setUnique(getUniqueProperty().getValue2().booleanValue());
		return operationParam;
	}

	@SuppressWarnings("static-method")
	//@SuppressWarnings("static-method") This method cannot be static because it is overrode by EditFacetWidget.
	protected EParameter getOperationParameter() {
		return EcoreFactory.eINSTANCE.createEParameter();
	}

	@Override
	protected GetOperationNameWidget createGetElementNameSubWidgetComposite() {
		return new GetOperationNameWidget(this, this.getElementNameProperty());
	}

	@Override
	protected AbstractGetOrCreateElementWithButtonWidget<FacetOperation, IDialog<IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> createGetOrCreateElementWidgetComposite() {
		final Facet context = (Facet) this.getContainerPropery().getValue2()
				.eContainer();
		return new GetOrCreateOperationWidget(this, this.getContainerPropery(),
				this.getEditingDomain(), context);
	}

	@Override
	protected Class<EClassifier> getETypeSelectionOption() {
		return EClassifier.class;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}

}
