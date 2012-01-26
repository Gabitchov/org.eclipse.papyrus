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
package org.eclipse.papyrus.uml.textedit.property.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.textedit.property.xtext.validation.UmlPropertyJavaValidator;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Package ;
import org.eclipse.xtext.gmf.glue.contentassist.CompletionProposalUtils;

public class UMLPropertyEditorPropertyUtil extends PropertyUtil {

	public static String getLabel(Property property) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		buffer.append(NamedElementUtil.getVisibilityAsSign(property));

		// derived property
		buffer.append(getDerived(property));

		// name
		buffer.append(" ");
		buffer.append(getName(property));

		// type
		if(property.getType() != null) {
			buffer.append(" : " + CompletionProposalUtils.getQualifiedNameLabelWithSufficientDepth(property.getType(), UmlPropertyJavaValidator.getModel()));
		} else {
			buffer.append(" : " + TypeUtil.UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
		if(!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}

		// property modifiers
		buffer.append(" ") ;
		buffer.append(PropertyUtil.getModifiersAsString(property, false));
		
		// default value
		if(property.getDefault() != null) {
			buffer.append(" = ");
			buffer.append("\"" + property.getDefault() + "\"");
		}
		
		
		return buffer.toString();
	}
	
}
