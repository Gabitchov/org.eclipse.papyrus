/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.clazz.custom.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.AssociationEndSourceEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.AssociationEndTargetEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassRoleSourceEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassRoleTargetEditPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

// TODO: Auto-generated Javadoc
/**
 * set the owner of the selected property as a corresponded classifier.
 */
public class SetClassifierPropertyOwnerAction implements IObjectActionDelegate {

	/** The selected element. */
	private GraphicalEditPart selectedElement;

	/**
	 * Instantiates a new sets the classifier property owner action.
	 */
	public SetClassifierPropertyOwnerAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 * 
	 * @param action
	 * @param targetPart
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */
	public void run(IAction action) {
		//1 this is a associationEnd?
		CompoundCommand command = new CompoundCommand();
		if(selectedElement instanceof AssociationEndSourceEditPart || selectedElement instanceof AssociationEndTargetEditPart || selectedElement instanceof AssociationClassRoleSourceEditPart || selectedElement instanceof AssociationClassRoleTargetEditPart) {
			Type owner = null;
			//2. look for the future owner of the property, run only for binary association
			Property property = (Property)((GraphicalEditPart)selectedElement).resolveSemanticElement();
			if(property.getOwner() instanceof Association) {
				//look for the owner of the property to Set
				Association association = (Association)property.getOwner();
				List<Type> ownerList = association.getEndTypes();
				if(ownerList.get(0).equals(property.getType()) && ownerList.size() > 1) {
					owner = (Type)ownerList.get(1);
				} else {
					owner = (Type)ownerList.get(0);
				}
			}
			// this is a classifier , construct and run the command
			EStructuralFeature feature = UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
			if(owner instanceof org.eclipse.uml2.uml.Class) {
				List<Property> attributeList = new ArrayList<Property>();
				attributeList.addAll(((org.eclipse.uml2.uml.Class)owner).getAttributes());
				attributeList.add(property);
				SetRequest setRequest = new SetRequest(owner, feature, attributeList);
				SetValueCommand setValueCommand = new SetValueCommand(setRequest);
				command.add(new ICommandProxy(setValueCommand));
				selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			}
		}
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param action
	 * @param selection
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
			if(selectedobject instanceof GraphicalEditPart) {
				selectedElement = (GraphicalEditPart)selectedobject;
			}
		}
	}
}
