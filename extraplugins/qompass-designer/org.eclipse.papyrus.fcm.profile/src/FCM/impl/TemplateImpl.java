/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM.impl;

import FCM.ActualChoice;
import FCM.FCMPackage;
import FCM.Template;
import FCM.TemplateKind;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link FCM.impl.TemplateImpl#getTemplateParams <em>Template Params</em>}</li>
 *   <li>{@link FCM.impl.TemplateImpl#getBase_Element <em>Base Element</em>}</li>
 *   <li>{@link FCM.impl.TemplateImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link FCM.impl.TemplateImpl#getActualChoice <em>Actual Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateImpl extends EObjectImpl implements Template {
	/**
	 * The cached value of the '{@link #getTemplateParams() <em>Template Params</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParams()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> templateParams;

	/**
	 * The cached value of the '{@link #getBase_Element() <em>Base Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Element()
	 * @generated
	 * @ordered
	 */
	protected Element base_Element;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final TemplateKind KIND_EDEFAULT = TemplateKind.PASS_FORMAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected TemplateKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getActualChoice() <em>Actual Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualChoice()
	 * @generated
	 * @ordered
	 */
	protected static final ActualChoice ACTUAL_CHOICE_EDEFAULT = ActualChoice.PASS_ACTUAL;

	/**
	 * The cached value of the '{@link #getActualChoice() <em>Actual Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualChoice()
	 * @generated
	 * @ordered
	 */
	protected ActualChoice actualChoice = ACTUAL_CHOICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getTemplateParams() {
		if (templateParams == null) {
			templateParams = new EObjectResolvingEList<Classifier>(Classifier.class, this, FCMPackage.TEMPLATE__TEMPLATE_PARAMS);
		}
		return templateParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getBase_Element() {
		if (base_Element != null && base_Element.eIsProxy()) {
			InternalEObject oldBase_Element = (InternalEObject)base_Element;
			base_Element = (Element)eResolveProxy(oldBase_Element);
			if (base_Element != oldBase_Element) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.TEMPLATE__BASE_ELEMENT, oldBase_Element, base_Element));
			}
		}
		return base_Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetBase_Element() {
		return base_Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Element(Element newBase_Element) {
		Element oldBase_Element = base_Element;
		base_Element = newBase_Element;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.TEMPLATE__BASE_ELEMENT, oldBase_Element, base_Element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(TemplateKind newKind) {
		TemplateKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.TEMPLATE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualChoice getActualChoice() {
		return actualChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualChoice(ActualChoice newActualChoice) {
		ActualChoice oldActualChoice = actualChoice;
		actualChoice = newActualChoice == null ? ACTUAL_CHOICE_EDEFAULT : newActualChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.TEMPLATE__ACTUAL_CHOICE, oldActualChoice, actualChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.TEMPLATE__TEMPLATE_PARAMS:
				return getTemplateParams();
			case FCMPackage.TEMPLATE__BASE_ELEMENT:
				if (resolve) return getBase_Element();
				return basicGetBase_Element();
			case FCMPackage.TEMPLATE__KIND:
				return getKind();
			case FCMPackage.TEMPLATE__ACTUAL_CHOICE:
				return getActualChoice();
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
			case FCMPackage.TEMPLATE__TEMPLATE_PARAMS:
				getTemplateParams().clear();
				getTemplateParams().addAll((Collection<? extends Classifier>)newValue);
				return;
			case FCMPackage.TEMPLATE__BASE_ELEMENT:
				setBase_Element((Element)newValue);
				return;
			case FCMPackage.TEMPLATE__KIND:
				setKind((TemplateKind)newValue);
				return;
			case FCMPackage.TEMPLATE__ACTUAL_CHOICE:
				setActualChoice((ActualChoice)newValue);
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
			case FCMPackage.TEMPLATE__TEMPLATE_PARAMS:
				getTemplateParams().clear();
				return;
			case FCMPackage.TEMPLATE__BASE_ELEMENT:
				setBase_Element((Element)null);
				return;
			case FCMPackage.TEMPLATE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case FCMPackage.TEMPLATE__ACTUAL_CHOICE:
				setActualChoice(ACTUAL_CHOICE_EDEFAULT);
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
			case FCMPackage.TEMPLATE__TEMPLATE_PARAMS:
				return templateParams != null && !templateParams.isEmpty();
			case FCMPackage.TEMPLATE__BASE_ELEMENT:
				return base_Element != null;
			case FCMPackage.TEMPLATE__KIND:
				return kind != KIND_EDEFAULT;
			case FCMPackage.TEMPLATE__ACTUAL_CHOICE:
				return actualChoice != ACTUAL_CHOICE_EDEFAULT;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", actualChoice: ");
		result.append(actualChoice);
		result.append(')');
		return result.toString();
	}

} //TemplateImpl
