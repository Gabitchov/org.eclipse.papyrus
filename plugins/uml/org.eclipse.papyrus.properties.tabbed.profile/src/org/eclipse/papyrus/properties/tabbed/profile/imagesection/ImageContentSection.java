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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.profile.imagesection;

import java.io.File;

import org.eclipse.papyrus.properties.tabbed.profile.AbstractViewSection;
import org.eclipse.papyrus.properties.tabbed.profile.Activator;
import org.eclipse.papyrus.umlutils.ImageUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Image;


/**
 * this class display section to display serialize in XML the image
 */
public class ImageContentSection extends AbstractViewSection {

	/**
	 * 
	 */
	private Button browseButton, removeButton;

	/**
	 * 
	 */
	private MouseListener browseButtonListener, removeButtonListener;

	/**
	 * 
	 */
	private String sectionLabel = "Content:";

	/**
	 * 
	 */
	private final org.eclipse.swt.graphics.Image remove_img = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,"icons/delete.gif").createImage();

	/**
	 * 
	 */
	private final org.eclipse.swt.graphics.Image add_img_32 =Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,"icons/Add_32x32.gif").createImage();

	/**
	 * 
	 * 
	 * @param tabbedPropertySheetPage
	 * @param parent
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		browseButton = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		browseButton.setImage(add_img_32);
		removeButton = getWidgetFactory().createButton(composite, "", SWT.PUSH);
		removeButton.setImage(remove_img);
		CLabel iconLabel = getWidgetFactory().createCLabel(composite, sectionLabel);

		// browseButton layout
		data = new FormData();
		data.left = new FormAttachment(0, 85);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		browseButton.setLayoutData(data);

		// removeButton layout
		data = new FormData();
		data.left = new FormAttachment(browseButton, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(browseButton, 0, SWT.CENTER);
		removeButton.setLayoutData(data);

		// iconLabel layout
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(browseButton, 0, SWT.CENTER);
		iconLabel.setLayoutData(data);

		browseButton.addMouseListener(browseButtonListener = new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
				FileDialog fd = new FileDialog(composite.getShell());
				String extensions[] = { "*.jpg;*.bmp;*.ico;*.gif;*.png;*.wmf;*.emf" };
				fd.setFilterExtensions(extensions);
				String iconSelected = fd.open();

				// No image selected
				if (iconSelected == null) {
					return;
				}

				if (getElement() instanceof Image) {

					File imgFile = new File(iconSelected);

					try {
						ImageUtil.setContent((Image) getElement(), imgFile);
						refresh();
					} catch (Exception ex) {
						System.err.println("Could not import image: "+ex);
					}
				}
			}
		});

		removeButton.addMouseListener(removeButtonListener = new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
				// Erase image content
				if (getElement() instanceof Image) {

					try {
						ImageUtil.setContent((Image) getElement(), null);
						refresh();
					} catch (Exception ex) {
						System.err.println("Could not import image: "+ex);
					}
				}
			}
		});
	}

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 *
	 */
	public void refresh() {
		if (!browseButton.isDisposed()) {

			/* initialization of buttons enabling */
			if (!(getElement() instanceof Image)) {
				return;
			}

			// Get Image content
			org.eclipse.swt.graphics.Image image = ImageUtil.getContent((Image) getElement());

			// Refresh text
			if (image != null) {
				// Resize icon to 32x32
				org.eclipse.swt.graphics.Image resizedIcon = new org.eclipse.swt.graphics.Image(image.getDevice(),
						image.getImageData().scaledTo(32, 32));
				browseButton.setImage(resizedIcon);
				removeButton.setEnabled(true);

			} else {
				browseButton.setImage(add_img_32);
				removeButton.setEnabled(false);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 *
	 */
	public void dispose() {
		super.dispose();
		if (browseButton != null && !browseButton.isDisposed())
			browseButton.removeMouseListener(browseButtonListener);
		if (removeButton != null && !removeButton.isDisposed())
			removeButton.removeMouseListener(removeButtonListener);
	}

}
