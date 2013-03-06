/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.cdo.validation.problems.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EProblems Container</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemsContainerImpl#getProblems
 * <em>Problems</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemsContainerImpl#getSubjects
 * <em>Subjects</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemsContainerImpl#getSubcontainers
 * <em>Subcontainers</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemsContainerImpl#getContainer
 * <em>Container</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EProblemsContainerImpl
		extends CDOObjectImpl
		implements EProblemsContainer {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EProblemsContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProblemsPackage.Literals.EPROBLEMS_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EProblem> getProblems() {
		return (EList<EProblem>) eGet(
			ProblemsPackage.Literals.EPROBLEMS_CONTAINER__PROBLEMS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> getSubjects() {
		return (EList<EObject>) eGet(
			ProblemsPackage.Literals.EPROBLEMS_CONTAINER__SUBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EProblemsContainer> getSubcontainers() {
		return (EList<EProblemsContainer>) eGet(
			ProblemsPackage.Literals.EPROBLEMS_CONTAINER__SUBCONTAINERS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EProblemsContainer getContainer() {
		return (EProblemsContainer) eGet(
			ProblemsPackage.Literals.EPROBLEMS_CONTAINER__CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContainer(EProblemsContainer newContainer) {
		eSet(ProblemsPackage.Literals.EPROBLEMS_CONTAINER__CONTAINER,
			newContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Iterator<EProblem> allProblems() {
		return new EProblemsIterator(eAllContents());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Iterator<EProblem> allProblems(final EObject element) {
		return new EProblemsIterator(eAllContents()) {

			@Override
			protected boolean accept(EProblem problem) {
				return problem.getElement() == element;
			}
		};
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Diagnostic> allDiagnostics() {
		List<Diagnostic> result = new java.util.ArrayList<Diagnostic>();

		for (Iterator<EProblem> allProblems = allProblems(); allProblems
			.hasNext();) {
			result.add(allProblems.next().toDiagnostic());
		}

		return new BasicEList.UnmodifiableEList<Diagnostic>(result.size(),
			result.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Diagnostic> allDiagnostics(EObject element) {
		List<Diagnostic> result = new java.util.ArrayList<Diagnostic>();

		for (Iterator<EProblem> allProblems = allProblems(element); allProblems
			.hasNext();) {
			result.add(allProblems.next().toDiagnostic());
		}

		return new BasicEList.UnmodifiableEList<Diagnostic>(result.size(),
			result.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EProblem getWorstProblem(EObject element) {
		EProblem result = null;

		for (Iterator<EProblem> problems = allProblems(element); problems
			.hasNext();) {
			EProblem next = problems.next();
			if (result == null) {
				result = next;
			} else if (next.getSeverity().compareTo(result.getSeverity()) > 0) {
				result = next;
			}
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
			case ProblemsPackage.EPROBLEMS_CONTAINER___ALL_PROBLEMS :
				return allProblems();
			case ProblemsPackage.EPROBLEMS_CONTAINER___ALL_PROBLEMS__EOBJECT :
				return allProblems((EObject) arguments.get(0));
			case ProblemsPackage.EPROBLEMS_CONTAINER___ALL_DIAGNOSTICS :
				return allDiagnostics();
			case ProblemsPackage.EPROBLEMS_CONTAINER___ALL_DIAGNOSTICS__EOBJECT :
				return allDiagnostics((EObject) arguments.get(0));
			case ProblemsPackage.EPROBLEMS_CONTAINER___GET_WORST_PROBLEM__EOBJECT :
				return getWorstProblem((EObject) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	private static class EProblemsIterator
			implements Iterator<EProblem> {

		private final Iterator<?> delegate;

		private EProblem preparedNext;

		public EProblemsIterator(Iterator<?> delegate) {
			this.delegate = delegate;
		}

		public boolean hasNext() {
			if (preparedNext == null) {
				while (delegate.hasNext()) {
					Object next = delegate.next();
					if (next instanceof EProblem) {
						EProblem problem = (EProblem) next;
						if (accept(problem)) {
							preparedNext = problem;
							break;
						}
					}
				}
			}

			return preparedNext != null;
		}

		protected boolean accept(EProblem problem) {
			return true;
		}

		public EProblem next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			EProblem result = preparedNext;
			preparedNext = null;
			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException("remove");
		}
	}

} // EProblemsContainerImpl
