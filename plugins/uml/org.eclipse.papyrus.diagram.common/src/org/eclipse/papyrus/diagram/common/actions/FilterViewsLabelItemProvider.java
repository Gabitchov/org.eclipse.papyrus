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
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPage;

// TODO: Auto-generated Javadoc
/**
 * The Class FilterViewsLabelItemProvider.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class FilterViewsLabelItemProvider extends AbstractContributionItemProvider {

	/** The Constant FILTER_VIEWS_AND_LABELS. */
	private static final String FILTER_VIEWS_AND_LABELS = "filter_views_and_labels";

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.common.ui.services.action.contributionitem.
	 * AbstractContributionItemProvider#createAction(java.lang.String,
	 * org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage page = partDescriptor.getPartPage();
		if(FILTER_VIEWS_AND_LABELS.equals(actionId)) {
			return new FilterViewsLabelsAction(page);
		}
		return super.createAction(actionId, partDescriptor);
	}

}
