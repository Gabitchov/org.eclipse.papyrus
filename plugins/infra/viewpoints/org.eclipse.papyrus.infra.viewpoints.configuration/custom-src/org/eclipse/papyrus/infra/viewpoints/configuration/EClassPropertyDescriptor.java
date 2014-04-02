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
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * Represents a descriptor for properties of type EClass
 * @author Laurent Wouters
 */
public class EClassPropertyDescriptor extends SurrogateItemPropertyDescriptor {
	private static final Collection<EObject> empty = new ArrayList<EObject>();
	
	public EClassPropertyDescriptor(IItemPropertyDescriptor inner) {
		super(inner);
	}
	
	@Override
	public Collection<?> getChoiceOfValues(Object object) {
		EObject current = (EObject)object;
		while (current != null && !(current instanceof PapyrusConfiguration))
			current = current.eContainer();
		if (current == null)
			return empty;
		PapyrusConfiguration conf = (PapyrusConfiguration)current;
		List<EClass> result = new ArrayList<EClass>();
		EPackage p = conf.getMetamodel();
		if (p == null)
			return result;
		for (EClassifier c : p.getEClassifiers())
			if (c instanceof EClass)
				result.add((EClass)c);
		return result;
	}
}
