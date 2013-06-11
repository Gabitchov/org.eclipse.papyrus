/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkEndEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkStartEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class RestoreDurationConstraintLinkCommand extends AbstractTransactionalCommand {

	private IAdaptable dcViewAdapter;

	private EditPartViewer viewer;

	private Boolean isOnTop;

	private Point targetLocation;

	private PreferencesHint diagramPreferenceHint;

	/**
	 * Constructor.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 */
	public RestoreDurationConstraintLinkCommand(TransactionalEditingDomain domain, IAdaptable dcViewAdapter, EditPartViewer viewer, Boolean isOnTop, Point targetLocation, PreferencesHint diagramPreferenceHint) {
		super(domain, "Resotore Annotated Link", null);
		this.dcViewAdapter = dcViewAdapter;
		this.viewer = viewer;
		this.isOnTop = isOnTop;
		this.targetLocation = targetLocation;
		this.diagramPreferenceHint = diagramPreferenceHint;
	}

	/**
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		if(dcViewAdapter == null || viewer == null || targetLocation == null) {
			return false;
		}
		return super.canExecute();
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
			return CommandResult.newCancelledCommandResult();
		}
		View view = (View)dcViewAdapter.getAdapter(View.class);
		if(view == null) {
			return CommandResult.newErrorCommandResult("No view found");
		}
		EditPart sourceEditPart = (EditPart)viewer.getEditPartRegistry().get(view);
		if(sourceEditPart == null) {
			return CommandResult.newCancelledCommandResult();
		}
		Rectangle bounds = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)sourceEditPart);
		Point sourceLocation = null;
		if(isOnTop != null) {
			sourceLocation = isOnTop.booleanValue() ? bounds.getTop() : bounds.getBottom();
		} else if(targetLocation.y >= bounds.getCenter().y) {
			sourceLocation = bounds.getBottom();
		} else {
			sourceLocation = bounds.getTop();
		}
		EditPart targetEditPart = null;
		CreateConnectionViewRequest request = CreateViewRequestFactory.getCreateConnectionRequest(UMLElementTypes.CommentAnnotatedElement_4010, diagramPreferenceHint);
		request.setLocation(sourceLocation);
		request.setType(AnnotatedLinkStartEditPolicy.REQ_ANNOTATED_LINK_START);
		request.setSourceEditPart(sourceEditPart);
		request.setTargetEditPart(sourceEditPart);
		Command command = sourceEditPart.getCommand(request);
		//connect...
		request.setLocation(targetLocation);
		request.setType(AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_END);
		targetEditPart = sourceEditPart.getViewer().findObjectAtExcluding(targetLocation, Collections.emptySet(), getTargetingConditional(request));
		request.setTargetEditPart(targetEditPart);
		command = targetEditPart.getCommand(request);
		if(command != null && command.canExecute()) {
			command.execute();
		}
		return CommandResult.newOKCommandResult();
	}

	protected EditPartViewer.Conditional getTargetingConditional(final Request req) {
		return new EditPartViewer.Conditional() {

			public boolean evaluate(EditPart editpart) {
				return editpart.getTargetEditPart(req) != null;
			}
		};
	}
}
