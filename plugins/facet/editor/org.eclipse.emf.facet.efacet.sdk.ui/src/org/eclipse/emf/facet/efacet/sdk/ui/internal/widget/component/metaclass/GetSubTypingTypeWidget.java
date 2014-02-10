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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.metaclass;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.composite.GetSubTypingTypeDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithDialogButtonWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * @author amenager_stage
 * 
 */
public class GetSubTypingTypeWidget extends
		AbstractGetOrCreateElementWithDialogButtonWidget<ETypedElement, IGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object>> {

	private final EditingDomain editingDoamin;
	private final EClass context;
	private final Facet facet;

	/**
	 * @param parent
	 * @param editingDomain
	 * @param propertyElement
	 */
	protected GetSubTypingTypeWidget(final Composite parent,
			final PropertyElement2<ETypedElement> propertyElement,
			final EditingDomain editingDomain, final EClass context,
			final Facet facet) {
		super(parent, propertyElement);
		this.editingDoamin = editingDomain;
		this.context = context;
		this.facet = facet;
	}

	@Override
	protected String getLabel() {
		return null;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Facet_mustSelectConformanceType;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	protected String getTextFieldInitialText() {
		return getPropertyElement().getValue2().getName();
	}

	@Override
	protected void onCanceled() {
		fireChanged();
	}

	// protected IDialog<GetFilteredSubTypingTypeWidget> getCreationDialog(

	@Override
	protected IDialog<IGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object>> getCreationDialog(
			final IWithResultDialogCallback<ETypedElement> callback) {
		return new GetSubTypingTypeDialog(callback, this.editingDoamin,
				this.facet, this.context);
	}

}
