/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.queries.core.configuration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.ModelQueryParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.queries.core.configuration.ParameterValue#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage#getParameterValue()
 * @model abstract="true"
 * @generated
 */
public interface ParameterValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(ModelQueryParameter)
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage#getParameterValue_Parameter()
	 * @model required="true"
	 * @generated
	 */
	ModelQueryParameter getParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.queries.core.configuration.ParameterValue#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(ModelQueryParameter value);

} // ParameterValue
