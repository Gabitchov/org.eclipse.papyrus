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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.commands.CreateHyperLinkPageCommand;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorHyperLinkEditorShell;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;

/**
 * 
 * The helper for editors
 * 
 */
public class EditorHyperLinkHelper extends AbstractHyperLinkHelper {


	@Override
	public String getNameofManagedHyperLink() {
		return Messages.EditorHyperLinkHelper_Editor;
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
		IPageIconsRegistry editorRegistry;
		try {
			editorRegistry = ServiceUtilsForEObject.getInstance().getService(IPageIconsRegistry.class, aModel);
		} catch (ServiceException e) {
			Activator.log.error(e);
			return;
		}
		EditorHyperLinkEditorShell editor = new EditorHyperLinkEditorShell(editorRegistry, aModel);
		editor.open();
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
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject hyperLinkObject) {
		if(hyperLinkObject instanceof HyperLinkEditor) {
			HyperLinkEditor hyperLinkEditor = (HyperLinkEditor)hyperLinkObject;
			return new CreateHyperLinkPageCommand(domain, object, hyperLinkEditor.getTooltipText(), HyperLinkConstants.PAPYRUS_HYPERLINK_PAGE, (EObject)hyperLinkEditor.getObject(), hyperLinkObject.getIsDefault());
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
		HyperLinkEditor hyperLinkEditor = new HyperLinkEditor();
		hyperLinkEditor.setObject(editor);
		return hyperLinkEditor;
	}

	/**
	 * 
	 * @param eAnnotation
	 *        an eAnnotation
	 * @return
	 *         the HyperLinkEditor corresponding to this eAnnotation
	 */
	public HyperLinkEditor getHyperLinkObjectFor(final EAnnotation eAnnotation) {
		for(String source : HyperLinkConstants.validHyperLinkPageSources) {
			if(source.equals(eAnnotation.getSource())) {
				HyperLinkEditor editor = new HyperLinkEditor();
				editor.setObject(eAnnotation.getReferences().get(0));
				editor.setIsDefault(Boolean.parseBoolean(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION)));
				editor.setTooltipText(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT));
				return editor;
			}
		}

		return null;
	}

}
