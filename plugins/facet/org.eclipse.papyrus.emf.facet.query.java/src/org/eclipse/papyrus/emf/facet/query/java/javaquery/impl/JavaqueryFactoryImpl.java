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
 *  
 */
package org.eclipse.papyrus.emf.facet.query.java.javaquery.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaQuery;
import org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaqueryFactory;
import org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaqueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=374198
 */
@Deprecated
public class JavaqueryFactoryImpl extends EFactoryImpl implements JavaqueryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavaqueryFactory init() {
		try {
			JavaqueryFactory theJavaqueryFactory = (JavaqueryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/emf/facet/query/java/0.1.incubation"); //$NON-NLS-1$ 
			if (theJavaqueryFactory != null) {
				return theJavaqueryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JavaqueryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaqueryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(final EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JavaqueryPackage.JAVA_QUERY: return createJavaQuery();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaQuery createJavaQuery() {
		JavaQueryImpl javaQuery = new JavaQueryImpl();
		return javaQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaqueryPackage getJavaqueryPackage() {
		return (JavaqueryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JavaqueryPackage getPackage() {
		return JavaqueryPackage.eINSTANCE;
	}

} //JavaqueryFactoryImpl
