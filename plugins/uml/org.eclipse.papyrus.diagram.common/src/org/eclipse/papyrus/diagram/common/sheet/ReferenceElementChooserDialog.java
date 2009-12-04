/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.sheet;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.diagram.common.part.UMLElementChooserDialog;
import org.eclipse.swt.widgets.Shell;

public class ReferenceElementChooserDialog extends UMLElementChooserDialog {

	private final EObject mySourceObject;

	private final EStructuralFeature myFeature;

	/*
	 * We assume that sourceObject is not null
	 */
	public ReferenceElementChooserDialog(Shell parentShell, AdapterFactory itemProvidersAdapterFactory,
			EObject sourceObject, EStructuralFeature feature) {
		super(parentShell, itemProvidersAdapterFactory);
		mySourceObject = sourceObject;
		myFeature = feature;
	}

	@Override
	protected void setSelection(TreeViewer treeViewer) {
		Object featureValue = mySourceObject.eGet(myFeature);
		if(featureValue != null) {
			treeViewer.expandToLevel(3);
			treeViewer.setSelection(new StructuredSelection(featureValue), true);
		}
	}

	@Override
	protected void setInput(TreeViewer treeViewer) {
		treeViewer.setInput(mySourceObject.eResource());
	}

}
