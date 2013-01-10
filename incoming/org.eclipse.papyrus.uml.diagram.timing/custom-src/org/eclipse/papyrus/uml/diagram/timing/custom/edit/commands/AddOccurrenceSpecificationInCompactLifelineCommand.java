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
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.OccurrenceSpecificationUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLFactory;

/** This command adds an OccurrenceSpecification at a given Location. */
public class AddOccurrenceSpecificationInCompactLifelineCommand extends AbstractTransactionalCommand {

	private final CompactStateInvariantEditPartCN compactStateInvariantEditPartCN;

	private final Point location;

	private final CompactLifelineEditPartCN lifelineEditPart;

	private final Lifeline lifeline;

	/**
	 * @param fullStateInvariantEditPartCN
	 *        the state invariant on top of which to put the OccurrenceSpecification
	 * @param location
	 *        where the user clicked: the horizontal coordinate indicates where to insert the
	 *        OccurrenceSpecification
	 */
	public AddOccurrenceSpecificationInCompactLifelineCommand(final CompactStateInvariantEditPartCN compactStateInvariantEditPartCN, final Point location) {
		super(getEditingDomain(compactStateInvariantEditPartCN), Messages.AddOccurrenceSpecificationInCompactLifelineCommand_CreateOccurrenceSpecification, null);
		this.compactStateInvariantEditPartCN = compactStateInvariantEditPartCN;
		this.location = location;
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
		final int insertionIndexInCompartment = OccurrenceSpecificationUtils.findInsertionIndexFor(pt, timelineCompartmentView, timelineCompartmentEditPart.getViewer());
		final int insertionIndexInFragments;
		final int insertionIndexInCoveredBys;
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
		final OccurrenceSpecification newOccurrenceSpecification = UMLFactory.eINSTANCE.createOccurrenceSpecification();
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

		final Node occurrenceSpecificationView = umlViewProvider.createOccurrenceSpecification_12(newOccurrenceSpecification, timelineCompartmentView, insertionIndexInCompartment, true, PreferencesHint.USE_DEFAULTS);

		final Location loc = NotationFactory.eINSTANCE.createLocation();
		loc.setX(pt.x);
		loc.setY(pt.y);
		occurrenceSpecificationView.setLayoutConstraint(loc);

		return CommandResult.newOKCommandResult(newOccurrenceSpecification);
	}

}
