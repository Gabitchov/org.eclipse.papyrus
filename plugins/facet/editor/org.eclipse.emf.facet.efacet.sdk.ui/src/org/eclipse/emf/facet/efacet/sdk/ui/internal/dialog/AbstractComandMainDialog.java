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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exception.SdkUiRuntimeException;
import org.eclipse.emf.facet.util.core.DebugUtils;
import org.eclipse.emf.facet.util.emf.core.EmfDebugUtils;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.emf.facet.util.ui.internal.exported.util.dialog.AbstractMainDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.osgi.util.NLS;

public abstract class AbstractComandMainDialog<W extends ICommandWidget>
		extends AbstractMainDialog<W> {

	private final EditingDomain editingDomain;

	/**
	 * Constructor.
	 * 
	 * @param editedElement
	 *            the selection in the model (ecore file).
	 * @param editingDomain
	 */
	public AbstractComandMainDialog(final Object editedElement,
			final EditingDomain editingDomain) {
		super(editedElement);
		this.editingDomain = editingDomain;
	}

	@Override
	protected void execute() {
		final Object result = getWidget().getCommand();
		if (result instanceof Command) {
			final Command command = (Command) result;
			DebugUtils.debug(EmfDebugUtils.debugCommand(command));
			if (command.canExecute()) {
				this.editingDomain.getCommandStack().execute(command);
			} else {
				Object widget = getWidget();
				if (widget instanceof SynchronizedObject<?>) {
					final SynchronizedObject<?> syncObject = (SynchronizedObject<?>) widget;
					widget = syncObject.getSynchronizedObject();
				}
				throw new SdkUiRuntimeException(NLS.bind(
						"The command created by {0} is not executable: {1}", //$NON-NLS-1$
						widget.getClass().getName(),
						EmfDebugUtils.debugCommand(command)));
			}
		}
	}

	protected final EditingDomain getEditingDomain() {
		return this.editingDomain;
	}
}
