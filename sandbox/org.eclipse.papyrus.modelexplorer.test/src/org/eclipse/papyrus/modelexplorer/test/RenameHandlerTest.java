package org.eclipse.papyrus.modelexplorer.test;

import java.util.List;

import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.modelexplorer.handler.RenameDiagramHandler;
import org.eclipse.papyrus.table.modelexplorer.handlers.RenameTableHandler;
import org.eclipse.ui.internal.handlers.HandlerProxy;
import org.eclipse.uml2.uml.Comment;
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
	public void renameUMLUnnamedElementTest() {
		List<Comment> comments = rootOfTheModel.getOwnedComments();
		Assert.isTrue(comments.size() != 0);
		for(int i = 0; i < rootOfTheModel.getOwnedComments().size(); i++) {
			selectElementInTheModelexplorer(rootOfTheModel.getOwnedComments().get(i));
			IHandler handler = getActiveHandler();
			if(handler != null) {
				Assert.isTrue(handler.isEnabled() == false, "Rename handler is not disabled on UnnamedElement");
			}
		}
	}

	@Test
	public void renameUMLNamedElementTest() {
		selectElementInTheModelexplorer(rootOfTheModel);
		IHandler handler = getActiveHandler();
		//TODO Assert.isTrue(handler instanceof RenameNamedElementHandler);
		Assert.isTrue(handler.getClass().getName().equals("org.eclipse.papyrus.uml.menu.handler.RenameNamedElementHandler"));
		Assert.isTrue(handler.isEnabled());
	}

	@Test
	public void renameTableTest() {
		for(int i = 0; i < papyrusTable.size(); i++) {
			selectElementInTheModelexplorer(papyrusTable.get(i));
			IHandler handler = getActiveHandler();
			Assert.isTrue(handler instanceof RenameTableHandler);
			Assert.isTrue(handler.isEnabled());
		}
	}

	@Test
	public void renameDiagramTest() {
		for(int i = 0; i < diagrams.size(); i++) {
			selectElementInTheModelexplorer(diagrams.get(i));
			IHandler handler = getActiveHandler();
			Assert.isTrue(handler instanceof RenameDiagramHandler);
			Assert.isTrue(handler.isEnabled());
		}
	}

	@Test
	public void renameLinkItemTest() {
		commonViewer.expandToLevel(3);
		Object[] expandedElement = commonViewer.getExpandedElements();
		for(Object object : expandedElement) {
			if(object instanceof org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem) {
				selectElementInTheModelexplorer((ITreeElement)object);
				IHandler handler = getActiveHandler();
				if(handler != null) {
					Assert.isTrue(handler.isEnabled() == false, "The handler " + handler + "is active on LinkItem, it is not the wanted behavior");
				}
			}
		}
	}
}
