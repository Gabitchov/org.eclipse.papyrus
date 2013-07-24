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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;

/**
 * Label Provider for problem
 * 
 * @author VL222926
 * 
 */
public class ProblemLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		return element instanceof Problem;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider#getText(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected String getText(final EObject element) {
		final Problem pb = (Problem)element;
		final String text = "#Problem: " + pb.getName() + "Description: " + pb.getDescription(); //$NON-NLS-1$ //$NON-NLS-2$
		return text;
	}


}
