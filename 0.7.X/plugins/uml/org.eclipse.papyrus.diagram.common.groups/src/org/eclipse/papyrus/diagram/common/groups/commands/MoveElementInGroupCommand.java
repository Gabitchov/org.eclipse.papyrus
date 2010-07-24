/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.commands;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.IContainerNodeDescriptor;

/**
 * Command to move model elements to a referencing group using the EMF action protocol.
 * 
 * This command should be returned by group compartment edit policies, in the
 * org.eclipse.papyrus.diagram.*.edit.policies.*ItemSemanticEditPolicy.getMoveCommand(MoveRequest) method.
 * This method can be implemented as follow :
 * return getGEFWrapper(new MoveElementInGroupCommand(req, getHost()));
 * 
 * @author vhemery
 */
public class MoveElementInGroupCommand extends MoveElementsCommand {

	/** the group host part from which this command is constructed */
	private EditPart groupPart;

	/**
	 * Constructs a new command to move a model element
	 * 
	 * @param request
	 *        the move element request
	 * @param targetEditPart
	 *        the group target edit part
	 */
	public MoveElementInGroupCommand(MoveRequest request, EditPart targetEditPart) {
		super(request);
		groupPart = targetEditPart;
		request.setParameter(IEditCommandRequest.REPLACE_DEFAULT_COMMAND, Boolean.TRUE);
	}


	/**
	 * Gets the feature of the group referencing the target element <code>element</code> after it is moved.
	 * 
	 * @param element
	 *        the element to be moved
	 * @return the feature that will reference the element in the target
	 */
	@Override
	protected EReference getTargetFeature(EObject element) {
		EReference feature = (EReference)getElementsToMove().get(element);
		if(feature == null && groupPart instanceof IGraphicalEditPart) {
			// find among references registered to the group framework which is the best
			IContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor((IGraphicalEditPart)groupPart);
			feature = Utils.getBestReferenceAmongList(desc.getChildrenReferences(), element);
		}
		return feature;
	}

	/**
	 * Checks that the element and the target to be modified by this command are correct.
	 */
	@Override
	public boolean canExecute() {

		EObject container = getTargetContainer();

		if(container == null || getElementsToMove() == null || getElementsToMove().isEmpty()) {
			return false;
		}

		for(Iterator<?> i = getElementsToMove().keySet().iterator(); i.hasNext();) {
			EObject element = (EObject)i.next();
			EReference feature = getTargetFeature(element);

			if(feature == null || !container.eClass().getEAllReferences().contains(feature)) {
				// If the target feature doesn't exist in the target container,
				// don't allow the move.
				return false;
			}

			// IF the element is already in the target container...
			Object children = container.eGet(feature);
			if(children instanceof Collection<?>) {
				if(((Collection<?>)children).contains(element)) {
					// Don't allow the reparenting
					return false;
				}
			}

			// IF the element is the parent of the target container...
			if(EcoreUtil.isAncestor(element, getTargetContainer())) {
				// Don't allow the reparenting
				return false;
			}

			// IF the container can not contain the element...
			if(!PackageUtil.canReference(getTargetContainer().eClass(), feature, element.eClass())) {
				// Don't allow the reparenting
				return false;
			}
		}

		return true;
	}

}
