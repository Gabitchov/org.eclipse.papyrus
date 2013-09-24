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
package org.eclipse.papyrus.cdo.internal.ui.hyperlink;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.cdo.internal.ui.dnd.CDOResourceURITransferData;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.SemanticElementHelper;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.swt.graphics.Image;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * A drop strategy that extracts URIs of CDO resources from an Ecore representation of a {@link CDOResourceURITransferData} to create hyperlinks.
 */
public class CDOResourceURIDropStrategy extends TransactionalDropStrategy {

	private static final String ID = Activator.PLUGIN_ID + ".cdoResourceURI"; //$NON-NLS-1$

	public CDOResourceURIDropStrategy() {
		super();
	}

	@Override
	public String getLabel() {
		return Messages.DropStrategy_label;
	}

	@Override
	public String getDescription() {
		return Messages.DropStrategy_desc;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public String getID() {
		return ID;
	}

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	protected Command doGetCommand(Request request, EditPart targetEditPart) {
		if(request instanceof DropObjectsRequest) {
			View view = getTargetView(targetEditPart);
			if(view == null) {
				return null;
			}

			final View mainView = SemanticElementHelper.findPrimaryView(view);
			if(mainView instanceof Diagram) {
				// don't create hyperlinks on the diagram surface
				return null;
			}

			final DropObjectsRequest dropRequest = (DropObjectsRequest)request;
			List<URI> hyperlinkURIs = null;

			for(EObject next : Iterables.filter(dropRequest.getObjects(), EObject.class)) {
				if(CDOResourceURITransferData.isCDOResourceURITransferData(next)) {
					if(hyperlinkURIs == null) {
						hyperlinkURIs = Lists.newArrayListWithCapacity(dropRequest.getObjects().size());
					}
					hyperlinkURIs.addAll(CDOResourceURITransferData.fromEObject(next).getURIs());
				}
			}

			if(hyperlinkURIs != null) {
				final TransactionalEditingDomain domain = getTransactionalEditingDomain(targetEditPart);

				final List<URI> _hyperlinkURIs = hyperlinkURIs;
				return new Command() {

					@Override
					public void execute() {
						for(URI next : _hyperlinkURIs) {
							new CreateCDOResourceHyperlinkCommand(domain, mainView, next.lastSegment(), next, false).execute();
						}
					}
				};
			}
		}

		return null;
	}

}
