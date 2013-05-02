/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.SetCustomStyleListValueCommand;

//TODO: This a remove & add command
//This command is currently never called in Papyrus
//See DiagramStyleSheetObservableList#getSetCommand(int, Object)
public class SetCSSStyleSheetCommand extends SetCustomStyleListValueCommand {

	public SetCSSStyleSheetCommand(EditingDomain domain, View view, String styleName, EClass eClass, EStructuralFeature feature, int index, Object value) {
		super(domain, view, styleName, eClass, feature, index, value);
		//TODO: implement execute & undo
		throw new UnsupportedOperationException();
	}

	@Override
	public void execute() {
		//TODO: Check whether we're removing an element. If so, remove it (And delete it, eventually).
		//In any case, create the new element and add it in the resource. Keep track of each.
		super.execute();
	}

	@Override
	public void undo() {
		//TODO: If an element has been removed, recreate it and add it in the view's resource
		//Remove the newly created element
		super.undo();
	}

}
