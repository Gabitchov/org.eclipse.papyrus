/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.ui.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.properties.contexts.ContextsPackage;

import org.eclipse.papyrus.properties.contexts.impl.ContextsPackageImpl;

import org.eclipse.papyrus.properties.environment.EnvironmentPackage;

import org.eclipse.papyrus.properties.environment.impl.EnvironmentPackageImpl;

import org.eclipse.papyrus.properties.ui.CompositeWidget;
import org.eclipse.papyrus.properties.ui.Element;
import org.eclipse.papyrus.properties.ui.Layout;
import org.eclipse.papyrus.properties.ui.PropertyEditor;
import org.eclipse.papyrus.properties.ui.ReferenceAttribute;
import org.eclipse.papyrus.properties.ui.StandardWidget;
import org.eclipse.papyrus.properties.ui.UIComponent;
import org.eclipse.papyrus.properties.ui.UiFactory;
import org.eclipse.papyrus.properties.ui.UiPackage;
import org.eclipse.papyrus.properties.ui.UnknownComponent;
import org.eclipse.papyrus.properties.ui.ValueAttribute;
import org.eclipse.papyrus.properties.ui.Widget;
import org.eclipse.papyrus.properties.ui.WidgetAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UiPackageImpl extends EPackageImpl implements UiPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uiComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardWidgetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEditorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeWidgetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownComponentEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.properties.ui.UiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UiPackageImpl() {
		super(eNS_URI, UiFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UiPackage init() {
		if (isInited) return (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);

		// Obtain or create and register package
		UiPackageImpl theUiPackage = (UiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UiPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EnvironmentPackageImpl theEnvironmentPackage = (EnvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI) instanceof EnvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI) : EnvironmentPackage.eINSTANCE);
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) : ContextsPackage.eINSTANCE);

		// Create package meta-data objects
		theUiPackage.createPackageContents();
		theEnvironmentPackage.createPackageContents();
		theContextsPackage.createPackageContents();

		// Initialize created meta-data
		theUiPackage.initializePackageContents();
		theEnvironmentPackage.initializePackageContents();
		theContextsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUiPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UiPackage.eNS_URI, theUiPackage);
		return theUiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUIComponent() {
		return uiComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUIComponent_Attributes() {
		return (EReference)uiComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidget() {
		return widgetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardWidget() {
		return standardWidgetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardWidget_WidgetType() {
		return (EReference)standardWidgetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyEditor() {
		return propertyEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyEditor_Property() {
		return (EReference)propertyEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyEditor_ReadOnly() {
		return (EAttribute)propertyEditorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyEditor_WidgetType() {
		return (EReference)propertyEditorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeWidget() {
		return compositeWidgetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeWidget_Layout() {
		return (EReference)compositeWidgetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeWidget_Widgets() {
		return (EReference)compositeWidgetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeWidget_WidgetType() {
		return (EReference)compositeWidgetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayout() {
		return layoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayout_LayoutType() {
		return (EReference)layoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidgetAttribute() {
		return widgetAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidgetAttribute_Name() {
		return (EAttribute)widgetAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueAttribute() {
		return valueAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueAttribute_Value() {
		return (EAttribute)valueAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceAttribute() {
		return referenceAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceAttribute_Value() {
		return (EReference)referenceAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnknownComponent() {
		return unknownComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnknownComponent_TypeName() {
		return (EAttribute)unknownComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiFactory getUiFactory() {
		return (UiFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		elementEClass = createEClass(ELEMENT);

		uiComponentEClass = createEClass(UI_COMPONENT);
		createEReference(uiComponentEClass, UI_COMPONENT__ATTRIBUTES);

		widgetEClass = createEClass(WIDGET);

		standardWidgetEClass = createEClass(STANDARD_WIDGET);
		createEReference(standardWidgetEClass, STANDARD_WIDGET__WIDGET_TYPE);

		propertyEditorEClass = createEClass(PROPERTY_EDITOR);
		createEReference(propertyEditorEClass, PROPERTY_EDITOR__PROPERTY);
		createEAttribute(propertyEditorEClass, PROPERTY_EDITOR__READ_ONLY);
		createEReference(propertyEditorEClass, PROPERTY_EDITOR__WIDGET_TYPE);

		compositeWidgetEClass = createEClass(COMPOSITE_WIDGET);
		createEReference(compositeWidgetEClass, COMPOSITE_WIDGET__LAYOUT);
		createEReference(compositeWidgetEClass, COMPOSITE_WIDGET__WIDGETS);
		createEReference(compositeWidgetEClass, COMPOSITE_WIDGET__WIDGET_TYPE);

		layoutEClass = createEClass(LAYOUT);
		createEReference(layoutEClass, LAYOUT__LAYOUT_TYPE);

		widgetAttributeEClass = createEClass(WIDGET_ATTRIBUTE);
		createEAttribute(widgetAttributeEClass, WIDGET_ATTRIBUTE__NAME);

		valueAttributeEClass = createEClass(VALUE_ATTRIBUTE);
		createEAttribute(valueAttributeEClass, VALUE_ATTRIBUTE__VALUE);

		referenceAttributeEClass = createEClass(REFERENCE_ATTRIBUTE);
		createEReference(referenceAttributeEClass, REFERENCE_ATTRIBUTE__VALUE);

		unknownComponentEClass = createEClass(UNKNOWN_COMPONENT);
		createEAttribute(unknownComponentEClass, UNKNOWN_COMPONENT__TYPE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EnvironmentPackage theEnvironmentPackage = (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);
		ContextsPackage theContextsPackage = (ContextsPackage)EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		uiComponentEClass.getESuperTypes().add(this.getElement());
		widgetEClass.getESuperTypes().add(this.getUIComponent());
		standardWidgetEClass.getESuperTypes().add(this.getWidget());
		propertyEditorEClass.getESuperTypes().add(this.getWidget());
		compositeWidgetEClass.getESuperTypes().add(this.getWidget());
		layoutEClass.getESuperTypes().add(this.getUIComponent());
		widgetAttributeEClass.getESuperTypes().add(this.getElement());
		valueAttributeEClass.getESuperTypes().add(this.getWidgetAttribute());
		referenceAttributeEClass.getESuperTypes().add(this.getWidgetAttribute());
		unknownComponentEClass.getESuperTypes().add(this.getWidget());

		// Initialize classes and features; add operations and parameters
		initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uiComponentEClass, UIComponent.class, "UIComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUIComponent_Attributes(), this.getWidgetAttribute(), null, "attributes", null, 0, -1, UIComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetEClass, Widget.class, "Widget", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(standardWidgetEClass, StandardWidget.class, "StandardWidget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStandardWidget_WidgetType(), theEnvironmentPackage.getStandardWidgetType(), null, "widgetType", null, 1, 1, StandardWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEditorEClass, PropertyEditor.class, "PropertyEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyEditor_Property(), theContextsPackage.getProperty(), null, "property", null, 1, 1, PropertyEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyEditor_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", "false", 1, 1, PropertyEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyEditor_WidgetType(), theEnvironmentPackage.getPropertyEditorType(), null, "widgetType", null, 1, 1, PropertyEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeWidgetEClass, CompositeWidget.class, "CompositeWidget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeWidget_Layout(), this.getLayout(), null, "layout", null, 1, 1, CompositeWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeWidget_Widgets(), this.getWidget(), null, "widgets", null, 0, -1, CompositeWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeWidget_WidgetType(), theEnvironmentPackage.getCompositeWidgetType(), null, "widgetType", null, 1, 1, CompositeWidget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(layoutEClass, Layout.class, "Layout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayout_LayoutType(), theEnvironmentPackage.getLayoutType(), null, "layoutType", null, 1, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetAttributeEClass, WidgetAttribute.class, "WidgetAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWidgetAttribute_Name(), ecorePackage.getEString(), "name", null, 1, 1, WidgetAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueAttributeEClass, ValueAttribute.class, "ValueAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueAttribute_Value(), ecorePackage.getEString(), "value", null, 1, 1, ValueAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceAttributeEClass, ReferenceAttribute.class, "ReferenceAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceAttribute_Value(), this.getUIComponent(), null, "value", null, 1, 1, ReferenceAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unknownComponentEClass, UnknownComponent.class, "UnknownComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnknownComponent_TypeName(), ecorePackage.getEString(), "typeName", null, 1, 1, UnknownComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UiPackageImpl
