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
package org.eclipse.papyrus.diagram.common.commands;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.ids.MOSKittModelIDs;
import org.eclipse.papyrus.diagram.common.providers.IDiagramInitializer;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;


// TODO: Auto-generated Javadoc
/**
 * The Class OpenAsDiagramCommand.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class OpenAsDiagramCommand extends AbstractTransactionalCommand {

	// private View nodeView = null;
	/** The resource. */
	private Resource resource = null;

	/** The element. */
	private EObject element = null;

	/** The diagram kind. */
	private String diagramKind = "";

	/** The new diagram. */
	private Diagram newDiagram = null;

	/** The initializers. */
	private Map<String, IDiagramInitializer> initializers = null;

	/** The ask name. */
	private boolean askName = true;

	/** The possible name. */
	private String possibleName = "";

	/**
	 * The previous dagram. If an undo is done, this Diagram will be opened if this command closed it.
	 */
	private Diagram previousDiagram = null;

	/**
	 * Flag to close the old diagram we come from.
	 */
	private boolean openInNew = true;

	/**
	 * Instantiates a new open as uml diagram command.
	 * 
	 * @param resource
	 *            the resource
	 * @param element
	 *            the element
	 * @param diagramKind
	 *            the diagram kind
	 */
	public OpenAsDiagramCommand(Resource resource, EObject element, String diagramKind) {
		this(resource, element, diagramKind, "", null, false);
	}

	/**
	 * 
	 * @param resource
	 * @param element
	 * @param diagramKind
	 * @param closeOld
	 */
	public OpenAsDiagramCommand(Resource resource, EObject element, String diagramKind, boolean openInNew) {
		this(resource, element, diagramKind, "", null, openInNew);
	}

	/**
	 * Instantiates a new open as uml diagram command.
	 * 
	 * @param resource
	 *            the resource
	 * @param element
	 *            the element
	 * @param diagramKind
	 *            the diagram kind
	 * @param name
	 *            the name
	 */
	public OpenAsDiagramCommand(Resource resource, EObject element, String diagramKind, String name) {
		this(resource, element, diagramKind, name, null, false);
	}

	/**
	 * 
	 * @param resource
	 * @param element
	 * @param diagramKind
	 * @param name
	 * @param closeOld
	 */
	public OpenAsDiagramCommand(Resource resource, EObject element, String diagramKind, String name, boolean openInNew) {
		this(resource, element, diagramKind, name, null, openInNew);
	}

	/**
	 * Instantiates a new open as uml diagram command.
	 * 
	 * @param resource
	 *            the resource
	 * @param element
	 *            the element
	 * @param diagramKind
	 *            the diagram kind
	 * @param initializer
	 *            the initializer
	 */
	public OpenAsDiagramCommand(Resource resource, EObject element, String diagramKind, IDiagramInitializer initializer) {
		this(resource, element, diagramKind, "", singleTonMap(diagramKind, initializer), false);
	}

	/**
	 * Instantiates a new open as uml diagram command.
	 * 
	 * @param resource
	 *            the resource
	 * @param element
	 *            the element
	 * @param diagramKind
	 *            the diagram kind
	 * @param initializers
	 *            the initializers
	 */
	public OpenAsDiagramCommand(Resource resource, EObject element, String diagramKind, Map<String, IDiagramInitializer> initializers) {
		this(resource, element, diagramKind, "", initializers, false);
	}

	/**
	 * Instantiates a new open as uml diagram command.
	 * 
	 * @param resource
	 *            the resource
	 * @param element
	 *            the element
	 * @param diagramKind
	 *            the diagram kind
	 * @param name
	 *            the diagram name
	 * @param initializer
	 *            the initializer
	 */
	public OpenAsDiagramCommand(Resource resource, EObject element, String diagramKind, String name, IDiagramInitializer initializer) {
		this(resource, element, diagramKind, name, singleTonMap(diagramKind, initializer), false);
	}

	/**
	 * Instantiates a new open as uml diagram command.
	 * 
	 * @param resource
	 *            the resource
	 * @param element
	 *            the element
	 * @param diagramKind
	 *            the diagram kind
	 * @param name
	 *            diagram's name
	 * @param initializers
	 *            the initializers
	 * @param closeOld
	 *            close old diagram
	 */
	public OpenAsDiagramCommand(Resource resource, EObject element, String diagramKind, String name, Map<String, IDiagramInitializer> initializers, boolean openInNew) {
		// editing domain is taken for original diagram,
		// if we open diagram from another file, we should use another editing
		// domain
		super(TransactionUtil.getEditingDomain(element), "Open Diagram", null);
		this.resource = resource;
		this.element = element;
		this.diagramKind = diagramKind;
		this.possibleName = name;
		this.initializers = initializers;
		this.openInNew = openInNew;
	}

	protected static Map<String, IDiagramInitializer> singleTonMap(String kind, IDiagramInitializer initializer) {
		if (kind != null) {
			return Collections.singletonMap(kind, initializer);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute() && (resource != null) && (element != null) && (MOSKittModelIDs.getAllExtensionModelIDs().contains(getDiagramKind()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.emf.commands.core.command. AbstractTransactionalCommand #doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			boolean createdDiagram = false;
			Diagram diagram = getDiagramToOpen();
			if (diagram == null) {
				if (possibleName != "") {
					diagram = MultiDiagramUtil.intializeNewDiagram(getDiagramKind(), element, resource, initializers, askName, possibleName);
				} else {
					diagram = MultiDiagramUtil.intializeNewDiagram(getDiagramKind(), element, resource, initializers, askName);
				}
				if (diagram == null) {
					return CommandResult.newCancelledCommandResult();
				} else {
					createdDiagram = true;
				}
			}
			newDiagram = diagram;
			previousDiagram = MDTUtil.getDiagramFomEditor(MDTUtil.getActiveEditor());
			MultiDiagramUtil.openDiagram(diagram, isOpenInNew() || createdDiagram);
			return CommandResult.newOKCommandResult();
		} catch (Exception ex) {
			throw new ExecutionException("Can't open diagram", ex);
		}
	}

	/**
	 * Gets the diagram to open.
	 * 
	 * @return the diagram to open
	 */
	protected Diagram getDiagramToOpen() {
		return null;
	}

	/**
	 * Gets the diagram domain element.
	 * 
	 * @return the diagram domain element
	 */
	protected EObject getDiagramDomainElement() {
		// use same element as associated with EP
		return element;
	}

	/**
	 * Gets the diagram kind.
	 * 
	 * @return the diagram kind
	 * 
	 * @throws ExecutionException
	 *             the execution exception
	 */
	protected String getDiagramKind() {
		return diagramKind;
	}

	/**
	 * 
	 * @return
	 */
	public Diagram getPreviousDiagram() {
		return previousDiagram;
	}

	/**
	 * Gets the adapter.
	 * 
	 * @param class_
	 *            the class_
	 * 
	 * @return the adapter
	 */
	public Object getAdapter(Class<Object> class_) {
		if (class_.equals(Diagram.class)) {
			return newDiagram;
		}
		return null;
	}

	/**
	 * Sets the ask name.
	 * 
	 * @param askName
	 *            the new ask name
	 */
	public void setAskName(boolean askName) {
		this.askName = askName;
	}

	public boolean isOpenInNew() {
		return openInNew;
	}

	@Override
	public boolean canUndo() {
		return false;
	}

}
