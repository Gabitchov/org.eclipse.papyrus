/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.generation.wizard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.properties.generation.layout.ILayoutGenerator;
import org.eclipse.papyrus.properties.generation.messages.Messages;
import org.eclipse.papyrus.properties.generation.wizard.widget.FileChooser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

/**
 * A WizardPage to display the selected generator's options, as well as the context's
 * target file. The options depend on the selected generator.
 * 
 * @author Camille Letavernier
 */
public class GeneratorPage extends AbstractCreateContextPage implements Listener {

	private IGenerator generator;

	private Composite root, generatorControl;

	private FileChooser targetFileChooser;

	/**
	 * Constructor.
	 */
	public GeneratorPage() {
		super(Messages.GeneratorPage_title);
	}

	/**
	 * Sets the IGenerator for this wizard, and displays its controls in the
	 * page.
	 * 
	 * @param generator
	 */
	public void setGenerator(IGenerator generator) {
		cleanGeneratorControl();
		generator.addListener(this);

		setDescription(generator.getDescription());
		this.generator = generator;
		generator.createControls(generatorControl);
		generatorControl.layout();
		root.layout();
	}

	@Override
	public boolean isPageComplete() {
		return targetFileChooser.getFilePath() != null && (generator != null && generator.isReady());
	}

	private void cleanGeneratorControl() {
		for(Control control : generatorControl.getChildren()) {
			control.dispose();
		}
	}

	public void createControl(Composite parent) {
		root = new Composite(parent, SWT.NONE);
		root.setLayout(new GridLayout(2, false));
		root.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		generatorControl = new Composite(root, SWT.NONE);
		generatorControl.setLayout(new FillLayout());
		generatorControl.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));


		Label layoutGeneratorLabel = new Label(root, SWT.NONE);
		layoutGeneratorLabel.setText(Messages.GeneratorPage_layoutGenerator);
		GridData data = new GridData();
		data.widthHint = 100;
		layoutGeneratorLabel.setLayoutData(data);

		CCombo layoutGeneratorCombo = new CCombo(root, SWT.BORDER);
		layoutGeneratorCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		layoutGeneratorCombo.setEditable(false);
		layoutGeneratorCombo.setBackground(new Color(layoutGeneratorCombo.getDisplay(), 255, 255, 255));
		for(ILayoutGenerator layoutGenerator : CreateContextWizard.layoutGenerators) {
			layoutGeneratorCombo.add(layoutGenerator.getName());
		}
		layoutGeneratorCombo.select(0);

		Label targetLabel = new Label(root, SWT.NONE);
		targetLabel.setText(Messages.GeneratorPage_target);
		data = new GridData();
		data.widthHint = 100;
		targetLabel.setLayoutData(data);

		targetFileChooser = new FileChooser(root, true);
		targetFileChooser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		targetFileChooser.addListener(this);

		setControl(root);
	}

	public void handleEvent(Event event) {
		String filePath = targetFileChooser.getFilePath();
		if(filePath != null) {
			getWizard().selectFieldsPage.setTargetURI(URI.createPlatformResourceURI(targetFileChooser.getFilePath(), true));
		}
		super.getContainer().updateButtons();
	}

}
