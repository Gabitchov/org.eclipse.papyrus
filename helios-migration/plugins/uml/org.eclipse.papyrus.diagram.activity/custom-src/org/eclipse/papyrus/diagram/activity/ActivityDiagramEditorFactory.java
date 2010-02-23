/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;

/**
 * The editor factory to launch the activity diagram.
 */
public class ActivityDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * Instantiates a new activity diagram editor factory.
	 */
	public ActivityDiagramEditorFactory() {
		super(UmlActivityDiagramForMultiEditor.class, ActivityDiagramEditPart.MODEL_ID);
	}
}
