/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.views.properties.ui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.contexts.UnknownProperty;
import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;
import org.eclipse.papyrus.views.properties.ui.PropertyEditor;
import org.eclipse.papyrus.views.properties.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.impl.PropertyEditorImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.impl.PropertyEditorImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.impl.PropertyEditorImpl#getWidgetType <em>Widget Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.impl.PropertyEditorImpl#getUnresolvedProperty <em>Unresolved Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.impl.PropertyEditorImpl#getContentProviderClass <em>Content Provider Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.impl.PropertyEditorImpl#isShowLabel <em>Show Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.views.properties.ui.impl.PropertyEditorImpl#getCustomLabel <em>Custom Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyEditorImpl extends WidgetImpl implements PropertyEditor {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWidgetType() <em>Widget Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgetType()
	 * @generated
	 * @ordered
	 */
	protected PropertyEditorType widgetType;

	/**
	 * The cached value of the '{@link #getUnresolvedProperty() <em>Unresolved Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnresolvedProperty()
	 * @generated
	 * @ordered
	 */
	protected UnknownProperty unresolvedProperty;

	/**
	 * The default value of the '{@link #getContentProviderClass() <em>Content Provider Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentProviderClass()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_PROVIDER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentProviderClass() <em>Content Provider Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentProviderClass()
	 * @generated
	 * @ordered
	 */
	protected String contentProviderClass = CONTENT_PROVIDER_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #isShowLabel() <em>Show Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowLabel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_LABEL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isShowLabel() <em>Show Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowLabel()
	 * @generated
	 * @ordered
	 */
	protected boolean showLabel = SHOW_LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomLabel() <em>Custom Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOM_LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomLabel() <em>Custom Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomLabel()
	 * @generated
	 * @ordered
	 */
	protected String customLabel = CUSTOM_LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.PROPERTY_EDITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (Property)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.PROPERTY_EDITOR__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PROPERTY_EDITOR__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PROPERTY_EDITOR__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyEditorType getWidgetType() {
		if (widgetType != null && widgetType.eIsProxy()) {
			InternalEObject oldWidgetType = (InternalEObject)widgetType;
			widgetType = (PropertyEditorType)eResolveProxy(oldWidgetType);
			if (widgetType != oldWidgetType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.PROPERTY_EDITOR__WIDGET_TYPE, oldWidgetType, widgetType));
			}
		}
		return widgetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyEditorType basicGetWidgetType() {
		return widgetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidgetType(PropertyEditorType newWidgetType) {
		PropertyEditorType oldWidgetType = widgetType;
		widgetType = newWidgetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PROPERTY_EDITOR__WIDGET_TYPE, oldWidgetType, widgetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownProperty getUnresolvedProperty() {
		return unresolvedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnresolvedProperty(UnknownProperty newUnresolvedProperty, NotificationChain msgs) {
		UnknownProperty oldUnresolvedProperty = unresolvedProperty;
		unresolvedProperty = newUnresolvedProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY, oldUnresolvedProperty, newUnresolvedProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnresolvedProperty(UnknownProperty newUnresolvedProperty) {
		if (newUnresolvedProperty != unresolvedProperty) {
			NotificationChain msgs = null;
			if (unresolvedProperty != null)
				msgs = ((InternalEObject)unresolvedProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY, null, msgs);
			if (newUnresolvedProperty != null)
				msgs = ((InternalEObject)newUnresolvedProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY, null, msgs);
			msgs = basicSetUnresolvedProperty(newUnresolvedProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY, newUnresolvedProperty, newUnresolvedProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContentProviderClass() {
		return contentProviderClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentProviderClass(String newContentProviderClass) {
		String oldContentProviderClass = contentProviderClass;
		contentProviderClass = newContentProviderClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PROPERTY_EDITOR__CONTENT_PROVIDER_CLASS, oldContentProviderClass, contentProviderClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowLabel() {
		return showLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowLabel(boolean newShowLabel) {
		boolean oldShowLabel = showLabel;
		showLabel = newShowLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PROPERTY_EDITOR__SHOW_LABEL, oldShowLabel, showLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomLabel() {
		return customLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomLabel(String newCustomLabel) {
		String oldCustomLabel = customLabel;
		customLabel = newCustomLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.PROPERTY_EDITOR__CUSTOM_LABEL, oldCustomLabel, customLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY:
				return basicSetUnresolvedProperty(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiPackage.PROPERTY_EDITOR__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case UiPackage.PROPERTY_EDITOR__READ_ONLY:
				return isReadOnly();
			case UiPackage.PROPERTY_EDITOR__WIDGET_TYPE:
				if (resolve) return getWidgetType();
				return basicGetWidgetType();
			case UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY:
				return getUnresolvedProperty();
			case UiPackage.PROPERTY_EDITOR__CONTENT_PROVIDER_CLASS:
				return getContentProviderClass();
			case UiPackage.PROPERTY_EDITOR__SHOW_LABEL:
				return isShowLabel();
			case UiPackage.PROPERTY_EDITOR__CUSTOM_LABEL:
				return getCustomLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UiPackage.PROPERTY_EDITOR__PROPERTY:
				setProperty((Property)newValue);
				return;
			case UiPackage.PROPERTY_EDITOR__READ_ONLY:
				setReadOnly((Boolean)newValue);
				return;
			case UiPackage.PROPERTY_EDITOR__WIDGET_TYPE:
				setWidgetType((PropertyEditorType)newValue);
				return;
			case UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY:
				setUnresolvedProperty((UnknownProperty)newValue);
				return;
			case UiPackage.PROPERTY_EDITOR__CONTENT_PROVIDER_CLASS:
				setContentProviderClass((String)newValue);
				return;
			case UiPackage.PROPERTY_EDITOR__SHOW_LABEL:
				setShowLabel((Boolean)newValue);
				return;
			case UiPackage.PROPERTY_EDITOR__CUSTOM_LABEL:
				setCustomLabel((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UiPackage.PROPERTY_EDITOR__PROPERTY:
				setProperty((Property)null);
				return;
			case UiPackage.PROPERTY_EDITOR__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case UiPackage.PROPERTY_EDITOR__WIDGET_TYPE:
				setWidgetType((PropertyEditorType)null);
				return;
			case UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY:
				setUnresolvedProperty((UnknownProperty)null);
				return;
			case UiPackage.PROPERTY_EDITOR__CONTENT_PROVIDER_CLASS:
				setContentProviderClass(CONTENT_PROVIDER_CLASS_EDEFAULT);
				return;
			case UiPackage.PROPERTY_EDITOR__SHOW_LABEL:
				setShowLabel(SHOW_LABEL_EDEFAULT);
				return;
			case UiPackage.PROPERTY_EDITOR__CUSTOM_LABEL:
				setCustomLabel(CUSTOM_LABEL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UiPackage.PROPERTY_EDITOR__PROPERTY:
				return property != null;
			case UiPackage.PROPERTY_EDITOR__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case UiPackage.PROPERTY_EDITOR__WIDGET_TYPE:
				return widgetType != null;
			case UiPackage.PROPERTY_EDITOR__UNRESOLVED_PROPERTY:
				return unresolvedProperty != null;
			case UiPackage.PROPERTY_EDITOR__CONTENT_PROVIDER_CLASS:
				return CONTENT_PROVIDER_CLASS_EDEFAULT == null ? contentProviderClass != null : !CONTENT_PROVIDER_CLASS_EDEFAULT.equals(contentProviderClass);
			case UiPackage.PROPERTY_EDITOR__SHOW_LABEL:
				return showLabel != SHOW_LABEL_EDEFAULT;
			case UiPackage.PROPERTY_EDITOR__CUSTOM_LABEL:
				return CUSTOM_LABEL_EDEFAULT == null ? customLabel != null : !CUSTOM_LABEL_EDEFAULT.equals(customLabel);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (readOnly: ");
		result.append(readOnly);
		result.append(", contentProviderClass: ");
		result.append(contentProviderClass);
		result.append(", showLabel: ");
		result.append(showLabel);
		result.append(", customLabel: ");
		result.append(customLabel);
		result.append(')');
		return result.toString();
	}

} //PropertyEditorImpl
