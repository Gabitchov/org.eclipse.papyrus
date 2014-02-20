/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - 402525
 * 
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.listener.CustomStyleListener;
import org.eclipse.papyrus.uml.tools.databinding.CommandBasedObservableValue;

/**
 * Abstract implementation for an ObservableValue associated to a GMF custom
 * style (NamedStyle).
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class AbstractCustomStyleObservableValue extends AbstractObservableValue implements CommandBasedObservableValue, IChangeListener, IObserving {

	protected View source;

	protected EditingDomain domain;

	protected String styleName;

	protected Object lastValue;

	protected CustomStyleListener listener;

	protected EClass styleClass;

	protected EStructuralFeature styleFeature;

	public AbstractCustomStyleObservableValue(View source, EditingDomain domain, String styleName, EClass styleClass, EStructuralFeature styleFeature) {
		this.source = source;
		this.domain = domain;
		this.styleName = styleName;
		this.styleClass = styleClass;
		this.styleFeature = styleFeature;
		source.eAdapters().add(listener = new CustomStyleListener(source, styleFeature, this, styleName));
	}

	public void handleChange(ChangeEvent event) {

		final Object oldValue = lastValue;
		final Object newValue = doGetValue();

		fireValueChange(new ValueDiff() {

			@Override
			public Object getOldValue() {
				return oldValue;
			}

			@Override
			public Object getNewValue() {
				return newValue;
			}

		});
	}

	@Override
	protected Object doGetValue() {
		NamedStyle valueStyle = source.getNamedStyle(styleClass, styleName);
		if(valueStyle != null) {
			lastValue = valueStyle.eGet(styleFeature);
		} else {
			lastValue = getDefaultValue();
		}
		return lastValue;
	}

	/**
	 * Gets the default value when this style is not set.
	 * 
	 * @return The default value for this NamedStyle
	 */
	protected abstract Object getDefaultValue();

	@Override
	protected void doSetValue(Object value) {
		Command command = getCommand(value);
		domain.getCommandStack().execute(command);
		doGetValue(); //Refresh the lastValue
	}

	public Command getCommand(Object value) {
		return new CustomStyleValueCommand(source, value, styleClass, styleFeature, styleName);
	}
	
	@Override
	public Object getObserved() {
		return source;
	}

	@Override
	public void dispose() {
		source.eAdapters().remove(listener);
		listener.dispose();
		listener = null;
		super.dispose();
	}
}
