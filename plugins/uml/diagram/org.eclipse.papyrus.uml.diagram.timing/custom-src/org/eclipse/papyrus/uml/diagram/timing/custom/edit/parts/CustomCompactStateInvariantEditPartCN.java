/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.CutAndInsertOccurrenceSpecificationCompactLifelineCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies.AbstractTimelineLayoutPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.SmallSquareFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateInvariantAppliedStereotypeEditPart;
import org.eclipse.uml2.uml.StateInvariant;

public class CustomCompactStateInvariantEditPartCN extends CompactStateInvariantEditPartCN {

	public CustomCompactStateInvariantEditPartCN(final View view) {
		super(view);
	}

	@Override
	public void performRequest(final Request request) {
		// allow creating an OccurrenceSpecification when double-clicking on a StateInvariant line
		// (in addition to the OccurrenceSpecification creation tool from the palette)
		if(request.getType() == REQ_OPEN && request instanceof LocationRequest) {
			final StateInvariant stateInvariant = (StateInvariant)((View)getModel()).getElement();
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(stateInvariant);
			// shift by 2 pixels to cut at the center of the OccurrenceSpecification
			final Point loc = new Point(((LocationRequest)request).getLocation()).translate(-SmallSquareFigure.RADIUS, 0);
			final CompositeCommand compositeCommand = new CompositeCommand(Messages.CustomCompactStateInvariantEditPartCN_CreateOccurrenceSpecification);
			compositeCommand.add(new CutAndInsertOccurrenceSpecificationCompactLifelineCommand(this, loc, false));
			final EditPart timeline = EditPartUtils.findParentEditPartWithId(this, CompactLifelineCompartmentEditPartCN.VISUAL_ID);
			final Command updateLayoutCommand = timeline.getCommand(AbstractTimelineLayoutPolicy.UPDATE_LAYOUT_REQUEST);
			compositeCommand.add(new CommandProxy(updateLayoutCommand));
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(compositeCommand));
		} else {
			super.performRequest(request);
		}
	}

	@Override
	protected void addBorderItem(final IFigure borderItemContainer, final IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof StateInvariantAppliedStereotypeEditPart) {
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
