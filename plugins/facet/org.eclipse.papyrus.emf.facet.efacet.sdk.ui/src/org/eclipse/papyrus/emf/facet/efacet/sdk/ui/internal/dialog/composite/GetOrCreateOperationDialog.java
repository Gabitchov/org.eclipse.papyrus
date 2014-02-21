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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation.GetOrCreateFiltredOperationWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.SynchronizedAbstractDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.swt.widgets.Display;

/**
 * Provide a dialog where the user can select an Operation in the existing
 * facets list or create a new one. This class use the specific widget
 * {@link GetOrCreateFiltredOperationWidget} and return the selected element
 * with the method {@link #getFacetOperationSelected()}.</p>
 * 
 * When the "ok" button is pressed, the parent property is set with the selected
 * element.
 * 
 * @see GetOrCreateFiltredOperationWidget
 */
public class GetOrCreateOperationDialog extends
		AbstractComandExecDialog<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>> {

	private GetOrCreateFiltredOperationWidget gOCOperation; // gOC=getOrCreate
	private final EditingDomain editingDomain;
	private final Facet context;

	/**
	 * The constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param context
	 * @param specificProperties
	 *            properties that parent widget had.
	 */
	public GetOrCreateOperationDialog(
			final IWithResultDialogCallback<FacetOperation> callback,
			final EditingDomain editingDomain, final Facet context) {
		super(callback, editingDomain);
		this.editingDomain = editingDomain;
		this.context = context;
	}

	/**
	 * Return the operation selected by the user.
	 * 
	 * @return the operation selected.
	 */
	public FacetOperation getFacetOperation() {
		return this.gOCOperation.getFacetOperationSelected();
	}

	@Override
	protected IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget> createWidget() {
		this.gOCOperation = new GetOrCreateFiltredOperationWidget(
				this.getDialogComposite(), this.editingDomain, this.context);
		return new SynchronizedGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>(
				this.gOCOperation, this.gOCOperation.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.GetOrCreate_Operation_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Select_Operation;
	}

	@Override
	protected void okPressed() {
		// TODO Use of an instance of PropetyElement2
		this.getCallback().canceled(
				this.gOCOperation.getFacetOperationSelected());
		super.okPressed();
	}

	public void selectElement(final FacetOperation element) {
		this.gOCOperation.selectElement(element);
	}

	public IDialog<IDerivedTypedElementWidget> createElement() {
		final IDialog<IDerivedTypedElementWidget> pressNewButton = this.gOCOperation
				.pressNewButton();
		return new SynchronizedAbstractDialog<IDerivedTypedElementWidget>(
				pressNewButton, Display.getDefault());
	}

	@Override
	protected FacetOperation getResult() {
		return this.gOCOperation.getFacetOperationSelected();
	}

}
