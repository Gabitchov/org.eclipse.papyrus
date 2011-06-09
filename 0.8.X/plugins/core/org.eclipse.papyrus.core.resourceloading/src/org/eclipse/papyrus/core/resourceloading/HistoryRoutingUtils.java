/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.controlmode.history.HistoryModel;
import org.eclipse.papyrus.controlmode.history.utils.HistoryUtils;
import org.eclipse.papyrus.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.sasheditor.SashModel;
import org.eclipse.papyrus.resource.sasheditor.SashModelUtils;


/**
 * The Class HistoryRoutingUtils.
 */
public class HistoryRoutingUtils {

	/**
	 * Retrieves all the URIs of the controlled resources of the initial resource uri
	 * 
	 * @param model
	 *        , the history model
	 * @param initialURI
	 *        , the uri to check
	 * @return
	 */
	public static Set<String> getAllControledURIs(ModelSet set, HistoryModel model, URI initialURI, boolean loadCorrespondantDI) {
		Set<String> result = new HashSet<String>();
		String path = HistoryUtils.getURIFullPath(SashModelUtils.getInitialURI(set)).toString();
		if(model != null && initialURI != null) {
			ControledResourceAdapter adapter = getControledResourceAdapter(set);
			set.getResource(URI.createURI(path.concat(initialURI.trimFragment().trimFileExtension().appendFileExtension(SashModel.MODEL_FILE_EXTENSION).toString())), loadCorrespondantDI);
			List<ControledResource> elements = adapter.getControledResource(initialURI.toString());
			for(ControledResource c : elements) {
				for(ControledResource child : c.getChildren()) {
					URI childURI = URI.createURI(child.getResourceURL());
					result.add(childURI.toString());
					result.addAll(getAllControledURIs(set, model, childURI, loadCorrespondantDI));
				}
			}
		}
		return result;
	}

	/**
	 * get the controled resource adapter from the given {@link ModelSet} if it is not found it is installed
	 * 
	 * @param set
	 * @return
	 */
	public static ControledResourceAdapter getControledResourceAdapter(ModelSet set) {
		ControledResourceAdapter adapter = null;
		for(Adapter a : set.eAdapters()) {
			if(a instanceof ControledResourceAdapter) {
				adapter = (ControledResourceAdapter)a;
			}
		}
		if(adapter == null) {
			adapter = new ControledResourceAdapter(set);
		}
		return adapter;
	}

}
