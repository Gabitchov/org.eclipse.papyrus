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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.composite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation.GetFilteredSubTypingTypeWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;

/**
 * Provide a dialog for the selection of the sub element.
 */
public class GetSubTypingTypeDialog extends
		AbstractComandExecDialog<ETypedElement, IGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object>> {

	private GetFilteredSubTypingTypeWidget typeWidget;
	private final EClass context;
	private final Facet facet;

	/**
	 * The constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param specificProperties
	 *            properties that parent widget had.
	 */
	public GetSubTypingTypeDialog(
			final IWithResultDialogCallback<ETypedElement> callback,
			final EditingDomain editingDomain, final Facet facet,
			final EClass context) {
		super(callback, editingDomain);
		this.facet = facet;
		this.context = context;
	}

	@Override
	protected IGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object> createWidget() {
		this.typeWidget = new GetFilteredSubTypingTypeWidget(this.getDialogComposite(),
				this.context, this.facet);
		return new SynchronizedGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object>(
				this.typeWidget, this.typeWidget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.GetSubTypingType_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.GetSubTypingType_title;
	}

	@Override
	protected void okPressed() {
		// TODO Use of an instance of PropetyElement2
		this.getCallback().commited(this.typeWidget.getSubTypeSelected());
		super.okPressed();
	}

	public void selectElement(final Object element) {
		if (element instanceof ETypedElement) {
			final ETypedElement eTypeElement = (ETypedElement) element;
			this.typeWidget.selectElement(eTypeElement);
		}
	}

	@Override
	protected ETypedElement getResult() {
		return this.typeWidget.getSubTypeSelected();
	}
}
