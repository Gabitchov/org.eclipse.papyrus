/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this helper has been specified in order to prevent to create or move a component into a component by using the role
 * "nestedClassifier". The good role is "packagedElement"
 *
 */
public class ComponentEditHelper extends ElementEditHelper {

	@Override
	protected ICommand getCreateCommand(CreateElementRequest req) {
		// overload the creation in order to prevent to create or move a component into a component by using the role
		// "nestedClassifier"
		EObject owner= req.getContainer();
		EReference eref=req.getContainmentFeature();
		if(owner!=null &&!canCreate(owner, eref)) {
			// Abort creation.
			return UnexecutableCommand.INSTANCE;
		}
		if(owner instanceof Component && eref==null){
			req.setContainmentFeature(UMLPackage.eINSTANCE.getComponent_PackagedElement());
		}
		return super.getCreateCommand(req);
	}

	@Override
	protected ICommand getMoveCommand(MoveRequest req) {
		// overload the creation in order to prevent to create or move a component into a component by using the role
		// "nestedClassifier"
		for(Object elementToMove : req.getElementsToMove().keySet()) {
			if( elementToMove instanceof Component && (UMLPackage.eINSTANCE.getClass_NestedClassifier().equals(req.getTargetFeature((EObject)elementToMove)))){
				return UnexecutableCommand.INSTANCE;
			}
			if( elementToMove instanceof Component && req.getTargetFeature((EObject)elementToMove)==null){
				req.setTargetFeature((EObject)elementToMove, (UMLPackage.eINSTANCE.getComponent_PackagedElement()));
			}
		}
		
		return super.getMoveCommand(req);
	}
	@Override
	protected ICommand getSetCommand(SetRequest req) {
		// overload the creation in order to prevent to create or move a component into a component by using the role
		// "nestedClassifier"
		EObject eobject=req.getElementToEdit();
		if( eobject instanceof Component && (UMLPackage.eINSTANCE.getComponent_PackagedElement().equals(req.getFeature()))){
			return UnexecutableCommand.INSTANCE;
		}
		return super.getSetCommand(req);
	}
	/**
	 * test if it is possible to create a component into a given container and with the given containment feature
	 * @param owner the owner of the component, can be null
	 * @param eref the containment feature, can be null
	 * @return false if the container is a component and the feature "nestedClassifier"
	 */
	protected boolean canCreate(EObject owner,EReference eref) {
		if(owner instanceof Component && UMLPackage.eINSTANCE.getClass_NestedClassifier().equals(eref)){
			return false;
		}
		return true;
	}
}
