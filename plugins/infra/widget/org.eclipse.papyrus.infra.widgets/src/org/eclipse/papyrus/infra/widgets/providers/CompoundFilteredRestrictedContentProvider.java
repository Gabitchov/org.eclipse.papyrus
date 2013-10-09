/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * This class allows to use several content provider for the same widget
 * + restriction behavior see {@link IRestrictedContentProvider} documentation
 * 
 * @author JC236769
 * 
 */
public class CompoundFilteredRestrictedContentProvider extends AbstractFilteredContentProvider implements IRestrictedContentProvider {

	private List<IRestrictedContentProvider> encapsulatedContentProviders = new ArrayList<IRestrictedContentProvider>();

	public boolean add(IRestrictedContentProvider o) {
		if(o != null) {
			return encapsulatedContentProviders.add(o);
		}
		return false;
	}


	public Object[] getElements(Object inputElement) {
		Collection<Object> asList = new HashSet<Object>();

		for(IRestrictedContentProvider encapsulatedContentProvider : encapsulatedContentProviders) {
			Object[] directElements = encapsulatedContentProvider.getElements(inputElement);
			asList.addAll(Arrays.asList(directElements));
		}
		return asList.toArray();
	}


	public Object[] getChildren(Object parentElement) {
		Collection<Object> asList = new HashSet<Object>();

		for(IRestrictedContentProvider encapsulatedContentProvider : encapsulatedContentProviders) {
			Object[] directElements = encapsulatedContentProvider.getChildren(parentElement);
			if(directElements != null && directElements.length != 0) {
				asList.addAll(Arrays.asList(directElements));
			}
		}
		return asList.toArray();
	}


	public Object getParent(Object element) {
		for(IRestrictedContentProvider encapsulatedContentProvider : encapsulatedContentProviders) {
			Object parent = encapsulatedContentProvider.getParent(element);
			if(parent != null) {
				return parent;
			}
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return true;
	}



	@Override
	public void dispose() {
		super.dispose();
		this.encapsulatedContentProviders.clear();
	}

	public void setRestriction(boolean isRestricted) {
		for(IRestrictedContentProvider current : encapsulatedContentProviders) {
			current.setRestriction(isRestricted);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider#isRestricted()
	 * 
	 * @return
	 */
	public boolean isRestricted() {
		if(!encapsulatedContentProviders.isEmpty()) {
			return encapsulatedContentProviders.get(0).isRestricted();
		}
		throw new UnsupportedOperationException();
	}

	public boolean isValidValue(Object element) {
		boolean result = false;
		for(final IRestrictedContentProvider current : encapsulatedContentProviders) {
			result = result || current.isValidValue(element);
		}
		return result;
	}

	public Object[] getElements() {
		return getElements(null);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider#setIgnoreInheritedElements(boolean)
	 * 
	 * @param ignoreInheritedElements
	 */
	public void setIgnoreInheritedElements(boolean ignoreInheritedElements) {
		for(final IRestrictedContentProvider current : encapsulatedContentProviders) {
			current.setIgnoreInheritedElements(ignoreInheritedElements);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider#isIgnoringInheritedElements()
	 * 
	 * @return
	 */
	public boolean isIgnoringInheritedElements() {
		return encapsulatedContentProviders.get(0).isIgnoringInheritedElements();//the value is the same for all encapsulated content provider
	}


}
