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
package org.eclipse.papyrus.sysml.diagram.parametric.providers;

import org.eclipse.core.runtime.IAdaptable;
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
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConnectorNameEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintLabelEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintPropertyNameEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.PropertyName2EditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.PropertyNameEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.parsers.ConnectorLabelParser;
import org.eclipse.papyrus.sysml.diagram.parametric.parsers.ConstraintLabelParser;
import org.eclipse.papyrus.sysml.diagram.parametric.parsers.ConstraintPropertyLabelParser;
import org.eclipse.papyrus.sysml.diagram.parametric.parsers.PropertyLabelParser;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlVisualIDRegistry;

/**
 * @generated
 */
public class SysmlParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private ConstraintPropertyLabelParser constraintPropertyLabel_5001Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintPropertyLabel_5001Parser() {
		if (constraintPropertyLabel_5001Parser == null) {
			constraintPropertyLabel_5001Parser = new ConstraintPropertyLabelParser();
		}
		return constraintPropertyLabel_5001Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintLabelParser constraintPropertyLabel_5004Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintPropertyLabel_5004Parser() {
		if (constraintPropertyLabel_5004Parser == null) {
			constraintPropertyLabel_5004Parser = new ConstraintLabelParser();
		}
		return constraintPropertyLabel_5004Parser;
	}

	/**
	 * @generated
	 */
	private PropertyLabelParser propertyName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_5002Parser() {
		if (propertyName_5002Parser == null) {
			propertyName_5002Parser = new PropertyLabelParser();
		}
		return propertyName_5002Parser;
	}

	/**
	 * @generated
	 */
	private PropertyLabelParser propertyName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_5003Parser() {
		if (propertyName_5003Parser == null) {
			propertyName_5003Parser = new PropertyLabelParser();
		}
		return propertyName_5003Parser;
	}

	/**
	 * @generated
	 */
	private ConnectorLabelParser connectorName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6001Parser() {
		if (connectorName_6001Parser == null) {
			connectorName_6001Parser = new ConnectorLabelParser();
		}
		return connectorName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ConstraintPropertyNameEditPart.VISUAL_ID:
			return getConstraintPropertyLabel_5001Parser();
		case ConstraintLabelEditPart.VISUAL_ID:
			return getConstraintPropertyLabel_5004Parser();
		case PropertyNameEditPart.VISUAL_ID:
			return getPropertyName_5002Parser();
		case PropertyName2EditPart.VISUAL_ID:
			return getPropertyName_5003Parser();
		case ConnectorNameEditPart.VISUAL_ID:
			return getConnectorName_6001Parser();
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
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(SysmlVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(SysmlVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (SysmlElementTypes.getElement(hint) == null) {
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
