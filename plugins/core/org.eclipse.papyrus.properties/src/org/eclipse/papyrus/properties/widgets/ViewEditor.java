/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.widgets;

import java.util.List;

import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.modelelement.DataSourceFactory;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.runtime.DataSource;
import org.eclipse.papyrus.properties.runtime.DefaultDisplayEngine;
import org.eclipse.papyrus.properties.runtime.DisplayEngine;
import org.eclipse.papyrus.widgets.editors.AbstractEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Warning : the view's sections will be displayed in the
 * tab of the caller (The sections' tabs will be ignored)
 * e.g. if you call the "Association" (UML) view from the
 * SysML tab, the association will be displayed in the SysML
 * tab, although its usual tab is UML
 */
public class ViewEditor extends AbstractPropertyEditor {

	private String viewPath;

	private Composite self;

	public ViewEditor(Composite parent, int style) {
		self = new Composite(parent, SWT.NONE);
		self.setLayout(new GridLayout(1, false));
	}

	@Override
	public void checkInput() {
		if(propertyPath != null && input != null && viewPath != null) {
			display();
		}
	}

	public void setNumColumns(int numColumns) {
		((GridLayout)self.getLayout()).numColumns = numColumns;
	}

	public int getNumColumns() {
		return ((GridLayout)self.getLayout()).numColumns;
	}

	public void setView(String viewPath) {
		this.viewPath = viewPath;
		checkInput();
	}

	public String getView() {
		return viewPath;
	}

	private View resolveView() {
		String contextName = viewPath.substring(0, viewPath.indexOf(":")); //$NON-NLS-1$
		String viewName = viewPath.substring(viewPath.indexOf(":") + 1); //$NON-NLS-1$
		Context context = ConfigurationManager.instance.getContext(contextName);
		for(View view : context.getViews()) {
			if(view.getName().equals(viewName)) {
				return view;
			}
		}
		return null;
	}

	private void display() {
		ModelElement element = input.getModelElement(propertyPath);
		View view = resolveView();
		if(view == null) {
			Activator.log.warn("Unabled to resolve view : " + viewPath); //$NON-NLS-1$
			return;
		}
		List<DataSource> sources = DataSourceFactory.instance.createSubDataSource(element, view, input, getLocalPropertyPath());

		DisplayEngine display = new DefaultDisplayEngine(true);

		for(DataSource source : sources) {
			for(Section section : view.getSections()) {
				display.createSection(self, section, source);
			}
		}

		updateControls();
	}

	protected void updateControls() {
		for(Control container : self.getChildren()) {
			if(container instanceof Composite) {
				for(Control control : ((Composite)container).getChildren()) {
					if(control instanceof AbstractEditor) {
						AbstractEditor editor = (AbstractEditor)control;
						editor.setReadOnly(getReadOnly() || editor.isReadOnly());
					}
				}
			}
		}

		self.setEnabled(!getReadOnly());
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly);
		updateControls();
	}

	@Override
	protected void doBinding() {
		//Nothing to do here
	}
}
