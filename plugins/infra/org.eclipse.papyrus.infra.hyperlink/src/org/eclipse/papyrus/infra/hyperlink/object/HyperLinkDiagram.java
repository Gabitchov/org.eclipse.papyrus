/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.object;

import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.OpenDiagramCommand;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.uml2.uml.Package;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * The Class HyperLinkDiagram a container of diagram
 */
public class HyperLinkDiagram extends HyperLinkObject { //TODO : extends AbstractHyperLinkEditor?

	/**
	 * Gets the diagram.
	 * 
	 * @return the diagram
	 */
	public Diagram getDiagram() {
		// TODO Auto-generated method stub
		return (Diagram)super.getObject();
	}

	/**
	 * Sets the diagram.
	 * 
	 * @param object
	 *        the new diagram
	 */
	public void setDiagram(Diagram object) {
		super.setObject(object);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject#executeSelectPressed()
	 *
	 */
	@Override
	public void executeSelectPressed() {
		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
		IPageMngr pageMngr=null;
		try {
			OpenDiagramCommand openCommand = new OpenDiagramCommand(ServiceUtils.getInstance().getTransactionalEditingDomain(papyrusEditor.getServicesRegistry()), getDiagram());
			if(openCommand.canExecute()) {
				openCommand.execute(null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public void executeEditMousePressed(List<HyperLinkObject> list, Package amodel) {
		IPageIconsRegistry editorRegistry=null;
		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry= papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EditorHyperlinkDiagramShell editor = new EditorHyperlinkDiagramShell(editorRegistry, amodel);
		editor.setHyperLinkDiagram(this);
		editor.open();
		if(editor.getHyperLinkDiagram() != null) {
			int index = list.indexOf(this);
			list.remove(this);
			list.add(index,editor.getHyperLinkDiagram());

		}
	}
}
