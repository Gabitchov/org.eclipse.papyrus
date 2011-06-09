/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.navigator.internal.Activator;
import org.eclipse.swt.widgets.Display;

/**
 * Action used to rename the given diagram
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class RenameDiagramAction extends Action {

	Diagram diagram;

	public RenameDiagramAction(Diagram diagram) {
		this.diagram = diagram;
		setImageDescriptor(Activator.getImageDescriptor("icons/etool16/rename.gif"));
		setText("Rename...");
	}

	/**
	 * Rename the given diagram
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();
		if(editingDomain != null) {
			InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Rename an existing diagram", "New name:", diagram.getName(), null);
			if(dialog.open() == Window.OK) {
				final String name = dialog.getValue();
				if(name != null && name.length() > 0) {

					Command command = new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {
							diagram.setName(name);
						}
					};

					editingDomain.getCommandStack().execute(command);
				}
			}
		}
	}
}
