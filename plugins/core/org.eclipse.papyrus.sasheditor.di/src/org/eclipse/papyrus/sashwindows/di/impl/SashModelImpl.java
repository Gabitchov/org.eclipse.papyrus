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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.sashwindows.di.DiPackage;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.SashModel;
import org.eclipse.papyrus.sashwindows.di.SashPanel;
import org.eclipse.papyrus.sashwindows.di.TabFolder;
import org.eclipse.papyrus.sashwindows.di.Window;
import org.eclipse.papyrus.sashwindows.di.util.DiSwitch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sash Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.SashModelImpl#getWindows <em>Windows</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.SashModelImpl#getCurrentSelection <em>Current Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SashModelImpl extends EObjectImpl implements SashModel {
	/**
	 * The cached value of the '{@link #getWindows() <em>Windows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWindows()
	 * @generated
	 * @ordered
	 */
	protected EList<Window> windows;
	/**
	 * The cached value of the '{@link #getCurrentSelection() <em>Current Selection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSelection()
	 * @generated
	 * @ordered
	 */
	protected TabFolder currentSelection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SashModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.SASH_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Window> getWindows() {
		if (windows == null) {
			windows = new EObjectContainmentEList<Window>(Window.class, this, DiPackage.SASH_MODEL__WINDOWS);
		}
		return windows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TabFolder getCurrentSelection() {
		if (currentSelection != null && currentSelection.eIsProxy()) {
			InternalEObject oldCurrentSelection = (InternalEObject)currentSelection;
			currentSelection = (TabFolder)eResolveProxy(oldCurrentSelection);
			if (currentSelection != oldCurrentSelection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiPackage.SASH_MODEL__CURRENT_SELECTION, oldCurrentSelection, currentSelection));
			}
		}
		return currentSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TabFolder basicGetCurrentSelection() {
		return currentSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentSelection(TabFolder newCurrentSelection) {
		TabFolder oldCurrentSelection = currentSelection;
		currentSelection = newCurrentSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.SASH_MODEL__CURRENT_SELECTION, oldCurrentSelection, currentSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addPage(Object pageIdentifier) {
		getCurrentSelection().addPage(pageIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removePage(Object pageIdentifier) {
		PageRef pageRef = lookupPage(pageIdentifier);
		if(pageRef == null)
			return;
		
		// Remove it
		pageRef.getParent().getChildren().remove(pageRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PageRef lookupPage(final Object pageIdentifier) {
		
		// Create appropriate visitor.
		DiSwitch<PageRef> visitor = new DiSwitch<PageRef>( ) {
			
			/**
			 * Iterate over windows
			 * @see org.eclipse.papyrus.sashwindows.di.util.DiSwitch#caseSashModel(org.eclipse.papyrus.sashwindows.di.SashModel)
			 *
			 * @param object
			 * @return
			 */
			public PageRef caseSashModel(SashModel object) {
				PageRef res = null;
				for( Window window : object.getWindows() )
				{
					 res = this.doSwitch(window);
					 if(res != null)
						 return res;
				}
				
				return super.caseSashModel(object);
			}
			
			/**
			 * Iterate over children
			 * @see org.eclipse.papyrus.sashwindows.di.util.DiSwitch#caseSashPanel(org.eclipse.papyrus.sashwindows.di.SashPanel)
			 *
			 * @param object
			 * @return
			 */
			public PageRef caseSashPanel(SashPanel object) {
				PageRef res = null;
				for( AbstractPanel panel : object.getChildren() )
				{
					 res = this.doSwitch(panel);
					 if(res != null)
						 return res;
				}
				
				return super.caseSashPanel(object);
			}
			
			/**
			 * Iterate over PageRef
			 * @see org.eclipse.papyrus.sashwindows.di.util.DiSwitch#caseTabFolder(org.eclipse.papyrus.sashwindows.di.TabFolder)
			 *
			 * @param object
			 * @return
			 */
			public PageRef caseTabFolder(TabFolder object) {
				for( PageRef pageRef : object.getChildren() )
				{
					 
					 if(pageRef.isForIdentifier(pageIdentifier) )
						 return pageRef;
				}
				
				return super.caseTabFolder(object);
			}
		};
		
		// Do lookup
		PageRef res = visitor.doSwitch(this);
		
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removePage(int pageIndex, TabFolder parentFolder) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void movePage(TabFolder srcParentFolder, int srcIndex, TabFolder targetParentFolder, int targetIndex) {

		PageRef pageRef = srcParentFolder.getChildren().remove(srcIndex);
		
		List<PageRef> targetChildrens = targetParentFolder.getChildren();
		// Check if out of target range.
		if( targetIndex<0 || targetIndex > targetChildrens.size())
			targetChildrens.add(pageRef);
		else
		    targetChildrens.add(targetIndex, pageRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiPackage.SASH_MODEL__WINDOWS:
				return ((InternalEList<?>)getWindows()).basicRemove(otherEnd, msgs);
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
			case DiPackage.SASH_MODEL__WINDOWS:
				return getWindows();
			case DiPackage.SASH_MODEL__CURRENT_SELECTION:
				if (resolve) return getCurrentSelection();
				return basicGetCurrentSelection();
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
			case DiPackage.SASH_MODEL__WINDOWS:
				getWindows().clear();
				getWindows().addAll((Collection<? extends Window>)newValue);
				return;
			case DiPackage.SASH_MODEL__CURRENT_SELECTION:
				setCurrentSelection((TabFolder)newValue);
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
			case DiPackage.SASH_MODEL__WINDOWS:
				getWindows().clear();
				return;
			case DiPackage.SASH_MODEL__CURRENT_SELECTION:
				setCurrentSelection((TabFolder)null);
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
			case DiPackage.SASH_MODEL__WINDOWS:
				return windows != null && !windows.isEmpty();
			case DiPackage.SASH_MODEL__CURRENT_SELECTION:
				return currentSelection != null;
		}
		return super.eIsSet(featureID);
	}

} //SashModelImpl
