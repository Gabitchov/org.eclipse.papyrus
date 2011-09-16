/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.diagramtemplate.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.diagramtemplate.DiagramDefinition;
import org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage;
import org.eclipse.papyrus.diagramtemplate.Selection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl#getFromRoot <em>From Root</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl#getDiagramKind <em>Diagram Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl#getLayoutToApply <em>Layout To Apply</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl#getPrefix <em>Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramDefinitionImpl extends EObjectImpl implements DiagramDefinition {
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
	 * The cached value of the '{@link #getFromRoot() <em>From Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromRoot()
	 * @generated
	 * @ordered
	 */
	protected EObject fromRoot;

	/**
	 * The cached value of the '{@link #getSelection() <em>Selection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected EList<Selection> selection;

	/**
	 * The default value of the '{@link #getDiagramKind() <em>Diagram Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramKind()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGRAM_KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagramKind() <em>Diagram Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramKind()
	 * @generated
	 * @ordered
	 */
	protected String diagramKind = DIAGRAM_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayoutToApply() <em>Layout To Apply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutToApply()
	 * @generated
	 * @ordered
	 */
	protected static final String LAYOUT_TO_APPLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayoutToApply() <em>Layout To Apply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutToApply()
	 * @generated
	 * @ordered
	 */
	protected String layoutToApply = LAYOUT_TO_APPLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected String prefix = PREFIX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramTemplatePackage.Literals.DIAGRAM_DEFINITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.DIAGRAM_DEFINITION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getFromRoot() {
		if (fromRoot != null && fromRoot.eIsProxy()) {
			InternalEObject oldFromRoot = (InternalEObject)fromRoot;
			fromRoot = eResolveProxy(oldFromRoot);
			if (fromRoot != oldFromRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramTemplatePackage.DIAGRAM_DEFINITION__FROM_ROOT, oldFromRoot, fromRoot));
			}
		}
		return fromRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetFromRoot() {
		return fromRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromRoot(EObject newFromRoot) {
		EObject oldFromRoot = fromRoot;
		fromRoot = newFromRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.DIAGRAM_DEFINITION__FROM_ROOT, oldFromRoot, fromRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Selection> getSelection() {
		if (selection == null) {
			selection = new EObjectContainmentEList<Selection>(Selection.class, this, DiagramTemplatePackage.DIAGRAM_DEFINITION__SELECTION);
		}
		return selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiagramKind() {
		return diagramKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramKind(String newDiagramKind) {
		String oldDiagramKind = diagramKind;
		diagramKind = newDiagramKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.DIAGRAM_DEFINITION__DIAGRAM_KIND, oldDiagramKind, diagramKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayoutToApply() {
		return layoutToApply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutToApply(String newLayoutToApply) {
		String oldLayoutToApply = layoutToApply;
		layoutToApply = newLayoutToApply;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.DIAGRAM_DEFINITION__LAYOUT_TO_APPLY, oldLayoutToApply, layoutToApply));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.DIAGRAM_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefix(String newPrefix) {
		String oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.DIAGRAM_DEFINITION__PREFIX, oldPrefix, prefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__SELECTION:
				return ((InternalEList<?>)getSelection()).basicRemove(otherEnd, msgs);
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
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__DESCRIPTION:
				return getDescription();
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__FROM_ROOT:
				if (resolve) return getFromRoot();
				return basicGetFromRoot();
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__SELECTION:
				return getSelection();
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__DIAGRAM_KIND:
				return getDiagramKind();
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__LAYOUT_TO_APPLY:
				return getLayoutToApply();
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__NAME:
				return getName();
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__PREFIX:
				return getPrefix();
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
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__FROM_ROOT:
				setFromRoot((EObject)newValue);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__SELECTION:
				getSelection().clear();
				getSelection().addAll((Collection<? extends Selection>)newValue);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__DIAGRAM_KIND:
				setDiagramKind((String)newValue);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__LAYOUT_TO_APPLY:
				setLayoutToApply((String)newValue);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__PREFIX:
				setPrefix((String)newValue);
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
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__FROM_ROOT:
				setFromRoot((EObject)null);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__SELECTION:
				getSelection().clear();
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__DIAGRAM_KIND:
				setDiagramKind(DIAGRAM_KIND_EDEFAULT);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__LAYOUT_TO_APPLY:
				setLayoutToApply(LAYOUT_TO_APPLY_EDEFAULT);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
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
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__FROM_ROOT:
				return fromRoot != null;
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__SELECTION:
				return selection != null && !selection.isEmpty();
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__DIAGRAM_KIND:
				return DIAGRAM_KIND_EDEFAULT == null ? diagramKind != null : !DIAGRAM_KIND_EDEFAULT.equals(diagramKind);
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__LAYOUT_TO_APPLY:
				return LAYOUT_TO_APPLY_EDEFAULT == null ? layoutToApply != null : !LAYOUT_TO_APPLY_EDEFAULT.equals(layoutToApply);
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramTemplatePackage.DIAGRAM_DEFINITION__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
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
		result.append(" (description: ");
		result.append(description);
		result.append(", diagramKind: ");
		result.append(diagramKind);
		result.append(", layoutToApply: ");
		result.append(layoutToApply);
		result.append(", name: ");
		result.append(name);
		result.append(", prefix: ");
		result.append(prefix);
		result.append(')');
		return result.toString();
	}

} //DiagramDefinitionImpl
