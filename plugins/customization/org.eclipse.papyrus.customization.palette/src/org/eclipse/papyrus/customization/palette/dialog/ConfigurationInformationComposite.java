/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.palette.dialog;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationFactory;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Profile;


/**
 * Class in charge of the composite in the {@link LocalPaletteContentPage}
 */
public class ConfigurationInformationComposite {

	/** current selected entry proxy */
	protected Configuration selectedConfiguration;

	/** proxy name text */
	protected Text nameText;

	/** proxy description text */
	protected Text descriptionText;

	/** proxy icon text */
	protected Text iconText;

	/** referenced proxy text */
	protected Text referencedText;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/** button for icon selection */
	protected Button iconButton;

	/** protocol for platform plugin URLs */
	protected static final String PLUGIN_PROTOCOL = "platform:/plugin/"; //$NON-NLS-1$

	/**
	 * Creates the content of the information composite
	 * 
	 * @param parent
	 *        the composite where to add created controls
	 * @param appliedProfiles
	 *        the list of applied profiles
	 * @return the newly created composite
	 */
	public Composite createComposite(final Composite parent, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.widthHint = 260;
		data.horizontalIndent = 10;
		composite.setLayoutData(data);

		Label entryInformationLabel = new Label(composite, SWT.NONE);
		entryInformationLabel.setText(Messages.Local_Palette_Entry_Information);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.horizontalSpan = 3;
		entryInformationLabel.setLayoutData(data);

		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setText(Messages.Local_Palette_Entry_Name);
		data = new GridData(SWT.FILL, SWT.FILL, false, false);
		nameLabel.setLayoutData(data);
		nameText = new Text(composite, SWT.LEAD | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		nameText.setLayoutData(data);
		nameText.addFocusListener(new NameFocusListener());
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.horizontalSpan = 2;
		nameText.setLayoutData(data);

		Label referencedLabel = new Label(composite, SWT.NONE);
		referencedLabel.setText(Messages.Local_Palette_Entry_Reference);
		data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		referencedLabel.setLayoutData(data);
		referencedText = new Text(composite, SWT.LEAD | SWT.BORDER | SWT.READ_ONLY);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		referencedText.setLayoutData(data);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.horizontalSpan = 2;
		referencedText.setLayoutData(data);

		Label descriptionLabel = new Label(composite, SWT.NONE);
		descriptionLabel.setText(Messages.Local_Palette_Entry_Description);
		data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		descriptionLabel.setLayoutData(data);
		descriptionText = new Text(composite, SWT.WRAP | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = 2;
		data.widthHint = 160;
		descriptionText.setLayoutData(data);
		descriptionText.addFocusListener(new DescriptionFocusListener());


		Label iconLabel = new Label(composite, SWT.NONE);
		iconLabel.setText(Messages.Local_Palette_Entry_Icon);
		data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		iconLabel.setLayoutData(data);
		iconText = new Text(composite, SWT.LEAD | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		iconText.setLayoutData(data);
		iconText.addFocusListener(new IconFocusListener());
		iconButton = new Button(composite, SWT.NONE);
		iconButton.setText("Select...");
		iconButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				BundleIconExplorerDialog dialog = new BundleIconExplorerDialog(parent.getShell(), iconText.getText());
				if(Dialog.OK == dialog.open()) {
					Object[] values = dialog.getResult();
					if(values.length != 1) {
						Activator.log.error("Waiting one icon path, but found " + values.length, null);
					} else {
						iconText.setText(values[0].toString());

						String bundleId = dialog.getCurrentBundleName();
						String iconPath = dialog.getIconPath();
						updateIconInConfiguration(bundleId, iconPath);
					}
				}
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		return composite;
	}


	private void updateIconInConfiguration(String bundleId, String iconPath) {
		if(selectedConfiguration != null) {
			IconDescriptor descriptor = PaletteconfigurationFactory.eINSTANCE.createIconDescriptor();
			if(bundleId != null && iconPath != null) {
				descriptor.setPluginID(bundleId);
				descriptor.setIconPath(iconPath);
			}
			selectedConfiguration.setIcon(descriptor);
		}
	}

	/**
	 * Updates the name field in the information area
	 */
	protected void updateNameEntryField() {
		if(selectedConfiguration != null) {
			nameText.setText((selectedConfiguration.getLabel() != null) ? selectedConfiguration.getLabel() : "");
			nameText.setEnabled(true);
		} else {
			nameText.setText("");
			nameText.setEnabled(false);
		}

	}

	/**
	 * Updates the reference field in the information area
	 */
	protected void updateReferencedEntryField() {
		if(selectedConfiguration instanceof ToolConfiguration) {
			ToolConfiguration configuration = ((ToolConfiguration)selectedConfiguration);
		} else {
			referencedText.setText("");
			referencedText.setEnabled(false);
		}
	}

	/**
	 * Updates the description field in the information area
	 */
	protected void updateDescriptionEntryField() {
		if(selectedConfiguration != null) {
			descriptionText.setText((selectedConfiguration.getDescription() != null) ? selectedConfiguration.getDescription() : "");
			descriptionText.setEnabled(true);
		} else {
			descriptionText.setText("");
			descriptionText.setEnabled(false);
		}
	}

	/**
	 * Updates the icon field in the information area
	 */
	protected void updateIconEntryField() {
		if(selectedConfiguration != null) {
			IconDescriptor descriptor = selectedConfiguration.getIcon();
			if(descriptor != null) {
				String iconPath = descriptor.getIconPath();
				String bundleId = descriptor.getPluginID();
				if(iconPath != null && bundleId != null) {
					iconText.setText(PLUGIN_PROTOCOL + bundleId + iconPath);
				}
			}
			iconText.setEnabled(true);
		} else {
			iconText.setText("");
			iconText.setEnabled(true);
		}
	}

	/**
	 * Sets the new Selected entry
	 * 
	 * @param configuration
	 *        the selectedConfiguration to set
	 */
	public void setSelectedConfiguration(Configuration configuration) {
		this.selectedConfiguration = configuration;

		updateNameEntryField();
		updateIconEntryField();
		updateReferencedEntryField();
		updateDescriptionEntryField();
	}

	/**
	 * focus listener for the name text field
	 */
	protected class NameFocusListener implements FocusListener {

		/**
		 * @{inheritDoc
		 */
		public void focusGained(FocusEvent e) {
		}

		/**
		 * @{inheritDoc
		 */
		public void focusLost(FocusEvent e) {
			if(selectedConfiguration != null) {
				selectedConfiguration.setLabel(nameText.getText().trim());
			}
		}

	}

	/**
	 * focus listener for the name text field
	 */
	protected class DescriptionFocusListener implements FocusListener {

		/**
		 * @{inheritDoc
		 */
		public void focusGained(FocusEvent e) {
		}

		/**
		 * @{inheritDoc
		 */
		public void focusLost(FocusEvent e) {
			if(selectedConfiguration != null) {
				selectedConfiguration.setDescription(descriptionText.getText().trim());
			}
		}
	}

	/**
	 * focus listener for the name text field
	 */
	protected class IconFocusListener implements FocusListener {

		/**
		 * @{inheritDoc
		 */
		public void focusGained(FocusEvent e) {
		}

		/**
		 * @{inheritDoc
		 */
		public void focusLost(FocusEvent e) {
			String text = iconText.getText();
			if(selectedConfiguration != null && text != null && !text.equals("")) {

				// parse the text....
				if(!text.startsWith(PLUGIN_PROTOCOL)) {
					return;
				}

				text = text.substring(PLUGIN_PROTOCOL.length(), text.length());

				int i = text.indexOf("/");
				if(i < 1) {
					return;
				}
				String bundlePath = text.substring(0, i);
				String iconPath = text.substring(bundlePath.length(), text.length());

				updateIconInConfiguration(bundlePath, iconPath);
			}
		}
	}

}
