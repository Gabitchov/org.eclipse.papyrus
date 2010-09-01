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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.domaincontextcodegen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class GenerateElementTypeModelAction implements IObjectActionDelegate {

	protected DomainContext selectedContext=null;
	public GenerateElementTypeModelAction() {
		// TODO Auto-generated constructor stub
	}

	public void run(IAction action) {
		if(selectedContext.getSpecializationOf()==null){
			if(selectedContext.getMetamodel()!=null){
				 Iterator<EClassifier> iterClass=selectedContext.getMetamodel().getEClassifiers().iterator();
				 ArrayList<ElementType> result= new ArrayList<ElementType>();
				while (iterClass.hasNext()) {
					EClassifier eClassifier = (EClassifier) iterClass.next();
					if(eClassifier instanceof EClass){
						ElementType elemenType= DomaincontextcodegenFactory.eINSTANCE.createElementType();
						elemenType.setEdithelper_EditHelperAdvicePath(selectedContext.getDefaultHelperPath());
						elemenType.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");
						elemenType.setMetaClass((EClass)eClassifier);
						elemenType.setSpecificName(selectedContext.getElementTypeNamePrefix()+"::"+eClassifier.getName().toUpperCase());
						result.add(elemenType);
					}
				}
					System.err.println(result.get(0).getMetaClass().getName());
					Collections.sort(result, new ElementTypeComparator());
					System.err.println(result.get(0).getMetaClass().getName());
					selectedContext.getElementTypes().addAll(result);
				
			}
		}
		
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection){
			if( ((IStructuredSelection)selection).getFirstElement() instanceof DomainContext){
				selectedContext= (DomainContext)((IStructuredSelection)selection).getFirstElement();
			}
		}

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

}
