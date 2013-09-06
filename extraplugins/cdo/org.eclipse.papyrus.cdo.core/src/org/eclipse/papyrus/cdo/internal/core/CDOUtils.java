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

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.getFirst;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.cdo.view.CDOViewSet;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureListIterator;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareTransactionalEditingDomain;
import org.eclipse.papyrus.cdo.core.util.CDOFunctions;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableListIterator;

/**
 * This is the CDOUtils type. Enjoy.
 */
public class CDOUtils {

	private static final Set<String> CDO_URI_SCHEMES = ImmutableSet.of("cdo", "dawn"); //$NON-NLS-1$ //$NON-NLS-2$

	private static Executor broadcastExecutor = new DirectExecutor();

	/**
	 * Not instantiable by clients.
	 */
	private CDOUtils() {
		super();
	}

	public static <T> T adapt(Object object, Class<? extends T> type) {
		T result = null;

		if(type.isInstance(object)) {
			result = type.cast(object);
		} else {
			if(object instanceof IAdaptable) {
				result = type.cast(((IAdaptable)object).getAdapter(type));
			}

			if((result == null) && object instanceof Notifier) {
				result = getFirst(filter(((Notifier)object).eAdapters(), type), null);
			}
		}

		return result;
	}

	public static boolean isCDOURI(URI uri) {
		return CDO_URI_SCHEMES.contains(uri.scheme());
	}

	public static boolean isCDOEditingDomain(EditingDomain domain) {
		return domain instanceof CDOAwareTransactionalEditingDomain;
	}

	public static ResourceSet getResourceSet(Notifier notifier) {
		ResourceSet result = null;

		if(notifier instanceof CDOViewSet) {
			result = ((CDOViewSet)notifier).getResourceSet();
		} else if(notifier instanceof ResourceSet) {
			result = (ResourceSet)notifier;
		} else if(notifier instanceof Resource) {
			result = ((Resource)notifier).getResourceSet();
		} else if(notifier instanceof CDOResourceNode) {
			// folders (resource nodes that aren't resources) are not in a
			// resource set, so get the associated view's resource set
			CDOView view = ((CDOResourceNode)notifier).cdoView();
			if(view != null) {
				result = view.getResourceSet();
			}
		} else if(notifier instanceof EObject) {
			result = getResourceSet(((EObject)notifier).eResource());
		}

		return result;
	}

	public static boolean isCDOObject(EObject object) {
		ResourceSet resourceSet = getResourceSet(object);

		return (resourceSet != null) && (CDOUtil.getViewSet(resourceSet) != null);
	}

	public static CDOObject getCDOObject(EObject object) {
		CDOObject result = null;

		if(isCDOObject(object)) {
			result = CDOUtil.getCDOObject(object);
		}

		return result;
	}

	public static CDOID getCDOID(EObject object) {
		CDOObject cdo = getCDOObject(object);
		return (cdo == null) ? CDOIDUtil.createExternal(EcoreUtil.getURI(object).toString()) : cdo.cdoID();
	}

	public static CDOView getView(ResourceSet resourceSet) {
		CDOView result = null;

		CDOViewSet viewSet = CDOUtil.getViewSet(resourceSet);
		if(viewSet != null) {
			CDOView[] views = viewSet.getViews();
			if(views.length > 0) {
				result = views[0];
			}
		}

		return result;
	}

	public static boolean isLockable(CDOObject object) {
		// transient objects do not have lock states, nor do those that are not
		// in a view or are in a closed view
		CDOView view = object.cdoView();
		return (view != null) && !view.isClosed() && (object.cdoLockState() != null);
	}

	public static boolean isLocked(CDOObject object, boolean remotely) {
		CDOLock lock = isLockable(object) ? object.cdoWriteLock() : null;

		return (lock != null) && (remotely ? lock.isLockedByOthers() : lock.isLocked());
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
		if(cdo != null) {
			if(cdo.cdoConflict()) {
				result = DawnState.CONFLICT;
			} else if(isLocked(cdo, true)) {
				result = DawnState.LOCKED_REMOTELY;
			} else if(isLocked(cdo, false)) {
				result = DawnState.LOCKED_LOCALLY;
			}
		}

		return result;
	}

	public static boolean isReadOnly(CDOObject object) {
		// an object is read-only if somebody else has it locked
		boolean result = CDOUtils.isLocked(object, true);

		// or if the current user doesn't have permission to write it
		if(!result) {
			CDORevision revision = object.cdoRevision();
			result = (revision != null) && !revision.getPermission().isWritable();
		}

		return result;
	}

	public static Iterable<EObject> getEObjects(Iterable<? extends CDOObject> cdoObjects) {
		return Iterables.transform(cdoObjects, CDOFunctions.getEObject());
	}

