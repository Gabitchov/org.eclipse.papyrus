/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.creation;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.messages.Messages;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


/**
 * A ReferenceFactory used to instantiate and edit EObjects.
 * The specified nsUri and ClassName are used to instantiate the EObject.
 * The matching {@link org.eclipse.papyrus.properties.contexts.View}s from all
 * applied {@link org.eclipse.papyrus.properties.contexts.Context}s are used to
 * display the right form to edit the EObject.
 * 
 * @author Camille Letavernier
 */
public class EcorePropertyEditorFactory extends PropertyEditorFactory {

	private EClass type;

	private EClass eClass;

	private String nsUri;

	private String className;

	/**
	 * 
	 * Constructor.
	 * 
	 * The factory will be able to instantiate the given EClass
	 * 
	 * @param type
	 *        The EClass to instantiate when creating new EObjects
	 */
	public EcorePropertyEditorFactory(EClass type) {
		this.type = type;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public EcorePropertyEditorFactory() {

	}

	/*
	 * Creates a new EcorePropertyEditorFactory. The given EClass is used to instantiate
	 * a new EObject when the {@link #createObject} method is called.
	 * Constructor.
	 * 
	 * @param eClass
	 * 
	 * public EcorePropertyEditorFactory(EClass eClass) {
	 * this.eClass = eClass;
	 * this.nsUri = eClass.getEPackage().getNsURI();
	 * this.className = eClass.getName();
	 * }
	 */

	/**
	 * @return the nsUri of the EClass used by this factory to instantiate new EObjects
	 * @see #getClassName
	 */
	public String getNsUri() {
		return nsUri;
	}

	/**
	 * @return the className of the EClass used by this factory to instantiate new EObjects
	 * @see #getNsUri()
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the nsUri of the EClass used by this factory to instantiate new EObjects
	 * 
	 * @param nsUri
	 * @see #getClassName
	 */
	public void setNsUri(String nsUri) {
		this.nsUri = nsUri;
		checkEClass();
	}

	/**
	 * Sets the className of the EClass used by this factory to instantiate new EObjects
	 * 
	 * @param className
	 * @see #getNsUri()
	 */
	public void setClassName(String className) {
		this.className = className;
		checkEClass();
	}

	private void checkEClass() {
		if(nsUri != null && className != null) {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsUri);
			if(ePackage == null) {
				Activator.log.warn("Cannot find the EPackage corresponding to URI " + nsUri); //$NON-NLS-1$
			}
			eClass = (EClass)ePackage.getEClassifier(className);
			if(eClass == null) {
				Activator.log.warn("Cannot find the EClass " + className + " in the package " + nsUri); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	@Override
	public boolean canCreateObject() {
		return true;
	}

	@Override
	public Object createObject(Control widget) {
		EClass eClass = chooseEClass(widget);
		if(eClass == null) {
			return null;
		}

		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		return super.createObject(widget, instance);
	}

	private EClass chooseEClass(Control widget) {
		if(eClass != null) {
			return eClass;
		}

		List<EClass> availableClasses = EMFHelper.getSubclassesOf(type, true);
		if(availableClasses.isEmpty()) {
			return null;
		}

		if(availableClasses.size() == 1) {
			return availableClasses.get(0);
		}

		final Menu menu = new Menu(widget);
		for(EClass eClass : availableClasses) {
			final MenuItem item = new MenuItem(menu, SWT.NONE);
			item.setText(eClass.getName());
			item.setData("eClass", eClass); //$NON-NLS-1$
			item.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					EcorePropertyEditorFactory.this.eClass = (EClass)item.getData("eClass"); //$NON-NLS-1$
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					// Nothing
				}

			});
		}

		menu.setVisible(true);

		//The menu is blocking the thread
		Display display = widget.getDisplay();
		while(menu.isVisible()) {
			try {
				if(!display.readAndDispatch()) {
					display.sleep();
				}
			} catch (Throwable ex) {
				Activator.log.error(ex);
			}
		}
		if(!display.isDisposed()) {
			display.update();
		}

		EClass eClass = this.eClass;
		this.eClass = null;

		return eClass;
	}

	@Override
	public Collection<Object> validateObjects(Collection<Object> objectsToValidate) {
		return objectsToValidate;
	}

	@Override
	public String getCreationDialogTitle() {
		return Messages.EcorePropertyEditorFactory_CreateANew + className;
	}
}
