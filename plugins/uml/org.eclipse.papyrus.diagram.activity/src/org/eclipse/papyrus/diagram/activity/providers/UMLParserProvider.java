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
package org.eclipse.papyrus.diagram.activity.providers;

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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityIsSingleExecutionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.activity.parser.custom.ActivitySingleExecutionParser;
import org.eclipse.papyrus.diagram.activity.parser.custom.ParameterParser;
import org.eclipse.papyrus.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser activityName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5001Parser() {
		if(activityName_5001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			activityName_5001Parser = parser;
		}
		return activityName_5001Parser;
	}

	/**
	 * @generated
	 */
	private ActivitySingleExecutionParser activityIsSingleExecution_5002Parser;

	/**
	 * @generated
	 */
	private IParser getActivityIsSingleExecution_5002Parser() {
		if(activityIsSingleExecution_5002Parser == null) {
			activityIsSingleExecution_5002Parser = new ActivitySingleExecutionParser();
		}
		return activityIsSingleExecution_5002Parser;
	}

	/**
	 * @generated
	 */
	private ParameterParser parameter_3001Parser;

	/**
	 * @generated
	 */
	private IParser getParameter_3001Parser() {
		if(parameter_3001Parser == null) {
			parameter_3001Parser = new ParameterParser();
		}
		return parameter_3001Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraint_3002Parser;

	/**
	 * @generated
	 */
	private IParser getConstraint_3002Parser() {
		if(constraint_3002Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<precondition>> {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			constraint_3002Parser = parser;
		}
		return constraint_3002Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraint_3003Parser;

	/**
	 * @generated
	 */
	private IParser getConstraint_3003Parser() {
		if(constraint_3003Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("<<postcondition>> {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			constraint_3003Parser = parser;
		}
		return constraint_3003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case ActivityNameEditPart.VISUAL_ID:
			return getActivityName_5001Parser();
		case ActivityIsSingleExecutionEditPart.VISUAL_ID:
			return getActivityIsSingleExecution_5002Parser();
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001Parser();
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3002Parser();
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3003Parser();
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
