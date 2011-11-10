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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * 
 * Thi content provider for the FillingQueries editor
 *
 */
public class FillingQueriesContentProvider implements IHierarchicContentProvider, IStaticContentProvider{

	private final TableInstance table;
	public FillingQueriesContentProvider(final TableInstance table) {
		this.table = table;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 *
	 * @return
	 */
	public Object[] getElements() {
		//we return only the querySet with interesting queries
		Collection<ModelQuerySet> allQueriesSet = new ArrayList<ModelQuerySet>();
		Collection<ModelQuerySet> querySetToKeep = new ArrayList<ModelQuerySet>();
		allQueriesSet.addAll(ModelQuerySetCatalog.getSingleton().getAllModelQuerySets());
		for(ModelQuerySet current : allQueriesSet){
			if(getChildren(current).length!=0){
				querySetToKeep.add(current);
			}
		}
		return querySetToKeep.toArray();
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 *
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(final Object inputElement) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 *
	 * @param parentElement
	 * @return
	 */
	public Object[] getChildren(final Object parentElement) {
		if(parentElement instanceof ModelQuerySet){
			List<ModelQuery> queries = new ArrayList<ModelQuery>();
			queries.addAll(((ModelQuerySet)parentElement).getQueries());
			List<ModelQuery> queriesToKeep = new ArrayList<ModelQuery>();
			EObject context = this.table.getContext();
			EClass eClassContext = context.eClass();
			for(ModelQuery current : queries){
				//TODO we should test the return type, no?
				EList<EClass> scope = current.getScope();
				for(EClass currentEClass : scope){
					if(currentEClass.isSuperTypeOf(eClassContext) || eClassContext.isInstance(current)){

						queriesToKeep.add(current);
					}else{
						queriesToKeep.add(current);
						//nothing to do
					}

				}
			}
			return queries.toArray();
		}
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
		return getChildren(element).length!=0;
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
		if(element instanceof ModelQuery){
			return true;
		}
		return false;
	}

}
