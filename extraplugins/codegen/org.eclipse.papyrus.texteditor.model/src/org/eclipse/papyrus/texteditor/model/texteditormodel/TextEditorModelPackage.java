/**
 *  Copyright (c) 2012 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.texteditor.model.texteditormodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModelFactory
 * @model kind="package"
 * @generated
 */
public interface TextEditorModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "texteditormodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/Example/0.10.0/texteditormodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "texteditormodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TextEditorModelPackage eINSTANCE = org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl <em>Text Editor Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl
	 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelPackageImpl#getTextEditorModel()
	 * @generated
	 */
	int TEXT_EDITOR_MODEL = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_EDITOR_MODEL__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Edited Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_EDITOR_MODEL__EDITED_OBJECT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_EDITOR_MODEL__TYPE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_EDITOR_MODEL__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Text Editor Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_EDITOR_MODEL_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel <em>Text Editor Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Editor Model</em>'.
	 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel
	 * @generated
	 */
	EClass getTextEditorModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel#getEditedObject <em>Edited Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edited Object</em>'.
	 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel#getEditedObject()
	 * @see #getTextEditorModel()
	 * @generated
	 */
	EReference getTextEditorModel_EditedObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel#getType()
	 * @see #getTextEditorModel()
	 * @generated
	 */
	EAttribute getTextEditorModel_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel#getName()
	 * @see #getTextEditorModel()
	 * @generated
	 */
	EAttribute getTextEditorModel_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TextEditorModelFactory getTextEditorModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl <em>Text Editor Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl
		 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelPackageImpl#getTextEditorModel()
		 * @generated
		 */
		EClass TEXT_EDITOR_MODEL = eINSTANCE.getTextEditorModel();

		/**
		 * The meta object literal for the '<em><b>Edited Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_EDITOR_MODEL__EDITED_OBJECT = eINSTANCE.getTextEditorModel_EditedObject();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_EDITOR_MODEL__TYPE = eINSTANCE.getTextEditorModel_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_EDITOR_MODEL__NAME = eINSTANCE.getTextEditorModel_Name();

	}

} //TextEditorModelPackage
