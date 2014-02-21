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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command;

import org.eclipse.core.commands.Command;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.AbstractDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.AbstractMainDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.WidgetProperties;
import org.eclipse.swt.widgets.Composite;

/**
 * This abstract class provides all the necessary methods for the creation of a
 * widget. The widget must return a {@link Command} (with the method
 * {@link #getCommand()}) that will be executed when the "ok" button of the
 * dialog will be pressed.</p>
 * 
 * The widget have to get all the necessary properties for the creation of the
 * element (with the command). To get all the properties, the widget have to add
 * all the subwidgets he needs for the edition of the command. Each subwidget
 * {@link AbstractWidget} will edit a specific property of the
 * {@link WidgetProperties}.
 * 
 * @since 0.3
 */
public abstract class AbstractCommandWidget extends AbstractWidget implements ICommandWidget {

	/**
	 * Constructor. Initialize the {@link IFacetCommandFactory} for the creation
	 * of the command.
	 * 
	 * @param parent
	 *            the parent {@link AbstractDialog} of this widget.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param properties
	 *            The {@link WidgetProperties} provided by the
	 *            {@link AbstractMainDialog} that the widget had to edit.
	 */
	public AbstractCommandWidget(final Composite parent) {
		super(parent);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget#getCommand()
	 */
	public abstract Object getCommand();

	@Override
	public String getError() {
		String result = null;
		for (final IAbstractWidget widgets : this.getSubWidgets()) {
			final String error = widgets.getError();
			if (error != null) {
				result = error;
				break;
			}
		}
		return result;
	}


	public abstract void onDialogValidation();
	
	public <A> A adapt(final Class<A> adapterType) {
		A result = null;
		if (adapterType.isInstance(this)) {
			@SuppressWarnings("unchecked")
			final A adapted = (A) this;
			result = adapted;
		}
		return result;
	}

}
