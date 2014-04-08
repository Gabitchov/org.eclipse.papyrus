/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429826
 *  Christian W. Damus (CEA) - bug 408491
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;


/**
 * This helper can be used to run (safe) transactions outside the CommandStack
 * 
 * @author Camille Letavernier
 * 
 */
public class TransactionHelper extends org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.TransactionHelper {

	//Refactoring needed. The sasheditor contentprovider should have dependencies to infra.EMF...

	public static final String TRANSACTION_OPTION_READ_ONLY_AXIS = "papyrus.read_only_axis"; //$NON-NLS-1$

	public static final String TRANSACTION_OPTION_INTERACTIVE = "papyrus.interactive"; //$NON-NLS-1$

	/**
	 * Merges the read-only {@code axis} option into an existing map of {@code options}.
	 * 
	 * @param options
	 *        an existing (non-{@code null}) options map
	 * @param axis
	 *        the axis option to merge
	 * @return the augmented {@code options}
	 */
	public static Map<String, Object> mergeReadOnlyAxisOption(Map<String, Object> options, ReadOnlyAxis axis) {
		return mergeReadOnlyAxisOption(options, Collections.singleton(axis));
	}

	/**
	 * Merges the read-only {@code axes} option into an existing map of {@code options}.
	 * 
	 * @param options
	 *        an existing (non-{@code null}) options map
	 * @param axes
	 *        the axes option to merge
	 * @return the augmented {@code options}
	 */
	public static Map<String, Object> mergeReadOnlyAxisOption(Map<String, Object> options, Set<ReadOnlyAxis> axes) {
		options.put(TRANSACTION_OPTION_READ_ONLY_AXIS, axes);
		return options;
	}

	/**
	 * Adds the read-only {@code axis} option to a transaction's {@code options}.
	 * 
	 * @param options
	 *        an options map, which may be {@code null} or immutable
	 * @param axis
	 *        the axis option to add
	 * @return a new map based on the {@code options} and including the {@code axis}
	 */
	public static Map<String, Object> addReadOnlyAxisOption(Map<String, ?> options, ReadOnlyAxis axis) {
		return addReadOnlyAxisOption(options, Collections.singleton(axis));
	}

	/**
	 * Adds the read-only {@code axes} option to a transaction's {@code options}.
	 * 
	 * @param options
	 *        an options map, which may be {@code null} or immutable
	 * @param axes
	 *        the axes option to add
	 * @return a new map based on the {@code options} and including the {@code axes}
	 */
	public static Map<String, Object> addReadOnlyAxisOption(Map<String, ?> options, Set<ReadOnlyAxis> axes) {
		Map<String, Object> result = (options == null) ? Maps.<String, Object> newHashMap() : Maps.newHashMap(options);
		result.put(TRANSACTION_OPTION_READ_ONLY_AXIS, axes);
		return result;
	}

	/**
	 * Creates a new mutable transaction options map with a read-only {@code axis}.
	 * 
	 * @param axis
	 *        the axis option
	 * @return a new mutable map including the {@code axis}
	 */
	public static Map<String, Object> readOnlyAxisOption(ReadOnlyAxis axis) {
		return readOnlyAxisOption(Collections.singleton(axis));
	}

	/**
	 * Creates a new mutable transaction options map with a read-only {@code axes}.
	 * 
	 * @param axes
	 *        the axes option
	 * @return a new mutable map including the {@code axes}
	 */
	public static Map<String, Object> readOnlyAxisOption(Set<ReadOnlyAxis> axes) {
		return addReadOnlyAxisOption(null, axes);
	}

	/**
	 * Queries the read-only axes to be enforced by a {@code transaction}.
	 * 
	 * @param transaction
	 *        a transaction
	 * @return its read-only axes, which are {@linkplain ReadOnlyAxis#anyAxis() all of them} by default if the option is absent
	 */
	@SuppressWarnings("unchecked")
	public static Set<ReadOnlyAxis> getReadOnlyAxisOption(Transaction transaction) {
		Set<ReadOnlyAxis> result;

		Object value = transaction.getOptions().get(TRANSACTION_OPTION_READ_ONLY_AXIS);
		if(value instanceof Set<?>) {
			result = (Set<ReadOnlyAxis>)value;
		} else if(value instanceof Iterable<?>) {
			result = Sets.immutableEnumSet((Iterable<ReadOnlyAxis>)value);
		} else {
			result = ReadOnlyAxis.anyAxis();
		}

		return result;
	}

