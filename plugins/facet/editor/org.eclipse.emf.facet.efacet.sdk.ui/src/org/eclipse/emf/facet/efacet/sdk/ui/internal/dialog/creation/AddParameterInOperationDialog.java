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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedETypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.creation.AddParameterInOperationWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Concrete Dialog for the creation of an Operation in a Facet.
 */
public class AddParameterInOperationDialog extends
		AbstractETypedElementDialog<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>, IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> {

	private final PropertyElement2<FacetOperation> operationProperty;

	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param selection
	 *            the selection in the model (ecore file).
	 */
	public AddParameterInOperationDialog(final FacetOperation selection,
			final EditingDomain editingDomain) {
		super(null, editingDomain);
		this.operationProperty = new PropertyElement2<FacetOperation>(false,
				selection);
	}
	
	@Override
	protected IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>> createWidget() {
		final AddParameterInOperationWidget widget = new AddParameterInOperationWidget(
				this.getDialogComposite(),
				this.getEditingDomain(), this.operationProperty,
				this.getNameProperty(), this.getLowerBdProperty(),
				this.getUpperBdProperty(), this.getTypeProperty(),
				this.getOrderedProperty(), this.getUniqueProperty());
		return new SynchronizedETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>(
				widget, widget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Add_an_Operation_Parameter_desc;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Add_an_Operation_Parameter;
	}

}
