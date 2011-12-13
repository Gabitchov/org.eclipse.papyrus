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
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment;

import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;

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
