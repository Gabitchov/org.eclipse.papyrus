/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.parsers.OccurrenceSpecificationNameParser;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationLabelEditPart;

public class CustomOccurrenceSpecificationLabelEditPart extends OccurrenceSpecificationLabelEditPart {
	private IParser parser;

	public CustomOccurrenceSpecificationLabelEditPart(final View view) {
		super(view);
	}

	@Override
	public IParser getParser() {
		if (this.parser == null) {
			this.parser = new OccurrenceSpecificationNameParser();
		}
		return this.parser;
	}
}
