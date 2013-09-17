/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.notationmodel.edit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;


/**
 * Custom Diagram Item provider
 * 
 * @author cedric dumoulin
 *
 */
public class DiagramItemProvider extends org.eclipse.gmf.runtime.notation.provider.DiagramItemProvider {


	protected AdapterFactory domainAdapterFactory;
	
	/**
	 * Constructor.
	 *
	 * @param adapterFactory
	 * @param domainAdapterFactory 
	 */
	public DiagramItemProvider(AdapterFactory adapterFactory, AdapterFactory domainAdapterFactory) {
		super(adapterFactory);
		this.adapterFactory = adapterFactory;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		return getChildren(object);
	}
	
	@Override
	public Collection<?> getElements(Object object) {
		
		Diagram diagram = (Diagram)object;
		if(diagram.getChildren().size() == 0) {
			return Collections.emptyList();
		}
		
		// TODO: improve the implementation by using a view list or
		// by having an internal shadow list
		List<View> children = diagram.getChildren();
		List<View> res = new ArrayList<View>()
				;
		for( View v : children) {
			if( v instanceof Shape || v instanceof Connector) {
				res.add(v);
			}
			
		}
		
		List<View> edges = diagram.getEdges();
		for( View v : edges) {
			if( v instanceof Shape || v instanceof Connector) {
				res.add(v);
			}
			
		}
		return res;
	}
}
