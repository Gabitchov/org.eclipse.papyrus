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
package org.eclipse.papyrus.cdo.validation.problems.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl.EObservableAdapterList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer;
import org.eclipse.papyrus.cdo.validation.problems.ESeverity;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsFactory;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage;
import org.eclipse.papyrus.cdo.validation.problems.internal.ProblemsPlugin;

/**
 * A utility for managing a single {@link EProblemsContainer} containing
 * problems for model elements in a {@link ResourceSet} scope.
 */
public class ProblemsManager {

	private final ManagerAdapter adapter;

	private EProblemsContainer problems;

	private ECrossReferenceAdapter xrefs;

	private ProblemsAdapter problemsAdapter;

	private CopyOnWriteArrayList<ProblemsListener> listeners = new CopyOnWriteArrayList<ProblemsListener>();

	ProblemsManager(Notifier notifier) {
		adapter = new ManagerAdapter();
		notifier.eAdapters().add(adapter);
		((EObservableAdapterList) notifier.eAdapters()).addListener(adapter);

		xrefs = ECrossReferenceAdapter.getCrossReferenceAdapter(notifier);

		problems = ProblemsFactory.eINSTANCE.createEProblemsContainer();
		if (xrefs != null) {
			problems.eAdapters().add(xrefs);
		}

		problemsAdapter = new ProblemsAdapter();
		problems.eAdapters().add(problemsAdapter);
	}

	/**
	 * Gets the problems manager associated with the specified
	 * {@code resourceSet}. If none has been created yet, then it is created and
	 * associated on demand.
	 * 
	 * @param resourceSet
	 *            a resource set
	 * 
	 * @return the {@code resourceSet}'s problems manager (never {@code null})
	 */
	public static ProblemsManager getProblemsManager(ResourceSet resourceSet) {
		ProblemsManager result = null;

		for (Adapter next : resourceSet.eAdapters()) {
			if (next instanceof ManagerAdapter) {
				result = ((ManagerAdapter) next).getManager();
				break;
			}
		}

		if (result == null) {
			result = new ProblemsManager(resourceSet);
		}

		return result;
	}

	/**
	 * Creates a new problems manager on a custom problem class and associates
	 * it with the specified {@code resourceSet}.
	 * 
	 * @param resourceSet
	 *            a resource set
	 * @param customProblemClass
	 *            an {@link EClass} conforming to <tt>EProblem</tt> to create
	 *            instead of the default <tt>EProblem</tt> type
	 * 
	 * @return the new problems manager
	 */
	public static ProblemsManager createProblemsManager(
			ResourceSet resourceSet, EClass customProblemClass) {
		if (customProblemClass == null) {
			throw new IllegalArgumentException("null customProblemClass"); //$NON-NLS-1$
		}

		return new ProblemsManager.Custom(resourceSet, customProblemClass);
	}

	public static IStatus toIStatus(EProblem problem) {
		return new StatusWrapper(problem);
	}

	public EProblem createProblem(Diagnostic diagnostic) {
		EProblem result;
		EObject element = null;

		Iterator<?> data = diagnostic.getData().iterator();
		while (data.hasNext()) {
			Object next = data.next();

			// CDOResources are EObjects
			if ((next instanceof EObject) && !(next instanceof Resource)) {
				element = (EObject) next;
				break;
			}
		}

		if (element == null) {
			// can't create a problem without the element to attach it to
			result = null;
		} else {
			result = createProblem();

			result.setSeverity(ESeverity.get(diagnostic.getSeverity()));
			result.setSource(diagnostic.getSource());
			result.setCode(diagnostic.getCode());
			result.setMessage(diagnostic.getMessage());

			result.setElement(element);
			while (data.hasNext()) {
				Object next = data.next();

				// CDOResources are EObjects
				if ((next instanceof EObject) && !(next instanceof Resource)) {
					result.getRelated().add((EObject) next);
				}
			}
		}

		return result;
	}

	/**
	 * Obtains all of the problems tracked by this problems manager.
	 */
	public Iterator<EProblem> getAllProblems() {
		return problems.allProblems();
	}

	/**
	 * Obtains all of the problems tracked by this problems manager for the
	 * specified {@code eObject}.
	 * 
	 * @param eObject
	 *            an object in the resource set scope for which I track problems
	 */
	public Iterator<EProblem> getAllProblems(EObject eObject) {
		Iterator<EProblem> result;

		if (xrefs == null) {
			result = problems.allProblems(eObject);
		} else {
			result = new EProblemsIterator<EStructuralFeature.Setting>(xrefs
				.getNonNavigableInverseReferences(eObject).iterator()) {

				@Override
				protected EProblem convert(EStructuralFeature.Setting object) {
					return object.getEStructuralFeature() == ProblemsPackage.Literals.EPROBLEM__ELEMENT
						? (EProblem) object.getEObject()
						: null;
				}
			};
		}

		return result;
	}

