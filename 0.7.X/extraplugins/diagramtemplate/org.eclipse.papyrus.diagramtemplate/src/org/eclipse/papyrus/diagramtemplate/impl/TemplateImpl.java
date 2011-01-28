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
import org.eclipse.papyrus.diagramtemplate.Template;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.TemplateImpl#getDiagramDefinitions <em>Diagram Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.TemplateImpl#getTargetRoot <em>Target Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateImpl extends EObjectImpl implements Template {
	/**
	 * The cached value of the '{@link #getDiagramDefinitions() <em>Diagram Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramDefinition> diagramDefinitions;

	/**
	 * The cached value of the '{@link #getTargetRoot() <em>Target Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRoot()
	 * @generated
	 * @ordered
	 */
	protected EObject targetRoot;

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
		return DiagramTemplatePackage.Literals.TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramDefinition> getDiagramDefinitions() {
		if (diagramDefinitions == null) {
			diagramDefinitions = new EObjectContainmentEList<DiagramDefinition>(DiagramDefinition.class, this, DiagramTemplatePackage.TEMPLATE__DIAGRAM_DEFINITIONS);
		}
		return diagramDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTargetRoot() {
		if (targetRoot != null && targetRoot.eIsProxy()) {
			InternalEObject oldTargetRoot = (InternalEObject)targetRoot;
			targetRoot = eResolveProxy(oldTargetRoot);
			if (targetRoot != oldTargetRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramTemplatePackage.TEMPLATE__TARGET_ROOT, oldTargetRoot, targetRoot));
			}
		}
		return targetRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTargetRoot() {
		return targetRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRoot(EObject newTargetRoot) {
		EObject oldTargetRoot = targetRoot;
		targetRoot = newTargetRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.TEMPLATE__TARGET_ROOT, oldTargetRoot, targetRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramTemplatePackage.TEMPLATE__DIAGRAM_DEFINITIONS:
				return ((InternalEList<?>)getDiagramDefinitions()).basicRemove(otherEnd, msgs);
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
			case DiagramTemplatePackage.TEMPLATE__DIAGRAM_DEFINITIONS:
				return getDiagramDefinitions();
			case DiagramTemplatePackage.TEMPLATE__TARGET_ROOT:
				if (resolve) return getTargetRoot();
				return basicGetTargetRoot();
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
			case DiagramTemplatePackage.TEMPLATE__DIAGRAM_DEFINITIONS:
				getDiagramDefinitions().clear();
				getDiagramDefinitions().addAll((Collection<? extends DiagramDefinition>)newValue);
				return;
			case DiagramTemplatePackage.TEMPLATE__TARGET_ROOT:
				setTargetRoot((EObject)newValue);
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
			case DiagramTemplatePackage.TEMPLATE__DIAGRAM_DEFINITIONS:
				getDiagramDefinitions().clear();
				return;
			case DiagramTemplatePackage.TEMPLATE__TARGET_ROOT:
				setTargetRoot((EObject)null);
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
			case DiagramTemplatePackage.TEMPLATE__DIAGRAM_DEFINITIONS:
				return diagramDefinitions != null && !diagramDefinitions.isEmpty();
			case DiagramTemplatePackage.TEMPLATE__TARGET_ROOT:
				return targetRoot != null;
		}
		return super.eIsSet(featureID);
	}

} //TemplateImpl
