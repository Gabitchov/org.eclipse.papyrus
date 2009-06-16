package org.eclipse.papyrus.diagram.statemachine.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.parser.custom.OnlyStereotypesNamesParser;
import org.eclipse.papyrus.diagram.common.parser.custom.SubmachineStateSubmachineNameParser;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateName7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateName8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionName2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.parser.TransitionParser;
import org.eclipse.papyrus.diagram.statemachine.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser stateMachineName_4017Parser;

	/**
	 * @generated
	 */
	private IParser getStateMachineName_4017Parser() {
		if (stateMachineName_4017Parser == null) {
			stateMachineName_4017Parser = createStateMachineName_4017Parser();
		}
		return stateMachineName_4017Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateMachineName_4017Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateMachineName_4018Parser;

	/**
	 * @generated
	 */
	private IParser getStateMachineName_4018Parser() {
		if (stateMachineName_4018Parser == null) {
			stateMachineName_4018Parser = createStateMachineName_4018Parser();
		}
		return stateMachineName_4018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateMachineName_4018Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser commentBody_5003Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5003Parser() {
		if (commentBody_5003Parser == null) {
			commentBody_5003Parser = createCommentBody_5003Parser();
		}
		return commentBody_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCommentBody_5003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getComment_Body(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4001Parser() {
		if (stateName_4001Parser == null) {
			stateName_4001Parser = createStateName_4001Parser();
		}
		return stateName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4001Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4002Parser() {
		if (stateName_4002Parser == null) {
			stateName_4002Parser = createStateName_4002Parser();
		}
		return stateName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4002Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser stateName_4013Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4013Parser() {
		if (stateName_4013Parser == null) {
			stateName_4013Parser = createStateName_4013Parser();
		}
		return stateName_4013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4013Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_4014Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4014Parser() {
		if (stateName_4014Parser == null) {
			stateName_4014Parser = createStateName_4014Parser();
		}
		return stateName_4014Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4014Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser stateName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4005Parser() {
		if (stateName_4005Parser == null) {
			stateName_4005Parser = createStateName_4005Parser();
		}
		return stateName_4005Parser;
	}

	/**
	 * @generated NOT
	 */
	protected IParser createStateName_4005Parser() {
		//		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
		//				.getNamedElement_Name(), };
		//
		//		MessageFormatParser parser = new MessageFormatParser(features);
		//		return parser;
		return new SubmachineStateSubmachineNameParser();
	}

	/**
	 * @generated
	 */
	private IParser stateName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4006Parser() {
		if (stateName_4006Parser == null) {
			stateName_4006Parser = createStateName_4006Parser();
		}
		return stateName_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4006Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser connectionPointReferenceName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getConnectionPointReferenceName_4003Parser() {
		if (connectionPointReferenceName_4003Parser == null) {
			connectionPointReferenceName_4003Parser = createConnectionPointReferenceName_4003Parser();
		}
		return connectionPointReferenceName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createConnectionPointReferenceName_4003Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser connectionPointReferenceName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getConnectionPointReferenceName_4004Parser() {
		if (connectionPointReferenceName_4004Parser == null) {
			connectionPointReferenceName_4004Parser = createConnectionPointReferenceName_4004Parser();
		}
		return connectionPointReferenceName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createConnectionPointReferenceName_4004Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser pseudostateName_4021Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4021Parser() {
		if (pseudostateName_4021Parser == null) {
			pseudostateName_4021Parser = createPseudostateName_4021Parser();
		}
		return pseudostateName_4021Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPseudostateName_4021Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4009Parser() {
		if (stateName_4009Parser == null) {
			stateName_4009Parser = createStateName_4009Parser();
		}
		return stateName_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4009Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_4010Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4010Parser() {
		if (stateName_4010Parser == null) {
			stateName_4010Parser = createStateName_4010Parser();
		}
		return stateName_4010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4010Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	private IParser pseudostateName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4007Parser() {
		if (pseudostateName_4007Parser == null) {
			pseudostateName_4007Parser = createPseudostateName_4007Parser();
		}
		return pseudostateName_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPseudostateName_4007Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser pseudostateName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4008Parser() {
		if (pseudostateName_4008Parser == null) {
			pseudostateName_4008Parser = createPseudostateName_4008Parser();
		}
		return pseudostateName_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPseudostateName_4008Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser pseudostateName_4011Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4011Parser() {
		if (pseudostateName_4011Parser == null) {
			pseudostateName_4011Parser = createPseudostateName_4011Parser();
		}
		return pseudostateName_4011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPseudostateName_4011Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser pseudostateName_4012Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4012Parser() {
		if (pseudostateName_4012Parser == null) {
			pseudostateName_4012Parser = createPseudostateName_4012Parser();
		}
		return pseudostateName_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPseudostateName_4012Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser pseudostateName_4015Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4015Parser() {
		if (pseudostateName_4015Parser == null) {
			pseudostateName_4015Parser = createPseudostateName_4015Parser();
		}
		return pseudostateName_4015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPseudostateName_4015Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser pseudostateName_4016Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4016Parser() {
		if (pseudostateName_4016Parser == null) {
			pseudostateName_4016Parser = createPseudostateName_4016Parser();
		}
		return pseudostateName_4016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPseudostateName_4016Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };

		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_4019Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_4019Parser() {
		if (transitionName_4019Parser == null) {
			transitionName_4019Parser = createTransitionName_4019Parser();
		}
		return transitionName_4019Parser;
	}

	/**
	 * @generated NOT
	 * 
	 * modified to return a special parser that shows the transition guard
	 */
	protected IParser createTransitionName_4019Parser() {
		return new TransitionParser();
	}

	/**
	 * @generated
	 */
	private IParser transitionName_4020Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_4020Parser() {
		if (transitionName_4020Parser == null) {
			transitionName_4020Parser = createTransitionName_4020Parser();
		}
		return transitionName_4020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTransitionName_4020Parser() {
		EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
				.getNamedElement_Name(), };
		return new OnlyStereotypesNamesParser();

	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case StateMachineNameEditPart.VISUAL_ID:
			return getStateMachineName_4017Parser();
		case StateMachineName2EditPart.VISUAL_ID:
			return getStateMachineName_4018Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5003Parser();
		case StateNameEditPart.VISUAL_ID:
			return getStateName_4001Parser();
		case StateName2EditPart.VISUAL_ID:
			return getStateName_4002Parser();
		case StateName3EditPart.VISUAL_ID:
			return getStateName_4013Parser();
		case StateName4EditPart.VISUAL_ID:
			return getStateName_4014Parser();
		case StateName5EditPart.VISUAL_ID:
			return getStateName_4005Parser();
		case StateName6EditPart.VISUAL_ID:
			return getStateName_4006Parser();
		case ConnectionPointReferenceNameEditPart.VISUAL_ID:
			return getConnectionPointReferenceName_4003Parser();
		case ConnectionPointReferenceName2EditPart.VISUAL_ID:
			return getConnectionPointReferenceName_4004Parser();
		case PseudostateName7EditPart.VISUAL_ID:
			return getPseudostateName_4021Parser();
		case StateName7EditPart.VISUAL_ID:
			return getStateName_4009Parser();
		case StateName8EditPart.VISUAL_ID:
			return getStateName_4010Parser();
		case PseudostateNameEditPart.VISUAL_ID:
			return getPseudostateName_4007Parser();
		case PseudostateName2EditPart.VISUAL_ID:
			return getPseudostateName_4008Parser();
		case PseudostateName3EditPart.VISUAL_ID:
			return getPseudostateName_4011Parser();
		case PseudostateName4EditPart.VISUAL_ID:
			return getPseudostateName_4012Parser();
		case PseudostateName5EditPart.VISUAL_ID:
			return getPseudostateName_4015Parser();
		case PseudostateName6EditPart.VISUAL_ID:
			return getPseudostateName_4016Parser();
		case TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_4019Parser();
		case TransitionName2EditPart.VISUAL_ID:
			return getTransitionName_4020Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		private final IElementType elementType;

		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		@Override
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
