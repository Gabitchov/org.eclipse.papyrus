/*****************************************************************************
 * Copyright (c) 2013 CEA
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

import java.lang.reflect.Field;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IActionBars;
import org.junit.Test;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=402978
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestMakeSameHeightForLifelines_402978 extends AbstractNodeTest {

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void testLifelinesSameSizeHeight() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(80, 100));
		assertNotNull("lifeline1", lifeline1);
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 100), new Dimension(80, 200));
		assertNotNull("lifeline2", lifeline2);
		StructuredSelection selection = new StructuredSelection(new Object[]{ lifeline2, lifeline1 });
		lifeline1.getViewer().setSelection(selection);
		waitForComplete();
		IContributionItem sameSizeHeight = findEditorAction("org.eclipse.papyrus.uml.diagram.menu.command.sameSize.height");
		assertNotNull("Same size height action", sameSizeHeight);
		executeAction(sameSizeHeight);
		waitForComplete();
		assertTrue("lifeline1 height", Math.abs(200 - getAbsoluteBounds(lifeline1).height) <= 1);//From CSS plugin, there is 1 pixel missing.
		assertTrue("lifeline2 height", Math.abs(200 - getAbsoluteBounds(lifeline2).height) <= 1);//From CSS plugin, there is 1 pixel missing.
	}

	@Test
	public void testLifelinesSameSizeBoth() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 100), new Dimension(80, 200));
		assertNotNull("lifeline1", lifeline1);
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(80, 300));
		assertNotNull("lifeline2", lifeline2);
		StructuredSelection selection = new StructuredSelection(new Object[]{ lifeline2, lifeline1 });
		lifeline1.getViewer().setSelection(selection);
		waitForComplete();
		IContributionItem sameSizeBoth = findEditorAction("org.eclipse.papyrus.uml.diagram.menu.command.sameSize.both");
		assertNotNull("Same size both action", sameSizeBoth);
		executeAction(sameSizeBoth);
		waitForComplete();
		assertTrue("lifeline1 height", Math.abs(300 - getAbsoluteBounds(lifeline1).height) <= 1);//From CSS plugin, there is 1 pixel missing.
		assertTrue("lifeline2 height", Math.abs(300 - getAbsoluteBounds(lifeline2).height) <= 1);//From CSS plugin, there is 1 pixel missing.
	}

	private void executeAction(final IContributionItem action) {
		assertNotNull("executable action", action);
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				Event event = new Event();
				event.type = SWT.Selection;
				if(action instanceof Listener) {
					((Listener)action).handleEvent(event);
				} else {
					try {
						Field f = action.getClass().getDeclaredField("menuItemListener");
						f.setAccessible(true);
						Listener listener = (Listener)f.get(action);
						if(listener != null) {
							f = action.getClass().getDeclaredField("widget");
							f.setAccessible(true);
							event.widget = (Widget)f.get(action);
							listener.handleEvent(event);
						}
					} catch (Exception e) {
					}
				}
			}
		});
	}

	private IContributionItem findEditorAction(String actionId) {
		IActionBars actionBars = diagramEditor.getEditorSite().getActionBars();
		IMenuManager menuManager = actionBars.getMenuManager();
		return getContributionItem(actionId, menuManager.getItems());
	}

	protected IContributionItem getContributionItem(String actionId, IContributionItem[] items) {
		if(actionId == null || items == null || items.length == 0) {
			return null;
		}
		for(IContributionItem item : items) {
			item.update();
			if(item.isSeparator() || item.isGroupMarker()) {
				continue;
			}
			if(actionId.equals(item.getId())) {
				return item;
			}
			if(item instanceof IContributionManager) {
				((IContributionManager)item).update(true);
				IContributionItem[] children = ((IContributionManager)item).getItems();
				IContributionItem child = getContributionItem(actionId, children);
				if(child != null) {
					return child;
				}
			}
		}
		return null;
	}
}
