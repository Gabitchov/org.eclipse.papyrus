/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.command;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLViewProvider;

/**
 * this is the specific command in charge to transform an element editpart into a defaultShape
 * 
 */
public class RectangleToLollipopCommand extends AbstractTransactionalCommand {
	private static View node;
	protected GraphicalEditPart elementEditPart;
	private SemanticAdapter semanticApdater;

	/**
	 * 
	 * Constructor of this command
	 * 
	 * @param domain
	 *            the transactional editing domain to execute transaction
	 * @param classView
	 *            the editpart that will be transformed
	 * @param semanticAdapter
	 *            the wrapper that store the value of the result
	 */
	public RectangleToLollipopCommand(TransactionalEditingDomain domain, GraphicalEditPart classView, SemanticAdapter semanticAdapter) {
		super(domain, "change to Lollipop", Collections.EMPTY_LIST);
		this.elementEditPart = classView;
		this.semanticApdater = semanticAdapter;
		setResult(CommandResult.newOKCommandResult(semanticAdapter));
	}

	/**
	 * 
	 * @param elementID
	 * @return return the element type from the id
	 */
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * 
	 * @param containerView
	 * @param domainElement
	 * @return get the visual id from the domain element
	 */
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// creation of the node
		UMLViewProvider umlViewProvider = new UMLViewProvider();
		View container = (View) elementEditPart.getNotationView().eContainer();
		Node interfaceView = umlViewProvider.createInterface_2003(elementEditPart.resolveSemanticElement(), container, -1, true, elementEditPart.getDiagramPreferencesHint());
		interfaceView.setLayoutConstraint(((Node) elementEditPart.getNotationView()).getLayoutConstraint());
		if (interfaceView.getLayoutConstraint() instanceof Bounds) {
			((Bounds) interfaceView.getLayoutConstraint()).setWidth(20);
			((Bounds) interfaceView.getLayoutConstraint()).setHeight(20);
		}
		node = interfaceView;
		// copy of all eannotations
		Iterator<EAnnotation> iter = elementEditPart.getNotationView().getEAnnotations().iterator();
		while (iter.hasNext()) {
			EAnnotation annotation = EcoreUtil.copy(iter.next());
			interfaceView.getEAnnotations().add(annotation);
		}
		semanticApdater.setView(node);
		return CommandResult.newOKCommandResult(semanticApdater);
	}
}
