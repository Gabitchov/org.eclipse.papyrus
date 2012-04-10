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
package org.eclipse.papyrus.xwt.core;

import java.util.HashMap;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.databinding.JFaceXWTDataBinding;
import org.eclipse.papyrus.xwt.internal.core.ScopeManager;
import org.eclipse.papyrus.xwt.internal.core.UpdateSourceTrigger;
import org.eclipse.papyrus.xwt.internal.utils.LoggerManager;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.widgets.Widget;

public class Trigger extends TriggerBase {

	private String property;

	private String sourceName;

	private Operator operator = Operator.EQ;

	private Object value;

	private SetterBase[] setters;

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public SetterBase[] getSetters() {
		if(setters == null) {
			return SetterBase.EMPTY_SETTERS;
		}
		return setters;
	}

	public void setSetters(SetterBase[] setters) {
		this.setters = setters;
	}

	public void on(Object target) {
	}

	public void prepare(Object target) {
		if(property != null) {
			final Object source = getElementByName(target, sourceName);
			if(source == null) {
				throw new XWTException("No element is found with the name = " + sourceName);
			}
			IObservable observableValue = ScopeManager.observeValue(source, source, property, UpdateSourceTrigger.PropertyChanged);
			observableValue.addChangeListener(new AbstractChangeListener(target) {

				public void handleChange(ChangeEvent event) {
					Class<?> valueType = JFaceXWTDataBinding.getValueType(source.getClass(), property);
					if(valueType == null) {
						LoggerManager.log("Type of the property " + property + " is not found in " + source.getClass().getName());
						return;
					}
					Widget widget = UserData.getWidget(source);
					if(widget == null) {
						return;
					}

					//
					// test value ==
					//
					Object realValue = value;
					if(value != null) {
						IConverter converter = XWT.findConvertor(value.getClass(), valueType);
						if(converter != null) {
							realValue = converter.convert(value);
						}
					}
					Object newValue = event.getSource();
					if(newValue instanceof IObservableValue) {
						IObservableValue observableValue = (IObservableValue)newValue;
						newValue = observableValue.getValue();
					}
					if(newValue != null) {
						IConverter newConverter = XWT.findConvertor(newValue.getClass(), valueType);
						if(newConverter != null) {
							newValue = newConverter.convert(newValue);
						}
					}

					if(!Operator.compare(newValue, operator, realValue)) {
						restoreValues();
						if(oldvalues != null) {
							oldvalues.clear();
						}
						return;
					}

					if(oldvalues != null && !oldvalues.isEmpty()) {
						return;
					}

					for(SetterBase setter : getSetters()) {
						try {
							Object oldValue = setter.applyTo(element, true);
							if(oldvalues == null) {
								oldvalues = new HashMap<SetterBase, Object>();
							}
							oldvalues.put(setter, oldValue);
						} catch (RuntimeException e) {
							continue;
						}
					}
				}
			});
		}
	}
}
