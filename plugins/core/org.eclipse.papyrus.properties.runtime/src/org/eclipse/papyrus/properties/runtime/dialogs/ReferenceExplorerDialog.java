package org.eclipse.papyrus.properties.runtime.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.properties.runtime.controller.IBoundedValuesController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * Selection dialog for icons in bundles
 */
public class ReferenceExplorerDialog extends SelectionStatusDialog {

	/** indicates if several elements can be selected at the same time */
	protected final boolean allowMultiple;

	/** tree that displays elements */
	protected FilteredTree filteredTree;

	/** current filter string */
	protected String filter = null;

	/** controller used to retrieve values */
	private IBoundedValuesController controller;

	/** filters for the tree viewer */
	private List<ViewerFilter> viewerFilters;


	/**
	 * Creates a new Icon Bundle Explorer Dialog
	 * 
	 * @param parentShell
	 *        the parent shell for the dialog
	 */
	public ReferenceExplorerDialog(Shell parentShell, IBoundedValuesController controller, boolean allowMultiple) {
		super(parentShell);
		this.allowMultiple = allowMultiple;
		this.controller = controller;
		setTitle("Select Reference"); // TODO select + the name of the editor - ':'
		setMessage("Select the reference you want"); // TODO select + the name of the editor - ':'

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		initializeDialogUnits(composite);

		// creates the message area, as defined in the super class
		createMessageArea(composite);
		// createFilterText(composite);
		createFilteredTree(composite);

		refreshTree();

		return composite;
	}

	/**
	 * Refresh the content of the tree
	 */
	protected void refreshTree() {
		filteredTree.getViewer().setInput(controller.getAvailableValues());

		// select objects
		filteredTree.getViewer().setSelection(new StructuredSelection(controller.getCurrentValues()));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void computeResult() {
		List<Object> elements = Arrays.asList(getSelectedElements());
		setResult(elements);
	}

	/**
	 * Returns an array of the currently selected elements.
	 * To be called within or after open().
	 * 
	 * @return returns an array of the currently selected elements.
	 */
	protected Object[] getSelectedElements() {
		Assert.isNotNull(filteredTree.getViewer());
		return ((IStructuredSelection)filteredTree.getViewer().getSelection()).toArray();
	}

	//	/**
	//	 * Creates an area where a filter can be entered. This filter will restrict the list of available icons.
	//	 * 
	//	 * @param parent
	//	 *        the parent composite where to create the filter text
	//	 * @return the created text area
	//	 */
	//	protected Text createFilterText(Composite parent) {
	//		Text text = new Text(parent, SWT.BORDER);
	//
	//		GridData data = new GridData();
	//		data.grabExcessVerticalSpace = false;
	//		data.grabExcessHorizontalSpace = true;
	//		data.horizontalAlignment = GridData.FILL;
	//		data.verticalAlignment = GridData.BEGINNING;
	//		text.setLayoutData(data);
	//		text.setFont(parent.getFont());
	//
	//		text.setText((filter == null ? "" : filter)); //$NON-NLS-1$
	//
	//		Listener listener = new Listener() {
	//
	//			public void handleEvent(Event e) {
	//				// filteredTree.setFilter("*" + filterText.getText()); //$NON-NLS-1$
	//			}
	//		};
	//		text.addListener(SWT.Modify, listener);
	//
	//		text.addKeyListener(new KeyListener() {
	//
	//			public void keyPressed(KeyEvent e) {
	//				if(e.keyCode == SWT.ARROW_DOWN) {
	//					filteredTree.setFocus();
	//				}
	//			}
	//
	//			public void keyReleased(KeyEvent e) {
	//			}
	//		});
	//
	//		filterText = text;
	//
	//		return text;
	//	}

	/**
	 * Creates a filtered tree.
	 * 
	 * @param parent
	 *        the parent composite.
	 * @return returns the filtered tree widget.
	 */
	protected FilteredTree createFilteredTree(Composite parent) {
		int flags = SWT.BORDER | (allowMultiple ? SWT.MULTI : SWT.SINGLE);

		TreeSelectionPatternFilter patternfilter = new TreeSelectionPatternFilter();
		patternfilter.setIncludeLeadingWildcard(true);

		FilteredTree tree = new FilteredTree(parent, flags, patternfilter, true);
		final TreeViewer treeViewer = tree.getViewer();
		treeViewer.setUseHashlookup(true);
		treeViewer.setContentProvider(controller.getContentProvider());
		GridData data = new GridData();
		data.widthHint = convertWidthInCharsToPixels(80);
		data.heightHint = convertHeightInCharsToPixels(18);
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		tree.setLayoutData(data);

		treeViewer.setLabelProvider(controller.getBrowserLabelProvider());

		List<ViewerFilter> filters = controller.getViewerFilters();
		filters.add(patternfilter);
		treeViewer.setFilters(filters.toArray(new ViewerFilter[filters.size()]));
		filteredTree = tree;
		return tree;
	}

	private class TreeSelectionPatternFilter extends PatternFilter {

		@Override
		protected boolean isParentMatch(Viewer viewer, Object element) {
			Object[] children = ((ITreeContentProvider)((AbstractTreeViewer)viewer).getContentProvider()).getChildren(element);
			// apply all filters
			if(viewerFilters != null && children != null) {
				// if one child match, show the parent in tree
				for(ViewerFilter viewerFilter : viewerFilters) {
					for(Object child : children) {
						if(viewerFilter.select(viewer, null, child)) {
							return super.isParentMatch(viewer, element);
						}
					}
				}
				return false;
			} else {
				return super.isParentMatch(viewer, element);
			}
		}

		@Override
		protected boolean isLeafMatch(Viewer viewer, Object element) {
			if(element instanceof EObject) {
				String labelText = ((EObject)element).toString();
				if(labelText != null) {
					return wordMatches(labelText);
				}
			}
			return false;
		}
	}

}
