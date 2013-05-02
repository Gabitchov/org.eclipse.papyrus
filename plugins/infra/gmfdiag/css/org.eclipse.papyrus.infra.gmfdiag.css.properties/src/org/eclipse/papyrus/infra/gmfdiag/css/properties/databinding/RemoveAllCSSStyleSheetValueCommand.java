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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.RemoveAllCustomStyleListValueCommand;


public class RemoveAllCSSStyleSheetValueCommand extends RemoveAllCustomStyleListValueCommand {

	protected final Set<EObject> deletedEObjects = new HashSet<EObject>();

	public RemoveAllCSSStyleSheetValueCommand(EditingDomain domain, View view, String styleName, EClass eClass, EStructuralFeature feature, Collection<?> values) {
		super(domain, view, styleName, eClass, feature, values);
	}

	@Override
	public void execute() {
		for(Object value : values) {
			if(value instanceof EObject) {
				EObject styleSheet = (EObject)value;
				Collection<EStructuralFeature.Setting> references = EMFHelper.getUsages(styleSheet);
				//We're removing the last reference to this styleSheet (Only if the stylesheet is contained
				//in the same resource as the view referencing it... We don't modify external models)
				if(references.size() == 1 && styleSheet.eResource() == view.eResource()) {
					deletedEObjects.add(styleSheet);
					styleSheet.eResource().getContents().remove(styleSheet);
				}
			}
		}

		super.execute();
	}

	@Override
	public void undo() {
		for(Object value : values) {
			if(value instanceof EObject) {
				EObject eObject = (EObject)value;
				if(deletedEObjects.contains(eObject)) {
					//We destroyed the StyleSheet EObject: recreate it in its previous resource
					view.eResource().getContents().add(eObject);
				}
			}
		}
		super.undo();
	}

}
