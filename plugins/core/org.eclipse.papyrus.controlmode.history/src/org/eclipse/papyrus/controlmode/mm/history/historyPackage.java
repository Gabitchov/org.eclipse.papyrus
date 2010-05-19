/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.controlmode.mm.history;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.controlmode.mm.history.historyFactory
 * @model kind="package"
 * @generated
 */
public interface historyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "history";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/controlmode";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "history";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	historyPackage eINSTANCE = org.eclipse.papyrus.controlmode.mm.history.impl.historyPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.controlmode.mm.history.impl.ControledResourceImpl <em>Controled Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.controlmode.mm.history.impl.ControledResourceImpl
	 * @see org.eclipse.papyrus.controlmode.mm.history.impl.historyPackageImpl#getControledResource()
	 * @generated
	 */
	int CONTROLED_RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLED_RESOURCE__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLED_RESOURCE__PARENT = 1;

	/**
	 * The feature id for the '<em><b>Resource URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLED_RESOURCE__RESOURCE_URL = 2;

	/**
	 * The number of structural features of the '<em>Controled Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLED_RESOURCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.controlmode.mm.history.impl.historyPackageImpl#getString()
	 * @generated
	 */
	int STRING = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.controlmode.mm.history.ControledResource <em>Controled Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Controled Resource</em>'.
	 * @see org.eclipse.papyrus.controlmode.mm.history.ControledResource
	 * @generated
	 */
	EClass getControledResource();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.controlmode.mm.history.ControledResource#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.papyrus.controlmode.mm.history.ControledResource#getChildren()
	 * @see #getControledResource()
	 * @generated
	 */
	EReference getControledResource_Children();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.controlmode.mm.history.ControledResource#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.controlmode.mm.history.ControledResource#getParent()
	 * @see #getControledResource()
	 * @generated
	 */
	EReference getControledResource_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.controlmode.mm.history.ControledResource#getResourceURL <em>Resource URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource URL</em>'.
	 * @see org.eclipse.papyrus.controlmode.mm.history.ControledResource#getResourceURL()
	 * @see #getControledResource()
	 * @generated
	 */
	EAttribute getControledResource_ResourceURL();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	historyFactory gethistoryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.controlmode.mm.history.impl.ControledResourceImpl <em>Controled Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.controlmode.mm.history.impl.ControledResourceImpl
		 * @see org.eclipse.papyrus.controlmode.mm.history.impl.historyPackageImpl#getControledResource()
		 * @generated
		 */
		EClass CONTROLED_RESOURCE = eINSTANCE.getControledResource();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROLED_RESOURCE__CHILDREN = eINSTANCE.getControledResource_Children();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROLED_RESOURCE__PARENT = eINSTANCE.getControledResource_Parent();

		/**
		 * The meta object literal for the '<em><b>Resource URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROLED_RESOURCE__RESOURCE_URL = eINSTANCE.getControledResource_ResourceURL();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.controlmode.mm.history.impl.historyPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

	}

} //historyPackage
