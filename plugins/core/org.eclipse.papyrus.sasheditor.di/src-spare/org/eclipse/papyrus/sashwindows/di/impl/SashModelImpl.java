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
import org.eclipse.papyrus.sashwindows.di.AbstractNode;
import org.eclipse.papyrus.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.sashwindows.di.DiFactory;
import org.eclipse.papyrus.sashwindows.di.DiPackage;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.SashModel;
import org.eclipse.papyrus.sashwindows.di.SashPanel;
import org.eclipse.papyrus.sashwindows.di.TabFolder;
import org.eclipse.papyrus.sashwindows.di.Window;
import org.eclipse.papyrus.sashwindows.di.util.DiSwitch;
import org.eclipse.swt.SWT;

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
	 * @generated NOT
	 */
	public void insertFolder(TabFolder folderToInsert, TabFolder refFolder, int side) {

		// Get the parent under which the sash will be inserted
		AbstractNode refParent = refFolder.getParent();
		
		SashPanel newSash ;
		int direction;
		
		// Compute sash direction
		if(side == SWT.LEFT || side == SWT.RIGHT)
			direction = SWT.HORIZONTAL;
		else
			direction = SWT.VERTICAL;
		// Create sash
		newSash = DiFactory.eINSTANCE.createSashPanel();
		
		if(side == SWT.LEFT || side == SWT.UP)
		{ // insert left
			newSash.setChildren(folderToInsert, refFolder, direction);
		}
		else
		{
			newSash.setChildren(refFolder, folderToInsert, direction);
		}
		// Insert in parent
		refParent.replaceChild( refFolder, newSash);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void movePage(TabFolder srcParentFolder, int srcIndex, TabFolder targetParentFolder) {

		PageRef pageRef = srcParentFolder.getChildren().remove(srcIndex);
		
		List<PageRef> targetChildrens = targetParentFolder.getChildren();
		// Check if out of target range.
		targetChildrens.add(pageRef);
	}

} //SashModelImpl
