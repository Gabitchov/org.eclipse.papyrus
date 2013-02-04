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
package org.eclipse.papyrus.uml.diagram.timing.custom;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.timing.custom.messages"; //$NON-NLS-1$

	public static String AbstractTimelineLayoutPolicy_MoveOccurrenceSpecification;

	public static String AbstractTimelineLayoutPolicy_UpdateLocationOfTimeElements;

	public static String AddOccurrenceSpecificationInCompactLifelineCommand_CreateOccurrenceSpecification;

	public static String ChangeLifelineFromCompactToFull_commandLabel;

	public static String ChangeLifelineFromFullToCompact_commandLabel;

	public static String CompactStateInvariantNameParser_SetStateInvariantName;

	public static String CompactStateInvariantNameParser_Unnamed;

	public static String CustomCompactLifelifeCompactStateInvariantCreationEditPolicy_CreateStateInvariant;

	public static String CustomCompactLifelifeCompactStateInvariantCreationEditPolicy_InitializeStateInvariant;

	public static String CustomCompactLifelineCompartmentLayoutEditPolicy_MoveElement;

	public static String CustomCompactLifelineCompartmentLayoutEditPolicy_MoveOccurrenceSpecification;

	public static String CustomCompactLifelineCompartmentLayoutEditPolicy_ResizeStateInvariant;

	public static String CustomCompactStateInvariantEditPartCN_CreateOccurrenceSpecification;

	public static String CustomFullLifelineStateDefinitionCompartmentCreationEditPolicy_CreateStateDefinition;

	public static String CustomFullLifelineStateDefinitionCompartmentCreationEditPolicy_InitializeStateDefinition;

	public static String CustomFullLifelineStateDefinitionCompartmentEditPartCN_AddStateDefinitionsHere;

	public static String CustomFullStateInvariantEditPartCN_CreateOccurrenceSpecification;

	public static String hideStateInvariant;

	public static String CustomInteractionCompartmentCreationEditPolicy_CreateCompactLifeline;

	public static String CustomInteractionCompartmentCreationEditPolicy_CreateFullLifeline;

	public static String CustomInteractionCreationEditPolicy_CreateGate;

	public static String CustomInteractionCreationEditPolicy_PositionGate;

	public static String CustomLifelineCompartmentGraphicalNodeEditPolicy_SetMessageFoundSourceLocation;

	public static String CustomLifelineCompartmentGraphicalNodeEditPolicy_SetMessageLostTargetLocation;

	public static String OccurrenceSpecificationUtils_DestroyOccurrenceSpecification;

	public static String OccurrenceSpecificationUtils_HideOccurrenceSpecification;

	public static String LifelineUtils_CreationOccurrence;

	public static String LifelineUtils_DestructionOccurrence;

	public static String LifelineUtils_UpdateFragmentNames;

	public static String LifelineUtils_UpdateLifelineFragmentNames;

	public static String CustomPaletteFactory_SetFoundMessageTarget;

	public static String CustomPaletteFactory_SetLostMessageOrigin;

	public static String CustomStateDefinitionEditPart_DeleteStateDefinition;

	public static String CustomTimelineCompartmentLayoutEditPolicy_MoveOccurrenceSpecification;

	public static String CustomTimelineCompartmentLayoutEditPolicy_MoveStateInvariant;

	public static String CustomTimelineCompartmentLayoutEditPolicy_MoveVerticalLine;

	public static String CustomTimelineCompartmentLayoutEditPolicy_UpdateStateInvariant;

	public static String CutAndInsertOccurrenceSpecificationCommand_CreateOccurrenceSpecification;

	public static String CutAndInsertOccurrenceSpecificationCompactLifelineCommand_CreateOccurrenceSpecification;

	public static String DeleteStateDefinitionCommand_DeleteStateDefinition;

	public static String DestructionOccurrenceSpecificationCreationTool_CreateDestructionOccurrenceSpecification;

	public static String DropUtils_DropElement;

	public static String DropUtils_DropGate;

	public static String DurationCreationTool_ClickEndElement;

	public static String DurationCreationTool_ClickStartElement;

	public static String ModelValidationUtils_CoveredByFragmentsWereReOrdered;

	public static String ModelValidationUtils_FragmentsFoundAfterDestructionOccurrenceSpecification;

	public static String ModelValidationUtils_FragmentsRemovedAfterDestructionOccurrenceSpecification;

	public static String ModelValidationUtils_MissingOccurrenceSpecificationAdded;

	public static String ModelValidationUtils_MissingOccurrenceSpecificationFound;

	public static String ModelValidationUtils_ModelValidation;

	public static String OccurrenceSpecificationCreationTool_CreateOccurrenceSpecification;

	public static String OccurrenceSpecificationHelperAdvice_DestroyOccurrenceSpecification;

	public static String OccurrenceSpecificationNameParser_SetOccurrenceSpecificationName;

	public static String StateDefinitionParser_SetStateDefinitionName;

	public static String StateDefinitionParser_Unnamed;

	public static String StateDefinitionUtils_State;

	public static String StateInvariantHelperAdvice_DestroyStateInvariant;

	public static String SwitchLifelineCommand_createLifelineFragments;

	public static String SwitchLifelineCommand_CreateLinkedElements;

	public static String SwitchLifelineCommand_CreateTimeRuler;

	public static String SwitchLifelineCommand_createMessages;

	public static String SwitchLifelineCommand_createStateDefinitions;

	public static String SwitchLifelineCommand_NameUnnamedStateInvariants;

	public static String SwitchLifelineCommand_ReAssociateTicks;

	public static String SwitchLifelineCommand_switchLifeline;

	public static String SwitchLifelineCommand_unnamed;

	public static String CreateTickCommand_attachTick;

	public static String CreateTickCommand_CreateTick;

	public static String ConstraintParser_SetConstraint;

	public static String GateHelperAdvice_DestroyGate;

	public static String GeneralOrderingCreationTool_ClickAfter;

	public static String GeneralOrderingCreationTool_ClickBefore;

	public static String TimingDiagramDragDropEditPolicy_Drop;

	public static String TimingDiagramDragDropEditPolicy_DropLifeline;

	public static String TimingDiagramDragDropEditPolicy_DropLifelineFragments;

	public static String TimingDiagramDragDropEditPolicy_DropMessage;

	public static String TimingDiagramDragDropEditPolicy_DropStateDefinitions;

	public static String ToggleTimeRulerVisibility_ToggleTimeRulerVisibility;

	public static String UmlTimingDiagramForMultiEditor_editorOpeningErrorMessage;

	public static String UmlTimingDiagramForMultiEditor_editorOpeningErrorTitle;

	public static String ValidateInteractionCommand_ValidateInteraction;

	public static String ViewUtils_MoveView;

	public static String CustomTimeRulerCreationEditPolicy_CreateFreeTimeRuler;

	public static String CustomTimingDiagramCreationEditPolicy_CreateInteraction;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
