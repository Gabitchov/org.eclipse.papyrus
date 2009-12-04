/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;

import org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternate Canvas</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl#getDomainDiagramElement <em>Domain Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl#getAlternateTopLevelNodes <em>Alternate Top Level Nodes</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl#getAlternateLinkNodes <em>Alternate Link Nodes</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AlternateCanvasImpl extends CommentedElementImpl implements AlternateCanvas {

	/**
	 * The cached value of the '{@link #getDomainDiagramElement() <em>Domain Diagram Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDomainDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected GenClass domainDiagramElement;

	/**
	 * The cached value of the '{@link #getAlternateTopLevelNodes() <em>Alternate Top Level Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAlternateTopLevelNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<AlternateGenTopLevelNode> alternateTopLevelNodes;

	/**
	 * The cached value of the '{@link #getAlternateLinkNodes() <em>Alternate Link Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAlternateLinkNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<AlternateGenLink> alternateLinkNodes;

	/**
	 * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected GenDiagram diagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AlternateCanvasImpl() {
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
		return PapyrusgmfgenextensionPackage.Literals.ALTERNATE_CANVAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenClass getDomainDiagramElement() {
		if(domainDiagramElement != null && domainDiagramElement.eIsProxy()) {
			InternalEObject oldDomainDiagramElement = (InternalEObject)domainDiagramElement;
			domainDiagramElement = (GenClass)eResolveProxy(oldDomainDiagramElement);
			if(domainDiagramElement != oldDomainDiagramElement) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT, oldDomainDiagramElement, domainDiagramElement));
			}
		}
		return domainDiagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenClass basicGetDomainDiagramElement() {
		return domainDiagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDomainDiagramElement(GenClass newDomainDiagramElement) {
		GenClass oldDomainDiagramElement = domainDiagramElement;
		domainDiagramElement = newDomainDiagramElement;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT, oldDomainDiagramElement, domainDiagramElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AlternateGenTopLevelNode> getAlternateTopLevelNodes() {
		if(alternateTopLevelNodes == null) {
			alternateTopLevelNodes = new EObjectContainmentEList<AlternateGenTopLevelNode>(AlternateGenTopLevelNode.class, this, PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES);
		}
		return alternateTopLevelNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AlternateGenLink> getAlternateLinkNodes() {
		if(alternateLinkNodes == null) {
			alternateLinkNodes = new EObjectContainmentEList<AlternateGenLink>(AlternateGenLink.class, this, PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_LINK_NODES);
		}
		return alternateLinkNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenDiagram getDiagram() {
		if(diagram != null && diagram.eIsProxy()) {
			InternalEObject oldDiagram = (InternalEObject)diagram;
			diagram = (GenDiagram)eResolveProxy(oldDiagram);
			if(diagram != oldDiagram) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DIAGRAM, oldDiagram, diagram));
			}
		}
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenDiagram basicGetDiagram() {
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDiagram(GenDiagram newDiagram) {
		GenDiagram oldDiagram = diagram;
		diagram = newDiagram;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DIAGRAM, oldDiagram, diagram));
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES:
			return ((InternalEList<?>)getAlternateTopLevelNodes()).basicRemove(otherEnd, msgs);
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_LINK_NODES:
			return ((InternalEList<?>)getAlternateLinkNodes()).basicRemove(otherEnd, msgs);
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT:
			if(resolve)
				return getDomainDiagramElement();
			return basicGetDomainDiagramElement();
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES:
			return getAlternateTopLevelNodes();
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_LINK_NODES:
			return getAlternateLinkNodes();
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DIAGRAM:
			if(resolve)
				return getDiagram();
			return basicGetDiagram();
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT:
			setDomainDiagramElement((GenClass)newValue);
			return;
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES:
			getAlternateTopLevelNodes().clear();
			getAlternateTopLevelNodes().addAll((Collection<? extends AlternateGenTopLevelNode>)newValue);
			return;
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_LINK_NODES:
			getAlternateLinkNodes().clear();
			getAlternateLinkNodes().addAll((Collection<? extends AlternateGenLink>)newValue);
			return;
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DIAGRAM:
			setDiagram((GenDiagram)newValue);
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT:
			setDomainDiagramElement((GenClass)null);
			return;
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES:
			getAlternateTopLevelNodes().clear();
			return;
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_LINK_NODES:
			getAlternateLinkNodes().clear();
			return;
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DIAGRAM:
			setDiagram((GenDiagram)null);
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
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT:
			return domainDiagramElement != null;
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES:
			return alternateTopLevelNodes != null && !alternateTopLevelNodes.isEmpty();
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__ALTERNATE_LINK_NODES:
			return alternateLinkNodes != null && !alternateLinkNodes.isEmpty();
		case PapyrusgmfgenextensionPackage.ALTERNATE_CANVAS__DIAGRAM:
			return diagram != null;
		}
		return super.eIsSet(featureID);
	}

} //AlternateCanvasImpl
