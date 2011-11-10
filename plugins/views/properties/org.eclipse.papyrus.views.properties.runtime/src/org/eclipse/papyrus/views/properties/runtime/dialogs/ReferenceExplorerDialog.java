package org.eclipse.papyrus.views.properties.runtime.dialogs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.IBoundedValuesController;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

/**
 * Selection dialog for icons in bundles
 */
public class ReferenceExplorerDialog extends FilteredItemsSelectionDialog {

	/** preference key for the dialog settings */
	private static final String DIALOG_SETTINGS = "org.eclipse.papyrus.views.properties.runtime.dialogs.ReferenceExplorerDialog"; //$NON-NLS-1$

	/** current filter string */
	protected String filter = null;

	/** controller used to retrieve values */
	private IBoundedValuesController controller;

	/** label Provider used in this window */
	private ILabelProvider labelProvider;

	/** reference comparator */
	private Comparator<?> referenceComparator = new ReferenceComparator();

	/**
	 * Creates a new ReferenceExplorerDialog
	 * 
	 * @param parentShell
	 *        the parent shell for the dialog
	 * @param controller
	 *        the controller managing the property editor
	 * @param allowMultiple
	 *        <code>true</code> if multi selection is allowed
	 */
	public ReferenceExplorerDialog(Shell parentShell, IBoundedValuesController controller, boolean allowMultiple) {
		super(parentShell, allowMultiple);
		this.controller = controller;
		labelProvider = controller.getBrowserLabelProvider();
		setTitle("Select " + ((PropertyEditorController)controller).getPropertyEditor().getDescriptor().getLabel());
		setMessage("Select the reference you want for " + ((PropertyEditorController)controller).getPropertyEditor().getDescriptor().getLabel() + "\nTooltip: " + ((PropertyEditorController)controller).getPropertyEditor().getTooltipText());
		setListLabelProvider(labelProvider);
		setDetailsLabelProvider(labelProvider);
		setInitialPattern("**");
		setInitialSelections(controller.getCurrentValues());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		// should create here the create wizard part
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
		if(settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
		}
		return settings;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ItemsFilter createFilter() {
		return new ObjectItemFilter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Comparator<?> getItemsComparator() {
		return referenceComparator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
		Object[] elements = getElements();
		if(elements == null) {
			return;
		}
		progressMonitor.beginTask("Filling reference list", elements.length);
		for(int i = 0; i < elements.length && !progressMonitor.isCanceled(); i++) {
			contentProvider.add(elements[i], itemsFilter);
			progressMonitor.worked(1);
		}
		progressMonitor.done();
	}

	/**
	 * Returns the list of elements to be displayed
	 * 
	 * @return the list of elements to be displayed
	 */
	protected Object[] getElements() {
		Object values = controller.getAvailableValues();
		if(values instanceof Object[]) {
			return (Object[])values;
		} else if(values instanceof List<?>) {
			return ((List<?>)values).toArray();
		} else if(values instanceof Object) {
			return Arrays.asList(values).toArray();
		}
		return new Object[]{ values };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getElementName(Object item) {
		return labelProvider.getText(item);
	}

	/**
	 * Comparator for the content of the dialog
	 */
	@SuppressWarnings("rawtypes")
	private static class ReferenceComparator implements Comparator {

		/**
		 * Creates a new ReferenceComparator.
		 */
		public ReferenceComparator() {
		}

		/**
		 * {@inheritDoc}
		 */
		public int compare(Object o1, Object o2) {
			return 1;
		}
	}

	/**
	 * Items filter the the elements in the dialog
	 */
	private class ObjectItemFilter extends ItemsFilter {

		/**
		 * Creates a new ObjectItemFilter.
		 */
		public ObjectItemFilter() {

		}

		/**
		 * {@inheritDoc}
		 */
		public boolean matchItem(Object item) {
			String value = labelProvider.getText(item);
			if(value != null) {
				return (matches(value));
			}
			Activator.log.debug("Value should not be null for object :" + item);
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected boolean matches(String text) {
			String pattern = patternMatcher.getPattern();
			if(pattern.indexOf("*") != 0 & pattern.indexOf("?") != 0 & pattern.indexOf(".") != 0) {//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				pattern = "*" + pattern; //$NON-NLS-1$
				patternMatcher.setPattern(pattern);
			}
			return patternMatcher.matches(text);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isConsistentItem(Object item) {
			return true;
		}
	}
}
