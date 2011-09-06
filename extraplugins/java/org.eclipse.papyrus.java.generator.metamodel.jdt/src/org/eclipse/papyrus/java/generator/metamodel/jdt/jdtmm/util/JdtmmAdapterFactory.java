/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage
 * @generated
 */
public class JdtmmAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static JdtmmPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JdtmmAdapterFactory() {
		if(modelPackage == null) {
			modelPackage = JdtmmPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if(object == modelPackage) {
			return true;
		}
		if(object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JdtmmSwitch<Adapter> modelSwitch =
			new JdtmmSwitch<Adapter>() {

				@Override
				public Adapter caseJDTJavaElement(JDTJavaElement object) {
					return createJDTJavaElementAdapter();
				}

				@Override
				public Adapter caseJDTParent(JDTParent object) {
					return createJDTParentAdapter();
				}

				@Override
				public Adapter caseJDTMember(JDTMember object) {
					return createJDTMemberAdapter();
				}

				@Override
				public Adapter caseJDTParentJavaElement(JDTParentJavaElement object) {
					return createJDTParentJavaElementAdapter();
				}

				@Override
				public Adapter caseJDTTypeParameter(JDTTypeParameter object) {
					return createJDTTypeParameterAdapter();
				}

				@Override
				public Adapter caseJDTField(JDTField object) {
					return createJDTFieldAdapter();
				}

				@Override
				public Adapter caseJDTType(JDTType object) {
					return createJDTTypeAdapter();
				}

				@Override
				public Adapter caseJDTMethod(JDTMethod object) {
					return createJDTMethodAdapter();
				}

				@Override
				public Adapter caseJDTParameter(JDTParameter object) {
					return createJDTParameterAdapter();
				}

				@Override
				public Adapter caseJDTCompilationUnit(JDTCompilationUnit object) {
					return createJDTCompilationUnitAdapter();
				}

				@Override
				public Adapter caseJDTTypeRoot(JDTTypeRoot object) {
					return createJDTTypeRootAdapter();
				}

				@Override
				public Adapter caseJDTPackageFragment(JDTPackageFragment object) {
					return createJDTPackageFragmentAdapter();
				}

				@Override
				public Adapter caseJDTPackageFragmentRoot(JDTPackageFragmentRoot object) {
					return createJDTPackageFragmentRootAdapter();
				}

				@Override
				public Adapter caseJDTJavaProject(JDTJavaProject object) {
					return createJDTJavaProjectAdapter();
				}

				@Override
				public Adapter caseJDTJavaModel(JDTJavaModel object) {
					return createJDTJavaModelAdapter();
				}

				@Override
				public Adapter caseJDTClass(JDTClass object) {
					return createJDTClassAdapter();
				}

				@Override
				public Adapter caseJDTInterface(JDTInterface object) {
					return createJDTInterfaceAdapter();
				}

				@Override
				public Adapter caseJDTEnum(JDTEnum object) {
					return createJDTEnumAdapter();
				}

				@Override
				public Adapter caseJDTImportDeclaration(JDTImportDeclaration object) {
					return createJDTImportDeclarationAdapter();
				}

				@Override
				public Adapter caseJDTImportContainer(JDTImportContainer object) {
					return createJDTImportContainerAdapter();
				}

				@Override
				public Adapter caseJDTException(JDTException object) {
					return createJDTExceptionAdapter();
				}

				@Override
				public Adapter defaultCase(EObject object) {
					return createEObjectAdapter();
				}
			};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *        the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement
	 * <em>JDT Java Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement
	 * @generated
	 */
	public Adapter createJDTJavaElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent <em>JDT Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent
	 * @generated
	 */
	public Adapter createJDTParentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember <em>JDT Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember
	 * @generated
	 */
	public Adapter createJDTMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParentJavaElement
	 * <em>JDT Parent Java Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParentJavaElement
	 * @generated
	 */
	public Adapter createJDTParentJavaElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter
	 * <em>JDT Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter
	 * @generated
	 */
	public Adapter createJDTTypeParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField <em>JDT Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField
	 * @generated
	 */
	public Adapter createJDTFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType <em>JDT Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType
	 * @generated
	 */
	public Adapter createJDTTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod <em>JDT Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod
	 * @generated
	 */
	public Adapter createJDTMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter
	 * <em>JDT Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter
	 * @generated
	 */
	public Adapter createJDTParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit
	 * <em>JDT Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit
	 * @generated
	 */
	public Adapter createJDTCompilationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeRoot <em>JDT Type Root</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeRoot
	 * @generated
	 */
	public Adapter createJDTTypeRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment
	 * <em>JDT Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment
	 * @generated
	 */
	public Adapter createJDTPackageFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot
	 * <em>JDT Package Fragment Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot
	 * @generated
	 */
	public Adapter createJDTPackageFragmentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject
	 * <em>JDT Java Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject
	 * @generated
	 */
	public Adapter createJDTJavaProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel
	 * <em>JDT Java Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel
	 * @generated
	 */
	public Adapter createJDTJavaModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTClass <em>JDT Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTClass
	 * @generated
	 */
	public Adapter createJDTClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTInterface
	 * <em>JDT Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTInterface
	 * @generated
	 */
	public Adapter createJDTInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTEnum <em>JDT Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTEnum
	 * @generated
	 */
	public Adapter createJDTEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportDeclaration
	 * <em>JDT Import Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportDeclaration
	 * @generated
	 */
	public Adapter createJDTImportDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportContainer
	 * <em>JDT Import Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportContainer
	 * @generated
	 */
	public Adapter createJDTImportContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTException
	 * <em>JDT Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTException
	 * @generated
	 */
	public Adapter createJDTExceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //JdtmmAdapterFactory
