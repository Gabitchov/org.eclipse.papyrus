/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;

/**
 * Represents a descriptor for properties of type EClass
 * This is used for the ModelAutoCreate.target property because we may want to create stereotyped elements
 * 
 * @author Laurent Wouters
 */
public class ComplexTypePropertyDescriptor extends SurrogateItemPropertyDescriptor {
	private static final Collection<EObject> empty = new ArrayList<EObject>();
	private List<String> result;

	public ComplexTypePropertyDescriptor(IItemPropertyDescriptor inner) {
		super(inner);
		result = new ArrayList<String>();
		try {
			IClientContext context = TypeContext.getContext();
			IElementType[] types = ElementTypeRegistry.getInstance().getElementTypes(context);
			if (types != null) {
				for (IElementType type : types) {
					result.add(type.getId());
				}
			}
			Collections.sort(result);
		} catch (ServiceException e) {
		}
	}

	@Override
	public Collection<?> getChoiceOfValues(Object object) {
		EObject current = (EObject) object;
		if (current == null)
			return empty;
		return result;
	}
}
