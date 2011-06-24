/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.widgets;

import java.util.Map;

import org.eclipse.papyrus.diagram.common.helper.PropertyLabelHelper;
import org.eclipse.papyrus.properties.widgets.MaskProvider;


public class LabelCustomizationMaskProvider implements MaskProvider {

	public Map<Integer, String> getMasks() {
		return PropertyLabelHelper.getInstance().getMasks();
	}

}
