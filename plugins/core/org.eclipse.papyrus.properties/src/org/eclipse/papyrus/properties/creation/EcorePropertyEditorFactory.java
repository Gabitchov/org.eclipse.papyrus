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


public class EcorePropertyEditorFactory extends PropertyEditorFactory {

	private EClass eClass;

	private String nsUri;

	private String className;

	public EcorePropertyEditorFactory() {

	}

	public EcorePropertyEditorFactory(EClass eClass) {
		this.eClass = eClass;
	}

	public String getNsUri() {
		return nsUri;
	}

	public String getClassName() {
		return className;
	}

	public void setNsUri(String nsUri) {
		this.nsUri = nsUri;
		checkEClass();
	}

	public void setClassName(String className) {
		this.className = className;
		checkEClass();
	}

	private void checkEClass() {
		if(nsUri != null && className != null) {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsUri);
			eClass = (EClass)ePackage.getEClassifier(className);
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
