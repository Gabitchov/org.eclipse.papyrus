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
package org.eclipse.papyrus.cdo.internal.ui.util;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * This is the UIUtil type. Enjoy.
 */
public class UIUtil {

	/**
	 * Not instantiable by clients.
	 */
	private UIUtil() {
		super();
	}

	public static Executor uiSafeExecutor() {
		return UISafeExecutor.INSTANCE;
	}

	/**
	 * Posts a runnable to run later on the UI thread, whether the current
	 * thread is the UI or not. In fact, the name "later" suggests that usually
	 * this method is useful in code that is on the UI thread but needs to
	 * ensure that some block runs later, after other events have been
	 * processed.
	 * 
	 * @param runnable
	 *            a block of code to run later
	 */
	public static void later(Runnable runnable) {
		DisplayUtils.getDisplay().asyncExec(runnable);
	}

	/**
	 * Posts a callable that needs access to the UI to run asynchronously on the
	 * specified {@code display} thread.
	 * 
	 * @param display
	 *            the display on which to post a computation asynchronously
	 * @param callable
	 *            a computation to run asynchronously on the UI thread
	 * @return the future result of the {@code callable}
	 */
	public static <T> Future<T> asyncCall(Display display, Callable<T> callable) {
		final FutureTask<T> result = new FutureTask<T>(callable);
		display.asyncExec(result);
		return result;
	}

	/**
	 * A UI-safe execution of a {@code callable} that needs access to the UI. If
	 * the current thread is the UI thread, then the result will be available
	 * immediately. Otherwise, the {@code callable} will be invoked
	 * asynchronously and the result will be available some time later.
	 * 
	 * @param callable
	 *            a computation to run on the UI thread
	 * @return the future result of the {@code callable}
	 */
	public static <T> Future<T> call(Callable<T> callable) {
		final FutureTask<T> result = new FutureTask<T>(callable);

		Display display = Display.getCurrent();
		if (display != null) {
			result.run();
		} else {
			DisplayUtils.getDisplay().asyncExec(result);
		}

		return result;
	}

	/**
	 * <p>
	 * Queries whether the current thread is the UI thread and, if not, posts an
	 * runnable to re-dispatch the calling method asynchronously on the UI
	 * thread.
	 * </p>
	 * <p>
	 * The intended usage pattern is thus:
	 * </p>
	 * 
	 * <pre>
	 *     public void doSomethingToTheUI(Object arg1, String arg2) {
	 *         if (UIUtil.ensureUIThread(this, arg1, arg2) {
	 *             // do stuff here with arg1 and arg2 that requires
	 *             // the UI thread
	 *         }
	 *     }
	 * </pre>
	 * 
	 * @param receiver
	 *            the receiver of the method to be (potentially) re-dispatched.
	 *            This is the object calling the {@code ensureUIThread()}
	 *            utility
	 * @param arguments
	 *            the arguments passed in the method invocation to be
	 *            re-dispatched
	 * 
	 * @return {@code true} if the current thread is the UI thread and the
	 *         calling method may proceed; {@code false} if the method
	 *         invocation was re-dispatched asynchronously and the calling
	 *         method must not proceed
	 */
	public static boolean ensureUIThread(final Object receiver,
			final Object... arguments) {

		final Display display = DisplayUtils.getDisplay();
		boolean result = Display.getCurrent() == display;

		if (!result) {
			// find the calling method and post its invocation asynchronously
			String callingMethodName = null;
			StackTraceElement[] stack = Thread.currentThread().getStackTrace();
			for (int i = 0; i < stack.length; i++) {
				StackTraceElement next = stack[i];
				if (UIUtil.class.getName().equals(next.getClassName())
					&& "ensureUIThread".equals(next.getMethodName())) { //$NON-NLS-1$

					callingMethodName = stack[i + 1].getMethodName();
					break;
				}
			}

			if (callingMethodName == null) {
				throw new IllegalStateException("Invalid stack trace"); //$NON-NLS-1$
			}

			final Method method = findMethod(receiver.getClass(),
				callingMethodName, arguments);
			if (method == null) {
				throw new IllegalStateException("Could not find calling method"); //$NON-NLS-1$
			}

			method.setAccessible(true);

			display.asyncExec(new Runnable() {

				public void run() {
					try {
						method.invoke(receiver, arguments);
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			});
		}

		return result;
	}

	private static Method findMethod(Class<?> owner, String name,
			Object[] arguments) {
		Method result = null;

		Class<?>[] actual = new Class<?>[arguments.length];
		for (int i = 0; i < arguments.length; i++) {
			actual[i] = (arguments[i] == null)
				? null
				: arguments[i].getClass();
		}

		Method[] declared = owner.getDeclaredMethods();
		out : for (int i = 0; i < declared.length; i++) {
			Method next = declared[i];
			if (name.equals(next.getName())) {
				Class<?>[] parameters = next.getParameterTypes();

				for (int j = 0; j < parameters.length; j++) {
					if ((actual[j] != null)
						&& !parameters[j].isAssignableFrom(actual[j])) {
						continue out;
					}
				}

				result = next;
				break out;
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private static final class UISafeExecutor
			implements Executor {

		static final UISafeExecutor INSTANCE = new UISafeExecutor();

		public void execute(Runnable command) {
			Display workbenchDisplay = PlatformUI.getWorkbench().getDisplay();
			if (Display.getCurrent() == workbenchDisplay) {
				command.run();
			} else {
				workbenchDisplay.asyncExec(command);
			}
		}
	}
}
