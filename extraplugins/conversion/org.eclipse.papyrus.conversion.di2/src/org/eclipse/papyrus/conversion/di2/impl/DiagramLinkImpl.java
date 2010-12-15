/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2.impl;


import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.conversion.di2.Di2Package;
import org.eclipse.papyrus.conversion.di2.Diagram;
import org.eclipse.papyrus.conversion.di2.DiagramLink;
import org.eclipse.papyrus.conversion.di2.GraphElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramLinkImpl#getDiagram <em>Diagram
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramLinkImpl#getZoom <em>Zoom</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramLinkImpl#getViewport <em>Viewport
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramLinkImpl#getGraphElement <em>Graph
 * Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DiagramLinkImpl extends EObjectImpl implements DiagramLink {

	/**
	 * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram diagram;

	/**
	 * The default value of the '{@link #getZoom() <em>Zoom</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getZoom()
	 * @generated
	 * @ordered
	 */
	protected static final double ZOOM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZoom() <em>Zoom</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getZoom()
	 * @generated
	 * @ordered
	 */
	protected double zoom = ZOOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getViewport() <em>Viewport</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getViewport()
	 * @generated
	 * @ordered
	 */
	protected static final Point VIEWPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewport() <em>Viewport</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getViewport()
	 * @generated
	 * @ordered
	 */
	protected Point viewport = VIEWPORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGraphElement() <em>Graph Element</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGraphElement()
	 * @generated
	 * @ordered
	 */
	protected GraphElement graphElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DiagramLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Di2Package.Literals.DIAGRAM_LINK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Diagram getDiagram() {
		if (diagram != null && diagram.eIsProxy()) {
			InternalEObject oldDiagram = (InternalEObject) diagram;
			diagram = (Diagram) eResolveProxy(oldDiagram);
			if (diagram != oldDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Di2Package.DIAGRAM_LINK__DIAGRAM,
							oldDiagram, diagram));
			}
		}
		return diagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Diagram basicGetDiagram() {
		return diagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDiagram(Diagram newDiagram) {
		Diagram oldDiagram = diagram;
		diagram = newDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_LINK__DIAGRAM, oldDiagram, diagram));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getZoom() {
		return zoom;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setZoom(double newZoom) {
		double oldZoom = zoom;
		zoom = newZoom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_LINK__ZOOM, oldZoom, zoom));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Point getViewport() {
		return viewport;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setViewport(Point newViewport) {
		Point oldViewport = viewport;
		viewport = newViewport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_LINK__VIEWPORT, oldViewport,
					viewport));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement getGraphElement() {
		if (graphElement != null && graphElement.eIsProxy()) {
			InternalEObject oldGraphElement = (InternalEObject) graphElement;
			graphElement = (GraphElement) eResolveProxy(oldGraphElement);
			if (graphElement != oldGraphElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Di2Package.DIAGRAM_LINK__GRAPH_ELEMENT,
							oldGraphElement, graphElement));
			}
		}
		return graphElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement basicGetGraphElement() {
		return graphElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGraphElement(GraphElement newGraphElement) {
		GraphElement oldGraphElement = graphElement;
		graphElement = newGraphElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_LINK__GRAPH_ELEMENT,
					oldGraphElement, graphElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Di2Package.DIAGRAM_LINK__DIAGRAM:
			if (resolve)
				return getDiagram();
			return basicGetDiagram();
		case Di2Package.DIAGRAM_LINK__ZOOM:
			return new Double(getZoom());
		case Di2Package.DIAGRAM_LINK__VIEWPORT:
			return getViewport();
		case Di2Package.DIAGRAM_LINK__GRAPH_ELEMENT:
			if (resolve)
				return getGraphElement();
			return basicGetGraphElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Di2Package.DIAGRAM_LINK__DIAGRAM:
			setDiagram((Diagram) newValue);
			return;
		case Di2Package.DIAGRAM_LINK__ZOOM:
			setZoom(((Double) newValue).doubleValue());
			return;
		case Di2Package.DIAGRAM_LINK__VIEWPORT:
			setViewport((Point) newValue);
			return;
		case Di2Package.DIAGRAM_LINK__GRAPH_ELEMENT:
			setGraphElement((GraphElement) newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
		case Di2Package.DIAGRAM_LINK__DIAGRAM:
			setDiagram((Diagram) null);
			return;
		case Di2Package.DIAGRAM_LINK__ZOOM:
			setZoom(ZOOM_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_LINK__VIEWPORT:
			setViewport(VIEWPORT_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_LINK__GRAPH_ELEMENT:
			setGraphElement((GraphElement) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Di2Package.DIAGRAM_LINK__DIAGRAM:
			return diagram != null;
		case Di2Package.DIAGRAM_LINK__ZOOM:
			return zoom != ZOOM_EDEFAULT;
		case Di2Package.DIAGRAM_LINK__VIEWPORT:
			return VIEWPORT_EDEFAULT == null ? viewport != null : !VIEWPORT_EDEFAULT.equals(viewport);
		case Di2Package.DIAGRAM_LINK__GRAPH_ELEMENT:
			return graphElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (zoom: ");
		result.append(zoom);
		result.append(", viewport: ");
		result.append(viewport);
		result.append(')');
		return result.toString();
	}

} // DiagramLinkImpl
