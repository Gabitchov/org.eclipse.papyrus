/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.diagram.deployment;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeploymentDiagramEditPart;


// TODO: Auto-generated Javadoc
/**
 * A factory for creating DeploymentDiagramEditor objects.
 */
public class DeploymentDiagramEditorFactory extends GmfEditorFactory {


	/**
	 * Instantiates a new deployment diagram editor factory.
	 */
	public DeploymentDiagramEditorFactory() {
		super(UmlDeploymentDiagramForMultiEditor.class, DeploymentDiagramEditPart.MODEL_ID);

	}


}
