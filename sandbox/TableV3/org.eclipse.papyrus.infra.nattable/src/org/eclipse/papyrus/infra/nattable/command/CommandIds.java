/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.command;


public class CommandIds {

	private CommandIds() {
		//to prevent instanciation
	}


	public static final String TOGGLE_STATE = "org.eclipse.ui.commands.toggleState"; //$NON-NLS-1$

	public static final String RADIO_STATE = "org.eclipse.ui.commands.radioState"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_DISPLAY_INDEX_ID = "org.eclipse.papyrus.infra.nattable.column.display.index"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_DISPLAY_LABEL_ID = "org.eclipse.papyrus.infra.nattable.column.display.label"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_DISPLAY_INDEX_STYLE_ID = "org.eclipse.papyrus.infra.nattable.column.index.style"; //$NON-NLS-1$

	public static final String COMMAND_ROW_DISPLAY_INDEX_ID = "org.eclipse.papyrus.infra.nattable.row.display.index"; //$NON-NLS-1$

	public static final String COMMAND_ROW_DISPLAY_LABEL_ID = "org.eclipse.papyrus.infra.nattable.row.display.label"; //$NON-NLS-1$

	public static final String COMMAND_ROW_DISPLAY_INDEX_STYLE_ID = "org.eclipse.papyrus.infra.nattable.row.index.style"; //$NON-NLS-1$

}
