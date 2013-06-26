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

/**
 * This class references the ids of the commands declared for tables
 * 
 * @author vl222926
 * 
 */
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

	public static final String COMMAND_COLUMN_LABEL_DISPLAY_ICON = "org.eclipse.papyrus.infra.nattable.column.label.display.icon"; //$NON-NLS-1$

	public static final String COMMAND_ROW_LABEL_DISPLAY_ICON = "org.eclipse.papyrus.infra.nattable.row.label.display.icon"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_LABEL_DISPLAY_LABEL = "org.eclipse.papyrus.infra.nattable.column.label.display.label"; //$NON-NLS-1$

	public static final String COMMAND_ROW_LABEL_DISPLAY_LABEL = "org.eclipse.papyrus.infra.nattable.row.label.display.label"; //$NON-NLS-1$

	public static final String COMMAND_ROW_LABEL_FEATURE_DISPLAY_IS_DERIVED = "org.eclipse.papyrus.infra.nattable.row.label.feature.display.isderived"; //$NON-NLS-1$

	public static final String COMMAND_ROW_LABEL_FEATURE_DISPLAY_MULTIPLICITY = "org.eclipse.papyrus.infra.nattable.row.label.feature.display.multiplicity"; //$NON-NLS-1$

	public static final String COMMAND_ROW_LABEL_FEATURE_DISPLAY_TYPE = "org.eclipse.papyrus.infra.nattable.row.label.feature.display.type"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_IS_DERIVED = "org.eclipse.papyrus.infra.nattable.column.label.feature.display.isderived"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_MULTIPLICITY = "org.eclipse.papyrus.infra.nattable.column.label.feature.display.multiplicity"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_TYPE = "org.eclipse.papyrus.infra.nattable.column.label.feature.display.type"; //$NON-NLS-1$

	public static final String COMMAND_ROW_LABEL_FEATURE_DISPLAY_NAME = "org.eclipse.papyrus.infra.nattable.row.label.feature.display.name"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_NAME = "org.eclipse.papyrus.infra.nattable.column.label.feature.display.name"; //$NON-NLS-1$

	public static final String COMMAND_ROW_DISCONNECT_SLAVE = "org.eclipse.papyrus.infra.nattable.row.disconnect.slave"; //$NON-NLS-1$

	public static final String COMMAND_COLUMN_DISCONNECT_SLAVE = "org.eclipse.papyrus.infra.nattable.column.disconnect.slave"; //$NON-NLS-1$

	public static final String COMMAND_INVERT_AXIS = "org.eclipse.papyrus.infra.nattable.invert.axis"; //$NON-NLS-1$

}
