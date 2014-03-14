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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.getorcreate;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.sync.SynchronizedGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.AbstractGetOrCreateCustomizationDialog;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.command.GetOrCreateCustomizationWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

/**
 * Provide a dialog where the user can select a {@link Customization} in the
 * list. This class use the specific widget
 * {@link GetOrCreateCustomizationWidget} and return the selected element with
 * the method {@link #getCustomizationSelected()}.</p>
 * 
 * When the "ok" button is pressed, the parent property is set with the selected
 * element.
 * 
 * @see GetOrCreateCustomizationWidget
 */
public class GetOrCreateCustomizationDialog
		extends
		AbstractGetOrCreateCustomizationDialog<Customization, IGetOrCreateFilteredElementCommmandWidget<Customization, ICommandWidget>> {

	private final PropertyElement2<Customization> customProperty;

	/**
	 * Constructor.
	 * 
	 * @param properties
	 *            properties that parent widget had.
	 */
	public GetOrCreateCustomizationDialog(
			final IWithResultDialogCallback<Customization> callback,
			final EditingDomain editingDomain, final Customization custom) {
		super(callback, editingDomain);
		this.customProperty = new PropertyElement2<Customization>(true, custom);
	}

	@Override
	protected IGetOrCreateFilteredElementCommmandWidget<Customization, ICommandWidget> createWidget() {
		final GetOrCreateCustomizationWidget widget =  new GetOrCreateCustomizationWidget(this.getDialogComposite(),
				getEditingDomain(), this.customProperty);
		return new SynchronizedGetOrCreateFilteredElementCommmandWidget<Customization, ICommandWidget>(
				widget, widget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.GetOrCreate_customization_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Select_Customization;
	}

	@Override
	protected void okPressed() {
		this.getCallback().commited(this.customProperty.getValue2());
		super.okPressed();
	}

}
