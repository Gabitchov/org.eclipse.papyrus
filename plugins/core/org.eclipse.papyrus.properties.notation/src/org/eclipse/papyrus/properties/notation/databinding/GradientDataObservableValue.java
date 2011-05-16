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
package org.eclipse.papyrus.properties.notation.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;


public class GradientDataObservableValue extends AbstractObservableValue {

	private GradientData data;

	private GradientProperty property;

	public GradientDataObservableValue(GradientData data, String property) {
		this.data = data;
		this.property = GradientProperty.valueOf(property);
	}

	public Object getValueType() {
		return Object.class;
	}

	@Override
	protected Object doGetValue() {
		if(data == null) {
			return null;
		}

		switch(property) {
		case gradientColor1:
			return data.getGradientColor1();
		case gradientColor2:
			return data.getGradientColor2();
		case gradientStyle:
			return data.getGradientStyle();
		case activate:
			if(data instanceof ObservableGradientData) {
				return ((ObservableGradientData)data).getActivate();
			} else {
				return true;
			}
		}

		return null;
	}

	@Override
	protected void doSetValue(Object value) {
		if(data == null) {
			return;
		}

		switch(property) {
		case gradientColor1:
			data.setGradientColor1((Integer)value);
			break;
		case gradientColor2:
			data.setGradientColor2((Integer)value);
			break;
		case gradientStyle:
			data.setGradientStyle((Integer)value);
			break;
		case activate:
			if(data instanceof ObservableGradientData) {
				((ObservableGradientData)data).setActivate((Boolean)value);
			}
		}
	}

	public static enum GradientProperty {
		gradientColor2, gradientColor1, gradientStyle, activate
	}

}
