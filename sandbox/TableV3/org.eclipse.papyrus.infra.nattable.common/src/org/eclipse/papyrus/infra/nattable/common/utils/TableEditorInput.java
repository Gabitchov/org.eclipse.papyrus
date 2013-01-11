/*******************************************************************************
 * Copyright (c) 2009, 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 331203 - table model editor - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 332924 - To be able to save the table
 *    Nicolas Guyomar (Mia-Software) - Bug 333029 - To be able to save the size of the lines and the columns
 *******************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.utils;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * Comes from org.eclipse.emf.facet.widget.nattable.workbench.
 * 
 * This class should not be used by others plugins
 */
public class TableEditorInput implements IEditorInput {

	/** The input for the Table widget */
	private final Table tableInstance;

	/** A textual description of what is shown in the editor */
	private final String description;

	private final EditingDomain editingDomain;

	public TableEditorInput(final Table papyrusTable, final EditingDomain editingDomain) {
		this.tableInstance = papyrusTable;
		this.description = papyrusTable.getDescription();
		this.editingDomain = editingDomain;
	}

	public Table getPapyrusTableInstance() {
		return this.tableInstance;
	}

	public String getDescription() {
		return this.description;
	}

	public boolean exists() {
		return false;
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getName() {
		return "Model Table"; //$NON-NLS-1$
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return "Model Table"; //$NON-NLS-1$
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") final Class adapter) {
		return null;
	}

	protected EditingDomain getEditingDomain() {
		return this.editingDomain;
	}
}
