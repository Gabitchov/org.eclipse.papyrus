/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 *  	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 *  
 */
package org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;

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
 * @see org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQueryFactory
 * @model kind="package"
 * @generated
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface JavaQueryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "javaquery"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/query/java/0.2.incubation/javaquery"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "javaQuery"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavaQueryPackage eINSTANCE = org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.impl.JavaQueryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.impl.JavaQueryImpl <em>Java Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.impl.JavaQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.impl.JavaQueryPackageImpl#getJavaQuery()
	 * @generated
	 */
	int JAVA_QUERY = 0;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Implementation Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__IMPLEMENTATION_CLASS_NAME = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQuery <em>Java Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQuery
	 * @generated
	 */
	EClass getJavaQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQuery#getImplementationClassName <em>Implementation Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class Name</em>'.
	 * @see org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQuery#getImplementationClassName()
	 * @see #getJavaQuery()
	 * @generated
	 */
	EAttribute getJavaQuery_ImplementationClassName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavaQueryFactory getJavaQueryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.impl.JavaQueryImpl <em>Java Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.impl.JavaQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.impl.JavaQueryPackageImpl#getJavaQuery()
		 * @generated
		 */
		EClass JAVA_QUERY = eINSTANCE.getJavaQuery();

		/**
		 * The meta object literal for the '<em><b>Implementation Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_QUERY__IMPLEMENTATION_CLASS_NAME = eINSTANCE.getJavaQuery_ImplementationClassName();

	}

} //JavaQueryPackage
