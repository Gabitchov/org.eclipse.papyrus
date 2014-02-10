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
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.dialog.command;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.custom.sdk.ui.internal.util.dialog.AbstractCustomizationMainDialog;
import org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.command.AddCustomizationPropertyWidget;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Concrete dialog for the creation of a customization property into a
 * customization.
 */
public class AddCustomizationPropertyDialog extends
		AbstractCustomizationMainDialog<ICommandWidget> {

	private AddCustomizationPropertyWidget addCustomW;
	private final EClassCustomization eClassCustom;
	private final PropertyElement2<FacetOperation> facetOpProperty;

	/**
	 * Constructor.
	 * 
	 * @param selection
	 *            the selection in the model (custom file).
	 */
	public AddCustomizationPropertyDialog(final EClassCustomization selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.eClassCustom = selection;
		this.facetOpProperty = new PropertyElement2<FacetOperation>(true);
	}

	@Override
	protected ICommandWidget createWidget() {
		this.addCustomW = new AddCustomizationPropertyWidget(
				this.getDialogComposite(), this.facetOpProperty,
				this.eClassCustom, this.getEditingDomain());
		return this.addCustomW;
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Add_Customization_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Add_Customization_title;
	}

	/**
	 * @return the addCustomizationWidget
	 */
	public AddCustomizationPropertyWidget getAddCustomizationWidget() {
		return this.addCustomW;
	}

}
