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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.dialog;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.FacetDialogFactoryImpl;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.SynchronizedFacetDialogFactory;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.swt.widgets.Display;

/**
 * Interface for the dialogs creation factory.
 * 
 * @see FacetDialogFactoryImpl
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IFacetDialogFactory {

	/**
	 * Return a new instance of the concrete implementation of this interface.
	 */
	IFacetDialogFactory INSTANCE = new SynchronizedFacetDialogFactory(
			new FacetDialogFactoryImpl(), Display.getDefault());

	/**
	 * Create an new Dialog for the creation of a FacetSet in a FacetSet.
	 * 
	 * @return the dialog.
	 */
	IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> openCreateFacetSetInFacetSetDialog();

	/**
	 * Create an new Dialog for the creation of a Facet in a FacetSet.
	 * 
	 * @return the dialog.
	 */
	IDialog<IFacetWidget> openCreateFacetInFacetSetDialog();

	/**
	 * Create an new Dialog for the creation of an Attribute in a Facet.
	 * 
	 * @return the dialog.
	 */
	IDialog<IEStructuralFeatureWidget> openAddAttributeInFacetDialog();

	/**
	 * Create an new Dialog for the creation of an Reference in a Facet.
	 * 
	 * @return the dialog.
	 */
	IDialog<IEStructuralFeatureWidget> openAddReferenceInFacetDialog();

	/**
	 * Create an new Dialog for the creation of an Operation in a Facet.
	 * 
	 * @return the dialog.
	 */
	IDialog<IDerivedTypedElementWidget> openAddOperationInFacetDialog();

	/**
	 * Create an new Dialog for the creation of a Parameter in an Operation.
	 * 
	 * @return the dialog.
	 */
	IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> openAddParameterInOperationDialog();

	/**
	 * Create an new Dialog for the edition of a FacetSet.
	 * 
	 * @return the dialog.
	 */
	IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> openEditFacetSetDialog();

	/**
	 * Create an new Dialog for the edition of a Facet.
	 * 
	 * @return the dialog.
	 */
	IDialog<IFacetWidget> openEditFacetDialog();

	/**
	 * Create an new Dialog for the edition of an Attribute.
	 * 
	 * @return the dialog.
	 */
	IDialog<IEStructuralFeatureWidget> openEditFacetAttributeDialog();

	/**
	 * Create an new Dialog for the edition of an Reference.
	 * 
	 * @return the dialog.
	 */
	IDialog<IEStructuralFeatureWidget> openEditFacetReferenceDialog();

	/**
	 * Create an new Dialog for the edition of an Operation.
	 * 
	 * @return the dialog.
	 */
	IDialog<IDerivedTypedElementWidget> openEditFacetOperationDialog();

	/**
	 * Create an new Dialog for the edition of a Parameter.
	 * 
	 * @return the dialog.
	 */
	IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> openEditFacetOperationParameterDialog();

}