	/**
	 * Obtains all of the problems tracked by this problems manager for the
	 * objects in the specified {@code resource}.
	 * 
	 * @param resource
	 *            an resource in the resource set scope for which I track
	 *            problems
	 */
	public Iterator<EProblem> getAllProblems(final Resource resource) {
		Iterator<EProblem> result;

		if (xrefs == null) {
			// more efficient to iterate all problems and filter for those whose
			// element is in the resource than to repeat iteration over the
			// problems for each object in the resource
			result = new Iterator<EProblem>() {

				private final Iterator<EProblem> all = getAllProblems();

				private EProblem next;

				public boolean hasNext() {
					if (next == null) {
						while (all.hasNext()) {
							EProblem couldBe = all.next();
							if (couldBe.getElement().eResource() == resource) {
								next = couldBe;
								break;
							}
						}
					}

					return next != null;
				}

				public EProblem next() {
					if (!hasNext()) {
						throw new NoSuchElementException();
					}

					EProblem result = next;
					next = null;
					return result;
				}

				public void remove() {
					throw new UnsupportedOperationException("remove"); //$NON-NLS-1$
				}
			};
		} else {
			// concatenate iterators for all of the proper contents of the
			// resource
			result = new Iterator<EProblem>() {

				private final Iterator<EObject> objects = EcoreUtil
					.getAllProperContents(resource, false);

				private Iterator<EProblem> iterator = Collections
					.<EProblem> emptyList().iterator();

				public boolean hasNext() {
					while (!iterator.hasNext() && objects.hasNext()) {
						iterator = getAllProblems(objects.next());
					}

					return iterator.hasNext();
				}

				public EProblem next() {
					if (!hasNext()) {
						throw new NoSuchElementException();
					}

					return iterator.next();
				}

				public void remove() {
					throw new UnsupportedOperationException("remove"); //$NON-NLS-1$
				}
			};
		}

		return result;
	}

	public boolean addProblem(EProblem problem) {
		return problems.getProblems().add(problem);
	}

	public boolean addDiagnostic(Diagnostic diagnostic) {
		boolean result;

		if (!diagnostic.getChildren().isEmpty()) {
			// add the children
			result = false;
			for (Diagnostic next : diagnostic.getChildren()) {
				result = addDiagnostic(next) || result;
			}
		} else {
			EProblem problem = createProblem(diagnostic);
			result = problem != null && addProblem(problem);
		}

		return result;
	}

	public void purgeProblems(EObject object) {
		purgeProblems(Collections.singleton(object));
	}

	@SuppressWarnings("unchecked")
	public void purgeProblems(Collection<? extends EObject> objects) {
		purgeProblems((Iterator<? extends EObject>) EcoreUtil
			.getAllContents(objects));
	}

	public void purgeProblems(Resource resource) {
		purgeProblems(EcoreUtil.<EObject> getAllProperContents(resource, false));
	}

	public void purgeAllProblems() {
		for (EProblem next : problems.getProblems()) {
			next.eAdapters().clear();
		}
		problems.getProblems().clear();
	}

	/**
	 * Disposes me. I remove any adapters I may have attached to any notifiers
	 * and purge my problems model. After invocation of this method, I can no
	 * longer be used.
	 */
	public void dispose() {
		if (problems != null) {
			problems.eAdapters().clear();
			for (Iterator<EObject> iter = problems.eAllContents(); iter
				.hasNext();) {
				iter.next().eAdapters().clear();
			}

			problems = null;
		}

		Notifier target = adapter.getTarget();
		if (target != null) {
			target.eAdapters().remove(adapter);
		}
		
		listeners.clear();
	}

	protected EProblem createProblem() {
		return ProblemsFactory.eINSTANCE.createEProblem();
	}

	void setCrossReferenceAdapter(ECrossReferenceAdapter adapter) {
		if (adapter != xrefs) {
			if (xrefs != null && problems != null) {
				problems.eAdapters().remove(xrefs);
			}

			xrefs = adapter;

			if (adapter != null && problems != null) {
				problems.eAdapters().add(adapter);
			}
		}
	}

	private void purgeProblems(Iterator<? extends EObject> contents) {
		List<EProblem> toRemove = new java.util.ArrayList<EProblem>();

		while (contents.hasNext()) {
			Iterator<EProblem> problems = getAllProblems(contents.next());
			while (problems.hasNext()) {
				toRemove.add(problems.next());
			}
		}

		for (EProblem next : toRemove) {
			next.eAdapters().clear();
		}
		problems.getProblems().removeAll(toRemove);
	}

	public static void delete(EProblem problem) {
		EcoreUtil.remove(problem);
		problem.setElement(null);
		problem.eAdapters().clear();
	}

