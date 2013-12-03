/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.showhideelements;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.createNodeFromPalette;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.common.editparts.ClassifierEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.papyrus.uml.diagram.common.util.CompartmentUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test Class for {@link CompartmentUtils}
 */
public class TestCompartmentUtils extends AbstractTest {

	/** view to select, copy and paste */
	private static EditPart blockEditPart1;

	/** additional view to select, copy and paste a list of elements */
	private static EditPart blockEditPart2;

	/**
	 * Prepare the diagram before testing
	 * 
	 * @throws Exception
	 *         exception thrown in case of problem
	 */
	@BeforeClass
	public static void prepareBlockForTest() throws Exception {
		try {
			createNodeFromPalette("blockdefinition.tool.block", getDiagramView(), true);
			blockEditPart1 = (EditPart)EditorUtils.getDiagramEditPart().getChildren().get(0);

			if(blockEditPart1 == null) {
				throw new Exception("Unable to prepare block for test.");
			}

			createNodeFromPalette("blockdefinition.tool.block", getDiagramView(), true);
			blockEditPart2 = (EditPart)EditorUtils.getDiagramEditPart().getChildren().get(1);

			if(blockEditPart2 == null) {
				throw new Exception("Unable to prepare block for test.");
			}
		} catch (Exception e) {
			throw new Exception("Unable to prepare block for test.", e);
		}
	}

	/**
	 * Test for {@link CompartmentUtils#getAllCompartmentsEditPart(org.eclipse.gef.EditPart, boolean)}
	 */
	@Test
	public void getAllCompartmentEditParts() {
		List<IResizableCompartmentEditPart> parts1 = CompartmentUtils.getAllCompartmentsEditPart(blockEditPart1, true);
		Assert.assertEquals(3, parts1.size());
		List<IResizableCompartmentEditPart> parts2 = CompartmentUtils.getAllCompartmentsEditPart(blockEditPart2, false);
		Assert.assertEquals(3, parts2.size());
	}

	/**
	 * Basic class for {@link ClassifierEditPart}
	 */
	protected static class TestClassifierEditPart extends ClassifierEditPart {

		/** main shape */
		private ClassifierFigure primaryShape;

		/**
		 * Constructor.
		 * 
		 * @param view
		 *        view associate to this edit part
		 */
		public TestClassifierEditPart(View view) {
			super(view);
			// addChild(new LabelEditPart(null), -1);
		}

		/**
		 * @generated
		 */
		protected IFigure createNodeShape() {
			return primaryShape = new ClassifierFigure();
		}

		/**
		 * @generated
		 */
		public ClassifierFigure getPrimaryShape() {
			return (ClassifierFigure)primaryShape;
		}

		@Override
		protected IFigure createNodePlate() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected IFigure setupContentPane(IFigure nodeShape) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	/**
	 * @return
	 */
	public static View createViewForClassifier() {
		return NotationFactory.eINSTANCE.createShape();
	}
}
