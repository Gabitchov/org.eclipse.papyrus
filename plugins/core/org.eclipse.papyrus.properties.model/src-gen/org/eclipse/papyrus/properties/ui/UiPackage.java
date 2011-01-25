/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.ui;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.properties.ui.UiFactory
 * @model kind="package"
 * @generated
 */
public interface UiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ui";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/properties/ui";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ui";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UiPackage eINSTANCE = org.eclipse.papyrus.properties.ui.impl.UiPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.ElementImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.UIComponentImpl <em>UI Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.UIComponentImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getUIComponent()
	 * @generated
	 */
	int UI_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_COMPONENT__ATTRIBUTES = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UI Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_COMPONENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.WidgetImpl <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.WidgetImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__ATTRIBUTES = UI_COMPONENT__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = UI_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.StandardWidgetImpl <em>Standard Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.StandardWidgetImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getStandardWidget()
	 * @generated
	 */
	int STANDARD_WIDGET = 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_WIDGET__ATTRIBUTES = WIDGET__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Widget Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_WIDGET__WIDGET_TYPE = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Standard Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_WIDGET_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.PropertyEditorImpl <em>Property Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.PropertyEditorImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getPropertyEditor()
	 * @generated
	 */
	int PROPERTY_EDITOR = 4;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR__ATTRIBUTES = WIDGET__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR__PROPERTY = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR__READ_ONLY = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Widget Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR__WIDGET_TYPE = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_EDITOR_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.CompositeWidgetImpl <em>Composite Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.CompositeWidgetImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getCompositeWidget()
	 * @generated
	 */
	int COMPOSITE_WIDGET = 5;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_WIDGET__ATTRIBUTES = WIDGET__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_WIDGET__LAYOUT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_WIDGET__WIDGETS = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Widget Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_WIDGET__WIDGET_TYPE = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_WIDGET_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.LayoutImpl <em>Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.LayoutImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getLayout()
	 * @generated
	 */
	int LAYOUT = 6;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__ATTRIBUTES = UI_COMPONENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Layout Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__LAYOUT_TYPE = UI_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_FEATURE_COUNT = UI_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.WidgetAttributeImpl <em>Widget Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.WidgetAttributeImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getWidgetAttribute()
	 * @generated
	 */
	int WIDGET_ATTRIBUTE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_ATTRIBUTE__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Widget Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_ATTRIBUTE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.ValueAttributeImpl <em>Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.ValueAttributeImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getValueAttribute()
	 * @generated
	 */
	int VALUE_ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ATTRIBUTE__NAME = WIDGET_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ATTRIBUTE__VALUE = WIDGET_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ATTRIBUTE_FEATURE_COUNT = WIDGET_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.ReferenceAttributeImpl <em>Reference Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.ReferenceAttributeImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getReferenceAttribute()
	 * @generated
	 */
	int REFERENCE_ATTRIBUTE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE__NAME = WIDGET_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE__VALUE = WIDGET_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATTRIBUTE_FEATURE_COUNT = WIDGET_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.ui.impl.UnknownComponentImpl <em>Unknown Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.properties.ui.impl.UnknownComponentImpl
	 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getUnknownComponent()
	 * @generated
	 */
	int UNKNOWN_COMPONENT = 10;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_COMPONENT__ATTRIBUTES = WIDGET__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_COMPONENT__TYPE_NAME = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unknown Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_COMPONENT_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.papyrus.properties.ui.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.UIComponent <em>UI Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Component</em>'.
	 * @see org.eclipse.papyrus.properties.ui.UIComponent
	 * @generated
	 */
	EClass getUIComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.ui.UIComponent#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.eclipse.papyrus.properties.ui.UIComponent#getAttributes()
	 * @see #getUIComponent()
	 * @generated
	 */
	EReference getUIComponent_Attributes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see org.eclipse.papyrus.properties.ui.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.StandardWidget <em>Standard Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Standard Widget</em>'.
	 * @see org.eclipse.papyrus.properties.ui.StandardWidget
	 * @generated
	 */
	EClass getStandardWidget();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.ui.StandardWidget#getWidgetType <em>Widget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Widget Type</em>'.
	 * @see org.eclipse.papyrus.properties.ui.StandardWidget#getWidgetType()
	 * @see #getStandardWidget()
	 * @generated
	 */
	EReference getStandardWidget_WidgetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.PropertyEditor <em>Property Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Editor</em>'.
	 * @see org.eclipse.papyrus.properties.ui.PropertyEditor
	 * @generated
	 */
	EClass getPropertyEditor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.ui.PropertyEditor#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.papyrus.properties.ui.PropertyEditor#getProperty()
	 * @see #getPropertyEditor()
	 * @generated
	 */
	EReference getPropertyEditor_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.ui.PropertyEditor#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see org.eclipse.papyrus.properties.ui.PropertyEditor#isReadOnly()
	 * @see #getPropertyEditor()
	 * @generated
	 */
	EAttribute getPropertyEditor_ReadOnly();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.ui.PropertyEditor#getWidgetType <em>Widget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Widget Type</em>'.
	 * @see org.eclipse.papyrus.properties.ui.PropertyEditor#getWidgetType()
	 * @see #getPropertyEditor()
	 * @generated
	 */
	EReference getPropertyEditor_WidgetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.CompositeWidget <em>Composite Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Widget</em>'.
	 * @see org.eclipse.papyrus.properties.ui.CompositeWidget
	 * @generated
	 */
	EClass getCompositeWidget();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.properties.ui.CompositeWidget#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.properties.ui.CompositeWidget#getLayout()
	 * @see #getCompositeWidget()
	 * @generated
	 */
	EReference getCompositeWidget_Layout();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.properties.ui.CompositeWidget#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widgets</em>'.
	 * @see org.eclipse.papyrus.properties.ui.CompositeWidget#getWidgets()
	 * @see #getCompositeWidget()
	 * @generated
	 */
	EReference getCompositeWidget_Widgets();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.ui.CompositeWidget#getWidgetType <em>Widget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Widget Type</em>'.
	 * @see org.eclipse.papyrus.properties.ui.CompositeWidget#getWidgetType()
	 * @see #getCompositeWidget()
	 * @generated
	 */
	EReference getCompositeWidget_WidgetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.properties.ui.Layout
	 * @generated
	 */
	EClass getLayout();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.properties.ui.Layout#getLayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout Type</em>'.
	 * @see org.eclipse.papyrus.properties.ui.Layout#getLayoutType()
	 * @see #getLayout()
	 * @generated
	 */
	EReference getLayout_LayoutType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.WidgetAttribute <em>Widget Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Attribute</em>'.
	 * @see org.eclipse.papyrus.properties.ui.WidgetAttribute
	 * @generated
	 */
	EClass getWidgetAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.ui.WidgetAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.ui.WidgetAttribute#getName()
	 * @see #getWidgetAttribute()
	 * @generated
	 */
	EAttribute getWidgetAttribute_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.ValueAttribute <em>Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Attribute</em>'.
	 * @see org.eclipse.papyrus.properties.ui.ValueAttribute
	 * @generated
	 */
	EClass getValueAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.ui.ValueAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.properties.ui.ValueAttribute#getValue()
	 * @see #getValueAttribute()
	 * @generated
	 */
	EAttribute getValueAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.ReferenceAttribute <em>Reference Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Attribute</em>'.
	 * @see org.eclipse.papyrus.properties.ui.ReferenceAttribute
	 * @generated
	 */
	EClass getReferenceAttribute();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.properties.ui.ReferenceAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.properties.ui.ReferenceAttribute#getValue()
	 * @see #getReferenceAttribute()
	 * @generated
	 */
	EReference getReferenceAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.ui.UnknownComponent <em>Unknown Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Component</em>'.
	 * @see org.eclipse.papyrus.properties.ui.UnknownComponent
	 * @generated
	 */
	EClass getUnknownComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.ui.UnknownComponent#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see org.eclipse.papyrus.properties.ui.UnknownComponent#getTypeName()
	 * @see #getUnknownComponent()
	 * @generated
	 */
	EAttribute getUnknownComponent_TypeName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UiFactory getUiFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.ElementImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.UIComponentImpl <em>UI Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.UIComponentImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getUIComponent()
		 * @generated
		 */
		EClass UI_COMPONENT = eINSTANCE.getUIComponent();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_COMPONENT__ATTRIBUTES = eINSTANCE.getUIComponent_Attributes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.WidgetImpl <em>Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.WidgetImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.StandardWidgetImpl <em>Standard Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.StandardWidgetImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getStandardWidget()
		 * @generated
		 */
		EClass STANDARD_WIDGET = eINSTANCE.getStandardWidget();

		/**
		 * The meta object literal for the '<em><b>Widget Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_WIDGET__WIDGET_TYPE = eINSTANCE.getStandardWidget_WidgetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.PropertyEditorImpl <em>Property Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.PropertyEditorImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getPropertyEditor()
		 * @generated
		 */
		EClass PROPERTY_EDITOR = eINSTANCE.getPropertyEditor();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_EDITOR__PROPERTY = eINSTANCE.getPropertyEditor_Property();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_EDITOR__READ_ONLY = eINSTANCE.getPropertyEditor_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Widget Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_EDITOR__WIDGET_TYPE = eINSTANCE.getPropertyEditor_WidgetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.CompositeWidgetImpl <em>Composite Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.CompositeWidgetImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getCompositeWidget()
		 * @generated
		 */
		EClass COMPOSITE_WIDGET = eINSTANCE.getCompositeWidget();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_WIDGET__LAYOUT = eINSTANCE.getCompositeWidget_Layout();

		/**
		 * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_WIDGET__WIDGETS = eINSTANCE.getCompositeWidget_Widgets();

		/**
		 * The meta object literal for the '<em><b>Widget Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_WIDGET__WIDGET_TYPE = eINSTANCE.getCompositeWidget_WidgetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.LayoutImpl <em>Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.LayoutImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getLayout()
		 * @generated
		 */
		EClass LAYOUT = eINSTANCE.getLayout();

		/**
		 * The meta object literal for the '<em><b>Layout Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT__LAYOUT_TYPE = eINSTANCE.getLayout_LayoutType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.WidgetAttributeImpl <em>Widget Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.WidgetAttributeImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getWidgetAttribute()
		 * @generated
		 */
		EClass WIDGET_ATTRIBUTE = eINSTANCE.getWidgetAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_ATTRIBUTE__NAME = eINSTANCE.getWidgetAttribute_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.ValueAttributeImpl <em>Value Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.ValueAttributeImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getValueAttribute()
		 * @generated
		 */
		EClass VALUE_ATTRIBUTE = eINSTANCE.getValueAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_ATTRIBUTE__VALUE = eINSTANCE.getValueAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.ReferenceAttributeImpl <em>Reference Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.ReferenceAttributeImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getReferenceAttribute()
		 * @generated
		 */
		EClass REFERENCE_ATTRIBUTE = eINSTANCE.getReferenceAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_ATTRIBUTE__VALUE = eINSTANCE.getReferenceAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.ui.impl.UnknownComponentImpl <em>Unknown Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.properties.ui.impl.UnknownComponentImpl
		 * @see org.eclipse.papyrus.properties.ui.impl.UiPackageImpl#getUnknownComponent()
		 * @generated
		 */
		EClass UNKNOWN_COMPONENT = eINSTANCE.getUnknownComponent();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNKNOWN_COMPONENT__TYPE_NAME = eINSTANCE.getUnknownComponent_TypeName();

	}

} //UiPackage
