/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.swt.widgets.Shell;


/**
 * Interface for access to a {@link Dialog} to prompt the user for specification of the resource to create for a new model unit.
 * Implementations are accessed by adaptation of the contextual {@code ModelSet}.  Where no adapter is provided, the
 * {@linkplain #DEFAULT default provider} is used.
 */
public interface IControlModeFragmentDialogProvider {
	/**
	 * The default provider used when the {@link ModelSet} does not supply one, or in case a
	 * custom provider wishes to delegate responsibility.  The default provider creates a dialog
	 * that lets the user browse the workspace and/or local filesystem for resource URIs.
	 */
	IControlModeFragmentDialogProvider DEFAULT = new IControlModeFragmentDialogProvider() {
		
		public Dialog createDialog(Shell shell, Resource parentUnit, String defaultUnitName) {
			return new CreateModelFragmentDialog(shell, parentUnit, defaultUnitName);
		}
		
		public URI getSelectedURI(Dialog dialog) {
			URI result = null;
			
			if ((dialog.getClass() == CreateModelFragmentDialog.class) && (dialog.getReturnCode() == Window.OK)) {
				result = ((CreateModelFragmentDialog) dialog).getURI();
			}
			
			return result;
		}
	};
	
	/**
	 * Create a new dialog to solicit the new model unit's URI from the user.  The new dialog is <em>not</em> opened.
	 * 
	 * @param shell the new dialog's parent shell
	 * @param parentUnit the model unit from which a sub-unit is to be carved out
	 * @param defaultUnitName the default suggested name of the new sub-unit.  Will not be {@code null}
	 * 
	 * @return the fragment resource URI selection dialog
	 */
	Dialog createDialog(Shell shell, Resource parentUnit, String defaultUnitName);
	
	/**
	 * Obtains the model unit URI selected by the user in the given {@code dialog}.  If that {@code dialog} was cancelled or was not
	 * created by this provider, then the result must be {@code null}.
	 *  
	 * @param dialog a dialog created by this provider that has been completed by the user
	 * 
	 * @return the URI selected by the user, or {@code null} if cancelled or an unrecognized dialog
	 */
	URI getSelectedURI(Dialog dialog);
}
