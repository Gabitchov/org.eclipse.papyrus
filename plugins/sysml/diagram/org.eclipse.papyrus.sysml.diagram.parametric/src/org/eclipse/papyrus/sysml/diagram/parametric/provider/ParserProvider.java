/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.parser.FlowPortLabelParser;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.parser.ParametricFrameParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConnectorLabelParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintLabelParser;
import org.eclipse.papyrus.uml.diagram.common.parser.MultiplicityElementLabelParser;
import org.eclipse.papyrus.uml.diagram.common.parser.NamedElementLabelParser;
import org.eclipse.papyrus.uml.diagram.common.parser.PropertyLabelParser;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

/**
 * Parser provider for labels used by this diagram.
 */
public class ParserProvider extends AbstractProvider implements IParserProvider {

	/** map from graphical hint to parsers */
	private static final Map<String, IParser> graphicalHintToParser = new HashMap<String, IParser>();

	static {
		graphicalHintToParser.put(SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID, new ParametricFrameParser());
		graphicalHintToParser.put(UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID, new PropertyLabelParser());
		graphicalHintToParser.put(UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID, new ConstraintLabelParser());

		graphicalHintToParser.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID, new PropertyLabelParser());
		graphicalHintToParser.put(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID, new FlowPortLabelParser());

		graphicalHintToParser.put(UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID, new NamedElementLabelParser());
		graphicalHintToParser.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_LABEL_ID, new ConnectorLabelParser());
		graphicalHintToParser.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_SOURCE_MULTIPLICITY_ID, new MultiplicityElementLabelParser());
		graphicalHintToParser.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_TARGET_MULTIPLICITY_ID, new MultiplicityElementLabelParser());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation)operation).getHint();

			if(!ElementTypes.DIAGRAM_ID.equals(getDiagramType(hint))) {
				return false;
			}

			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IParser getParser(IAdaptable hint) {
		String parserHint = (String)hint.getAdapter(String.class);
		if(parserHint != null) {
			IParser parser = graphicalHintToParser.get(parserHint);
			if(parser != null) {
				return parser;
			}
		}

		View view = (View)hint.getAdapter(View.class);
		if(view != null) {
			IParser parser = graphicalHintToParser.get(view.getType());
			if(parser != null) {
				return parser;
			}
		}

		return null;
	}

	private String getDiagramType(IAdaptable hint) {
		Diagram diagram = (Diagram)hint.getAdapter(Diagram.class);
		if(diagram != null) {
			return diagram.getType();
		}

		return "undefined";
	}

}
