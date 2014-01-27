/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.properties.provider;

import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * 
 * The label provider for the facets
 *
 */
public class FacetLabelProvider extends LabelProvider{
	
	/**
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public String getText(final Object element) {
		if(element instanceof Facet){
			return ((Facet)element).getName();
		}
		return super.getText(element);
	}
}