/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

public class ContextUtil {
	public static Type getExpectedType(EObject rule) {
		EObject context = rule ;
		while (context != null && !(context instanceof TagSpecificationRule)) {
			context = context.eContainer() ;
		}
		if (context != null) {
			TagSpecificationRule tag = (TagSpecificationRule) context ;
			if (tag.getProperty() != null)
				return tag.getProperty().getType() ;
		}
		return null ;
	}
	
	public static Element getContextElement(EObject rule) {
		EObject context = rule ;
		while (context != null && !(context instanceof TagSpecificationRule)) {
			context = context.eContainer() ;
		}
		if (context != null) {
			TagSpecificationRule tag = (TagSpecificationRule) context ;
			return tag.getProperty() ;
		}
		return null ;
	}
}
