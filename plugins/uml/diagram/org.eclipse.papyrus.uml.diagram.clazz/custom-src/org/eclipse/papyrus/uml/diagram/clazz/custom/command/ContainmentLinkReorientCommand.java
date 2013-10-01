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
 *  Fadoi LAKHAL  Fadoi.Lakhal@cea.fr - Initial API and implementation
 *  Tatiana Fesenko (CEA LIST) -  318000 [Class Diagram] Refactor the creation / move / drag and drop behavior of the ContainmentLink
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContainmentSubLinkEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * The Class AddedLinkReorientCommand is used to reorient a containment link.
 */
public class ContainmentLinkReorientCommand extends AbstractTransactionalCommand {

	/** The reorient direction. */
	private final int reorientDirection;

	/** The old end. */
	private final EObject oldEnd;

	/** The new end. */
	private final EObject newEnd;

	/** The my target edit part. */
	private EditPart myTargetEditPart;

	/** The old end visual parent. */
	private EObject oldEndVisualParent;

	/**
	 * Instantiates a new containment link reorient command.
	 * 
	 * @param req
	 *        the req
	 * @param editPartTarget
	 *        the edit part target
	 */
	public ContainmentLinkReorientCommand(ReorientReferenceRelationshipRequest req, EditPart editPartTarget) {
		super(req.getEditingDomain(), req.getLabel(), null);
		myTargetEditPart = editPartTarget;
		reorientDirection = req.getDirection();
		final EObject oldEndView;
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			oldEndView = ((Edge)req.getParameter(ContainmentHelper.KEY_CONNECTION_VIEW)).getSource();
		} else if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			oldEndView = ((Edge)req.getParameter(ContainmentHelper.KEY_CONNECTION_VIEW)).getTarget();
		} else {
			throw new IllegalStateException();
		}
		oldEndVisualParent = ((View)oldEndView.eContainer()).getElement();
		oldEnd = req.getOldRelationshipEnd();
		newEnd = req.getNewRelationshipEnd();
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	public boolean canExecute() {
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * Can reorient source.
	 * 
	 * @return true, if successful
	 */
	protected boolean canReorientSource() {
		return false;
	}

	/**
	 * Can reorient target.
	 * 
	 * @return true, if successful
	 */
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof PackageableElement && newEnd instanceof PackageableElement)) {
			return false;
		}
		if(getNewTarget().equals(getOldTarget().getOwner())) {
			return false;
		}
		if(EcoreUtil.isAncestor(getNewTarget(), getOldTarget())) {
			return false;
		}
		return newEnd != null;
	}

	/**
	 * Reorient source.
	 * 
	 * @return the command result
	 * @throws ExecutionException
	 *         the execution exception
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		throw new ExecutionException("Cannot reorient a source of Containment link");
	}

	/**
	 * Reorient target.
	 * 
	 * @return the command result
	 * @throws ExecutionException
	 *         the execution exception
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		EObject source = getOldTarget().getOwner();
		EObject moveOldTargetTo = getOldTargetOwner();
		EObject moveNewTargetTo = source;
		ContainmentHelper helper = new ContainmentHelper(getEditingDomain());
		helper.move(getOldTarget(), moveOldTargetTo);
		helper.move(getNewTarget(), moveNewTargetTo);
		deleteOldLinkEditPart();
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Delete old link edit part.
	 * 
	 * @return true, if successful
	 */
	private boolean deleteOldLinkEditPart() {
		if(myTargetEditPart instanceof ClassEditPart || myTargetEditPart instanceof PackageEditPart) {
			CompoundCommand cc = new CompoundCommand();
			for(Object currentLink : ((AbstractGraphicalEditPart)myTargetEditPart).getTargetConnections()) {
				if(currentLink instanceof ContainmentSubLinkEditPart) {
					ContainmentSubLinkEditPart addedLinkEP = (ContainmentSubLinkEditPart)currentLink;
					if((addedLinkEP.getSource() instanceof CContainmentCircleEditPart)) {
						if(((CContainmentCircleEditPart)addedLinkEP.getSource()).getSourceConnections().size() == 1) {
							cc.add(new ICommandProxy(new DeleteCommand(getEditingDomain(), (View)addedLinkEP.getSource().getModel())));
						}
						cc.add(new ICommandProxy(new DeleteCommand(getEditingDomain(), addedLinkEP.getNotationView())));
					}
				}
			}
			cc.execute();
		}
		return true;
	}

	/**
	 * Gets the old source.
	 * 
	 * @return the old source
	 */
	private PackageableElement getOldSource() {
		return (PackageableElement)oldEnd;
	}

	/**
	 * Gets the new source.
	 * 
	 * @return the new source
	 */
	private PackageableElement getNewSource() {
		return (PackageableElement)newEnd;
	}

	/**
	 * Gets the old target.
	 * 
	 * @return the old target
	 */
	private PackageableElement getOldTarget() {
		return (PackageableElement)oldEnd;
	}

	/**
	 * Gets the new target.
	 * 
	 * @return the new target
	 */
	private PackageableElement getNewTarget() {
		return (PackageableElement)newEnd;
	}

	/**
	 * Gets the old target owner.
	 * 
	 * @return the old target owner
	 */
	private EObject getOldTargetOwner() {
		return oldEndVisualParent;
	}
}
