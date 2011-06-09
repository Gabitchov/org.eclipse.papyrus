/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.RectangleFigure;

public class PolylineContainer extends RectangleFigure {

	public PolylineContainer() {
		super();
		setOutline(false);
		setFill(false);
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}

}
