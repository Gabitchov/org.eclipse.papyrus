/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.CutAndInsertOccurrenceSpecificationCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies.AbstractTimelineLayoutPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.SmallSquareFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.parts.NoScrollNoBorderDragEditPartsTracker;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.RequestUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLPackage;

public class CustomFullStateInvariantEditPartCN extends FullStateInvariantEditPartCN {

	public CustomFullStateInvariantEditPartCN(final View view) {
		super(view);
	}

	/**
	 * The drag tracker has been specialized in order to constrain movement inside its container without scroll bar
	 * 
	 * @see http://wiki.eclipse.org/Papyrus_Developer_Guide/NoScrollbar
	 */
	@Override
	public DragTracker getDragTracker(final Request request) {
		return new NoScrollNoBorderDragEditPartsTracker(this);
	}

	@Override
	public void performRequest(final Request request) {
		// allow creating an OccurrenceSpecification when double-clicking on a StateInvariant line
		// (in addition to the OccurrenceSpecification creation tool from the palette)
		if (request.getType() == REQ_OPEN && request instanceof LocationRequest) {
			final StateInvariant stateInvariant = (StateInvariant) ((View) getModel()).getElement();
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(stateInvariant);
			// shift by 2 pixels to cut at the center of the OccurrenceSpecification
			final Point loc = new Point(((LocationRequest) request).getLocation()).translate(-SmallSquareFigure.RADIUS, 0);
			final CompositeCommand compositeCommand = new CompositeCommand(Messages.CustomFullStateInvariantEditPartCN_CreateOccurrenceSpecification);
			compositeCommand.add(new CutAndInsertOccurrenceSpecificationCommand(this, loc, false));
			final EditPart timeline = EditPartUtils.findParentEditPartWithId(this, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
			final Command updateLayoutCommand = timeline.getCommand(AbstractTimelineLayoutPolicy.UPDATE_LAYOUT_REQUEST);
			compositeCommand.add(new CommandProxy(updateLayoutCommand));
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(compositeCommand));
		} else {
			super.performRequest(request);
		}
	}

	@Override
	public Command getCommand(final Request request) {
		if (request instanceof ChangeBoundsRequest) {
			final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;
			// we allow moving an OccurrenceSpecification on top of a StateInvariant line
			// in this case, we redirect the request to the parent timeline compartment
			if (RequestUtils.isChangeBoundsRequestFor(changeBoundsRequest, UMLPackage.eINSTANCE.getOccurrenceSpecification())) {
				return getTimelineCompartmentEditPart().getCommand(request);
			}
		} else if (request instanceof EditCommandRequestWrapper) {
			// we also need to forward this request, otherwise the feedback figure stays displayed
			final EditCommandRequestWrapper editCommandRequestWrapper = (EditCommandRequestWrapper) request;
			final IEditCommandRequest editCommandRequest = editCommandRequestWrapper.getEditCommandRequest();
			if (editCommandRequest instanceof MoveRequest) {
				final MoveRequest moveRequest = (MoveRequest) editCommandRequest;
				if (moveRequest.getTargetContainer() instanceof StateInvariant) {
					return getTimelineCompartmentEditPart().getCommand(request);
				}
			}
		}
		return super.getCommand(request);
	}

	private FullLifelineTimelineCompartmentEditPartCN getTimelineCompartmentEditPart() {
		final FullLifelineTimelineCompartmentEditPartCN timelineEditPart = (FullLifelineTimelineCompartmentEditPartCN) EditPartUtils.findParentEditPartWithId(
				this, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		return timelineEditPart;
	}

	@Override
	protected void addBorderItem(final IFigure borderItemContainer, final IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof FullStateInvariantAppliedStereotypeEditPart) {
			final BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH) {
				@Override
				public int getPreferredSideOfParent() {
					/*
					 * Avoids an infinite layout bug that makes the UI thread freeze indefinitely, because
					 * BorderItemLocator continuously switches from PositionConstants.TOP to PositionConstants.MIDDLE.
					 */
					return PositionConstants.TOP;
				}
			};
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}
}
