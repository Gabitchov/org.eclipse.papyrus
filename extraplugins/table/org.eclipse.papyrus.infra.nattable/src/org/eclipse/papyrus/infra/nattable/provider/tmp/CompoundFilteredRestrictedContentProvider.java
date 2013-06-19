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
package org.eclipse.papyrus.infra.nattable.provider.tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;;
/**
 * This class allows to use several content provider for the same widget
 * + restriction behavior see {@link IRestrictedContentProvider} documentation
 * 
 * @author JC236769
 * 
 */
//FIXME must be deleted after the official extraplugins build and before Papyrus 0.10SR1
public class CompoundFilteredRestrictedContentProvider extends org.eclipse.papyrus.infra.widgets.providers.CompoundFilteredRestrictedContentProvider implements org.eclipse.papyrus.infra.nattable.provider.tmp.IRestrictedContentProvider {

	private List<IRestrictedContentProvider> encapsulatedContentProviders2 = new ArrayList<IRestrictedContentProvider>();

	public boolean add(IRestrictedContentProvider o) {
		super.add(o);
		if(o != null) {
			return encapsulatedContentProviders2.add(o);
		}
		return false;
	}


	@Override
	public Object[] getElements(Object inputElement) {
		List<Object> asList = new ArrayList<Object>();

		for(IRestrictedContentProvider encapsulatedContentProvider : encapsulatedContentProviders2) {
			Object[] directElements = encapsulatedContentProvider.getElements(inputElement);
			asList.addAll(Arrays.asList(directElements));
		}
		return asList.toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		List<Object> asList = new ArrayList<Object>();

		for(IRestrictedContentProvider encapsulatedContentProvider : encapsulatedContentProviders2) {
			Object[] directElements = encapsulatedContentProvider.getChildren(parentElement);
			if(directElements != null && directElements.length != 0) {
				asList.addAll(Arrays.asList(directElements));
			}
		}
		return asList.toArray();
	}

	@Override
	public Object getParent(Object element) {
		for(IRestrictedContentProvider encapsulatedContentProvider : encapsulatedContentProviders2) {
			Object parent = encapsulatedContentProvider.getParent(element);
			if(parent != null) {
				return parent;
			}
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return true;
	}



	@Override
	public void dispose() {
		//		super.dispose();
		this.encapsulatedContentProviders2.clear();
	}

	@Override
	public void setRestriction(boolean isRestricted) {
		for(IRestrictedContentProvider current : encapsulatedContentProviders2) {
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
		if(!encapsulatedContentProviders2.isEmpty()) {
			return ((org.eclipse.papyrus.infra.nattable.provider.tmp.IRestrictedContentProvider)encapsulatedContentProviders2.get(0)).isRestricted();
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isValidValue(Object element) {
		boolean result = false;
		for(final IRestrictedContentProvider current : encapsulatedContentProviders2) {
			result = result || current.isValidValue(element);
		}
		return result;
	}

	@Override
	public Object[] getElements() {
		return getElements(null);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.tmp.IInheritedElementContentProvider#setIgnoreInheritedElements(boolean)
	 * 
	 * @param ignoreInheritedElements
	 */
	public void setIgnoreInheritedElements(boolean ignoreInheritedElements) {
		for(final IRestrictedContentProvider current : encapsulatedContentProviders2) {
			((IInheritedElementContentProvider)current).setIgnoreInheritedElements(ignoreInheritedElements);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.tmp.IInheritedElementContentProvider#isIgnoringInheritedElements()
	 * 
	 * @return
	 */
	public boolean isIgnoringInheritedElements() {
		return ((IInheritedElementContentProvider)encapsulatedContentProviders2.get(0)).isIgnoringInheritedElements();//the value is the same for all encapsulated content provider
	}


}
