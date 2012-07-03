/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import java.util.Collection;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.ContainerNodeDescriptorRegistry;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;
import org.eclipse.uml2.uml.Element;

/**
 * Drag and drop policy which allow drop of objects which are not contains from a semantic point of view into a visual element such as Activity
 * Partition
 * 
 * @author adaussy
 * 
 */
public class ActivityGroupCustomDragAndDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	/**
	 * Override in order to accept drop of element which are not directly containing by a referencing group
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy#getDropObjectCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected IUndoableOperation getDropObjectCommand(DropObjectsRequest dropRequest, EObject droppedObject) {
		Point location = dropRequest.getLocation().getCopy();
		int nodeVISUALID = getNodeVisualID(((IGraphicalEditPart)getHost()).getNotationView(), droppedObject);
		int linkVISUALID = getLinkWithClassVisualID(droppedObject);
		if(getSpecificDrop().contains(nodeVISUALID) || getSpecificDrop().contains(linkVISUALID)) {
			Command specificDropCommand = getSpecificDropCommand(dropRequest, (Element)droppedObject, nodeVISUALID, linkVISUALID);
			CompositeCommand cc = new CompositeCommand("Drop command");
			cc.compose(new CommandProxy(specificDropCommand));
			// If ctrl key activate, get the content of element dropped
			if(isCopy(dropRequest)) {
				// Check for ICommandProxy and CompoundCommand the most command type used
				if(specificDropCommand instanceof ICommandProxy) {
					ICommandProxy specificDropCommandProxy = (ICommandProxy)specificDropCommand;
					createDeferredCommandWithCommandResult(droppedObject, cc, specificDropCommandProxy);
				} else if(specificDropCommand instanceof CompoundCommand) {
					CompoundCommand specificDropCompoundCommand = (CompoundCommand)specificDropCommand;
					ICommandProxy cp = getCommandProxyFromCompoundCommand(specificDropCompoundCommand);
					if(cp != null) {
						createDeferredCommandWithCommandResult(droppedObject, cc, cp);
					}
				}
			}
			return cc;
		}
		if(linkVISUALID == -1 && nodeVISUALID != -1) {
			// The element to drop is a node
			// Retrieve it's expected graphical parent
			EObject graphicalParent = ((GraphicalEditPart)getHost()).resolveSemanticElement();
			// Restrict the default node creation to the following cases:
			// . Take the containment relationship into consideration
			// . Release the constraint when GraphicalParent is a diagram
			IContainerNodeDescriptor descriptor = ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(getContainerEClass());
			if(getHost().getModel() instanceof Diagram) {
				return getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject, dropRequest);
			} else if((graphicalParent instanceof Element)) {
				if(descriptor.canIBeModelParentOf(droppedObject.eClass())) {
					if(droppedObject.eContainer() != null && !droppedObject.eContainer().equals(getHostObject())) {
						return UnexecutableCommand.INSTANCE;
					}
					return getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject, dropRequest);
				} else if(descriptor.canIBeGraphicalParentOf(droppedObject.eClass())) {
					return getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject, dropRequest);
				}
			}
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		if(linkVISUALID != -1) {
			Collection<?> sources = linkmappingHelper.getSource((Element)droppedObject);
			Collection<?> targets = linkmappingHelper.getTarget((Element)droppedObject);
			if(sources.size() == 0 || targets.size() == 0) {
				return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
			}
			// binary association
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			CompositeCommand cc = new CompositeCommand("Add Link"); //$NON-NLS-1$
			dropBinaryLink(cc, source, target, linkVISUALID, location, (Element)droppedObject);
			return cc;
		}
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}

	/**
	 * Retreive the {@link EClass} of the host
	 * 
	 * @return
	 */
	protected EClass getContainerEClass() {
		EditPart editPart = getHost();
		if(editPart instanceof IGraphicalEditPart) {
			IGraphicalEditPart part = (IGraphicalEditPart)editPart;
			EObject element = part.resolveSemanticElement();
			if(element != null) {
				return element.eClass();
			}
		}
		return null;
	}
}
