/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

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
import org.eclipse.papyrus.uml.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseName2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.parser.custom.DurationObservationParser;
import org.eclipse.papyrus.uml.diagram.sequence.parser.custom.InteractionUseCustomParsers;
import org.eclipse.papyrus.uml.diagram.sequence.parser.custom.LifelineCustomParsers;
import org.eclipse.papyrus.uml.diagram.sequence.parser.custom.MessageCustomParser;
import org.eclipse.papyrus.uml.diagram.sequence.parser.custom.TimeConstraintParser;
import org.eclipse.papyrus.uml.diagram.sequence.parser.custom.TimeObservationParser;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser interactionName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionName_5001Parser() {
		if(interactionName_5001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("sd: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interactionName_5001Parser = parser;
		}
		return interactionName_5001Parser;
	}

	/**
	 * @generated
	 */
	private LifelineCustomParsers lifelineName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getLifelineName_5002Parser() {
		if(lifelineName_5002Parser == null) {
			lifelineName_5002Parser = new LifelineCustomParsers();
		}
		return lifelineName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateInvariantName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getStateInvariantName_5008Parser() {
		if(stateInvariantName_5008Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateInvariantName_5008Parser = parser;
		}
		return stateInvariantName_5008Parser;
	}

	/**
	 * @generated
	 */
	private TimeConstraintParser timeConstraintLabel_5009Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintLabel_5009Parser() {
		if(timeConstraintLabel_5009Parser == null) {
			timeConstraintLabel_5009Parser = new TimeConstraintParser();
		}
		return timeConstraintLabel_5009Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser timeConstraintLabel_5013Parser;

	/**
	 * @generated
	 */
	private IParser getTimeConstraintLabel_5013Parser() {
		if(timeConstraintLabel_5013Parser == null) {
			timeConstraintLabel_5013Parser = new AppliedStereotypeParser();
		}
		return timeConstraintLabel_5013Parser;
	}

	/**
	 * @generated
	 */
	private TimeObservationParser timeObservationLabel_5010Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationLabel_5010Parser() {
		if(timeObservationLabel_5010Parser == null) {
			timeObservationLabel_5010Parser = new TimeObservationParser();
		}
		return timeObservationLabel_5010Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser timeObservationLabel_5014Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationLabel_5014Parser() {
		if(timeObservationLabel_5014Parser == null) {
			timeObservationLabel_5014Parser = new AppliedStereotypeParser();
		}
		return timeObservationLabel_5014Parser;
	}

	/**
	 * @generated
	 */
	private TimeConstraintParser durationConstraintLabel_5011Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintLabel_5011Parser() {
		if(durationConstraintLabel_5011Parser == null) {
			durationConstraintLabel_5011Parser = new TimeConstraintParser();
		}
		return durationConstraintLabel_5011Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser durationConstraintLabel_5015Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintLabel_5015Parser() {
		if(durationConstraintLabel_5015Parser == null) {
			durationConstraintLabel_5015Parser = new AppliedStereotypeParser();
		}
		return durationConstraintLabel_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser interactionUseName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionUseName_5003Parser() {
		if(interactionUseName_5003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("Ref"); //$NON-NLS-1$
			parser.setEditorPattern("Ref"); //$NON-NLS-1$
			parser.setEditPattern("Ref"); //$NON-NLS-1$
			interactionUseName_5003Parser = parser;
		}
		return interactionUseName_5003Parser;
	}

	/**
	 * @generated
	 */
	private InteractionUseCustomParsers interactionUseName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionUseName_5004Parser() {
		if(interactionUseName_5004Parser == null) {
			interactionUseName_5004Parser = new InteractionUseCustomParsers();
		}
		return interactionUseName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser continuationName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getContinuationName_5007Parser() {
		if(continuationName_5007Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			continuationName_5007Parser = parser;
		}
		return continuationName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5005Parser() {
		if(constraintName_5005Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5005Parser = parser;
		}
		return constraintName_5005Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintLabel_5012Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintLabel_5012Parser() {
		if(constraintLabel_5012Parser == null) {
			constraintLabel_5012Parser = new ConstraintParser();
		}
		return constraintLabel_5012Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5006Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5006Parser() {
		if(commentBody_5006Parser == null) {
			commentBody_5006Parser = new CommentParser();
		}
		return commentBody_5006Parser;
	}

	/**
	 * @generated
	 */
	private TimeConstraintParser durationConstraintLabel_5018Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintLabel_5018Parser() {
		if(durationConstraintLabel_5018Parser == null) {
			durationConstraintLabel_5018Parser = new TimeConstraintParser();
		}
		return durationConstraintLabel_5018Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser durationConstraintLabel_5019Parser;

	/**
	 * @generated
	 */
	private IParser getDurationConstraintLabel_5019Parser() {
		if(durationConstraintLabel_5019Parser == null) {
			durationConstraintLabel_5019Parser = new AppliedStereotypeParser();
		}
		return durationConstraintLabel_5019Parser;
	}

	/**
	 * @generated
	 */
	private DurationObservationParser durationObservationLabel_5016Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationLabel_5016Parser() {
		if(durationObservationLabel_5016Parser == null) {
			durationObservationLabel_5016Parser = new DurationObservationParser();
		}
		return durationObservationLabel_5016Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser durationObservationLabel_5017Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationLabel_5017Parser() {
		if(durationObservationLabel_5017Parser == null) {
			durationObservationLabel_5017Parser = new AppliedStereotypeParser();
		}
		return durationObservationLabel_5017Parser;
	}

	/**
	 * @generated
	 */
	private MessageCustomParser messageName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6001Parser() {
		if(messageName_6001Parser == null) {
			messageName_6001Parser = new MessageCustomParser();
		}
		return messageName_6001Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_6008Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_6008Parser() {
		if(messageLabel_6008Parser == null) {
			messageLabel_6008Parser = new AppliedStereotypeParser();
		}
		return messageLabel_6008Parser;
	}

	/**
	 * @generated
	 */
	private MessageCustomParser messageName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6002Parser() {
		if(messageName_6002Parser == null) {
			messageName_6002Parser = new MessageCustomParser();
		}
		return messageName_6002Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_6009Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_6009Parser() {
		if(messageLabel_6009Parser == null) {
			messageLabel_6009Parser = new AppliedStereotypeParser();
		}
		return messageLabel_6009Parser;
	}

	/**
	 * @generated
	 */
	private MessageCustomParser messageName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6003Parser() {
		if(messageName_6003Parser == null) {
			messageName_6003Parser = new MessageCustomParser();
		}
		return messageName_6003Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_6010Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_6010Parser() {
		if(messageLabel_6010Parser == null) {
			messageLabel_6010Parser = new AppliedStereotypeParser();
		}
		return messageLabel_6010Parser;
	}

	/**
	 * @generated
	 */
	private MessageCustomParser messageName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6004Parser() {
		if(messageName_6004Parser == null) {
			messageName_6004Parser = new MessageCustomParser();
		}
		return messageName_6004Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_6011Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_6011Parser() {
		if(messageLabel_6011Parser == null) {
			messageLabel_6011Parser = new AppliedStereotypeParser();
		}
		return messageLabel_6011Parser;
	}

	/**
	 * @generated
	 */
	private MessageCustomParser messageName_6005Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6005Parser() {
		if(messageName_6005Parser == null) {
			messageName_6005Parser = new MessageCustomParser();
		}
		return messageName_6005Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_6012Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_6012Parser() {
		if(messageLabel_6012Parser == null) {
			messageLabel_6012Parser = new AppliedStereotypeParser();
		}
		return messageLabel_6012Parser;
	}

	/**
	 * @generated
	 */
	private MessageCustomParser messageName_6006Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6006Parser() {
		if(messageName_6006Parser == null) {
			messageName_6006Parser = new MessageCustomParser();
		}
		return messageName_6006Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_6013Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_6013Parser() {
		if(messageLabel_6013Parser == null) {
			messageLabel_6013Parser = new AppliedStereotypeParser();
		}
		return messageLabel_6013Parser;
	}

	/**
	 * @generated
	 */
	private MessageCustomParser messageName_6007Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6007Parser() {
		if(messageName_6007Parser == null) {
			messageName_6007Parser = new MessageCustomParser();
		}
		return messageName_6007Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser messageLabel_6014Parser;

	/**
	 * @generated
	 */
	private IParser getMessageLabel_6014Parser() {
		if(messageLabel_6014Parser == null) {
			messageLabel_6014Parser = new AppliedStereotypeParser();
		}
		return messageLabel_6014Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser generalOrderingLabel_6015Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralOrderingLabel_6015Parser() {
		if(generalOrderingLabel_6015Parser == null) {
			generalOrderingLabel_6015Parser = new AppliedStereotypeParser();
		}
		return generalOrderingLabel_6015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case InteractionNameEditPart.VISUAL_ID:
			return getInteractionName_5001Parser();
		case InteractionUseNameEditPart.VISUAL_ID:
			return getInteractionUseName_5003Parser();
		case InteractionUseName2EditPart.VISUAL_ID:
			return getInteractionUseName_5004Parser();
		case ContinuationNameEditPart.VISUAL_ID:
			return getContinuationName_5007Parser();
		case LifelineNameEditPart.VISUAL_ID:
			return getLifelineName_5002Parser();
		case StateInvariantNameEditPart.VISUAL_ID:
			return getStateInvariantName_5008Parser();
		case TimeConstraintLabelEditPart.VISUAL_ID:
			return getTimeConstraintLabel_5009Parser();
		case TimeConstraintAppliedStereotypeEditPart.VISUAL_ID:
			return getTimeConstraintLabel_5013Parser();
		case TimeObservationLabelEditPart.VISUAL_ID:
			return getTimeObservationLabel_5010Parser();
		case TimeObservationAppliedStereotypeEditPart.VISUAL_ID:
			return getTimeObservationLabel_5014Parser();
		case DurationConstraintLabelEditPart.VISUAL_ID:
			return getDurationConstraintLabel_5011Parser();
		case DurationConstraintAppliedStereotypeEditPart.VISUAL_ID:
			return getDurationConstraintLabel_5015Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5005Parser();
		case Constraint2EditPart.VISUAL_ID:
			return getConstraintLabel_5012Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5006Parser();
		case DurationConstraintInMessageLabelEditPart.VISUAL_ID:
			return getDurationConstraintLabel_5018Parser();
		case DurationConstraintInMessageAppliedStereotypeEditPart.VISUAL_ID:
			return getDurationConstraintLabel_5019Parser();
		case DurationObservationLabelEditPart.VISUAL_ID:
			return getDurationObservationLabel_5016Parser();
		case DurationObservationAppliedStereotypeEditPart.VISUAL_ID:
			return getDurationObservationLabel_5017Parser();
		case MessageNameEditPart.VISUAL_ID:
			return getMessageName_6001Parser();
		case MessageSyncAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_6008Parser();
		case MessageName2EditPart.VISUAL_ID:
			return getMessageName_6002Parser();
		case MessageAsyncAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_6009Parser();
		case MessageName3EditPart.VISUAL_ID:
			return getMessageName_6003Parser();
		case MessageReplyAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_6010Parser();
		case MessageName4EditPart.VISUAL_ID:
			return getMessageName_6004Parser();
		case MessageCreateAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_6011Parser();
		case MessageName5EditPart.VISUAL_ID:
			return getMessageName_6005Parser();
		case MessageDeleteAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_6012Parser();
		case MessageName6EditPart.VISUAL_ID:
			return getMessageName_6006Parser();
		case MessageLostAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_6013Parser();
		case MessageName7EditPart.VISUAL_ID:
			return getMessageName_6007Parser();
		case MessageFoundAppliedStereotypeEditPart.VISUAL_ID:
			return getMessageLabel_6014Parser();
		case GeneralOrderingAppliedStereotypeEditPart.VISUAL_ID:
			return getGeneralOrderingLabel_6015Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * 
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String)hint.getAdapter(String.class);
		if(vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View)hint.getAdapter(View.class);
		if(view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation)operation).getHint();
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
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if(IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
