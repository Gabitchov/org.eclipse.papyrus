/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.tests.canonical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.CreateTimingDiagramCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineStateDefinitionCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantVerticalLineEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.timing.tests.generic.AbstractPapyrusTestCase;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.ValueSpecification;

public class AbstractTimingDiagramTestCase extends AbstractPapyrusTestCase {

	private InteractionEditPartTN interactionEditPart;

	private InteractionCompartmentEditPartTN interactionCompartment;

	private FullLifelineEditPartCN fullLifelineEditPart;

	private CompactLifelineEditPartCN compactLifelineEditPart;

	private FullLifelineStateDefinitionCompartmentEditPartCN stateDefinitionCompartment;

	private FullLifelineTimelineCompartmentEditPartCN fullLifelineTimelineCompartment;

	private CompactLifelineCompartmentEditPartCN compactLifelineTimelineCompartment;

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateTimingDiagramCommand();
	}

	/** Creates the default Interaction (use this when only one Interaction will be used in a test) */
	protected void createDefaultInteraction(final Point position, final Dimension size) {
		this.interactionEditPart = createInteraction(position, size);
		this.interactionCompartment = (InteractionCompartmentEditPartTN)EditPartUtils.findFirstChildEditPartWithId(this.interactionEditPart, InteractionCompartmentEditPartTN.VISUAL_ID);
		assertNotNull("The interaction compartment was not found", this.interactionCompartment);
	}

	/** Creates the default Interaction (use this when only one Interaction will be used in a test) */
	protected void createDefaultInteraction() {
		createDefaultInteraction(new Point(0, 0), new Dimension(800, 600));
	}

	/**
	 * Creates the default full Lifeline in the default Interaction (use this when only one Interaction and one Lifeline
	 * will be used in a test)
	 */
	protected void createDefaultFullLifeline() {
		this.fullLifelineEditPart = createFullLifeline(getDefaultInteractionEditPart());
		this.stateDefinitionCompartment = (FullLifelineStateDefinitionCompartmentEditPartCN)EditPartUtils.findFirstChildEditPartWithId(this.fullLifelineEditPart, FullLifelineStateDefinitionCompartmentEditPartCN.VISUAL_ID);
		assertNotNull("The StateDefinition compartment must exist", this.stateDefinitionCompartment);
		this.fullLifelineTimelineCompartment = (FullLifelineTimelineCompartmentEditPartCN)EditPartUtils.findFirstChildEditPartWithId(this.fullLifelineEditPart, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		assertNotNull("The timeline compartment must exist", this.fullLifelineTimelineCompartment);
	}

	/**
	 * Creates the default compact Lifeline in the default Interaction (use this when only one Interaction and one
	 * Lifeline will be used in a test)
	 */
	protected void createDefaultCompactLifeline() {
		this.compactLifelineEditPart = createCompactLifeline(getDefaultInteractionEditPart());
		this.compactLifelineTimelineCompartment = (CompactLifelineCompartmentEditPartCN)EditPartUtils.findFirstChildEditPartWithId(this.compactLifelineEditPart, CompactLifelineCompartmentEditPartCN.VISUAL_ID);
		assertNotNull("The timeline compartment must exist", this.compactLifelineTimelineCompartment);
	}

	/** Creates 3 state definitions in the default Lifeline */
	protected void createThreeStateDefinitionsInDefaultFullLifeline() {
		createView(UMLElementTypes.Node_9, this.stateDefinitionCompartment);
		createView(UMLElementTypes.Node_9, this.stateDefinitionCompartment);
		createView(UMLElementTypes.Node_9, this.stateDefinitionCompartment);
	}

	/**
	 * Creates a new StateDefinition in the default Lifeline using a Request.
	 * 
	 * @return the created StateDefinition's EditPart
	 */
	protected StateDefinitionEditPart createStateDefinitionInDefaultFullLifeline() {
		return createStateDefinition(getDefaultFullLifelineEditPart());
	}

	/**
	 * Creates a new StateDefinition in the given Lifeline using a Request.
	 * 
	 * @return the created StateDefinition's EditPart
	 */
	protected StateDefinitionEditPart createStateDefinition(final FullLifelineEditPartCN parentLifelineEditPart) {
		final FullLifelineStateDefinitionCompartmentEditPartCN compartment = (FullLifelineStateDefinitionCompartmentEditPartCN)EditPartUtils.findFirstChildEditPartWithId(parentLifelineEditPart, FullLifelineStateDefinitionCompartmentEditPartCN.VISUAL_ID);
		final View stateDefinitionView = createView(UMLElementTypes.Node_9, compartment);
		assertNotNull("The StateDefinition View should be created", stateDefinitionView);
		return (StateDefinitionEditPart)findChildEditPartAssociatedToView(compartment, stateDefinitionView);
	}

	/**
	 * Create a new full Lifeline in the default Interaction using a Request.
	 * 
	 * @return the created full Lifeline's EditPart
	 */
	protected FullLifelineEditPartCN createFullLifelineInDefaultInteraction() {
		return createFullLifeline(getDefaultInteractionEditPart());
	}

	/**
	 * Create a new full Lifeline in the given Interaction using a Request.
	 * 
	 * @return the created full Lifeline's EditPart
	 */
	protected FullLifelineEditPartCN createFullLifeline(final InteractionEditPartTN parentInteractionEditPart) {
		final EditPart compartment = EditPartUtils.findFirstChildEditPartWithId(parentInteractionEditPart, InteractionCompartmentEditPartTN.VISUAL_ID);
		assertNotNull("The compartment must not be null", compartment);
		final View view = createView(UMLElementTypes.Lifeline_19, compartment);
		assertNotNull("The FullLifeline View should be created", view);
		return (FullLifelineEditPartCN)findChildEditPartAssociatedToView(compartment, view);
	}

	/**
	 * Create a new compact Lifeline in the default Interaction using a Request.
	 * 
	 * @return the created compact Lifeline's EditPart
	 */
	protected CompactLifelineEditPartCN createCompactLifelineInDefaultInteraction() {
		return createCompactLifeline(getDefaultInteractionEditPart());
	}

	/**
	 * Create a new compact Lifeline in the given Interaction using a Request.
	 * 
	 * @return the created compact Lifeline's EditPart
	 */
	protected CompactLifelineEditPartCN createCompactLifeline(final InteractionEditPartTN parentInteractionEditPart) {
		final EditPart compartment = EditPartUtils.findFirstChildEditPartWithId(parentInteractionEditPart, InteractionCompartmentEditPartTN.VISUAL_ID);
		assertNotNull("The compartment must not be null", compartment);
		final View view = createView(UMLElementTypes.Lifeline_20, compartment);
		assertNotNull("The CompactLifeline View should be created", view);
		return (CompactLifelineEditPartCN)findChildEditPartAssociatedToView(compartment, view);
	}

	/**
	 * Create a new Interaction in the default diagram using a Request.
	 * 
	 * @param location
	 *        the position for the new Interaction
	 * @param dimension
	 *        the size of the new Interaction
	 * @return the created Interaction's EditPart
	 */
	protected InteractionEditPartTN createInteraction(final Point location, final Dimension dimension) {
		createView(UMLElementTypes.Interaction_2, location, dimension, getDiagramEditPart());
		final InteractionEditPartTN interactionEditPart = (InteractionEditPartTN)EditPartUtils.findFirstChildEditPartWithId(getDiagramEditPart(), InteractionEditPartTN.VISUAL_ID);
		assertNotNull("The interaction EditPart was not found under the diagram EditPart", interactionEditPart);
		final InteractionCompartmentEditPartTN interactionCompartment = (InteractionCompartmentEditPartTN)EditPartUtils.findFirstChildEditPartWithId(interactionEditPart, InteractionCompartmentEditPartTN.VISUAL_ID);
		assertNotNull("The interaction compartment was not found", interactionCompartment);
		return interactionEditPart;
	}

	/**
	 * Create a new Interaction with a default size in the default diagram using a Request.
	 * 
	 * @return the created Interaction's EditPart
	 */
	protected InteractionEditPartTN createInteraction() {
		return createInteraction(new Point(0, 0), new Dimension(800, 400));
	}

	/**
	 * Create three occurrence specifications in the default Lifeline:
	 * <ul>
	 * <li>click at 1/4 on the single StateInvariant (automatically created at the beginning; takes the whole width)
	 * <li>click at 1/3 on the just created second StateInvariant (that takes 3/4 of the width)
	 * <li>click at 1/2 on the just created second StateInvariant (that takes 1/2 of the width)
	 * <li>this results in three regularly spaced occurrence specifications
	 * <ul>
	 * 
	 */
	protected void createThreeOccurrenceSpecificationsInDefaultFullLifeline() {
		createOccurrenceSpecificationInLastFullStateInvariantWithRatio(1, 1.0 / 4.0);
		createOccurrenceSpecificationInLastFullStateInvariantWithRatio(2, 1.0 / 3.0);
		createOccurrenceSpecificationInLastFullStateInvariantWithRatio(3, 1.0 / 2.0);
	}

	/**
	 * Create three occurrence specifications in the default Lifeline:
	 * <ul>
	 * <li>click at 1/4 on the single StateInvariant (automatically created at the beginning; takes the whole width)
	 * <li>click at 1/3 on the just created second StateInvariant (that takes 3/4 of the width)
	 * <li>click at 1/2 on the just created second StateInvariant (that takes 1/2 of the width)
	 * <li>this results in three regularly spaced occurrence specifications
	 * <ul>
	 * 
	 */
	protected void createThreeOccurrenceSpecificationsInDefaultCompactLifeline() {
		createOccurrenceSpecificationInLastCompactStateInvariantWithRatio(1, 1.0 / 4.0);
		createOccurrenceSpecificationInLastCompactStateInvariantWithRatio(2, 1.0 / 3.0);
		createOccurrenceSpecificationInLastCompactStateInvariantWithRatio(3, 1.0 / 2.0);
	}

	/**
	 * Create an OccurrenceSpecification on the last StateInvariant in the timeline of the default Lifeline
	 * 
	 * @param expectedNumberOfStateInvariants
	 *        the number of state invariants that is expected (for checking)
	 * @param xPos
	 *        the position starting from the left of the StateInvariant
	 */
	protected void createOccurrenceSpecificationInLastFullStateInvariantAtAbsolutePos(final int expectedNumberOfStateInvariants, final int xPos) {
		// we need to wait for GMF to do its layout in order to have correct coordinates
		flushEventLoop();
		final FullStateInvariantEditPartCN lastStateInvariant = getAndAssertLastFullStateInvariant(expectedNumberOfStateInvariants);
		final Rectangle bounds = getAbsoluteBounds(lastStateInvariant);
		assertTrue("position out of bounds", xPos < bounds.width);
		sendOpenSelectionRequest(lastStateInvariant, new Point(bounds.x + xPos, bounds.y));
	}

	/**
	 * Create an OccurrenceSpecification on the last StateInvariant in the timeline of the default Lifeline
	 * 
	 * @param expectedNumberOfStateInvariants
	 *        the number of state invariants that is expected (for checking)
	 * @param xPos
	 *        the position starting from the left of the StateInvariant
	 */
	protected void createOccurrenceSpecificationInLastCompactStateInvariantAtAbsolutePos(final int expectedNumberOfStateInvariants, final int xPos) {
		// we need to wait for GMF to do its layout in order to have correct coordinates
		flushEventLoop();
		final CompactStateInvariantEditPartCN lastStateInvariant = getAndAssertLastCompactStateInvariant(expectedNumberOfStateInvariants);
		final Rectangle bounds = getAbsoluteBounds(lastStateInvariant);
		assertTrue("position out of bounds", xPos < bounds.width);
		sendOpenSelectionRequest(lastStateInvariant, new Point(bounds.x + xPos, bounds.y));
	}

	/**
	 * Create an OccurrenceSpecification on the last StateInvariant in the timeline of the default full Lifeline
	 * 
	 * @param expectedNumberOfStateInvariants
	 *        the number of state invariants that is expected (for checking)
	 * @param ratio
	 *        where to click in the StateInvariant (0.0 = beginning; 1.0 = end)
	 */
	protected void createOccurrenceSpecificationInLastFullStateInvariantWithRatio(final int expectedNumberOfStateInvariants, final double ratio) {
		assertTrue("invalid ratio", ratio >= 0.0 && ratio <= 1.0);
		// we need to wait for GMF to do its layout in order to have correct coordinates
		flushEventLoop();
		final FullStateInvariantEditPartCN lastStateInvariant = getAndAssertLastFullStateInvariant(expectedNumberOfStateInvariants);
		final Rectangle bounds = getAbsoluteBounds(lastStateInvariant);
		sendOpenSelectionRequest(lastStateInvariant, new Point(bounds.x + (int)(bounds.width * ratio), bounds.y));
	}

	/**
	 * Create an OccurrenceSpecification on the last StateInvariant in the timeline of the default compact Lifeline
	 * 
	 * @param expectedNumberOfStateInvariants
	 *        the number of state invariants that is expected (for checking)
	 * @param ratio
	 *        where to click in the StateInvariant (0.0 = beginning; 1.0 = end)
	 */
	protected void createOccurrenceSpecificationInLastCompactStateInvariantWithRatio(final int expectedNumberOfStateInvariants, final double ratio) {
		assertTrue("invalid ratio", ratio >= 0.0 && ratio <= 1.0);
		// we need to wait for GMF to do its layout in order to have correct coordinates
		flushEventLoop();
		final CompactStateInvariantEditPartCN lastStateInvariant = getAndAssertLastCompactStateInvariant(expectedNumberOfStateInvariants);
		final Rectangle bounds = getAbsoluteBounds(lastStateInvariant);
		sendOpenSelectionRequest(lastStateInvariant, new Point(bounds.x + (int)(bounds.width * ratio), bounds.y));
	}

	private FullStateInvariantEditPartCN getAndAssertLastFullStateInvariant(final int expectedNumberOfStateInvariants) {
		final List<FullStateInvariantEditPartCN> stateInvariants = findStateInvariantsInDefaultFullLifeline();
		assertEquals("Wrong number of StateInvariants", expectedNumberOfStateInvariants, stateInvariants.size());
		final FullStateInvariantEditPartCN lastStateInvariant = stateInvariants.get(expectedNumberOfStateInvariants - 1);
		return lastStateInvariant;
	}

	private CompactStateInvariantEditPartCN getAndAssertLastCompactStateInvariant(final int expectedNumberOfStateInvariants) {
		final List<CompactStateInvariantEditPartCN> stateInvariants = findStateInvariantsInDefaultCompactLifeline();
		assertEquals("Wrong number of StateInvariants", expectedNumberOfStateInvariants, stateInvariants.size());
		final CompactStateInvariantEditPartCN lastStateInvariant = stateInvariants.get(expectedNumberOfStateInvariants - 1);
		return lastStateInvariant;
	}

	/** @return all OccurrenceSpecification EditParts found in the default Lifeline */
	@SuppressWarnings("unchecked")
	protected List<OccurrenceSpecificationEditPartCN> findOccurrenceSpecificationsInDefaultFullLifeline() {
		return (List<OccurrenceSpecificationEditPartCN>)EditPartUtils.findChildEditPartsWithId(getDefaultFullLifelineEditPart(), OccurrenceSpecificationEditPartCN.VISUAL_ID);
	}

	/** @return all OccurrenceSpecification EditParts found in the default Lifeline */
	@SuppressWarnings("unchecked")
	protected List<OccurrenceSpecificationEditPartCN> findOccurrenceSpecificationsInDefaultCompactLifeline() {
		return (List<OccurrenceSpecificationEditPartCN>)EditPartUtils.findChildEditPartsWithId(getDefaultCompactLifelineEditPart(), OccurrenceSpecificationEditPartCN.VISUAL_ID);
	}

	/** @return all StateInvariant EditParts found in the default Lifeline */
	@SuppressWarnings("unchecked")
	protected List<FullStateInvariantEditPartCN> findStateInvariantsInDefaultFullLifeline() {
		return (List<FullStateInvariantEditPartCN>)EditPartUtils.findChildEditPartsWithId(getDefaultFullLifelineEditPart(), FullStateInvariantEditPartCN.VISUAL_ID);
	}

	/** @return all StateInvariant EditParts found in the default Lifeline */
	@SuppressWarnings("unchecked")
	protected List<CompactStateInvariantEditPartCN> findStateInvariantsInDefaultCompactLifeline() {
		return (List<CompactStateInvariantEditPartCN>)EditPartUtils.findChildEditPartsWithId(getDefaultCompactLifelineEditPart(), CompactStateInvariantEditPartCN.VISUAL_ID);
	}

	/** @return all StateDefinition EditParts found in the default Lifeline */
	@SuppressWarnings("unchecked")
	protected List<StateDefinitionEditPart> findStateDefinitions() {
		return (List<StateDefinitionEditPart>)EditPartUtils.findChildEditPartsWithId(getDefaultFullLifelineEditPart(), StateDefinitionEditPart.VISUAL_ID);
	}

	/**
	 * Check that the fragments in the default interaction are ordered following the given pattern.
	 * 
	 * @param pattern
	 *        the pattern, where "o" means OccurrenceSpecification, and "-" means StateInvariant
	 */
	protected void checkInteractionFragmentsWithPattern(final String expectedPattern) {
		final String fragmentsStringPattern = computeInteractionFragmentsStringPattern();
		assertEquals("The timeline does not follow the expected pattern", expectedPattern, fragmentsStringPattern);
	}

	protected String computeInteractionFragmentsStringPattern() {
		final StringBuilder pattern = new StringBuilder();
		final Interaction interaction = (Interaction)((View)getDefaultInteractionEditPart().getModel()).getElement();
		final EList<InteractionFragment> fragments = interaction.getFragments();
		for(final InteractionFragment fragment : fragments) {
			if(fragment instanceof StateInvariant) {
				pattern.append("-");
			} else if(fragment instanceof DestructionOccurrenceSpecification) {
				pattern.append("x");
			} else if(fragment instanceof MessageOccurrenceSpecification) {
				pattern.append("m");
			} else if(fragment instanceof OccurrenceSpecification) {
				pattern.append("o");
			}
		}
		return pattern.toString();
	}

	protected InteractionCompartmentEditPartTN getDefaultInteractionCompartment() {
		return this.interactionCompartment;
	}

	protected InteractionEditPartTN getDefaultInteractionEditPart() {
		return this.interactionEditPart;
	}

	protected FullLifelineEditPartCN getDefaultFullLifelineEditPart() {
		return this.fullLifelineEditPart;
	}

	protected FullLifelineStateDefinitionCompartmentEditPartCN getDefaultStateDefinitionCompartment() {
		return this.stateDefinitionCompartment;
	}

	protected FullLifelineTimelineCompartmentEditPartCN getDefaultFullLifelineTimelineCompartment() {
		return this.fullLifelineTimelineCompartment;
	}

	protected CompactLifelineEditPartCN getDefaultCompactLifelineEditPart() {
		return this.compactLifelineEditPart;
	}

	protected CompactLifelineCompartmentEditPartCN getDefaultCompactLifelineTimelineCompartment() {
		return this.compactLifelineTimelineCompartment;
	}

	/**
	 * Click in the middle of the given compact StateInvariant with the OccurrenceSpecification tool in order to create
	 * an OccurrenceSpecification over it.
	 * 
	 * @param compactStateInvariant
	 *        the StateInvariant on which to create an OccurrenceSpecification
	 * @param bottom
	 *        whether to click at the bottom of the StateInvariant, instead of at the top
	 */
	protected void createOccurrenceSpecificationOverCompactStateInvariant(final CompactStateInvariantEditPartCN compactStateInvariant, final boolean bottom) {
		final Rectangle bounds = getBounds(compactStateInvariant);
		final Point point = new Point(bounds.x + bounds.width / 2, bounds.y + (bottom ? bounds.height - 2 : 2));
		compactStateInvariant.getFigure().getParent().translateToAbsolute(point);
		clickTool("createOccurrenceSpecificationCreationTool", point);
	}

	protected void checkFullTimelinePattern(final String expectedPattern) {
		final String timelineStringPattern = computeFullTimelineStringPattern();
		assertEquals("The timeline does not follow the expected pattern", expectedPattern, timelineStringPattern);
	}

	protected String computeFullTimelineStringPattern() {
		flushEventLoop();
		final StringBuilder pattern = new StringBuilder();
		final FullLifelineTimelineCompartmentEditPartCN timelineCompartment = getDefaultFullLifelineTimelineCompartment();
		@SuppressWarnings("unchecked")
		final List<EditPart> children = timelineCompartment.getChildren();
		for(final EditPart editPart : children) {
			if(editPart instanceof FullStateInvariantEditPartCN) {
				outputFullStateInvariantPattern((FullStateInvariantEditPartCN)editPart, pattern);
			} else if(editPart instanceof OccurrenceSpecificationEditPartCN) {
				outputFullOccurrenceSpecificationPattern((OccurrenceSpecificationEditPartCN)editPart, pattern);
			} else if(editPart instanceof FullStateInvariantVerticalLineEditPart) {
				pattern.append("VerticalLine;");
			} else {
				fail("unexpected element");
			}
		}
		return pattern.toString();
	}

	private static void outputFullStateInvariantPattern(final FullStateInvariantEditPartCN editPart, final StringBuilder pattern) {
		final View view = (View)editPart.getModel();
		assertNotNull("The EditPart must have a View", view);
		final StateInvariant stateInvariant = (StateInvariant)view.getElement();
		assertNotNull("The View must have a semantic element", view);
		final Constraint constraint = stateInvariant.getInvariant();
		assertNotNull("The StateInvariant must have a Constraint", constraint);
		final ValueSpecification specification = constraint.getSpecification();
		assertNotNull("The Constraint must have a ValueSpecification", specification);
		assertTrue("The ValueSpecification must be an OpaqueExpression", specification instanceof OpaqueExpression);
		final OpaqueExpression opaqueExpression = (OpaqueExpression)specification;
		assertNotNull("The OpaqueExpression must not have a null list of bodies", opaqueExpression.getBodies());
		assertEquals("The OpaqueExpression must have one Body", 1, opaqueExpression.getBodies().size());
		pattern.append("StateInvariant(").append(opaqueExpression.getBodies().get(0)).append(");");
	}

	private static void outputFullOccurrenceSpecificationPattern(final OccurrenceSpecificationEditPartCN editPart, final StringBuilder pattern) {
		final View view = (View)editPart.getModel();
		assertNotNull("The EditPart must have a View", view);
		final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification)view.getElement();
		assertNotNull("The View must have a semantic element", occurrenceSpecification);
		final String name = occurrenceSpecification.getName();
		pattern.append("OccurrenceSpecification(").append(name).append(");");
	}

	protected void checkCompactTimelinePattern(final String expectedPattern) {
		final String timelineStringPattern = computeCompactTimelineStringPattern();
		assertEquals("The timeline does not follow the expected pattern", expectedPattern, timelineStringPattern);
	}

	protected String computeCompactTimelineStringPattern() {
		flushEventLoop();
		final StringBuilder pattern = new StringBuilder();
		final CompactLifelineCompartmentEditPartCN timelineCompartment = getDefaultCompactLifelineTimelineCompartment();
		@SuppressWarnings("unchecked")
		final List<EditPart> children = timelineCompartment.getChildren();
		for(final EditPart editPart : children) {
			if(editPart instanceof CompactStateInvariantEditPartCN) {
				outputCompactStateInvariantPattern((CompactStateInvariantEditPartCN)editPart, pattern);
			} else if(editPart instanceof OccurrenceSpecificationEditPartCN) {
				outputCompactOccurrenceSpecificationPattern((OccurrenceSpecificationEditPartCN)editPart, pattern);
			} else {
				fail("unexpected element");
			}
		}
		return pattern.toString();
	}

	private static void outputCompactStateInvariantPattern(final CompactStateInvariantEditPartCN editPart, final StringBuilder pattern) {
		final View view = (View)editPart.getModel();
		assertNotNull("The EditPart must have a View", view);
		final StateInvariant stateInvariant = (StateInvariant)view.getElement();
		assertNotNull("The View must have a semantic element", view);
		final Constraint constraint = stateInvariant.getInvariant();
		assertNotNull("The StateInvariant must have a Constraint", constraint);
		final ValueSpecification specification = constraint.getSpecification();
		assertNotNull("The Constraint must have a ValueSpecification", specification);
		assertTrue("The ValueSpecification must be an OpaqueExpression", specification instanceof OpaqueExpression);
		final OpaqueExpression opaqueExpression = (OpaqueExpression)specification;
		assertNotNull("The OpaqueExpression must not have a null list of bodies", opaqueExpression.getBodies());
		if(opaqueExpression.getBodies().isEmpty()) {
			pattern.append("StateInvariant(unnamed);");
		} else {
			pattern.append("StateInvariant(").append(opaqueExpression.getBodies().get(0)).append(");");
		}
	}

	private static void outputCompactOccurrenceSpecificationPattern(final OccurrenceSpecificationEditPartCN editPart, final StringBuilder pattern) {
		final View view = (View)editPart.getModel();
		assertNotNull("The EditPart must have a View", view);
		final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification)view.getElement();
		assertNotNull("The View must have a semantic element", occurrenceSpecification);
		final String name = occurrenceSpecification.getName();
		pattern.append("OccurrenceSpecification(").append(name).append(");");
	}

	protected void checkSimpleFullTimelinePattern(final String expectedPattern) {
		final String timelineStringPattern = computeSimpleFullTimelineStringPattern();
		assertEquals("The timeline does not follow the expected pattern", expectedPattern, timelineStringPattern);
	}

	protected String computeSimpleFullTimelineStringPattern() {
		flushEventLoop();
		final StringBuilder pattern = new StringBuilder();
		final FullLifelineTimelineCompartmentEditPartCN timelineCompartment = getDefaultFullLifelineTimelineCompartment();
		@SuppressWarnings("unchecked")
		final List<EditPart> children = timelineCompartment.getChildren();
		for(final EditPart editPart : children) {
			if(editPart instanceof FullStateInvariantEditPartCN) {
				pattern.append("-");
			} else if(editPart instanceof OccurrenceSpecificationEditPartCN) {
				pattern.append("o");
			} else if(editPart instanceof MessageOccurrenceSpecificationEditPartCN) {
				pattern.append("m");
			} else if(editPart instanceof DestructionOccurrenceSpecificationEditPartCN) {
				pattern.append("x");
			} else if(editPart instanceof FullStateInvariantVerticalLineEditPart) {
				pattern.append("|");
			} else {
				fail("unexpected element");
			}
		}
		return pattern.toString();
	}

	/**
	 * Check that the timeline contains the expected elements in the expected order.
	 * 
	 * @param expectedPattern
	 *        a pattern where
	 *        <ul>
	 *        <li>"o" represents an OccurrenceSpecification
	 *        <li>"-" represents a StateInvariant
	 *        </ul>
	 */
	protected void checkSimpleCompactTimelinePattern(final String expectedPattern) {
		final String timelineStringPattern = computeSimpleCompactTimelineStringPattern();
		assertEquals("The timeline does not follow the expected pattern", expectedPattern, timelineStringPattern);
	}

	protected String computeSimpleCompactTimelineStringPattern() {
		flushEventLoop();
		final StringBuilder pattern = new StringBuilder();
		final CompactLifelineCompartmentEditPartCN timelineCompartment = getDefaultCompactLifelineTimelineCompartment();
		@SuppressWarnings("unchecked")
		final List<EditPart> children = timelineCompartment.getChildren();
		for(final EditPart editPart : children) {
			if(editPart instanceof CompactStateInvariantEditPartCN) {
				pattern.append("-");
			} else if(editPart instanceof OccurrenceSpecificationEditPartCN) {
				pattern.append("o");
			} else if(editPart instanceof MessageOccurrenceSpecificationEditPartCN) {
				pattern.append("m");
			} else if(editPart instanceof DestructionOccurrenceSpecificationEditPartCN) {
				pattern.append("x");
			} else {
				fail("unexpected element");
			}
		}
		return pattern.toString();
	}

	/**
	 * Test that the modifications can all be undone and redone, and that the dirty state is consistent throughout the
	 * undo/redo operations.
	 * 
	 * @param nElementsToUndo
	 *        the number of elements that should be undoable before reaching the non-dirty state
	 */
	protected void testDirtyStateForFullUndoRedo(final int nElementsToUndo) {
		assertTrue("The editor should be dirty after all the modifications", this.diagramEditor.isDirty());
		for(int i = 0; i < nElementsToUndo; i++) {
			undoOnUIThread();
			// editor should be dirty for all states except the initial state
			if(i == nElementsToUndo - 1) {
				assertFalse("The editor should not be dirty after we undid all previous modifications", this.diagramEditor.isDirty());
			} else {
				assertTrue("The editor should be dirty until we undo all previous modifications", this.diagramEditor.isDirty());
			}
		}
		for(int i = 0; i < nElementsToUndo; i++) {
			redoOnUIThread();
			assertTrue("The editor should be dirty after we redo", this.diagramEditor.isDirty());
		}
	}
}
