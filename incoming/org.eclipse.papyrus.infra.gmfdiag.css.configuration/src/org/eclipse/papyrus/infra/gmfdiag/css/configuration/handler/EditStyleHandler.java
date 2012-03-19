/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;


public class EditStyleHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		//TODO
		Shell parentShell = ((Event)event.getTrigger()).widget.getDisplay().getActiveShell();
		MessageDialog.open(MessageDialog.WARNING, parentShell, "Edit style error", "This action is not yet supported", SWT.NONE);
		return null;
	}

}
