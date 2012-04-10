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
package org.eclipse.papyrus.xwt.jface;

import java.net.URL;
import java.util.HashMap;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTLoader;
import org.eclipse.papyrus.xwt.databinding.BindingContext;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author yyang <yves.yang@soyatec.com>
 */
public class XWTTitleAreaDialog extends TitleAreaDialog {

	private Object dataContext;

	private BindingContext bindingContext;

	private AggregateValidationStatus validationStatus;

	private Class<?> contentCLS;

	public XWTTitleAreaDialog(Shell parentShell, Object dataContext, BindingContext bindingContext) {
		super(parentShell);
		this.dataContext = dataContext;
		this.bindingContext = bindingContext;
	}

	public XWTTitleAreaDialog(Shell parentShell, Class<?> contentCLS, Object dataContext) {
		this(parentShell, contentCLS, dataContext, null);
	}

	public XWTTitleAreaDialog(Shell parentShell, Class<?> contentCLS, Object dataContext, BindingContext bindingContext) {
		super(parentShell);
		this.contentCLS = contentCLS;
		this.dataContext = dataContext;
		this.bindingContext = bindingContext;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Control control = super.createDialogArea(parent);

		if(bindingContext == null) {
			bindingContext = new BindingContext(parent);
		}
		validationStatus = bindingContext.getStatus();
		validationStatus.addChangeListener(new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				IStatus status = (IStatus)validationStatus.getValue();
				setMessage(status.getMessage(), status.getSeverity());
			}
		});

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(contentCLS.getClassLoader());
			HashMap<String, Object> newOptions = new HashMap<String, Object>();
			newOptions.put(XWTLoader.CONTAINER_PROPERTY, parent);
			Object dataContext = getDataContext();
			if(dataContext != null) {
				newOptions.put(XWTLoader.DATACONTEXT_PROPERTY, dataContext);
			}
			BindingContext bindingContext = getBindingContext();
			if(bindingContext != null) {
				newOptions.put(XWTLoader.BINDING_CONTEXT_PROPERTY, bindingContext);
			}
			newOptions.put(XWTLoader.CLASS_PROPERTY, contentCLS);

			XWT.loadWithOptions(getContentURL(), newOptions);
			GridLayoutFactory.fillDefaults().generateLayout(parent);
			parent.layout(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Thread.currentThread().setContextClassLoader(classLoader);
			parent.setVisible(true);
		}
		return control;
	}

	public URL getContentURL() {
		if(contentCLS != null) {
			return contentCLS.getResource(contentCLS.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		}
		return null;
	}

	public Object getDataContext() {
		return dataContext;
	}

	public BindingContext getBindingContext() {
		return bindingContext;
	}
}
