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
import java.util.Collection;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer;
import org.eclipse.papyrus.cdo.validation.problems.ESeverity;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EProblem</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl#getSeverity
 * <em>Severity</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl#getMessage
 * <em>Message</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl#getSource
 * <em>Source</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl#getCode
 * <em>Code</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl#getElement
 * <em>Element</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl#getRelated
 * <em>Related</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.cdo.validation.problems.impl.EProblemImpl#getContainer
 * <em>Container</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EProblemImpl
		extends CDOObjectImpl
		implements EProblem {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EProblemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProblemsPackage.Literals.EPROBLEM;
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
	public ESeverity getSeverity() {
		return (ESeverity) eGet(ProblemsPackage.Literals.EPROBLEM__SEVERITY,
			true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSeverity(ESeverity newSeverity) {
		eSet(ProblemsPackage.Literals.EPROBLEM__SEVERITY, newSeverity);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getMessage() {
		return (String) eGet(ProblemsPackage.Literals.EPROBLEM__MESSAGE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMessage(String newMessage) {
		eSet(ProblemsPackage.Literals.EPROBLEM__MESSAGE, newMessage);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSource() {
		return (String) eGet(ProblemsPackage.Literals.EPROBLEM__SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSource(String newSource) {
		eSet(ProblemsPackage.Literals.EPROBLEM__SOURCE, newSource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getCode() {
		return (Integer) eGet(ProblemsPackage.Literals.EPROBLEM__CODE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCode(int newCode) {
		eSet(ProblemsPackage.Literals.EPROBLEM__CODE, newCode);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getElement() {
		return (EObject) eGet(ProblemsPackage.Literals.EPROBLEM__ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElement(EObject newElement) {
		eSet(ProblemsPackage.Literals.EPROBLEM__ELEMENT, newElement);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> getRelated() {
		return (EList<EObject>) eGet(
			ProblemsPackage.Literals.EPROBLEM__RELATED, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EProblemsContainer getContainer() {
		return (EProblemsContainer) eGet(
			ProblemsPackage.Literals.EPROBLEM__CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContainer(EProblemsContainer newContainer) {
		eSet(ProblemsPackage.Literals.EPROBLEM__CONTAINER, newContainer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Diagnostic toDiagnostic() {
		Collection<EObject> related = getRelated();
		Object[] data = new Object[1 + related.size()];
		data[0] = getElement();
		if (!related.isEmpty()) {
			System.arraycopy(related.toArray(), 0, data, 1, related.size());
		}
		return new BasicDiagnostic(getSeverity().getValue(), getSource(),
			getCode(), getMessage(), data);
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
			case ProblemsPackage.EPROBLEM___TO_DIAGNOSTIC :
				return toDiagnostic();
		}
		return super.eInvoke(operationID, arguments);
	}

} // EProblemImpl
