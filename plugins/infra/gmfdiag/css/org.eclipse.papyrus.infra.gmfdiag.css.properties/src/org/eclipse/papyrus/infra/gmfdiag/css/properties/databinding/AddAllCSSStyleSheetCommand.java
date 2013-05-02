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
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.AddAllCustomStyleListValueCommand;


public class AddAllCSSStyleSheetCommand extends AddAllCustomStyleListValueCommand {

	protected final Set<EObject> createdEObjects = new HashSet<EObject>();

	public AddAllCSSStyleSheetCommand(EditingDomain domain, View view, String styleName, EClass styleClass, EStructuralFeature styleFeature, Collection<?> values, int index) {
		super(domain, view, styleName, styleClass, styleFeature, values, index);
	}

	public AddAllCSSStyleSheetCommand(EditingDomain domain, View view, String styleName, EClass styleClass, EStructuralFeature feature, Collection<?> values) {
		super(domain, view, styleName, styleClass, feature, values);
	}

	@Override
	public void execute() {
		for(Object value : values) {
			if(value instanceof EObject) {
				EObject eObject = (EObject)value;
				if(eObject.eResource() == null) {
					view.eResource().getContents().add(eObject);
					createdEObjects.add(eObject);
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
				if(createdEObjects.contains(eObject)) {
					eObject.eResource().getContents().remove(eObject);
				}
			}
		}
		super.undo();
	}

}
