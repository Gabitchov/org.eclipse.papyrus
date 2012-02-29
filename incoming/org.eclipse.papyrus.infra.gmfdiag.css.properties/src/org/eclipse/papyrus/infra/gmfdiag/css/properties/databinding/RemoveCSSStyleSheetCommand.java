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
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.custom.RemoveCustomStyleListValueCommand;


public class RemoveCSSStyleSheetCommand extends RemoveCustomStyleListValueCommand {

	protected Resource previousResource;

	public RemoveCSSStyleSheetCommand(EditingDomain domain, View view, String styleName, EClass eClass, EStructuralFeature feature, Object value) {
		super(domain, view, styleName, eClass, feature, value);
	}

	@Override
	public void execute() {
		if(value instanceof EObject) {
			EObject eObject = (EObject)value;
			Map<EObject, Collection<EStructuralFeature.Setting>> references = EcoreUtil.CrossReferencer.find(Collections.singletonList(eObject));
			//We're removing the last reference to this styleSheet (Only if the stylesheet is contained
			//in the same resource as the view referencing it... We don't modify external models)
			if(references.size() == 1 && eObject.eResource() == view.eResource()) {
				previousResource = eObject.eResource();
				eObject.eResource().getContents().remove(eObject);
			}
		}

		super.execute();
	}

	@Override
	public void undo() {
		//We destroyed the StyleSheet EObject: recreate it in its previous resource
		if(previousResource != null) {
			previousResource.getContents().add((EObject)value);
		}
		super.undo();
	}

}
