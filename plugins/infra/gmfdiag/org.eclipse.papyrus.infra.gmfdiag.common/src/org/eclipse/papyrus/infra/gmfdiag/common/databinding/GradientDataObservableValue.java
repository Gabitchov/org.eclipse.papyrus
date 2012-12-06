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
package org.eclipse.papyrus.infra.gmfdiag.common.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;

/**
 * An ObservableValue for GradientData
 * The GradientData is not a pure EMF object
 * 
 * @author Camille Letavernier
 */
public class GradientDataObservableValue extends AbstractObservableValue {

	private GradientData data;

	private GradientProperty property;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param data
	 *        The GradientData to observe
	 * @param property
	 *        The name of the property to observe
	 */
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

	/**
	 * The list of properties that can be used by the GradientDataObservableValue
	 * 
	 * @author Camille Letavernier
	 */
	public static enum GradientProperty {
		/**
		 * The gradientColor2 property
		 * (In Papyrus diagrams, it is actually the fillColor that is used
		 * instead of the gradientColor2)
		 */
		gradientColor2,

		/**
		 * The gradientColor1 property
		 */
		gradientColor1,

		/**
		 * The gradientStyle property (Vertical or Horizontal)
		 */
		gradientStyle,

		/**
		 * Whether the gradient is activated or not
		 */
		activate
	}

}
