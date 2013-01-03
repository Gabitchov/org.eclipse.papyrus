/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.navigator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLDomainNavigatorLabelProvider implements ICommonLabelProvider {

	/**
	 * @generated
	 */
	private final AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance()
			.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	public void init(final ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Image getImage(final Object element) {
		if (element instanceof UMLDomainNavigatorItem) {
			return this.myAdapterFactoryLabelProvider.getImage(((UMLDomainNavigatorItem) element).getEObject());
		}
		return null;
	}

	/**
	 * @generated
	 */
	public String getText(final Object element) {
		if (element instanceof UMLDomainNavigatorItem) {
			return this.myAdapterFactoryLabelProvider.getText(((UMLDomainNavigatorItem) element).getEObject());
		}
		return null;
	}

	/**
	 * @generated
	 */
	public void addListener(final ILabelProviderListener listener) {
		this.myAdapterFactoryLabelProvider.addListener(listener);
	}

	/**
	 * @generated
	 */
	public void dispose() {
		this.myAdapterFactoryLabelProvider.dispose();
	}

	/**
	 * @generated
	 */
	public boolean isLabelProperty(final Object element, final String property) {
		return this.myAdapterFactoryLabelProvider.isLabelProperty(element, property);
	}

	/**
	 * @generated
	 */
	public void removeListener(final ILabelProviderListener listener) {
		this.myAdapterFactoryLabelProvider.removeListener(listener);
	}

	/**
	 * @generated
	 */
	public void restoreState(final IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(final IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(final Object anElement) {
		return null;
	}

}
