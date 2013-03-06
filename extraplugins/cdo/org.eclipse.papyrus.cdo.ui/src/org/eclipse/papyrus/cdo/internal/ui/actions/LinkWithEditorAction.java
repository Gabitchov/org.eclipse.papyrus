/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.views.ModelRepositoriesView;
import org.eclipse.ui.IPropertyListener;

/**
 * This is the AddRepositoryAction type. Enjoy.
 */
public class LinkWithEditorAction
		extends Action {

	private ModelRepositoriesView part;

	public LinkWithEditorAction(ModelRepositoriesView part) {
		super("Link with Editor", IAction.AS_CHECK_BOX);

		this.part = part;
		part.addPropertyListener(new IPropertyListener() {

			public void propertyChanged(Object source, int propId) {
				switch (propId) {
					case ModelRepositoriesView.LINK_WITH_EDITOR_PROPERTY :
						updateToggleState();
						break;
				}
			}
		});

		setImageDescriptor(Activator.getIcon(Activator.ICON_LINK_WITH_EDITOR));
		
		setChecked(part.isLinkWithEditor());
	}

	@Override
	public void run() {
		part.setLinkWithEditor(!part.isLinkWithEditor());
	}

	void updateToggleState() {
		setChecked(part.isLinkWithEditor());
	}
}
