/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.actions.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.common.actions.LabelHelper;
import org.eclipse.uml2.uml.NamedElement;

public class UMLClipboardActionHandler extends ClipboardActionHandler {

	@Override
	protected void prepareEObject(EObject eObject) {
		if(eObject instanceof NamedElement) {
			NamedElement namedElement = (NamedElement)eObject;
			namedElement.setName(LabelHelper.INSTANCE.findName(eObject.eContainer(), namedElement));
		}
	}
}
