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
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
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
		Control checkbox = getControl((Composite)group, Button.class, "Show", SWT.CHECK);
		assertNotNull("Preference Item Visibility CheckBox: ", checkbox);
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
		Rectangle rect = getAbsoluteBounds(cf);
		InteractionOperandEditPart operand = (InteractionOperandEditPart)createNode(UMLElementTypes.InteractionOperand_3005, cf, rect.getCenter(), null);
		assertNotNull(operand);
	}

	@Test
	public void testGuardVisibility() {
	}
}
