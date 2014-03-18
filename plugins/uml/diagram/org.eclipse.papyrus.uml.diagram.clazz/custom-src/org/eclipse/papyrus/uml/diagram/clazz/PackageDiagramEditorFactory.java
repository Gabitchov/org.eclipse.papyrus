/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Factory for legacy package diagrams tht migrates them to the viewpoints-defined ones
 * 
 * @author Laurent Wouters
 * 
 */
public class PackageDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * Initializes this factory
	 */
	public PackageDiagramEditorFactory() {
		super(UmlClassDiagramForMultiEditor.class, "Package");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory#createIPageModel(java.lang.Object)
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {
		migrate((Diagram) pageIdentifier);
		return super.createIPageModel(pageIdentifier);
	}

	/**
	 * Migrate the given package diagram to the viewpoints-defined one
	 * 
	 * @param diagram
	 *            The diagram to migrate
	 */
	private void migrate(final Diagram diagram) {
		TransactionalEditingDomain domain = null;
		try {
			domain = ServiceUtilsForResourceSet.getInstance().getTransactionalEditingDomain(diagram.eResource().getResourceSet());
		} catch (ServiceException e) {
			return;
		}
		domain.getCommandStack().execute(new AbstractCommand() {
			@Override
			public void execute() {
				ViewPrototype proto = DiagramUtils.getPrototype(diagram);
				DiagramUtils.setPrototype(diagram, proto);
				diagram.setType("PapyrusUMLClassDiagram");
			}
			@Override
			public void redo() {
				execute();
			}

			@Override
			public boolean canExecute() {
				return true;
			}
		});
	}
}
