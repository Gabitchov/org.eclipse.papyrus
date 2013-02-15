/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.editor.AbstractEMFNattableEditor;
import org.eclipse.papyrus.infra.nattable.common.messages.Messages;
import org.eclipse.ui.IEditorPart;


public abstract class AbstractTableHandler extends AbstractHandler {

	protected IEditorPart getCurrentTableEditor(final ExecutionEvent event) {
		try {
			return ServiceUtilsForHandlers.getInstance().getNestedActiveIEditorPart(event);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.AbstractTableHandler_CurrentEditorCantBeFound, e);
		}
		return null;
	}

	protected NatTable getCurrentNattable(final ExecutionEvent event) {
		final AbstractEMFNattableEditor editor = (AbstractEMFNattableEditor)getCurrentTableEditor(event);
		if(editor != null) {
			return (NatTable)editor.getAdapter(NatTable.class);
		}
		return null;

	}
}
