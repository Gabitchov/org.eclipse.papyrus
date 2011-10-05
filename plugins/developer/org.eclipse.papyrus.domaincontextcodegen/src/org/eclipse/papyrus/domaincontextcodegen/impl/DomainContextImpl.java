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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.domaincontextcodegen.Advice;
import org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration;
import org.eclipse.papyrus.domaincontextcodegen.DomainContext;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypes;
import org.eclipse.papyrus.domaincontextcodegen.GenHandlers;
import org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getTypeProjectName <em>Type Project Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getHandlerProjectName <em>Handler Project Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getIClientContextID <em>IClient Context ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getMetamodel <em>Metamodel</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getSpecializationOf <em>Specialization Of</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getElementTypeIDPrefix <em>Element Type ID Prefix</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getElementTypeNamePrefix <em>Element Type Name Prefix</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getElementTypes <em>Element Types</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getDefaultHelperPath <em>Default Helper Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getAdvices <em>Advices</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getBindings <em>Bindings</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getGenHandlers <em>Gen Handlers</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getGeneratedSourceFolder <em>Generated Source Folder</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getMenu <em>Menu</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl#getCommand <em>Command</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DomainContextImpl extends EObjectImpl implements DomainContext {

	/**
	 * The default value of the '{@link #getTypeProjectName() <em>Type Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTypeProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeProjectName() <em>Type Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTypeProjectName()
	 * @generated
	 * @ordered
	 */
	protected String typeProjectName = TYPE_PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getHandlerProjectName() <em>Handler Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHandlerProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String HANDLER_PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHandlerProjectName() <em>Handler Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHandlerProjectName()
	 * @generated
	 * @ordered
	 */
	protected String handlerProjectName = HANDLER_PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIClientContextID() <em>IClient Context ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIClientContextID()
	 * @generated
	 * @ordered
	 */
	protected static final String ICLIENT_CONTEXT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIClientContextID() <em>IClient Context ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIClientContextID()
	 * @generated
	 * @ordered
	 */
	protected String iClientContextID = ICLIENT_CONTEXT_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected EPackage metamodel;

	/**
	 * The cached value of the '{@link #getSpecializationOf() <em>Specialization Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSpecializationOf()
	 * @generated
	 * @ordered
	 */
	protected DomainContext specializationOf;

	/**
	 * The default value of the '{@link #getElementTypeIDPrefix() <em>Element Type ID Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypeIDPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_ID_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeIDPrefix() <em>Element Type ID Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypeIDPrefix()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeIDPrefix = ELEMENT_TYPE_ID_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementTypeNamePrefix() <em>Element Type Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypeNamePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_NAME_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeNamePrefix() <em>Element Type Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypeNamePrefix()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeNamePrefix = ELEMENT_TYPE_NAME_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElementTypes() <em>Element Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypes()
	 * @generated
	 * @ordered
	 */
	protected ElementTypes elementTypes;

	/**
	 * The default value of the '{@link #getDefaultHelperPath() <em>Default Helper Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDefaultHelperPath()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_HELPER_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultHelperPath() <em>Default Helper Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDefaultHelperPath()
	 * @generated
	 * @ordered
	 */
	protected String defaultHelperPath = DEFAULT_HELPER_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdvices() <em>Advices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAdvices()
	 * @generated
	 * @ordered
	 */
	protected EList<Advice> advices;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementTypeBindings> bindings;

	/**
	 * The cached value of the '{@link #getGenHandlers() <em>Gen Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGenHandlers()
	 * @generated
	 * @ordered
	 */
	protected GenHandlers genHandlers;

	/**
	 * The default value of the '{@link #getGeneratedSourceFolder() <em>Generated Source Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGeneratedSourceFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATED_SOURCE_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeneratedSourceFolder() <em>Generated Source Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGeneratedSourceFolder()
	 * @generated
	 * @ordered
	 */
	protected String generatedSourceFolder = GENERATED_SOURCE_FOLDER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMenu() <em>Menu</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMenu()
	 * @generated
	 * @ordered
	 */
	protected EList<MenuDeclaration> menu;

	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected EList<CommandDeclaration> command;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DomainContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getTypeProjectName() {
		return typeProjectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypeProjectName(String newTypeProjectName) {
		String oldTypeProjectName = typeProjectName;
		typeProjectName = newTypeProjectName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__TYPE_PROJECT_NAME, oldTypeProjectName, typeProjectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getHandlerProjectName() {
		return handlerProjectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHandlerProjectName(String newHandlerProjectName) {
		String oldHandlerProjectName = handlerProjectName;
		handlerProjectName = newHandlerProjectName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__HANDLER_PROJECT_NAME, oldHandlerProjectName, handlerProjectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getIClientContextID() {
		return iClientContextID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIClientContextID(String newIClientContextID) {
		String oldIClientContextID = iClientContextID;
		iClientContextID = newIClientContextID;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID, oldIClientContextID, iClientContextID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPackage getMetamodel() {
		if(metamodel != null && metamodel.eIsProxy()) {
			InternalEObject oldMetamodel = (InternalEObject)metamodel;
			metamodel = (EPackage)eResolveProxy(oldMetamodel);
			if(metamodel != oldMetamodel) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL, oldMetamodel, metamodel));
			}
		}
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPackage basicGetMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMetamodel(EPackage newMetamodel) {
		EPackage oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL, oldMetamodel, metamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomainContext getSpecializationOf() {
		if(specializationOf != null && specializationOf.eIsProxy()) {
			InternalEObject oldSpecializationOf = (InternalEObject)specializationOf;
			specializationOf = (DomainContext)eResolveProxy(oldSpecializationOf);
			if(specializationOf != oldSpecializationOf) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF, oldSpecializationOf, specializationOf));
			}
		}
		return specializationOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomainContext basicGetSpecializationOf() {
		return specializationOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSpecializationOf(DomainContext newSpecializationOf) {
		DomainContext oldSpecializationOf = specializationOf;
		specializationOf = newSpecializationOf;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF, oldSpecializationOf, specializationOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getElementTypeIDPrefix() {
		return elementTypeIDPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementTypeIDPrefix(String newElementTypeIDPrefix) {
		String oldElementTypeIDPrefix = elementTypeIDPrefix;
		elementTypeIDPrefix = newElementTypeIDPrefix;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX, oldElementTypeIDPrefix, elementTypeIDPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getElementTypeNamePrefix() {
		return elementTypeNamePrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementTypeNamePrefix(String newElementTypeNamePrefix) {
		String oldElementTypeNamePrefix = elementTypeNamePrefix;
		elementTypeNamePrefix = newElementTypeNamePrefix;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX, oldElementTypeNamePrefix, elementTypeNamePrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementTypes getElementTypes() {
		return elementTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetElementTypes(ElementTypes newElementTypes, NotificationChain msgs) {
		ElementTypes oldElementTypes = elementTypes;
		elementTypes = newElementTypes;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES, oldElementTypes, newElementTypes);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementTypes(ElementTypes newElementTypes) {
		if(newElementTypes != elementTypes) {
			NotificationChain msgs = null;
			if(elementTypes != null)
				msgs = ((InternalEObject)elementTypes).eInverseRemove(this, DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN, ElementTypes.class, msgs);
			if(newElementTypes != null)
				msgs = ((InternalEObject)newElementTypes).eInverseAdd(this, DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN, ElementTypes.class, msgs);
			msgs = basicSetElementTypes(newElementTypes, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES, newElementTypes, newElementTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDefaultHelperPath() {
		return defaultHelperPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefaultHelperPath(String newDefaultHelperPath) {
		String oldDefaultHelperPath = defaultHelperPath;
		defaultHelperPath = newDefaultHelperPath;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH, oldDefaultHelperPath, defaultHelperPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Advice> getAdvices() {
		if(advices == null) {
			advices = new EObjectContainmentEList<Advice>(Advice.class, this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICES);
		}
		return advices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ElementTypeBindings> getBindings() {
		if(bindings == null) {
			bindings = new EObjectContainmentEList<ElementTypeBindings>(ElementTypeBindings.class, this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenHandlers getGenHandlers() {
		return genHandlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGenHandlers(GenHandlers newGenHandlers, NotificationChain msgs) {
		GenHandlers oldGenHandlers = genHandlers;
		genHandlers = newGenHandlers;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS, oldGenHandlers, newGenHandlers);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGenHandlers(GenHandlers newGenHandlers) {
		if(newGenHandlers != genHandlers) {
			NotificationChain msgs = null;
			if(genHandlers != null)
				msgs = ((InternalEObject)genHandlers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS, null, msgs);
			if(newGenHandlers != null)
				msgs = ((InternalEObject)newGenHandlers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS, null, msgs);
			msgs = basicSetGenHandlers(newGenHandlers, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS, newGenHandlers, newGenHandlers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getGeneratedSourceFolder() {
		return generatedSourceFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGeneratedSourceFolder(String newGeneratedSourceFolder) {
		String oldGeneratedSourceFolder = generatedSourceFolder;
		generatedSourceFolder = newGeneratedSourceFolder;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER, oldGeneratedSourceFolder, generatedSourceFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<MenuDeclaration> getMenu() {
		if(menu == null) {
			menu = new EObjectContainmentEList<MenuDeclaration>(MenuDeclaration.class, this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__MENU);
		}
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<CommandDeclaration> getCommand() {
		if(command == null) {
			command = new EObjectContainmentEList<CommandDeclaration>(CommandDeclaration.class, this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__COMMAND);
		}
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
			if(elementTypes != null)
				msgs = ((InternalEObject)elementTypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES, null, msgs);
			return basicSetElementTypes((ElementTypes)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
			return basicSetElementTypes(null, msgs);
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICES:
			return ((InternalEList<?>)getAdvices()).basicRemove(otherEnd, msgs);
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
			return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS:
			return basicSetGenHandlers(null, msgs);
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MENU:
			return ((InternalEList<?>)getMenu()).basicRemove(otherEnd, msgs);
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__COMMAND:
			return ((InternalEList<?>)getCommand()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__TYPE_PROJECT_NAME:
			return getTypeProjectName();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__HANDLER_PROJECT_NAME:
			return getHandlerProjectName();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID:
			return getIClientContextID();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__METAMODEL:
			if(resolve)
				return getMetamodel();
			return basicGetMetamodel();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__SPECIALIZATION_OF:
			if(resolve)
				return getSpecializationOf();
			return basicGetSpecializationOf();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX:
			return getElementTypeIDPrefix();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX:
			return getElementTypeNamePrefix();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
			return getElementTypes();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
			return getDefaultHelperPath();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICES:
			return getAdvices();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
			return getBindings();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS:
			return getGenHandlers();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER:
			return getGeneratedSourceFolder();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MENU:
			return getMenu();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__COMMAND:
			return getCommand();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__TYPE_PROJECT_NAME:
			setTypeProjectName((String)newValue);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__HANDLER_PROJECT_NAME:
			setHandlerProjectName((String)newValue);
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
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
			setElementTypes((ElementTypes)newValue);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
			setDefaultHelperPath((String)newValue);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICES:
			getAdvices().clear();
			getAdvices().addAll((Collection<? extends Advice>)newValue);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
			getBindings().clear();
			getBindings().addAll((Collection<? extends ElementTypeBindings>)newValue);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS:
			setGenHandlers((GenHandlers)newValue);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER:
			setGeneratedSourceFolder((String)newValue);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MENU:
			getMenu().clear();
			getMenu().addAll((Collection<? extends MenuDeclaration>)newValue);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__COMMAND:
			getCommand().clear();
			getCommand().addAll((Collection<? extends CommandDeclaration>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__TYPE_PROJECT_NAME:
			setTypeProjectName(TYPE_PROJECT_NAME_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__HANDLER_PROJECT_NAME:
			setHandlerProjectName(HANDLER_PROJECT_NAME_EDEFAULT);
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
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
			setElementTypes((ElementTypes)null);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
			setDefaultHelperPath(DEFAULT_HELPER_PATH_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICES:
			getAdvices().clear();
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
			getBindings().clear();
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS:
			setGenHandlers((GenHandlers)null);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER:
			setGeneratedSourceFolder(GENERATED_SOURCE_FOLDER_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MENU:
			getMenu().clear();
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__COMMAND:
			getCommand().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__TYPE_PROJECT_NAME:
			return TYPE_PROJECT_NAME_EDEFAULT == null ? typeProjectName != null : !TYPE_PROJECT_NAME_EDEFAULT.equals(typeProjectName);
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__HANDLER_PROJECT_NAME:
			return HANDLER_PROJECT_NAME_EDEFAULT == null ? handlerProjectName != null : !HANDLER_PROJECT_NAME_EDEFAULT.equals(handlerProjectName);
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
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
			return elementTypes != null;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
			return DEFAULT_HELPER_PATH_EDEFAULT == null ? defaultHelperPath != null : !DEFAULT_HELPER_PATH_EDEFAULT.equals(defaultHelperPath);
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICES:
			return advices != null && !advices.isEmpty();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
			return bindings != null && !bindings.isEmpty();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS:
			return genHandlers != null;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER:
			return GENERATED_SOURCE_FOLDER_EDEFAULT == null ? generatedSourceFolder != null : !GENERATED_SOURCE_FOLDER_EDEFAULT.equals(generatedSourceFolder);
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MENU:
			return menu != null && !menu.isEmpty();
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__COMMAND:
			return command != null && !command.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (typeProjectName: ");
		result.append(typeProjectName);
		result.append(", handlerProjectName: ");
		result.append(handlerProjectName);
		result.append(", IClientContextID: ");
		result.append(iClientContextID);
		result.append(", elementTypeIDPrefix: ");
		result.append(elementTypeIDPrefix);
		result.append(", elementTypeNamePrefix: ");
		result.append(elementTypeNamePrefix);
		result.append(", defaultHelperPath: ");
		result.append(defaultHelperPath);
		result.append(", generatedSourceFolder: ");
		result.append(generatedSourceFolder);
		result.append(')');
		return result.toString();
	}

} //DomainContextImpl
