/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;

public class SemanticParserAdapter extends ParserAdapter implements ISemanticParser {

	public SemanticParserAdapter(ExternalParserBase delegate, ApplyStrategy applier,
			ExternalToString.WithReferences view, ExternalToString edit) {
		super(delegate, applier, view, edit);
	}

	public SemanticParserAdapter(ExternalParserBase delegate, ApplyStrategy applier,
			ExternalToString.WithReferences viewAndEdit) {
		this(delegate, applier, viewAndEdit, viewAndEdit);
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return isAffectingEvent(notification);
	}

	public List getSemanticElementsBeingParsed(EObject element) {
		return isValidElement(element) ? getViewToStringImpl().getAdditionalReferencedElements(element)
				: Collections.EMPTY_LIST;
	}

	private ExternalToString.WithReferences getViewToStringImpl() {
		return (ExternalToString.WithReferences) getViewToString();
	}

}
