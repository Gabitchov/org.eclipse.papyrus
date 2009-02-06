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
 *****************************************************************************/

package org.eclipse.papyrus.diagram.clazz;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractGmfCreateDiagramAction;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.sasheditor.extension.ICreateDiagramAction;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Action creating a new diagram.
 * 
 * @deprecated Not used anymore TODO Remove it.
 * @author dumoulin
 * 
 */
public class CreateClassDiagramAction extends AbstractGmfCreateDiagramAction implements ICreateDiagramAction {

	/**
	 * Create the first element of the uml part.
	 */
	@Override
	protected Package createInitialModel() {
		return UMLFactory.eINSTANCE.createPackage();
	}

	@Override
	protected String getDiagramName() {
		// TODO Auto-generated method stub
		return "PapyrusClassDiagram";
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
