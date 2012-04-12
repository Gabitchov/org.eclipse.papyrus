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
package org.eclipse.papyrus.uml.diagram.usecase.command;

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
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLViewProvider;
import org.eclipse.uml2.uml.Element;

/**
 * this is the specific command in charge to transform an element editpart into a defaultShape
 * 
 */
public class ChangetoDefaultShapeCommand extends AbstractTransactionalCommand {

	protected GraphicalEditPart elementEditPart;

	/**
	 * 
	 * Constructor of this command
	 * 
	 * @param domain
	 *        the transactional editing domain to execute transaction
	 * @param classView
	 *        the editpart that will be transformed
	 */
	public ChangetoDefaultShapeCommand(TransactionalEditingDomain domain, GraphicalEditPart classView) {
		super(domain, "ChangeToDefaultNamedElement", Collections.EMPTY_LIST);
		this.elementEditPart = classView;
	}

	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		//creation of the node
		Element semanticElement = (Element)elementEditPart.resolveSemanticElement();
		View containerView = (View)elementEditPart.getNotationView().eContainer();
		int visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, semanticElement);
		UMLViewProvider umlViewProvider = new UMLViewProvider();
		IAdaptable elementAdapter = new EObjectAdapter(semanticElement);
		String semanticHint = ((IHintedType)getUMLElementType(visualID)).getSemanticHint();
		Node node = umlViewProvider.createNode(elementAdapter, containerView, semanticHint, -1, true, elementEditPart.getDiagramPreferencesHint());
		node.setLayoutConstraint(((Node)elementEditPart.getNotationView()).getLayoutConstraint());
		//copy of all eannotations
		Iterator<EAnnotation> iter = elementEditPart.getNotationView().getEAnnotations().iterator();
		while(iter.hasNext()) {
			EAnnotation annotation = EcoreUtil.copy(iter.next());
			node.getEAnnotations().add(annotation);
		}
		return null;
	}
}
