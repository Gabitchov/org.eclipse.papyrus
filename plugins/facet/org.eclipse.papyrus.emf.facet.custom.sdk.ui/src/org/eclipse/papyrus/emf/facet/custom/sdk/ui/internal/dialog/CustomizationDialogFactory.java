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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.dialog;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.dialog.ICustomizationDialogFactory;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.command.AddCaseQueryDialog;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.command.AddCustomizationPropertyDialog;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.command.CreateEClassCustomizationDialog;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.command.CreateFacetCustomizationDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.handler.HandlerUtils;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.SynchronizedAbstractDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.swt.widgets.Display;

/**
 * Concrete implementation of {@link ICustomizationDialogFactory}.
 * 
 * @see ICustomizationDialogFactory
 */
public class CustomizationDialogFactory implements ICustomizationDialogFactory {

	protected static void openDialog(final IDialog<?> dialog,
			final Display display) {
		display.asyncExec(new Runnable() {
			public void run() {
				dialog.open();
			}
		});
	}

	public IDialog<ICommandWidget> openCreateEClassCustomizationDialog(
			final Display display,
			final EditingDomain editingDomain) {
		final IDialog<ICommandWidget> dialog = new CreateEClassCustomizationDialog(
				(Customization) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog, display);
		return new SynchronizedAbstractDialog<ICommandWidget>(dialog, display);
	}

	public IDialog<ICommandWidget> openCreateFacetCustomizationDialog(
			final Display display,
			final EditingDomain editingDomain) {
		final IDialog<ICommandWidget> dialog = new CreateFacetCustomizationDialog(
				(Customization) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog, display);
		return new SynchronizedAbstractDialog<ICommandWidget>(dialog, display);
	}

	public IDialog<ICommandWidget> openAddCustomizationPropertyDialog(
			final Display display,
			final EditingDomain editingDomain) {
		final IDialog<ICommandWidget> dialog = new AddCustomizationPropertyDialog(
				(EClassCustomization) HandlerUtils.getSelection(),
				editingDomain);
		openDialog(dialog, display);
		return new SynchronizedAbstractDialog<ICommandWidget>(dialog, display);
	}

	public IDialog<ICommandWidget> openAddCaseQueryDialog(
			final Display display,
			final EditingDomain editingDomain) {
		final IDialog<ICommandWidget> dialog = new AddCaseQueryDialog(
				(ETypedElementCase) HandlerUtils.getSelection(), editingDomain);
		openDialog(dialog, display);
		return new SynchronizedAbstractDialog<ICommandWidget>(dialog, display);
	}

}
