/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.part;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.sysml.diagram.requirement.Activator;

/**
 * Diagram editor that extends the UMLDiagramEditor editor.
 */
public class RequirementDiagramEditor extends org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditor {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getContributorId() {
		return Activator.PLUGIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferencesHint() {
		return Activator.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * Constructor.
	 * 
	 * @param servicesRegistry
	 *        registry to find services (label providers, editing domain, etc.)
	 * @param diagram
	 *        edited diagram
	 * @throws ServiceException
	 *         exception thrown ni case of issue during initialization
	 */
	public RequirementDiagramEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws ServiceException {
		super(servicesRegistry, diagram);
	}

}
