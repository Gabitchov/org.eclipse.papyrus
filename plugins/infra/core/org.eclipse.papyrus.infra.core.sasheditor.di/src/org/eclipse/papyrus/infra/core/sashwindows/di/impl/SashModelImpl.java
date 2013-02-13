/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di.impl;

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
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiFactory;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch;
import org.eclipse.swt.SWT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sash Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashModelImpl#getWindows <em>Windows</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashModelImpl#getCurrentSelection <em>Current Selection</em>}</li>
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
	 * 
	 * @generated NOT
	 */
	public void addPage(Object pageIdentifier) {
		getCurrentSelection().addPage(pageIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void addPage(TabFolder folder, Object pageIdentifier) {
//		if(folder==null) {
//			// Use first folder
//			folder = getFirstFolder();
//		}
		folder.addPage(pageIdentifier);
	}

	/**
	 * Get the first folder in the model.
	 * Return null if no folder exist.
	 * @return
	 */
//	public TabFolder getFirstFolder() {
//		
//	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void removePage(Object pageIdentifier) {
		PageRef pageRef = lookupPage(pageIdentifier);
		if(pageRef == null)
			return;

		// Get the folder containing the page
		TabFolder folder = pageRef.getParent();
		// Remove the page
		folder.getChildren().remove(pageRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void removePageAndEmptyFolder(Object pageIdentifier) {
		PageRef pageRef = lookupPage(pageIdentifier);
		if(pageRef == null)
			return;

		// Get the folder containing the page
		TabFolder folder = pageRef.getParent();
		// Remove the page
		folder.getChildren().remove(pageRef);
		// Remove parent if empty
		removeEmptyFolder(folder);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCurrentSelectionSilently(TabFolder selection) {
		currentSelection = selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public PageRef lookupPage(final Object pageIdentifier) {

		// Create appropriate visitor.
		DiSwitch<PageRef> visitor = new DiSwitch<PageRef>() {

			/**
			 * Iterate over windows
			 * 
			 * @see org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch#caseSashModel(org.eclipse.papyrus.infra.core.sashwindows.di.SashModel)
			 * 
			 * @param object
			 * @return
			 */
			public PageRef caseSashModel(SashModel object) {
				PageRef res = null;
				for(Window window : object.getWindows())
				{
					res = this.doSwitch(window);
					if(res != null)
						return res;
				}

				return super.caseSashModel(object);
			}

			/**
			 * 
			 * @see org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch#caseWindow(org.eclipse.papyrus.infra.core.sashwindows.di.Window)
			 * 
			 * @param object
			 * @return
			 */
			public PageRef caseWindow(Window window) {

				AbstractPanel panel = window.getPanel();
				if(panel == null)
					return null;


				PageRef res = this.doSwitch(panel);
				if(res != null)
					return res;

				return super.caseWindow(window);
			}

			/**
			 * Iterate over children
			 * 
			 * @see org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch#caseSashPanel(org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel)
			 * 
			 * @param object
			 * @return
			 */
			public PageRef caseSashPanel(SashPanel object) {
				PageRef res = null;
				for(AbstractPanel panel : object.getChildren())
				{
					res = this.doSwitch(panel);
					if(res != null)
						return res;
				}

				return super.caseSashPanel(object);
			}

			/**
			 * Iterate over PageRef
			 * 
			 * @see org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch#caseTabFolder(org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder)
			 * 
			 * @param object
			 * @return
			 */
			public PageRef caseTabFolder(TabFolder object) {
				for(PageRef pageRef : object.getChildren())
				{

					if(pageRef.isForIdentifier(pageIdentifier))
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
	 * TODO Add method to metamodel
	 * 
	 * @generated NOT
	 */
	public TabFolder lookupFirstFolder() {

		// Create appropriate visitor.
		DiSwitch<TabFolder> visitor = new DiSwitch<TabFolder>() {

			/**
			 * Iterate over windows
			 * 
			 * @see org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch#caseSashModel(org.eclipse.papyrus.infra.core.sashwindows.di.SashModel)
			 * 
			 * @param object
			 * @return
			 */
			public TabFolder caseSashModel(SashModel object) {
				TabFolder res = null;
				for(Window window : object.getWindows())
				{
					res = this.doSwitch(window);
					if(res != null)
						return res;
				}

				return super.caseSashModel(object);
			}

			/**
			 * 
			 * @see org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch#caseWindow(org.eclipse.papyrus.infra.core.sashwindows.di.Window)
			 * 
			 * @param object
			 * @return
			 */
			public TabFolder caseWindow(Window window) {

				AbstractPanel panel = window.getPanel();
				if(panel == null)
					return null;


				TabFolder res = this.doSwitch(panel);
				if(res != null)
					return res;

				return super.caseWindow(window);
			}

			/**
			 * Iterate over children
			 * 
			 * @see org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch#caseSashPanel(org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel)
			 * 
			 * @param object
			 * @return
			 */
			public TabFolder caseSashPanel(SashPanel object) {
				TabFolder res = null;
				for(AbstractPanel panel : object.getChildren())
				{
					res = this.doSwitch(panel);
					if(res != null)
						return res;
				}

				return super.caseSashPanel(object);
			}

			/**
			 * Iterate over PageRef
			 * 
			 * @see org.eclipse.papyrus.infra.core.sashwindows.di.util.DiSwitch#caseTabFolder(org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder)
			 * 
			 * @param object
			 * @return
			 */
			public TabFolder caseTabFolder(TabFolder object) {
				return object;
			}

		};

		// Do lookup
		TabFolder res = visitor.doSwitch(this);

		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * TODO Add method to metamodel
	 * 
	 * @generated NOT
	 */
	public Window lookupFirstWindow() {
	
		List<Window> list = getWindows();
		if(list.size() == 0)
			return null;
		
		return list.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void movePage(TabFolder srcParentFolder, int srcIndex, TabFolder targetParentFolder, int targetIndex) {


		// Check if we move all pages of srcFolder
		if(srcIndex == -1) {
			// move all
			List<PageRef> srcChildrens = srcParentFolder.getChildren();
			List<PageRef> targetChildrens = targetParentFolder.getChildren();
//			while(srcChildrens.size() > 0) {
//				PageRef pageRef = srcChildrens.remove(0);
//				targetChildrens.add(pageRef);
//			}
			
			if(targetIndex < 0 || targetIndex >= targetChildrens.size()) {
				// Index is out of bounds. Move at the end.
				targetChildrens.addAll(srcChildrens);
			}
			else {
				// index is in bounds. Move at index.
				targetChildrens.addAll(targetIndex, srcChildrens);
			}
			return;
		}

		// Move only one
		PageRef pageRef = srcParentFolder.getChildren().remove(srcIndex);

		List<PageRef> targetChildrens = targetParentFolder.getChildren();
		// Check if out of target range.
		if(targetIndex < 0 || targetIndex > targetChildrens.size())
			targetChildrens.add(pageRef);
		else
			targetChildrens.add(targetIndex, pageRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void insertFolder(TabFolder folderToInsert, TabFolder refFolder, int side) {

		// Get the parent under which the sash will be inserted
		PanelParent refParent = refFolder.getParent();

		SashPanel newSash;
		int direction;

		// Compute sash direction
		if(side == SWT.LEFT || side == SWT.RIGHT)
			direction = SWT.HORIZONTAL;
		else
			direction = SWT.VERTICAL;
		// Create sash
		newSash = DiFactory.eINSTANCE.createSashPanel();
		// Insert in parent. Should be done before setting childrens, otherwise, the child can't be
		// replaced as it will not belong to parent anymore.
		refParent.replaceChild(refFolder, newSash);

		if(side == SWT.LEFT || side == SWT.UP) { // insert left
			newSash.setChildren(folderToInsert, refFolder, direction);
		} else {
			newSash.setChildren(refFolder, folderToInsert, direction);
		}

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void movePage(TabFolder srcParentFolder, int srcIndex, TabFolder targetParentFolder) {

		// Check if we move all pages of srcFolder
		if(srcIndex == -1) {
			// move all
			List<PageRef> srcChildrens = srcParentFolder.getChildren();
			List<PageRef> targetChildrens = targetParentFolder.getChildren();
			while(srcChildrens.size() > 0) {
				PageRef pageRef = srcChildrens.remove(0);
				targetChildrens.add(pageRef);
			}
			return;
		}
		
		// Move only one page
		PageRef pageRef = srcParentFolder.getChildren().remove(srcIndex);
		List<PageRef> targetChildrens = targetParentFolder.getChildren();
		// Check if out of target range.
		targetChildrens.add(pageRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void removeEmptyFolder(TabFolder folder) {

		EList<PageRef> children = folder.getChildren();

		// Check if empty
		if(children.size() > 0)
			return;

		PanelParent parent = folder.getParent();
		// Forbid removing of the last folder
		if(parent instanceof Window)
			return;

		// Parent is a sash. Ask it to remove the child and itself
		((SashPanel)parent).delete(folder);
		// adjust current selection if the old folder was the currentSelection
		if(getCurrentSelection() == folder) {
			setCurrentSelectionSilently(lookupFirstFolder());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeAllPages() {
		
		// Get a the first window and a folder.
		// Clear the folder and set it as the root folder.
		// This disguard all other folder and pages ...
		Window firstWindow = lookupFirstWindow();
		TabFolder folder = lookupFirstFolder();
		
		folder.getChildren().clear();
		firstWindow.setPanel(folder);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeOtherPages(Object pageIdentifier) {
		// Get a the first window and a folder.
		// Clear the folder and set it as the root folder.
		// This disguard all other folder and pages ...
		Window firstWindow = lookupFirstWindow();
		TabFolder folder = lookupFirstFolder();
		PageRef page = lookupPage(pageIdentifier);
		
		folder.getChildren().clear();
		if( page != null)
		{
			folder.getChildren().add(page);
		}
		firstWindow.setPanel(folder);
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
