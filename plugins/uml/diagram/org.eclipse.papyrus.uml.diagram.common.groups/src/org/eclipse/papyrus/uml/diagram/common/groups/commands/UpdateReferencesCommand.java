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
package org.eclipse.papyrus.uml.diagram.common.groups.commands;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;

/**
 * Update all references of a parent group.
 * This class will set or unset references of the parent from a given child list
 * 
 * @author arthur daussy
 * 
 */

public class UpdateReferencesCommand extends AbstractTransactionalCommand {

	/**
	 * Mode used to set references
	 */
	public final static boolean SET_MODE = true;

	/**
	 * Mode used to unset references
	 */
	public final static boolean UNSET_MODE = false;

	/**
	 * List of all {@link IGraphicalEditPart} of all children
	 */
	private List<IGraphicalEditPart> childrenPart;

	/**
	 * {@link AbstractContainerNodeDescriptor} of the parent group
	 */
	private AbstractContainerNodeDescriptor descriptor;

	/**
	 * {@link IAdaptable} of the parent (Used to find {@link EObject}
	 */
	private IAdaptable elementAdapter;

	/**
	 * Current mode {@link UpdateReferencesCommand#UNSET_MODE} and {@link #SET_MODE}
	 */
	private boolean setMode = true;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @see {@link AbstractTransactionalCommand}
	 * @param label
	 * @see {@link AbstractTransactionalCommand}
	 * @param children
	 * @see {@link #childrenPart}
	 * @param descriptor
	 * @see {@link #descriptor}
	 * @param adapter
	 * @see {@link #elementAdapter}
	 */
	public UpdateReferencesCommand(TransactionalEditingDomain domain, String label, List<IGraphicalEditPart> children, AbstractContainerNodeDescriptor descriptor, IAdaptable adapter) {
		super(domain, label, null);
		this.descriptor = descriptor;
		elementAdapter = adapter;
		this.childrenPart = children;

	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @see {@link AbstractTransactionalCommand}
	 * @param label
	 * @see {@link AbstractTransactionalCommand}
	 * @param children
	 * @see {@link #childrenPart}
	 * @param descriptor
	 * @see {@link #descriptor}
	 * @param adapter
	 * @see {@link #elementAdapter}
	 */
	public UpdateReferencesCommand(TransactionalEditingDomain domain, String label, List<IGraphicalEditPart> children, AbstractContainerNodeDescriptor descriptor, IAdaptable adapter, boolean mode) {
		super(domain, label, null);
		this.descriptor = descriptor;
		elementAdapter = adapter;
		this.childrenPart = children;
		this.setMode = mode;

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
		Object createdElement = elementAdapter.getAdapter(EObject.class);
		if(createdElement instanceof EObject) {
			EObject eObjectCreatedElement = (EObject)createdElement;
			for(IGraphicalEditPart part : childrenPart) {
				EObject childElement = part.resolveSemanticElement();
				List<EReference> refs = descriptor.getReferenceFor(childElement.eClass());
				for(EReference ref : refs) {
					//Add reference to the father
					if(ref != null && ref.isMany()) {
						//ref.getEOpposite()
						Collection<EObject> collection = (Collection<EObject>)eObjectCreatedElement.eGet(ref);
						if(setMode) {
							if(!collection.contains(childElement)) {
								collection.add(childElement);
							}
						} else {
							if(collection.contains(childElement)) {
								collection.remove(childElement);
							}
						}
						//Remove all element which have a model sons in the collection
					} else if(ref != null && !ref.isMany()) {
						if(setMode) {
							eObjectCreatedElement.eSet(ref, childElement);
						} else {
							eObjectCreatedElement.eUnset(ref);
						}
					}
				}
				Utils.withDrawRedundantElementReferenced(childElement);
			}
		}

		return CommandResult.newOKCommandResult();
	}


}
