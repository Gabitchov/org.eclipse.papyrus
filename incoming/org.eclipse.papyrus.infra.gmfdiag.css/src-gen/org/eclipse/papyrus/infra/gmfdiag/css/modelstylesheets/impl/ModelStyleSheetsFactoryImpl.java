/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.gmfdiag.css.modelstylesheets.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.gmfdiag.css.modelstylesheets.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelStyleSheetsFactoryImpl extends EFactoryImpl implements ModelStyleSheetsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelStyleSheetsFactory init() {
		try {
			ModelStyleSheetsFactory theModelStyleSheetsFactory = (ModelStyleSheetsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/infra/gmfdiag/css"); 
			if (theModelStyleSheetsFactory != null) {
				return theModelStyleSheetsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelStyleSheetsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelStyleSheetsFactoryImpl() {
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
			case ModelStyleSheetsPackage.MODEL_STYLE_SHEETS: return createModelStyleSheets();
			case ModelStyleSheetsPackage.STYLE_SHEET_REFERENCE: return createStyleSheetReference();
			case ModelStyleSheetsPackage.EMBEDDED_STYLE_SHEET: return createEmbeddedStyleSheet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelStyleSheets createModelStyleSheets() {
		ModelStyleSheetsImpl modelStyleSheets = new ModelStyleSheetsImpl();
		return modelStyleSheets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyleSheetReference createStyleSheetReference() {
		StyleSheetReferenceImpl styleSheetReference = new StyleSheetReferenceImpl();
		return styleSheetReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbeddedStyleSheet createEmbeddedStyleSheet() {
		EmbeddedStyleSheetImpl embeddedStyleSheet = new EmbeddedStyleSheetImpl();
		return embeddedStyleSheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelStyleSheetsPackage getModelStyleSheetsPackage() {
		return (ModelStyleSheetsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelStyleSheetsPackage getPackage() {
		return ModelStyleSheetsPackage.eINSTANCE;
	}

} //ModelStyleSheetsFactoryImpl
