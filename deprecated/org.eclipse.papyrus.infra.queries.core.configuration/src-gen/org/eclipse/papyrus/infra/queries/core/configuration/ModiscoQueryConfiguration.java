/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.queries.core.configuration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.facet.infra.query.ModelQuery;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modisco Query Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration#getParameterValues <em>Parameter Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage#getModiscoQueryConfiguration()
 * @model
 * @generated
 */
public interface ModiscoQueryConfiguration extends QueryConfiguration {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' reference.
	 * @see #setQuery(ModelQuery)
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage#getModiscoQueryConfiguration_Query()
	 * @model required="true"
	 * @generated
	 */
	ModelQuery getQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration#getQuery <em>Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' reference.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(ModelQuery value);

	/**
	 * Returns the value of the '<em><b>Parameter Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.queries.core.configuration.ParameterValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Values</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage#getModiscoQueryConfiguration_ParameterValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterValue> getParameterValues();

} // ModiscoQueryConfiguration
