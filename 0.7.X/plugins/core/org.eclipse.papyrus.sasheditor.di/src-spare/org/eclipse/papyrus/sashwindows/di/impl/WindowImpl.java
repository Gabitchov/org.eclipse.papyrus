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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.sashwindows.di.DiPackage;
import org.eclipse.papyrus.sashwindows.di.Position;
import org.eclipse.papyrus.sashwindows.di.Size;
import org.eclipse.papyrus.sashwindows.di.Window;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Window</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.WindowImpl#getPanel <em>Panel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.WindowImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.impl.WindowImpl#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowImpl extends AbstractNodeImpl implements Window {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void replaceChild(AbstractPanel oldChild, AbstractPanel newChild) {
		setPanel(newChild);
		newChild.setParent(this);
	}


} //WindowImpl
