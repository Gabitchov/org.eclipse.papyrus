package org.eclipse.papyrus.core.wizard;

import junit.framework.TestCase;

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.wizards.Activator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;


public abstract class TestNewModelWizardBase extends TestCase {
	
	private IWorkbenchWizard myWizard;
	
	protected static final IStructuredSelection EMPTY_SELECTION = new StructuredSelection();	
	
	protected abstract IWorkbenchWizard createWizard();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		myWizard = createWizard();
		myWizard.init(getWorkbench(), getSelection());
		initWizardDialog(myWizard, getShell()); 
	}
	
	protected IStructuredSelection getSelection() {
		return EMPTY_SELECTION;
	}

	protected void initWizardDialog(IWorkbenchWizard wizard, Shell shell) {
		WizardDialog dialog= new WizardDialog(shell, wizard);
		PixelConverter converter= new PixelConverter(JFaceResources.getDialogFont());
		dialog.setMinimumPageSize(converter.convertWidthInCharsToPixels(70), converter.convertHeightInCharsToPixels(20));
		dialog.create();
	}
	
	protected Shell getShell() {
		return getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
	protected IWorkbench getWorkbench() {
		return Activator.getDefault().getWorkbench();
	}
	
	protected IWorkbenchWizard getWizard() {
		return myWizard;
	}
	
	
	protected void testOrderOfPages(Class[] expectedPages) {
		IWizardPage next = getWizard().getPages()[0];
		for (int i = 0; i < expectedPages.length; i++) {
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
