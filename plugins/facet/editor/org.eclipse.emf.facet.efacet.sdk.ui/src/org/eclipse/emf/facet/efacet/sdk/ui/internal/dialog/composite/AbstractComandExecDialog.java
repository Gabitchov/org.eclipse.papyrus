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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.composite;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.dialog.AbstractDialogWithCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;

public abstract class AbstractComandExecDialog<T extends Object, W extends ICommandWidget>
		extends AbstractDialogWithCallback<T, W> {

	private final EditingDomain editingDomain;

	/**
	 * Constructor.
	 * 
	 * @param editingDomain
	 *            the current editing domain
	 * @param properties
	 *            the properties that the widget needs
	 */
	protected AbstractComandExecDialog(
			final IWithResultDialogCallback<T> callback,
			final EditingDomain editingDomain) {
		super(callback);
		this.editingDomain = editingDomain;
	}

	@Override
	protected void execute() {
		final Object result = getWidget().getCommand();
		if (result instanceof Command) {
			final Command command = (Command) result;
			this.editingDomain.getCommandStack().execute(command);
		}
	}
}
