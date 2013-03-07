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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.filters;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * A specific kind of filter that can filter UML based results
 * 
 */
public class TypesMatchFilter extends MatchFilter {

	private Object[] selectedTypes;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param types
	 *        the collection of types whose instance are NOT filtered
	 */
	public TypesMatchFilter(Object[] types) {
		this.selectedTypes = types;
	}

	@Override
	public String getName() {
		return Messages.TypesMatchFilter_0;
	}

	@Override
	public String getID() {
		return "TypesMatchFilter"; //$NON-NLS-1$
	}

	@Override
	public String getDescription() {
		return Messages.TypesMatchFilter_2;
	}

	@Override
	public String getActionLabel() {
		return Messages.TypesMatchFilter_3;
	}

	@Override
	public boolean filters(Match match) {
		if(match instanceof AbstractResultEntry) {
			List<Object> selectedTypesList = Arrays.asList(selectedTypes);

			Object elementToValidate = ((AbstractResultEntry)match).elementToCheckFilterFor();

			if(elementToValidate instanceof Element) {

				if(selectedTypesList.contains(((Element)elementToValidate).eClass())) {
					return false;
				}
				for(Object object : selectedTypesList) {
					if(((Element)elementToValidate).getAppliedStereotypes().contains(object)) {
						return false;
					}
				}
				return true;
			}
		}

		return false;
	}
}
