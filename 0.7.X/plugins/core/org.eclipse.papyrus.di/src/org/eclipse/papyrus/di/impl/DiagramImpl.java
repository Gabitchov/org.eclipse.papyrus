/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.impl;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.di.DiagramLink;
import org.eclipse.papyrus.di.SemanticModelBridge;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.impl.DiagramImpl#getOwner <em>Owner</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.DiagramImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.DiagramImpl#getZoom <em>Zoom</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.DiagramImpl#getViewport <em>Viewport</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.DiagramImpl#getDiagramLink <em>Diagram Link</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.DiagramImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DiagramImpl extends GraphNodeImpl implements Diagram {

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected SemanticModelBridge owner;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getZoom() <em>Zoom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getZoom()
	 * @generated
	 * @ordered
	 */
	protected static final double ZOOM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZoom() <em>Zoom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getZoom()
	 * @generated
	 * @ordered
	 */
	protected double zoom = ZOOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getViewport() <em>Viewport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getViewport()
	 * @generated
	 * @ordered
	 */
	protected static final Point VIEWPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewport() <em>Viewport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getViewport()
	 * @generated
	 * @ordered
	 */
	protected Point viewport = VIEWPORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiagramLink() <em>Diagram Link</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDiagramLink()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramLink> diagramLink;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DiagramImpl() {
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
		return DiPackage.Literals.DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SemanticModelBridge getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOwner(SemanticModelBridge newOwner, NotificationChain msgs) {
		SemanticModelBridge oldOwner = owner;
		owner = newOwner;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiPackage.DIAGRAM__OWNER, oldOwner, newOwner);
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
	public void setOwner(SemanticModelBridge newOwner) {
		if(newOwner != owner) {
			NotificationChain msgs = null;
			if(owner != null)
				msgs = ((InternalEObject)owner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiPackage.DIAGRAM__OWNER, null, msgs);
			if(newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiPackage.DIAGRAM__OWNER, null, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.DIAGRAM__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.DIAGRAM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getZoom() {
		return zoom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setZoom(double newZoom) {
		double oldZoom = zoom;
		zoom = newZoom;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.DIAGRAM__ZOOM, oldZoom, zoom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Point getViewport() {
		return viewport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setViewport(Point newViewport) {
		Point oldViewport = viewport;
		viewport = newViewport;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.DIAGRAM__VIEWPORT, oldViewport, viewport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<DiagramLink> getDiagramLink() {
		if(diagramLink == null) {
			diagramLink = new EObjectResolvingEList<DiagramLink>(DiagramLink.class, this, DiPackage.DIAGRAM__DIAGRAM_LINK);
		}
		return diagramLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @NOT generated
	 */
	public String getType() {
		if(this.type == null || this.type.equals("")) {
			return "ClassDiagram";
		}
		return this.type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.DIAGRAM__TYPE, oldType, type));
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
		case DiPackage.DIAGRAM__OWNER:
			return basicSetOwner(null, msgs);
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
		case DiPackage.DIAGRAM__OWNER:
			return getOwner();
		case DiPackage.DIAGRAM__NAME:
			return getName();
		case DiPackage.DIAGRAM__ZOOM:
			return getZoom();
		case DiPackage.DIAGRAM__VIEWPORT:
			return getViewport();
		case DiPackage.DIAGRAM__DIAGRAM_LINK:
			return getDiagramLink();
		case DiPackage.DIAGRAM__TYPE:
			return getType();
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
		case DiPackage.DIAGRAM__OWNER:
			setOwner((SemanticModelBridge)newValue);
			return;
		case DiPackage.DIAGRAM__NAME:
			setName((String)newValue);
			return;
		case DiPackage.DIAGRAM__ZOOM:
			setZoom((Double)newValue);
			return;
		case DiPackage.DIAGRAM__VIEWPORT:
			setViewport((Point)newValue);
			return;
		case DiPackage.DIAGRAM__DIAGRAM_LINK:
			getDiagramLink().clear();
			getDiagramLink().addAll((Collection<? extends DiagramLink>)newValue);
			return;
		case DiPackage.DIAGRAM__TYPE:
			setType((String)newValue);
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
		case DiPackage.DIAGRAM__OWNER:
			setOwner((SemanticModelBridge)null);
			return;
		case DiPackage.DIAGRAM__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DiPackage.DIAGRAM__ZOOM:
			setZoom(ZOOM_EDEFAULT);
			return;
		case DiPackage.DIAGRAM__VIEWPORT:
			setViewport(VIEWPORT_EDEFAULT);
			return;
		case DiPackage.DIAGRAM__DIAGRAM_LINK:
			getDiagramLink().clear();
			return;
		case DiPackage.DIAGRAM__TYPE:
			setType(TYPE_EDEFAULT);
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
		case DiPackage.DIAGRAM__OWNER:
			return owner != null;
		case DiPackage.DIAGRAM__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DiPackage.DIAGRAM__ZOOM:
			return zoom != ZOOM_EDEFAULT;
		case DiPackage.DIAGRAM__VIEWPORT:
			return VIEWPORT_EDEFAULT == null ? viewport != null : !VIEWPORT_EDEFAULT.equals(viewport);
		case DiPackage.DIAGRAM__DIAGRAM_LINK:
			return diagramLink != null && !diagramLink.isEmpty();
		case DiPackage.DIAGRAM__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", zoom: ");
		result.append(zoom);
		result.append(", viewport: ");
		result.append(viewport);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //DiagramImpl
