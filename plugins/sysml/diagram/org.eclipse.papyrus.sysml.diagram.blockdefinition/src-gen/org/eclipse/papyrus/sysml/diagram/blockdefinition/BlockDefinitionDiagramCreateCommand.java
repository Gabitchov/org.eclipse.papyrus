/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		CEA LIST - Initial API and implementation
 * 		Laurent Wouters (CEA LIST) laurent.wouters@cea.fr - Viewpoints application
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;

/**
 * Represents the creation command for a SysML block definition diagram
 * @author Laurent Wouters
 */
public class BlockDefinitionDiagramCreateCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultDiagramName() {
		return "New Block Definition Diagram"; // //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return ElementTypes.DIAGRAM_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return Activator.DIAGRAM_PREFERENCES_HINT;
	}
}
