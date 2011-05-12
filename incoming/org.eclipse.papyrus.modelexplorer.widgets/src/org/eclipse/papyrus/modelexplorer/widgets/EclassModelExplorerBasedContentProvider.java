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
 * It can only filter if wantedMetaclass and metaclassNotWanted are Eclass
 */
public class EclassModelExplorerBasedContentProvider extends EncapsulatedContentProvider  implements IMetaclassFilteredContentProvider{


	/** The not wanted. */
	protected ArrayList<Object> metaClassNotWantedList=new ArrayList<Object>();
	/** The not wanted. */
	protected Object metaClassWanted=null;
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
	public EclassModelExplorerBasedContentProvider(EObject semanticRoot) {
		super(new ModelContentProvider(semanticRoot));
		this.semanticRoot= semanticRoot;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setMetaClassNotWanted(List<Object> metaClassNotWanted) {
		metaClassNotWantedList.clear();
		metaClassNotWantedList.addAll(metaClassNotWanted);
	}
	/**
	 * {@inheritDoc}
	 */
	public void setMetaClassWanted(Object metaClassWanted) {
		this.metaClassWanted=metaClassWanted;
	}

	
	/**
	 * get Wanted metaclasse
	 * @return Eclass that reprensent the wanted metaclass
	 */
	public Object getMetaClassWanted() {
		return metaClassWanted;
	}

	@Override
	public boolean isValidValue(Object element) {
		
		//to filter, test if the wanted metaclass is not null
		if(metaClassWanted!=null){
			// get the semantic object form the element
			EObject semanticObject=null;
			
			if(element instanceof IAdaptable){
				semanticObject=(EObject)brige.getSemanticElement(element);
			}
			if(element instanceof EObject){
				semanticObject=(EObject)element;
			}
			//return ok for Ereference
			if(element instanceof EReference||semanticObject instanceof EReference){
				return true;
			}
			//the semantic object is not null
			if(semanticObject!=null){
				//test if this is an Eclass
				if(metaClassWanted instanceof EClass){
					//test if the semanticobject is instance of metaclassWanted
					// and not an instance of metaclassNotWanted
				if(((EClass)metaClassWanted).isSuperTypeOf(semanticObject.eClass())){
					if(metaClassNotWantedList.size()>0){
						Iterator<Object> iternotwanted= metaClassNotWantedList.iterator();
						while( iternotwanted.hasNext()){
							Object notWanted=iternotwanted.next();
							if(notWanted instanceof EClass)
							if(((EClass)notWanted).isSuperTypeOf(semanticObject.eClass())){
								return false;
							}
						}
					}
					return true;
				}
				}
				return false;
			}

		}
		return super.isValidValue(element);
	}
}
