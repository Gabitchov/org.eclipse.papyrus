/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Grégoire Dupé (Mia-Software) - Bug 365808 - [Unit Test Failure][0.2/4.2][0.2/3.8] org.eclipse.papyrus.emf.facet.widgets.nattable.tests.NatTableAPITests
 *    Grégoire Dupé (Mia-Software) - Bug 367153 - synchronization utilities
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *    Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync;

import org.eclipse.swt.widgets.Display;

/**
 * <ul>
 * <li>syncExecWithResult (has return type, throws exception)
 * <li>safeSyncExec (has return type, no exception)
 * <li>voidSyncExec (no return type, throws exception)
 * <li>voidExceptionFreeRunnable (no return type, no exception)
 * </ul>
 */
public class SynchronizedObject<O extends Object> {

	private final O object;
	private final Thread widgetThread;
	private final Display display;

	public SynchronizedObject(final O object, final Display display) {
		this.object = object;
		this.display = display;
		this.widgetThread = this.display.getThread();
	}
	
	protected final <T, E extends Exception> T syncExecWithResult(
			final IRunnable<T, E> runnable) throws E {
		T result;
		if (this.widgetThread == Thread.currentThread()) {
			result = runnable.run();
		} else {
			final ExceptionHandler exceptionHandler = new ExceptionHandler();
			final Object[] resultHandler = new Object[1];
			this.display.syncExec(new java.lang.Runnable() {
				public void run() {
					try {
						resultHandler[0] = runnable.run();
					} catch (final Exception e) {
						exceptionHandler.setException(e);
					}

				}
			});
			if (exceptionHandler.getException() != null) {
				@SuppressWarnings("unchecked")
				// @SuppressWarnings("unchecked") This cast is safe because
				// "exceptionHandler" contains an exception thrown by "runnable"
				// and
				// "runnable" throws by definition a instance of E
				final E castException = (E) exceptionHandler.getException();
				throw castException;
			}
			@SuppressWarnings("unchecked")
			// @SuppressWarnings("unchecked") This cast is safe because
			// "resultHandler" contains a value returned by "runnable" and
			// "runnable" returns by definition a instance of T
			final T tmpResult = (T) resultHandler[0];
			result = tmpResult;
		}
		return result;
	}
	
	protected class ExceptionHandler {

		private Exception exception;

		public Exception getException() {
			return this.exception;
		}

		public void setException(final Exception exception) {
			this.exception = exception;
		}
	}

	protected final <E extends Exception> void voidSyncExec(
			final AbstractVoidRunnable<E> runnable) throws E {
		this.syncExecWithResult(runnable);
	}

	protected final <T> T safeSyncExec(
			final AbstractExceptionFreeRunnable<T> runnable) {
		try {
			return this.syncExecWithResult(runnable);
		} catch (final Exception e) {
			throw new DisplaySyncRuntimeException(e);
		}
	}

	protected final void voidExceptionFreeRunnable(
			final AbstractVoidExceptionFreeRunnable runnable) {
		try {
			this.syncExecWithResult(runnable);
		} catch (final Exception e) {
			throw new DisplaySyncRuntimeException(e);
		}
	}
	
	public O getSynchronizedObject() {
		return this.object;
	}

}
