/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.Tab;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tab</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl#getAfterTab <em>After Tab</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl#getSections <em>Sections</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.impl.TabImpl#isIndented <em>Indented</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TabImpl extends EObjectImpl implements Tab {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected String category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected String image = IMAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAfterTab() <em>After Tab</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfterTab()
	 * @generated
	 * @ordered
	 */
	protected Tab afterTab;

	/**
	 * The cached value of the '{@link #getSections() <em>Sections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSections()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> sections;

	/**
	 * The default value of the '{@link #isIndented() <em>Indented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIndented()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INDENTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIndented() <em>Indented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIndented()
	 * @generated
	 * @ordered
	 */
	protected boolean indented = INDENTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TabImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.TAB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.TAB__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.TAB__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(String newCategory) {
		String oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.TAB__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(String newImage) {
		String oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.TAB__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tab getAfterTab() {
		if (afterTab != null && afterTab.eIsProxy()) {
			InternalEObject oldAfterTab = (InternalEObject)afterTab;
			afterTab = (Tab)eResolveProxy(oldAfterTab);
			if (afterTab != oldAfterTab) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.TAB__AFTER_TAB, oldAfterTab, afterTab));
			}
		}
		return afterTab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tab basicGetAfterTab() {
		return afterTab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAfterTab(Tab newAfterTab) {
		Tab oldAfterTab = afterTab;
		afterTab = newAfterTab;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.TAB__AFTER_TAB, oldAfterTab, afterTab));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Section> getSections() {
		if (sections == null) {
			sections = new EObjectContainmentWithInverseEList<Section>(Section.class, this, ContextsPackage.TAB__SECTIONS, ContextsPackage.SECTION__TAB);
		}
		return sections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIndented() {
		return indented;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndented(boolean newIndented) {
		boolean oldIndented = indented;
		indented = newIndented;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.TAB__INDENTED, oldIndented, indented));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.TAB__SECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSections()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.TAB__SECTIONS:
				return ((InternalEList<?>)getSections()).basicRemove(otherEnd, msgs);
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
			case ContextsPackage.TAB__LABEL:
				return getLabel();
			case ContextsPackage.TAB__ID:
				return getId();
			case ContextsPackage.TAB__CATEGORY:
				return getCategory();
			case ContextsPackage.TAB__IMAGE:
				return getImage();
			case ContextsPackage.TAB__AFTER_TAB:
				if (resolve) return getAfterTab();
				return basicGetAfterTab();
			case ContextsPackage.TAB__SECTIONS:
				return getSections();
			case ContextsPackage.TAB__INDENTED:
				return isIndented();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ContextsPackage.TAB__LABEL:
				setLabel((String)newValue);
				return;
			case ContextsPackage.TAB__ID:
				setId((String)newValue);
				return;
			case ContextsPackage.TAB__CATEGORY:
				setCategory((String)newValue);
				return;
			case ContextsPackage.TAB__IMAGE:
				setImage((String)newValue);
				return;
			case ContextsPackage.TAB__AFTER_TAB:
				setAfterTab((Tab)newValue);
				return;
			case ContextsPackage.TAB__SECTIONS:
				getSections().clear();
				getSections().addAll((Collection<? extends Section>)newValue);
				return;
			case ContextsPackage.TAB__INDENTED:
				setIndented((Boolean)newValue);
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
			case ContextsPackage.TAB__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case ContextsPackage.TAB__ID:
				setId(ID_EDEFAULT);
				return;
			case ContextsPackage.TAB__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case ContextsPackage.TAB__IMAGE:
				setImage(IMAGE_EDEFAULT);
				return;
			case ContextsPackage.TAB__AFTER_TAB:
				setAfterTab((Tab)null);
				return;
			case ContextsPackage.TAB__SECTIONS:
				getSections().clear();
				return;
			case ContextsPackage.TAB__INDENTED:
				setIndented(INDENTED_EDEFAULT);
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
			case ContextsPackage.TAB__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case ContextsPackage.TAB__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ContextsPackage.TAB__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case ContextsPackage.TAB__IMAGE:
				return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
			case ContextsPackage.TAB__AFTER_TAB:
				return afterTab != null;
			case ContextsPackage.TAB__SECTIONS:
				return sections != null && !sections.isEmpty();
			case ContextsPackage.TAB__INDENTED:
				return indented != INDENTED_EDEFAULT;
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
		result.append(" (label: ");
		result.append(label);
		result.append(", id: ");
		result.append(id);
		result.append(", category: ");
		result.append(category);
		result.append(", image: ");
		result.append(image);
		result.append(", indented: ");
		result.append(indented);
		result.append(')');
		return result.toString();
	}

} //TabImpl
