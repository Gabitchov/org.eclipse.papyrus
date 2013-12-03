/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.deployment.dialog;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class AttributeLabelProvider extends LabelProvider {

	public String getText(Object element) {
		if(element instanceof Property) {
			Property p = (Property)element;
			Type type = p.getType();
			return p.getClass_().getName() + "." + p.getName() + ((type != null) ?
				" : " + type.getQualifiedName() :
				"");
		}
		else {
			return "invalid";
		}
	}
};
