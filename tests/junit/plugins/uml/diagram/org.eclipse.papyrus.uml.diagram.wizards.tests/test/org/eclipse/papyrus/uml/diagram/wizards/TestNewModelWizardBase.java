/*****************************************************************************
 * Copyright (c) 2013, 2014 LIFL, CEA LIST, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  LIFL - Initial API and implementation
 *  CEA LIST - Update tests and re-integrate into automation suite
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

import junit.framework.TestCase;

import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectStorageProviderPage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.junit.After;
import org.junit.Before;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;


public abstract class TestNewModelWizardBase extends TestCase {

	protected static final IStructuredSelection EMPTY_SELECTION = StructuredSelection.EMPTY;

	protected SettingsHelper settings;
	
	protected abstract IWorkbenchWizard createWizard();

	private String settingsBackup;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		initSettingsHelper();
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		try {
			restoreDialogSettings();
		} finally {
			super.tearDown();
		}
	}

	protected IStructuredSelection getSelection() {
		return EMPTY_SELECTION;
	}

	protected IWorkbenchWizard initWizardDialog() {
		IWorkbenchWizard wizard = createWizard();
		initWizardDialog(wizard);
		return wizard;
	}

	protected IWorkbenchWizard initWizardDialog(final IWorkbenchWizard wizard) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				wizard.init(getWorkbench(), getSelection());
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				PixelConverter converter = new PixelConverter(JFaceResources.getDialogFont());
				dialog.setMinimumPageSize(converter.convertWidthInCharsToPixels(70), converter.convertHeightInCharsToPixels(20));
				dialog.create();
			}
		});

		return wizard;
	}

	protected Shell getShell() {
		return getWorkbench().getActiveWorkbenchWindow().getShell();
	}

	protected IWorkbench getWorkbench() {
		return Activator.getDefault().getWorkbench();
	}

	protected <P extends IWizardPage> P getPage(IWizard wizard, Class<P> pageType) {
		P result = Iterables.find(Iterables.filter(Arrays.asList(wizard.getPages()), pageType), Predicates.alwaysTrue(), null);
		assertNotNull("Did not find page of type " + pageType.getSimpleName(), result);
		return result;
	}
	
	protected void testOrderOfPages(IWorkbenchWizard wizard, Class<?>[] expectedPages) {
		Class<?> optionalInitialPage = SelectStorageProviderPage.class;
		 
		IWizardPage next = wizard.getPages()[0];
		for(int i = 0; i < expectedPages.length; i++) {
			String isNullMessageFormat = "page %s expected, but actual is: null";
			assertNotNull(String.format(isNullMessageFormat, i), next);

			if((optionalInitialPage != null) && (i == 0) && optionalInitialPage.isInstance(next)) {
				// we have tested the optional initial page; don't do it again
				optionalInitialPage = null;
				i--;
			} else {
				testPageInstanceOf(next, expectedPages[i], i);
			}
			
			next = next.getNextPage();
		}
		String noMorePagesExpectedMessageFormat = "page %s is not expected";
		assertNull(String.format(noMorePagesExpectedMessageFormat, next), next);

	}

	protected void testPageInstanceOf(IWizardPage next, Class<?> expectedClass, int index) {
		String wrongClassFormat = "page %s expected to be SelectRootElementPage, but actual is: %s";
		assertTrue(String.format(wrongClassFormat, index, next.getClass()), expectedClass.isInstance(next));
	}

	private void initSettingsHelper() {
		IDialogSettings workbenchSettings = Activator.getDefault().getDialogSettings();
		IDialogSettings settings = workbenchSettings.getSection(CreateModelWizard.NEW_MODEL_SETTINGS);
		if(settings == null) {
			settings = workbenchSettings.addNewSection(CreateModelWizard.NEW_MODEL_SETTINGS);
		}
		this.settings = new SettingsHelper(settings);

		StringWriter backupWriter = new StringWriter();
		try {
			settings.save(backupWriter);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Impossible IO exception on string writer: " + e.getLocalizedMessage());
		}
		this.settingsBackup = backupWriter.toString();
	}
	
	private void restoreDialogSettings() {
		if(settingsBackup != null) {
			IDialogSettings workbenchSettings = Activator.getDefault().getDialogSettings();
			IDialogSettings settings = workbenchSettings.getSection(CreateModelWizard.NEW_MODEL_SETTINGS);
			if(settings != null) {
				((DialogSettings)workbenchSettings).removeSection(settings);
				settings = workbenchSettings.addNewSection(settings.getName());

				try {
					settings.load(new StringReader(settingsBackup));
				} catch (IOException e) {
					e.printStackTrace();
					fail("Impossible IO exception on string read: " + e.getLocalizedMessage());
				}
			}
		}
	}
}
