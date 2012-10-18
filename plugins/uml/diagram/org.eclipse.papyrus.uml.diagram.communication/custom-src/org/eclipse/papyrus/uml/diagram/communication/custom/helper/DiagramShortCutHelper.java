/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.helper;



import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.uml.diagram.communication.custom.commands.DiagramShortCutCreationViewCommand;
import org.eclipse.papyrus.uml.diagram.communication.providers.UMLElementTypes;



// TODO: Auto-generated Javadoc
/**
 * The Class DiagramShortCutHelper.
 */
public class DiagramShortCutHelper extends ElementHelper {

	/**
	 * Instantiates a new DiagramShortCut helper.
	 * 
	 * @param editDomain
	 *        the edit domain
	 */
	public DiagramShortCutHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	/**
	 * Drop DiagramShortCut.
	 * 
	 * @param diagram
	 *        the element to drop
	 * 
	 * @param viewer
	 *        the viewer
	 * @param diagramPreferencesHint
	 *        the diagram preferences hint
	 * @param location
	 *        the location of the drop
	 * @param containerView
	 *        the container view that will contain the associationClass views
	 * 
	 * @return the command
	 */
	public Command dropDiagramShortCut(Diagram diagram, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView) {
		CompositeCommand cc = new CompositeCommand("dropDiagramShortCut"); //$NON-NLS-1$



		//creation of the node DiagramShortCut

		IAdaptable elementAdapter = new EObjectAdapter(diagram);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)UMLElementTypes.Diagram_8016).getSemanticHint(), ViewUtil.APPEND, true, diagramPreferencesHint);
		DiagramShortCutCreationViewCommand nodeCreationCommand = new DiagramShortCutCreationViewCommand(getEditingDomain(), descriptor, ((View)containerView));
		cc.compose(nodeCreationCommand);

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "drop", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), location); //$NON-NLS-1$
		cc.compose(setBoundsCommand);


		return new ICommandProxy(cc);
	}

}
