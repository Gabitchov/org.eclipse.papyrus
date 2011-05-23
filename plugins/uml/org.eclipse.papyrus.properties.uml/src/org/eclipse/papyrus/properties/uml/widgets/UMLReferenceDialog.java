/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.widgets;


import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.uml.modelexplorer.widgets.UMLTreeSelectorDialog;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.widgets.editors.ReferenceDialog;
import org.eclipse.papyrus.widgets.editors.TreeSelectorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;


public class UMLReferenceDialog extends ReferenceDialog {

	public UMLReferenceDialog(final Composite parent, final int style) {
		super(parent, style);
	}


	@Override
	protected TreeSelectorDialog createDialog(final Shell shell) {
		return new UMLTreeSelectorDialog(shell);
	}


	@Override
	protected void doBinding() {
		if(modelProperty instanceof PapyrusObservableValue) {
			PapyrusObservableValue modelObservable = (PapyrusObservableValue)modelProperty;
			EObject editedEObject = modelObservable.getEObject();
			EStructuralFeature editedFeature = modelObservable.getEStructuralFeature();
			UMLTreeSelectorDialog umlDialog = (UMLTreeSelectorDialog)dialog;
			Package rootPackage = PackageUtil.getRootPackage((Element)modelObservable.getEObject());
			umlDialog.init(editedEObject, editedFeature, rootPackage, (EClass)modelObservable.getEStructuralFeature().getEType(), new LinkedList<Object>());
		}

		super.doBinding();
	}

}
