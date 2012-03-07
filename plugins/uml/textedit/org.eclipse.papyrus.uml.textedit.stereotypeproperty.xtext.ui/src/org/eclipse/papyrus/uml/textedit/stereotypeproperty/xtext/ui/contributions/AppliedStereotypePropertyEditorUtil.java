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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contributions;

import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class AppliedStereotypePropertyEditorUtil {

	public static String getLabel(AppliedStereotypeProperty  appliedStereotypeProperty) {
		
		final Property property = appliedStereotypeProperty.getStereotypeProperty();
		final Stereotype stereotype=appliedStereotypeProperty.getStereotype();
		final Element umlElement=appliedStereotypeProperty.getBaseElement();


		String result= StereotypeUtil.displayPropertyValue(stereotype, property, umlElement, "");
		if(!( result.contains("="))){			
			result=result+"= null";
		}
		return result;
	}
	
}
