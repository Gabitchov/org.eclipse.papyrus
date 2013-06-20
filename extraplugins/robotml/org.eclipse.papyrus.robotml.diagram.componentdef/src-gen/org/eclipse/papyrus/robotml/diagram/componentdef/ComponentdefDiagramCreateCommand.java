/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.componentdef;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.robotml.diagram.componentdef.edit.part.ComponentdefDiagramEditPart;

public class ComponentdefDiagramCreateCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	@Override
	protected String getDefaultDiagramName() {
		return "ComponentsDiagram";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return ComponentdefDiagramEditPart.DIAGRAM_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return Activator.DIAGRAM_PREFERENCES_HINT;
	}

}
