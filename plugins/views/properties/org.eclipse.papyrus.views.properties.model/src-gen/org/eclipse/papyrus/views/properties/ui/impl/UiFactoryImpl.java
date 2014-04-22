/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.views.properties.ui.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.views.properties.ui.*;
import org.eclipse.papyrus.views.properties.ui.CompositeWidget;
import org.eclipse.papyrus.views.properties.ui.Element;
import org.eclipse.papyrus.views.properties.ui.Layout;
import org.eclipse.papyrus.views.properties.ui.PropertyEditor;
import org.eclipse.papyrus.views.properties.ui.ReferenceAttribute;
import org.eclipse.papyrus.views.properties.ui.StandardWidget;
import org.eclipse.papyrus.views.properties.ui.UiFactory;
import org.eclipse.papyrus.views.properties.ui.UiPackage;
import org.eclipse.papyrus.views.properties.ui.UnknownComponent;
import org.eclipse.papyrus.views.properties.ui.ValueAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UiFactoryImpl extends EFactoryImpl implements UiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UiFactory init() {
		try {
			UiFactory theUiFactory = (UiFactory)EPackage.Registry.INSTANCE.getEFactory(UiPackage.eNS_URI);
			if (theUiFactory != null) {
				return theUiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiFactoryImpl() {
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
			case UiPackage.ELEMENT: return createElement();
			case UiPackage.STANDARD_WIDGET: return createStandardWidget();
			case UiPackage.PROPERTY_EDITOR: return createPropertyEditor();
			case UiPackage.COMPOSITE_WIDGET: return createCompositeWidget();
			case UiPackage.UNKNOWN_COMPONENT: return createUnknownComponent();
			case UiPackage.LAYOUT: return createLayout();
			case UiPackage.VALUE_ATTRIBUTE: return createValueAttribute();
			case UiPackage.REFERENCE_ATTRIBUTE: return createReferenceAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardWidget createStandardWidget() {
		StandardWidgetImpl standardWidget = new StandardWidgetImpl();
		return standardWidget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyEditor createPropertyEditor() {
		PropertyEditorImpl propertyEditor = new PropertyEditorImpl();
		return propertyEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeWidget createCompositeWidget() {
		CompositeWidgetImpl compositeWidget = new CompositeWidgetImpl();
		return compositeWidget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownComponent createUnknownComponent() {
		UnknownComponentImpl unknownComponent = new UnknownComponentImpl();
		return unknownComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createLayout() {
		LayoutImpl layout = new LayoutImpl();
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueAttribute createValueAttribute() {
		ValueAttributeImpl valueAttribute = new ValueAttributeImpl();
		return valueAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceAttribute createReferenceAttribute() {
		ReferenceAttributeImpl referenceAttribute = new ReferenceAttributeImpl();
		return referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiPackage getUiPackage() {
		return (UiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UiPackage getPackage() {
		return UiPackage.eINSTANCE;
	}

} //UiFactoryImpl
