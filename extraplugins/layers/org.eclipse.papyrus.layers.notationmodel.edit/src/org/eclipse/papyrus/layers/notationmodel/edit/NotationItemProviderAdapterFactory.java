/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.notationmodel.edit;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;

/**
 * A ProviderAdapterFactory for notations elements in Layers.
 * The associated providers allows to render notation elements as UML elements.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class NotationItemProviderAdapterFactory extends org.eclipse.gmf.runtime.notation.provider.NotationItemProviderAdapterFactory {


	/**
	 * The {@link AdapterFactory} to which some methods will delegate to show business
	 * models.
	 */
	protected AdapterFactory domainAdapterFactory;
	
	/**
	 * Constructor.
	 *
	 * @param domainAdapterFactory
	 */
	public NotationItemProviderAdapterFactory(AdapterFactory domainAdapterFactory) {
		this.domainAdapterFactory = domainAdapterFactory;
	}
	/**
	 * Use our DiagramAdapter.
	 * @see org.eclipse.gmf.runtime.notation.provider.NotationItemProviderAdapterFactory#createDiagramAdapter()
	 *
	 * @return
	 */
	@Override
	public Adapter createDiagramAdapter() {
		if (diagramItemProvider == null) {
			diagramItemProvider = new DiagramItemProvider(this, domainAdapterFactory);
		}

		return diagramItemProvider;
	}
	
	@Override
	public Adapter createShapeAdapter() {
		if (shapeItemProvider == null) {
			shapeItemProvider = new ShapeItemProvider(this, domainAdapterFactory);
		}

		return shapeItemProvider;
	}
	
	@Override
	public Adapter createConnectorAdapter() {
		if (connectorItemProvider == null) {
			connectorItemProvider = new ConnectorItemProvider(this, domainAdapterFactory);
		}

		return connectorItemProvider;
	}
}
