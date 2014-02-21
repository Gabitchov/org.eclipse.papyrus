/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Guyomar (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - Bug 334546 - [celleditors] no border on Text field
 *   Gregoire Dupe (Mia-Software) - Bug 339998 - public methods of AbstractCellEditorComposite have to be protected
 *   Nicolas Bros (Mia-Software) - Bug 334539 - [celleditors] change listener 
 *****************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public abstract class AbstractCellEditorComposite<T> extends Composite implements IWidget<T>,
		IWidget2<T> {

	private final List<IListener> commitListeners;
	private final List<IListener> changeListeners;
	@Deprecated
	private final List<Listener> compatibilityCommitListeners;
	private final IValidator defaultValidator = new IValidator() {
		public IStatus validate(final Object object) {
			return Status.OK_STATUS;
		}
	};

	public AbstractCellEditorComposite(final Composite parent) {
		this(parent, SWT.NONE);
	}

	@SuppressWarnings("deprecation") /* backwards-compatibility */
	public AbstractCellEditorComposite(final Composite parent, final int style) {
		super(parent, style);
		this.compatibilityCommitListeners = new ArrayList<Listener>();
		this.commitListeners = new ArrayList<IListener>();
		this.changeListeners = new ArrayList<IListener>();
	}

	/** @deprecated use {@link AbstractCellEditorComposite#addCommitListener(IListener)} */
	@Deprecated
	public void addCommitListener(final Listener listener) {
		synchronized (this.compatibilityCommitListeners) {
			if (!this.compatibilityCommitListeners.contains(listener)) {
				this.compatibilityCommitListeners.add(listener);
			}
		}
	}

	/** @deprecated use {@link AbstractCellEditorComposite#removeCommitListener(IListener)} */
	@Deprecated
	public void removeCommitListener(final Listener listener) {
		synchronized (this.compatibilityCommitListeners) {
			this.compatibilityCommitListeners.remove(listener);
		}
	}

	public void addCommitListener(final IListener listener) {
		synchronized (this.commitListeners) {
			if (!this.commitListeners.contains(listener)) {
				this.commitListeners.add(listener);
			}
		}
	}

	public void removeCommitListener(final IListener listener) {
		synchronized (this.commitListeners) {
			this.commitListeners.remove(listener);
		}
	}

	@SuppressWarnings("deprecation") /* backwards-compatibility */
	protected final void fireCommit() {
		synchronized (this.compatibilityCommitListeners) {
			for (Listener commitListener : new ArrayList<Listener>(
					this.compatibilityCommitListeners)) {
				commitListener.handleEvent(new Event());
			}
		}
		synchronized (this.commitListeners) {
			for (IListener commitListener : new ArrayList<IListener>(this.commitListeners)) {
				commitListener.handleEvent();
			}
		}
	}

	public void addChangeListener(final IListener listener) {
		synchronized (this.changeListeners) {
			if (!this.changeListeners.contains(listener)) {
				this.changeListeners.add(listener);
			}
		}
	}

	public void removeChangeListener(final IListener listener) {
		synchronized (this.changeListeners) {
			this.changeListeners.remove(listener);
		}
	}

	protected final void fireChanged() {
		synchronized (this.changeListeners) {
			for (IListener changeListener : new ArrayList<IListener>(this.changeListeners)) {
				changeListener.handleEvent();
			}
		}
	}

	public IValidator getValidator() {
		// always valid by default
		return this.defaultValidator;
	}

	protected final void close() {
		if (!isDisposed()) {
			getParent().forceFocus();
			dispose();
		}
	}
}
