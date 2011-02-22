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
package org.eclipse.papyrus.table.common.internal;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * Comes from org.eclipse.emf.facet.widget.nattable.workbench.
 * 
 * This class should not be used by others plugins
 * TODO Should be deleted or merge with an other classe
 */
public class TableEditorInput implements IEditorInput {

	/** The input for the Table widget */
	private final TableInstance tableInstance;

	/** A textual description of what is shown in the editor */
	private final String description;

	private EditingDomain editingDomain;

	public TableEditorInput(final TableInstance tableInstance, final EditingDomain editingDomain) {
		this.tableInstance = tableInstance;
		this.description = tableInstance.getDescription();
		this.editingDomain = editingDomain;
	}

	public TableInstance getTableInstance() {
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
		return "Model Table";
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return "Model Table";
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") final Class adapter) {
		return null;
	}

	protected EditingDomain getEditingDomain() {
		return this.editingDomain;
	}
}
