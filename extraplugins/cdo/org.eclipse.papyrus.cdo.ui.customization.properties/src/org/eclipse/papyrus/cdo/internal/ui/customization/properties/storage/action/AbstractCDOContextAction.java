/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.action;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.CDOTextURIHandler;
import org.eclipse.papyrus.views.properties.contexts.Context;

/**
 * This is the AbstractCDOContextAction type. Enjoy.
 */
public class AbstractCDOContextAction {

	protected CDOTransaction createTransaction(EObject object) {
		CDOView view = null;

		Resource resource = object.eResource();
		if(resource instanceof CDOResource) {
			view = ((CDOResource)resource).cdoView();
		} else {
			view = CDOTextURIHandler.getView(resource.getResourceSet(), resource.getURI());
		}

		CDOTransaction result = null;

		if(view != null) {
			result = view.getSession().openTransaction();
			CDOTextURIHandler.install(result.getResourceSet());
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	protected <T extends EObject> T getDoppelganger(T original, CDOView view) {
		Resource resource = original.eResource();
		if(resource instanceof CDOResource) {
			CDOID oid = CDOUtil.getCDOObject(original).cdoID();
			return (T)CDOUtil.getEObject(view.getObject(oid));
		} else {
			return (T)view.getResourceSet().getEObject(EcoreUtil.getURI(original), true);
		}
	}

	protected CDOResourceFolder getContextFolder(Context context) {
		CDOResourceFolder result = null;

		Resource resource = context.eResource();

		if(resource instanceof CDOResource) {
			result = ((CDOResource)resource).getFolder();
		} else {
			CDOView view = CDOTextURIHandler.getView(resource.getResourceSet(), resource.getURI());
			if(view != null) {
				CDOResourceNode node = view.getResourceNode(URI.decode(CDOURIUtil.extractResourcePath(CDOTextURIHandler.translate(resource.getURI()))));
				if(node != null) {
					result = node.getFolder();
				}
			}
		}
		return result;
	}

}
