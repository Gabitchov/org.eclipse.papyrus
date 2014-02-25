/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.databinding;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;

/**
 * This class encapsulates a gradient data, which may be null (If the
 * gradient is not activated).
 * 
 * If the gradient data is null, it will be created just-in-time when
 * setters are called.
 * 
 * This class has an additional property, {@link #activate}.
 * activate = false implies that the gradient data has not been set
 * (gradient data = null)
 * 
 * @author Camille Letavernier
 */
public class ObservableGradientData extends GradientData {

	private IObservableValue source;

	private GradientData encapsulated;

	private boolean activate;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The IObservableValue containing the gradient data. It will be
	 *        notified when the gradient data is changed
	 * @param encapsulated
	 *        The encapsulated gradient data. May be null
	 */
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

	/**
	 * Notifies the object owned the gradient data that a change
	 * occurred
	 */
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

	/**
	 * 
	 * @return true if this gradient data is activated
	 */
	public boolean getActivate() {
		return activate;
	}

	/**
	 * Activates or de-activates this gradient data
	 * 
	 * @param value
	 *        Whether the gradient data should be activated or de-activated
	 */
	public void setActivate(boolean value) {
		this.activate = value;
		notifySource();
	}

	public EObject getOwner() {
		EObject result = null;

		if(source instanceof IObserving) {
			Object owner = ((IObserving)source).getObserved();
			if(owner instanceof EObject) {
				result = (EObject)owner;
			}
		}

		return result;
	}
}
