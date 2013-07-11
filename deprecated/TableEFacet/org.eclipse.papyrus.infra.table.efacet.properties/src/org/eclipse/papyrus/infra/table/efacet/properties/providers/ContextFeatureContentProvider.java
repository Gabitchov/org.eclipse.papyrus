/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.properties.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * 
 * Context provider for the table edition
 * 
 */
public class ContextFeatureContentProvider implements IHierarchicContentProvider, IStaticContentProvider {

	/**
	 * the edited table
	 */
	private final PapyrusTable table;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the edited table
	 */
	public ContextFeatureContentProvider(final PapyrusTable table) {
		this.table = table;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 * 
	 * @return
	 */
	public Object[] getElements() {
		return new Object[0];
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(final Object inputElement) {
		return this.table.getTable().getContext().eClass().getEAllReferences().toArray();
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 * 
	 * @param parentElement
	 * @return
	 */
	public Object[] getChildren(final Object parentElement) {
		return new Object[0];
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public Object getParent(final Object element) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasChildren(final Object element) {
		return getChildren(element).length != 0;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 * 
	 */
	public void dispose() {
		//nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		//nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider#isValidValue(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public boolean isValidValue(final Object element) {
		return true;
	}

}
