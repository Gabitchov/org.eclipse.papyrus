/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo vincent.lorenzo@cea.fr  - Adapted from Composite Structure Diagram
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.profile;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileDiagramEditPart;

/**
 * The profile's diagram editor factory
 * 
 * @author VL222926
 * 
 */
public class ProfileDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ProfileDiagramEditorFactory() {
		super(UmlProfileDiagramForMultiEditor.class, ProfileDiagramEditPart.MODEL_ID);
	}
}
