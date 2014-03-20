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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * Represents a descriptor for properties of type EList of EPackage
 * This class lists the currently loaded ECore metamodels.
 * @author Laurent Wouters
 */
public class ProfilePropertyDescriptor extends EPackagePropertyDescriptor {
	public ProfilePropertyDescriptor(IItemPropertyDescriptor inner) {
		super(inner);
	}
	
	@Override
	public IItemLabelProvider getLabelProvider(Object object) {
		return new IItemLabelProvider() {
			public String getText(Object object) {
				if (object instanceof EPackage)
					return ((EPackage)object).getNsURI();
				if (object instanceof EList<?>) {
					EList<?> list = (EList<?>)object;
					if (list.isEmpty())
						return "";
					StringBuilder builder = new StringBuilder("{");
					for (int i=0; i!=list.size(); i++) {
						if (i != 0)
							builder.append(", ");
						builder.append(((EPackage)list.get(i)).getNsURI());
					}
					builder.append("}");
					return builder.toString();
				}
				return "";
			}
			public Object getImage(Object object) { return null; }
		};
	}
}
