/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.part;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditor;
import org.eclipse.papyrus.sysml.diagram.requirement.Activator;

/**
 * SysML Requirement Diagram editor that extend the UML Class Diagram editor
 * 
 */
public class RequirementDiagramEditor extends UMLDiagramEditor {

	@Override
	public String getContributorId() {
		return Activator.PLUGIN_ID;
	}

	@Override
	protected PreferencesHint getPreferencesHint() {
		return Activator.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * Constructor.
	 * 
	 * @param servicesRegistry
	 * @param diagram
	 * @throws ServiceException
	 */
	public RequirementDiagramEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws ServiceException {
		super(servicesRegistry, diagram);
	}

}
