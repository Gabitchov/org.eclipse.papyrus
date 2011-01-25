/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.properties.contexts.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContextsFactoryImpl extends EFactoryImpl implements ContextsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContextsFactory init() {
		try {
			ContextsFactory theContextsFactory = (ContextsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/properties/contexts"); 
			if (theContextsFactory != null) {
				return theContextsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ContextsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextsFactoryImpl() {
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
			case ContextsPackage.CONTEXT: return createContext();
			case ContextsPackage.VIEW: return createView();
			case ContextsPackage.TAB: return createTab();
			case ContextsPackage.SECTION: return createSection();
			case ContextsPackage.DATA_CONTEXT_ELEMENT: return createDataContextElement();
			case ContextsPackage.PROPERTY: return createProperty();
			case ContextsPackage.UNKNOWN_PROPERTY: return createUnknownProperty();
			case ContextsPackage.DATA_CONTEXT_PACKAGE: return createDataContextPackage();
			case ContextsPackage.DATA_CONTEXT_ROOT: return createDataContextRoot();
			case ContextsPackage.CONSTRAINT_DESCRIPTOR: return createConstraintDescriptor();
			case ContextsPackage.VALUE_PROPERTY: return createValueProperty();
			case ContextsPackage.REFERENCE_PROPERTY: return createReferenceProperty();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tab createTab() {
		TabImpl tab = new TabImpl();
		return tab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section createSection() {
		SectionImpl section = new SectionImpl();
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataContextElement createDataContextElement() {
		DataContextElementImpl dataContextElement = new DataContextElementImpl();
		return dataContextElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownProperty createUnknownProperty() {
		UnknownPropertyImpl unknownProperty = new UnknownPropertyImpl();
		return unknownProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataContextPackage createDataContextPackage() {
		DataContextPackageImpl dataContextPackage = new DataContextPackageImpl();
		return dataContextPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataContextRoot createDataContextRoot() {
		DataContextRootImpl dataContextRoot = new DataContextRootImpl();
		return dataContextRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintDescriptor createConstraintDescriptor() {
		ConstraintDescriptorImpl constraintDescriptor = new ConstraintDescriptorImpl();
		return constraintDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueProperty createValueProperty() {
		ValuePropertyImpl valueProperty = new ValuePropertyImpl();
		return valueProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceProperty createReferenceProperty() {
		ReferencePropertyImpl referenceProperty = new ReferencePropertyImpl();
		return referenceProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextsPackage getContextsPackage() {
		return (ContextsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ContextsPackage getPackage() {
		return ContextsPackage.eINSTANCE;
	}

} //ContextsFactoryImpl
