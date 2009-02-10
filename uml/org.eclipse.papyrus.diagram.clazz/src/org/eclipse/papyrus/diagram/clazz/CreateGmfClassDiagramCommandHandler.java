/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin Cedric.Dumoulin@lifl.fr - Initial API and implementation
 * 
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.clazz;

import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;

/**
 * Action creating a new GMF diagram in Papyrus This handler is used with editors using BackboneContext.
 * 
 * @author dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreateGmfClassDiagramCommandHandler extends AbstractPapyrusGmfCreateDiagramCommandHandler implements IHandler {

	@Override
	protected String getDiagramName() {
		return openDiagramNameDialog("ClassDiagram");
	}

	/**
	 * @return
	 */
	protected String getDiagramNotationID() {
		return ModelEditPart.MODEL_ID;
	}

	/**
	 * @return
	 */
	protected PreferencesHint getPreferenceHint() {
		return org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

}
