/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.views.properties.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.views.properties.ui.*;
import org.eclipse.papyrus.views.properties.ui.CompositeWidget;
import org.eclipse.papyrus.views.properties.ui.Element;
import org.eclipse.papyrus.views.properties.ui.Layout;
import org.eclipse.papyrus.views.properties.ui.PropertyEditor;
import org.eclipse.papyrus.views.properties.ui.ReferenceAttribute;
import org.eclipse.papyrus.views.properties.ui.StandardWidget;
import org.eclipse.papyrus.views.properties.ui.UIComponent;
import org.eclipse.papyrus.views.properties.ui.UiPackage;
import org.eclipse.papyrus.views.properties.ui.UnknownComponent;
import org.eclipse.papyrus.views.properties.ui.ValueAttribute;
import org.eclipse.papyrus.views.properties.ui.Widget;
import org.eclipse.papyrus.views.properties.ui.WidgetAttribute;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.views.properties.ui.UiPackage
 * @generated
 */
public class UiSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UiPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiSwitch() {
		if (modelPackage == null) {
			modelPackage = UiPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UiPackage.ELEMENT: {
				Element element = (Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.UI_COMPONENT: {
				UIComponent uiComponent = (UIComponent)theEObject;
				T result = caseUIComponent(uiComponent);
				if (result == null) result = caseElement(uiComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.WIDGET: {
				Widget widget = (Widget)theEObject;
				T result = caseWidget(widget);
				if (result == null) result = caseUIComponent(widget);
				if (result == null) result = caseElement(widget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.STANDARD_WIDGET: {
				StandardWidget standardWidget = (StandardWidget)theEObject;
				T result = caseStandardWidget(standardWidget);
				if (result == null) result = caseWidget(standardWidget);
				if (result == null) result = caseUIComponent(standardWidget);
				if (result == null) result = caseElement(standardWidget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.PROPERTY_EDITOR: {
				PropertyEditor propertyEditor = (PropertyEditor)theEObject;
				T result = casePropertyEditor(propertyEditor);
				if (result == null) result = caseWidget(propertyEditor);
				if (result == null) result = caseUIComponent(propertyEditor);
				if (result == null) result = caseElement(propertyEditor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.COMPOSITE_WIDGET: {
				CompositeWidget compositeWidget = (CompositeWidget)theEObject;
				T result = caseCompositeWidget(compositeWidget);
				if (result == null) result = caseWidget(compositeWidget);
				if (result == null) result = caseUIComponent(compositeWidget);
				if (result == null) result = caseElement(compositeWidget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.UNKNOWN_COMPONENT: {
				UnknownComponent unknownComponent = (UnknownComponent)theEObject;
				T result = caseUnknownComponent(unknownComponent);
				if (result == null) result = caseWidget(unknownComponent);
				if (result == null) result = caseUIComponent(unknownComponent);
				if (result == null) result = caseElement(unknownComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.LAYOUT: {
				Layout layout = (Layout)theEObject;
				T result = caseLayout(layout);
				if (result == null) result = caseUIComponent(layout);
				if (result == null) result = caseElement(layout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.WIDGET_ATTRIBUTE: {
				WidgetAttribute widgetAttribute = (WidgetAttribute)theEObject;
				T result = caseWidgetAttribute(widgetAttribute);
				if (result == null) result = caseElement(widgetAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.VALUE_ATTRIBUTE: {
				ValueAttribute valueAttribute = (ValueAttribute)theEObject;
				T result = caseValueAttribute(valueAttribute);
				if (result == null) result = caseWidgetAttribute(valueAttribute);
				if (result == null) result = caseElement(valueAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.REFERENCE_ATTRIBUTE: {
				ReferenceAttribute referenceAttribute = (ReferenceAttribute)theEObject;
				T result = caseReferenceAttribute(referenceAttribute);
				if (result == null) result = caseWidgetAttribute(referenceAttribute);
				if (result == null) result = caseElement(referenceAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UI Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UI Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUIComponent(UIComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWidget(Widget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Standard Widget</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Standard Widget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStandardWidget(StandardWidget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyEditor(PropertyEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Widget</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Widget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeWidget(CompositeWidget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownComponent(UnknownComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayout(Layout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWidgetAttribute(WidgetAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueAttribute(ValueAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceAttribute(ReferenceAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //UiSwitch
