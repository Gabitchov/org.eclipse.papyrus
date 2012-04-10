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

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.internal.utils.LoggerManager;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class Condition {

	public static final Condition[] EMPTY_ARRAY = new Condition[0];

	private IBinding binding;

	private String property;

	private Operator operator = Operator.EQ;

	private String sourceName;

	private Object value;

	private CacheData cacheData;

	static class CacheData {

		protected Object value;

		protected IProperty property;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public IBinding getBinding() {
		return binding;
	}

	public void setBinding(IBinding binding) {
		this.binding = binding;
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

	public boolean evaluate(Object element) {
		String propertyName = getProperty();
		String sourceName = getSourceName();
		IBinding binding = getBinding();
		Object value = getValue();
		if(value == null) {
			return false;
		}
		while(value instanceof IObservableValue) {
			value = ((IObservableValue)value).getValue();
		}

		Object dataObject = TriggerBase.getElementByName(element, sourceName);

		if(propertyName != null) {
			if(cacheData != null) {
				try {
					Object existingValue = cacheData.property.getValue(dataObject);
					return Operator.compare(existingValue, operator, cacheData.value);
				} catch (Exception e) {
					LoggerManager.log(e);
				}
			}
			cacheData = new CacheData();

			IMetaclass metaclass = XWT.getMetaclass(dataObject);
			IProperty prop = metaclass.findProperty(propertyName);
			if(prop != null && value != null) {
				cacheData.property = prop;
				Class<?> valueType = value.getClass();
				IConverter converter = XWT.findConvertor(valueType, prop.getType());
				Object trueValue = value;
				if(converter != null) {
					trueValue = converter.convert(trueValue);
				}
				cacheData.value = trueValue;
				try {
					Object existingValue = prop.getValue(dataObject);
					return Operator.compare(existingValue, operator, trueValue);
				} catch (Exception e) {
					LoggerManager.log(e);
				}
			}
		} else if(binding != null) {
			Object existingValue = binding.getValue(null);
			if(existingValue == null) {
				return false;
			}
			while(existingValue instanceof IObservableValue) {
				existingValue = ((IObservableValue)existingValue).getValue();
			}
			Class<?> existingValueType = existingValue.getClass();
			Class<?> valueType = value.getClass();
			Object normalizedValue = value;
			if(!existingValueType.isAssignableFrom(valueType) && !valueType.isAssignableFrom(existingValueType)) {
				IConverter converter = XWT.findConvertor(valueType, existingValueType);
				if(converter != null) {
					normalizedValue = converter.convert(normalizedValue);
				} else if(value.toString().trim().length() > 0) {
					boolean found = false;
					// in case where the value is a boolean
					converter = XWT.findConvertor(valueType, Boolean.class);
					if(converter != null) {
						try {
							Object booleanValue = converter.convert(value);
							if(booleanValue != null) {
								converter = XWT.findConvertor(existingValueType, Boolean.class);
								if(converter != null) {
									existingValue = converter.convert(existingValue);
									normalizedValue = booleanValue;
									found = true;
								}
							}
						} catch (RuntimeException e) {
						}
					}
					if(!found) {
						converter = XWT.findConvertor(valueType, int.class);
						if(converter != null) {
							try {
								Object booleanValue = converter.convert(value);
								if(booleanValue != null) {
									converter = XWT.findConvertor(existingValueType, int.class);
									if(converter != null) {
										existingValue = converter.convert(existingValue);
										normalizedValue = booleanValue;
										found = true;
									}
								}
							} catch (Exception e) {
							}
						}
					}
					if(!found) {
						converter = XWT.findConvertor(valueType, double.class);
						if(converter != null) {
							try {
								Object booleanValue = converter.convert(value);
								if(booleanValue != null) {
									converter = XWT.findConvertor(existingValueType, double.class);
									if(converter != null) {
										existingValue = converter.convert(existingValue);
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
									converter = XWT.findConvertor(existingValueType, String.class);
									if(converter != null) {
										existingValue = converter.convert(existingValue);
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
			return Operator.compare(existingValue, operator, normalizedValue);
		}
		return false;
	}
}
