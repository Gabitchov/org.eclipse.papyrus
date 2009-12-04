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
package org.eclipse.papyrus.diagram.sequence.providers;

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
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName7EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.sequence.parser.custom.InteractionUseCustomParsers;
import org.eclipse.papyrus.diagram.sequence.parser.custom.LifelineCustomParsers;
import org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
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
	private IParser actionExecutionSpecificationName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getActionExecutionSpecificationName_5005Parser() {
		if(actionExecutionSpecificationName_5005Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actionExecutionSpecificationName_5005Parser = parser;
		}
		return actionExecutionSpecificationName_5005Parser;
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
	private IParser messageName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6001Parser() {
		if(messageName_6001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			messageName_6001Parser = parser;
		}
		return messageName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6002Parser() {
		if(messageName_6002Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			messageName_6002Parser = parser;
		}
		return messageName_6002Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6003Parser() {
		if(messageName_6003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			messageName_6003Parser = parser;
		}
		return messageName_6003Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6004Parser() {
		if(messageName_6004Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			messageName_6004Parser = parser;
		}
		return messageName_6004Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_6005Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6005Parser() {
		if(messageName_6005Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			messageName_6005Parser = parser;
		}
		return messageName_6005Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_6006Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6006Parser() {
		if(messageName_6006Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			messageName_6006Parser = parser;
		}
		return messageName_6006Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_6007Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6007Parser() {
		if(messageName_6007Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			messageName_6007Parser = parser;
		}
		return messageName_6007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case InteractionNameEditPart.VISUAL_ID:
			return getInteractionName_5001Parser();
		case LifelineNameEditPart.VISUAL_ID:
			return getLifelineName_5002Parser();
		case ActionExecutionSpecificationNameEditPart.VISUAL_ID:
			return getActionExecutionSpecificationName_5005Parser();
		case InteractionUseNameEditPart.VISUAL_ID:
			return getInteractionUseName_5003Parser();
		case InteractionUseName2EditPart.VISUAL_ID:
			return getInteractionUseName_5004Parser();
		case MessageNameEditPart.VISUAL_ID:
			return getMessageName_6001Parser();
		case MessageName2EditPart.VISUAL_ID:
			return getMessageName_6002Parser();
		case MessageName3EditPart.VISUAL_ID:
			return getMessageName_6003Parser();
		case MessageName4EditPart.VISUAL_ID:
			return getMessageName_6004Parser();
		case MessageName5EditPart.VISUAL_ID:
			return getMessageName_6005Parser();
		case MessageName6EditPart.VISUAL_ID:
			return getMessageName_6006Parser();
		case MessageName7EditPart.VISUAL_ID:
			return getMessageName_6007Parser();
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
