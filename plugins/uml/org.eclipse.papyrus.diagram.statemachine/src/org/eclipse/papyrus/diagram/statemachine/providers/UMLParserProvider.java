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
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateNameLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeStereotypeLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionGuardLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionNameLabelEditPart;
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
	private IParser stateMachineName_2001Parser;

	/**
	 * @generated
	 */
	private IParser getStateMachineName_2001Parser() {
		if (stateMachineName_2001Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateMachineName_2001Parser = parser;
		}
		return stateMachineName_2001Parser;
	}

	/**
	 * @generated
	 */
	private IParser pseudostateName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4002Parser() {
		if (pseudostateName_4002Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pseudostateName_4002Parser = parser;
		}
		return pseudostateName_4002Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser pseudostateName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getPseudostateName_4003Parser() {
		if (pseudostateName_4003Parser == null) {
			pseudostateName_4003Parser = new AppliedStereotypeParser();
		}
		return pseudostateName_4003Parser;
	}

	/**
	 * @generated
	 */
	private IParser finalStateName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getFinalStateName_4005Parser() {
		if (finalStateName_4005Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			finalStateName_4005Parser = parser;
		}
		return finalStateName_4005Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4004Parser() {
		if (stateName_4004Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateName_4004Parser = parser;
		}
		return stateName_4004Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_6000Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_6000Parser() {
		if (transitionName_6000Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			transitionName_6000Parser = parser;
		}
		return transitionName_6000Parser;
	}

	/**
	 * @generated
	 */
	private TransitionPropertiesParser transitionGuard_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionGuard_6001Parser() {
		if (transitionGuard_6001Parser == null) {
			transitionGuard_6001Parser = new TransitionPropertiesParser();
		}
		return transitionGuard_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case StateMachineNameEditPart.VISUAL_ID:
			return getStateMachineName_2001Parser();
		case PseudoStateNodeLabelEditPart.VISUAL_ID:
			return getPseudostateName_4002Parser();
		case PseudoStateNodeStereotypeLabelEditPart.VISUAL_ID:
			return getPseudostateName_4003Parser();
		case FinalStateNameLabelEditPart.VISUAL_ID:
			return getFinalStateName_4005Parser();
		case StateNameLabelEditPart.VISUAL_ID:
			return getStateName_4004Parser();
		case TransitionNameLabelEditPart.VISUAL_ID:
			return getTransitionName_6000Parser();
		case TransitionGuardLabelEditPart.VISUAL_ID:
			return getTransitionGuard_6001Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
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
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
