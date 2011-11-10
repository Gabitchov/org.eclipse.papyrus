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
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


public class ComboLabelProvider extends LabelProvider {

	private ILabelProvider labelProvider;

	public ComboLabelProvider(IBaseLabelProvider encapsulated) {
		this.labelProvider = (ILabelProvider)encapsulated;
	}

	@Override
	public String getText(Object value) {
		if(value == UnsetObject.instance || value == UnchangedObject.instance) {
			return value.toString();
		}
		return labelProvider.getText(value);
	}

	@Override
	public Image getImage(Object value) {
		if(value == UnsetObject.instance || value == UnchangedObject.instance) {
			return null;
		}
		return labelProvider.getImage(value);
	}
}
