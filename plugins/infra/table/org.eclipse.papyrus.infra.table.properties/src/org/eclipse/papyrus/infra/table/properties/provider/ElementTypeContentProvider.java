package org.eclipse.papyrus.infra.table.properties.provider;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;
import org.eclipse.papyrus.infra.table.properties.Activator;
import org.eclipse.papyrus.infra.table.properties.messages.Messages;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


public class ElementTypeContentProvider extends AbstractStaticContentProvider implements ITreeContentProvider, IGraphicalContentProvider {

	private Set<String> values = null;


	public String[] getElements() {
		if(this.values == null) {
			this.values = getValues();
		}

		return this.values.toArray(new String[values.size()]);
	}


	private Set<String> getValues() {
		final Set<String> allValues = getAllPossiblesValues();
		return allValues;
	}

	private Set<String> getAllPossiblesValues() {

		IClientContext clientContext = null;
		try {
			clientContext = TypeContext.getContext();
		} catch (ServiceException e1) {
		Activator.log.error(e1);
		}
		IElementType[] types = ElementTypeRegistry.getInstance().getElementTypes(clientContext);
		final Set<String> ids = new TreeSet<String>();
		for(IElementType iElementType : types) {
			final String id = iElementType.getId();
			if(id.contains("sysml.stereotype.") || id.contains("uml.stereotype.")) {//FIXME should not be done here -> should be adapted in the Papyrus Table V3 //$NON-NLS-1$ //$NON-NLS-2$
				//nothing to do 
			} else {
				ids.add(id);
			}
		}
		return ids;
	}


	public Object[] getChildren(Object parentElement) {
		return new Object[0];
	}

	public Object getParent(Object element) {
		return null; //Flat provider
	}

	public boolean hasChildren(Object element) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createBefore(Composite parent) {
		createPatternFilter(parent);
	}

	protected ViewerFilter patternFilter;

	private String currentFilterPattern = ""; //$NON-NLS-1$

	private StructuredViewer viewer;

	protected void createPatternFilter(Composite parent) {
		StringEditor editor = new StringEditor(parent, SWT.NONE);
		editor.setLabel("Filter:"); //$NON-NLS-1$
		editor.setToolTipText(Messages.ElementTypeContentProvider_EnterTheNameOfTheWantedElement);
		editor.setValidateOnDelay(true);
		patternFilter = new PatternViewerFilter();
		((PatternViewerFilter)patternFilter).setPattern(currentFilterPattern);

		editor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				String filterPattern = (String)((StringEditor)editor).getValue();
				((PatternViewerFilter)patternFilter).setPattern(filterPattern);
				viewer.refresh();
				if(!("".equals(filterPattern) || currentFilterPattern.equals(filterPattern))) { //$NON-NLS-1$
					Object firstMatch = getFirstMatchingElement(null);
					if(firstMatch != null) {
						//						revealSemanticElement(Collections.singletonList(firstMatch));
					}
					currentFilterPattern = filterPattern;
				}
			}

		});

		List<ViewerFilter> filters = new LinkedList<ViewerFilter>(Arrays.asList(viewer.getFilters()));
		filters.add(patternFilter);
		viewer.setFilters(filters.toArray(new ViewerFilter[filters.size()]));
	}


	public void createAfter(Composite parent) {
	}


	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		this.viewer = (StructuredViewer)viewer;
	}

	/**
	 * Returns the first (encapsulated) element matching the current filters
	 * 
	 * @return
	 */
	protected Object getFirstMatchingElement(Object parent) {
		//Browse from the root element
		if(parent == null) {
			for(Object parentElement : getElements(viewer.getInput())) {
				Object firstMatch = getFirstMatchingElement(parentElement);
				if(firstMatch != null) {
					return firstMatch;
				}
			}
			return null;
		}

		for(ViewerFilter filter : viewer.getFilters()) {
			if(!filter.select(viewer, getParent(parent), parent)) {
				return null;
			}
		}

		//Browse the child elements
		for(Object childElement : getChildren(parent)) {
			Object firstMatch = getFirstMatchingElement(childElement);
			if(firstMatch != null) {
				return firstMatch;
			}
		}

		//No match found
		return null;
	}


}
