/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart.CustomInteractionOperandFigure;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.InteractionOperandModelElementFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestGuardVisibility_402966 extends AbstractNodeTest {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testPreferencePage() {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(shell, "org.eclipse.papyrus.uml.diagram.sequence.preferences.InteractionOperandPreferencePage", null, null);
		dialog.setBlockOnOpen(false);
		dialog.open();
		IPreferencePage page = (IPreferencePage)dialog.getSelectedPage();
		Control control = page.getControl();
		Control group = getControl((Composite)control, Group.class, "Guard", SWT.NONE);
		assertNotNull("Preference Item Guard Group: ", group);
		Button checkbox = (Button)getControl((Composite)group, Button.class, "Show", SWT.CHECK);
		assertNotNull("Preference Item Visibility CheckBox: ", checkbox);
		assertEquals("Default value of Guard Visibility: ", true, checkbox.getSelection());
		dialog.close();
	}

	private Control getControl(Composite parent, Class<?> controlType, String name, int style) {
		if(parent == null || parent.isDisposed()) {
			return null;
		}
		for(Control child : parent.getChildren()) {
			if(child.getClass() == controlType) {
				if(child instanceof Group && name.equals(((Group)child).getText())) {
					return child;
				}
				if(child instanceof Button && name.equals(((Button)child).getText()) && ((style & child.getStyle())) != 0) {
					return child;
				}
			} else if(child instanceof Composite) {
				Control control = getControl((Composite)child, controlType, name, style);
				if(control != null) {
					return control;
				}
			}
		}
		return null;
	}

	@Test
	public void testPropertySheetPage() {
		CombinedFragmentEditPart cf = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(100, 100), new Dimension(400, 100));
		assertNotNull(cf);
		CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)cf.getChildBySemanticHint("" + CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID);
		assertNotNull(compartment);
		InteractionOperandEditPart operand = (InteractionOperandEditPart)createNode(UMLElementTypes.InteractionOperand_3005, compartment, getAbsoluteCenter(compartment), null);
		assertNotNull(operand);
		waitForComplete();
		try {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			PropertySheet propertySheet = (PropertySheet)activePage.showView(IPageLayout.ID_PROP_SHEET);
			IPage currentPage = propertySheet.getCurrentPage();
			assertTrue(currentPage instanceof TabbedPropertySheetPage);
			waitForComplete();
			TabbedPropertySheetPage page = (TabbedPropertySheetPage)currentPage;
			page.setSelectedTab("appearance");
			waitForComplete();
			ITabDescriptor selectedTab = page.getSelectedTab();
			assertNotNull(selectedTab);
			assertEquals("appearance", selectedTab.getId());
			waitForComplete();
			//force select the operand
			page.selectionChanged(activePage.getActiveEditor(), new StructuredSelection(operand));
			waitForComplete();
			Control control = page.getControl();
			assertNotNull(control);
			Button checkbox = (Button)getControl((Composite)control, Button.class, "Show Guard", SWT.CHECK);
			assertNotNull("Could not found \"Show Guard\" CheckBox in Properties: ", checkbox);
			assertEquals("Synchronized value with model: ", InteractionOperandModelElementFactory.isGuardVisible(operand.getPrimaryView()), checkbox.getSelection());
			testGuardVisibility(operand, checkbox.getSelection());
			checkbox.setSelection(!checkbox.getSelection());
			Event event = new Event();
			event.button = 1;
			event.widget = checkbox;
			event.type = SWT.Selection;
			checkbox.notifyListeners(SWT.Selection, event);
			waitForComplete();
			testGuardVisibility(operand, checkbox.getSelection());
		} catch (PartInitException e) {
			fail("Could not open Property Sheet View: " + e.getMessage());
		}
	}

	public void testGuardVisibility(InteractionOperandEditPart operand, boolean visible) {
		assertNotNull(operand);
		CustomInteractionOperandFigure primaryShape = operand.getPrimaryShape();
		WrappingLabel constraintLabel = primaryShape.getInteractionConstraintLabel();
		assertNotNull(constraintLabel);
		if(visible) {
			String text = ((ITextAwareEditPart)operand).getParser().getPrintString(new EObjectAdapter(operand.resolveSemanticElement()), ParserOptions.NONE.intValue());
			assertEquals("Show Guard:", text, constraintLabel.getText());
		} else {
			assertEquals("Hide Guard:", "", constraintLabel.getText());
		}
	}
}
