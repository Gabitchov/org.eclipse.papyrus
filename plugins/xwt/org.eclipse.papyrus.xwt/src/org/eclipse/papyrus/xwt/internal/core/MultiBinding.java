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
package org.eclipse.papyrus.xwt.internal.core;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.IDataBindingInfo;
import org.eclipse.papyrus.xwt.IDataProvider;
import org.eclipse.papyrus.xwt.IMultiValueConverter;
import org.eclipse.papyrus.xwt.IValidationRule;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.converters.StringMultiValueConerter;
import org.eclipse.papyrus.xwt.core.IDynamicBinding;
import org.eclipse.papyrus.xwt.databinding.AggregateObservableValue;
import org.eclipse.papyrus.xwt.databinding.IBindingContext;
import org.eclipse.papyrus.xwt.internal.utils.LoggerManager;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;

/**
 * Support the aggregation of data binding
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class MultiBinding extends DynamicBinding implements IDataBindingInfo {

	private Binding[] bindings = Binding.EMPTY_ARRAY;

	private IMultiValueConverter valueConverter;

	private IValidationRule[] valueValidators = IValidationRule.EMPTY_ARRAY;

	private AggregateObservableValue observableValue;

	private IObservableValue observableWidget;

	private BindingExpressionPath targetPropertySegments;

	/**
	 * <p>
	 * Default
	 * </p>
	 * 
	 */
	private UpdateSourceTrigger updateSourceTrigger = UpdateSourceTrigger.Default;

	private BindingGate bindingGate;

	public UpdateSourceTrigger getUpdateSourceTrigger() {
		return updateSourceTrigger;
	}

	public void setUpdateSourceTrigger(UpdateSourceTrigger updateSourceTrigger) {
		this.updateSourceTrigger = updateSourceTrigger;
	}

	public Binding[] getBindings() {
		return bindings;
	}

	public void setBindings(Binding[] bindings) {
		this.bindings = bindings;
	}

	public IMultiValueConverter getConverter() {
		if(valueConverter == null) {
			valueConverter = new StringMultiValueConerter();
		}
		return valueConverter;
	}

	public void setConverter(IMultiValueConverter valueConverter) {
		this.valueConverter = valueConverter;
	}

	public boolean isSourcePropertyReadOnly() {
		for(Binding binding : bindings) {
			if(binding.isSourcePropertyReadOnly()) {
				return true;
			}
		}
		return false;
	}

	public Object getValue(Class<?> targetType) {
		if(observableValue == null) {
			IObservableValue[] values = new IObservableValue[bindings.length];
			for(int i = 0; i < values.length; i++) {
				bindings[i].getValue(targetType);
				IObservable observable = bindings[i].getObservableSource();
				if(observable instanceof IObservableValue) {
					values[i] = (IObservableValue)observable;
				} else {
					LoggerManager.log("Binding expression has a problem with " + bindings[i].getPath());
					return null;
				}
			}

			observableValue = new AggregateObservableValue(values, getConverter());
		}

		IObservableValue observableWidget = getObservableWidget();

		IDataProvider dataProvider = getDataProvider();
		if(dataProvider != null) {
			BindingGate bindingGate = getBindingGate();
			if(bindingGate != null) {
				Object target = getControl();
				if(target instanceof Text && getType().equalsIgnoreCase("text")) {
					if(isSourcePropertyReadOnly()) {
						Text text = (Text)target;
						text.setEditable(false);
					}
				} else if(target instanceof Button && getType().equalsIgnoreCase("selection")) {
					if(isSourcePropertyReadOnly()) {
						Button button = (Button)target;
						button.setEnabled(false);
					}
				} else if((target instanceof Combo || target instanceof CCombo) && getType().equalsIgnoreCase("text")) {
					if(isSourcePropertyReadOnly()) {
						Control control = (Control)target;
						control.setEnabled(false);
					}
				} else if(target instanceof MenuItem && getType().equalsIgnoreCase("selection")) {
					if(isSourcePropertyReadOnly()) {
						MenuItem menuItem = (MenuItem)target;
						menuItem.setEnabled(false);
					}
				}
			}
			bindingGate.bind(observableValue, observableWidget, this);
		}

		if(targetType == null || !targetType.isInstance(observableValue)) {
			return observableValue.getValue();
		}
		return observableValue;
	}

	private BindingGate getBindingGate() {
		if(this.bindingGate == null) {
			IBindingContext dataBindingContext = XWT.getBindingContext(getControl());
			this.bindingGate = new BindingGate(dataBindingContext);
		}

		return this.bindingGate;
	}

	public IObservableValue getObservableWidget() {
		if(observableWidget == null) {
			Object target = getControl();
			Object host = getHost();
			try {
				observableWidget = ScopeManager.observeValue(target, host, getTargettPropertyExpression(), getUpdateSourceTrigger());
			} catch (XWTException e) {
			}
		}
		return observableWidget;
	}

	public Object createBoundSource() {
		Object control = getControl();
		Object source = XWT.getDataContext(control);
		Object localDataContext = UserData.getLocalDataContext(control);
		if(localDataContext == this) {
			return source;
		}

		if(source instanceof IDynamicBinding) {
			return ((IDynamicBinding)source).createBoundSource();
		}
		return source;
	}

	public boolean isSourceControl() {
		Object source = null;
		Object dataContextHost = getDataContextHost();
		if(dataContextHost != null) {
			source = UserData.getLocalDataContext(dataContextHost);
		}

		if(source instanceof IDynamicBinding) {
			return ((IDynamicBinding)source).isSourceControl();
		}
		return false;
	}

	public BindingExpressionPath getTargettPropertyExpression() {
		if(targetPropertySegments == null) {
			targetPropertySegments = new BindingExpressionPath(getType());
		}
		return targetPropertySegments;
	}

	public IValidationRule[] getValidators() {
		return valueValidators;
	}

	public void setValidators(IValidationRule[] valueValidators) {
		this.valueValidators = valueValidators;
	}

	public void reset() {
		for(Binding binding : bindings) {
			binding.reset();
		}
	}
}