	public void addProblemsListener(ProblemsListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeProblemsListener(ProblemsListener listener) {
		listeners.remove(listener);
	}

	protected void fireAdded(EProblem problem) {
		if (!listeners.isEmpty()) {
			ProblemsEvent event = new ProblemsEvent(this, ProblemsEvent.ADDED,
				problem);
			for (ProblemsListener next : listeners) {
				try {
					next.problemAdded(event);
				} catch (Exception e) {
					ProblemsPlugin.INSTANCE.log(e);
				}
			}
		}
	}

	protected void fireRemoved(EProblem problem) {
		if (!listeners.isEmpty()) {
			ProblemsEvent event = new ProblemsEvent(this,
				ProblemsEvent.REMOVED, problem);
			for (ProblemsListener next : listeners) {
				try {
					next.problemRemoved(event);
				} catch (Exception e) {
					ProblemsPlugin.INSTANCE.log(e);
				}
			}
		}
	}

	//
	// Nested types
	//

	static class Custom
			extends ProblemsManager {

		private final EClass customProblemClass;

		public Custom(Notifier notifier, EClass customProblemClass) {
			super(notifier);

			if (!ProblemsPackage.Literals.EPROBLEM
				.isSuperTypeOf(customProblemClass)) {
				throw new IllegalArgumentException(
					"customProblemClass does not conform to EProblem"); //$NON-NLS-1$
			}

			this.customProblemClass = customProblemClass;
		}

		@Override
		protected EProblem createProblem() {
			return (EProblem) EcoreUtil.create(customProblemClass);
		}
	}

	private class ManagerAdapter
			extends AdapterImpl
			implements EObservableAdapterList.Listener {

		ProblemsManager getManager() {
			return ProblemsManager.this;
		}

		@Override
		public void setTarget(Notifier newTarget) {
			super.setTarget(newTarget);

			if (newTarget == null) {
				// we've been unloaded. Unload the problems model
				dispose();
			}
		}

		public void added(Notifier notifier, Adapter adapter) {
			if (adapter instanceof ECrossReferenceAdapter) {
				setCrossReferenceAdapter((ECrossReferenceAdapter) adapter);
			}
		}

		public void removed(Notifier notifier, Adapter adapter) {
			if (adapter instanceof ECrossReferenceAdapter) {
				setCrossReferenceAdapter(null);
			}
		}
	}

	private class ProblemsAdapter
			extends AdapterImpl {

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == ProblemsPackage.Literals.EPROBLEMS_CONTAINER__PROBLEMS) {
				switch (msg.getEventType()) {
					case Notification.ADD :
						fireAdded((EProblem) msg.getNewValue());
						break;
					case Notification.ADD_MANY :
						for (Object next : (Collection<?>) msg.getNewValue()) {
							fireAdded((EProblem) next);
						}
						break;
					case Notification.REMOVE :
						fireRemoved((EProblem) msg.getOldValue());
						break;
					case Notification.REMOVE_MANY :
						for (Object next : (Collection<?>) msg.getOldValue()) {
							fireRemoved((EProblem) next);
						}
						break;
				}
			}
		}
	}

	private static abstract class EProblemsIterator<E>
			implements Iterator<EProblem> {

		private final Iterator<? extends E> delegate;

		private EProblem preparedNext;

		public EProblemsIterator(Iterator<? extends E> delegate) {
			this.delegate = delegate;
		}

		public boolean hasNext() {
			if (preparedNext == null) {
				while (delegate.hasNext()) {
					EProblem problem = convert(delegate.next());
					if (problem != null) {
						preparedNext = problem;
						break;
					}
				}
			}

			return preparedNext != null;
		}

		protected abstract EProblem convert(E object);

		public EProblem next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			EProblem result = preparedNext;
			preparedNext = null;
			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException("remove"); //$NON-NLS-1$
		}
	}

	private static class StatusWrapper
			implements IStatus {

		static final IStatus[] NO_STATUSES = new IStatus[0];

		private final EProblem problem;

		StatusWrapper(EProblem problem) {
			this.problem = problem;
		}

		public IStatus[] getChildren() {
			return NO_STATUSES;
		}

		public int getCode() {
			return problem.getCode();
		}

		public Throwable getException() {
			return null;
		}

		public String getMessage() {
			return problem.getMessage();
		}

		public String getPlugin() {
			return problem.getSource();
		}

		public int getSeverity() {
			return problem.getSeverity().getValue();
		}

		public boolean isMultiStatus() {
			return false;
		}

		public boolean isOK() {
			return getSeverity() == IStatus.OK;
		}

		public boolean matches(int severityMask) {
			return (getSeverity() & severityMask) != 0;
		}
	}
}
