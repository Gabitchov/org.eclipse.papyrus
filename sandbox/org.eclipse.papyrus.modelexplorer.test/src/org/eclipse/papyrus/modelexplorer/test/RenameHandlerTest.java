package org.eclipse.papyrus.modelexplorer.test;

import org.eclipse.core.runtime.Assert;
import org.junit.Test;


public class RenameHandlerTest extends AbstractHandlerTest {

	/**
	 * the id of the command to rename the element
	 */
	private static final String commandId = "org.eclipse.ui.edit.rename";

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public RenameHandlerTest() {
		super(commandId);
	}

	@Test
	public void renamedUMLUnnamedElementTest() {
		Assert.isTrue(false, "TODO");
	}

	@Test
	public void renamedUMLNamedElementTest() {
		Assert.isTrue(false, "TODO");
	}

	@Test
	public void renameTableTest() {
		Assert.isTrue(false, "TODO");
	}

	@Test
	public void renameDiagramTest() {
		Assert.isTrue(false, "TODO");
	}

	@Test
	public void renameLinkTest() {
		Assert.isTrue(false, "TODO");
	}
}
