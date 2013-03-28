/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.dnd;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.SemanticElementHelper;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.infra.hyperlink.commands.CreateHyperLinkPageCommand;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;

/**
 * A Strategy to drop shortcuts to nested editors on GMF Diagram elements
 * 
 * @author Camille Letavernier
 * 
 */
public class HyperlinkDropStrategy extends TransactionalDropStrategy {

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return "Create hyperlinks";
	}

	public String getDescription() {
		return "Creates an hyperlink to Papyrus nested editor (e.g. Diagram, Table, ...) on a Diagram element";
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return "org.eclipse.papyrus.infra.gmfdiag.dnd.CreateHyperlink";
	}

	@Deprecated
	public int getPriority() {
		return 0;
	}

	@Override
	public Command doGetCommand(Request request, final EditPart targetEditPart) {
		if(request instanceof DropObjectsRequest) {

			View view = getTargetView(targetEditPart);
			if(view == null) {
				return null;
			}

			final View mainView = SemanticElementHelper.findPrimaryView(view);
			if(mainView instanceof Diagram) {
				//We cannot create hyperlinks from the root edit part
				return null;
			}

			final DropObjectsRequest dropRequest = (DropObjectsRequest)request;

			final ServicesRegistry registry;
			try {
				registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(mainView);
				IPageManager pageManager = ServiceUtils.getInstance().getIPageManager(registry);

				for(Object droppedObject : dropRequest.getObjects()) {
					if(!(droppedObject instanceof EObject && pageManager.allPages().contains(droppedObject))) {
						return null;
					}
				}
			} catch (ServiceException ex) {
				Activator.log.error(ex);
				return null;
			}

			return new Command() {

				@Override
				public void execute() {

					try {
						ILabelProvider labelProvider = registry.getService(LabelProviderService.class).getLabelProvider();
						TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);

						for(Object droppedObject : dropRequest.getObjects()) {
							String text = labelProvider.getText(droppedObject);
							CreateHyperLinkPageCommand command = new CreateHyperLinkPageCommand(domain, mainView, text, text, (EObject)droppedObject, true);
							command.execute();
						}
					} catch (ServiceException ex) {
						Activator.log.error(ex);
					}


				}
			};
		}

		return null;
	}
}
