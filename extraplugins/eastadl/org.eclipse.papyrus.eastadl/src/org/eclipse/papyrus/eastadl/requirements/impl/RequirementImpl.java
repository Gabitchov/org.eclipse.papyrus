/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.requirements.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.behavior.Mode;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Comment;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.papyrus.eastadl.requirements.Refine;
import org.eclipse.papyrus.eastadl.requirements.Requirement;
import org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject;
import org.eclipse.papyrus.eastadl.requirements.RequirementsContainer;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.requirements.Copy;
import org.eclipse.papyrus.sysml.requirements.DeriveReqt;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Requirement</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getOwnedComment <em>Owned Comment</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getBase_PackageableElement <em>Base Packageable Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getNote <em>Note</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getReferencingContainer <em>Referencing Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getFormalism <em>Formalism</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getUrl <em>Url</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RequirementImpl extends org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl implements Requirement {

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * The cached value of the '{@link #getOwnedComment() <em>Owned Comment</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOwnedComment()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> ownedComment;

	/**
	 * The cached value of the '{@link #getBase_PackageableElement() <em>Base Packageable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_PackageableElement()
	 * @generated
	 * @ordered
	 */
	protected PackageableElement base_PackageableElement;

	/**
	 * The default value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected String note = NOTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencingContainer() <em>Referencing Container</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getReferencingContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementsContainer> referencingContainer;

	/**
	 * The default value of the '{@link #getFormalism() <em>Formalism</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormalism()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMALISM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormalism() <em>Formalism</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormalism()
	 * @generated
	 * @ordered
	 */
	protected String formalism = FORMALISM_EDEFAULT;

	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected EList<Mode> mode;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Requirement basicGetMaster() {
		// The Requirement is the supplier of the Copy link between the master Requirement and
		// current
		// This should return the TestCase verifying current Requirement
		Requirement master = null;
		Copy currentCopy = null;

		if(getBase_Class() != null) {
			Iterator<Dependency> itDep = getBase_Class().getClientDependencies().iterator();

			// Find Copy link
			while(itDep.hasNext()) {
				Dependency currentDep = itDep.next();
				currentCopy = (Copy)UMLUtil.getStereotypeApplication(currentDep, Copy.class);

				if(currentCopy != null) {
					EList<NamedElement> suppliers = currentCopy.getBase_Abstraction().getSuppliers();
					Iterator<NamedElement> it = suppliers.iterator();
					while(it.hasNext() && (master == null)) {
						Requirement currentRequirement = (Requirement)UMLUtil.getStereotypeApplication(it.next(), Requirement.class);
						if(currentRequirement != null) {
							master = currentRequirement;
						}
					}
				}
			}
		}
		return master;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if(baseClass == EAElement.class) {
			switch(derivedFeatureID) {
			case RequirementsPackage.REQUIREMENT__NAME:
				return ElementsPackage.EA_ELEMENT__NAME;
			case RequirementsPackage.REQUIREMENT__BASE_NAMED_ELEMENT:
				return ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;
			case RequirementsPackage.REQUIREMENT__OWNED_COMMENT:
				return ElementsPackage.EA_ELEMENT__OWNED_COMMENT;
			default:
				return -1;
			}
		}
		if(baseClass == EAPackageableElement.class) {
			switch(derivedFeatureID) {
			case RequirementsPackage.REQUIREMENT__BASE_PACKAGEABLE_ELEMENT:
				return ElementsPackage.EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT;
			default:
				return -1;
			}
		}
		if(baseClass == TraceableSpecification.class) {
			switch(derivedFeatureID) {
			case RequirementsPackage.REQUIREMENT__NOTE:
				return ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;
			default:
				return -1;
			}
		}
		if(baseClass == RequirementSpecificationObject.class) {
			switch(derivedFeatureID) {
			case RequirementsPackage.REQUIREMENT__REFERENCING_CONTAINER:
				return RequirementsPackage.REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if(baseClass == EAElement.class) {
			switch(baseFeatureID) {
			case ElementsPackage.EA_ELEMENT__NAME:
				return RequirementsPackage.REQUIREMENT__NAME;
			case ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT:
				return RequirementsPackage.REQUIREMENT__BASE_NAMED_ELEMENT;
			case ElementsPackage.EA_ELEMENT__OWNED_COMMENT:
				return RequirementsPackage.REQUIREMENT__OWNED_COMMENT;
			default:
				return -1;
			}
		}
		if(baseClass == EAPackageableElement.class) {
			switch(baseFeatureID) {
			case ElementsPackage.EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				return RequirementsPackage.REQUIREMENT__BASE_PACKAGEABLE_ELEMENT;
			default:
				return -1;
			}
		}
		if(baseClass == TraceableSpecification.class) {
			switch(baseFeatureID) {
			case ElementsPackage.TRACEABLE_SPECIFICATION__NOTE:
				return RequirementsPackage.REQUIREMENT__NOTE;
			default:
				return -1;
			}
		}
		if(baseClass == RequirementSpecificationObject.class) {
			switch(baseFeatureID) {
			case RequirementsPackage.REQUIREMENT_SPECIFICATION_OBJECT__REFERENCING_CONTAINER:
				return RequirementsPackage.REQUIREMENT__REFERENCING_CONTAINER;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT__NAME:
			return getName();
		case RequirementsPackage.REQUIREMENT__BASE_NAMED_ELEMENT:
			if(resolve)
				return getBase_NamedElement();
			return basicGetBase_NamedElement();
		case RequirementsPackage.REQUIREMENT__OWNED_COMMENT:
			return getOwnedComment();
		case RequirementsPackage.REQUIREMENT__BASE_PACKAGEABLE_ELEMENT:
			if(resolve)
				return getBase_PackageableElement();
			return basicGetBase_PackageableElement();
		case RequirementsPackage.REQUIREMENT__NOTE:
			return getNote();
		case RequirementsPackage.REQUIREMENT__REFERENCING_CONTAINER:
			return getReferencingContainer();
		case RequirementsPackage.REQUIREMENT__FORMALISM:
			return getFormalism();
		case RequirementsPackage.REQUIREMENT__URL:
			return getUrl();
		case RequirementsPackage.REQUIREMENT__MODE:
			return getMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT__NAME:
			return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
		case RequirementsPackage.REQUIREMENT__BASE_NAMED_ELEMENT:
			return base_NamedElement != null;
		case RequirementsPackage.REQUIREMENT__OWNED_COMMENT:
			return ownedComment != null && !ownedComment.isEmpty();
		case RequirementsPackage.REQUIREMENT__BASE_PACKAGEABLE_ELEMENT:
			return base_PackageableElement != null;
		case RequirementsPackage.REQUIREMENT__NOTE:
			return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
		case RequirementsPackage.REQUIREMENT__REFERENCING_CONTAINER:
			return referencingContainer != null && !referencingContainer.isEmpty();
		case RequirementsPackage.REQUIREMENT__FORMALISM:
			return FORMALISM_EDEFAULT == null ? formalism != null : !FORMALISM_EDEFAULT.equals(formalism);
		case RequirementsPackage.REQUIREMENT__URL:
			return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
		case RequirementsPackage.REQUIREMENT__MODE:
			return mode != null && !mode.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT__NAME:
			setName((String)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__BASE_NAMED_ELEMENT:
			setBase_NamedElement((NamedElement)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__OWNED_COMMENT:
			getOwnedComment().clear();
			getOwnedComment().addAll((Collection<? extends Comment>)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__BASE_PACKAGEABLE_ELEMENT:
			setBase_PackageableElement((PackageableElement)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__NOTE:
			setNote((String)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REFERENCING_CONTAINER:
			getReferencingContainer().clear();
			getReferencingContainer().addAll((Collection<? extends RequirementsContainer>)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__FORMALISM:
			setFormalism((String)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__URL:
			setUrl((String)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__MODE:
			getMode().clear();
			getMode().addAll((Collection<? extends Mode>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.REQUIREMENT;
	}




	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__BASE_NAMED_ELEMENT:
			setBase_NamedElement((NamedElement)null);
			return;
		case RequirementsPackage.REQUIREMENT__OWNED_COMMENT:
			getOwnedComment().clear();
			return;
		case RequirementsPackage.REQUIREMENT__BASE_PACKAGEABLE_ELEMENT:
			setBase_PackageableElement((PackageableElement)null);
			return;
		case RequirementsPackage.REQUIREMENT__NOTE:
			setNote(NOTE_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REFERENCING_CONTAINER:
			getReferencingContainer().clear();
			return;
		case RequirementsPackage.REQUIREMENT__FORMALISM:
			setFormalism(FORMALISM_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__URL:
			setUrl(URL_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__MODE:
			getMode().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<org.eclipse.papyrus.sysml.requirements.Requirement> getDerived() {
		// This should return the Requirement(s) derived from current
		EList<Requirement> derived = new BasicEList<Requirement>();
		DeriveReqt currentDeriveReqt = null;

		if(getBase_Class() != null) {
			Iterator<DirectedRelationship> itDep = getBase_Class().getTargetDirectedRelationships().iterator();

			// Find DeriveReqt link
			while(itDep.hasNext()) {
				DirectedRelationship currentDirectedRelationship = itDep.next();
				currentDeriveReqt = (DeriveReqt)UMLUtil.getStereotypeApplication(currentDirectedRelationship, DeriveReqt.class);

				if(currentDeriveReqt != null) {
					EList<NamedElement> clients = currentDeriveReqt.getBase_Abstraction().getClients();
					Iterator<NamedElement> it = clients.iterator();
					while(it.hasNext()) {
						Requirement currentRequirement = (Requirement)UMLUtil.getStereotypeApplication(it.next(), Requirement.class);
						if(currentRequirement != null) {
							derived.add(currentRequirement);
						}
					}
				}
			}
		}
		// Convert to InternalEList<?>
		return new BasicInternalEList<org.eclipse.papyrus.sysml.requirements.Requirement>(org.eclipse.papyrus.sysml.requirements.Requirement.class, derived.size(), derived.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFormalism() {
		return formalism;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Mode> getMode() {
		if(mode == null) {
			mode = new EObjectResolvingEList<Mode>(Mode.class, this, RequirementsPackage.REQUIREMENT__MODE);
		}
		return mode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getName() {
		return getBase_Class().getName();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Comment> getOwnedComment() {
		if(ownedComment == null) {
			ownedComment = new EObjectResolvingEList<Comment>(Comment.class, this, RequirementsPackage.REQUIREMENT__OWNED_COMMENT);
		}
		return ownedComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackageableElement getBase_PackageableElement() {
		if(base_PackageableElement != null && base_PackageableElement.eIsProxy()) {
			InternalEObject oldBase_PackageableElement = (InternalEObject)base_PackageableElement;
			base_PackageableElement = (PackageableElement)eResolveProxy(oldBase_PackageableElement);
			if(base_PackageableElement != oldBase_PackageableElement) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENT__BASE_PACKAGEABLE_ELEMENT, oldBase_PackageableElement, base_PackageableElement));
			}
		}
		return base_PackageableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackageableElement basicGetBase_PackageableElement() {
		return base_PackageableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_PackageableElement(PackageableElement newBase_PackageableElement) {
		PackageableElement oldBase_PackageableElement = base_PackageableElement;
		base_PackageableElement = newBase_PackageableElement;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__BASE_PACKAGEABLE_ELEMENT, oldBase_PackageableElement, base_PackageableElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getRefinedBy() {
		// This should return the NamedElement(s) that refine current Requirement
		EList<NamedElement> refinedBy = new BasicEList<NamedElement>();
		Refine currentRefine = null;

		if(getBase_Class() != null) {
			Iterator<DirectedRelationship> itDep = getBase_Class().getTargetDirectedRelationships().iterator();

			// Find Refine link
			while(itDep.hasNext()) {
				DirectedRelationship currentDRelationship = itDep.next();
				currentRefine = (Refine)UMLUtil.getStereotypeApplication(currentDRelationship, Refine.class);

				if(currentRefine != null) {
					refinedBy.addAll(currentRefine.getBase_Dependency().getClients());
				}
			}
		}
		// Convert to InternalEList<?>
		return new BasicInternalEList<NamedElement>(NamedElement.class, refinedBy.size(), refinedBy.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFormalism(String newFormalism) {
		String oldFormalism = formalism;
		formalism = newFormalism;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__FORMALISM, oldFormalism, formalism));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setName(String newName) {
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if(base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if(base_NamedElement != oldBase_NamedElement) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNote(String newNote) {
		String oldNote = note;
		note = newNote;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__NOTE, oldNote, note));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementsContainer> getReferencingContainer() {
		if(referencingContainer == null) {
			referencingContainer = new EObjectResolvingEList<RequirementsContainer>(RequirementsContainer.class, this, RequirementsPackage.REQUIREMENT__REFERENCING_CONTAINER);
		}
		return referencingContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (note: ");
		result.append(note);
		result.append(", formalism: ");
		result.append(formalism);
		result.append(", url: ");
		result.append(url);
		result.append(')');
		return result.toString();
	}

} // RequirementImpl
