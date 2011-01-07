package org.eclipse.papyrus.diagram.statemachine.providers;

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
import org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.diagram.statemachine.custom.parsers.TransitionPropertiesParser;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.GeneralizationStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateChoiceNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateChoiceStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateDeepHistoryNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateDeepHistoryStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEntryPointNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEntryPointStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateExitPointNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateExitPointStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateForkNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateForkStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateInitialNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateInitialStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJoinNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJoinStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJunctionNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJunctionStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateShallowHistoryNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateShallowHistoryStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateTerminateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateTerminateStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionGuardEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

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
	private IParser stateMachineName_2001Parser;

	/**
	 * @generated
	 */
	private IParser finalStateName_5001Parser;

	/**
	 * @generated
	 */
	private IParser stateName_6001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser finalStateName_5002Parser;

	/**
	 * @generated
	 */
	private IParser transitionName_7001Parser;

	/**
	 * @generated
	 */
	private TransitionPropertiesParser transitionGuard_7002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_8001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_8002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_9001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_9002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_10001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_10002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_11001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_11002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_12001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_12002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_13001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_13002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_14001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_14002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_15001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_15002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_16001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_16002Parser;

	/**
	 * @generated
	 */
	private IParser pseudostateName_17001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_17002Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser transitionName_7003Parser;

	/**
	 * @generated
	 */
	private IParser connectionPointReferenceName_18001Parser;

	/**
	 * @generated
	 */
	private AppliedStereotypeParser connectionPointReferenceName_18002Parser;

	/**
	 * @generated
	 */
	private IParser generalizationIsSubstitutable_19002Parser;

	/**
	 * @generated
	 */
	private IParser getConnectionPointReferenceName_18001Parser() {
		if(connectionPointReferenceName_18001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			connectionPointReferenceName_18001Parser = parser;
		}
		return connectionPointReferenceName_18001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getConnectionPointReferenceName_18002Parser() {
		if(connectionPointReferenceName_18002Parser == null) {
			connectionPointReferenceName_18002Parser = new AppliedStereotypeParser();
		}
		return connectionPointReferenceName_18002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getFinalStateName_5001Parser() {
		if(finalStateName_5001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			finalStateName_5001Parser = parser;
		}
		return finalStateName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getFinalStateName_5002Parser() {
		if(finalStateName_5002Parser == null) {
			finalStateName_5002Parser = new AppliedStereotypeParser();
		}
		return finalStateName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getGeneralizationIsSubstitutable_19002Parser() {
		if(generalizationIsSubstitutable_19002Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getGeneralization_IsSubstitutable() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditorPattern("<<{0}>>"); //$NON-NLS-1$
			parser.setEditPattern("<<{0}>>"); //$NON-NLS-1$
			generalizationIsSubstitutable_19002Parser = parser;
		}
		return generalizationIsSubstitutable_19002Parser;
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
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case StateMachineNameEditPart.VISUAL_ID:
			return getStateMachineName_2001Parser();
		case FinalStateNameEditPart.VISUAL_ID:
			return getFinalStateName_5001Parser();
		case FinalStateStereotypeEditPart.VISUAL_ID:
			return getFinalStateName_5002Parser();
		case StateNameEditPart.VISUAL_ID:
			return getStateName_6001Parser();
		case PseudostateInitialNameEditPart.VISUAL_ID:
			return getPseudostateName_8001Parser();
		case PseudostateInitialStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_8002Parser();
		case PseudostateJoinNameEditPart.VISUAL_ID:
			return getPseudostateName_9001Parser();
		case PseudostateJoinStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_9002Parser();
		case PseudostateForkNameEditPart.VISUAL_ID:
			return getPseudostateName_10001Parser();
		case PseudostateForkStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_10002Parser();
		case PseudostateChoiceNameEditPart.VISUAL_ID:
			return getPseudostateName_11001Parser();
		case PseudostateChoiceStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_11002Parser();
		case PseudostateJunctionNameEditPart.VISUAL_ID:
			return getPseudostateName_12001Parser();
		case PseudostateJunctionStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_12002Parser();
		case PseudostateShallowHistoryNameEditPart.VISUAL_ID:
			return getPseudostateName_13001Parser();
		case PseudostateShallowHistoryStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_13002Parser();
		case PseudostateDeepHistoryNameEditPart.VISUAL_ID:
			return getPseudostateName_14001Parser();
		case PseudostateDeepHistoryStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_14002Parser();
		case PseudostateTerminateNameEditPart.VISUAL_ID:
			return getPseudostateName_15001Parser();
		case PseudostateTerminateStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_15002Parser();
		case PseudostateEntryPointNameEditPart.VISUAL_ID:
			return getPseudostateName_16001Parser();
		case PseudostateEntryPointStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_16002Parser();
		case PseudostateExitPointNameEditPart.VISUAL_ID:
			return getPseudostateName_17001Parser();
		case PseudostateExitPointStereotypeEditPart.VISUAL_ID:
			return getPseudostateName_17002Parser();
		case ConnectionPointReferenceNameEditPart.VISUAL_ID:
			return getConnectionPointReferenceName_18001Parser();
		case ConnectionPointReferenceStereotypeEditPart.VISUAL_ID:
			return getConnectionPointReferenceName_18002Parser();
		case TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_7001Parser();
		case TransitionGuardEditPart.VISUAL_ID:
			return getTransitionGuard_7002Parser();
		case TransitionStereotypeEditPart.VISUAL_ID:
			return getTransitionName_7003Parser();
		case GeneralizationStereotypeEditPart.VISUAL_ID:
			return getGeneralizationIsSubstitutable_19002Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_10001Parser() {
		if(pseudostateName_10001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_10001Parser = parser;
		}
		return pseudostateName_10001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_10002Parser() {
		if(pseudostateName_10002Parser == null) {
			pseudostateName_10002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_10002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_11001Parser() {
		if(pseudostateName_11001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_11001Parser = parser;
		}
		return pseudostateName_11001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_11002Parser() {
		if(pseudostateName_11002Parser == null) {
			pseudostateName_11002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_11002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_12001Parser() {
		if(pseudostateName_12001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_12001Parser = parser;
		}
		return pseudostateName_12001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_12002Parser() {
		if(pseudostateName_12002Parser == null) {
			pseudostateName_12002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_12002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_13001Parser() {
		if(pseudostateName_13001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_13001Parser = parser;
		}
		return pseudostateName_13001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_13002Parser() {
		if(pseudostateName_13002Parser == null) {
			pseudostateName_13002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_13002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_14001Parser() {
		if(pseudostateName_14001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_14001Parser = parser;
		}
		return pseudostateName_14001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_14002Parser() {
		if(pseudostateName_14002Parser == null) {
			pseudostateName_14002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_14002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_15001Parser() {
		if(pseudostateName_15001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_15001Parser = parser;
		}
		return pseudostateName_15001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_15002Parser() {
		if(pseudostateName_15002Parser == null) {
			pseudostateName_15002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_15002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_16001Parser() {
		if(pseudostateName_16001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_16001Parser = parser;
		}
		return pseudostateName_16001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_16002Parser() {
		if(pseudostateName_16002Parser == null) {
			pseudostateName_16002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_16002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_17001Parser() {
		if(pseudostateName_17001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_17001Parser = parser;
		}
		return pseudostateName_17001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_17002Parser() {
		if(pseudostateName_17002Parser == null) {
			pseudostateName_17002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_17002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_8001Parser() {
		if(pseudostateName_8001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_8001Parser = parser;
		}
		return pseudostateName_8001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_8002Parser() {
		if(pseudostateName_8002Parser == null) {
			pseudostateName_8002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_8002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_9001Parser() {
		if(pseudostateName_9001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_9001Parser = parser;
		}
		return pseudostateName_9001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getPseudostateName_9002Parser() {
		if(pseudostateName_9002Parser == null) {
			pseudostateName_9002Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_9002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getStateMachineName_2001Parser() {
		if(stateMachineName_2001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateMachineName_2001Parser = parser;
		}
		return stateMachineName_2001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getStateName_6001Parser() {
		if(stateName_6001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateName_6001Parser = parser;
		}
		return stateName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getTransitionGuard_7002Parser() {
		if(transitionGuard_7002Parser == null) {
			transitionGuard_7002Parser = new TransitionPropertiesParser();
		}
		return transitionGuard_7002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getTransitionName_7001Parser() {
		if(transitionName_7001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			transitionName_7001Parser = parser;
		}
		return transitionName_7001Parser;
	}

	/**
	 * @generated
	 */
	private IParser getTransitionName_7003Parser() {
		if(transitionName_7003Parser == null) {
			transitionName_7003Parser = new AppliedStereotypeParser();
		}
		return transitionName_7003Parser;
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

}
