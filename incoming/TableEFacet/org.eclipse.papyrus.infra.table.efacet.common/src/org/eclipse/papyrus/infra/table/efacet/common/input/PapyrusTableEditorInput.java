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
package org.eclipse.papyrus.infra.table.efacet.common.input;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * Comes from org.eclipse.emf.facet.widget.nattable.workbench.
 * 
 * This class should not be used by others plugins
 */
public class PapyrusTableEditorInput implements IEditorInput {

	/** The input for the Table widget */
	private final PapyrusTable papyrusTable;

	/** A textual description of what is shown in the editor */
	private final String description;

	private final EditingDomain editingDomain;

	public PapyrusTableEditorInput(final PapyrusTable papyrusTable, final EditingDomain editingDomain) {
		this.papyrusTable = papyrusTable;
		this.description = papyrusTable.getTable().getDescription();
		this.editingDomain = editingDomain;
	}

	public PapyrusTable getPapyrusTable() {
		return this.papyrusTable;
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
		return "PapyrusTable Model"; //$NON-NLS-1$
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return "PapyrusTable Model"; //$NON-NLS-1$
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") final Class adapter) {
		return null;
	}

	public EditingDomain getEditingDomain() {
		return this.editingDomain;
	}
}
