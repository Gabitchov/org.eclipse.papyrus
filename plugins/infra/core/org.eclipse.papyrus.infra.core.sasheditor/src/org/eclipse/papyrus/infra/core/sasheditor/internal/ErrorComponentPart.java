/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 392301
 *   
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IComponentModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * A PagePart which can be used to fill a tab when an error occurs
 * Avoid manipulating "null" instances, which may lead to widget crashes
 * 
 * @author Camille Letavernier
 * 
 */
public class ErrorComponentPart extends ComponentPart {

	public ErrorComponentPart(TabFolderPart parent) {
		super(parent, createErrorComponentPartModel(), null);
		createPartControl(parent.getControl());
	}

	private static IComponentModel createErrorComponentPartModel() {
		IComponentModel componentModel = new IComponentModel() {

			public void dispose() {
				// Pass. The tab icon is a workbench-shared icon
			}
			
			public String getTabTitle() {
				return "Invalid tab";
			}

			public Image getTabIcon() {
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
			}

			public Image getComponentIcon() {
				return Display.getDefault().getSystemImage(SWT.ICON_ERROR);
			}

			public Object getRawModel() {
				return null;
			}

			public Composite createPartControl(Composite parent) {
				Composite tabComposite = new Composite(parent, SWT.NONE);
				tabComposite.setLayout(new GridLayout(2, false));

				Image componentIcon = getComponentIcon();
				if(componentIcon != null) {
					Label errorImageLabel = new Label(tabComposite, SWT.NONE);
					errorImageLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
					errorImageLabel.setImage(componentIcon);
				}

				Label label = new Label(tabComposite, SWT.NONE);
				label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				label.setText("Invalid tab");

				return tabComposite;
			}
		};

		return componentModel;
	}

}
