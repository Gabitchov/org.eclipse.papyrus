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
package org.eclipse.papyrus.views.properties.widgets;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.tools.databinding.MultipleObservableValue;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.runtime.DefaultDisplayEngine;
import org.eclipse.papyrus.views.properties.runtime.DisplayEngine;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.papyrus.views.properties.xwt.XWTSection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * An Editor for displaying a whole property {@link View} on a sub-object.
 * If the property is a list, there will be one view per element in the list.
 * 
 * The view's tabs will be ignored : the sections are embedded in the caller's
 * tab.
 */
public class ViewEditor extends AbstractPropertyEditor {

	private String viewPath;

	private Composite self;

	private Collection<XWTSection> sections;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public ViewEditor(Composite parent, int style) {
		self = new Composite(parent, SWT.NONE);
		PropertiesLayout layout = new PropertiesLayout(1, true);
		layout.horizontalSpacing = 0;
		layout.marginWidth = 0;
		self.setLayout(layout);
	}

	@Override
	public void checkInput() {
		if(propertyPath != null && input != null && viewPath != null) {
			display();
		}
	}

	/**
	 * Sets the number of columns for this editor. If the property is a list,
	 * there will be one view per element in the list : these views will be
	 * distributed in the given number of columns.
	 * 
	 * @param numColumns
	 */
	public void setNumColumns(int numColumns) {
		((PropertiesLayout)self.getLayout()).numColumns = numColumns;
	}

	/**
	 * @return the number of columns for this editor.
	 */
	public int getNumColumns() {
		return ((PropertiesLayout)self.getLayout()).numColumns;
	}

	/**
	 * Sets the view for this editor. The view is represented by its viewPath, which is
	 * of form ContextName:ViewName
	 * e.g. : UML:Class
	 * The Context should be registered in the ConfigurationManager
	 * 
	 * @param viewPath
	 *        The path of the view used to display the given property
	 */
	public void setView(String viewPath) {
		this.viewPath = viewPath;
		checkInput();
	}

	/**
	 * @return the qualified name of the view associated to this editor
	 */
	public String getView() {
		return viewPath;
	}

	private View resolveView() {
		String contextName = viewPath.substring(0, viewPath.indexOf(":")); //$NON-NLS-1$
		String viewName = viewPath.substring(viewPath.indexOf(":") + 1); //$NON-NLS-1$
		Context context = ConfigurationManager.getInstance().getContext(contextName);
		for(View view : context.getViews()) {
			if(view.getName().equals(viewName)) {
				return view;
			}
		}
		return null;
	}

	private void display() {
		View view = resolveView();

		if(view == null) {
			Activator.log.warn("Unabled to resolve view : " + viewPath); //$NON-NLS-1$
			return;
		}

		IObservable observable = getInputObservable();
		if(observable == null) {
			return;
		}

		DisplayEngine display = new DefaultDisplayEngine(true);

		sections = new LinkedList<XWTSection>();

		if(observable instanceof IObservableValue) {
			IObservableValue observableValue = (IObservableValue)observable;
			if(observableValue instanceof MultipleObservableValue) {
				MultipleObservableValue multipleObservable = (MultipleObservableValue)observableValue;
				display(display, multipleObservable.getObservedValues(), view);
			} else {
				Object value = observableValue.getValue();
				display(display, value, view);
			}
		} else if(observable instanceof IObservableList) {
			IObservableList observableList = (IObservableList)observable;
			for(Object value : observableList) {
				display(display, value, view);
			}
		}

		updateControls();
	}

	/**
	 * Displays the given view in the display engine, with the given object.
	 * 
	 * @param display
	 *        The Display engine used to display the view. It should allow duplication,
	 *        as for list properties, the same section will be displayed for each element
	 *        in the list.
	 * @param data
	 *        The raw object for which we are displaying the view.
	 * @param view
	 *        The view to display
	 */
	protected void display(DisplayEngine display, Object data, View view) {
		display(display, Collections.singletonList(data), view);
	}

	/**
	 * Displays the given view in the display engine, with the given object.
	 * 
	 * @param display
	 *        The Display engine used to display the view. It should allow duplication,
	 *        as for list properties, the same section will be displayed for each element
	 *        in the list.
	 * @param selectedElements
	 *        The list of objects for which we are displaying the view
	 * @param view
	 *        The view to display
	 */
	protected void display(DisplayEngine display, List<Object> selectedElements, View view) {
		for(Section section : view.getSections()) {
			XWTSection xwtSection = new XWTSection(section, view, display);
			sections.add(xwtSection);

			ISelection selection = new StructuredSelection(selectedElements);

			xwtSection.createControls(new Composite(self, SWT.NONE), null);
			xwtSection.setInput(null, selection);
			xwtSection.refresh();
		}
	}

	/**
	 * Updates the displayed widgets to mark them as readOnly if needed.
	 */
	protected void updateControls() {
		for(Control container : self.getChildren()) {
			//TODO : Browse recursively ?
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
	protected IObservable getInputObservable() {
		//Override the generic behavior: ViewEditor doesn't rely on an AbstractEditor
		return input.getObservable(propertyPath);
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

	@Override
	public Control getControl() {
		return self;
	}
}
