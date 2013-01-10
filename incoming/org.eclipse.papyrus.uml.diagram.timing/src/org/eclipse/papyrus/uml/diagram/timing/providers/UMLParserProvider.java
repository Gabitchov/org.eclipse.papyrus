/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.timing.custom.parsers.ConstraintParser;
import org.eclipse.papyrus.uml.diagram.timing.custom.parsers.StateDefinitionParser;
import org.eclipse.papyrus.uml.diagram.timing.custom.parsers.TickParser;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationConstraintSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationObservationNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GeneralOrderingNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageAsyncAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageAsyncNameLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageCreateAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageCreateNameLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageDeleteAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageDeleteNameLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundNameLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostNameLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageReplyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageReplyNameLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageSyncAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageSyncNameLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateInvariantAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TickNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeObservationNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser interactionName_37Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionName_37Parser() {
		if(this.interactionName_37Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.interactionName_37Parser = parser;
		}
		return this.interactionName_37Parser;
	}

	/**
	 * @generated
	 */
	private IParser lifelineName_21Parser;

	/**
	 * @generated
	 */
	private IParser getLifelineName_21Parser() {
		if(this.lifelineName_21Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.lifelineName_21Parser = parser;
		}
		return this.lifelineName_21Parser;
	}

	/**
	 * @generated
	 */
	private IParser lifelineName_22Parser;

	/**
	 * @generated
	 */
	private IParser getLifelineName_22Parser() {
		if(this.lifelineName_22Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.lifelineName_22Parser = parser;
		}
		return this.lifelineName_22Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser stateInvariantName_62Parser;

	/**
	 * @generated
	 */
	private IParser getStateInvariantName_62Parser() {
		if(this.stateInvariantName_62Parser == null) {
			this.stateInvariantName_62Parser = new AppliedStereotypeParser();
		}
		return this.stateInvariantName_62Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateInvariantName_31Parser;

	/**
	 * @generated
	 */
	private IParser getStateInvariantName_31Parser() {
		if(this.stateInvariantName_31Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.stateInvariantName_31Parser = parser;
		}
		return this.stateInvariantName_31Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser stateInvariantName_64Parser;

	/**
	 * @generated
	 */
	private IParser getStateInvariantName_64Parser() {
		if(this.stateInvariantName_64Parser == null) {
			this.stateInvariantName_64Parser = new AppliedStereotypeParser();
		}
		return this.stateInvariantName_64Parser;
	}

	/**
	 * @generated
	 */
	private IParser occurrenceSpecificationName_10Parser;

	/**
	 * @generated
	 */
	private IParser getOccurrenceSpecificationName_10Parser() {
		if(this.occurrenceSpecificationName_10Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.occurrenceSpecificationName_10Parser = parser;
		}
		return this.occurrenceSpecificationName_10Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser occurrenceSpecificationName_58Parser;

	/**
	 * @generated
	 */
	private IParser getOccurrenceSpecificationName_58Parser() {
		if(this.occurrenceSpecificationName_58Parser == null) {
			this.occurrenceSpecificationName_58Parser = new AppliedStereotypeParser();
		}
		return this.occurrenceSpecificationName_58Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageOccurrenceSpecificationName_14Parser;

	/**
	 * @generated
	 */
	private IParser getMessageOccurrenceSpecificationName_14Parser() {
		if(this.messageOccurrenceSpecificationName_14Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.messageOccurrenceSpecificationName_14Parser = parser;
		}
		return this.messageOccurrenceSpecificationName_14Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageOccurrenceSpecificationName_59Parser;

	/**
	 * @generated
	 */
	private IParser getMessageOccurrenceSpecificationName_59Parser() {
		if(this.messageOccurrenceSpecificationName_59Parser == null) {
			this.messageOccurrenceSpecificationName_59Parser = new AppliedStereotypeParser();
		}
		return this.messageOccurrenceSpecificationName_59Parser;
	}

	/**
	 * @generated
	 */
	private StateDefinitionParser nodeLabel_38Parser;

	/**
	 * @generated
	 */
	private IParser getNodeLabel_38Parser() {
		if(this.nodeLabel_38Parser == null) {
			this.nodeLabel_38Parser = new StateDefinitionParser();
		}
		return this.nodeLabel_38Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser timeConstraintSpecification_30Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintSpecification_30Parser() {
		if(this.timeConstraintSpecification_30Parser == null) {
			this.timeConstraintSpecification_30Parser = new ConstraintParser();
		}
		return this.timeConstraintSpecification_30Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser timeConstraintName_65Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintName_65Parser() {
		if(this.timeConstraintName_65Parser == null) {
			this.timeConstraintName_65Parser = new AppliedStereotypeParser();
		}
		return this.timeConstraintName_65Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeObservationName_34Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationName_34Parser() {
		if(this.timeObservationName_34Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.timeObservationName_34Parser = parser;
		}
		return this.timeObservationName_34Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser timeObservationName_66Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationName_66Parser() {
		if(this.timeObservationName_66Parser == null) {
			this.timeObservationName_66Parser = new AppliedStereotypeParser();
		}
		return this.timeObservationName_66Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser durationConstraintSpecification_33Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintSpecification_33Parser() {
		if(this.durationConstraintSpecification_33Parser == null) {
			this.durationConstraintSpecification_33Parser = new ConstraintParser();
		}
		return this.durationConstraintSpecification_33Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationObservationName_35Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationName_35Parser() {
		if(this.durationObservationName_35Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.durationObservationName_35Parser = parser;
		}
		return this.durationObservationName_35Parser;
	}

	/**
	 * @generated
	 */
	private IParser generalOrderingName_68Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralOrderingName_68Parser() {
		if(this.generalOrderingName_68Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.generalOrderingName_68Parser = parser;
		}
		return this.generalOrderingName_68Parser;
	}

	/**
	 * @generated
	 */
	private TickParser nodeLabel_36Parser;

	/**
	 * @generated
	 */
	private IParser getNodeLabel_36Parser() {
		if(this.nodeLabel_36Parser == null) {
			this.nodeLabel_36Parser = new TickParser();
		}
		return this.nodeLabel_36Parser;
	}

	/**
	 * @generated
	 */
	private IParser destructionOccurrenceSpecificationName_32Parser;

	/**
	 * @generated
	 */
	private IParser getDestructionOccurrenceSpecificationName_32Parser() {
		if(this.destructionOccurrenceSpecificationName_32Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.destructionOccurrenceSpecificationName_32Parser = parser;
		}
		return this.destructionOccurrenceSpecificationName_32Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser destructionOccurrenceSpecificationName_63Parser;

	/**
	 * @generated
	 */
	private IParser getDestructionOccurrenceSpecificationName_63Parser() {
		if(this.destructionOccurrenceSpecificationName_63Parser == null) {
			this.destructionOccurrenceSpecificationName_63Parser = new AppliedStereotypeParser();
		}
		return this.destructionOccurrenceSpecificationName_63Parser;
	}

	/**
	 * @generated
	 */
	private IParser gateName_70Parser;

	/**
	 * @generated
	 */
	private IParser getGateName_70Parser() {
		if(this.gateName_70Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.gateName_70Parser = parser;
		}
		return this.gateName_70Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_56Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_56Parser() {
		if(this.messageName_56Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.messageName_56Parser = parser;
		}
		return this.messageName_56Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_57Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_57Parser() {
		if(this.messageLabel_57Parser == null) {
			this.messageLabel_57Parser = new AppliedStereotypeParser();
		}
		return this.messageLabel_57Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_60Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_60Parser() {
		if(this.messageName_60Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.messageName_60Parser = parser;
		}
		return this.messageName_60Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_61Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_61Parser() {
		if(this.messageLabel_61Parser == null) {
			this.messageLabel_61Parser = new AppliedStereotypeParser();
		}
		return this.messageLabel_61Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_42Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_42Parser() {
		if(this.messageName_42Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.messageName_42Parser = parser;
		}
		return this.messageName_42Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_43Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_43Parser() {
		if(this.messageLabel_43Parser == null) {
			this.messageLabel_43Parser = new AppliedStereotypeParser();
		}
		return this.messageLabel_43Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_45Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_45Parser() {
		if(this.messageName_45Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.messageName_45Parser = parser;
		}
		return this.messageName_45Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_46Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_46Parser() {
		if(this.messageLabel_46Parser == null) {
			this.messageLabel_46Parser = new AppliedStereotypeParser();
		}
		return this.messageLabel_46Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_48Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_48Parser() {
		if(this.messageName_48Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.messageName_48Parser = parser;
		}
		return this.messageName_48Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_49Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_49Parser() {
		if(this.messageLabel_49Parser == null) {
			this.messageLabel_49Parser = new AppliedStereotypeParser();
		}
		return this.messageLabel_49Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_51Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_51Parser() {
		if(this.messageName_51Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.messageName_51Parser = parser;
		}
		return this.messageName_51Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_52Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_52Parser() {
		if(this.messageLabel_52Parser == null) {
			this.messageLabel_52Parser = new AppliedStereotypeParser();
		}
		return this.messageLabel_52Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_54Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_54Parser() {
		if(this.messageName_54Parser == null) {
			final EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			final MessageFormatParser parser = new MessageFormatParser(features);
			this.messageName_54Parser = parser;
		}
		return this.messageName_54Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_55Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_55Parser() {
		if(this.messageLabel_55Parser == null) {
			this.messageLabel_55Parser = new AppliedStereotypeParser();
		}
		return this.messageLabel_55Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(final int visualID) {
		switch(visualID) {
		case InteractionNameEditPart.VISUAL_ID:
			return getInteractionName_37Parser();
		case FullLifelineNameEditPart.VISUAL_ID:
			return getLifelineName_21Parser();
		case CompactLifelineNameEditPart.VISUAL_ID:
			return getLifelineName_22Parser();
		case FullStateInvariantAppliedStereotypeEditPart.VISUAL_ID:
			return getStateInvariantName_62Parser();
		case CompactStateInvariantNameEditPart.VISUAL_ID:
			return getStateInvariantName_31Parser();
		case StateInvariantAppliedStereotypeEditPart.VISUAL_ID:
			return getStateInvariantName_64Parser();
		case OccurrenceSpecificationLabelEditPart.VISUAL_ID:
			return getOccurrenceSpecificationName_10Parser();
		case OccurrenceSpecificationAppliedStereotypeEditPart.VISUAL_ID:
			return getOccurrenceSpecificationName_58Parser();
		case MessageOccurrenceSpecificationLabelEditPart.VISUAL_ID:
			return getMessageOccurrenceSpecificationName_14Parser();
		case MessageOccurrenceSpecificationAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageOccurrenceSpecificationName_59Parser();
		case StateDefinitionLabelEditPart.VISUAL_ID:
			return getNodeLabel_38Parser();
		case TimeConstraintSpecificationEditPart.VISUAL_ID:
			return getTimeConstraintSpecification_30Parser();
		case TimeConstraintAppliedStereotypeEditPart.VISUAL_ID:
			return getTimeConstraintName_65Parser();
		case TimeObservationNameEditPart.VISUAL_ID:
			return getTimeObservationName_34Parser();
		case TimeObservationAppliedStereotypeEditPart.VISUAL_ID:
			return getTimeObservationName_66Parser();
		case DurationConstraintSpecificationEditPart.VISUAL_ID:
			return getDurationConstraintSpecification_33Parser();
		case DurationObservationNameEditPart.VISUAL_ID:
			return getDurationObservationName_35Parser();
		case GeneralOrderingNameEditPart.VISUAL_ID:
			return getGeneralOrderingName_68Parser();
		case TickNameEditPart.VISUAL_ID:
			return getNodeLabel_36Parser();
		case DestructionOccurrenceSpecificationLabelEditPart.VISUAL_ID:
			return getDestructionOccurrenceSpecificationName_32Parser();
		case DestructionOccurrenceSpecificationAppliedStereotypeEditPart.VISUAL_ID:
			return getDestructionOccurrenceSpecificationName_63Parser();
		case GateLabelEditPart.VISUAL_ID:
			return getGateName_70Parser();
		case MessageSyncNameLabelEditPart.VISUAL_ID:
			return getMessageName_56Parser();
		case MessageSyncAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_57Parser();
		case MessageAsyncNameLabelEditPart.VISUAL_ID:
			return getMessageName_60Parser();
		case MessageAsyncAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_61Parser();
		case MessageReplyNameLabelEditPart.VISUAL_ID:
			return getMessageName_42Parser();
		case MessageReplyAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_43Parser();
		case MessageCreateNameLabelEditPart.VISUAL_ID:
			return getMessageName_45Parser();
		case MessageCreateAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_46Parser();
		case MessageDeleteNameLabelEditPart.VISUAL_ID:
			return getMessageName_48Parser();
		case MessageDeleteAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_49Parser();
		case MessageLostNameLabelEditPart.VISUAL_ID:
			return getMessageName_51Parser();
		case MessageLostAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_52Parser();
		case MessageFoundNameLabelEditPart.VISUAL_ID:
			return getMessageName_54Parser();
		case MessageFoundAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_55Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * 
	 * @generated
	 */
	public static IParser getParser(final IElementType type, final EObject object, final String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(final IAdaptable hint) {
		final String vid = (String)hint.getAdapter(String.class);
		if(vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		final View view = (View)hint.getAdapter(View.class);
		if(view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(final IOperation operation) {
		if(operation instanceof GetParserOperation) {
			final IAdaptable hint = ((GetParserOperation)operation).getHint();
			if(UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(final IElementType type, final EObject object, final String parserHint) {
			super(object, parserHint);
			assert type != null;
			this.elementType = type;
		}

		/**
		 * @generated
		 */
		@Override
		public Object getAdapter(final Class adapter) {
			if(IElementType.class.equals(adapter)) {
				return this.elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
