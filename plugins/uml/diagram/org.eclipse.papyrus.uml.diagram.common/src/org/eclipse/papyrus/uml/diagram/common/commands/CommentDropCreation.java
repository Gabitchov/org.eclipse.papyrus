/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;


/**
 * this command is used to create a comment and to drop into a diagram.
 * This command is independent from diagrams
 * 
 */
public class CommentDropCreation extends AbstractCommand {

	protected String content = null;

	protected Object owner = null;

	protected GraphicalEditPart targetEditPart;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param label
	 *        label of the command
	 * @param content
	 *        content to put in the comment
	 * @param owner
	 *        the owner of the comment
	 * @param targetEditPart
	 *        the target editpart in which will be display the comment
	 */
	public CommentDropCreation(String label, String content, Object owner, GraphicalEditPart targetEditPart) {
		super(label);
		this.content = content;
		this.owner = owner;
		this.targetEditPart = targetEditPart;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		if(owner instanceof Element) {
			//creation of the command
			Comment comment = ((Element)owner).createOwnedComment();
			comment.setBody(content);
			CommandResult result = CommandResult.newOKCommandResult(comment);
			setResult(result);

			//drop the comment into the target editPart
			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			dropObjectsRequest.setLocation(new Point(10, 10));
			ArrayList objectList = new ArrayList();
			objectList.add(comment);
			dropObjectsRequest.setObjects(objectList);
			org.eclipse.gef.commands.Command cmd = targetEditPart.getCommand(dropObjectsRequest);
			if(cmd != null) {
				targetEditPart.getEditingDomain().getCommandStack().execute(new org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper(cmd));
			}
			return result;
		}
		return CommandResult.newOKCommandResult();
	}

	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return null;
	}

	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return null;
	}

}
