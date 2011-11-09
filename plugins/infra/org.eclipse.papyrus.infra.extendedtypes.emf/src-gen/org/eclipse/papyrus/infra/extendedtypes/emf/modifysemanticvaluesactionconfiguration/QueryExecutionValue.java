/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration;

import org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Execution Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationPackage#getQueryExecutionValue()
 * @model
 * @generated
 */
public interface QueryExecutionValue extends FeatureValue {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' reference.
	 * @see #setConfiguration(QueryConfiguration)
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationPackage#getQueryExecutionValue_Configuration()
	 * @model
	 * @generated
	 */
	QueryConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(QueryConfiguration value);

} // QueryExecutionValue
