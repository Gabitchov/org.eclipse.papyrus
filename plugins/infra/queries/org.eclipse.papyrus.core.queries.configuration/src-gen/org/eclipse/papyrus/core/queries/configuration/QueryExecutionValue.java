/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.core.queries.configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Execution Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.core.queries.configuration.QueryExecutionValue#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.core.queries.configuration.ConfigurationPackage#getQueryExecutionValue()
 * @model
 * @generated
 */
public interface QueryExecutionValue extends ParameterValue {
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
	 * @see org.eclipse.papyrus.core.queries.configuration.ConfigurationPackage#getQueryExecutionValue_Configuration()
	 * @model required="true"
	 * @generated
	 */
	QueryConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.core.queries.configuration.QueryExecutionValue#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(QueryConfiguration value);

} // QueryExecutionValue
