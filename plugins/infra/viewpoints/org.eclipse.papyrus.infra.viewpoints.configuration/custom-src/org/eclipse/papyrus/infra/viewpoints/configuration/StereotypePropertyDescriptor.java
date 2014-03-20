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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * Represents a descriptor for stereotype properties
 * @author Laurent Wouters
 */
public class StereotypePropertyDescriptor extends SurrogateItemPropertyDescriptor {
	private static final Collection<EObject> empty = new ArrayList<EObject>();
	
	public StereotypePropertyDescriptor(IItemPropertyDescriptor inner) {
		super(inner);
	}
	
	@Override
	public Collection<?> getChoiceOfValues(Object object) {
		EObject current = (EObject)object;
		while (current != null && !(current instanceof PapyrusView))
			current = current.eContainer();
		if (current == null)
			return empty;
		PapyrusView conf = (PapyrusView)current;
		List<EClass> result = new ArrayList<EClass>();
		for (EPackage p : conf.getProfiles())
			for (EClassifier c : p.getEClassifiers())
				if (c instanceof EClass)
					result.add((EClass)c);
		return result;
	}
	
	@Override
	public IItemLabelProvider getLabelProvider(Object object) {
		return new IItemLabelProvider() {
			public String getText(Object object) {
				if (object instanceof EClass)
					return eClassToString((EClass)object);
				if (object instanceof EList<?>) {
					EList<?> list = (EList<?>)object;
					if (list.isEmpty())
						return "";
					StringBuilder builder = new StringBuilder("{");
					for (int i=0; i!=list.size(); i++) {
						if (i != 0)
							builder.append(", ");
						builder.append(eClassToString((EClass)list.get(i)));
					}
					builder.append("}");
					return builder.toString();
				}
				return "";
			}
			public Object getImage(Object object) { return null; }
		};
	}
	
	private String eClassToString(EClass item) {
		return item.getEPackage().getNsPrefix() + "#" + item.getName();
	}
}
