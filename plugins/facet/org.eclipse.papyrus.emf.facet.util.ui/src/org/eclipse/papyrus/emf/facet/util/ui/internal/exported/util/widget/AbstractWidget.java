/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.AbstractGetPropertyWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.bounds.AbstractGetBoundsWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.widget.metaclass.FilteredElementSelectionWidget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * An abstract class providing the creation of a specific action widget.</p>
 * 
 * The listener provided by the {@link #getWidgetListener()} is applied on the
 * widget and called when the mouse move into the dialog.
 * 
 * @see AbstractCommandWidget
 * @see AbstractGetOrCreateFilteredElementCommandWidget
 * @see FilteredElementSelectionWidget
 * @see SelectSubTypingTypeWidget
 * @see AbstractGetBoundsWidget
 * @see AbstractGetPropertyWidget
 * @see GetQueryWidgetComposite
 * @see SelectQueryTypeWidget
 * @since 0.3
 */
public abstract class AbstractWidget extends Composite implements IAbstractWidget {

	protected static final int VERTICAL_SPACING = 2;
	protected static final int WIDTH_HINT = 110;
	private final Composite widgetParent;
	private final List<IAbstractWidget> subWidgets;
	private final List<IAbstractWidget> listeners;

	/**
	 * The constructor.
	 * 
	 * @param parent
	 *            the parent of the widget.
	 * @param editingDomain
	 *            the editing domain.
	 */
	public AbstractWidget(final Composite parent) {
		super(parent, SWT.NONE);
		this.widgetParent = parent;
		this.subWidgets = new LinkedList<IAbstractWidget>();
		this.setLayout(new GridLayout());
		this.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.listeners = new LinkedList<IAbstractWidget>();
	}

	/**
	 * Add the widget to the list of sub widgets.
	 * 
	 * @param widget
	 *            the widget to add.
	 */
	protected void addSubWidget(final IAbstractWidget widget) {
		this.subWidgets.add(widget);
	}

	/**
	 * This method add all the sub widgets of this widget.
	 * <p/>
	 * Use the method {@link #addSubWidget(AbstractCommandWidget)}
	 */
	protected abstract void addSubWidgets();

	/**
	 * @return the widget parent.
	 */
	protected Composite getWidgetParent() {
		return this.widgetParent;
	}

	/**
	 * Return the string containing the error for this widget.
	 * 
	 * @return null if there is no error. The string containing the error if
	 *         there is an error.
	 */
	public abstract String getError();

	/**
	 * Create the content of the widget (call {@link #addSubWidgets()}) and
	 * sub-widgets.
	 */
	public void createWidgetContent() {
		addSubWidgets();
		for (final IAbstractWidget widget : this.subWidgets) {
			widget.createWidgetContent();
			widget.addListener(this);
		}
	}

	/**
	 * Add the abstractWidget in parameter to the list of listeners of the
	 * widget.
	 * 
	 * @param abstractWidget
	 *            the abstractWidget to listen.
	 */
	public void addListener(final AbstractWidget abstractWidget) {
		// This method is public because PMD doesn't want it to be private...
		// This is due to the fact that this method is used on the method
		// 'createWidgetContent' but it is called on the same object type but
		// not on the same instance. So, programatly, put the method private is
		// correct because the object type is the same that the owner but not on
		// the same instance.
		this.listeners.add(abstractWidget);
	}

	/**
	 * When a modification append, this method is called and the method
	 * {@link #notifyChanged()} is called for each listeners of this widget.
	 */
	protected void fireChanged() {
		for (final IAbstractWidget listener : this.listeners) {
			listener.notifyChanged();
		}
	}

	/**
	 * When a change in a sub-widget append, this method is execute. If no
	 * action has to be done when a modification append, this method has to be
	 * void.
	 */
	public abstract void notifyChanged();

	/**
	 * @return the subWidgets
	 */
	public List<IAbstractWidget> getSubWidgets() {
		return this.subWidgets;
	}

}
