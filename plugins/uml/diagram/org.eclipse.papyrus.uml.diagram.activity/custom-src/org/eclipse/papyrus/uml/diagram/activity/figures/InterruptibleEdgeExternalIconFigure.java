/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.figures;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;

/**
 * External icon which look like a Z which represent external icon for Interruptible Edge or Exception Handler
 */
public class InterruptibleEdgeExternalIconFigure extends ImageFigure {

	public InterruptibleEdgeExternalIconFigure() {
		super(UMLDiagramEditorPlugin.imageDescriptorFromPlugin(UMLDiagramEditorPlugin.ID, "icons/InterruptibleEdgeIcon.png").createImage(), 0);
	}
}
