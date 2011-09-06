/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.java.profile.java.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaFactoryImpl extends EFactoryImpl implements JavaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavaFactory init() {
		try {
			JavaFactory theJavaFactory = (JavaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/JAVA/1"); 
			if (theJavaFactory != null) {
				return theJavaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JavaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaFactoryImpl() {
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
			case JavaPackage.JAVA_CLASS: return createJavaClass();
			case JavaPackage.JAVA_PACKAGE_: return createJavaPackage_();
			case JavaPackage.JAVA_METHOD: return createJavaMethod();
			case JavaPackage.JAVA_PARAMETER: return createJavaParameter();
			case JavaPackage.JAVA_PROPERTY: return createJavaProperty();
			case JavaPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case JavaPackage.JAVA_PROJECT: return createJavaProject();
			case JavaPackage.JAVA_SRC_FOLDER: return createJavaSrcFolder();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JavaPackage.TRUE_FALSE_DEFAULT:
				return createTrueFalseDefaultFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JavaPackage.TRUE_FALSE_DEFAULT:
				return convertTrueFalseDefaultToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClass createJavaClass() {
		JavaClassImpl javaClass = new JavaClassImpl();
		return javaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaPackage_ createJavaPackage_() {
		JavaPackage_Impl javaPackage_ = new JavaPackage_Impl();
		return javaPackage_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaMethod createJavaMethod() {
		JavaMethodImpl javaMethod = new JavaMethodImpl();
		return javaMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaParameter createJavaParameter() {
		JavaParameterImpl javaParameter = new JavaParameterImpl();
		return javaParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaProperty createJavaProperty() {
		JavaPropertyImpl javaProperty = new JavaPropertyImpl();
		return javaProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaProject createJavaProject() {
		JavaProjectImpl javaProject = new JavaProjectImpl();
		return javaProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaSrcFolder createJavaSrcFolder() {
		JavaSrcFolderImpl javaSrcFolder = new JavaSrcFolderImpl();
		return javaSrcFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueFalseDefault createTrueFalseDefaultFromString(EDataType eDataType, String initialValue) {
		TrueFalseDefault result = TrueFalseDefault.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTrueFalseDefaultToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaPackage getJavaPackage() {
		return (JavaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JavaPackage getPackage() {
		return JavaPackage.eINSTANCE;
	}

} //JavaFactoryImpl
