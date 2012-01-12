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
package org.eclipse.papyrus.customization.properties.providers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.views.properties.contexts.Property;

/**
 * A Content provider to retrieve all available properties in the current
 * contexts
 * 
 * @author Camille Letavernier
 */
public class PropertyContentProvider extends AbstractContextualContentProvider implements IHierarchicContentProvider {

	/**
	 * Constructor.
	 * 
	 * @param source
	 *        The source from which the contexts will be retrieved
	 */
	public PropertyContentProvider(EObject source) {
		super(source);
	}

	public Object[] getElements() {
		return contexts.toArray();
	}

	public Object[] getElements(Object inputElement) {
		return getElements();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof Context) {
			Context parent = (Context)parentElement;
			return parent.getDataContexts().toArray();
		} else if(parentElement instanceof DataContextElement) {
			List result = new LinkedList();
			if(parentElement instanceof DataContextPackage) {
				DataContextPackage contextPackage = (DataContextPackage)parentElement;
				result.addAll(contextPackage.getElements());
			}
			DataContextElement element = (DataContextElement)parentElement;
			result.addAll(element.getProperties());
			Iterator<?> it = result.iterator();
			while(it.hasNext()) {
				Object value = it.next();
				if(isEmpty(value)) {
					it.remove();
				}
			}
			return result.toArray();
		} else {
			return new Object[0];
		}
	}

	protected boolean isEmpty(Object element) {
		if(element instanceof DataContextPackage) {
			DataContextPackage dcPackage = (DataContextPackage)element;
			return dcPackage.getElements().isEmpty() && dcPackage.getProperties().isEmpty();
		} else if(element instanceof DataContextElement) {
			return ((DataContextElement)element).getProperties().isEmpty();
		} else if(element instanceof Context) {
			return ((Context)element).getDataContexts().isEmpty();
		}

		return false;
	}

	public Object getParent(Object element) {
		if(element instanceof Property) {
			return ((Property)element).getContextElement();
		} else if(element instanceof DataContextElement) {
			return ((DataContextElement)element).getPackage();
		} else {
			return null;
		}
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public boolean isValidValue(Object element) {
		return element instanceof Property;
	}

}
