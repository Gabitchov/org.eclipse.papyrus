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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem;
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
		if(pb instanceof StringResolutionProblem) {
			return ((StringResolutionProblem)pb).getValueAsString();
		}
		return pb.getDescription();
	}

	/**
	 * 
	 * @param element
	 *        a problem
	 * @return
	 *         the text to display for a problem in a tooltip
	 */
	//TODO : should be obtained using a service or a specific wrapper to get tooltip
	public String getTooltipText(final EObject element) {
		if(element instanceof Problem) {
			final Problem problem = (Problem)element;
			final StringBuilder builder = new StringBuilder();
			if(problem instanceof StringResolutionProblem) {
				final List<String> unresolvedStrings = ((StringResolutionProblem)problem).getUnresolvedString();
				builder.append(NLS.bind(Messages.ProblemLabelProvider_StringsValuesCanBeResolved,unresolvedStrings.size()));
				if(unresolvedStrings.size() == 1) {
					builder.append(" "); //$NON-NLS-1$
					builder.append(unresolvedStrings.get(0));
				} else {
					final Iterator<String> iterOnString = ((StringResolutionProblem)problem).getUnresolvedString().iterator();
					while(iterOnString.hasNext()) {
						builder.append("\n\t- "); //$NON-NLS-1$
						builder.append(iterOnString.next());
					}
				}
			} else {
				builder.append(((Problem)problem).getDescription());
			}
			return builder.toString();
		}
		return null;
	}

}
