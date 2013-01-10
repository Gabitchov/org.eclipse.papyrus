/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This command cuts a StateInvariant in two StateInvariants, with an OccurrenceSpecification in between the two
 * StateInvariants.
 */
public class CutAndInsertOccurrenceSpecificationCompactLifelineCommand extends AbstractTransactionalCommand {

	private final CompactStateInvariantEditPartCN compactStateInvariantEditPartCN;

	private final Point location;

	private final CompactLifelineEditPartCN lifelineEditPart;

	private final Lifeline lifeline;

	private final boolean destruction;

	/**
	 * @param fullStateInvariantEditPartCN
	 *        the state invariant to cut in two
	 * @param location
	 *        where the user clicked: the horizontal coordinate indicates where to insert the
	 *        OccurrenceSpecification
	 * @param destruction
	 *        whether to create a DestructionOccurrenceSpecification
	 */
	public CutAndInsertOccurrenceSpecificationCompactLifelineCommand(final CompactStateInvariantEditPartCN compactStateInvariantEditPartCN, final Point location, final boolean destruction) {
		super(getEditingDomain(compactStateInvariantEditPartCN), Messages.CutAndInsertOccurrenceSpecificationCompactLifelineCommand_CreateOccurrenceSpecification, null);
		this.compactStateInvariantEditPartCN = compactStateInvariantEditPartCN;
		this.location = location;
		this.destruction = destruction;
		this.lifelineEditPart = (CompactLifelineEditPartCN)EditPartUtils.findParentEditPartWithId(this.compactStateInvariantEditPartCN, CompactLifelineEditPartCN.VISUAL_ID);
		this.lifeline = (Lifeline)((View)this.lifelineEditPart.getModel()).getElement();
	}

	private static TransactionalEditingDomain getEditingDomain(final CompactStateInvariantEditPartCN compactStateInvariantEditPart) {
		final StateInvariant stateInvariant = (StateInvariant)((View)compactStateInvariantEditPart.getModel()).getElement();
		return TransactionUtil.getEditingDomain(stateInvariant);
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final CompactLifelineCompartmentEditPartCN timelineCompartmentEditPart = (CompactLifelineCompartmentEditPartCN)EditPartUtils.findFirstChildEditPartWithId(this.lifelineEditPart, CompactLifelineCompartmentEditPartCN.VISUAL_ID);

		final View timelineCompartmentView = (View)timelineCompartmentEditPart.getModel();

		// translate the coordinates
		final Point pt = new Point(this.location);
		timelineCompartmentEditPart.getFigure().translateToRelative(pt);
		pt.translate(timelineCompartmentEditPart.getFigure().getBounds().getTopLeft().getNegated());

		// find where to insert the OccurrenceSpecification
		int insertionIndexInCompartment = OccurrenceSpecificationUtils.findInsertionIndexFor(pt, timelineCompartmentView, timelineCompartmentEditPart.getViewer());
		int insertionIndexInFragments;
		int insertionIndexInCoveredBys;
		if(insertionIndexInCompartment < timelineCompartmentView.getChildren().size()) {
			final View view = (View)timelineCompartmentView.getChildren().get(insertionIndexInCompartment);
			final EObject element = view.getElement();
			insertionIndexInFragments = this.lifeline.getInteraction().getFragments().indexOf(element);
			insertionIndexInCoveredBys = this.lifeline.getCoveredBys().indexOf(element);
		} else {
			insertionIndexInFragments = -1;
			insertionIndexInCoveredBys = -1;
		}

		// create the occurrence specification at the right index
		final OccurrenceSpecification newOccurrenceSpecification = this.destruction ? UMLFactory.eINSTANCE.createDestructionOccurrenceSpecification() : UMLFactory.eINSTANCE.createOccurrenceSpecification();
		OccurrenceSpecificationUtils.setAutogeneratedName(newOccurrenceSpecification, true);
		if(insertionIndexInFragments == -1) {
			this.lifeline.getInteraction().getFragments().add(newOccurrenceSpecification);
		} else {
			this.lifeline.getInteraction().getFragments().add(insertionIndexInFragments, newOccurrenceSpecification);
		}
		if(insertionIndexInCoveredBys == -1) {
			this.lifeline.getCoveredBys().add(newOccurrenceSpecification);
		} else {
			this.lifeline.getCoveredBys().add(insertionIndexInCoveredBys, newOccurrenceSpecification);
		}

		// create the View for the occurrence specification
		final UMLViewProvider umlViewProvider = new UMLViewProvider();

		final Node occurrenceSpecificationView;
		if(this.destruction) {
			occurrenceSpecificationView = umlViewProvider.createDestructionOccurrenceSpecification_27(newOccurrenceSpecification, timelineCompartmentView, insertionIndexInCompartment, true, PreferencesHint.USE_DEFAULTS);
		} else {
			occurrenceSpecificationView = umlViewProvider.createOccurrenceSpecification_12(newOccurrenceSpecification, timelineCompartmentView, insertionIndexInCompartment, true, PreferencesHint.USE_DEFAULTS);
		}

		final Location loc = NotationFactory.eINSTANCE.createLocation();
		loc.setX(pt.x);
		loc.setY(pt.y);
		occurrenceSpecificationView.setLayoutConstraint(loc);

		if(this.destruction) {
			OccurrenceSpecificationUtils.deleteEverythingAfter(newOccurrenceSpecification, occurrenceSpecificationView);
		} else {
			// increase the indices for inserting the state invariant (don't increase -1 since it means "at the end")
			if(insertionIndexInFragments != -1) {
				insertionIndexInFragments++;
			}
			if(insertionIndexInCoveredBys != -1) {
				insertionIndexInCoveredBys++;
			}
			if(insertionIndexInCompartment != -1) {
				insertionIndexInCompartment++;
			}

			// create a new state invariant
			StateInvariantUtils.createCompactStateInvariant(timelineCompartmentView, insertionIndexInFragments, insertionIndexInCoveredBys, insertionIndexInCompartment);
		}

		LifelineUtils.updateFragmentNames(this.lifeline, null);

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				timelineCompartmentEditPart.refresh();
				ViewUtils.selectInViewer(occurrenceSpecificationView, CutAndInsertOccurrenceSpecificationCompactLifelineCommand.this.lifelineEditPart.getViewer());
			}
		});

		return CommandResult.newOKCommandResult(newOccurrenceSpecification);
	}

}
