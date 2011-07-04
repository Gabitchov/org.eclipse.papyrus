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
package org.eclipse.papyrus.uml.modelexplorer.widgets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.modelexplorer.widgets.EditServiceValidator;

public class ServiceEditFilteredUMLContentProvider extends UMLElementMEBContentProvider {

	private EditServiceValidator validator;

	public ServiceEditFilteredUMLContentProvider(EObject editedObject, EStructuralFeature feature, EObject semanticRoot) {
		super(semanticRoot, "history_" + feature.getEType().getEPackage().getName() + ":" + feature.getEType().getName() + ":" + feature.getName());
		validator = new EditServiceValidator(editedObject, feature);
	}

	@Override
	public boolean isValidValue(Object element) {
		return super.isValidValue(element) && validator.isValidValue(element);
	}

}
