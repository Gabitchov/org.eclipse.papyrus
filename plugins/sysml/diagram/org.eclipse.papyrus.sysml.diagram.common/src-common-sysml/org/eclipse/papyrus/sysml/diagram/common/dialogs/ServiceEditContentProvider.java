/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.dialogs;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.services.edit.utils.ElementTypeValidator;
import org.eclipse.papyrus.uml.modelexplorer.widgets.UMLElementMEBContentProvider;

/**
 * A content provider that takes into account the nature of the searched element
 * (adapted from org.eclipse.papyrus.uml.modelexplorer.widgets.ServiceEditFilteredUMLContentProvider).
 */
public class ServiceEditContentProvider extends UMLElementMEBContentProvider {

	private ElementTypeValidator validator;

	public ServiceEditContentProvider(IElementType elementType, EStructuralFeature feature, EObject semanticRoot) {
		super(semanticRoot, "history_" + feature.getEType().getEPackage().getName() + ":" + feature.getEType().getName() + ":" + feature.getName()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		setMetaClassWanted(feature.getEType());
		setMetaClassNotWanted(Collections.emptyList());
		validator = new ElementTypeValidator(elementType);
	}

	@Override
	public boolean isValidValue(Object element) {
		return super.isValidValue(element) && validator.validate(new Object[]{getAdaptedValue(element)}).isOK();
	}
}
