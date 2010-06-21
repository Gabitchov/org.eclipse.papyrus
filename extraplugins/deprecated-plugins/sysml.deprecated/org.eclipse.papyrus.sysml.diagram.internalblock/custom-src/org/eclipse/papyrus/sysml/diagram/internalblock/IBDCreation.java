/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.composite.CreateCompositeDiagramCommand;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.UMLFactory;

public class IBDCreation extends CreateCompositeDiagramCommand {

	/**
	 * Name of the Diagram
	 */
	protected static final String CSD_DEFAULT_NAME = "IBD"; //$NON-NLS-1$

	public static final String MODEL_ID = "IBD"; //$NON-NLS-1$

	public IBDCreation() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultDiagramName() {
		return openDiagramNameDialog(CSD_DEFAULT_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	/**
	 * Initialize the diagram with the canvas domain element shown.
	 * 
	 * @param diagram
	 *            the diagram to initialize
	 */
	protected void initializeDiagramContent(Diagram diagram) {

		// Create a view for the canvasDomainElement in the new diagram
		View view = ViewService.getInstance().createView(Node.class, new EObjectAdapter(canvasDomainElement), diagram,
				null, ViewUtil.APPEND, true, getPreferenceHint());

		// Update the view position and size (should adapt to canvas current size)
		Bounds viewBounds = (Bounds) ((Node) view).getLayoutConstraint();
		viewBounds.setX(DEFAULT_MARGIN);
		viewBounds.setY(DEFAULT_MARGIN);
		viewBounds.setHeight(DEFAULT_HEIGHT);
		viewBounds.setWidth(DEFAULT_WIDTH);
	}

}
