/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.storage.actions;


/**
 * This is the AbstractContextStorageActionProvider type. Enjoy.
 */
public abstract class AbstractContextStorageActionProvider implements IContextStorageActionProvider {

	private IContextCopyAction copyAction;

	private IContextEditAction editAction;

	private IContextDeleteAction deleteAction;

	public AbstractContextStorageActionProvider() {
		super();
	}

	public IContextCopyAction getContextCopyAction() {
		if(copyAction == null) {
			copyAction = createContextCopyAction();
		}

		return copyAction;
	}

	protected abstract IContextCopyAction createContextCopyAction();

	public IContextEditAction getContextEditAction() {
		if(editAction == null) {
			editAction = createContextEditAction();
		}

		return editAction;
	}

	protected abstract IContextEditAction createContextEditAction();

	public IContextDeleteAction getContextDeleteAction() {
		if(deleteAction == null) {
			deleteAction = createContextDeleteAction();
		}

		return deleteAction;
	}

	protected abstract IContextDeleteAction createContextDeleteAction();

}
