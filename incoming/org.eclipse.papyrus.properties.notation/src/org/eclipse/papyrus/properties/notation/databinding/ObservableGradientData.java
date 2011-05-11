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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;


public class ObservableGradientData extends GradientData {

	private IObservableValue source;

	private GradientData encapsulated;

	private boolean activate;

	public ObservableGradientData(IObservableValue source, GradientData encapsulated) {
		this.encapsulated = new GradientData(encapsulated);
		this.source = source;
		this.activate = encapsulated != null;
	}

	@Override
	public int getGradientColor1() {
		return encapsulated.getGradientColor1();
	}

	@Override
	public int getGradientColor2() {
		return encapsulated.getGradientColor2();
	}

	@Override
	public int getGradientStyle() {
		return encapsulated.getGradientStyle();
	}

	protected void notifySource() {
		if(activate) {
			source.setValue(new GradientData(encapsulated));
		} else {
			source.setValue(null);
		}
	}

	@Override
	public void setGradientColor1(int color) {
		encapsulated.setGradientColor1(color);
		notifySource();
	}

	@Override
	public void setGradientColor2(int color) {
		encapsulated.setGradientColor2(color);
		notifySource();
	}

	@Override
	public void setGradientStyle(int style) {
		encapsulated.setGradientStyle(style);
		notifySource();
	}

	@Override
	public int hashCode() {
		return encapsulated.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		return encapsulated.equals(other);
	}

	public boolean getActivate() {
		return activate;
	}

	public void setActivate(boolean value) {
		this.activate = value;
		notifySource();
	}

}
