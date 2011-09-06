/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.ui.preference;

import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.core.BinaryType;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.swt.widgets.Composite;


/**
 * Used to choice a generic class
 * 
 * @author DEBLOCK Nicolas and GILES Manuel
 * 
 */
public class GenericClassFieldEditor extends StringButtonFieldEditor {

	public GenericClassFieldEditor(String name, String labelText, Composite parent) {
		super(name, labelText, parent);
	}

	@Override
	protected String changePressed() {

		// search scope
		IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
		FilteredTypesSelectionDialog d = new FilteredTypesSelectionDialog(getShell(), false, null, scope, IJavaSearchConstants.TYPE);
		d.open();
		Object[] pack = d.getResult();
		BinaryType result = (BinaryType)pack[0];
		try {
			// if it's not a generic class, generate a error message
			if(!(result.getClassFile().getType().getFullyQualifiedParameterizedName().contains("<") && result.getClassFile().getType().getFullyQualifiedParameterizedName().contains(">"))) {
				String errorMessage = "Erreur : " + result.getElementName() + " is not a generic class";
				MessageDialog.openError(getShell(), "Error", errorMessage);
				return getStringValue();
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			String errorMessage = "Erreur : " + e.getMessage();
			MessageDialog.openError(getShell(), "Error", errorMessage);
		}


		return result.getPackageFragment().getElementName() + "." + result.getElementName();
	}


}
