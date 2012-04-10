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
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.widgets.Widget;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class DataTrigger extends TriggerBase {

	private Object value;

	private Operator operator = Operator.EQ;

	private IBinding binding;

	private SetterBase[] setters;

	private ValueChangeListener changeListener;

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public IBinding getBinding() {
		return binding;
	}

	public void setBinding(IBinding binding) {
		this.binding = binding;
	}

	public SetterBase[] getSetters() {
		if(setters == null) {
			return Setter.EMPTY_SETTERS;
		}
		return setters;
	}

	public void setSetters(SetterBase[] setters) {
		this.setters = setters;
	}

	class ValueChangeListener extends AbstractChangeListener {

		public ValueChangeListener(Object element) {
			super(element);
		}

		public void handleChange(ChangeEvent event) {
			doHandleChange(true);
		}

		public void doHandleChange(boolean update) {
			Widget widget = UserData.getWidget(element);
			if(widget == null) {
				return;
			}
			Object currentValue = binding.getValue(null);
			if(currentValue == null) {
				return;
			}
			while(currentValue instanceof IObservableValue) {
				currentValue = ((IObservableValue)currentValue).getValue();
			}

			Class<?> currentValueType = currentValue.getClass();
			Class<?> valueType = value.getClass();
			Object normalizedValue = value;
			if(!currentValueType.isAssignableFrom(valueType) && !valueType.isAssignableFrom(currentValueType)) {
				IConverter converter = XWT.findConvertor(valueType, currentValueType);
				if(converter != null) {
					normalizedValue = converter.convert(normalizedValue);
				} else if(value != null && value.toString().trim().length() > 0) {
					boolean found = false;
					// in case where the value is a boolean
					converter = XWT.findConvertor(valueType, Boolean.class);
					if(converter != null) {
						try {
							Object booleanValue = converter.convert(value);
							if(booleanValue != null) {
								converter = XWT.findConvertor(currentValueType, Boolean.class);
								if(converter != null) {
									currentValue = converter.convert(currentValue);
									normalizedValue = booleanValue;
									found = true;
								}
							}
						} catch (RuntimeException e) {
						}
					}
					if(!found) {
						converter = XWT.findConvertor(valueType, Integer.class);
						if(converter != null) {
							try {
								Object booleanValue = converter.convert(value);
								if(booleanValue != null) {
									converter = XWT.findConvertor(currentValueType, Integer.class);
									if(converter != null) {
										currentValue = converter.convert(currentValue);
										normalizedValue = booleanValue;
										found = true;
									}
								}
							} catch (Exception e) {
							}
						}
					}
					if(!found) {
						converter = XWT.findConvertor(valueType, Double.class);
						if(converter != null) {
							try {
								Object booleanValue = converter.convert(value);
								if(booleanValue != null) {
									converter = XWT.findConvertor(currentValueType, Double.class);
									if(converter != null) {
										currentValue = converter.convert(currentValue);
										normalizedValue = booleanValue;
										found = true;
									}
								}
							} catch (Exception e) {
							}
						}
					}
					if(!found) {
						converter = XWT.findConvertor(valueType, String.class);
						if(converter != null) {
							try {
								Object booleanValue = converter.convert(value);
								if(booleanValue != null) {
									converter = XWT.findConvertor(currentValueType, String.class);
									if(converter != null) {
										currentValue = converter.convert(currentValue);
										normalizedValue = booleanValue;
										found = true;
									}
								}
							} catch (Exception e) {
							}
						}
					}
				}
			}
			if(!Operator.compare(currentValue, operator, normalizedValue) && update) {
				restoreValues();
				return;
			}

			for(SetterBase setter : getSetters()) {
				try {
					Object oldValue = setter.applyTo(element, update);
					if(!update) {
						if(oldvalues == null) {
							oldvalues = new HashMap<SetterBase, Object>();
						}
						oldvalues.put(setter, oldValue);
					}
				} catch (RuntimeException e) {
					continue;
				}
			}
		}
	}

	public void prepare(Object target) {
		if(value == null) {
			return;
		}
		Widget widget = UserData.getWidget(target);
		if(widget == null) {
			return;
		}
		Object bindingTarget = null;
		if(binding != null) {
			if(binding instanceof IDynamicBinding) {
				IDynamicBinding dynamicBinding = (IDynamicBinding)binding;
				bindingTarget = dynamicBinding.createBoundSource();
			} else {
				bindingTarget = binding.getValue(null);
			}
		} else {
			bindingTarget = XWT.getDataContext(widget);
		}
		if(!(bindingTarget instanceof IObservableValue)) {
			return;
		}
		IObservableValue observableValue = (IObservableValue)bindingTarget;
		changeListener = new ValueChangeListener(target);
		observableValue.addChangeListener(changeListener);
		changeListener.doHandleChange(false); // get default value
	}

	@Override
	public void on(Object target) {
		changeListener.doHandleChange(true);
	}
}
