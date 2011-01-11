/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.core.adaptor.gmf.DiagramsUtil;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigationHelper;
import org.eclipse.papyrus.diagram.common.dialogs.NavigationCreateDiagramDialog;
import org.eclipse.papyrus.diagram.common.dialogs.NavigationOpenDiagramDialog;
import org.eclipse.papyrus.diagram.common.providers.NavigationDecorator;
import org.eclipse.swt.widgets.Display;

/**
 * This class is used to open a new diagram when the double click is detected. It is dependent of
 * papyrus environment
 */
public class NavigationEditPolicy extends DecorationEditPolicy {
	
	public static final String NAVIGATION_POLICY = "navigationEditPolicy";
	
	public NavigationEditPolicy() {
		setDecorators(Collections.singletonMap(NAVIGATION_POLICY, new NavigationDecorator(new DecoratorTarget())));
	}

	protected Command getOpenCommand(Request request) {
		IGraphicalEditPart gep = (IGraphicalEditPart)getHost();

		List<NavigableElement> navElements = NavigationHelper.getInstance().getAllNavigableElements(gep.resolveSemanticElement());

		HashMap<NavigableElement, List<Diagram>> existingDiagrams = new HashMap<NavigableElement, List<Diagram>>();
		HashMap<NavigableElement, List<CreationCommandDescriptor>> possibleCreations = new HashMap<NavigableElement, List<CreationCommandDescriptor>>();

		for(NavigableElement navElement : navElements) {
			final EObject element = navElement.getElement();
			if(navElement instanceof ExistingNavigableElement) {
				List<Diagram> associatedDiagrams = DiagramsUtil.getAssociatedDiagrams(element, null);

				// ignore the current diagram
				associatedDiagrams.remove(gep.getNotationView().getDiagram());
				if(associatedDiagrams != null && !associatedDiagrams.isEmpty()) {
					existingDiagrams.put(navElement, associatedDiagrams);
				}
			}

			List<CreationCommandDescriptor> possibleCommandDescs = new LinkedList<CreationCommandDescriptor>();
			for(final CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				if(desc.getCondition() == null || desc.getCondition().create(element)) {
					possibleCommandDescs.add(desc);
				}
			}
			if(!possibleCommandDescs.isEmpty()) {
				possibleCreations.put(navElement, possibleCommandDescs);
			}
		}

		if(!existingDiagrams.isEmpty()) {
			NavigationOpenDiagramDialog dialog = new NavigationOpenDiagramDialog(Display.getCurrent().getActiveShell(), existingDiagrams);
			int result = dialog.open();
			if(result == Window.OK) {
				return new ICommandProxy(dialog.getCommand());
			}
		} else {
			NavigationCreateDiagramDialog dialog = new NavigationCreateDiagramDialog(Display.getCurrent().getActiveShell(), possibleCreations);
			int result = dialog.open();
			if(result == Window.OK) {
				return new ICommandProxy(dialog.getCommand());
			}
		}

		return UnexecutableCommand.INSTANCE;
	}

    public Command getCommand(Request request) {
        if (RequestConstants.REQ_OPEN.equals(request.getType()))
            return getOpenCommand(request);
        return super.getCommand(request);
    }

    public boolean understandsRequest(Request request) {
        if (RequestConstants.REQ_OPEN.equals(request.getType()))
            return true;
        return super.understandsRequest(request);
    }

    public EditPart getTargetEditPart(Request request) {

        if (understandsRequest(request))
            return getHost();

        return null;
    }

	private static ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
	}

}
