/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.qompass.designer.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.qompass.designer.core.CommandSupport;
import org.eclipse.papyrus.qompass.designer.core.commands.AddMarteAndFcmProfile;
import org.eclipse.papyrus.qompass.designer.core.commands.AddQompassModelLibs;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

/**
 * This class adds the FCM profile, parts of the MARTE profile and required package imports to your model.
 */
public class AddProfileAndModelLibsHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		if(selectedEObject instanceof Package) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(!(selectedEObject instanceof Package)) {
			return null;
		}
		final Package selectedPkg = (Package)selectedEObject;

		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(selectedPkg);
		AddMarteAndFcmProfile addProfiles = new AddMarteAndFcmProfile(selectedPkg,
				AddMarteAndFcmProfile.APPLY_FCM | AddMarteAndFcmProfile.APPLY_ALLOC | AddMarteAndFcmProfile.APPLY_HLAM_GCM,
				domain);
		AddQompassModelLibs addModelLibs = new AddQompassModelLibs(selectedPkg, domain);
	
		final ListSelectionDialog dialog = new ListSelectionDialog(new Shell(),
			addModelLibs.getAvailableImportPackages().toArray(),
			new ArrayContentProvider(),
			new LabelProvider() {

				public String getText(Object pi) {
					return ((PackageImport)pi).getImportedPackage().getName();
				}
			},
			"Select Qompass model libraries for package import.\n" + //$NON-NLS-1$
				"Libraries that are already imported, are selected. Please note that additional\n" + //$NON-NLS-1$
				"Qompass model library might be loaded with the standard \"import registered library\" option\n" + //$NON-NLS-1$
				"\n" +//$NON-NLS-1$
				"Pressing \"Ok\" will continue with the application of the FCM profile and (parts of) the MARTE profile\n");//$NON-NLS-1$

		dialog.setTitle("Select import library"); //$NON-NLS-1$
		dialog.setInitialElementSelections(addModelLibs.getAlreadyImportedPackages());
		// dialog.setElements (list.toArray ());
		int result = dialog.open();
		if(result == IDialogConstants.OK_ID) {
			addModelLibs.setImportList(dialog.getResult());
			CommandSupport.exec(addModelLibs);
			CommandSupport.exec(addProfiles);
			// open dialog?
			// MessageDialog.openWarning(new Shell(),
			//	"Warning", "The MARTE profile is not available."); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return null;
	}
}
