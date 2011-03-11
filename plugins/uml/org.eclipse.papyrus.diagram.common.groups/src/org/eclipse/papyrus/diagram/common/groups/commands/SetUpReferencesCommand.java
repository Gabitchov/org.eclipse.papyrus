/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
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
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.diagram.common.groups.utils.GroupRequestConstants;

/**
 * Command to update referencing groups for a child element.
 * (The child element is not necessary already created, it has just to be available through an adapter at runtime execution)
 * 
 * @author arthur daussy
 */
public class SetUpReferencesCommand extends AbstractTransactionalCommand {

	private CreateElementRequestAdapter elementAdapter;


	/**
	 * Command constructor
	 * 
	 * @param domain
	 *        editing domain
	 * @param label
	 *        command label
	 * @param adapter
	 *        adapter to recover created element
	 */
	public SetUpReferencesCommand(TransactionalEditingDomain domain, String label, CreateElementRequestAdapter adapter) {
		super(domain, label, null);
		elementAdapter = adapter;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws ExecutionException
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
		Object createdElement = elementAdapter.getAdapter(EObject.class);
		if(createdElement instanceof EObject) {
			EObject eObjectCreatedElement = (EObject)createdElement;
			//Check if the added field are available
			CreateElementRequest createElementRequest = (CreateElementRequest)elementAdapter.getAdapter(CreateElementRequest.class);
			Object list = createElementRequest.getParameter(GroupRequestConstants.GRAPHICAL_CONTAINERS);
			if(list instanceof List<?>) {
				List<?> graphicaParentList = (List<?>)list;
				for(Object parent : graphicaParentList) {
					if(parent instanceof IGraphicalEditPart) {
						IGraphicalEditPart part = (IGraphicalEditPart)parent;
						EObject eObjectSourceReference = part.resolveSemanticElement();
						AbstractContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(part);
						List<EReference> refs = desc.getReferenceFor(eObjectCreatedElement.eClass());
						for(EReference ref : refs) {
							if(ref != null && ref.isMany()) {
								Collection<EObject> collection = (Collection<EObject>)eObjectSourceReference.eGet(ref);
								if(!collection.contains(eObjectCreatedElement)) {
									collection.add(eObjectCreatedElement);
								}
							} else if(ref != null && !ref.isMany()) {
								eObjectSourceReference.eSet(ref, eObjectCreatedElement);
							}
						}
					}

				}
			}
		}

		return CommandResult.newOKCommandResult();
	}

}
