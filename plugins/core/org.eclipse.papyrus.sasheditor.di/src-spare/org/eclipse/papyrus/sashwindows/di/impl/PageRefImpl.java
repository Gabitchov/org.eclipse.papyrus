/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sashwindows.di.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.sashwindows.di.DiPackage;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.TabFolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.PageRefImpl#getPageIdentifier <em>Page Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.PageRefImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageRefImpl extends EObjectImpl implements PageRef {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getPageIdentifier() {
		Object res = getEmfPageIdentifier();
		
		if( res != null )
		{
			return res;
		}
		else
			return getObjectPageIdentifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isForIdentifier(Object pageIdentifier) {
		  return getPageIdentifier().equals(pageIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPageIdentifier(Object newPageIdentifier) {
		
		if(newPageIdentifier instanceof EObject)
		{
			setEmfPageIdentifier((EObject)newPageIdentifier);
			return;
		}
		
		// if null, unset all
		if( newPageIdentifier == null && getEmfPageIdentifier() != null)
		{
			setEmfPageIdentifier(null);
		}
		else
		{
			setObjectPageIdentifier(newPageIdentifier);
		}
		
		
	}

} //PageRefImpl
