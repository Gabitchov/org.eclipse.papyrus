/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.CustomMultiAssociationHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * The Class AssociationBranchDeletion is used delete a branch
 */
public class AssociationBranchDeletion implements IObjectActionDelegate {

	/** The selected element. */
	private AssociationBranchEditPart selectedElement;

	/**
	 * Instantiates a new association branch deletion.
	 */
	public AssociationBranchDeletion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	public void run(IAction action) {
		CompoundCommand command = new CompoundCommand();
		Association association = null;
		TransactionalEditingDomain domain = selectedElement.getEditingDomain();
		GraphicalEditPart associationNodeEditPart = null;
		// 1. Semantic deletion
		GraphicalEditPart branchSource = (GraphicalEditPart) selectedElement.getSource();
		// target is the association end of the association branch
		association = (Association) branchSource.resolveSemanticElement();
		associationNodeEditPart = branchSource;
		Property associationEndToRemove = CustomMultiAssociationHelper.getPropertyToListen((Edge) selectedElement.getModel(), association);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(associationEndToRemove);
		if (provider != null) {
			DestroyElementRequest destroyRequest = new DestroyElementRequest(associationEndToRemove, false);
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(destroyRequest);
			if (deleteCommand != null) {
				command.add(new ICommandProxy(deleteCommand));
			}
		}
		// 2. graphical deletion of the branch
		View associationBranchView = selectedElement.getNotationView();
		command.add(new ICommandProxy(new DeleteCommand(domain, associationBranchView)));
		// 3. test if it exists more than 2 branches
		int branchNumber = associationNodeEditPart.getSourceConnections().size() + associationNodeEditPart.getTargetConnections().size();
		if (branchNumber == 3) {
			// 4. Graphical deletion of the node
			command.add(new ICommandProxy(new DeleteCommand(domain, associationNodeEditPart.getNotationView())));
			// 5. Graphical creation of the binary dependency
			// 5.1 calculus of the future source and target of the binary
			// dependency
			List<EditPart> sourceList = new ArrayList<EditPart>();
			List<EditPart> targetList = new ArrayList<EditPart>();
			for (Object editPart : associationNodeEditPart.getSourceConnections()) {
				sourceList.add((EditPart) editPart);
			}
			for (Object editPart : associationNodeEditPart.getTargetConnections()) {
				targetList.add((EditPart) editPart);
			}
			sourceList.remove(selectedElement);
			targetList.remove(selectedElement);
			PreferencesHint preferencesHint = ((GraphicalEditPart) ((ConnectionEditPart) (sourceList.get(0))).getTarget()).getDiagramPreferencesHint();
			ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(UMLElementTypes.Association_4001, ((IHintedType) UMLElementTypes.Association_4001).getSemanticHint(), preferencesHint);
			CustomDeferredCreateConnectionViewCommand binaryCommand = new CustomDeferredCreateConnectionViewCommand(domain, ((IHintedType) UMLElementTypes.Association_4001).getSemanticHint(), new SemanticAdapter(null,
					(((ConnectionEditPart) (sourceList.get(0))).getTarget()).getModel()), new SemanticAdapter(null, (((ConnectionEditPart) (sourceList.get(1))).getTarget()).getModel()), sourceList.get(0).getViewer(), preferencesHint, viewDescriptor, null);
			binaryCommand.setElement(association);
			command.add(new ICommandProxy(binaryCommand));
		}
		// 6.command Execution
		selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedobject instanceof AssociationBranchEditPart) {
				selectedElement = (AssociationBranchEditPart) selectedobject;
			}
		}
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
	}
}
