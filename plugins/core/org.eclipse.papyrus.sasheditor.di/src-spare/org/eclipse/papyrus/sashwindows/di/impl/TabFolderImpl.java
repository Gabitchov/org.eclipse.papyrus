/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sashwindows.di.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.sashwindows.di.DiFactory;
import org.eclipse.papyrus.sashwindows.di.DiPackage;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.TabFolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tab Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.TabFolderImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TabFolderImpl extends AbstractPanelImpl implements TabFolder {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addPage(Object pageIdentifier) {
		PageRef newPage = DiFactory.eINSTANCE.createPageRef();
		newPage.setPageIdentifier(pageIdentifier);
		getChildren().add(newPage);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removePage(int pageIndex) {
		getChildren().remove(pageIndex);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sashwindows.di.TabFolder#movePage(int, int)
	 *
	 * @param oldIndex
	 * @param newIndex
	 * @generated NOT
	 */
	public void movePage(int oldIndex, int newIndex) {
		int listSize = getChildren().size();
		if (newIndex >= listSize)
		{
			newIndex = listSize-1;
		}
		if (newIndex < 0)
		{
			newIndex = 0;
		}
		
		if (oldIndex == newIndex)
			return;

		if( listSize == 0)
			return;


		getChildren().move(newIndex, oldIndex);
	}

} //TabFolderImpl
