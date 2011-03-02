/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.customization.providers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.properties.contexts.DataContextRoot;
import org.eclipse.papyrus.properties.contexts.Property;

/**
 * A Content provider to retrieve all available properties in the current
 * contexts
 * 
 * @author Camille Letavernier
 */
public class PropertyContentProvider extends AbstractContextualContentProvider {

	/**
	 * Constructor.
	 * 
	 * @param source
	 *        The source from which the contexts will be retrieved
	 */
	public PropertyContentProvider(EObject source) {
		super(source);
	}

	public Property[] getElements() {
		if(contexts == null || contexts.isEmpty()) {
			return new Property[0];
		}

		List<Property> result = new LinkedList<Property>();
		for(Context context : contexts) {
			for(DataContextRoot root : context.getDataContexts()) {
				result.addAll(findProperties(root));
			}
		}

		return result.toArray(new Property[result.size()]);
	}

	private Collection<Property> findProperties(DataContextElement element) {
		List<Property> result = new LinkedList<Property>();
		result.addAll(element.getProperties());
		if(element instanceof DataContextPackage) {
			for(DataContextElement subElement : ((DataContextPackage)element).getElements()) {
				result.addAll(findProperties(subElement));
			}
		}
		return result;
	}

}
