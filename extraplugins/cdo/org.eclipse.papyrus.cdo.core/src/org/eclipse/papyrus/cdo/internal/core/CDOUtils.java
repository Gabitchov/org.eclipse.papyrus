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
package org.eclipse.papyrus.cdo.internal.core;

import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.cdo.view.CDOViewSet;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareTransactionalEditingDomain;

import com.google.common.collect.ImmutableSet;

/**
 * This is the CDOUtils type. Enjoy.
 */
public class CDOUtils {

	private static final Set<String> CDO_URI_SCHEMES = ImmutableSet.of("cdo",
		"dawn");

	private static Executor broadcastExecutor = new DirectExecutor();

	/**
	 * Not instantiable by clients.
	 */
	private CDOUtils() {
		super();
	}

	public static boolean isCDOURI(URI uri) {
		return CDO_URI_SCHEMES.contains(uri.scheme());
	}

	public static boolean isCDOEditingDomain(EditingDomain domain) {
		return domain instanceof CDOAwareTransactionalEditingDomain;
	}

	public static ResourceSet getResourceSet(Notifier notifier) {
		ResourceSet result = null;

		if (notifier instanceof CDOViewSet) {
			result = ((CDOViewSet) notifier).getResourceSet();
		} else if (notifier instanceof ResourceSet) {
			result = (ResourceSet) notifier;
		} else if (notifier instanceof Resource) {
			result = ((Resource) notifier).getResourceSet();
		} else if (notifier instanceof CDOResourceNode) {
			// folders (resource nodes that aren't resources) are not in a
			// resource set, so get the associated view's resource set
			CDOView view = ((CDOResourceNode) notifier).cdoView();
			if (view != null) {
				result = view.getResourceSet();
			}
		} else if (notifier instanceof EObject) {
			result = getResourceSet(((EObject) notifier).eResource());
		}

		return result;
	}

	public static boolean isCDOObject(EObject object) {
		ResourceSet resourceSet = getResourceSet(object);

		return (resourceSet != null)
			&& (CDOUtil.getViewSet(resourceSet) != null);
	}

	public static CDOObject getCDOObject(EObject object) {
		CDOObject result = null;

		if (isCDOObject(object)) {
			result = CDOUtil.getCDOObject(object);
		}

		return result;
	}

	public static boolean isLockable(CDOObject object) {
		// transient objects do not have lock states
		return object.cdoLockState() != null;
	}

	public static boolean isLocked(CDOObject object, boolean remotely) {
		CDOLock lock = isLockable(object)
			? object.cdoWriteLock()
			: null;

		return (lock != null) && (remotely
			? lock.isLockedByOthers()
			: lock.isLocked());
	}

	public static void lock(CDOObject object) {
		object.cdoWriteLock().lock();
	}

	public static void unlock(CDOObject object) {
		object.cdoWriteLock().unlock();
	}

	public static DawnState computeState(EObject object) {
		DawnState result = DawnState.CLEAN;

		CDOObject cdo = getCDOObject(object);
		if (cdo != null) {
			if (cdo.cdoConflict()) {
				result = DawnState.CONFLICT;
			} else if (isLocked(cdo, true)) {
				result = DawnState.LOCKED_REMOTELY;
			} else if (isLocked(cdo, false)) {
				result = DawnState.LOCKED_LOCALLY;
			}
		}

		return result;
	}

	/**
	 * <p>
	 * Runs a code block that broadcasts notification of
	 * {@link ResourceSetChangeEvent}s, {@link CDOViewInvalidationEvent}s, etc.
	 * to listeners using the most appropriate
	 * {@linkplain #setBroadcastExecutor() executor} available. This allows a
	 * UI-safe execution to be injected if necessary.
	 * </p>
	 * <p>
	 * <strong>Note</strong> that there is no assurance that this block will be
	 * executed either synchronously or asynchronously.
	 * </p>
	 * 
	 * @param broadcastCommand
	 *            the notification command to execute
	 */
	public static void notify(Runnable broadcastCommand) {
		broadcastExecutor.execute(broadcastCommand);
	}

	public static void notify(final TransactionalEditingDomain domain,
			final Runnable broadcastCommand) {

		broadcastExecutor.execute(new Runnable() {

			public void run() {
				try {
					domain.runExclusive(broadcastCommand);
				} catch (Exception e) {
					Activator.log.error(
						"Exception in execution of notification broadcast.", e);
				}
			}
		});
	}

	public static void setBroadcastExecutor(Executor executor) {
		broadcastExecutor = (executor == null)
			? new DirectExecutor()
			: executor;
	}

	//
	// Nested types
	//

	private static final class DirectExecutor
			implements Executor {

		public void execute(Runnable command) {
			command.run();
		}
	}
}
