/**
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Uml_diff_extensionFactoryImpl extends EFactoryImpl implements Uml_diff_extensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Uml_diff_extensionFactory init() {
		try {
			Uml_diff_extensionFactory theUml_diff_extensionFactory = (Uml_diff_extensionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/uml/compare/diff_ext/0.9"); 
			if (theUml_diff_extensionFactory != null) {
				return theUml_diff_extensionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Uml_diff_extensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Uml_diff_extensionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION: return createGeneralizationTargetChangedExtension();
			case Uml_diff_extensionPackage.GENERALIZATION_SOURCE_CHANGED_EXTENSION: return createGeneralizationSourceChangedExtension();
			case Uml_diff_extensionPackage.UML_DIFF_EXTENSION: return createUMLDiffExtension();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationTargetChangedExtension createGeneralizationTargetChangedExtension() {
		GeneralizationTargetChangedExtensionImpl generalizationTargetChangedExtension = new GeneralizationTargetChangedExtensionImpl();
		return generalizationTargetChangedExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationSourceChangedExtension createGeneralizationSourceChangedExtension() {
		GeneralizationSourceChangedExtensionImpl generalizationSourceChangedExtension = new GeneralizationSourceChangedExtensionImpl();
		return generalizationSourceChangedExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLDiffExtension createUMLDiffExtension() {
		UMLDiffExtensionImpl umlDiffExtension = new UMLDiffExtensionImpl();
		return umlDiffExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Uml_diff_extensionPackage getUml_diff_extensionPackage() {
		return (Uml_diff_extensionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Uml_diff_extensionPackage getPackage() {
		return Uml_diff_extensionPackage.eINSTANCE;
	}

} //Uml_diff_extensionFactoryImpl
