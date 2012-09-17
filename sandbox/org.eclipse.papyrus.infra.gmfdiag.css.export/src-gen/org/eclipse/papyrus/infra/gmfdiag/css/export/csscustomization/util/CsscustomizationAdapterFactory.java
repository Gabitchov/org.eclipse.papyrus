/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage
 * @generated
 */
public class CsscustomizationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CsscustomizationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsscustomizationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CsscustomizationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CsscustomizationSwitch<Adapter> modelSwitch =
		new CsscustomizationSwitch<Adapter>() {
			@Override
			public Adapter caseCSSStylesheet(CSSStylesheet object) {
				return createCSSStylesheetAdapter();
			}
			@Override
			public Adapter caseCustomizableElement(CustomizableElement object) {
				return createCustomizableElementAdapter();
			}
			@Override
			public Adapter caseFileBasedCustomizableElement(FileBasedCustomizableElement object) {
				return createFileBasedCustomizableElementAdapter();
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
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet <em>CSS Stylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet
	 * @generated
	 */
	public Adapter createCSSStylesheetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement <em>Customizable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement
	 * @generated
	 */
	public Adapter createCustomizableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement <em>File Based Customizable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement
	 * @generated
	 */
	public Adapter createFileBasedCustomizableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CsscustomizationAdapterFactory
