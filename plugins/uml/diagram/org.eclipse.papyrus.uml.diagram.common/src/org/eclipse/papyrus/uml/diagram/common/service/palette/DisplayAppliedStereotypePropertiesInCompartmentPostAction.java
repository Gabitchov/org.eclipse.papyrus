/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Post action that manages the display of applied stereotypes.
 * <p>
 * More precisely, it is in charge of the display of properties of Stereotypes in Compartments
 * </p>
 */
public class DisplayAppliedStereotypePropertiesInCompartmentPostAction extends GraphicalPostAction {

	/** map of stereotypes / properties to display with their qualified names */
	protected Map<String, String> stereotypePropertiesToDisplay = new HashMap<String, String>();

	/** entry proxy "parent" of this action when configuring the action */
	protected IPaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/** add icon path */
	protected static final String ICONS_ADD = "/icons/obj16/Add_16x16.gif"; //$NON-NLS-1$

	/** remove icon path */
	protected static final String ICONS_REMOVE = "/icons/delete.gif"; //$NON-NLS-1$

	/** TreeViewer that shows the stereotypes to display and their properties */
	private CheckboxTreeViewer stereotypePropertiesToShowTreeViewer;

	/** HashMap of displayed Properties */
	protected Set<String> listOfDisplayableStereotypeProperties = new HashSet<String>();

	/** Node names and constants */
	private static final String PROPERTIES_NODE_NAME = "propertiesToDisplay";

	private static final String PROPERTY_NODE_NAME = "propertyToDisplay";

	/**
	 * @{inheritDoc
	 */
	@Override
	public void init(Node configurationNode, IAspectActionProvider factory) {
		super.init(configurationNode, factory);
		if(configurationNode == null) {
			return;
		}
		NodeList childNodes = configurationNode.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); i++) {
			String nodeName = childNodes.item(i).getNodeName();
			if(PROPERTIES_NODE_NAME.equals(nodeName)) {
				NodeList propertyNodes = childNodes.item(i).getChildNodes();
				for(int j = 0; j < propertyNodes.getLength(); j++) {
					String propertyNodeName = propertyNodes.item(j).getNodeName();
					if(PROPERTY_NODE_NAME.equals(propertyNodeName)) {
						Node propertyNameNode = propertyNodes.item(j).getAttributes().getNamedItem(IPapyrusPaletteConstant.NAME);
						if(propertyNameNode != null) {
							listOfDisplayableStereotypeProperties.add(propertyNameNode.getNodeValue());
						}
					}
				}
			}
		}
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void save(Node parentNode) {
		Element propertiesNode = ((Element)parentNode).getOwnerDocument().createElement(PROPERTIES_NODE_NAME);
		for(String propertyName : listOfDisplayableStereotypeProperties) {
			Element propertyNode = propertiesNode.getOwnerDocument().createElement(PROPERTY_NODE_NAME);
			propertyNode.setAttribute(IPapyrusPaletteConstant.NAME, propertyName);
			propertiesNode.appendChild(propertyNode);
		}
		((Element)parentNode).appendChild(propertiesNode);
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void run(EditPart editPart) {
		final CompositeCommand compositeCommand = new CompositeCommand("Modify Stereotype Properties Display");
		View view = (View)editPart.getModel();
		TransactionalEditingDomain editingDomain = org.eclipse.papyrus.infra.core.utils.EditorUtils.getTransactionalEditingDomain();
		// create commands for properties
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = listOfDisplayableStereotypeProperties.iterator();
		while(it.hasNext()) {
			String value = it.next();
			buffer.append(value);
			if(it.hasNext()) {
				buffer.append(",");
			}
		}
		RecordingCommand propertyCommand = AppliedStereotypeHelper.getAddAppliedStereotypePropertiesCommand(editingDomain, view, buffer.toString());
		compositeCommand.add(new EMFtoGMFCommandWrapper(propertyCommand));
		
		RecordingCommand stereotypeCommand = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(editingDomain, view, "", UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION) ;
		compositeCommand.add(new EMFtoGMFCommandWrapper(stereotypeCommand));
		
		compositeCommand.reduce();
		if(compositeCommand.canExecute()) {
			boolean isActivating = true;
			Map<String, Boolean> options = null;
			// use the viewer to determine if we are still initializing the
			// diagram
			// do not use the DiagramEditPart.isActivating since
			// ConnectionEditPart's
			// parent will not be a diagram edit part
			EditPartViewer viewer = editPart.getViewer();
			if(viewer instanceof DiagramGraphicalViewer) {
				isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
			}
			if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)editPart, false, false)) {
				options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
			}
			AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)editPart).getEditingDomain(), StringStatics.BLANK, options) {

				@Override
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					compositeCommand.execute(monitor, info);
					return Status.OK_STATUS;
				}
			};
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator.log.error(e);
			}
		} else {
			Activator.log.error("Impossible to execute graphical post action " + propertiesToUpdate, null);
		}
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public Control createConfigurationComposite(Composite parent, IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.entryProxy = entryProxy;
		// retrieve displayed stereotypes
		List<String> displayedStereotypeNames = new ArrayList<String>();
		if(entryProxy instanceof IPaletteAspectToolEntryProxy) {
			for(IPostAction postAction : ((IPaletteAspectToolEntryProxy)entryProxy).getPostActions()) {
				if(postAction instanceof StereotypePostAction) {
					for(String stereotypeName : ((StereotypePostAction)postAction).getStereotypesToApply()) {
						displayedStereotypeNames.add(stereotypeName);
					}
				}
			}
		}
		// get the stereotypes to display, looking in the list of applied profiles and comparing with the list of stereotype qualified names to be displayed
		List<Stereotype> displayedStereotypes = new ArrayList<Stereotype>();
		for(Profile appliedProfile : appliedProfiles) {
			for(Stereotype stereotype : appliedProfile.getOwnedStereotypes()) {
				if(stereotype != null && displayedStereotypeNames.contains(stereotype.getQualifiedName())) {
					displayedStereotypes.add(stereotype);
				}
			}
		}
		// check list has same size...
		if(displayedStereotypeNames.size() != displayedStereotypes.size()) {
			Activator.log.error("all the stereotypes were not resolved:\n" + displayedStereotypeNames + "\n" + displayedStereotypes, null);
		}
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new GridLayout(1, false));
		Label label = new Label(composite, SWT.None);
		label.setText("Choose applied stereotype Properties to display in compartment: ");
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		label.setLayoutData(data);
		stereotypePropertiesToShowTreeViewer = new CheckboxTreeViewer(composite, SWT.BORDER | SWT.CHECK);
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		stereotypePropertiesToShowTreeViewer.getControl().setLayoutData(layoutData);
		stereotypePropertiesToShowTreeViewer.setContentProvider(new ITreeContentProvider() {

			/**
			 * {@inheritDoc}
			 */
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// nothing to do here
			}

			/**
			 * {@inheritDoc}
			 */
			public void dispose() {
				// nothing to do here
			}

			/**
			 * {@inheritDoc}
			 */
			public boolean hasChildren(Object element) {
				if(element instanceof ITreeElement) {
					return ((ITreeElement)element).getChildren().length > 0;
				}
				return false;
			}

			/**
			 * {@inheritDoc}
			 */
			public Object getParent(Object element) {
				if(element instanceof ITreeElement) {
					return ((ITreeElement)element).getParent();
				}
				return null;
			}

			/**
			 * {@inheritDoc}
			 */
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof List) {
					List<StereotypeTreeItem> stereotypeTreeItems = new ArrayList<DisplayAppliedStereotypePropertiesInCompartmentPostAction.StereotypeTreeItem>();
					for(Object object : (List<?>)inputElement) {
						if(object instanceof Stereotype) {
							stereotypeTreeItems.add(new StereotypeTreeItem((Stereotype)object));
						}
					}
					return stereotypeTreeItems.toArray();
				}
				return new Object[0];
			}

			/**
			 * {@inheritDoc}
			 */
			public Object[] getChildren(Object parentElement) {
				if(parentElement instanceof ITreeElement) {
					return ((ITreeElement)parentElement).getChildren();
				}
				return new Object[0];
			}
		});
		stereotypePropertiesToShowTreeViewer.setLabelProvider(new TreeItemLabelProvider());
		stereotypePropertiesToShowTreeViewer.setCheckStateProvider(new CheckStateProvider());
		stereotypePropertiesToShowTreeViewer.addCheckStateListener(new CheckStateListener());
		stereotypePropertiesToShowTreeViewer.setInput(displayedStereotypes);
		return composite;
	}

	/**
	 * Listener for the check/uncheck states of the event.
	 */
	public class CheckStateListener implements ICheckStateListener {

		/**
		 * {@inheritDoc}
		 */
		public void checkStateChanged(CheckStateChangedEvent event) {
			for(TreeItem stereotypeItem : ((CheckboxTreeViewer)event.getCheckable()).getTree().getItems()) {
				Stereotype stereotype = ((StereotypeTreeItem)stereotypeItem.getData()).getStereotype();
				if(stereotype == null) {
					Activator.log.debug("impossible to find stereotype");
					return;
				}
				for(TreeItem propertyItem : stereotypeItem.getItems()) {
					PropertyTreeItem propertyTreeItem = ((PropertyTreeItem)propertyItem.getData());
					if(propertyTreeItem != null && propertyTreeItem.getProperty() != null) {
						if(propertyItem.getChecked()) {
							listOfDisplayableStereotypeProperties.add(getPropertyName(stereotype, ((PropertyTreeItem)propertyItem.getData()).getProperty()));
						} else {
							listOfDisplayableStereotypeProperties.remove(getPropertyName(stereotype, ((PropertyTreeItem)propertyItem.getData()).getProperty()));
						}
					}
				}
			}
			
		}
	}

	/**
	 * The label provider for the tableviewer : one columns shows the stereotype
	 * name and the other shows the display option
	 */
	class TreeItemLabelProvider extends LabelProvider {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(Object element) {
			if(element instanceof StereotypeTreeItem) {
				return ((StereotypeTreeItem)element).getStereotype().getQualifiedName();
			} else if(element instanceof PropertyTreeItem) {
				return ((PropertyTreeItem)element).getProperty().getQualifiedName();
			}
			return super.getText(element);
		}
	}

	public class CheckStateProvider implements ICheckStateProvider {

		/**
		 * {@inheritDoc}
		 */
		public boolean isChecked(Object element) {
			if(element instanceof PropertyTreeItem) {
				Property property = ((PropertyTreeItem)element).getProperty();
				Stereotype stereotype = ((PropertyTreeItem)element).getParent().getStereotype();
				if(property != null && stereotype != null) {
					String name = getPropertyName(stereotype, property);
					return listOfDisplayableStereotypeProperties.contains(name);
				}
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isGrayed(Object element) {
			return false;
		}
	}

	public String getPropertyName(Stereotype stereotype, Property property) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(stereotype.getQualifiedName());
		buffer.append(".");
		buffer.append(property.getName());
		return buffer.toString();
	}

	public interface ITreeElement {

		public ITreeElement[] getChildren();

		public ITreeElement getParent();
	}

	/**
	 * Tree Item to manage Stereotypes
	 */
	public class StereotypeTreeItem implements ITreeElement {

		private Stereotype stereotype;

		private PropertyTreeItem[] propertyTreeItems;

		/**
		 * Constructor.
		 * 
		 * @param parentItem
		 *        th parent item for this tree item
		 * @param style
		 *        the style of this tree item
		 */
		public StereotypeTreeItem(Stereotype stereotype) {
			this.stereotype = stereotype;
		}

		/**
		 * Returns the Stereotype represented by this tree item
		 */
		public Stereotype getStereotype() {
			return stereotype;
		}

		public PropertyTreeItem[] getChildren() {
			if(propertyTreeItems == null) {
				List<PropertyTreeItem> items = new ArrayList<DisplayAppliedStereotypePropertiesInCompartmentPostAction.PropertyTreeItem>();
				for(Property property : stereotype.getAllAttributes()) {
					if(property != null) {
						items.add(new PropertyTreeItem(this, property));
					}
				}
				propertyTreeItems = items.toArray(new PropertyTreeItem[]{});
			}
			return propertyTreeItems;
		}

		public ITreeElement getParent() {
			return null;
		}
	}

	/**
	 * Tree Item to manage Stereotypes
	 */
	public class PropertyTreeItem implements ITreeElement {

		private Property property;

		private StereotypeTreeItem stereotypeTreeItem;

		/**
		 * Constructor.
		 * 
		 * @param parentItem
		 *        the parent item for this tree item
		 * @param style
		 *        the style of this tree item
		 */
		public PropertyTreeItem(StereotypeTreeItem stereotypeTreeItem, Property property) {
			this.stereotypeTreeItem = stereotypeTreeItem;
			this.property = property;
		}

		/**
		 * Returns the Property represented by this tree item
		 */
		public Property getProperty() {
			return property;
		}

		public StereotypeTreeItem getParent() {
			return stereotypeTreeItem;
		}

		public ITreeElement[] getChildren() {
			return new ITreeElement[0];
		}
	}
}
