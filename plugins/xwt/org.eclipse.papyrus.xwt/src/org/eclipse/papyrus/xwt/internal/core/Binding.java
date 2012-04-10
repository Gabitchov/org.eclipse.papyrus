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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.xwt.IDataProvider;
import org.eclipse.papyrus.xwt.IValidationRule;
import org.eclipse.papyrus.xwt.IValueConverter;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.core.IBinding;
import org.eclipse.papyrus.xwt.core.IDynamicBinding;
import org.eclipse.papyrus.xwt.databinding.ControlDataBinding;
import org.eclipse.papyrus.xwt.databinding.DataBinding;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

/**
 * Generic Binding definition
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class Binding extends DynamicBinding {

	public static Binding[] EMPTY_ARRAY = new Binding[0];

	private String path;

	private Object source;

	private String elementName;

	private IValueConverter converter;

	private IValidationRule[] validationRules = IValidationRule.EMPTY_ARRAY;

	private IObservable observableSource;

	public Binding() {
		super();
	}

	/**
	 * <p>
	 * Default
	 * </p>
	 * 
	 */
	private UpdateSourceTrigger updateSourceTrigger = UpdateSourceTrigger.Default;

	private BindingExpressionPath pathSegments;

	public BindingExpressionPath getPathPropertySegments() {
		if(pathSegments == null) {
			pathSegments = new BindingExpressionPath(getPath());
		}
		return pathSegments;
	}

	public UpdateSourceTrigger getUpdateSourceTrigger() {
		return updateSourceTrigger;
	}

	public void setUpdateSourceTrigger(UpdateSourceTrigger updateSourceTrigger) {
		this.updateSourceTrigger = updateSourceTrigger;
	}

	public IValueConverter getConverter() {
		return converter;
	}

	public void setConverter(IValueConverter converter) {
		this.converter = converter;
	}

	public String getPath() {
		return path;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
		if(this.source instanceof IObservable) {
			this.observableSource = (IObservable)this.source;
		}
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	protected Object getSourceObject() {
		if(source != null) {
			return source;
		} else if(elementName != null) {
			return XWT.findElementByName(getControl(), elementName);
		}
		return null;
	}

	protected boolean isSelfBinding(Object data) {
		if(data != this) {
			return false;
		}
		Binding binding = (Binding)data;
		return BindingExpressionPath.isEmptyPath(binding.getPath());
	}

	public Object createBoundSource() {
		Object control = getControl();
		Object source = getSourceObject();
		if(source == null) {
			source = XWT.getDataContext(control, IDynamicBinding.class);
			Object localDataContext = UserData.getLocalDataContext(control);
			if(localDataContext == this) {
				return source;
			}
		}
		if(source instanceof IDynamicBinding) {
			Object value = ((IDynamicBinding)source).createBoundSource();
			if(value != null && path != null) {
				Widget widget = UserData.getWidget(value);
				if(widget == null) {
					widget = UserData.getWidget(control);
				}
				return ScopeManager.observeValue(widget, value, getPathPropertySegments(), getUpdateSourceTrigger());
			}
		}
		if(source != null && !BindingExpressionPath.isEmptyPath(path)) {
			Widget widget = UserData.getWidget(source);
			if(widget == null) {
				widget = UserData.getWidget(control);
			}
			return ScopeManager.observeValue(widget, source, getPathPropertySegments(), getUpdateSourceTrigger());
		}
		return source;
	}

	public boolean isSourceControl() {
		Object source = getSourceObject();
		if(source == null) {
			Object dataContextHost = getDataContextHost();
			if(dataContextHost != null) {
				source = UserData.getLocalDataContext(dataContextHost);
			}
		}

		if(source instanceof IDynamicBinding) {
			return ((IDynamicBinding)source).isSourceControl();
		}
		if(source instanceof IBinding) {
			source = ((IBinding)source).getValue(null);
		}

		if(path == null) {
			return false;
		}

		int index = BindingExpressionPath.lastIndexOf(path);
		if(index == -1) {
			return (source instanceof Control || source instanceof Viewer);
		}

		if(source instanceof IDataProvider) {
			return false;
		}
		String parentPath = path.substring(0, index);
		IObservable observable = ScopeManager.observeValue(getControl(), source, parentPath, getUpdateSourceTrigger());
		if(observable != null) {
			IObservableValue observableValue = (IObservableValue)observable;
			Object type = observableValue.getValueType();
			if(type != null) {
				return UserData.isUIElementType(type);
			}
		}
		return false;
	}

	public Object getValue(Class<?> targetType) {
		Object dataContext = getSourceObject();
		if(dataContext == null) {
			Object dataContextHost = getDataContextHost();
			if(dataContextHost != null) {
				dataContext = UserData.getLocalDataContext(dataContextHost);
				if(dataContext instanceof IDynamicBinding) {
					IDynamicBinding dynamicBinding = (IDynamicBinding)dataContext;
					Object boundSource = dynamicBinding.createBoundSource();
					if(boundSource != null) {
						dataContext = boundSource;
					}
				}
			}
		}

		// direct binding
		if(dataContext instanceof IBinding) {
			dataContext = ((IBinding)dataContext).getValue(null);
		}

		IDataProvider dataProvider = getDataProvider(dataContext);

		try {
			if(isSourceControl()) {
				ControlDataBinding controlDataBinding = new ControlDataBinding(dataContext, this, dataProvider);
				return controlDataBinding.getValue(targetType);
			}
		} catch (XWTException e) {
			// in case the property cannot be bound. return value
		}

		DataBinding dataBinding = null;
		if(dataProvider != null && (path != null || dataContext instanceof IObservable)) {
			dataBinding = new DataBinding(this, dataProvider);
		}
		if(dataBinding != null) {
			return dataBinding.getValue(targetType);
		}
		return convertedValue(dataContext);
	}

	private Object convertedValue(Object value) {
		IValueConverter converter = getConverter();
		if(converter != null) {
			value = converter.convert(value);
		}
		return value;
	}

	public boolean isSourcePropertyReadOnly() {
		IDataProvider dataProvider = getDataProvider();
		try {
			return ScopeManager.isPropertyReadOnly(dataProvider, getPathPropertySegments());
		} catch (XWTException e) {
		}
		return false;
	}

	public IObservable getObservableSource() {
		return observableSource;
	}

	public void setObservableSource(IObservable observableSource) {
		this.observableSource = observableSource;
	}

	/**
	 * Returns the validationRules for the binding
	 * 
	 * @return the array of validationRules
	 */
	public IValidationRule[] getValidationRules() {
		return this.validationRules;
	}

	/**
	 * Sets a single validationRule
	 * 
	 * @param validator
	 */
	public IValidationRule getValidationRule() {
		if(this.validationRules != null && this.validationRules.length > 0) {
			return this.validationRules[0];
		}
		return null;
	}

	/**
	 * Set the validationRules for the binding
	 * 
	 * @param validators
	 */
	public void setValidationRules(IValidationRule[] validationRules) {
		this.validationRules = validationRules;
	}

	/**
	 * Sets a single validationRule
	 * 
	 * @param validator
	 */
	public void setValidationRule(IValidationRule validationRule) {
		this.validationRules = new IValidationRule[]{ validationRule };
	}

	public void reset() {
		observableSource = null;
	}
}
