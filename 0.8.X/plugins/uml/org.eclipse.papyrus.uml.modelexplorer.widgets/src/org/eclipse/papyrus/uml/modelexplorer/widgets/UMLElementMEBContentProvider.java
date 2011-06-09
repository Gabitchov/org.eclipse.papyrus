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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.widgets;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.modelexplorer.widgets.EclassModelExplorerBasedContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Stereotype;


/**
 *this content provider is specific for UML, it specifies getvalidValue by taking in account stereotypes 
 *
 */
public class UMLElementMEBContentProvider extends EclassModelExplorerBasedContentProvider {

	public UMLElementMEBContentProvider(EObject semanticRoot) {
		super(semanticRoot);
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.modelexplorer.widgets.EclassModelExplorerBasedContentProvider#isValidValue(java.lang.Object)
	 *
	 */
	public boolean isValidValue(Object element) {

		if(metaClassWanted!=null){
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
			
			//this is a Eclass
			if(semanticObject!=null){
				if(metaClassWanted instanceof EClass){
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
				//this is a stereotype
				if(metaClassWanted instanceof Stereotype){
					if(semanticObject instanceof Element){
						Element selectedUMLelement= (Element) semanticObject;
						return selectedUMLelement.getAppliedStereotypes().contains((Stereotype)metaClassWanted);
						}
					}
				}
				return false;
			}

		return super.isValidValue(element);
	}
}
