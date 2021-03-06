/**
 */
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPhysicalFactory
 * @model kind="package"
 * @generated
 */
public interface HwPhysicalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HwPhysical";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/HwPhysical/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "HwPhysical";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HwPhysicalPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.impl.HwPhysicalPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.dummy <em>dummy</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.dummy
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.impl.HwPhysicalPackageImpl#getdummy()
	 * @generated
	 */
	int DUMMY = 0;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.dummy <em>dummy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>dummy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.dummy
	 * @generated
	 */
	EEnum getdummy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HwPhysicalFactory getHwPhysicalFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.dummy <em>dummy</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.dummy
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.impl.HwPhysicalPackageImpl#getdummy()
		 * @generated
		 */
		EEnum DUMMY = eINSTANCE.getdummy();

	}

} //HwPhysicalPackage
