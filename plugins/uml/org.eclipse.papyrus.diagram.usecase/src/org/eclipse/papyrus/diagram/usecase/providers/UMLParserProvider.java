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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers;

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
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseNameEditPart;
import org.eclipse.papyrus.diagram.usecase.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser actorName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5002Parser() {
		if (actorName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5002Parser = parser;
		}
		return actorName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5003Parser() {
		if (actorName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5003Parser = parser;
		}
		return actorName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5004Parser() {
		if (useCaseName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			useCaseName_5004Parser = parser;
		}
		return useCaseName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5005Parser() {
		if (useCaseName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			useCaseName_5005Parser = parser;
		}
		return useCaseName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5007Parser() {
		if (componentName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_5007Parser = parser;
		}
		return componentName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5012Parser() {
		if (packageName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5012Parser = parser;
		}
		return packageName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5011Parser() {
		if (constraintName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5011Parser = parser;
		}
		return constraintName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser commentBody_5013Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5013Parser() {
		if (commentBody_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getComment_Body() };
			MessageFormatParser parser = new MessageFormatParser(features);
			commentBody_5013Parser = parser;
		}
		return commentBody_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser extensionPoint_3002Parser;

	/**
	 * @generated
	 */
	private IParser getExtensionPoint_3002Parser() {
		if (extensionPoint_3002Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			extensionPoint_3002Parser = parser;
		}
		return extensionPoint_3002Parser;
	}

	/**
	 * @generated
	 */
	private IParser extensionPoint_3003Parser;

	/**
	 * @generated
	 */
	private IParser getExtensionPoint_3003Parser() {
		if (extensionPoint_3003Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			extensionPoint_3003Parser = parser;
		}
		return extensionPoint_3003Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5006Parser() {
		if (useCaseName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			useCaseName_5006Parser = parser;
		}
		return useCaseName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5008Parser() {
		if (actorName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5008Parser = parser;
		}
		return actorName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5009Parser() {
		if (useCaseName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			useCaseName_5009Parser = parser;
		}
		return useCaseName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6003Parser() {
		if (associationName_6003Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			associationName_6003Parser = parser;
		}
		return associationName_6003Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6004Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6004Parser() {
		if (associationName_6004Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			associationName_6004Parser = parser;
		}
		return associationName_6004Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6005Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6005Parser() {
		if (dependencyName_6005Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_6005Parser = parser;
		}
		return dependencyName_6005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ActorNameEditPart.VISUAL_ID:
			return getActorName_5002Parser();
		case ActorName2EditPart.VISUAL_ID:
			return getActorName_5003Parser();
		case UseCaseNameEditPart.VISUAL_ID:
			return getUseCaseName_5004Parser();
		case UseCaseName2EditPart.VISUAL_ID:
			return getUseCaseName_5005Parser();
		case ComponentNameEditPart.VISUAL_ID:
			return getComponentName_5007Parser();
		case PackageName2EditPart.VISUAL_ID:
			return getPackageName_5012Parser();
		case ConstraintNameEditPart.VISUAL_ID:
			return getConstraintName_5011Parser();
		case CommentBodyEditPart.VISUAL_ID:
			return getCommentBody_5013Parser();
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3002Parser();
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3003Parser();
		case UseCaseName3EditPart.VISUAL_ID:
			return getUseCaseName_5006Parser();
		case ActorName3EditPart.VISUAL_ID:
			return getActorName_5008Parser();
		case UseCaseName4EditPart.VISUAL_ID:
			return getUseCaseName_5009Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6003Parser();
		case AssociationName2EditPart.VISUAL_ID:
			return getAssociationName_6004Parser();
		case DependencyNameEditPart.VISUAL_ID:
			return getDependencyName_6005Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * 
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
