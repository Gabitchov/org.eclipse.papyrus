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
 *   Atos - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.listeners.DropTargetListener;
import org.eclipse.swt.dnd.DND;

/**
 * This command drag and drop the content of the element which just be dropped
 * 
 */
public class DeferredCreateCommand extends AbstractTransactionalCommand {

	private IAdaptable adapter;

	private EditPartViewer editPartViewer;

	private EObject parent;

	public DeferredCreateCommand(TransactionalEditingDomain domain, EObject parentEObject, IAdaptable parentAdapter, EditPartViewer editPartViewer) {

		super(domain, DiagramUIMessages.CreateCommand_Label, getWorkspaceFiles(parentEObject));
		this.editPartViewer = editPartViewer;

		Assert.isNotNull(parentAdapter);

		this.adapter = parentAdapter;
		this.parent = parentEObject;

	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		View view = (View)adapter.getAdapter(View.class);
		if(view != null) {
			// Get the parent edit part
			EditPart parentEditPart = (EditPart)editPartViewer.getEditPartRegistry().get(view.eContainer());
			parentEditPart.refresh();
			Object editPart = editPartViewer.getEditPartRegistry().get(view);
			List<IGraphicalEditPart> graphicalEditParts = new ArrayList<IGraphicalEditPart>();
			if(editPart != null && editPart instanceof IGraphicalEditPart) {
				IGraphicalEditPart graphicalParentEditPart = (IGraphicalEditPart)editPart;
				graphicalEditParts.add(graphicalParentEditPart);
				// Get all the graphical editparts
				for(Object child : graphicalParentEditPart.getChildren()) {
					if(child instanceof IGraphicalEditPart) {
						graphicalEditParts.add((IGraphicalEditPart)child);
					}
				}
				// for all child check if it can be add for all graphical editparts
				for(EObject child : parent.eContents()) {
					boolean alreadyDisplay = false;
					for(IGraphicalEditPart gep : graphicalEditParts) {
						DropObjectsRequest request = new DropObjectsRequest();
						request.setObjects(Collections.singletonList(child));
						request.setLocation(new Point(10, 10));
						if(request.getExtendedData() != null) {
							request.getExtendedData().put(DropTargetListener.EVENT_DETAIL, DND.DROP_COPY);
						}
						final Command command = gep.getCommand(request);
						// If possible do the drop
						if(command != null && command.canExecute() && !alreadyDisplay) {
							command.execute();
							parentEditPart.refresh();
							alreadyDisplay = true;
							// Arrange all
							if(gep.getChildren() != null && !gep.getChildren().isEmpty()) {
								ArrangeRequest r = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL);
								r.setPartsToArrange(gep.getChildren());
								Command d = gep.getCommand(r);
								if(d != null && d.canExecute()) {
									d.execute();
								}
								//TODO : auto-resize
							}
						}
					}
				}
			}
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canExecute() {
		return true;
	}

}
