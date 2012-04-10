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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.XWTLoader;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractDialog extends Dialog {

	protected Object dataContext;

	protected String title;

	public AbstractDialog(Shell parentShell, String title, Object dataContext) {
		super(parentShell);
		this.dataContext = dataContext;
		this.title = title;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		if(title != null) {
			getShell().setText(title);
		}

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(getClassLoader());
			HashMap<String, Object> newOptions = new HashMap<String, Object>();
			initOptions(parent, newOptions);
			Object element = XWT.loadWithOptions(getContentURL(), newOptions);
			if(!(element instanceof Control)) {
				throw new XWTException("Root element must a control.");
			}
			GridLayoutFactory.fillDefaults().generateLayout(parent);
			parent.layout(true, true);
			return (Control)element;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Thread.currentThread().setContextClassLoader(classLoader);
			parent.setVisible(true);
		}
		return null;
	}

	protected void initOptions(Composite parent, HashMap<String, Object> newOptions) {
		newOptions.put(XWTLoader.CONTAINER_PROPERTY, parent);
		newOptions.put(XWTLoader.DATACONTEXT_PROPERTY, dataContext);
		newOptions.put(XWTLoader.CLASS_PROPERTY, geCLR());
	}

	protected abstract URL getContentURL();

	protected ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	protected Object geCLR() {
		return this;
	}
}
