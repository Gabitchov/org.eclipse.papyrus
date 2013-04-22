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

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;

/**
 * Bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=402964
 * 
 * Description:
 * http://ec2-46-137-124-143.eu-west-1.compute.amazonaws.com/confluence/display/PAPYRUS/402964+-+Display+type+name+as+tooltip+of+each+node+element
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestTooltip_402964 extends TestTopNode {

	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase#getDiagramCommandCreation()
	 * 
	 * @return
	 */
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	protected void testLifelineTooltip() {

	}
}
