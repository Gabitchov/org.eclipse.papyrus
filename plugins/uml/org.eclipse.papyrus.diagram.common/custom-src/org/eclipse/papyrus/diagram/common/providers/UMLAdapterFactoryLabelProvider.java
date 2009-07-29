/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.uml2.common.edit.provider.IItemQualifiedTextProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class UMLAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider {

	public UMLAdapterFactoryLabelProvider() {
		super(new UMLItemProviderAdapterFactory());

	}

	@Override
	public String getText(Object object) {
		IItemQualifiedTextProvider itemQualifiedTextProvider = (IItemQualifiedTextProvider) adapterFactory.adapt(
				object, IItemQualifiedTextProvider.class);

		String qualifiedName = itemQualifiedTextProvider != null ? itemQualifiedTextProvider.getQualifiedText(object)
				: super.getText(object);

		IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(object,
				IItemLabelProvider.class);

		String labelName = itemLabelProvider != null ? itemLabelProvider.getText(object) : super.getText(object);

		String typeDecorator = !labelName.equals("") ? labelName.split(">")[0] + ">" : "";

		return typeDecorator + " " + qualifiedName;
	}

}
