/*****************************************************************************
 * Copyright (c) 2012 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;

/**
 * Return true if the selection is a package
 * 
 * @author arthur daussy
 * 
 */
public class UMLPackageSelectionTester extends PropertyTester {

	/** Tester ID for UML Call Action nature */
	public final static String IS_PACKAGE = "isUMLPackage";

	public UMLPackageSelectionTester() {
	}

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		// Ensure Papyrus is the active editor
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if((editor == null) || (!(editor instanceof IMultiDiagramEditor))) {
			return false;
		}
		Object currentValue = null;
		if(IS_PACKAGE.equals(property)) {
			if(receiver instanceof StructuredSelection) {
				StructuredSelection structuredSelection = (StructuredSelection)receiver;
				Object obj = structuredSelection.getFirstElement();
				EObject element = null;
				if(obj instanceof IAdaptable) {
					element = (EObject)((IAdaptable)obj).getAdapter(EObject.class);
					if(element instanceof View) {
						element = ((View)element).getElement();
					}
				}
				currentValue = element instanceof Package;
			}
			return (currentValue == expectedValue);
		}
		return false;
	}
}
