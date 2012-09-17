/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CsscustomizationFactoryImpl extends EFactoryImpl implements CsscustomizationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CsscustomizationFactory init() {
		try {
			CsscustomizationFactory theCsscustomizationFactory = (CsscustomizationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/css/customization"); 
			if (theCsscustomizationFactory != null) {
				return theCsscustomizationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CsscustomizationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsscustomizationFactoryImpl() {
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
			case CsscustomizationPackage.CSS_STYLESHEET: return createCSSStylesheet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSSStylesheet createCSSStylesheet() {
		CSSStylesheetImpl cssStylesheet = new CSSStylesheetImpl();
		return cssStylesheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsscustomizationPackage getCsscustomizationPackage() {
		return (CsscustomizationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CsscustomizationPackage getPackage() {
		return CsscustomizationPackage.eINSTANCE;
	}

} //CsscustomizationFactoryImpl
