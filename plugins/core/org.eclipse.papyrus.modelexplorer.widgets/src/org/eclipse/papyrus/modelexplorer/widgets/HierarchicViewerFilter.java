/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.widgets;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.modelexplorer.SemanticFromModelExplorer;
import org.eclipse.papyrus.widgets.providers.IHierarchicContentProvider;

/**
 * 
 * This a View Filter that use a IHierarchicContentProvider 
 *
 */
public class HierarchicViewerFilter extends ViewerFilter {

	/**
	 * a constructor
	 * @param contentProvider that contains isValidValue() in order to know element to filter
	 */
	public HierarchicViewerFilter(IHierarchicContentProvider contentProvider) {
		super();
		this.contentProvider = contentProvider;
	}

	/**
	 *  the content provider
	 */
	protected IHierarchicContentProvider contentProvider; 
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		SemanticFromModelExplorer brige= new SemanticFromModelExplorer();

		EObject semanticObject=null;
		if(element instanceof IAdaptable){
			semanticObject=(EObject)brige.getSemanticElement(element);
		}
		if(element instanceof EObject){
			semanticObject=(EObject)element;
		}

		if (semanticObject!=null){//it contains nothing 
			if(semanticObject instanceof EReference){
				//Do not display references that are not containment kind
				if(!((EReference)semanticObject).isContainment()){return false;}
				//this an ereference maybe it references something that is interesting
				boolean result=false;
				Object[] children=contentProvider.getChildren(element);
				for(int i=0; i<children.length;i++){
					boolean contains=select(viewer,semanticObject,children[i]);
					result=result||contains;
				}
				return result;
			}

			if(semanticObject.eContents().size()==0){
				return contentProvider.isValidValue(semanticObject);
			}
			else{ //it contains something so we have to test children before
				boolean result=false;
				if( contentProvider.isValidValue(semanticObject)){
					return true;
				}

				Iterator<EObject>iter=semanticObject.eAllContents();
				while(iter.hasNext()){
					EObject subEObject= iter.next();
					boolean contains=select(viewer,semanticObject,subEObject);
					result=result||contains;
				}
				return result;


			}
		}
		return false;
	}

}
