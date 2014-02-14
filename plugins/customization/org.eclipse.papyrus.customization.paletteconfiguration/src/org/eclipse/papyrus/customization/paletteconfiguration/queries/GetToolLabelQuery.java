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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.customization.paletteconfiguration.queries;

import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;

/** Returns the Label for a tool. */
public class GetToolLabelQuery implements IJavaQuery2<ToolConfiguration, String> {

	public String evaluate(ToolConfiguration source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		StringBuffer buffer = new StringBuffer();
		buffer.append('[');
		switch(source.getKind()) {
		case CONNECTION_TOOL:
			buffer.append("Connection Tool");
			break;
		default:
			buffer.append("Node Tool");
			break;
		}
		buffer.append(']');
		buffer.append(' ');


		buffer.append(source.getLabel());
		return buffer.toString();
	}
}
