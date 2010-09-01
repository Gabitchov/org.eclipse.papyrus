/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.domaincontextcodegen.AdviceBinding;
import org.eclipse.papyrus.domaincontextcodegen.Binding;
import org.eclipse.papyrus.domaincontextcodegen.DomainContext;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getIClientContextID <em>IClient Context ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getSpecializationOf <em>Specialization Of</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getElementTypeIDPrefix <em>Element Type ID Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getElementTypeNamePrefix <em>Element Type Name Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getMatcherPatch <em>Matcher Patch</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getElementTypes <em>Element Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getDefaultHelperPath <em>Default Helper Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getAdvicebindings <em>Advicebindings</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainContextImpl extends EObjectImpl implements DomainContext {
	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIClientContextID() <em>IClient Context ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIClientContextID()
	 * @generated
	 * @ordered
	 */
	protected static final String ICLIENT_CONTEXT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIClientContextID() <em>IClient Context ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIClientContextID()
	 * @generated
	 * @ordered
	 */
	protected String iClientContextID = ICLIENT_CONTEXT_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected EPackage metamodel;

	/**
	 * The cached value of the '{@link #getSpecializationOf() <em>Specialization Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializationOf()
	 * @generated
	 * @ordered
	 */
	protected DomainContext specializationOf;

	/**
	 * The default value of the '{@link #getElementTypeIDPrefix() <em>Element Type ID Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeIDPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_ID_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeIDPrefix() <em>Element Type ID Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeIDPrefix()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeIDPrefix = ELEMENT_TYPE_ID_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementTypeNamePrefix() <em>Element Type Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeNamePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_NAME_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeNamePrefix() <em>Element Type Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeNamePrefix()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeNamePrefix = ELEMENT_TYPE_NAME_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getMatcherPatch() <em>Matcher Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcherPatch()
	 * @generated
	 * @ordered
	 */
	protected static final String MATCHER_PATCH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMatcherPatch() <em>Matcher Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcherPatch()
	 * @generated
	 * @ordered
	 */
	protected String matcherPatch = MATCHER_PATCH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElementTypes() <em>Element Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementType> elementTypes;

	/**
	 * The default value of the '{@link #getDefaultHelperPath() <em>Default Helper Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultHelperPath()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_HELPER_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultHelperPath() <em>Default Helper Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultHelperPath()
	 * @generated
	 * @ordered
	 */
	protected String defaultHelperPath = DEFAULT_HELPER_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdvicebindings() <em>Advicebindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvicebindings()
	 * @generated
	 * @ordered
	 */
	protected EList<AdviceBinding> advicebindings;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<Binding> bindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIClientContextID() {
		return iClientContextID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIClientContextID(String newIClientContextID) {
		String oldIClientContextID = iClientContextID;
		iClientContextID = newIClientContextID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID, oldIClientContextID, iClientContextID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getMetamodel() {
		if (metamodel != null && metamodel.eIsProxy()) {
			InternalEObject oldMetamodel = (InternalEObject)metamodel;
			metamodel = (EPackage)eResolveProxy(oldMetamodel);
			if (metamodel != oldMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL, oldMetamodel, metamodel));
			}
		}
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodel(EPackage newMetamodel) {
		EPackage oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL, oldMetamodel, metamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainContext getSpecializationOf() {
		if (specializationOf != null && specializationOf.eIsProxy()) {
			InternalEObject oldSpecializationOf = (InternalEObject)specializationOf;
			specializationOf = (DomainContext)eResolveProxy(oldSpecializationOf);
			if (specializationOf != oldSpecializationOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF, oldSpecializationOf, specializationOf));
			}
		}
		return specializationOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainContext basicGetSpecializationOf() {
		return specializationOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecializationOf(DomainContext newSpecializationOf) {
		DomainContext oldSpecializationOf = specializationOf;
		specializationOf = newSpecializationOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF, oldSpecializationOf, specializationOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementTypeIDPrefix() {
		return elementTypeIDPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeIDPrefix(String newElementTypeIDPrefix) {
		String oldElementTypeIDPrefix = elementTypeIDPrefix;
		elementTypeIDPrefix = newElementTypeIDPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX, oldElementTypeIDPrefix, elementTypeIDPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementTypeNamePrefix() {
		return elementTypeNamePrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeNamePrefix(String newElementTypeNamePrefix) {
		String oldElementTypeNamePrefix = elementTypeNamePrefix;
		elementTypeNamePrefix = newElementTypeNamePrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX, oldElementTypeNamePrefix, elementTypeNamePrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMatcherPatch() {
		return matcherPatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcherPatch(String newMatcherPatch) {
		String oldMatcherPatch = matcherPatch;
		matcherPatch = newMatcherPatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__MATCHER_PATCH, oldMatcherPatch, matcherPatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementType> getElementTypes() {
		if (elementTypes == null) {
			elementTypes = new EObjectContainmentEList<ElementType>(ElementType.class, this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES);
		}
		return elementTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultHelperPath() {
		return defaultHelperPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultHelperPath(String newDefaultHelperPath) {
		String oldDefaultHelperPath = defaultHelperPath;
		defaultHelperPath = newDefaultHelperPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH, oldDefaultHelperPath, defaultHelperPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__PROJECT_NAME, oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdviceBinding> getAdvicebindings() {
		if (advicebindings == null) {
			advicebindings = new EObjectContainmentEList<AdviceBinding>(AdviceBinding.class, this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICEBINDINGS);
		}
		return advicebindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Binding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<Binding>(Binding.class, this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
				return ((InternalEList<?>)getElementTypes()).basicRemove(otherEnd, msgs);
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICEBINDINGS:
				return ((InternalEList<?>)getAdvicebindings()).basicRemove(otherEnd, msgs);
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
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
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__PROJECT_NAME:
				return getProjectName();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID:
				return getIClientContextID();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL:
				if (resolve) return getMetamodel();
				return basicGetMetamodel();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF:
				if (resolve) return getSpecializationOf();
				return basicGetSpecializationOf();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX:
				return getElementTypeIDPrefix();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX:
				return getElementTypeNamePrefix();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MATCHER_PATCH:
				return getMatcherPatch();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
				return getElementTypes();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
				return getDefaultHelperPath();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICEBINDINGS:
				return getAdvicebindings();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
				return getBindings();
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
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__PROJECT_NAME:
				setProjectName((String)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID:
				setIClientContextID((String)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL:
				setMetamodel((EPackage)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF:
				setSpecializationOf((DomainContext)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX:
				setElementTypeIDPrefix((String)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX:
				setElementTypeNamePrefix((String)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MATCHER_PATCH:
				setMatcherPatch((String)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
				getElementTypes().clear();
				getElementTypes().addAll((Collection<? extends ElementType>)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
				setDefaultHelperPath((String)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICEBINDINGS:
				getAdvicebindings().clear();
				getAdvicebindings().addAll((Collection<? extends AdviceBinding>)newValue);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends Binding>)newValue);
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
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__PROJECT_NAME:
				setProjectName(PROJECT_NAME_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID:
				setIClientContextID(ICLIENT_CONTEXT_ID_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL:
				setMetamodel((EPackage)null);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF:
				setSpecializationOf((DomainContext)null);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX:
				setElementTypeIDPrefix(ELEMENT_TYPE_ID_PREFIX_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX:
				setElementTypeNamePrefix(ELEMENT_TYPE_NAME_PREFIX_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MATCHER_PATCH:
				setMatcherPatch(MATCHER_PATCH_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
				getElementTypes().clear();
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
				setDefaultHelperPath(DEFAULT_HELPER_PATH_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICEBINDINGS:
				getAdvicebindings().clear();
				return;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
				getBindings().clear();
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
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__PROJECT_NAME:
				return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID:
				return ICLIENT_CONTEXT_ID_EDEFAULT == null ? iClientContextID != null : !ICLIENT_CONTEXT_ID_EDEFAULT.equals(iClientContextID);
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL:
				return metamodel != null;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF:
				return specializationOf != null;
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX:
				return ELEMENT_TYPE_ID_PREFIX_EDEFAULT == null ? elementTypeIDPrefix != null : !ELEMENT_TYPE_ID_PREFIX_EDEFAULT.equals(elementTypeIDPrefix);
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX:
				return ELEMENT_TYPE_NAME_PREFIX_EDEFAULT == null ? elementTypeNamePrefix != null : !ELEMENT_TYPE_NAME_PREFIX_EDEFAULT.equals(elementTypeNamePrefix);
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MATCHER_PATCH:
				return MATCHER_PATCH_EDEFAULT == null ? matcherPatch != null : !MATCHER_PATCH_EDEFAULT.equals(matcherPatch);
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
				return elementTypes != null && !elementTypes.isEmpty();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
				return DEFAULT_HELPER_PATH_EDEFAULT == null ? defaultHelperPath != null : !DEFAULT_HELPER_PATH_EDEFAULT.equals(defaultHelperPath);
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICEBINDINGS:
				return advicebindings != null && !advicebindings.isEmpty();
			case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
				return bindings != null && !bindings.isEmpty();
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
		result.append(" (projectName: ");
		result.append(projectName);
		result.append(", IClientContextID: ");
		result.append(iClientContextID);
		result.append(", elementTypeIDPrefix: ");
		result.append(elementTypeIDPrefix);
		result.append(", elementTypeNamePrefix: ");
		result.append(elementTypeNamePrefix);
		result.append(", matcherPatch: ");
		result.append(matcherPatch);
		result.append(", defaultHelperPath: ");
		result.append(defaultHelperPath);
		result.append(')');
		return result.toString();
	}

} //DomainContextImpl
