/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * This editpart has primary shape decorated by the DefaultSizeNodeFigure or other GMF-runtime figures. Most of the generated node' editparts are PrimaryShapeEditPart's.
 */
public interface PrimaryShapeEditPart extends IGraphicalEditPart {

	public IFigure getPrimaryShape();
}
