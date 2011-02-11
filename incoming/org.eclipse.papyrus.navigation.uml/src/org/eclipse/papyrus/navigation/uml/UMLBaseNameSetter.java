/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigation.uml;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.navigation.IBaseNameSetter;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.uml2.uml.NamedElement;


public class UMLBaseNameSetter implements IBaseNameSetter {
	
	public static final UMLBaseNameSetter instance = new UMLBaseNameSetter();
	
	private UMLBaseNameSetter() {
	}

	public void setBaseName(String base, EObject toName) {
		if (toName instanceof NamedElement) {
			NamedElement namedElement = (NamedElement)toName;

			List<EObject> contents;
			if (namedElement.eContainer() != null) {
				contents = namedElement.eContainer().eContents();
			} else {
				contents = Collections.EMPTY_LIST;
			}

			namedElement.setName(NamedElementUtil.getDefaultNameWithIncrement(base, namedElement, contents));
		}
	}

}
