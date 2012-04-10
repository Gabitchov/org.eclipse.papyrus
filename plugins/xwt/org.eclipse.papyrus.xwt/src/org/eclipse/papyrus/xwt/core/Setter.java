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
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;


/**
 * Setter of the class Style, which is used to define the in-line XAML style
 * 
 * @see Style
 * @author yyang
 */
public class Setter extends SetterBase {

	protected String property;

	protected Object value;

	protected String targetName;

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object applyTo(Object element, boolean update) {
		String propName = getProperty();
		Object propValue = getValue();
		String targetName = getTargetName();
		Object setterTarget = element;
		Object oldValue = null;
		if(targetName != null) {
			setterTarget = TriggerBase.getElementByName(element, targetName);
		}
		IMetaclass metaclass = XWT.getMetaclass(setterTarget);
		IProperty prop = metaclass.findProperty(propName);
		if(prop != null && propValue != null) {
			Object toValue = propValue;
			Class<?> valueType = propValue.getClass();
			Class<?> targetType = prop.getType();
			if(targetType != null && !targetType.isAssignableFrom(valueType)) {
				IConverter converter = XWT.findConvertor(valueType, targetType);
				if(converter != null) {
					toValue = converter.convert(propValue);
				} else {
					throw new XWTException("Converter doesn't exist from \"" + valueType.getName() + "\" to \"" + targetType.getName());
				}
			}
			try {
				oldValue = prop.getValue(setterTarget);
				if(update) {
					prop.setValue(setterTarget, toValue);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return oldValue;
	}

	public void undo(Object element, Object value) {
		String propName = getProperty();
		String targetName = getTargetName();
		Object setterTarget = element;
		if(targetName != null) {
			setterTarget = TriggerBase.getElementByName(element, targetName);
		}
		IMetaclass metaclass = XWT.getMetaclass(setterTarget);
		IProperty prop = metaclass.findProperty(propName);
		if(prop != null) {
			try {
				prop.setValue(setterTarget, value);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
