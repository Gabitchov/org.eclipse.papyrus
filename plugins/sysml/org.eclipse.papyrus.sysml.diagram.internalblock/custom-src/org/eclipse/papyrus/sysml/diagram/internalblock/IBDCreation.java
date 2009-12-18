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
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.InternalBlockDiagramEditorPlugin;
import org.eclipse.uml2.uml.UMLFactory;

public class IBDCreation extends AbstractPapyrusGmfCreateDiagramCommandHandler {

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
		return InternalBlockDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

}
