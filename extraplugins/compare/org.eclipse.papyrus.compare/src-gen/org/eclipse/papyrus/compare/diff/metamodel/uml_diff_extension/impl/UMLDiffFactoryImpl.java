/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLDiffFactoryImpl extends EFactoryImpl implements UMLDiffFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLDiffFactory init() {
		try {
			UMLDiffFactory theUMLDiffFactory = (UMLDiffFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/uml/compare/diff_ext/1.0"); 
			if (theUMLDiffFactory != null) {
				return theUMLDiffFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UMLDiffFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLDiffFactoryImpl() {
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
			case UMLDiffPackage.TAGGED_VALUE_CHANGE_LEFT_TARGET: return createTaggedValueChangeLeftTarget();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET: return createTaggedValueChangeRightTarget();
			case UMLDiffPackage.UPDATE_TAGGED_VALUE: return createUpdateTaggedValue();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION: return createAddStereotypeApplication();
			case UMLDiffPackage.REMOVE_STEREOTYPE_APPLICATION: return createRemoveStereotypeApplication();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaggedValueChangeLeftTarget createTaggedValueChangeLeftTarget() {
		TaggedValueChangeLeftTargetImpl taggedValueChangeLeftTarget = new TaggedValueChangeLeftTargetImpl();
		return taggedValueChangeLeftTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaggedValueChangeRightTarget createTaggedValueChangeRightTarget() {
		TaggedValueChangeRightTargetImpl taggedValueChangeRightTarget = new TaggedValueChangeRightTargetImpl();
		return taggedValueChangeRightTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateTaggedValue createUpdateTaggedValue() {
		UpdateTaggedValueImpl updateTaggedValue = new UpdateTaggedValueImpl();
		return updateTaggedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddStereotypeApplication createAddStereotypeApplication() {
		AddStereotypeApplicationImpl addStereotypeApplication = new AddStereotypeApplicationImpl();
		return addStereotypeApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveStereotypeApplication createRemoveStereotypeApplication() {
		RemoveStereotypeApplicationImpl removeStereotypeApplication = new RemoveStereotypeApplicationImpl();
		return removeStereotypeApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLDiffPackage getUMLDiffPackage() {
		return (UMLDiffPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UMLDiffPackage getPackage() {
		return UMLDiffPackage.eINSTANCE;
	}

} //UMLDiffFactoryImpl
