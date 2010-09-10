/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.domaincontextcodegen.AdviceBinding;
import org.eclipse.papyrus.domaincontextcodegen.Binding;
import org.eclipse.papyrus.domaincontextcodegen.DomainContext;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenFactory;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypes;
import org.eclipse.papyrus.domaincontextcodegen.GenHandlers;
import org.eclipse.papyrus.domaincontextcodegen.InheritanceKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DomaincontextcodegenFactoryImpl extends EFactoryImpl implements DomaincontextcodegenFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DomaincontextcodegenFactory init() {
		try {
			DomaincontextcodegenFactory theDomaincontextcodegenFactory = (DomaincontextcodegenFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/2010/domaincontextcodegen");
			if(theDomaincontextcodegenFactory != null) {
				return theDomaincontextcodegenFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DomaincontextcodegenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomaincontextcodegenFactoryImpl() {
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
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT:
			return createDomainContext();
		case DomaincontextcodegenPackage.ELEMENT_TYPES:
			return createElementTypes();
		case DomaincontextcodegenPackage.ELEMENT_TYPE:
			return createElementType();
		case DomaincontextcodegenPackage.ADVICE_BINDING:
			return createAdviceBinding();
		case DomaincontextcodegenPackage.BINDING:
			return createBinding();
		case DomaincontextcodegenPackage.GEN_HANDLERS:
			return createGenHandlers();
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
		case DomaincontextcodegenPackage.INHERITANCE_KIND:
			return createInheritanceKindFromString(eDataType, initialValue);
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
		case DomaincontextcodegenPackage.INHERITANCE_KIND:
			return convertInheritanceKindToString(eDataType, instanceValue);
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
	public DomainContext createDomainContext() {
		DomainContextImpl domainContext = new DomainContextImpl();
		return domainContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementTypes createElementTypes() {
		ElementTypesImpl elementTypes = new ElementTypesImpl();
		return elementTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementType createElementType() {
		ElementTypeImpl elementType = new ElementTypeImpl();
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AdviceBinding createAdviceBinding() {
		AdviceBindingImpl adviceBinding = new AdviceBindingImpl();
		return adviceBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Binding createBinding() {
		BindingImpl binding = new BindingImpl();
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenHandlers createGenHandlers() {
		GenHandlersImpl genHandlers = new GenHandlersImpl();
		return genHandlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InheritanceKind createInheritanceKindFromString(EDataType eDataType, String initialValue) {
		InheritanceKind result = InheritanceKind.get(initialValue);
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
	public String convertInheritanceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomaincontextcodegenPackage getDomaincontextcodegenPackage() {
		return (DomaincontextcodegenPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DomaincontextcodegenPackage getPackage() {
		return DomaincontextcodegenPackage.eINSTANCE;
	}

} //DomaincontextcodegenFactoryImpl
