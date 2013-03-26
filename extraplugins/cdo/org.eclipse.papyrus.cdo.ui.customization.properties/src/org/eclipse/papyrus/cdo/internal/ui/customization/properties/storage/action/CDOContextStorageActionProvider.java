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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.CDOTextURIHandler;
import org.eclipse.papyrus.customization.properties.storage.actions.AbstractContextStorageActionProvider;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextCopyAction;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextDeleteAction;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextEditAction;
import org.eclipse.papyrus.views.properties.contexts.Context;


/**
 * This is the CDOContextStorageActionProvider type. Enjoy.
 */
public class CDOContextStorageActionProvider extends AbstractContextStorageActionProvider {

	public CDOContextStorageActionProvider() {
		super();
	}

	public boolean providesFor(Context context) {
		URI uri = EcoreUtil.getURI(context);
		return (uri != null) && CDOUtils.isCDOURI(uri) || CDOTextURIHandler.SCHEME.equals(uri.scheme());
	}

	@Override
	protected IContextCopyAction createContextCopyAction() {
		return new CDOContextCopyAction();
	}

	@Override
	protected IContextEditAction createContextEditAction() {
		return new CDOContextEditAction();
	}

	@Override
	protected IContextDeleteAction createContextDeleteAction() {
		return new CDOContextDeleteAction();
	}

}
