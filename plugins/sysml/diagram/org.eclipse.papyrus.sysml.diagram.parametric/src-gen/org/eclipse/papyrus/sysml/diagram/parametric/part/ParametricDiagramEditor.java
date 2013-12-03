/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.part;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;

/**
 * @generated
 */
public class ParametricDiagramEditor extends org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditor {

	/** context used when trying to find services */
  public static final String ID = "org.eclipse.papyrus.sysml.diagram.parametric.part.ParametricDiagramEditorID"; //$NON-NLS-1$

  /**
   * {@inheritDoc}
   */
  @Override
  public String getContextID() {
    return CONTEXT_ID;
  }

  /**
	 * @throws org.eclipse.papyrus.infra.core.services.ServiceException 
 * @generated
	 */
	public ParametricDiagramEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws ServiceException, org.eclipse.papyrus.infra.core.services.ServiceException {
    super(servicesRegistry, diagram);
  }
	
  // Start of user code Custom Editor Methods
	// End of user code

	/**
	 * @generated
	 */
	@Override
  public String getContributorId() {
    return Activator.PLUGIN_ID;
  }

	/**
	 * @generated
	 */
	@Override
  protected PreferencesHint getPreferencesHint() {
    return Activator.DIAGRAM_PREFERENCES_HINT;
  }
}
