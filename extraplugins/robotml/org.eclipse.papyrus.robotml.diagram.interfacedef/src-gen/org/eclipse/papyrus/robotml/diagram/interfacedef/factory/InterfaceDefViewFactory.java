/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.interfacedef.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;

public class InterfaceDefViewFactory extends DiagramViewFactory {

	protected MeasurementUnit getMeasurementUnit() {
		return MeasurementUnit.PIXEL_LITERAL;
	}
}
