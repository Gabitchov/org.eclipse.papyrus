/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sashwindows.di.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.sashwindows.di.DiFactory;
import org.eclipse.papyrus.sashwindows.di.DiPackage;
import org.eclipse.papyrus.sashwindows.di.PageList;
import org.eclipse.papyrus.sashwindows.di.PageRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.PageListImpl#getAvailablePage <em>Available Page</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageListImpl extends EObjectImpl implements PageList {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addPage(Object pageIdentifier) {
		
		PageRef pageRef = DiFactory.eINSTANCE.createPageRef();
		pageRef.setPageIdentifier(pageIdentifier);
		getAvailablePage().add(pageRef);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removePage(Object pageIdentifier) {
		for( PageRef pageRef : getAvailablePage() )
		{

			if(pageRef.getPageIdentifier().equals(pageIdentifier))
			{
				getAvailablePage().remove(pageRef);
				return ;
			}
		}
	}

} //PageListImpl
