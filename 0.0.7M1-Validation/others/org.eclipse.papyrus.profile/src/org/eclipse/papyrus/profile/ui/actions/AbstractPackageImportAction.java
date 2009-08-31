/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.actions;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Package;

/**
 * Abstract command for all package import for registered elements actions
 */
public abstract class AbstractPackageImportAction extends AbstractViewActionDelegate {

	/** current selection */
	protected Package selectedElement;

	/** Editing domain of the viewer given to init() method */
	protected EditingDomain editingDomain;

	/** stored instance of the command */
	protected ChangeCommand command;

	@Override
	public void init(IViewPart view) {
		super.init(view);
		// try to retrieve editing domain
		editingDomain = (EditingDomain) view.getAdapter(EditingDomain.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Package getSelectedElement() {
		return selectedElement;
	}

	/**
	 * Returns <code>true</code> if the element is a Package
	 * 
	 * @param element
	 *            the element to test
	 * @return <code>true</code> if the element is a Package
	 */
	@Override
	protected boolean isSelectableElement(Object element) {
		return (element instanceof Package);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSelectedElement(Object selectedElement) {
		if (selectedElement instanceof Package) {
			this.selectedElement = (Package) selectedElement;
		}
	}

	/**
	 * Returns <code>true</code> if the action can be executed
	 * 
	 * @return <code>true</code> if the action can be executed
	 */
	public boolean canExecute() {
		return getCommand().canExecute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(IAction action) {
		getCommand().execute();
	}

	/**
	 * returns the command that is executed by this action.
	 * 
	 * @param domain
	 *            EMF editing domain used by the command
	 * @return the command that is executed by this action
	 */
	public abstract ChangeCommand getCommand(EditingDomain domain);

	/**
	 * returns the command that is executed by this action.
	 * 
	 * @return the command that is executed by this action
	 */
	public ChangeCommand getCommand() {
		return getCommand(editingDomain);
	}
}