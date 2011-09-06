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

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTClass;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTEnum;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTException;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportContainer;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportDeclaration;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTInterface;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParentJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeRoot;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmFactory;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.VisibilityKind;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class JdtmmPackageImpl extends EPackageImpl implements JdtmmPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtJavaElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtParentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtParentJavaElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtTypeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtCompilationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtTypeRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtPackageFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtPackageFragmentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtJavaProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtEnumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtImportDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtImportContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtExceptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum visibilityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum trueFalseDefaultEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jdtJavaModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType intEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType jdtVisitorExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType visitorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JdtmmPackageImpl() {
		super(eNS_URI, JdtmmFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link JdtmmPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JdtmmPackage init() {
		if(isInited)
			return (JdtmmPackage)EPackage.Registry.INSTANCE.getEPackage(JdtmmPackage.eNS_URI);

		// Obtain or create and register package
		JdtmmPackageImpl theJdtmmPackage = (JdtmmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JdtmmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JdtmmPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJdtmmPackage.createPackageContents();

		// Initialize created meta-data
		theJdtmmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJdtmmPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JdtmmPackage.eNS_URI, theJdtmmPackage);
		return theJdtmmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTJavaElement() {
		return jdtJavaElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTJavaElement_Parent() {
		return (EReference)jdtJavaElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTJavaElement_ElementName() {
		return (EAttribute)jdtJavaElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTJavaElement_ElementType() {
		return (EAttribute)jdtJavaElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTJavaElement_Comment() {
		return (EAttribute)jdtJavaElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTJavaElement_Generated() {
		return (EAttribute)jdtJavaElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTParent() {
		return jdtParentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTParent_Flags() {
		return (EAttribute)jdtParentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTParent_Children() {
		return (EReference)jdtParentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTMember() {
		return jdtMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTMember_TypeParameters() {
		return (EReference)jdtMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTMember_Visibility() {
		return (EAttribute)jdtMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTParentJavaElement() {
		return jdtParentJavaElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTTypeParameter() {
		return jdtTypeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTTypeParameter_DeclaringMember() {
		return (EReference)jdtTypeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTField() {
		return jdtFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTField_Owner() {
		return (EReference)jdtFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTField_Type() {
		return (EReference)jdtFieldEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTField_Value() {
		return (EAttribute)jdtFieldEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTField_GenerateGetter() {
		return (EAttribute)jdtFieldEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTField_GenerateSetter() {
		return (EAttribute)jdtFieldEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTField_Abstract() {
		return (EAttribute)jdtFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTField_Final() {
		return (EAttribute)jdtFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTField_Static() {
		return (EAttribute)jdtFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTField_IsMultiValued() {
		return (EAttribute)jdtFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTType() {
		return jdtTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTType_Methods() {
		return (EReference)jdtTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTType_CompilationUnit() {
		return (EReference)jdtTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTType_Class() {
		return (EAttribute)jdtTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTType_Interface() {
		return (EAttribute)jdtTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTType_Enum() {
		return (EAttribute)jdtTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTType_Abstract() {
		return (EAttribute)jdtTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTType_Final() {
		return (EAttribute)jdtTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTType_Static() {
		return (EAttribute)jdtTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTType_Types() {
		return (EReference)jdtTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTType_Owner() {
		return (EReference)jdtTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTType_SuperInterfaces() {
		return (EReference)jdtTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTType_SuperClass() {
		return (EReference)jdtTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTType_SuperInterfaceNames() {
		return (EAttribute)jdtTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTType_SuperClassName() {
		return (EAttribute)jdtTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTType_Fields() {
		return (EReference)jdtTypeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTMethod() {
		return jdtMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTMethod_ReturnType() {
		return (EReference)jdtMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTMethod_Parameters() {
		return (EReference)jdtMethodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTMethod_Exceptions() {
		return (EReference)jdtMethodEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTMethod_Synchronized() {
		return (EAttribute)jdtMethodEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTMethod_Constructor() {
		return (EAttribute)jdtMethodEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTMethod_Abstract() {
		return (EAttribute)jdtMethodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTMethod_Final() {
		return (EAttribute)jdtMethodEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTMethod_Static() {
		return (EAttribute)jdtMethodEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTMethod_Owner() {
		return (EReference)jdtMethodEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTCompilationUnit() {
		return jdtCompilationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTCompilationUnit_PackageFragment() {
		return (EReference)jdtCompilationUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTCompilationUnit_Types() {
		return (EReference)jdtCompilationUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTTypeRoot() {
		return jdtTypeRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTPackageFragment() {
		return jdtPackageFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTPackageFragment_PackageFragmentRoot() {
		return (EReference)jdtPackageFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTPackageFragment_CompilationUnits() {
		return (EReference)jdtPackageFragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTPackageFragmentRoot() {
		return jdtPackageFragmentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTPackageFragmentRoot_JavaProject() {
		return (EReference)jdtPackageFragmentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTPackageFragmentRoot_PackageFragments() {
		return (EReference)jdtPackageFragmentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTJavaProject() {
		return jdtJavaProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTJavaProject_JavaModel() {
		return (EReference)jdtJavaProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTJavaProject_PackageFragmentRoots() {
		return (EReference)jdtJavaProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTClass() {
		return jdtClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTInterface() {
		return jdtInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTEnum() {
		return jdtEnumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTImportDeclaration() {
		return jdtImportDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTImportContainer() {
		return jdtImportContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTParameter() {
		return jdtParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTParameter_ParameterOwner() {
		return (EReference)jdtParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTParameter_Final() {
		return (EAttribute)jdtParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJDTParameter_IsMultiValued() {
		return (EAttribute)jdtParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTParameter_Type() {
		return (EReference)jdtParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTParameter_ReturnOwner() {
		return (EReference)jdtParameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTException() {
		return jdtExceptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getVisibilityKind() {
		return visibilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getTrueFalseDefault() {
		return trueFalseDefaultEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJDTJavaModel() {
		return jdtJavaModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJDTJavaModel_JavaProject() {
		return (EReference)jdtJavaModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getint() {
		return intEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getJDTVisitorException() {
		return jdtVisitorExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getVisitor() {
		return visitorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getboolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JdtmmFactory getJdtmmFactory() {
		return (JdtmmFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		jdtJavaElementEClass = createEClass(JDT_JAVA_ELEMENT);
		createEReference(jdtJavaElementEClass, JDT_JAVA_ELEMENT__PARENT);
		createEAttribute(jdtJavaElementEClass, JDT_JAVA_ELEMENT__ELEMENT_NAME);
		createEAttribute(jdtJavaElementEClass, JDT_JAVA_ELEMENT__ELEMENT_TYPE);
		createEAttribute(jdtJavaElementEClass, JDT_JAVA_ELEMENT__COMMENT);
		createEAttribute(jdtJavaElementEClass, JDT_JAVA_ELEMENT__GENERATED);

		jdtParentEClass = createEClass(JDT_PARENT);
		createEAttribute(jdtParentEClass, JDT_PARENT__FLAGS);
		createEReference(jdtParentEClass, JDT_PARENT__CHILDREN);

		jdtMemberEClass = createEClass(JDT_MEMBER);
		createEReference(jdtMemberEClass, JDT_MEMBER__TYPE_PARAMETERS);
		createEAttribute(jdtMemberEClass, JDT_MEMBER__VISIBILITY);

		jdtParentJavaElementEClass = createEClass(JDT_PARENT_JAVA_ELEMENT);

		jdtTypeParameterEClass = createEClass(JDT_TYPE_PARAMETER);
		createEReference(jdtTypeParameterEClass, JDT_TYPE_PARAMETER__DECLARING_MEMBER);

		jdtFieldEClass = createEClass(JDT_FIELD);
		createEReference(jdtFieldEClass, JDT_FIELD__OWNER);
		createEAttribute(jdtFieldEClass, JDT_FIELD__ABSTRACT);
		createEAttribute(jdtFieldEClass, JDT_FIELD__FINAL);
		createEAttribute(jdtFieldEClass, JDT_FIELD__STATIC);
		createEAttribute(jdtFieldEClass, JDT_FIELD__IS_MULTI_VALUED);
		createEReference(jdtFieldEClass, JDT_FIELD__TYPE);
		createEAttribute(jdtFieldEClass, JDT_FIELD__VALUE);
		createEAttribute(jdtFieldEClass, JDT_FIELD__GENERATE_GETTER);
		createEAttribute(jdtFieldEClass, JDT_FIELD__GENERATE_SETTER);

		jdtTypeEClass = createEClass(JDT_TYPE);
		createEReference(jdtTypeEClass, JDT_TYPE__METHODS);
		createEReference(jdtTypeEClass, JDT_TYPE__COMPILATION_UNIT);
		createEAttribute(jdtTypeEClass, JDT_TYPE__CLASS);
		createEAttribute(jdtTypeEClass, JDT_TYPE__INTERFACE);
		createEAttribute(jdtTypeEClass, JDT_TYPE__ENUM);
		createEAttribute(jdtTypeEClass, JDT_TYPE__ABSTRACT);
		createEAttribute(jdtTypeEClass, JDT_TYPE__FINAL);
		createEAttribute(jdtTypeEClass, JDT_TYPE__STATIC);
		createEReference(jdtTypeEClass, JDT_TYPE__TYPES);
		createEReference(jdtTypeEClass, JDT_TYPE__OWNER);
		createEReference(jdtTypeEClass, JDT_TYPE__SUPER_INTERFACES);
		createEReference(jdtTypeEClass, JDT_TYPE__SUPER_CLASS);
		createEAttribute(jdtTypeEClass, JDT_TYPE__SUPER_INTERFACE_NAMES);
		createEAttribute(jdtTypeEClass, JDT_TYPE__SUPER_CLASS_NAME);
		createEReference(jdtTypeEClass, JDT_TYPE__FIELDS);

		jdtMethodEClass = createEClass(JDT_METHOD);
		createEReference(jdtMethodEClass, JDT_METHOD__RETURN_TYPE);
		createEReference(jdtMethodEClass, JDT_METHOD__PARAMETERS);
		createEAttribute(jdtMethodEClass, JDT_METHOD__ABSTRACT);
		createEAttribute(jdtMethodEClass, JDT_METHOD__FINAL);
		createEAttribute(jdtMethodEClass, JDT_METHOD__STATIC);
		createEReference(jdtMethodEClass, JDT_METHOD__EXCEPTIONS);
		createEAttribute(jdtMethodEClass, JDT_METHOD__SYNCHRONIZED);
		createEAttribute(jdtMethodEClass, JDT_METHOD__CONSTRUCTOR);
		createEReference(jdtMethodEClass, JDT_METHOD__OWNER);

		jdtParameterEClass = createEClass(JDT_PARAMETER);
		createEReference(jdtParameterEClass, JDT_PARAMETER__PARAMETER_OWNER);
		createEAttribute(jdtParameterEClass, JDT_PARAMETER__FINAL);
		createEAttribute(jdtParameterEClass, JDT_PARAMETER__IS_MULTI_VALUED);
		createEReference(jdtParameterEClass, JDT_PARAMETER__TYPE);
		createEReference(jdtParameterEClass, JDT_PARAMETER__RETURN_OWNER);

		jdtCompilationUnitEClass = createEClass(JDT_COMPILATION_UNIT);
		createEReference(jdtCompilationUnitEClass, JDT_COMPILATION_UNIT__PACKAGE_FRAGMENT);
		createEReference(jdtCompilationUnitEClass, JDT_COMPILATION_UNIT__TYPES);

		jdtTypeRootEClass = createEClass(JDT_TYPE_ROOT);

		jdtPackageFragmentEClass = createEClass(JDT_PACKAGE_FRAGMENT);
		createEReference(jdtPackageFragmentEClass, JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT);
		createEReference(jdtPackageFragmentEClass, JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS);

		jdtPackageFragmentRootEClass = createEClass(JDT_PACKAGE_FRAGMENT_ROOT);
		createEReference(jdtPackageFragmentRootEClass, JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT);
		createEReference(jdtPackageFragmentRootEClass, JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS);

		jdtJavaProjectEClass = createEClass(JDT_JAVA_PROJECT);
		createEReference(jdtJavaProjectEClass, JDT_JAVA_PROJECT__JAVA_MODEL);
		createEReference(jdtJavaProjectEClass, JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS);

		jdtJavaModelEClass = createEClass(JDT_JAVA_MODEL);
		createEReference(jdtJavaModelEClass, JDT_JAVA_MODEL__JAVA_PROJECT);

		jdtClassEClass = createEClass(JDT_CLASS);

		jdtInterfaceEClass = createEClass(JDT_INTERFACE);

		jdtEnumEClass = createEClass(JDT_ENUM);

		jdtImportDeclarationEClass = createEClass(JDT_IMPORT_DECLARATION);

		jdtImportContainerEClass = createEClass(JDT_IMPORT_CONTAINER);

		jdtExceptionEClass = createEClass(JDT_EXCEPTION);

		// Create enums
		visibilityKindEEnum = createEEnum(VISIBILITY_KIND);
		trueFalseDefaultEEnum = createEEnum(TRUE_FALSE_DEFAULT);

		// Create data types
		intEDataType = createEDataType(INT);
		booleanEDataType = createEDataType(BOOLEAN);
		stringEDataType = createEDataType(STRING);
		jdtVisitorExceptionEDataType = createEDataType(JDT_VISITOR_EXCEPTION);
		visitorEDataType = createEDataType(VISITOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		jdtMemberEClass.getESuperTypes().add(this.getJDTParentJavaElement());
		jdtParentJavaElementEClass.getESuperTypes().add(this.getJDTJavaElement());
		jdtParentJavaElementEClass.getESuperTypes().add(this.getJDTParent());
		jdtTypeParameterEClass.getESuperTypes().add(this.getJDTJavaElement());
		jdtFieldEClass.getESuperTypes().add(this.getJDTMember());
		jdtTypeEClass.getESuperTypes().add(this.getJDTMember());
		jdtMethodEClass.getESuperTypes().add(this.getJDTMember());
		jdtParameterEClass.getESuperTypes().add(this.getJDTMember());
		jdtCompilationUnitEClass.getESuperTypes().add(this.getJDTTypeRoot());
		jdtTypeRootEClass.getESuperTypes().add(this.getJDTParentJavaElement());
		jdtPackageFragmentEClass.getESuperTypes().add(this.getJDTParentJavaElement());
		jdtPackageFragmentRootEClass.getESuperTypes().add(this.getJDTParentJavaElement());
		jdtJavaProjectEClass.getESuperTypes().add(this.getJDTParentJavaElement());
		jdtJavaModelEClass.getESuperTypes().add(this.getJDTParentJavaElement());
		jdtClassEClass.getESuperTypes().add(this.getJDTType());
		jdtInterfaceEClass.getESuperTypes().add(this.getJDTType());
		jdtEnumEClass.getESuperTypes().add(this.getJDTType());
		jdtImportDeclarationEClass.getESuperTypes().add(this.getJDTJavaElement());
		jdtImportContainerEClass.getESuperTypes().add(this.getJDTParentJavaElement());

		// Initialize classes and features; add operations and parameters
		initEClass(jdtJavaElementEClass, JDTJavaElement.class, "JDTJavaElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTJavaElement_Parent(), this.getJDTParent(), this.getJDTParent_Children(), "parent", null, 0, 1, JDTJavaElement.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTJavaElement_ElementName(), this.getString(), "elementName", null, 1, 1, JDTJavaElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTJavaElement_ElementType(), this.getint(), "elementType", null, 1, 1, JDTJavaElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTJavaElement_Comment(), this.getString(), "comment", null, 1, 1, JDTJavaElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTJavaElement_Generated(), this.getboolean(), "generated", null, 1, 1, JDTJavaElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(jdtJavaElementEClass, this.getString(), "getQualifiedName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		EOperation op = addEOperation(jdtJavaElementEClass, null, "accept", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getVisitor(), "visitor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getJDTVisitorException());

		addEOperation(jdtJavaElementEClass, this.getString(), "getJDTSignature", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(jdtParentEClass, JDTParent.class, "JDTParent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJDTParent_Flags(), this.getint(), "flags", null, 1, 1, JDTParent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTParent_Children(), this.getJDTJavaElement(), this.getJDTJavaElement_Parent(), "children", null, 0, -1, JDTParent.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(jdtParentEClass, null, "setFlag", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "flag", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getboolean(), "value", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(jdtParentEClass, this.getboolean(), "isFlagSet", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "flag", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(jdtMemberEClass, JDTMember.class, "JDTMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTMember_TypeParameters(), this.getJDTTypeParameter(), this.getJDTTypeParameter_DeclaringMember(), "typeParameters", null, 0, -1, JDTMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTMember_Visibility(), this.getVisibilityKind(), "visibility", "public", 1, 1, JDTMember.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(jdtParentJavaElementEClass, JDTParentJavaElement.class, "JDTParentJavaElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jdtTypeParameterEClass, JDTTypeParameter.class, "JDTTypeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTTypeParameter_DeclaringMember(), this.getJDTMember(), this.getJDTMember_TypeParameters(), "declaringMember", null, 0, 1, JDTTypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtFieldEClass, JDTField.class, "JDTField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTField_Owner(), this.getJDTType(), this.getJDTType_Fields(), "owner", null, 1, 1, JDTField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTField_Abstract(), this.getboolean(), "abstract", "false", 1, 1, JDTField.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTField_Final(), this.getboolean(), "final", "false", 1, 1, JDTField.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTField_Static(), this.getboolean(), "static", "false", 1, 1, JDTField.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTField_IsMultiValued(), this.getboolean(), "isMultiValued", "false", 1, 1, JDTField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTField_Type(), this.getJDTType(), null, "type", null, 0, 1, JDTField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTField_Value(), this.getString(), "value", null, 1, 1, JDTField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTField_GenerateGetter(), this.getTrueFalseDefault(), "generateGetter", null, 1, 1, JDTField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTField_GenerateSetter(), this.getTrueFalseDefault(), "generateSetter", null, 1, 1, JDTField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtTypeEClass, JDTType.class, "JDTType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTType_Methods(), this.getJDTMethod(), this.getJDTMethod_Owner(), "methods", null, 0, -1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTType_CompilationUnit(), this.getJDTCompilationUnit(), this.getJDTCompilationUnit_Types(), "compilationUnit", null, 0, 1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTType_Class(), this.getboolean(), "class", "false", 1, 1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTType_Interface(), this.getboolean(), "interface", "false", 1, 1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTType_Enum(), this.getboolean(), "enum", "false", 1, 1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTType_Abstract(), this.getboolean(), "abstract", "false", 1, 1, JDTType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTType_Final(), this.getboolean(), "final", "false", 1, 1, JDTType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTType_Static(), this.getboolean(), "static", "false", 1, 1, JDTType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTType_Types(), this.getJDTType(), this.getJDTType_Owner(), "types", null, 0, -1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTType_Owner(), this.getJDTType(), this.getJDTType_Types(), "owner", null, 0, 1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTType_SuperInterfaces(), this.getJDTType(), null, "superInterfaces", null, 0, -1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTType_SuperClass(), this.getJDTType(), null, "superClass", null, 0, 1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTType_SuperInterfaceNames(), this.getString(), "superInterfaceNames", null, 0, -1, JDTType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTType_SuperClassName(), this.getString(), "superClassName", null, 1, 1, JDTType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTType_Fields(), this.getJDTField(), this.getJDTField_Owner(), "fields", null, 0, -1, JDTType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtMethodEClass, JDTMethod.class, "JDTMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTMethod_ReturnType(), this.getJDTParameter(), this.getJDTParameter_ReturnOwner(), "returnType", null, 0, 1, JDTMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTMethod_Parameters(), this.getJDTParameter(), this.getJDTParameter_ParameterOwner(), "parameters", null, 0, -1, JDTMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTMethod_Abstract(), this.getboolean(), "abstract", "false", 1, 1, JDTMethod.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTMethod_Final(), this.getboolean(), "final", "false", 1, 1, JDTMethod.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTMethod_Static(), this.getboolean(), "static", "false", 1, 1, JDTMethod.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTMethod_Exceptions(), this.getJDTType(), null, "exceptions", null, 0, -1, JDTMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTMethod_Synchronized(), this.getboolean(), "synchronized", "false", 1, 1, JDTMethod.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTMethod_Constructor(), this.getboolean(), "constructor", null, 1, 1, JDTMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTMethod_Owner(), this.getJDTType(), this.getJDTType_Methods(), "owner", null, 1, 1, JDTMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtParameterEClass, JDTParameter.class, "JDTParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTParameter_ParameterOwner(), this.getJDTMethod(), this.getJDTMethod_Parameters(), "parameterOwner", null, 0, 1, JDTParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTParameter_Final(), this.getboolean(), "final", "false", 1, 1, JDTParameter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJDTParameter_IsMultiValued(), this.getboolean(), "isMultiValued", "false", 1, 1, JDTParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTParameter_Type(), this.getJDTType(), null, "type", null, 0, 1, JDTParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTParameter_ReturnOwner(), this.getJDTMethod(), this.getJDTMethod_ReturnType(), "returnOwner", null, 0, 1, JDTParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtCompilationUnitEClass, JDTCompilationUnit.class, "JDTCompilationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTCompilationUnit_PackageFragment(), this.getJDTPackageFragment(), this.getJDTPackageFragment_CompilationUnits(), "packageFragment", null, 0, 1, JDTCompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTCompilationUnit_Types(), this.getJDTType(), this.getJDTType_CompilationUnit(), "types", null, 0, -1, JDTCompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtTypeRootEClass, JDTTypeRoot.class, "JDTTypeRoot", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jdtPackageFragmentEClass, JDTPackageFragment.class, "JDTPackageFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTPackageFragment_PackageFragmentRoot(), this.getJDTPackageFragmentRoot(), this.getJDTPackageFragmentRoot_PackageFragments(), "packageFragmentRoot", null, 0, 1, JDTPackageFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTPackageFragment_CompilationUnits(), this.getJDTCompilationUnit(), this.getJDTCompilationUnit_PackageFragment(), "compilationUnits", null, 0, -1, JDTPackageFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtPackageFragmentRootEClass, JDTPackageFragmentRoot.class, "JDTPackageFragmentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTPackageFragmentRoot_JavaProject(), this.getJDTJavaProject(), this.getJDTJavaProject_PackageFragmentRoots(), "javaProject", null, 0, 1, JDTPackageFragmentRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTPackageFragmentRoot_PackageFragments(), this.getJDTPackageFragment(), this.getJDTPackageFragment_PackageFragmentRoot(), "packageFragments", null, 0, -1, JDTPackageFragmentRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtJavaProjectEClass, JDTJavaProject.class, "JDTJavaProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTJavaProject_JavaModel(), this.getJDTJavaModel(), this.getJDTJavaModel_JavaProject(), "javaModel", null, 0, 1, JDTJavaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getJDTJavaProject_PackageFragmentRoots(), this.getJDTPackageFragmentRoot(), this.getJDTPackageFragmentRoot_JavaProject(), "packageFragmentRoots", null, 0, -1, JDTJavaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtJavaModelEClass, JDTJavaModel.class, "JDTJavaModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJDTJavaModel_JavaProject(), this.getJDTJavaProject(), this.getJDTJavaProject_JavaModel(), "javaProject", null, 0, -1, JDTJavaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jdtClassEClass, JDTClass.class, "JDTClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jdtInterfaceEClass, JDTInterface.class, "JDTInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jdtEnumEClass, JDTEnum.class, "JDTEnum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jdtImportDeclarationEClass, JDTImportDeclaration.class, "JDTImportDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jdtImportContainerEClass, JDTImportContainer.class, "JDTImportContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jdtExceptionEClass, JDTException.class, "JDTException", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(visibilityKindEEnum, VisibilityKind.class, "VisibilityKind");
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PUBLIC);
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PROTECTED);
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PRIVATE);

		initEEnum(trueFalseDefaultEEnum, TrueFalseDefault.class, "TrueFalseDefault");
		addEEnumLiteral(trueFalseDefaultEEnum, TrueFalseDefault.TRUE);
		addEEnumLiteral(trueFalseDefaultEEnum, TrueFalseDefault.FALSE);
		addEEnumLiteral(trueFalseDefaultEEnum, TrueFalseDefault.DEFAULT);

		// Initialize data types
		initEDataType(intEDataType, int.class, "int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, boolean.class, "boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(jdtVisitorExceptionEDataType, JDTVisitorException.class, "JDTVisitorException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(visitorEDataType, JDTVisitor.class, "Visitor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// union
		createUnionAnnotations();
		// redefines
		createRedefinesAnnotations();
		// subsets
		createSubsetsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>union</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUnionAnnotations() {
		String source = "union";
		addAnnotation(getJDTParent_Children(),
				source,
				new String[]{
				});
	}

	/**
	 * Initializes the annotations for <b>redefines</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createRedefinesAnnotations() {
		String source = "redefines";
		addAnnotation(getJDTField_Owner(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTJavaElement/parent")
				});
		addAnnotation(getJDTType_CompilationUnit(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTJavaElement/parent")
				});
		addAnnotation(getJDTType_Owner(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTJavaElement/parent")
				});
		addAnnotation(getJDTMethod_Owner(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTJavaElement/parent")
				});
		addAnnotation(getJDTCompilationUnit_PackageFragment(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTJavaElement/parent")
				});
		addAnnotation(getJDTPackageFragment_PackageFragmentRoot(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTJavaElement/parent")
				});
		addAnnotation(getJDTPackageFragmentRoot_JavaProject(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTJavaElement/parent")
				});
	}

	/**
	 * Initializes the annotations for <b>subsets</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createSubsetsAnnotations() {
		String source = "subsets";
		addAnnotation(getJDTType_Methods(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTParent/children")
				});
		addAnnotation(getJDTType_Types(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTParent/children")
				});
		addAnnotation(getJDTType_Fields(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTParent/children")
				});
		addAnnotation(getJDTCompilationUnit_Types(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTParent/children")
				});
		addAnnotation(getJDTPackageFragment_CompilationUnits(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTParent/children")
				});
		addAnnotation(getJDTPackageFragmentRoot_PackageFragments(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTParent/children")
				});
		addAnnotation(getJDTJavaProject_PackageFragmentRoots(),
				source,
				new String[]{
				},
				new URI[]{
				URI.createURI(eNS_URI).appendFragment("//JDTParent/children")
				});
	}

} //JdtmmPackageImpl
