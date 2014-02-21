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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.AbstractCustomizationMainDialog;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.command.CreateEClassCustomizationWidget;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

/**
 * Concrete dialog for the creation of an EClass Customization.
 */
public class CreateEClassCustomizationDialog extends
		AbstractCustomizationMainDialog<ICommandWidget> {

	private CreateEClassCustomizationWidget eClassCustomW;
	private final PropertyElement2<Customization> customProperty;
	private final PropertyElement2<EClass> mClassProperty;
	private final PropertyElement2<Facet> extFacetProperty;

	/**
	 * Constructor.
	 * 
	 * @param selection
	 *            the selection in the model (custom file).
	 */
	public CreateEClassCustomizationDialog(final Customization selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.customProperty = new PropertyElement2<Customization>(true);
		this.mClassProperty = new PropertyElement2<EClass>(true);
		this.extFacetProperty = new PropertyElement2<Facet>(true);
		if (selection != null) {
			this.customProperty.setValue2(selection);
		}
	}

	@Override
	protected ICommandWidget createWidget() {
		this.eClassCustomW = new CreateEClassCustomizationWidget(
				this.getDialogComposite(), this.getCustomCmdFactory(),
				getEditingDomain(), this.customProperty, this.mClassProperty,
				this.extFacetProperty);
		return this.eClassCustomW;
	}

	@Override
	protected String getDialogMessage() {
		return Messages.CreateEClassCustomizationDialog_Message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.CreateEClassCustomizationDialog_Title;
	}

	/**
	 * @return the createEClassCustomizationWidget
	 */
	public CreateEClassCustomizationWidget getCreateEClassCustomizationWidget() {
		return this.eClassCustomW;
	}

	protected final CreateEClassCustomizationWidget geteClassCustomW() {
		return this.eClassCustomW;
	}

	protected final PropertyElement2<Customization> getCustomProperty() {
		return this.customProperty;
	}

	protected final PropertyElement2<EClass> getmClassProperty() {
		return this.mClassProperty;
	}

	protected final PropertyElement2<Facet> getExtFacetProperty() {
		return this.extFacetProperty;
	}

}
