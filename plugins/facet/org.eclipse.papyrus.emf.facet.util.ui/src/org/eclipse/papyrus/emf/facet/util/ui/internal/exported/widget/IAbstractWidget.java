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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;

/**
 * 
 * @see AbstractWidget
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IAbstractWidget {

	/**
	 * Add the abstractWidget in parameter to the list of listeners of the
	 * widget.
	 * 
	 * @param abstractWidget
	 *            the abstractWidget to listen.
	 */
	void addListener(final AbstractWidget abstractWidget);

	/**
	 * When a change in a sub-widget append, this method is execute. If no
	 * action has to be done when a modification append, this method has to be
	 * void.
	 */
	void notifyChanged();
	
	/**
	 * Create the content of the widget (call {@link #addSubWidgets()}) and
	 * sub-widgets.
	 */
	void createWidgetContent();
	
	/**
	 * Return the string containing the error for this widget.
	 * 
	 * @return null if there is no error. The string containing the error if
	 *         there is an error.
	 */
	String getError();

}