	public static Iterable<EStructuralFeature.Setting> crossReference(EObject object) {
		Iterable<EStructuralFeature.Setting> result;

		ECrossReferenceAdapter adapter = adapt(object, ECrossReferenceAdapter.class);
		if(adapter != null) {
			result = adapter.getInverseReferences(object);
		} else {
			EObject tree = EcoreUtil.getRootContainer(object);
			Resource resource = tree.eResource();
			ResourceSet rset = (resource == null) ? null : resource.getResourceSet();

			if(rset != null) {
				result = EcoreUtil.UsageCrossReferencer.find(object, rset);
			} else if(resource != null) {
				result = EcoreUtil.UsageCrossReferencer.find(object, resource);
			} else {
				result = EcoreUtil.UsageCrossReferencer.find(object, tree);
			}
		}

		return result;
	}

	/**
	 * Obtains an unmodifiable iterator over the values in the specified {@code feature} of an {@code object}. The resulting iterator supplies zero
	 * or one element for scalar features, according to whether the feature's value is {@code null} or not. In the case of a scalar feature,
	 * the index of the element as reported by {@link ListIterator#nextIndex()} and {@link ListIterator#previousIndex()} is {@code -1}.
	 * 
	 * @param object
	 *        an object
	 * @param feature
	 *        a feature of the {@code object}
	 * @param resolve
	 *        whether to resolve proxies (in the case of an {@link EReference}
	 * 
	 * @return the unmodifiable feature list iterator
	 */
	public static <E> FeatureListIterator<E> iterator(EObject object, final EStructuralFeature feature, boolean resolve) {
		FeatureListIterator<E> result;

		Object value = object.eGet(feature, resolve);
		if(value instanceof InternalEList<?>) {
			@SuppressWarnings("unchecked")
			InternalEList<E> list = (InternalEList<E>)value;
			final ListIterator<E> delegate = (resolve) ? list.listIterator() : list.basicListIterator();

			class NonEmpty extends UnmodifiableListIterator<E> implements FeatureListIterator<E> {

				public EStructuralFeature feature() {
					return feature;
				}

				public boolean hasNext() {
					return delegate.hasNext();
				}

				public E next() {
					return delegate.next();
				}

				public int nextIndex() {
					return delegate.nextIndex();
				}

				public boolean hasPrevious() {
					return delegate.hasPrevious();
				}

				public E previous() {
					return delegate.previous();
				}

				public int previousIndex() {
					return delegate.previousIndex();
				}
			};

			result = new NonEmpty();
		} else if(value == null) {
			class Empty extends UnmodifiableListIterator<E> implements FeatureListIterator<E> {

				public EStructuralFeature feature() {
					return feature;
				}

				public boolean hasNext() {
					return false;
				}

				public E next() {
					throw new NoSuchElementException();
				}

				public int nextIndex() {
					return -1;
				}

				public boolean hasPrevious() {
					return false;
				}

				public E previous() {
					throw new NoSuchElementException();
				}

				public int previousIndex() {
					return -2;
				}
			};

			result = new Empty();
		} else {
			@SuppressWarnings("unchecked")
			final E onlyValue = (E)value;

			class Singleton extends UnmodifiableListIterator<E> implements FeatureListIterator<E> {

				private int index = -1;

				public EStructuralFeature feature() {
					return feature;
				}

				public boolean hasNext() {
					return index < 0;
				}

				public E next() {
					if(!hasNext()) {
						throw new NoSuchElementException();
					}
					index++;
					return onlyValue;
				}

				public int nextIndex() {
					return index;
				}

				public boolean hasPrevious() {
					return index == 0;
				}

				public E previous() {
					if(!hasPrevious()) {
						throw new NoSuchElementException();
					}
					index--;
					return onlyValue;
				}

				public int previousIndex() {
					return index - 1;
				}
			};

			result = new Singleton();
		}

		return result;
	}

	/**
	 * <p>
	 * Runs a code block that broadcasts notification of {@link ResourceSetChangeEvent}s, {@link CDOViewInvalidationEvent}s, etc. to listeners using
	 * the most appropriate {@linkplain #setBroadcastExecutor() executor} available. This allows a UI-safe execution to be injected if necessary.
	 * </p>
	 * <p>
	 * <strong>Note</strong> that there is no assurance that this block will be executed either synchronously or asynchronously.
	 * </p>
	 * 
	 * @param broadcastCommand
	 *        the notification command to execute
	 */
	public static void notify(Runnable broadcastCommand) {
		broadcastExecutor.execute(broadcastCommand);
	}

	public static void notify(final TransactionalEditingDomain domain, final Runnable broadcastCommand) {

		broadcastExecutor.execute(new Runnable() {

			public void run() {
				try {
					domain.runExclusive(broadcastCommand);
				} catch (Exception e) {
					Activator.log.error("Exception in execution of notification broadcast.", e); //$NON-NLS-1$
				}
			}
		});
	}

	public static void setBroadcastExecutor(Executor executor) {
		broadcastExecutor = (executor == null) ? new DirectExecutor() : executor;
	}

	//
	// Nested types
	//

	private static final class DirectExecutor implements Executor {

		public void execute(Runnable command) {
			command.run();
		}
	}
}
