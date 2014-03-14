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
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * Represents a descriptor for properties of type EReference
 * @author Laurent Wouters
 */
public class EReferencePropertyDescriptor extends SurrogateItemPropertyDescriptor {
	private static final Collection<?> empty = new ArrayList<EReference>();
	
	public EReferencePropertyDescriptor(IItemPropertyDescriptor inner) {
		super(inner);
	}
	
	@Override
	public Collection<?> getChoiceOfValues(Object object) {
		PathElement pe = (PathElement)object;
		EClass origin = pe.getOrigin();
		if (origin == null)
			return empty;
		return origin.getEAllReferences();
	}
}