/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.providers;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.uml.diagram.composite.custom.parsers.ConnectorLabelParser;
import org.eclipse.papyrus.uml.diagram.composite.custom.parsers.MultiplicityLabelParser;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorMultiplicitySourceEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorMultiplicityTargetEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorNameEditPart;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLParserProvider;

public class CustomParserProvider extends UMLParserProvider {

	protected IParser getParser(int visualID) {
		switch(visualID) {
		case ConnectorMultiplicitySourceEditPart.VISUAL_ID:
		case ConnectorMultiplicityTargetEditPart.VISUAL_ID:
			return getMultiplicityFormatParser();
		case ConnectorNameEditPart.VISUAL_ID:
			return getConnectorLabelParser();
		}
		return super.getParser(visualID);
	}

	private IParser getConnectorLabelParser() {
		return new ConnectorLabelParser();
	}

	private IParser getMultiplicityFormatParser() {
		return new MultiplicityLabelParser();
	}
}
