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
package org.eclipse.papyrus.cdo.validation.problems;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>EProblem</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Description of a problem in some element of an EMF-based model instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getRelated <em>Related</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface EProblem extends CDOObject {

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute. The
	 * literals are from the enumeration
	 * {@link org.eclipse.papyrus.cdo.validation.problems.ESeverity}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.papyrus.cdo.validation.problems.ESeverity
	 * @see #setSeverity(ESeverity)
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Severity()
	 * @model required="true"
	 * @generated
	 */
	ESeverity getSeverity();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getSeverity
	 * <em>Severity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.papyrus.cdo.validation.problems.ESeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ESeverity value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Message()
	 * @model required="true"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getMessage
	 * <em>Message</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Source()
	 * @model required="true"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getSource
	 * <em>Source</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(int)
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Code()
	 * @model
	 * @generated
	 */
	int getCode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(int value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
	 * element that manifests the problem. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Element()
	 * @model required="true"
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getElement
	 * <em>Element</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Related</b></em>' reference list. The
	 * list contents are of type {@link org.eclipse.emf.ecore.EObject}. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Other
	 * model elements contributing to or otherwise related to the problem. May
	 * be, but not necessarily derived from, the 'data' list of an Ecore
	 * Diagnostic. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Related</em>' reference list.
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Related()
	 * @model
	 * @generated
	 */
	EList<EObject> getRelated();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getProblems <em>Problems</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(EProblemsContainer)
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Container()
	 * @see org.eclipse.papyrus.cdo.validation.problems.EProblemsContainer#getProblems
	 * @model opposite="problems" transient="false"
	 * @generated
	 */
	EProblemsContainer getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(EProblemsContainer value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"org.eclipse.emf.ecore.diagnostic"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional identifier of a problem type.  This should correspond to a marker type registered on the Eclipse {@code org.eclipse.core.resources.markers} extension point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Type()
	 * @model default="org.eclipse.emf.ecore.diagnostic"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.cdo.validation.problems.EProblem#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' map.
	 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage#getEProblem_Attributes()
	 * @model mapType="org.eclipse.papyrus.cdo.validation.problems.Attribute<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getAttributes();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.cdo.validation.problems.EDiagnostic" required="true"
	 * @generated
	 */
	Diagnostic toDiagnostic();

} // EProblem
