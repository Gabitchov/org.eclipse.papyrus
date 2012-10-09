/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Method Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractMethodInjection#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractMethodInjection()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMethodInjection extends FeatureInjection {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractMethodInjection_Parameters()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ParameterInjection> getParameters();

} // AbstractMethodInjection
