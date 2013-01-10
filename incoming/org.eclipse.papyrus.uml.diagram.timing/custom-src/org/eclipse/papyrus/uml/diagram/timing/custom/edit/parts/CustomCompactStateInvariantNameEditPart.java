/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.parsers.CompactStateInvariantNameParser;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantNameEditPart;

public class CustomCompactStateInvariantNameEditPart extends CompactStateInvariantNameEditPart {

	private IParser parser;

	public CustomCompactStateInvariantNameEditPart(final View view) {
		super(view);
	}

	@Override
	public void performRequest(final Request request) {
		if(request.getType() == REQ_OPEN) {
			// double-click on the label is handled by the parent (to cut the CompactStateInvariant)
			getParent().performRequest(request);
		} else {
			super.performRequest(request);
		}
	}

	@Override
	public IParser getParser() {
		if(this.parser == null) {
			this.parser = new CompactStateInvariantNameParser();
		}
		return this.parser;
	}
}
