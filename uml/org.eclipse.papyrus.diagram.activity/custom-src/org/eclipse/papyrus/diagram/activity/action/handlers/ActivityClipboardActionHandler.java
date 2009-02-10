/*******************************************************************************
 * Copyright (c) 2008 
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.action.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.diagram.activity.edit.commands.helpers.ActivityPartitionActivity;
import org.eclipse.papyrus.diagram.common.actions.handlers.ClipboardActionHandler;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.commands.AddEObjectReferencesToDiagram;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.UMLPackage;

public class ActivityClipboardActionHandler extends ClipboardActionHandler {

	@Override
	protected void executePasteAfterCopy(IGlobalActionContext cntxt) {

		ISelection selection = cntxt.getSelection();
		List<EditPart> editParts = MDTUtil.getEditPartsFromSelection(selection);

		if (editParts.size() == 1) {
			EditPart editPart = editParts.get(0);
			EObject element = MDTUtil.resolveSemantic(editPart);
			if (element instanceof ActivityPartition) {
				ActivityPartition activityPartition = (ActivityPartition) element;
				// we want to paste in an Activity Partition
				// special actions required
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
				if (domain != null && domain.getClipboard() != null && domain.getClipboard().size() > 0) {

					// All the objects in the clipboard are supposed to be of
					// the
					// same type

					Object[] objects = domain.getClipboard().toArray();
					EObject firstObjectToBePasted = (EObject) objects[0];
					EStructuralFeature feature = getFeature(firstObjectToBePasted, editPart);

					// elements pasted on an ActivityPartition ares stored in an
					// Activity
					Activity activity = ActivityPartitionActivity.getActivityPartitionActivity(activityPartition);
					// Execute paste
					Command pasteCommand = PasteFromClipboardCommand.create(domain, activity, feature);
					domain.getCommandStack().execute(pasteCommand);

					// The new elements must be shown on the diagram
					List<EObject> eobjects = new ArrayList<EObject>();
					for (Object o : pasteCommand.getAffectedObjects()) {
						if (o instanceof EObject) {
							eobjects.add((EObject) o);
						}
					}

					// The affected objects must be set inside the
					// ActivityPartition
					for (EObject eObject : eobjects) {
						if (eObject instanceof ActivityNode) {
							ActivityNode activityNode = (ActivityNode) eObject;
							Command addCommand = AddCommand.create(domain, activityPartition, UMLPackage.eINSTANCE.getActivityPartition_Node(), activityNode);
							if (addCommand != null) {
								domain.getCommandStack().execute(addCommand);
							}
						}
					}
					// ad these objects' references to the Diagram
					ICommand command = new AddEObjectReferencesToDiagram(domain, DiagramEditPartsUtil.findDiagramFromEditPart(editPart), eobjects);
					domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));

					// refresh the affected EditPart
					if (editPart instanceof IGraphicalEditPart) {
						DiagramEditPartsUtil.updateEditPart((IGraphicalEditPart) editPart);
					}
				}
			} else {
				// if not an ActivityPartition, default behavior
				super.executePasteAfterCopy(cntxt);
			}
		}
	}

	@Override
	protected void executePasteAfterCut(IGlobalActionContext cntxt) {

		ISelection selection = cntxt.getSelection();
		List<EditPart> editParts = MDTUtil.getEditPartsFromSelection(selection);

		if (editParts.size() == 1) {
			EditPart editPart = editParts.get(0);
			EObject element = MDTUtil.resolveSemantic(editPart);
			if (element instanceof ActivityPartition) {
				ActivityPartition activityPartition = (ActivityPartition) element;
				// elements pasted on an ActivityPartition ares stored in an
				// Activity
				Activity activity = ActivityPartitionActivity.getActivityPartitionActivity(activityPartition);
				// we want to paste in an Activity Partition
				// special actions required
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
				if (domain != null && domain.getClipboard() != null && domain.getClipboard().size() > 0) {
					// command
					CompoundCommand cc = new CompoundCommand("Paste");

					// get list of ActivityNodes to move
					List<ActivityNode> activityNodes = new ArrayList<ActivityNode>();
					for (Object object : domain.getClipboard()) {
						EObject eObject = MDTUtil.resolveSemantic(object);
						if (eObject instanceof ActivityNode) {
							activityNodes.add((ActivityNode) eObject);
						}
					}

					// add all ActivityNodes to the selected ActivityPartition's
					// node feature
					for (ActivityNode activityNode : activityNodes) {
						Command setCommand = AddCommand.create(domain, activity, UMLPackage.eINSTANCE.getActivity_Node(), activityNode);
						if (setCommand != null && setCommand.canExecute()) {
							cc.append(setCommand);
						}
						setCommand = AddCommand.create(domain, activityNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), activityPartition);
						if (setCommand != null && setCommand.canExecute()) {
							cc.append(setCommand);
						}
					}

					// delete copied object
					Command removeCommand = RemoveCommand.create(domain, activity, UMLPackage.eINSTANCE.getActivity_Node(), clipboard);
					cc.append(removeCommand);
					// delete copied object's views
					for (EditPart ep : editPartsInClipboard) {
						Command c = getDeleteViewCommand(ep);
						if (c != null) {
							cc.append(c);
						}
					}

					if (cc.canExecute()) {
						domain.getCommandStack().execute(cc);
					}

					// ad these objects' references to the Diagram
					ICommand command = new AddEObjectReferencesToDiagram(domain, DiagramEditPartsUtil.findDiagramFromEditPart(editPart), Arrays.asList(activityNodes.toArray(new EObject[activityNodes
							.size()])));
					domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));

					// refresh the affected EditPart
					if (editPart instanceof IGraphicalEditPart) {
						DiagramEditPartsUtil.updateEditPart((IGraphicalEditPart) editPart);
					}
				}
			} else {
				// if not an ActivityPartition, default behavior
				super.executePasteAfterCut(cntxt);
			}
		}
	}
}
