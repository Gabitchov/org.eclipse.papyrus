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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.diff.internal.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.compare.diff.merge.IMergeListener;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;


public abstract class AbstractFireMergeCommand extends AbstractCommand {

	/**
	 * the list of the listeners
	 */
	private final List<IMergeListener> listeners;

	/**
	 * a list of the diff element
	 */
	private final List<DiffElement> diffs;

	private final DiffElement diffElement;

	public AbstractFireMergeCommand(final DiffElement diffElement, final List<IMergeListener> listeners) {
		this.diffElement = diffElement;
		this.diffs = Collections.emptyList();
		this.listeners = new ArrayList<IMergeListener>(listeners);
	}

	public AbstractFireMergeCommand(final List<DiffElement> diffs, final List<IMergeListener> listeners) {
		this.diffElement = null;
		this.diffs = new ArrayList<DiffElement>(diffs);
		this.listeners = new ArrayList<IMergeListener>(listeners);
	}

	public boolean canRedo() {
		return canExecute();
	}

	public List<IMergeListener> getMergeListeners() {
		return Collections.unmodifiableList(listeners);
	}

	public List<DiffElement> getDiffElementsList() {
		return Collections.unmodifiableList(this.diffs);
	}

	public DiffElement getDiffElement() {
		return this.diffElement;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	public void redo() {
		execute();

	}
}
