/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.providers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;

public class ExtensionDefintionContentProvider implements ITreeContentProvider {

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 * 
	 */
	public void dispose() {

	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(Object inputElement) {
		HashSet<ExtensionDefinition> output = new HashSet<ExtensionDefinition>();

		if(inputElement instanceof Facade) {
			EList<ExtensionDefinition> extensionsDefinitions = ((Facade)inputElement).getExtensionDefinitions();
			for(ExtensionDefinition extensionDefinition : extensionsDefinitions) {
				output.add(extensionDefinition);
			}
		}

		return output.toArray();
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 * 
	 * @param parentElement
	 * @return
	 */
	public Object[] getChildren(Object parentElement) {
		List<BaseMetaclass> output = new ArrayList<BaseMetaclass>();
		if(parentElement instanceof ExtensionDefinition) {

			ExtensionDefinition parent = (ExtensionDefinition)parentElement;

			if(parent.getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
				for(BaseMetaclass baseMetaclass : parent.getBaseMetaclasses()) {
					if(!((EClass)baseMetaclass.getBase()).isAbstract()) {
						output.add(baseMetaclass);
					}
				}
			}
		}
		return output.toArray();
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasChildren(Object element) {
		if(getChildren(element).length != 0) {
			return true;
		} else {
			return false;
		}
	}
}
