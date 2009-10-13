/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.sasheditor.internal.AbstractPart;
import org.eclipse.papyrus.sasheditor.internal.ComponentPart;
import org.eclipse.papyrus.sasheditor.internal.EditorPart;
import org.eclipse.papyrus.sasheditor.internal.PartVisitor;
import org.eclipse.papyrus.sasheditor.internal.RootPart;
import org.eclipse.papyrus.sasheditor.internal.SashPanelPart;
import org.eclipse.papyrus.sasheditor.internal.TabFolderPart;
import org.eclipse.papyrus.sasheditor.internal.TabItemPart;


/**
 * This visitor allows to compare all node of the sash system to all node of the model.
 * For each node, a compare method is called, which can perform any comparison stuff.
 * 
 * @author dumoulin
 */
public class CompareTreeVisitor extends PartVisitor {

	/**
	 * Stack of parents.
	 */
	protected Stack<Object> modelStack = new Stack<Object>();
	protected Stack<AbstractPart> partStack = new Stack<AbstractPart>();
	
	/**
	 * Push the parents in stacks
	 * @param modelParent
	 * @param partParent
	 */
	private void pushParents( Object modelParent, AbstractPart partParent)
	{
		partStack.push(partParent);
		modelStack.push(modelParent);
	}
	
	/**
	 * Pop the parents.
	 */
	private void popParents() 
	{
		partStack.pop();
		modelStack.pop();
	}
	
	/**
	 * Get current model parent.
	 * Retrieve it from the stack. 
	 * The parent is the upper model node visited
	 * @return
	 */
	protected Object getModelParent()
	{
		return modelStack.top();
	}
	
	/**
	 * Get current part parent.
	 * Retrieve it from the stack. 
	 * The parent is the upper part node visited
	 * @return
	 */
	protected Object getPartParent()
	{
		return partStack.top();
	}
	
	/**
	 * Visit the specified type, and then visit the childs..
	 * @param folder
	 */
	public void accept(TabFolderPart tile) {
		acceptTabFolderPart(tile);
		// Visit the children
//		pushParents(tile., tile);
		tile.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the childs..
	 * @param folder
	 */
	public void accept(RootPart tile) {
		acceptRootPart(tile);
		// Visit the children
		tile.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * @param folder
	 */
	public void accept(SashPanelPart tile) {
		acceptSashPanelPart(tile);
		// Visit the children
		tile.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * @param folder
	 */
	public void accept(TabItemPart tile) {
		acceptTabItemPart(tile);
		// Visit the children
		tile.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * @param tile
	 */
	public void accept(EditorPart tile) {
		acceptEditorTile(tile);
		// Visit the children
		tile.visitChildren(this);
	}
	
	/**
	 * Visit the specified type, and then visit the children ..
	 * @param tile
	 */
	public void accept(ComponentPart part) {
		acceptEditorTile(part);
		// Visit the children
		part.visitChildren(this);
	}


	// ----------------------------------------------
	
	
	/**
	 * Visit the specified type.
	 * @param tile
	 */
	protected void acceptRootPart(RootPart tile) {
	}

	/**
	 * Visit the specified type.
	 * @param tile
	 */
	protected void acceptSashPanelPart(SashPanelPart tile) {
	}

	/**
	 * Visit the specified type.
	 * @param tile
	 */
	protected void acceptTabFolderPart(TabFolderPart tile) {
	}

	/**
	 * Visit the specified type.
	 * @param tile
	 */
	protected void acceptTabItemPart(TabItemPart tile) {
	}

	/**
	 * Visit the specified type.
	 * @param tile
	 */
	protected void acceptEditorTile(EditorPart tile) {
	}

	/**
	 * Visit the specified type.
	 * @param tile
	 */
	protected void acceptEditorTile(ComponentPart tile) {
	}
	
	
	/**
	 * A simple stack implementation
	 * @author dumoulin
	 * @param <T>
	 */
	protected class Stack<T> {
		private List<T> list = new ArrayList<T>();
		/**
		 * Push object in the stack
		 * @param object
		 */
		public void push( T object)
		{
			list.add(object);
		}
		 
		/**
		 * Get the index of the top of the stack.
		 * @return
		 */
		private int topIndex() {
			return list.size()-1;
		}
		/**
		 * Get top of stack.
		 * @return
		 */
		public T top() {
			return list.get(topIndex());
		}
		
		/**
		 * Pop object in statck
		 * @return
		 */
		public T pop() {
			return list.remove(topIndex());
		}
	}


}
