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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.command;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.command.CreateFacetCustomizationWidget;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

/**
 * Concrete dialog for the creation of a Facet Customization.
 */
public class CreateFacetCustomizationDialog extends
		CreateEClassCustomizationDialog {

	private CreateFacetCustomizationWidget facetCustomW;
	private PropertyElement2<Facet> facetCustomProp;

	/**
	 * Constructor.
	 * 
	 * @param selection
	 *            the selection in the model (custom file).
	 */
	public CreateFacetCustomizationDialog(final Customization selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.facetCustomProp =  new PropertyElement2<Facet>(true);
	}

	@Override
	protected ICommandWidget createWidget() {
		this.facetCustomW = new CreateFacetCustomizationWidget(
				this.getDialogComposite(), getCustomCmdFactory(),
				getEditingDomain(), getmClassProperty(), getCustomProperty(),
				getExtFacetProperty(), this.facetCustomProp);
		return this.facetCustomW;
	}

	@Override
	protected String getDialogMessage() {
		return Messages.CreateFacetCustomizationDialog_Message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.CreateFacetCustomizationDialog_Title;
	}

	/**
	 * @return the createFacetCustomizationWidget
	 */
	public CreateFacetCustomizationWidget getCreateFacetCustomizationWidget() {
		return this.facetCustomW;
	}

}
