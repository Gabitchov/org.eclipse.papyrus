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

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;

/** Returns the Label for a tool. */
public class GetToolLabelQuery implements IJavaModelQuery<ToolConfiguration, String> {

	/**
	 * {@inheritDoc}
	 */
	public String evaluate(final ToolConfiguration context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		StringBuffer buffer = new StringBuffer();
		buffer.append('[');
		switch(context.getKind()) {
		case CONNECTION_TOOL:
			buffer.append("Connection Tool");
			break;
		default:
			buffer.append("Node Tool");
			break;
		}
		buffer.append(']');
		buffer.append(' ');


		buffer.append(context.getLabel());

		//		// retrieves list of types to create
		//		List<IElementType> typesToCreate = new ArrayList<IElementType>();
		//		for(ElementDescriptor descriptor : context.getElementDescriptors()) {
		//			IElementType type = ExtendedTypesRegistry.getInstance().getType(descriptor.getElementTypeId());
		//			if(type != null) {
		//				typesToCreate.add(type);
		//			}
		//		}
		//
		//		// filter the list (removes all elements that create the same metaclass, but with different representation. this is caused by standard GMF tooling generation
		//		List<IElementType> filteredList = new ArrayList<IElementType>();
		//		for(IElementType type : typesToCreate) {
		//			boolean toAdd = true;
		//			for(IElementType typeInFilteredList : filteredList) {
		//				boolean isEquivalent = ElementTypeUtils.isSemanticallyEquivalent(typeInFilteredList, type);
		//				if(isEquivalent) {
		//					toAdd = false;
		//				}
		//			}
		//
		//			if(toAdd) {
		//				filteredList.add(type);
		//			}
		//		}
		//
		//		Iterator<IElementType> it = filteredList.iterator();
		//		while(it.hasNext()) {
		//			IElementType type = it.next();
		//			buffer.append(type.getDisplayName());
		//			if(it.hasNext()) {
		//				buffer.append(", ");
		//			}
		//		}

		return buffer.toString();
	}
}
