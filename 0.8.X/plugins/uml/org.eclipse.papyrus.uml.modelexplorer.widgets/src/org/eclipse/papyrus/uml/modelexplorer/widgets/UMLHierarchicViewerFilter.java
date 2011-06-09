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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.modelexplorer.SemanticFromModelExplorer;
import org.eclipse.papyrus.modelexplorer.widgets.HierarchicViewerFilter;
import org.eclipse.papyrus.widgets.providers.IHierarchicContentProvider;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLHierarchicViewerFilter extends HierarchicViewerFilter {

	public UMLHierarchicViewerFilter(IHierarchicContentProvider contentProvider) {
		super(contentProvider);
		// TODO Auto-generated constructor stub
	}
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
				if(!((EReference)semanticObject).equals(UMLPackage.eINSTANCE.getNamespace_PackageImport())){return true;}
				
			}
		}
		if(semanticObject instanceof PackageImport){
			return select(viewer, parentElement, ((PackageImport)semanticObject).getImportedPackage());
		}
		// TODO Auto-generated method stub
		return super.select(viewer, parentElement, element);
	}
}