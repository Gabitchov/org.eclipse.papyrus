/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sashwindows.di.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.sashwindows.di.AbstractNode;
import org.eclipse.papyrus.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.sashwindows.di.DiPackage;
import org.eclipse.papyrus.sashwindows.di.SashPanel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sash Panel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.SashPanelImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.SashPanelImpl#getSashPosition <em>Sash Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.SashPanelImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SashPanelImpl extends AbstractPanelImpl implements SashPanel {
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setChildren(AbstractPanel leftChild, AbstractPanel rightChild, int direction) {
		setDirection(direction);
		List<AbstractPanel> children = getChildren();

		if( children.size()==0)
		{
			children.add(leftChild);
			children.add(rightChild);
			
		}
		else
		{
			// Detach old child
			children.get(0).setParent(null);
			children.get(1).setParent(null);
			children.set(0, leftChild);
			children.set(1, rightChild);
		}
		// set children's parent
		leftChild.setParent(this);
		rightChild.setParent(this);

	}

	/**
	 * <!-- begin-user-doc -->
	 * Set both ends (parent and child).
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void replaceChild(AbstractPanel oldChild, AbstractPanel newChild) {
		
		int index = getChildren().indexOf(oldChild);
		if(index>=0)
		{
			// do replace
			getChildren().set(index, newChild);
			newChild.setParent(this);
		}
	}

} //SashPanelImpl
