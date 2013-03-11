package org.eclipse.papyrus.uml.diagram.wizards;

import junit.framework.TestCase;

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.junit.Before;


public abstract class TestNewModelWizardBase extends TestCase {

	protected static final IStructuredSelection EMPTY_SELECTION = new StructuredSelection();

	protected abstract IWorkbenchWizard createWizard();

	@Override
	@Before
	protected void setUp() throws Exception {
		super.setUp();
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

	protected void testOrderOfPages(IWorkbenchWizard wizard, Class[] expectedPages) {
		IWizardPage next = wizard.getPages()[0];
		for(int i = 0; i < expectedPages.length; i++) {
			String isNullMessageFormat = "page %s expected, but actual is: null";
			assertNotNull(String.format(isNullMessageFormat, i), next);

			testPageInstanceOf(next, expectedPages[i], i);

			next = next.getNextPage();
		}
		String noMorePagesExpectedMessageFormat = "page %s is not expected";
		assertNull(String.format(noMorePagesExpectedMessageFormat, next), next);

	}

	protected void testPageInstanceOf(IWizardPage next, Class expectedClass, int index) {
		String wrongClassFormat = "page %s expected to be SelectRootElementPage, but actual is: %s";
		assertTrue(String.format(wrongClassFormat, index, next.getClass()), expectedClass.isInstance(next));
	}


}
