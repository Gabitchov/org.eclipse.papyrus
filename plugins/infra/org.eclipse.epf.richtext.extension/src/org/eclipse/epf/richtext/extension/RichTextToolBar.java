package org.eclipse.epf.richtext.extension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epf.richtext.actions.IRichTextAction;
import org.eclipse.epf.richtext.actions.RichTextAction;
import org.eclipse.epf.richtext.extension.actions.ComboContributionItem;
import org.eclipse.epf.richtext.extension.actions.RichTextButtonAction;
import org.eclipse.epf.richtext.actions.RichTextComboAction;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolItem;

/**
 * The default rich text tool bar implementation.
 * 
 * Split into 2 toolbars (one for CCombos, one for buttons) for tabbing purposes.
 * 
 * @author Nguyen
 */
public class RichTextToolBar implements IRichTextToolBar {

	/**
	 * If true, add a new tool bar.
	 */
	private boolean addToolBar = true;

	/**
	 * The current tool bar manager used to populate the tool actions.
	 */
	private ToolBarManager toolbarMgr;

	/**
	 * The current tool bar manager used to populate the tool actions.
	 */
	private ToolBarManager toolbarMgrCombo;

	/**
	 * The action items in the tool bar(s).
	 */
	private List<Object> actionItems = new ArrayList<Object>();

	/**
	 * the parent composite
	 */
	protected Composite parent;

	/**
	 * Creates a new instance.
	 * 
	 * @param parent
	 *        the parent composite
	 * @param style
	 *        the tool bar style
	 * @param richText
	 *        the parent rich text control
	 */
	public RichTextToolBar(Composite parent, int style) {
		this.parent = parent;
		addToolBar();
	}

	/**
	 * @see org.eclipse.epf.richtext.extension.IRichTextToolBar#addButton(org.eclipse.swt.widgets.Button)
	 * 
	 * @param button
	 */
	public void addButton(Button button) {
		if(button != null) {
			ToolItem item = new ToolItem(toolbarMgr.getControl(), SWT.FLAT);
			item.setControl(button);
			toolbarMgr.update(true);
		}
	}

	/**
	 * @see org.eclipse.epf.richtext.IRichTextToolBar#addAction(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */
	public void addAction(final IAction action) {
		if(action != null) {
			ActionContributionItem item = new ActionContributionItem(action);

			toolbarMgr.add(item);
			toolbarMgr.update(true);
			actionItems.add(item);
		}
	}

	/**
	 * Adds a combo action to the tool bar.
	 * 
	 * @param action
	 *        the action to add
	 */
	public void addAction(final RichTextComboAction item) {
		if(item != null) {
			item.init();
			toolbarMgrCombo.add(item);
			toolbarMgrCombo.update(true);
			actionItems.add(item);
		}
	}

	/**
	 * Adds a combo action to the tool bar.
	 * 
	 * @param action
	 *        the action to add
	 */
	public void addAction(final org.eclipse.epf.richtext.extension.actions.RichTextComboAction item) {
		if(item != null) {
			item.init();
			toolbarMgrCombo.add(item);
			toolbarMgrCombo.update(true);
			actionItems.add(item);
		}
	}

	/**
	 * @see org.eclipse.epf.richtext.extension.IRichTextToolBar#addAction(org.eclipse.epf.richtext.extension.actions.RichTextButtonAction)
	 * 
	 * @param item
	 */
	public void addAction(final RichTextButtonAction item) {
		if(item != null) {
			item.init();
			toolbarMgr.add(item);
			toolbarMgr.update(true);
			actionItems.add(item);
		}
	}

	/**
	 * Adds a separator to the tool bar.
	 */
	public void addSeparator() {
		toolbarMgr.add(new Separator());
	}

	/**
	 * Updates the toolbar state.
	 * <p>
	 * Enables/disables actions depending on the currently selected RichTextEditor tab (RichText vs. HTML)
	 * 
	 * @param editable
	 *        specifies whether to enable non-ReadOnly commands
	 */
	public void updateToolBar(boolean enabled) {
		//		boolean richTextMode = true;
		//		if (editor.isHTMLTabSelected()) {
		//			richTextMode = false;
		//		}
		for(Iterator<Object> i = actionItems.iterator(); i.hasNext();) {
			Object item = i.next();
			if(item instanceof ToolItem) {
				ToolItem toolItem = (ToolItem)item;
				toolItem.setEnabled(enabled);
			} else if(item instanceof Combo) {
				((Combo)item).setEnabled(enabled);
			} else if(item instanceof ActionContributionItem) {
				RichTextAction action = (RichTextAction)((ActionContributionItem)item).getAction();
				action.setEnabled(enabled);
			} else if(item instanceof RichTextButtonAction) {
				RichTextButtonAction action = (RichTextButtonAction) item;
				action.getButton().setEnabled(enabled);
			} else if(item instanceof ComboContributionItem) {
				ComboContributionItem contributionItem = (ComboContributionItem) item;
				contributionItem.getCCombo().setEnabled(enabled);
			} else {
				System.out.println(item.getClass().getName());
			}
		}
	}

	/**
	 * Adds a tool bar, if necessary, to contain a button action or separator.
	 */
	public void addToolBar() {
		if(addToolBar) {
			toolbarMgrCombo = new ToolBarManager(SWT.WRAP | SWT.FLAT | parent.getStyle());
			toolbarMgrCombo.createControl(parent);
			toolbarMgr = new ToolBarManager(SWT.WRAP | SWT.FLAT | parent.getStyle());
			toolbarMgr.createControl(parent);
			addToolBar = false;
		}
	}

	/**
	 * @see org.eclipse.epf.richtext.IRichTextToolBar#getToolbarMgr()
	 * 
	 * @return
	 */
	public ToolBarManager getToolbarMgr() {
		return toolbarMgr;
	}

	/**
	 * @return ToolBarManager
	 */
	public ToolBarManager getToolbarMgrCombo() {
		return toolbarMgrCombo;
	}
}
