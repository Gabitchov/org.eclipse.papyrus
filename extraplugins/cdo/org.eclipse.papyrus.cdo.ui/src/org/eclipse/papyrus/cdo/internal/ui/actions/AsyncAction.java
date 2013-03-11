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
package org.eclipse.papyrus.cdo.internal.ui.actions;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.google.common.collect.Iterables;

/**
 * This is the AsyncAction type. Enjoy.
 */
public abstract class AsyncAction<T> extends BaseSelectionListenerAction {

	protected final Class<? extends T> type;

	private T selection;

	public AsyncAction(Class<? extends T> type, String text, String icon) {
		this(type, text, Activator.getIcon(icon));
	}

	public AsyncAction(Class<? extends T> type, String text, ImageDescriptor icon) {

		super(text);

		this.type = type;

		setImageDescriptor(icon);
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		this.selection = coerce(selection.getFirstElement());

		return (this.selection != null) && super.updateSelection(selection);
	}

	protected T coerce(Object selection) {
		T result = null;

		if(type.isInstance(selection)) {
			result = type.cast(selection);
		} else if(selection instanceof IAdaptable) {
			result = type.cast(((IAdaptable)selection).getAdapter(type));
		}

		return result;
	}

	@Override
	public void run() {
		if(selection != null) {
			if(gatherInput(selection)) {
				new Job(getText()) {

					{
						setUser(true);
					}

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						try {
							doRun(selection, monitor);
						} catch (CoreException e) {
							return e.getStatus();
						}
						return Status.OK_STATUS;
					}
				}.schedule();
			}
		}
	}

	protected boolean gatherInput(T selection) {
		return true;
	}

	protected static IStatus error(String message, Throwable exception) {
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, exception);
	}

	protected static IStatus wrap(Collection<? extends IStatus> statuses, String summary) {
		IStatus result;

		if(statuses.size() == 1) {
			result = Iterables.getOnlyElement(statuses);
		} else {
			result = new MultiStatus(Activator.PLUGIN_ID, 0, Iterables.toArray(statuses, IStatus.class), summary, null);
		}

		return result;
	}

	protected abstract void doRun(T selection, IProgressMonitor monitor) throws CoreException;
}
