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
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.Collections;
import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;


public class SelectOrCreateDialogEditor extends ReferenceDialog {

	protected SelectOrCreateDialog selectOrCreateDialog;

	public SelectOrCreateDialogEditor(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected ITreeSelectorDialog createDialog(Shell shell) {
		return selectOrCreateDialog = new SelectOrCreateDialog(shell, "title", null, null, null, Collections.EMPTY_LIST, new LinkedHashMap());
	}

	//	public void setCreateAs(EClass createAs) {
	//		//Unsupported yet
	//	}

	public void setCreateAs(EClass createAs, EObject inParentObject, EStructuralFeature feature) {
		selectOrCreateDialog.setCreateAs(createAs, inParentObject, feature);
	}

	public void setEditingDomain(EditingDomain domain) {
		selectOrCreateDialog.setEditingDomain(domain);
	}

}
