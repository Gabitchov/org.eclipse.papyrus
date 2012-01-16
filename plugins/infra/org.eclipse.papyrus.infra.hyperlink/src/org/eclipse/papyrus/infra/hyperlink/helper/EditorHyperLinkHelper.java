/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorHyperLinkEditorShell;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkEditorHelpersRegistrationUtil;

/**
 * 
 * The helper for editors
 * 
 */
public class EditorHyperLinkHelper extends AbstractHyperLinkHelper {


	@Override
	public String getNameofManagedHyperLink() {
		return "Editor";
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper#executeNewMousePressed(java.util.List, org.eclipse.emf.ecore.EObject)
	 * 
	 * @param list
	 * @param aModel
	 */
	@Override
	public void executeNewMousePressed(final List<HyperLinkObject> list, final EObject aModel) {
		IPageIconsRegistry editorRegistry = null;
		IMultiDiagramEditor papyrusEditor = EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry = papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		EditorHyperLinkEditorShell editor = new EditorHyperLinkEditorShell(editorRegistry, aModel);
		editor.open();//TODO and the cancel?
		if(editor.getHyperLinkEditor() != null) {
			list.add(editor.getHyperLinkEditor());
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper#getFilteredObject(java.util.List)
	 * 
	 * @param hyperLinkObjects
	 * @return
	 */
	@Override
	public List<HyperLinkObject> getFilteredObject(final List<HyperLinkObject> hyperLinkObjects) {
		ArrayList<HyperLinkObject> result = new ArrayList<HyperLinkObject>();
		Iterator<HyperLinkObject> iterator = hyperLinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperLinkObject current = iterator.next();
			if(current instanceof HyperLinkEditor) {
				result.add(current);
			}
		}
		return result;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper#getHyperLinkObject(org.eclipse.emf.ecore.EAnnotation)
	 * 
	 * @param eAnnotation
	 * @return
	 */
	@Override
	public HyperLinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		return getHyperLinkObjectFor(eAnnotation);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper#getAddHyperLinkCommand(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.ecore.EModelElement, org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject)
	 * 
	 * @param domain
	 * @param object
	 * @param HyperLinkObject
	 * @return
	 */
	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject HyperLinkObject) {
		Collection<AbstractHyperLinkEditorHelper> helpers = HyperLinkEditorHelpersRegistrationUtil.INSTANCE.getAllRegisteredHyperLinkEditorHelper();
		for(AbstractHyperLinkEditorHelper current : helpers) {
			RecordingCommand cmd = current.getAddHyperLinkCommand(domain, object, HyperLinkObject);
			if(cmd != null) {
				return cmd;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the HyperLinkEditor corresponding to this object
	 * 
	 */
	public HyperLinkEditor getHyperLinkObjectFor(final Object editor) {// create an interface for this method?
		Collection<AbstractHyperLinkEditorHelper> helpers = HyperLinkEditorHelpersRegistrationUtil.INSTANCE.getAllRegisteredHyperLinkEditorHelper();
		for(AbstractHyperLinkEditorHelper current : helpers) {
			HyperLinkEditor object = current.getHyperLinkObjectFor(editor);
			if(object != null) {
				return object;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param eAnnotation
	 *        an eAnnotation
	 * @return
	 *         the HyperLinkEditor corresponding to this eAnnotation
	 */
	public HyperLinkEditor getHyperLinkObjectFor(final EAnnotation eAnnotation) {
		Collection<AbstractHyperLinkEditorHelper> helpers = HyperLinkEditorHelpersRegistrationUtil.INSTANCE.getAllRegisteredHyperLinkEditorHelper();
		for(AbstractHyperLinkEditorHelper current : helpers) {
			HyperLinkEditor object = current.getHyperLinkObjectForEAnnotation(eAnnotation);
			if(object != null) {
				return object;
			}
		}
		return null;
	}
}
