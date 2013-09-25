/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - support dropping other kinds of objects to create hyperlinks
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.dnd;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.SemanticElementHelper;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.helper.IHyperlinkHelperExtension;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkHelpersRegistrationUtil;
import org.eclipse.swt.graphics.Image;

/**
 * A Strategy to create hyperlinks to elements for which we know how to create them.
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
			List<org.eclipse.emf.common.command.Command> hyperlinkCommands = null;

			final ServicesRegistry registry;
			try {
				registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(mainView);

				Collection<AbstractHyperLinkHelper> helpers = HyperLinkHelpersRegistrationUtil.INSTANCE.getAllRegisteredHyperLinkHelper();

				TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
				for(Object droppedObject : dropRequest.getObjects()) {
					for(AbstractHyperLinkHelper next : helpers) {
						if(next instanceof IHyperlinkHelperExtension) {
							IHyperlinkHelperExtension helper = (IHyperlinkHelperExtension)next;
							org.eclipse.emf.common.command.Command command = helper.getCreateHyperlinkCommand(domain, mainView, droppedObject);
							if(command != null) {
								// we have something to do. Yay!
								if(hyperlinkCommands == null) {
									hyperlinkCommands = new java.util.ArrayList<org.eclipse.emf.common.command.Command>();
								}
								hyperlinkCommands.add(command);
								break; // don't look for another helper for this object
							}
						}
					}
				}
			} catch (ServiceException ex) {
				Activator.log.error(ex);
			}

			if(hyperlinkCommands != null) {
				final List<org.eclipse.emf.common.command.Command> _hyperlinkCommands = hyperlinkCommands;
				return new Command() {

					@Override
					public void execute() {
						for(org.eclipse.emf.common.command.Command next : _hyperlinkCommands) {
							next.execute();
						}
					}
				};
			}
		}

		return null;
	}
}
