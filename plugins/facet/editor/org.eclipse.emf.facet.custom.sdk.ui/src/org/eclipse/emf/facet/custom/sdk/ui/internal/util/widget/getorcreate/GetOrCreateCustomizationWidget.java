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
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.custom.sdk.ui.internal.util.dialog.getorcreate.GetOrCreateCustomizationDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithDialogButtonWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget allow the creation of a Customization element.
 */
public class GetOrCreateCustomizationWidget
		extends
		AbstractGetOrCreateElementWithDialogButtonWidget<Customization, IGetOrCreateFilteredElementCommmandWidget<Customization, ICommandWidget>> {

	private final EditingDomain editingDomain;

	/**
	 * Constructor.*
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param propertyElement
	 *            the property element that be edited with this composite.
	 * @param properties
	 *            the map of properties of the parent.
	 */
	public GetOrCreateCustomizationWidget(final Composite parent,
			final PropertyElement2<Customization> propertyElement,
			final EditingDomain editingDomain) {
		super(parent, propertyElement);
		this.editingDomain = editingDomain;
	}

	@Override
	protected String getLabel() {
		return Messages.Customization;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Customization_mustSelectCustomization;
	}

	@Override
	protected String getTextFieldInitialText() {
		return this.getPropertyElement().getValue2().getName();
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	protected void onCanceled() {
		// Nothing to do.
	}

	@Override
	protected IDialog<IGetOrCreateFilteredElementCommmandWidget<Customization, ICommandWidget>> getCreationDialog(
			final IWithResultDialogCallback<Customization> callback) {
		return new GetOrCreateCustomizationDialog(callback, this.editingDomain,
				this.getPropertyElement().getValue2());
	}

}
