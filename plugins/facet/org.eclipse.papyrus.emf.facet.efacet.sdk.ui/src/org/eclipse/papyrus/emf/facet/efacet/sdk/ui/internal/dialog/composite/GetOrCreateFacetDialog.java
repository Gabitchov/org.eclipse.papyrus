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
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation.GetOrCreateFiltredFacetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.SynchronizedAbstractDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.swt.widgets.Display;

/**
 * Provide a dialog where the user can select a facet in the existing facetSet
 * list or create a new one. This class use the specific widget
 * {@link GetOrCreateFiltredFacetWidget} and return the selected element with
 * the method {@link #getFacetSelected()}.</p>
 * 
 * When the "ok" button is pressed, the parent property is set with the selected
 * element.
 * 
 * @see GetOrCreateFiltredFacetWidget
 */
public class GetOrCreateFacetDialog extends
		AbstractComandExecDialog<Facet, IGetOrCreateFilteredElementCommmandWidget<Facet, IFacetWidget>> {

	private GetOrCreateFiltredFacetWidget gOCFacet; // gOC=getOrCreate
	private final EditingDomain editingDomain;
	private final FacetSet container;

	/**
	 * The constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param container
	 * @param properties
	 *            properties that parent widget had.
	 */
	public GetOrCreateFacetDialog(
			final IWithResultDialogCallback<Facet> callback,
			final EditingDomain editingDomain, final FacetSet container) {
		super(callback, editingDomain);
		this.editingDomain = editingDomain;
		this.container = container;
	}

	/**
	 * Return the facet selected by the user.
	 * 
	 * @return the facet selected.
	 */
	public Facet getFacet() {
		return this.gOCFacet.getFacetSelected();
	}

	@Override
	protected IGetOrCreateFilteredElementCommmandWidget<Facet, IFacetWidget> createWidget() {
		this.gOCFacet = new GetOrCreateFiltredFacetWidget(
				this.getDialogComposite(), this.editingDomain, this.container);
		return new SynchronizedGetOrCreateFilteredElementCommmandWidget<Facet, IFacetWidget>(
				this.gOCFacet, this.gOCFacet.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.GetOrCreate_Facet_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Select_Facet;
	}

	@Override
	protected void okPressed() {
		// TODO Use of an instance of PropetyElement2
		this.getCallback().canceled(this.gOCFacet.getFacetSelected());
		super.okPressed();
	}

	public IDialog<IFacetWidget> createElement() {
		final IDialog<IFacetWidget> pressNewButton = this.gOCFacet
				.pressNewButton();
		return new SynchronizedAbstractDialog<IFacetWidget>(pressNewButton,
				Display.getDefault());
	}

	@Override
	protected Facet getResult() {
		return this.gOCFacet.getFacetSelected();
	}
}
