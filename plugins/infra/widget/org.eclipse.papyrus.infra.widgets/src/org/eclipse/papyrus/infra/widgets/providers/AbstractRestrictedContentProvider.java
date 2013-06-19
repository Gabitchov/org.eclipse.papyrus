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

import org.eclipse.jface.viewers.Viewer;

/**
 * Abstract Implementation for {@link IRestrictedContentProvider}
 * 
 * @author JC236769
 * 
 */
public abstract class AbstractRestrictedContentProvider implements IRestrictedContentProvider {

	/**
	 * flag to indicate the useage of the restriction in the content provider
	 */
	private boolean isRestricted;

	/**
	 * if <code>false</code> the inherited features will be displayed
	 */
	private boolean ignoreInheritedFeatures;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param isRestricted
	 */
	public AbstractRestrictedContentProvider(final boolean isRestricted) {
		this.isRestricted = isRestricted;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider#setRestriction(boolean)
	 * 
	 * @param isRestricted
	 */
	public final void setRestriction(boolean isRestricted) {
		this.isRestricted = isRestricted;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 * 
	 */
	public void dispose() {

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider#setIgnoreInheritedElements(boolean)
	 * 
	 * @param ignoreInheritedElements
	 */
	public void setIgnoreInheritedElements(boolean ignoreInheritedElements) {
		this.ignoreInheritedFeatures = ignoreInheritedElements;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider#isIgnoringInheritedElements()
	 * 
	 * @return
	 */
	public boolean isIgnoringInheritedElements() {
		return this.ignoreInheritedFeatures;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider#isRestricted()
	 * 
	 * @return
	 */
	public boolean isRestricted() {
		return this.isRestricted;
	}

}
