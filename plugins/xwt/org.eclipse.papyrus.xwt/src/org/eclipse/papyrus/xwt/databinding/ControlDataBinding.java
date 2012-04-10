/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.xwt.databinding;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.IDataProvider;
import org.eclipse.papyrus.xwt.IValueConverter;
import org.eclipse.papyrus.xwt.internal.core.Binding;
import org.eclipse.papyrus.xwt.internal.core.BindingGate;
import org.eclipse.papyrus.xwt.internal.core.ScopeManager;
import org.eclipse.papyrus.xwt.internal.utils.UserData;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class ControlDataBinding extends AbstractDataBinding {

	private Object source;

	public ControlDataBinding(Object source, Binding binding, IDataProvider dataProvider) {
		super(binding, dataProvider);
		this.source = source;
	}

	/**
	 * Get bind value of two bindings.
	 */
	public Object getValue(Class<?> targetType) {
		IObservableValue targetWidget = null;
		Object target = getControl();
		if(target != null) {
			targetWidget = ScopeManager.observeValue(target, target, getTargetProperty(), getUpdateSourceTrigger());
		}
		if(source == null) {
			return null;
		}

		Object control = UserData.getWidget(source);
		if(control == null) {
			control = getControl();
		}

		IObservableValue sourceWidget = ScopeManager.observeValue(control, source, getSourceProperty(), getUpdateSourceTrigger());

		if(targetWidget == null) {
			if(sourceWidget != null) {
				if(targetType != null && !targetType.isInstance(sourceWidget)) {
					return sourceWidget;
				}
				Object value = sourceWidget.getValue();
				while(value instanceof IObservableValue) {
					value = ((IObservableValue)value).getValue();
				}
				IValueConverter converter = getConverter();
				if(converter != null) {
					value = converter.convert(value);
				}
				return value;
			}
			return source;
		}

		IBindingContext dataBindingContext = getDataBindingContext();
		BindingGate bindingGate = new BindingGate(dataBindingContext);
		bindingGate.bind(sourceWidget, targetWidget, this);
		if(sourceWidget != null) {
			if(targetType != null && !targetType.isInstance(sourceWidget)) {
				return sourceWidget;
			}
			// convert to final value
			Object value = sourceWidget.getValue();
			while(value instanceof IObservableValue) {
				value = ((IObservableValue)value).getValue();
			}
			IValueConverter converter = getConverter();
			if(converter != null) {
				value = converter.convert(value);
			}
			return value;
		}
		return source;
	}

	/**
	 * 
	 * @return
	 */
	protected Object getSource() {
		return source;
	}
}