	/**
	 * Merges the {@code interactive} transaction option into an existing map of {@code options}.
	 * 
	 * @param options
	 *        an existing (non-{@code null}) options map
	 * @param interactive
	 *        whether the transaction is in an user-interactive context
	 * @return the augmented {@code options}
	 */
	public static Map<String, Object> mergeInteractiveOption(Map<String, Object> options, boolean interactive) {
		options.put(TRANSACTION_OPTION_INTERACTIVE, interactive);
		return options;
	}

	/**
	 * Adds the {@code interactive} option option to a transaction's {@code options}.
	 * 
	 * @param options
	 *        an options map, which may be {@code null} or immutable
	 * @param interactive
	 *        whether the transaction is in an user-interactive context
	 * @return a new map based on the {@code options} and including the {@code interactive} option
	 */
	public static Map<String, Object> addInteractiveOption(Map<String, ?> options, boolean interactive) {
		Map<String, Object> result = (options == null) ? Maps.<String, Object> newHashMap() : Maps.newHashMap(options);
		result.put(TRANSACTION_OPTION_INTERACTIVE, interactive);
		return result;
	}

	/**
	 * Creates a new mutable transaction options map with an {@code interactive} option.
	 * 
	 * @param interactive
	 *        whether the transaction is in an user-interactive context
	 * @return a new mutable map including the {@code interactive} option
	 */
	public static Map<String, Object> interactiveOption(boolean interactive) {
		return addInteractiveOption(null, interactive);
	}

	/**
	 * Queries whether a {@code transaction} is running in a user-interactive context. In practice, this means that it would be appropriate to
	 * prompt the user to make resources/objects writable if necessary.
	 * 
	 * @param transaction
	 *        a transaction
	 * @return {@code false} if the {@code transaction} has the {@linkplain #TRANSACTION_OPTION_INTERACTIVE interactive option} set {@code false};
	 *         {@code true}, otherwise (including the default case of no option set)
	 */
	public static boolean isInteractive(Transaction transaction) {
		Object value = transaction.getOptions().get(TRANSACTION_OPTION_INTERACTIVE);
		return (value instanceof Boolean) ? (Boolean)value : true;
	}
	
	/**
	 * Create a privileged runnable with progress, which is like a regular {@linkplain TransactionalEditingDomain#createPrivilegedRunnable(Runnable)
	 * privileged runnable} except that it is given a progress monitor for progress reporting.
	 * This enables execution of monitored runnables on the modal-context thread using the transaction borrowed from the UI thread.
	 * 
	 * @param domain
	 *        an editing domain
	 * @param runnable
	 *        a runnable with progress that is to borrow the {@code domain}'s active transaction on the modal context thread
	 * @return the privileged runnable, ready to pass into the progress service or other such API
	 */
	public static IRunnableWithProgress createPrivilegedRunnableWithProgress(TransactionalEditingDomain domain, final IRunnableWithProgress runnable) {
		final IProgressMonitor monitorHolder[] = { null };

		final Runnable privileged = domain.createPrivilegedRunnable(new Runnable() {

			@Override
			public void run() {
				try {
					runnable.run(monitorHolder[0]);
				} catch (Exception e) {
					throw new WrappedException(e);
				}
			}
		});

		return new IRunnableWithProgress() {

			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				monitorHolder[0] = monitor;

				try {
					privileged.run();
				} catch (WrappedException e) {
					Exception unwrapped = e.exception();
					if(unwrapped instanceof InvocationTargetException) {
						throw (InvocationTargetException)unwrapped;
					} else if(unwrapped instanceof InterruptedException) {
						throw (InterruptedException)unwrapped;
					} else {
						throw e;
					}
				}
			}
		};
	}
}
