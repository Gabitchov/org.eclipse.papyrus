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
package org.eclipse.papyrus.modelexplorerbasedwidgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.modelexplorer.SemanticFromModelExplorer;
import org.eclipse.papyrus.widgets.providers.EncapsulatedContentProvider;

/**
 * this is an Encapsulated content provider based on the model explorer on which we can filter wanted meta-classes
 */
public class ModelExplorerBasedContentProvider extends EncapsulatedContentProvider  implements IMetaclassFilteredContentProvider{


	/** The not wanted. */
	protected ArrayList<EClass> metaClassNotWantedList=new ArrayList<EClass>();
	/** The not wanted. */
	protected EClass metaClassWanted=null;
	/**
	 * a bridge to find the seamntic element behind an object of the model explorer
	 */
	protected SemanticFromModelExplorer brige= new SemanticFromModelExplorer();
	/**
	 * the wanted root of the contentprovider
	 */
	protected EObject semanticRoot;

	/**
	 * the constructor
	 * @param semanticRoot the root that we want to display at top
	 */
	public ModelExplorerBasedContentProvider(EObject semanticRoot) {
		super(new ModelContentProvider(semanticRoot));
		this.semanticRoot= semanticRoot;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setMetaClassNotWanted(List<EClass> metaClassNotWanted) {
		metaClassNotWantedList.clear();
		metaClassNotWantedList.addAll(metaClassNotWanted);
	}
	/**
	 * {@inheritDoc}
	 */
	public void setMetaClassWanted(EClass metaClassWanted) {
		this.metaClassWanted=metaClassWanted;
	}

	
	/**
	 * get Wanted metaclasse
	 * @return Eclass that reprensent the wanted metaclass
	 */
	public EClass getMetaClassWanted() {
		return metaClassWanted;
	}

	@Override
	public boolean isValidValue(Object element) {
		if(metaClassWanted!=null){
			EObject eObject=null;
			if(element instanceof IAdaptable){
				eObject=(EObject)brige.getSemanticElement(element);
			}
			if(element instanceof EObject){
				eObject=(EObject)element;
			}
			//return ok for Ereference
			if(element instanceof EReference||eObject instanceof EReference){
				return true;
			}
			if(eObject!=null){
				if(metaClassWanted.isSuperTypeOf(eObject.eClass())){
					if(metaClassNotWantedList.size()>0){
						Iterator<EClass> iternotwanted= metaClassNotWantedList.iterator();
						while( iternotwanted.hasNext()){
							if(iternotwanted.next().isSuperTypeOf(eObject.eClass())){
								return false;
							}
						}
					}
					return true;
				}
				return false;
			}

		}
		return super.isValidValue(element);
	}
}
