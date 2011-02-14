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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.properties.Activator;


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

	private EClass eClass;

	private String nsUri;

	private String className;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public EcorePropertyEditorFactory() {

	}

	/**
	 * Creates a new EcorePropertyEditorFactory. The given EClass is used to instantiate
	 * a new EObject when the {@link #createObject} method is called.
	 * Constructor.
	 * 
	 * @param eClass
	 */
	public EcorePropertyEditorFactory(EClass eClass) {
		this.eClass = eClass;
		this.nsUri = eClass.getEPackage().getNsURI();
		this.className = eClass.getName();
	}

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
	public Object createObject() {
		return eClass.getEPackage().getEFactoryInstance().create(eClass);
	}

	@Override
	public Collection<Object> validateObjects(Collection<Object> objectsToValidate) {
		return objectsToValidate;
	}
}
