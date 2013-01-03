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
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.OccurrenceSpecificationUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLFactory;

/** This command cuts a StateInvariant in two at a given Location, and inserts an OccurrenceSpecification. */
public class CutAndInsertOccurrenceSpecificationCommand extends AbstractTransactionalCommand {

	private final FullStateInvariantEditPartCN fullStateInvariantEditPartCN;
	private final Point location;
	private final FullLifelineEditPartCN lifelineEditPart;
	private final Lifeline lifeline;
	private final boolean destruction;

	/**
	 * @param fullStateInvariantEditPartCN
	 *            the state invariant to cut in two
	 * @param location
	 *            where the user clicked: the horizontal coordinate indicates where to insert the
	 *            OccurrenceSpecification
	 * @param destruction
	 *            whether to create a DestructionOccurrenceSpecification
	 */
	public CutAndInsertOccurrenceSpecificationCommand(final FullStateInvariantEditPartCN fullStateInvariantEditPartCN, final Point location,
			final boolean destruction) {
		super(getEditingDomain(fullStateInvariantEditPartCN), Messages.CutAndInsertOccurrenceSpecificationCommand_CreateOccurrenceSpecification, null);
		this.fullStateInvariantEditPartCN = fullStateInvariantEditPartCN;
		this.location = location;
		this.destruction = destruction;
		this.lifelineEditPart = (FullLifelineEditPartCN) EditPartUtils.findParentEditPartWithId(this.fullStateInvariantEditPartCN,
				FullLifelineEditPartCN.VISUAL_ID);
		this.lifeline = (Lifeline) ((View) this.lifelineEditPart.getModel()).getElement();
	}

	private static TransactionalEditingDomain getEditingDomain(final FullStateInvariantEditPartCN fullStateInvariantEditPart) {
		final StateInvariant stateInvariant = (StateInvariant) ((View) fullStateInvariantEditPart.getModel()).getElement();
		return TransactionUtil.getEditingDomain(stateInvariant);
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final FullLifelineTimelineCompartmentEditPartCN timelineCompartmentEditPart = (FullLifelineTimelineCompartmentEditPartCN) EditPartUtils
				.findFirstChildEditPartWithId(this.lifelineEditPart, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		final View timelineCompartmentView = (View) timelineCompartmentEditPart.getModel();
		final View stateInvariantView = (View) this.fullStateInvariantEditPartCN.getModel();
		final StateInvariant firstStateInvariant = (StateInvariant) stateInvariantView.getElement();

		final int indexInFragments = this.lifeline.getInteraction().getFragments().indexOf(firstStateInvariant);
		final int indexInCoveredBys = this.lifeline.getCoveredBys().indexOf(firstStateInvariant);
		final int indexInCompartment = timelineCompartmentView.getChildren().indexOf(stateInvariantView);

		// create occurrence specification
		final OccurrenceSpecification newOccurrenceSpecification = this.destruction ? UMLFactory.eINSTANCE.createDestructionOccurrenceSpecification()
				: UMLFactory.eINSTANCE.createOccurrenceSpecification();
		OccurrenceSpecificationUtils.setAutogeneratedName(newOccurrenceSpecification, true);
		this.lifeline.getInteraction().getFragments().add(indexInFragments + 1, newOccurrenceSpecification);
		this.lifeline.getCoveredBys().add(indexInCoveredBys + 1, newOccurrenceSpecification);

		// create View for occurrence specification
		final UMLViewProvider umlViewProvider = new UMLViewProvider();

		final Node occurrenceSpecificationView;
		if (this.destruction) {
			occurrenceSpecificationView = umlViewProvider.createDestructionOccurrenceSpecification_27(newOccurrenceSpecification, timelineCompartmentView,
					indexInCompartment + 1, true, PreferencesHint.USE_DEFAULTS);
		} else {
			occurrenceSpecificationView = umlViewProvider.createOccurrenceSpecification_12(newOccurrenceSpecification, timelineCompartmentView,
					indexInCompartment + 1, true, PreferencesHint.USE_DEFAULTS);
		}
		final Location loc = NotationFactory.eINSTANCE.createLocation();
		final Point pt = new Point(this.location);
		timelineCompartmentEditPart.getFigure().translateToRelative(pt);
		pt.translate(timelineCompartmentEditPart.getFigure().getBounds().getTopLeft().getNegated());
		loc.setX(pt.x);
		loc.setY(pt.y);
		occurrenceSpecificationView.setLayoutConstraint(loc);

		if (this.destruction) {
			OccurrenceSpecificationUtils.deleteEverythingAfter(newOccurrenceSpecification, occurrenceSpecificationView);
		} else {
			// create a VerticalLine View to link the two StateInvariants
			umlViewProvider.createNode_39(null, timelineCompartmentView, indexInCompartment + 2, true, PreferencesHint.USE_DEFAULTS);

			// get first state invariant id
			final String id = StateInvariantUtils.getStateInvariantId(firstStateInvariant);

			// create a second state invariant with the same state id (on the same state)
			StateInvariantUtils.createStateInvariant(id, this.lifelineEditPart, indexInFragments + 2, indexInCoveredBys + 2, indexInCompartment + 3);
		}

		// update the names of the adjacent occurrences
		LifelineUtils.updateFragmentNames(this.lifeline, (View) this.lifelineEditPart.getModel());

		timelineCompartmentEditPart.refresh();
		ViewUtils.selectInViewer(occurrenceSpecificationView, this.lifelineEditPart.getViewer());

		return CommandResult.newOKCommandResult(newOccurrenceSpecification);
	}
}
