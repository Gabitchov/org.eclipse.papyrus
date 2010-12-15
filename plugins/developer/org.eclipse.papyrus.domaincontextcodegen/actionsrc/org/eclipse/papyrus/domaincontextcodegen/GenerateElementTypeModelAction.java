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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * <pre>
 * 
 * Automated generation of ElementTypes (in the domain model), an ElementType generated for
 * each element of the domain model.
 * 
 * </pre>
 */
public class GenerateElementTypeModelAction implements IObjectActionDelegate {

	protected DomainContext selectedContext = null;

	public GenerateElementTypeModelAction() {
	}

	public void run(IAction action) {

		ElementTypes elementTypeList = DomaincontextcodegenFactory.eINSTANCE.createElementTypes();
		selectedContext.setElementTypes(elementTypeList);

		if(selectedContext.getSpecializationOf() == null) {
			if(selectedContext.getMetamodel() != null) {
				Iterator<EClassifier> iterClass = selectedContext.getMetamodel().getEClassifiers().iterator();
				ArrayList<MetaClassType> result = new ArrayList<MetaClassType>();
				while(iterClass.hasNext()) {
					EClassifier eClassifier = (EClassifier)iterClass.next();
					if(eClassifier instanceof EClass) {
						MetaClassType elemenType = DomaincontextcodegenFactory.eINSTANCE.createMetaClassType();
						elemenType.setHelper(selectedContext.getDefaultHelperPath());
						elemenType.setMetaClass((EClass)eClassifier);
						elemenType.setIcon("platform:/plugin/org.eclipse.uml2.uml.edit/icons/full/obj16/" + eClassifier.getName() + ".gif");

						// Convert name to upper case with '_' separator between name parts e.g. NamedElement -> NAMED_ELEMENT
						// String formattedName = CodeGenUtil.format(eClassifier.getName(), '_', null, false, true).toUpperCase();
						// elemenType.setName(not_formattedName);

						// No formatting
						String not_formattedName = eClassifier.getName();
						elemenType.setName(not_formattedName);

						result.add(elemenType);
					}
				}
				System.err.println(result.get(0).getMetaClass().getName());
				Collections.sort(result, new ElementTypeComparator());
				System.err.println(result.get(0).getMetaClass().getName());
				elementTypeList.getTypes().addAll(result);

			}
		}
		//to Do in the case of specialization with a profile

	}

	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			if(((IStructuredSelection)selection).getFirstElement() instanceof DomainContext) {
				selectedContext = (DomainContext)((IStructuredSelection)selection).getFirstElement();
			}
		}

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

}
