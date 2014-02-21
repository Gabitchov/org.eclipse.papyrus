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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.facet.util.emf.ui.util.EditingUtil;
import org.eclipse.emf.facet.util.ui.internal.exported.util.dialog.AbstractDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;

public abstract class AbstractCommandDialog<T extends Object, W extends ICommandWidget>
		extends AbstractDialog<T, W> {

	/**
	 * Constructor.
	 * 
	 * @param properties
	 *            properties that parent widget had.
	 */
	public AbstractCommandDialog(final T callback) {
		super(callback);
	}

	@Override
	protected void execute() {
		final Object result = getWidget().getCommand();
		if (result instanceof Command) {
			final Command command = (Command) result;
			EditingUtil.getEditingDomain().getCommandStack().execute(command);
		}
	}
}
