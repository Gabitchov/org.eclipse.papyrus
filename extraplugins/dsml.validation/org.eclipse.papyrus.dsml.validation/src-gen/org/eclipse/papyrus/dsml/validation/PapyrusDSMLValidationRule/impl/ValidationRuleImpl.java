/**
 */
package org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule;

import org.eclipse.uml2.uml.Constraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#isEnabledByDefault <em>Is Enabled By Default</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidationRuleImpl extends MinimalEObjectImpl.Container implements ValidationRule {
	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final Severity SEVERITY_EDEFAULT = Severity.ERROR;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected Severity severity = SEVERITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final Mode MODE_EDEFAULT = Mode.BATCH;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected Mode mode = MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledByDefault() <em>Is Enabled By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledByDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENABLED_BY_DEFAULT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabledByDefault() <em>Is Enabled By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledByDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnabledByDefault = IS_ENABLED_BY_DEFAULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Constraint() <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Constraint()
	 * @generated
	 * @ordered
	 */
	protected Constraint base_Constraint;

	/**
	 * The default value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
	protected static final int STATUS_CODE_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
	protected int statusCode = STATUS_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<String> target;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected String class_ = CLASS_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValidationRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusDSMLValidationRulePackage.Literals.VALIDATION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(Severity newSeverity) {
		Severity oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(Mode newMode) {
		Mode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledByDefault() {
		return isEnabledByDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEnabledByDefault(boolean newIsEnabledByDefault) {
		boolean oldIsEnabledByDefault = isEnabledByDefault;
		isEnabledByDefault = newIsEnabledByDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__IS_ENABLED_BY_DEFAULT, oldIsEnabledByDefault, isEnabledByDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getBase_Constraint() {
		if (base_Constraint != null && base_Constraint.eIsProxy()) {
			InternalEObject oldBase_Constraint = (InternalEObject)base_Constraint;
			base_Constraint = (Constraint)eResolveProxy(oldBase_Constraint);
			if (base_Constraint != oldBase_Constraint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
			}
		}
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint basicGetBase_Constraint() {
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Constraint(Constraint newBase_Constraint) {
		Constraint oldBase_Constraint = base_Constraint;
		base_Constraint = newBase_Constraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusCode(int newStatusCode) {
		int oldStatusCode = statusCode;
		statusCode = newStatusCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__STATUS_CODE, oldStatusCode, statusCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTarget() {
		if (target == null) {
			target = new EDataTypeUniqueEList<String>(String.class, this, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__TARGET);
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass_(String newClass) {
		String oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__CLASS, oldClass, class_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusDSMLValidationRulePackage.VALIDATION_RULE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__SEVERITY:
				return getSeverity();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MODE:
				return getMode();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__IS_ENABLED_BY_DEFAULT:
				return isEnabledByDefault();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__BASE_CONSTRAINT:
				if (resolve) return getBase_Constraint();
				return basicGetBase_Constraint();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__STATUS_CODE:
				return getStatusCode();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MESSAGE:
				return getMessage();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__DESCRIPTION:
				return getDescription();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__TARGET:
				return getTarget();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__CLASS:
				return getClass_();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__ID:
				return getId();
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
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__SEVERITY:
				setSeverity((Severity)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MODE:
				setMode((Mode)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__IS_ENABLED_BY_DEFAULT:
				setIsEnabledByDefault((Boolean)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__STATUS_CODE:
				setStatusCode((Integer)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MESSAGE:
				setMessage((String)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__TARGET:
				getTarget().clear();
				getTarget().addAll((Collection<? extends String>)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__CLASS:
				setClass_((String)newValue);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__ID:
				setId((String)newValue);
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
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__IS_ENABLED_BY_DEFAULT:
				setIsEnabledByDefault(IS_ENABLED_BY_DEFAULT_EDEFAULT);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)null);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__STATUS_CODE:
				setStatusCode(STATUS_CODE_EDEFAULT);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__TARGET:
				getTarget().clear();
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__CLASS:
				setClass_(CLASS_EDEFAULT);
				return;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__ID:
				setId(ID_EDEFAULT);
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
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MODE:
				return mode != MODE_EDEFAULT;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__IS_ENABLED_BY_DEFAULT:
				return isEnabledByDefault != IS_ENABLED_BY_DEFAULT_EDEFAULT;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__BASE_CONSTRAINT:
				return base_Constraint != null;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__STATUS_CODE:
				return statusCode != STATUS_CODE_EDEFAULT;
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__TARGET:
				return target != null && !target.isEmpty();
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case PapyrusDSMLValidationRulePackage.VALIDATION_RULE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (severity: ");
		result.append(severity);
		result.append(", mode: ");
		result.append(mode);
		result.append(", isEnabledByDefault: ");
		result.append(isEnabledByDefault);
		result.append(", statusCode: ");
		result.append(statusCode);
		result.append(", message: ");
		result.append(message);
		result.append(", description: ");
		result.append(description);
		result.append(", target: ");
		result.append(target);
		result.append(", class: ");
		result.append(class_);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //ValidationRuleImpl
