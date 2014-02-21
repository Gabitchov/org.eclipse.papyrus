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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.dialog.IFacetDialogFactory;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation.AddAttributeInFacetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation.AddOperationInFacetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation.AddParameterInOperationDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation.AddReferenceInFacetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation.CreateFacetInFacetSetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation.CreateFacetSetInFacetSetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.edition.EditFacetAttributeDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.edition.EditFacetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.edition.EditFacetOperationDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.edition.EditFacetOperationParameterDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.edition.EditFacetReferenceDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.edition.EditFacetSetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.emf.facet.util.emf.ui.util.EditingUtil;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.handler.HandlerUtils;
import org.eclipse.emf.facet.util.ui.internal.exported.util.dialog.SynchronizedAbstractDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.swt.widgets.Display;

/**
 * A factory for the dialogs creation.
 */
public class FacetDialogFactoryImpl implements IFacetDialogFactory {

	protected static void openDialog(final IDialog<?> dialog) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				dialog.open();
			}
		});
	}

	public IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> openCreateFacetSetInFacetSetDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> dialog = new CreateFacetSetInFacetSetDialog(
				(FacetSet) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>>(
				dialog, Display.getDefault());
	}

	public IDialog<IFacetWidget> openCreateFacetInFacetSetDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final IDialog<IFacetWidget> dialog = new CreateFacetInFacetSetDialog(
				(FacetSet) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IFacetWidget>(dialog,
				Display.getDefault());
	}

	public IDialog<IEStructuralFeatureWidget> openAddAttributeInFacetDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final Facet facet = (Facet) HandlerUtils.getSelection();
		final IDialog<IEStructuralFeatureWidget> dialog = new AddAttributeInFacetDialog(
				facet, editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IEStructuralFeatureWidget>(
				dialog, Display.getDefault());
	}

	public IDialog<IEStructuralFeatureWidget> openAddReferenceInFacetDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final Facet facet = (Facet) HandlerUtils.getSelection();
		final IDialog<IEStructuralFeatureWidget> dialog = new AddReferenceInFacetDialog(
				facet, editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IEStructuralFeatureWidget>(
				dialog, Display.getDefault());
	}

	public IDialog<IDerivedTypedElementWidget> openAddOperationInFacetDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final Facet facet = (Facet) HandlerUtils.getSelection();
		final IDialog<IDerivedTypedElementWidget> dialog = new AddOperationInFacetDialog(
				facet, editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IDerivedTypedElementWidget>(
				dialog, Display.getDefault());
	}

	public IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> openAddParameterInOperationDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> dialog = new AddParameterInOperationDialog(
				(FacetOperation) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>>(
				dialog, Display.getDefault());
	}

	public IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> openEditFacetSetDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> dialog = new EditFacetSetDialog(
				(FacetSet) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>>(
				dialog,
				Display.getDefault());
	}

	public IDialog<IFacetWidget> openEditFacetDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final IDialog<IFacetWidget> dialog = new EditFacetDialog(
				(Facet) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IFacetWidget>(
				dialog,
				Display.getDefault());
	}

	public IDialog<IEStructuralFeatureWidget> openEditFacetAttributeDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final FacetAttribute fAttribute = (FacetAttribute) HandlerUtils
				.getSelection();
		final IDialog<IEStructuralFeatureWidget> dialog = new EditFacetAttributeDialog(
				fAttribute, editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IEStructuralFeatureWidget>(
				dialog, Display.getDefault());
	}

	public IDialog<IEStructuralFeatureWidget> openEditFacetReferenceDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final FacetReference facetReference = (FacetReference) HandlerUtils
				.getSelection();
		final IDialog<IEStructuralFeatureWidget> dialog = new EditFacetReferenceDialog(
				facetReference, editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IEStructuralFeatureWidget>(
				dialog, Display.getDefault());
	}

	public IDialog<IDerivedTypedElementWidget> openEditFacetOperationDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final FacetOperation facetOperation = (FacetOperation) HandlerUtils
				.getSelection();
		final IDialog<IDerivedTypedElementWidget> dialog = new EditFacetOperationDialog(
				facetOperation, editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IDerivedTypedElementWidget>(
				dialog, Display.getDefault());
	}

	public IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> openEditFacetOperationParameterDialog() {
		final EditingDomain editingDomain = EditingUtil.getEditingDomain();
		final IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> dialog = new EditFacetOperationParameterDialog(
				(EParameter) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog);
		return new SynchronizedAbstractDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>>(
				dialog, Display.getDefault());
	}
}
