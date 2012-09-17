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

import java.lang.reflect.Method;

import org.eclipse.papyrus.xwt.IDataProvider;
import org.eclipse.papyrus.xwt.IXWTLoader;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.annotation.UIBounds;
import org.eclipse.papyrus.xwt.core.IDynamicBinding;
import org.eclipse.papyrus.xwt.core.IUserDataConstants;
import org.eclipse.papyrus.xwt.databinding.BindingMode;
import org.eclipse.papyrus.xwt.databinding.IBindingContext;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;

/**
 * Generic Binding definition
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public abstract class DynamicBinding implements IDynamicBinding {

	private Object control;

	private Object host;

	private BindingMode mode = BindingMode.TwoWay;

	private IXWTLoader xwtLoader;

	/**
	 * The name of the {@link DataBindingContext} that we will look up in static
	 * resources
	 */
	private IBindingContext bindingContext;

	/**
	 * which used to decide binding type, not only text.
	 */
	private String type;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.core.IDynamicBinding#getContextName()
	 */
	public IBindingContext getBindingContext() {
		if(this.bindingContext == null) {
			Object element = (control == null ? host : control);
			this.bindingContext = XWT.getBindingContext(element);
		}
		return this.bindingContext;
	}

	public Object getHost() {
		return host;
	}

	public void setHost(Object host) {
		this.host = host;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.core.IDynamicBinding#setBindingContext(IBindingContext
	 * )
	 */
	public void setBindingContext(IBindingContext bindingContext) {
		this.bindingContext = bindingContext;
	}

	public void setControl(Object control) {
		this.control = control;
	}

	public Object getControl() {
		return this.control;
	}

	/**
	 * @param type
	 *        the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	public BindingMode getMode() {
		return mode;
	}

	public void setMode(BindingMode mode) {
		this.mode = mode;
	}

	public void setXWTLoader(IXWTLoader xwtLoader) {
		this.xwtLoader = xwtLoader;
	}

	protected Object getDataContextHost() {
		Object control = getControl();
		if(control == null) {
			return null;
		}
		Object data = UserData.getLocalDataContext(control);
		if(data == null || data == this) {
			if(data == null && UserData.hasLocalData(control, IUserDataConstants.XWT_DATACONTEXT_KEY)) {
				return control;
			}
			Widget parent = UserData.getParent(control);
			if(parent != null) {
				return UserData.getDataContextHost(parent);
			}
			return null;
		}
		return control;
	}

	protected Object getDataContext() {
		if(control != null) {
			return UserData.getDataContext(control);
		}
		return null;
	}

	protected IDataProvider getDataProvider(Object dataContext) {
		if(dataContext != null) {
			if(dataContext instanceof IDataProvider) {
				return (IDataProvider)dataContext;
			} else {
				return xwtLoader.findDataProvider(dataContext);
			}
		}
		return null;
	}

	public IDataProvider getDataProvider() {
		return getDataProvider(getDataContext());
	}

	protected Rectangle getControlBounds() {
		Widget widget = (Widget)getControl();
		if(widget instanceof Control) {
			Control control = (Control)widget;
			return control.getBounds();
		}
		Method drawMethod = findBoundsMethod(widget.getClass());
		if(drawMethod != null) {
			try {
				drawMethod.setAccessible(true);
				return (Rectangle)drawMethod.invoke(widget);
			} catch (Exception e) {
				throw new XWTException(e);
			}
		}
		Control control = findHostControl();
		return control.getBounds();
	}

	protected Control findHostControl() {
		Widget widget = (Widget)getControl();
		Control host;
		if(widget instanceof Item) {
			Item item = (Item)widget;
			host = (Control)XWT.findParent(item, Control.class);
		} else if(widget instanceof Control) {
			host = (Control)widget;
		} else {
			throw new XWTException();
		}
		return host;
	}

	private Method findBoundsMethod(Class<?> type) {
		for(Method method : type.getDeclaredMethods()) {
			if(method.getAnnotation(UIBounds.class) != null && method.getTypeParameters().length == 0 && method.getReturnType() == Rectangle.class) {
				return method;
			}
		}
		Class<?> supertype = type.getSuperclass();
		if(supertype != null && supertype != Widget.class) {
			Method method = findBoundsMethod(supertype);
			if(method != null) {
				return method;
			}
		}
		for(Class<?> anInterface : type.getInterfaces()) {
			Method method = findBoundsMethod(anInterface);
			if(method != null) {
				return method;
			}
		}
		try {
			Method method = type.getDeclaredMethod("getBounds");
			if(method.getReturnType() == Rectangle.class) {
				return method;
			}
		} catch (Exception e) {
		}
		return null;
	}
}
