/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Comment;

/**
 * Section with advanced editor for the {@link Comment} in Papyrus
 */
public class CommentPropertySection extends AbstractPropertySection {

	/** advanced editor for the comments */
	protected CommentRichTextEditor richText;

	/** edited comment */
	protected Comment comment;

	/**
	 * Creates a new CommentPropertySection
	 */
	public CommentPropertySection() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		richText = CommentRichTextFormToolkit.createFocusAwareRichTextEditor(getWidgetFactory(), parent, "", comment, SWT.NONE, EditorUtils.getMultiDiagramEditor().getEditorSite());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if(!(selection instanceof IStructuredSelection) || !((part instanceof IEditingDomainProvider) || part.getAdapter(IEditingDomainProvider.class) != null)) {
			return;
		}

		Object firstElement = ((IStructuredSelection)selection).getFirstElement();
		EObject newEObject = resolveSemanticObject(firstElement);

		if(newEObject instanceof Comment) {
			setComment((Comment)newEObject);
			richText.init(comment, null);
			richText.setText(comment.getBody());
		}
	}

	/**
	 * Sets the comment to edit
	 * 
	 * @param comment
	 *        the comment to edit
	 */
	protected void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * Returns the comment to edit
	 * 
	 * @return the comment to edit
	 */
	protected Comment getComment() {
		return comment;
	}

	/**
	 * Resolve semantic element
	 * 
	 * @param object
	 *        the object to resolve
	 * @return <code>null</code> or the semantic element associated to the specified object
	 */
	private EObject resolveSemanticObject(Object object) {
		if(object instanceof EObject) {
			return (EObject)object;
		} else if(object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)object;
			if(adaptable.getAdapter(EObject.class) != null) {
				return (EObject)adaptable.getAdapter(EObject.class);
			}
		}
		return null;
	}
}
