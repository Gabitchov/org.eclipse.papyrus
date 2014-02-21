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
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.dialog;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.sdk.core.ICustomizationCommandFactory;
import org.eclipse.emf.facet.custom.sdk.core.ICustomizationCommandFactoryFactory;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;

public abstract class AbstractGetOrCreateCustomizationDialog<T, W extends ICommandWidget>
		extends AbstractGetCustomizationDialog<T, W> {

	private final EditingDomain editingDomain;
	private final ICustomizationCommandFactory customCmdFactory;

	/**
	 * Constructor.
	 * 
	 * @param properties
	 *            properties that parent widget had.
	 */
	public AbstractGetOrCreateCustomizationDialog(
			final IWithResultDialogCallback<T> callback,
			final EditingDomain editingDomain) {
		super(callback);
		this.editingDomain = editingDomain;
		this.customCmdFactory = ICustomizationCommandFactoryFactory.DEFAULT
				.createICustomizationCommandFactory(editingDomain);
	}

	protected final EditingDomain getEditingDomain() {
		return this.editingDomain;
	}

	protected final ICustomizationCommandFactory getCustomCmdFactory() {
		return this.customCmdFactory;
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
