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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.papyrus.compare.ui.viewer.content.part.UMLModelContentMergeTabFolder;
import org.eclipse.swt.widgets.Composite;


public class UMLModelContentMergeViewer extends ModelContentMergeViewer {

	private Action myShowAllProperties;

	public UMLModelContentMergeViewer(Composite parent, CompareConfiguration config) {
		super(parent, config);
	}

	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(Composite composite, int side) {
		return new UMLModelContentMergeTabFolder(this, composite, side);
	}

	@Override
	protected void createToolItems(ToolBarManager tbm) {
		super.createToolItems(tbm);
		tbm.add(new Separator("viewer")); //$NON-NLS-1$
		myShowAllProperties = new Action("Show All Properties", IAction.AS_CHECK_BOX) {

			@Override
			public void run() {
				showAllProperties();
			}
		};
		myShowAllProperties.setToolTipText("Show All Properties of the Element");
		//			setImageDescriptor(ImageDescriptor.createFromImage(descriptor.getEnabledImage()));
		//			setHoverImageDescriptor(ImageDescriptor.createFromImage(descriptor.getEnabledImage()));
		//			setDisabledImageDescriptor(ImageDescriptor.createFromImage(descriptor.getDisabledImage()));

		final ActionContributionItem showAllPropertiesContribution = new ActionContributionItem(myShowAllProperties);
		showAllPropertiesContribution.setVisible(true);
		tbm.appendToGroup("viewer", showAllPropertiesContribution); //$NON-NLS-1$
	}

	protected void showAllProperties() {
		//		if(currentSelection != null) {
		//			copy(currentSelection, true);
		//		}
		//		currentSelection.clear();
		//		switchCopyState(false);
	}

}
