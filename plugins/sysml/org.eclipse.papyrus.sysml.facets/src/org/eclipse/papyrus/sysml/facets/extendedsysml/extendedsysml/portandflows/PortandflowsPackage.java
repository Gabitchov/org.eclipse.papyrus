/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.PortandflowsFactory
 * @model kind="package"
 * @generated
 */
public interface PortandflowsPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "portandflows";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/ExtendedSysML/PortAndFlows";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "PortAndFlows";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	PortandflowsPackage eINSTANCE = org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.impl.PortandflowsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection
	 * <em>NA Flow Port Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection
	 * @see org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.impl.PortandflowsPackageImpl#getNAFlowPortDirection()
	 * @generated
	 */
	int NA_FLOW_PORT_DIRECTION = 0;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection
	 * <em>NA Flow Port Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>NA Flow Port Direction</em>'.
	 * @see org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection
	 * @generated
	 */
	EEnum getNAFlowPortDirection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PortandflowsFactory getPortandflowsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection
		 * <em>NA Flow Port Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection
		 * @see org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.impl.PortandflowsPackageImpl#getNAFlowPortDirection()
		 * @generated
		 */
		EEnum NA_FLOW_PORT_DIRECTION = eINSTANCE.getNAFlowPortDirection();

	}

} //PortandflowsPackage
