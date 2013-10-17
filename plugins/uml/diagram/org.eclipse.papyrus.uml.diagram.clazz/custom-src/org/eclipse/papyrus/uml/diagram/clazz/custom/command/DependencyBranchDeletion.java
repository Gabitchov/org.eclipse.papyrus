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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class DependencyBranchDeletion used to delete a branch from n-ary dependency
 */
public class DependencyBranchDeletion implements IObjectActionDelegate {

	/** The selected element. */
	private DependencyBranchEditPart selectedElement;

	/**
	 * Instantiates a new dependency branch deletion.
	 */
	public DependencyBranchDeletion() {
	}

	/**
	 * {@inheritedDoc}
	 */
	public void run(IAction action) {
		CompoundCommand command = new CompoundCommand();
		Dependency dependency = null;
		TransactionalEditingDomain domain = selectedElement.getEditingDomain();
		GraphicalEditPart dependencyNodeEditPart = null;
		// 1. Semanctic deletion of the client or supplier
		GraphicalEditPart branchSource = (GraphicalEditPart)selectedElement.getSource();
		GraphicalEditPart branchtarget = (GraphicalEditPart)selectedElement.getTarget();
		EStructuralFeature feature = null;
		ArrayList<NamedElement> newValue = new ArrayList<NamedElement>();
		if(branchSource.resolveSemanticElement() instanceof Dependency) {
			// target is the supplier of the dependency
			dependency = (Dependency)branchSource.resolveSemanticElement();
			dependencyNodeEditPart = branchSource;
			newValue.addAll(dependency.getSuppliers());
			newValue.remove(branchtarget.resolveSemanticElement());
			feature = UMLPackage.eINSTANCE.getDependency_Supplier();
		} else {
			// source is the client of the dependency to remove
			feature = UMLPackage.eINSTANCE.getDependency_Client();
			dependency = (Dependency)branchtarget.resolveSemanticElement();
			dependencyNodeEditPart = branchtarget;
			newValue.addAll(dependency.getClients());
			newValue.remove(branchSource.resolveSemanticElement());
		}
		SetRequest setRequest = new SetRequest(dependency, feature, newValue);
		SetValueCommand setValueCommand = new SetValueCommand(setRequest);
		command.add(new ICommandProxy(setValueCommand));
		// 2. graphical deletion of the branch
		View branchDependencyView = selectedElement.getNotationView();
		command.add(new ICommandProxy(new DeleteCommand(domain, branchDependencyView)));
		// 3. test if it exists more than 2 branches
		int branchNumber = dependencyNodeEditPart.getSourceConnections().size() + dependencyNodeEditPart.getTargetConnections().size();
		if(branchNumber == 3) {
			// 4. Graphical deletion of the node
			command.add(new ICommandProxy(new DeleteCommand(domain, dependencyNodeEditPart.getNotationView())));
			// 5. Graphical creation of the binary dependency
			// 5.1 calculus of the furture source and taget of the binary
			// dependency
			ArrayList<EditPart> sourceList = new ArrayList<EditPart>();
			ArrayList<EditPart> targetList = new ArrayList<EditPart>();
			sourceList.addAll(dependencyNodeEditPart.getSourceConnections());
			targetList.addAll(dependencyNodeEditPart.getTargetConnections());
			sourceList.remove(selectedElement);
			targetList.remove(selectedElement);
			PreferencesHint preferencesHint = ((GraphicalEditPart)((ConnectionEditPart)(sourceList.get(0))).getTarget()).getDiagramPreferencesHint();
			ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(UMLElementTypes.Dependency_4008, ((IHintedType)UMLElementTypes.Dependency_4008).getSemanticHint(), preferencesHint);
			CustomDeferredCreateConnectionViewCommand binaryCommand = new CustomDeferredCreateConnectionViewCommand(domain, ((IHintedType)UMLElementTypes.Dependency_4008).getSemanticHint(), new SemanticAdapter(null, (((ConnectionEditPart)(targetList.get(0))).getSource()).getModel()), new SemanticAdapter(null, (((ConnectionEditPart)(sourceList.get(0))).getTarget()).getModel()), sourceList.get(0).getViewer(), preferencesHint, viewDescriptor, null);
			binaryCommand.setElement(dependency);
			command.add(new ICommandProxy(binaryCommand));
		}
		// 6.command Execution
		selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}

	/**
	 * {@inheritedDoc}
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
			if(selectedobject instanceof DependencyBranchEditPart) {
				selectedElement = (DependencyBranchEditPart)selectedobject;
			}
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
	}
}
