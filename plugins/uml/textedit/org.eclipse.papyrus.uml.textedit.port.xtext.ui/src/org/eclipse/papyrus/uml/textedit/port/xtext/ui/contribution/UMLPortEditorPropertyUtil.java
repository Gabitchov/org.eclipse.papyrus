/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.port.xtext.ui.contribution;

import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.contentassist.CompletionProposalUtils;
import org.eclipse.papyrus.uml.alf.naming.ALFIDConverter;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PortUtil;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

public class UMLPortEditorPropertyUtil extends PortUtil {

	public static String getLabel(Property property) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		buffer.append(NamedElementUtil.getVisibilityAsSign(property));

		// derived property
		buffer.append(getDerived(property));

		// name
		buffer.append(" ");
		buffer.append(ALFIDConverter.nameToID(getName(property)));

		// is conjugated
		if (((Port) property).isConjugated()) {
			buffer.append(": ~");
		} else {
			buffer.append(": ");
		}
		// type
		if (property.getType() != null) {

			buffer.append(CompletionProposalUtils.getQualifiedNameLabelWithSufficientDepth(property.getType(),
					property.getNamespace()));
		} else {
			buffer.append(TypeUtil.UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
		if (!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}

		// property modifiers
		buffer.append(" ");
		buffer.append(PropertyUtil.getModifiersAsString(property, false));

		// default value
		if (property.getDefault() != null) {
			buffer.append(" = ");
			buffer.append("\"" + property.getDefault() + "\"");
		}

		return buffer.toString();
	}

}
