/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.runtime.preferences;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.properties.runtime.preferences.PreferencesFactory
 * @model kind="package"
 * @generated
 */
public interface PreferencesPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "preferences";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papryus/properties/preferences";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "pref";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	PreferencesPackage eINSTANCE = org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.runtime.preferences.impl.ContextDescriptorImpl <em>Context Descriptor</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.properties.runtime.preferences.impl.ContextDescriptorImpl
	 * @see org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesPackageImpl#getContextDescriptor()
	 * @generated
	 */
	int CONTEXT_DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Applied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DESCRIPTOR__APPLIED = 1;

	/**
	 * The number of structural features of the '<em>Context Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesImpl <em>Preferences</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesImpl
	 * @see org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesPackageImpl#getPreferences()
	 * @generated
	 */
	int PREFERENCES = 1;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__CONTEXTS = 0;

	/**
	 * The number of structural features of the '<em>Preferences</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor <em>Context Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Context Descriptor</em>'.
	 * @see org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor
	 * @generated
	 */
	EClass getContextDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor#getName()
	 * @see #getContextDescriptor()
	 * @generated
	 */
	EAttribute getContextDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor#isApplied
	 * <em>Applied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Applied</em>'.
	 * @see org.eclipse.papyrus.properties.runtime.preferences.ContextDescriptor#isApplied()
	 * @see #getContextDescriptor()
	 * @generated
	 */
	EAttribute getContextDescriptor_Applied();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.runtime.preferences.Preferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Preferences</em>'.
	 * @see org.eclipse.papyrus.properties.runtime.preferences.Preferences
	 * @generated
	 */
	EClass getPreferences();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.runtime.preferences.Preferences#getContexts
	 * <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.eclipse.papyrus.properties.runtime.preferences.Preferences#getContexts()
	 * @see #getPreferences()
	 * @generated
	 */
	EReference getPreferences_Contexts();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PreferencesFactory getPreferencesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.runtime.preferences.impl.ContextDescriptorImpl
		 * <em>Context Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.properties.runtime.preferences.impl.ContextDescriptorImpl
		 * @see org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesPackageImpl#getContextDescriptor()
		 * @generated
		 */
		EClass CONTEXT_DESCRIPTOR = eINSTANCE.getContextDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONTEXT_DESCRIPTOR__NAME = eINSTANCE.getContextDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Applied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONTEXT_DESCRIPTOR__APPLIED = eINSTANCE.getContextDescriptor_Applied();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesImpl <em>Preferences</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesImpl
		 * @see org.eclipse.papyrus.properties.runtime.preferences.impl.PreferencesPackageImpl#getPreferences()
		 * @generated
		 */
		EClass PREFERENCES = eINSTANCE.getPreferences();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PREFERENCES__CONTEXTS = eINSTANCE.getPreferences_Contexts();

	}

} //PreferencesPackage
