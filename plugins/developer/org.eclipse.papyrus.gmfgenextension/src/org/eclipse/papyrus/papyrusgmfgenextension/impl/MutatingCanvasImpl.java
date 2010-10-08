/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas;
import org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mutating Canvas</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl#getAlternateCanvases <em>Alternate Canvases</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MutatingCanvasImpl extends CommentedElementImpl implements MutatingCanvas {

	/**
	 * The cached value of the '{@link #getAlternateCanvases() <em>Alternate Canvases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternateCanvases()
	 * @generated
	 * @ordered
	 */
	protected EList<AlternateCanvas> alternateCanvases;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatingCanvasImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.MUTATING_CANVAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AlternateCanvas> getAlternateCanvases() {
		if (alternateCanvases == null) {
			alternateCanvases = new EObjectContainmentEList<AlternateCanvas>(AlternateCanvas.class, this, PapyrusgmfgenextensionPackage.MUTATING_CANVAS__ALTERNATE_CANVASES);
		}
		return alternateCanvases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.MUTATING_CANVAS__ALTERNATE_CANVASES:
				return ((InternalEList<?>)getAlternateCanvases()).basicRemove(otherEnd, msgs);
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
			case PapyrusgmfgenextensionPackage.MUTATING_CANVAS__ALTERNATE_CANVASES:
				return getAlternateCanvases();
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
			case PapyrusgmfgenextensionPackage.MUTATING_CANVAS__ALTERNATE_CANVASES:
				getAlternateCanvases().clear();
				getAlternateCanvases().addAll((Collection<? extends AlternateCanvas>)newValue);
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
			case PapyrusgmfgenextensionPackage.MUTATING_CANVAS__ALTERNATE_CANVASES:
				getAlternateCanvases().clear();
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
			case PapyrusgmfgenextensionPackage.MUTATING_CANVAS__ALTERNATE_CANVASES:
				return alternateCanvases != null && !alternateCanvases.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MutatingCanvasImpl
