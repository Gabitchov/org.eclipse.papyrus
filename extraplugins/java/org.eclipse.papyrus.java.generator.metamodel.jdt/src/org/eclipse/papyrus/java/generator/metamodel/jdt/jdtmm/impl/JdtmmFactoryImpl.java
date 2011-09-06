/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.*;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class JdtmmFactoryImpl extends EFactoryImpl implements JdtmmFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static JdtmmFactory init() {
		try {
			JdtmmFactory theJdtmmFactory = (JdtmmFactory)EPackage.Registry.INSTANCE.getEFactory("http:///jdtmm.ecore");
			if(theJdtmmFactory != null) {
				return theJdtmmFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JdtmmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JdtmmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case JdtmmPackage.JDT_TYPE_PARAMETER:
			return createJDTTypeParameter();
		case JdtmmPackage.JDT_FIELD:
			return createJDTField();
		case JdtmmPackage.JDT_METHOD:
			return createJDTMethod();
		case JdtmmPackage.JDT_PARAMETER:
			return createJDTParameter();
		case JdtmmPackage.JDT_COMPILATION_UNIT:
			return createJDTCompilationUnit();
		case JdtmmPackage.JDT_PACKAGE_FRAGMENT:
			return createJDTPackageFragment();
		case JdtmmPackage.JDT_PACKAGE_FRAGMENT_ROOT:
			return createJDTPackageFragmentRoot();
		case JdtmmPackage.JDT_JAVA_PROJECT:
			return createJDTJavaProject();
		case JdtmmPackage.JDT_JAVA_MODEL:
			return createJDTJavaModel();
		case JdtmmPackage.JDT_CLASS:
			return createJDTClass();
		case JdtmmPackage.JDT_INTERFACE:
			return createJDTInterface();
		case JdtmmPackage.JDT_ENUM:
			return createJDTEnum();
		case JdtmmPackage.JDT_IMPORT_DECLARATION:
			return createJDTImportDeclaration();
		case JdtmmPackage.JDT_IMPORT_CONTAINER:
			return createJDTImportContainer();
		case JdtmmPackage.JDT_EXCEPTION:
			return createJDTException();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch(eDataType.getClassifierID()) {
		case JdtmmPackage.VISIBILITY_KIND:
			return createVisibilityKindFromString(eDataType, initialValue);
		case JdtmmPackage.TRUE_FALSE_DEFAULT:
			return createTrueFalseDefaultFromString(eDataType, initialValue);
		case JdtmmPackage.INT:
			return createintFromString(eDataType, initialValue);
		case JdtmmPackage.BOOLEAN:
			return createbooleanFromString(eDataType, initialValue);
		case JdtmmPackage.STRING:
			return createStringFromString(eDataType, initialValue);
		case JdtmmPackage.JDT_VISITOR_EXCEPTION:
			return createJDTVisitorExceptionFromString(eDataType, initialValue);
		case JdtmmPackage.VISITOR:
			return createVisitorFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch(eDataType.getClassifierID()) {
		case JdtmmPackage.VISIBILITY_KIND:
			return convertVisibilityKindToString(eDataType, instanceValue);
		case JdtmmPackage.TRUE_FALSE_DEFAULT:
			return convertTrueFalseDefaultToString(eDataType, instanceValue);
		case JdtmmPackage.INT:
			return convertintToString(eDataType, instanceValue);
		case JdtmmPackage.BOOLEAN:
			return convertbooleanToString(eDataType, instanceValue);
		case JdtmmPackage.STRING:
			return convertStringToString(eDataType, instanceValue);
		case JdtmmPackage.JDT_VISITOR_EXCEPTION:
			return convertJDTVisitorExceptionToString(eDataType, instanceValue);
		case JdtmmPackage.VISITOR:
			return convertVisitorToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTTypeParameter createJDTTypeParameter() {
		JDTTypeParameterImpl jdtTypeParameter = new JDTTypeParameterImpl();
		return jdtTypeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTField createJDTField() {
		JDTFieldImpl jdtField = new JDTFieldImpl();
		return jdtField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTMethod createJDTMethod() {
		JDTMethodImpl jdtMethod = new JDTMethodImpl();
		return jdtMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTCompilationUnit createJDTCompilationUnit() {
		JDTCompilationUnitImpl jdtCompilationUnit = new JDTCompilationUnitImpl();
		return jdtCompilationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTPackageFragment createJDTPackageFragment() {
		JDTPackageFragmentImpl jdtPackageFragment = new JDTPackageFragmentImpl();
		return jdtPackageFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTPackageFragmentRoot createJDTPackageFragmentRoot() {
		JDTPackageFragmentRootImpl jdtPackageFragmentRoot = new JDTPackageFragmentRootImpl();
		return jdtPackageFragmentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTJavaProject createJDTJavaProject() {
		JDTJavaProjectImpl jdtJavaProject = new JDTJavaProjectImpl();
		return jdtJavaProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTClass createJDTClass() {
		JDTClassImpl jdtClass = new JDTClassImpl();
		return jdtClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTInterface createJDTInterface() {
		JDTInterfaceImpl jdtInterface = new JDTInterfaceImpl();
		return jdtInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTEnum createJDTEnum() {
		JDTEnumImpl jdtEnum = new JDTEnumImpl();
		return jdtEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTImportDeclaration createJDTImportDeclaration() {
		JDTImportDeclarationImpl jdtImportDeclaration = new JDTImportDeclarationImpl();
		return jdtImportDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTImportContainer createJDTImportContainer() {
		JDTImportContainerImpl jdtImportContainer = new JDTImportContainerImpl();
		return jdtImportContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTParameter createJDTParameter() {
		JDTParameterImpl jdtParameter = new JDTParameterImpl();
		return jdtParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTException createJDTException() {
		JDTExceptionImpl jdtException = new JDTExceptionImpl();
		return jdtException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VisibilityKind createVisibilityKindFromString(EDataType eDataType, String initialValue) {
		VisibilityKind result = VisibilityKind.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertVisibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TrueFalseDefault createTrueFalseDefaultFromString(EDataType eDataType, String initialValue) {
		TrueFalseDefault result = TrueFalseDefault.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertTrueFalseDefaultToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTJavaModel createJDTJavaModel() {
		JDTJavaModelImpl jdtJavaModel = new JDTJavaModelImpl();
		return jdtJavaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Integer createintFromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertintToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTVisitorException createJDTVisitorExceptionFromString(EDataType eDataType, String initialValue) {
		return (JDTVisitorException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertJDTVisitorExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTVisitor createVisitorFromString(EDataType eDataType, String initialValue) {
		return (JDTVisitor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertVisitorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Boolean createbooleanFromString(EDataType eDataType, String initialValue) {
		return (Boolean)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertbooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JdtmmPackage getJdtmmPackage() {
		return (JdtmmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JdtmmPackage getPackage() {
		return JdtmmPackage.eINSTANCE;
	}

} //JdtmmFactoryImpl
