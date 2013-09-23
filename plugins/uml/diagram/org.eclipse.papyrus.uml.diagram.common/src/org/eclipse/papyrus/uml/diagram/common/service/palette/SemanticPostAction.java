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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ProviderHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.providers.SemanticUMLContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.uml.Profile;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Aspect action that modifies semantic information on the edit part newly
 * created
 */
public class SemanticPostAction extends ModelPostAction {

	/** list of properties to update, identified by their names */
	protected Map<String, Object> propertiesToUpdate;

	/** list of properties defined at runtime */
	protected List<String> runtimeDefinedProperties;

	/** entry proxy "parent" of this action when configuring the action */
	protected IPaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/** viewer for the features to initialize */
	protected TableViewer featureViewer;

	/**
	 * this attribute caches the value of the metaclass linked to the creation
	 * entry (performance optimization)
	 */
	protected EClass metaclass = null;

	/** path to the checked box image */
	protected final static String ICON_CHECKED = "/icons/complete_tsk.gif";

	/** path to the unchecked box image */
	protected final static String ICON_UNCHECKED = "/icons/incomplete_tsk.gif";

	/** separator used to serialize lists */
	protected static final String SEPARATOR = ",,";

	/**
	 * Constructor.
	 */
	public SemanticPostAction() {
		propertiesToUpdate = new HashMap<String, Object>();
		runtimeDefinedProperties = new ArrayList<String>();
	}

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
			Node featureNode = childNodes.item(i);
			if(IPapyrusPaletteConstant.FEATURE_NODE_NAME.equals(featureNode.getNodeName())) {
				Node nameNode = featureNode.getAttributes().getNamedItem(IPapyrusPaletteConstant.NAME);
				Node valueNode = featureNode.getAttributes().getNamedItem(IPapyrusPaletteConstant.VALUE);
				Node separatorNode = featureNode.getAttributes().getNamedItem(IPapyrusPaletteConstant.SEPARATOR);
				if(nameNode != null && valueNode != null && separatorNode != null) {
					propertiesToUpdate.put(nameNode.getNodeValue(), parseValue(valueNode.getNodeValue(), separatorNode.getNodeValue()));
				} else {
					Activator.log.error("Impossible to parse the configuration node for semantic post action", null);
				}
			} else if(IPapyrusPaletteConstant.RUNTIME_FEATURE_NODE_NAME.equals(featureNode.getNodeName())) {
				Node nameNode = featureNode.getAttributes().getNamedItem(IPapyrusPaletteConstant.NAME);
				if(nameNode != null) {
					runtimeDefinedProperties.add(nameNode.getNodeValue());
				} else {
					Activator.log.error("Impossible to parse the configuration node for semantic post action", null);
				}
			}
		}
	}

	/**
	 * parse the value from the serialized form
	 * 
	 * @param nodeValue
	 *        the serialized value of the element
	 * @param separator
	 *        the separator used to serialized, in case the element is a
	 *        list
	 * @return the value of the element
	 */
	protected Object parseValue(String nodeValue, String separator) {
		// check this was a list
		if(nodeValue.indexOf(separator) > 0) {
			// this is a list
			List<Object> values = new ArrayList<Object>();

			StringTokenizer tokenizer = new StringTokenizer(nodeValue, separator);
			while(tokenizer.hasMoreElements()) {
				Object value = tokenizer.nextElement();
				values.add(value);
			}
			return values;
		} else {
			// this is not a list
			return nodeValue;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getPostCommand(final IAdaptable viewAdapter) {
		final TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();

		return new AbstractTransactionalCommand(editingDomain, "Modify Semantic", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				View view = (View)viewAdapter.getAdapter(View.class);

				if(view != null) {
					EObject objectToEdit = view.getElement();

					for(String featureName : propertiesToUpdate.keySet()) {
						// retrieve feature to set
						EStructuralFeature feature = objectToEdit.eClass().getEStructuralFeature(featureName);
						if(feature == null) {
							Activator.log.error("Impossible to find the feature " + featureName + " for element " + objectToEdit, null);
						} else if(feature instanceof EReference) {
							URI uri = (URI)getValue(feature, propertiesToUpdate.get(featureName));

							try {
								EObject value = objectToEdit.eResource().getResourceSet().getEObject(uri, true);

								if(value == null) {
									return CommandResult.newErrorCommandResult("Cannot find the object at " + uri);
								}

								objectToEdit.eSet(feature, value);
							} catch (Exception ex) {
								Activator.log.error(String.format("Cannot set the initial value for '%s'", feature.getName()), ex); //The exception is not properly propagated. Log it here to avoid silent exceptions
								return CommandResult.newErrorCommandResult(ex);
							}
						} else {
							objectToEdit.eSet(feature, getValue(feature, propertiesToUpdate.get(featureName)));
						}
					}

					// create the command to open the dialog to set properties on runtime
					if(runtimeDefinedProperties.size() > 0) {
						DynamicConfigureRequest request = new DynamicConfigureRequest(objectToEdit, runtimeDefinedProperties);
						new SetDynamicValueCommand(request).doExecuteWithResult(null, null);
					}

				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * Returns the map of properties to update
	 * 
	 * @return the map of properties to update
	 */
	public Map<String, Object> getPropertiesToUpdate() {
		return propertiesToUpdate;
	}

	/**
	 * @{inheritDoc
	 */
	public Control createConfigurationComposite(Composite parent, IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.entryProxy = entryProxy;

		// retrieve tool metaclass
		if(entryProxy.getEntry() instanceof CombinedTemplateCreationEntry) {
			metaclass = PaletteUtil.getToolMetaclass((CombinedTemplateCreationEntry)entryProxy.getEntry());
		}

		Composite mainComposite = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(3, false);
		mainComposite.setLayout(layout);

		Label titleLabel = new Label(mainComposite, SWT.NONE);
		titleLabel.setText("Values to set for the semantic element");
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		titleLabel.setLayoutData(data);

		featureViewer = new TableViewer(mainComposite, SWT.BORDER | SWT.FULL_SELECTION);
		createColumns(featureViewer);
		featureViewer.setContentProvider(new FeatureContentProvider());
		featureViewer.setLabelProvider(new FeatureLabelProvider());
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = 3;
		featureViewer.getControl().setLayoutData(data);

		updateFeaturesViewer();
		return mainComposite;
	}

	/**
	 * This will create the columns for the table
	 * 
	 * @param viewer
	 *        the viewer for which column are created
	 */
	protected void createColumns(TableViewer viewer) {
		// name column
		TableViewerColumn nameColumn = new TableViewerColumn(viewer, SWT.NONE);
		nameColumn.getColumn().setText("Feature Name");
		nameColumn.getColumn().setWidth(130);
		nameColumn.getColumn().setResizable(true);
		nameColumn.getColumn().setMoveable(false);

		// runtime defined property column
		TableViewerColumn runtimeColumn = new TableViewerColumn(viewer, SWT.NONE);
		runtimeColumn.getColumn().setText("Runtime");
		runtimeColumn.getColumn().setWidth(70);
		runtimeColumn.getColumn().setResizable(true);
		runtimeColumn.getColumn().setMoveable(false);
		runtimeColumn.setEditingSupport(new DynamicFeatureEditingSupport(viewer));

		// value column
		TableViewerColumn valueColumn = new TableViewerColumn(viewer, SWT.NONE);
		valueColumn.getColumn().setText("Values");
		valueColumn.getColumn().setWidth(300);
		valueColumn.getColumn().setResizable(true);
		valueColumn.getColumn().setMoveable(false);
		valueColumn.setEditingSupport(new FeatureEditingSupport(viewer));

		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

	/**
	 * updates the stereotype viewer
	 */
	protected void updateFeaturesViewer() {
		featureViewer.setInput(metaclass);
	}

	/**
	 * @{inheritDoc
	 */
	public void save(Node parentNode) {
		if(!(parentNode instanceof Element)) {
			Activator.log.error("parent node is not an Element", null);
			return;
		} else {
			for(String featureName : propertiesToUpdate.keySet()) {
				Element childElement = ((Element)parentNode).getOwnerDocument().createElement(IPapyrusPaletteConstant.FEATURE_NODE_NAME);
				childElement.setAttribute(IPapyrusPaletteConstant.NAME, featureName);
				childElement.setAttribute(IPapyrusPaletteConstant.VALUE, serializeValue(propertiesToUpdate.get(featureName), SEPARATOR));
				childElement.setAttribute(IPapyrusPaletteConstant.SEPARATOR, SEPARATOR);
				parentNode.appendChild(childElement);
			}

			for(String featureName : runtimeDefinedProperties) {
				Element childElement = ((Element)parentNode).getOwnerDocument().createElement(IPapyrusPaletteConstant.RUNTIME_FEATURE_NODE_NAME);
				childElement.setAttribute(IPapyrusPaletteConstant.NAME, featureName);
				parentNode.appendChild(childElement);
			}
		}
	}

	/**
	 * Serialize the value of the element
	 * 
	 * @param object
	 *        the object to serialize
	 * @return the string corresponding to the serialize value
	 */
	@SuppressWarnings("rawtypes")
	protected String serializeValue(Object object, String separator) {
		if(object instanceof Collection) {
			return PaletteUtil.convertToFlatRepresentation((Collection)object, separator);
		}
		return object.toString();
	}

	/**
	 * Returns <code>true</code> if the value of this feature is defined at
	 * runtime
	 * 
	 * @param feature
	 *        the feature to check
	 * @return <code>true</code> if the value of this feature is defined at
	 *         runtime, else <code>false</code>
	 */
	protected boolean isRuntimeDefined(EStructuralFeature feature) {
		return runtimeDefinedProperties.contains(feature.getName());
	}

	protected ResourceSet getResourceSet() {
		try {
			return getServicesRegistry().getService(ModelSet.class);
		} catch (Exception ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/**
	 * Content provider for the feature viewer
	 */
	protected class FeatureContentProvider implements IStructuredContentProvider {

		/** current edited metaclass */
		protected EClass currentEClass;

		/**
		 * @{inheritDoc
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof EClass) {
				currentEClass = (EClass)inputElement;
				List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
				// create a new list with only non derived features
				for(EStructuralFeature feature : currentEClass.getEAllStructuralFeatures()) {
					if(feature instanceof EReference) {
						EReference reference = (EReference)feature;
						if(reference.isContainer() || reference.isContainment() || reference.isMany()) {
							continue; //Ignore containment and container features, as well as multi-valued references
						}
					}

					if(!feature.isDerived() && feature.isChangeable()) {
						features.add(feature);
					}
				}
				return features.toArray();
			}
			return new Object[0];
		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {
			//Nothing
		}

		/**
		 * @{inheritDoc
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			//Nothing
		}

	}

	/**
	 * Class giving cell editors for statically defined values
	 */
	protected class FeatureEditingSupport extends EditingSupport {

		/** proposals for boolean */
		protected final String[] booleanProposals = new String[]{ "", "true", "false" };

		/**
		 * Constructor.
		 * 
		 * @param viewer
		 *        viewer in which editors will open
		 */
		public FeatureEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected CellEditor getCellEditor(Object element) {
			EStructuralFeature feature = (EStructuralFeature)element;

			if(feature instanceof EReference) {
				return createReferenceEditor((EReference)feature);
			}

			EClassifier eType = feature.getEType();
			if(eType instanceof EEnum) {
				return createEnumerationEditor(feature);
			}
			String instanceTypeName = eType.getInstanceClassName();
			if(instanceTypeName.equals(String.class.getCanonicalName())) {
				return new TextCellEditor(((TableViewer)getViewer()).getTable());
			} else if(instanceTypeName.equals(Integer.class.getCanonicalName())) {
				return new TextCellEditor(((TableViewer)getViewer()).getTable());
			} else if(instanceTypeName.equals("boolean")) {
				return createBooleanEditor(feature);
			}

			return new TextCellEditor(((TableViewer)getViewer()).getTable());
		}

		/**
		 * Creates and return a combobox cell editor for a boolean type
		 * 
		 * @param feature
		 *        the feature to edit
		 * @return the newly created combo box cell editor
		 */
		protected CellEditor createBooleanEditor(EStructuralFeature feature) {
			return new ComboBoxCellEditor(((TableViewer)getViewer()).getTable(), booleanProposals, SWT.READ_ONLY);
		}

		/**
		 * Creates and return a Reference Browser dialog for a Reference type
		 * 
		 * @param reference
		 *        The reference to edit
		 * @return
		 *         The newly created dialog editor
		 */
		protected CellEditor createReferenceEditor(EReference reference) {
			return new ReferenceDialogCellEditor(((TableViewer)getViewer()).getTable(), reference, SWT.NONE);
		}

		/**
		 * Creates and return a combobox cell editor for an enumeration type
		 * 
		 * @param feature
		 *        the feature to edit
		 * @return the newly created combo box cell editor
		 */
		protected CellEditor createEnumerationEditor(EStructuralFeature feature) {
			EEnum eType = (EEnum)feature.getEType();
			List<EEnumLiteral> literals = eType.getELiterals();
			String[] proposals = new String[literals.size() + 1];
			proposals[0] = "";
			for(int i = 0; i < literals.size(); i++) {
				// i+1 because there is already the "" string
				proposals[i + 1] = literals.get(i).getLiteral();
			}
			return new ComboBoxCellEditor(((TableViewer)getViewer()).getTable(), proposals, SWT.READ_ONLY);
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected Object getValue(Object element) {
			EStructuralFeature feature = (EStructuralFeature)element;
			if(feature instanceof EReference) {
				return getReferenceValue((EReference)feature);
			}
			EClassifier eType = feature.getEType();
			if(eType instanceof EEnum) {
				return getEnumerationValue(feature);
			} else {
				String instanceTypeName = eType.getInstanceClassName();
				if(instanceTypeName.equals("boolean")) {
					return getBooleanValue(feature);
				}
				return (propertiesToUpdate.get(feature.getName()) != null) ? propertiesToUpdate.get(feature.getName()) : "";
			}
		}

		/**
		 * Returns the value from the feature
		 * 
		 * @param feature
		 *        the feature to edit
		 * @return the boolean value
		 */
		protected Object getEnumerationValue(EStructuralFeature feature) {
			EEnum eType = (EEnum)feature.getEType();
			List<EEnumLiteral> literals = eType.getELiterals();
			List<String> proposals = new ArrayList<String>();
			proposals.add("");
			for(int i = 0; i < literals.size(); i++) {
				// i+1 because there is already the "" string
				proposals.add(i + 1, literals.get(i).getLiteral());
			}
			Object value = propertiesToUpdate.get(feature.getName());

			if(value == null) {
				return 0;
			} else {
				return proposals.indexOf(value);
			}
		}

		/**
		 * Returns the value from the feature
		 * 
		 * @param feature
		 *        the feature to edit
		 * @return the boolean value
		 */
		protected Object getBooleanValue(EStructuralFeature feature) {
			List<String> booleans = Arrays.asList(booleanProposals);
			Object value = propertiesToUpdate.get(feature.getName());
			if(value == null || value.equals("")) {
				return 0;
			} else {
				return booleans.indexOf(value);
			}
		}

		/**
		 * Returns the URI value for this reference
		 * 
		 * @param feature
		 * @return
		 */
		public Object getReferenceValue(EReference feature) {
			Object uriAsString = propertiesToUpdate.get(feature.getName());
			if(uriAsString == null || "".equals(uriAsString)) {
				return null;
			}
			URI uri = URI.createURI((String)uriAsString);
			return uri;
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected void setValue(Object element, Object value) {
			EStructuralFeature feature = (EStructuralFeature)element;
			String featureName = ((EStructuralFeature)element).getName();
			if(feature instanceof EReference) {
				setReferenceValue(element, value);
			} else {
				EClassifier eType = feature.getEType();
				if(eType instanceof EEnum) {
					setEnumerationValue(element, value);
				} else {
					String instanceTypeName = eType.getInstanceClassName();
					if(instanceTypeName.equals("boolean")) {
						setBooleanValue(element, value);
					} else {
						if(value == null || value.equals("")) {
							propertiesToUpdate.remove(featureName);
						} else {
							propertiesToUpdate.put(featureName, value);
						}
					}
				}
			}

			getViewer().update(element, null);
		}

		/**
		 * Sets the new boolean value on the given element.
		 * 
		 * @param element
		 *        the model element
		 * @param value
		 *        the new value
		 */
		protected void setEnumerationValue(Object element, Object value) {
			EStructuralFeature feature = (EStructuralFeature)element;
			EEnum eType = (EEnum)feature.getEType();
			List<EEnumLiteral> literals = eType.getELiterals();
			List<String> proposals = new ArrayList<String>();
			proposals.add("");
			for(int i = 0; i < literals.size(); i++) {
				// i+1 because there is already the "" string
				proposals.add(i + 1, literals.get(i).getLiteral());
			}
			String featureName = feature.getName();
			if(value == null || value.equals(0)) {
				propertiesToUpdate.remove(featureName);
			} else {
				// retrieve the index of the current value in the list
				int index = (Integer)value;
				propertiesToUpdate.put(featureName, proposals.get(index));
			}
		}

		/**
		 * Set the new EObject value for this feature. The URI is stored as a URI
		 * 
		 * @param element
		 *        The Feature
		 * @param value
		 *        The EObject value
		 */
		protected void setReferenceValue(Object element, Object value) {
			EStructuralFeature feature = (EStructuralFeature)element;
			String featureName = feature.getName();
			if(value instanceof EObject) {
				propertiesToUpdate.put(featureName, EcoreUtil.getURI((EObject)value).toString());
			} else {
				propertiesToUpdate.remove(feature.getName());
			}
		}

		/**
		 * Sets the new boolean value on the given element.
		 * 
		 * @param element
		 *        the model element
		 * @param value
		 *        the new value
		 */
		protected void setBooleanValue(Object element, Object value) {
			EStructuralFeature feature = (EStructuralFeature)element;
			String featureName = feature.getName();
			if(value == null || value.equals(0)) {
				propertiesToUpdate.remove(featureName);
			} else if(value.equals(1)) {
				propertiesToUpdate.put(featureName, booleanProposals[1]);
			} else if(value.equals(2)) {
				propertiesToUpdate.put(featureName, booleanProposals[2]);
			} else {
				Activator.log.error("impossible to set boolean value " + value, null);
			}
		}

	}

	/**
	 * Class giving cell editors for statically defined values
	 */
	protected class DynamicFeatureEditingSupport extends EditingSupport {

		/** editor */
		private CellEditor editor;

		/**
		 * Constructor.
		 * 
		 * @param viewer
		 *        viewer in which editors will open
		 */
		public DynamicFeatureEditingSupport(ColumnViewer viewer) {
			super(viewer);
			editor = new CheckboxCellEditor(null, SWT.NONE);
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected Object getValue(Object element) {
			EStructuralFeature feature = (EStructuralFeature)element;
			return runtimeDefinedProperties.contains(feature.getName());
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected void setValue(Object element, Object value) {
			String featureName = ((EStructuralFeature)element).getName();
			// it should be in the list
			if(!runtimeDefinedProperties.contains(featureName)) {
				runtimeDefinedProperties.add(featureName);
			} else {
				runtimeDefinedProperties.remove(featureName);
			}
			getViewer().update(element, null);
		}

	}

	/**
	 * Label provider for the feature viewer
	 */
	protected class FeatureLabelProvider implements ITableLabelProvider {

		/**
		 * @{inheritDoc
		 */
		public Image getColumnImage(Object element, int columnIndex) {
			EStructuralFeature feature = (EStructuralFeature)element;

			if(columnIndex == 1) {
				// check if it is defined at runtime, using a popup dialog
				if(isRuntimeDefined(feature)) {
					return Activator.getPluginIconImage(Activator.ID, ICON_CHECKED);
				} else {
					return Activator.getPluginIconImage(Activator.ID, ICON_UNCHECKED);
				}

			} else if(columnIndex == 2) {
				if(feature instanceof EReference) {
					Object value = propertiesToUpdate.get(feature.getName());
					if(value == null) {
						return null;
					}

					ResourceSet resourceSet = getResourceSet();
					EObject eObject = resourceSet.getEObject(URI.createURI(value.toString()), true);
					if(eObject.eIsProxy()) {
						eObject = EcoreUtil.resolve(eObject, resourceSet);
					}

					try {
						return getServicesRegistry().getService(LabelProviderService.class).getLabelProvider().getImage(eObject);
					} catch (Exception ex) {
						Activator.log.error(ex);
						return null;
					}
				}
			}
			return null;
		}

		/**
		 * @{inheritDoc
		 */
		public String getColumnText(Object element, int columnIndex) {
			String text = "";
			EStructuralFeature feature = (EStructuralFeature)element;
			switch(columnIndex) {
			case 0:
				text = feature.getName();
				break;
			case 1:
				break;
			case 2:
				// retrieve current given values
				Object value = propertiesToUpdate.get(feature.getName());

				if(feature instanceof EReference) {
					if(value != null) {
						ResourceSet resourceSet = getResourceSet();
						EObject eObject = resourceSet.getEObject(URI.createURI(value.toString()), false);
						if(eObject.eIsProxy()) {
							eObject = EcoreUtil.resolve(eObject, resourceSet);
						}

						try {
							text = getServicesRegistry().getService(LabelProviderService.class).getLabelProvider().getText(eObject);
							return text;
						} catch (Exception ex) {
							Activator.log.error(ex);
							return null;
						}
					}
				}



				text = (value != null) ? value.toString() : "";

			default:
				break;
			}

			return text;
		}

		/**
		 * @{inheritDoc
		 */
		public void addListener(ILabelProviderListener listener) {
			//Nothing
		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {
			//Nothing
		}

		/**
		 * @{inheritDoc
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * @{inheritDoc
		 */
		public void removeListener(ILabelProviderListener listener) {
			//Nothing
		}
	}

	/**
	 * A CellEditor for reference properties
	 * 
	 * @author Camille Letavernier
	 */
	public class ReferenceDialogCellEditor extends DialogCellEditor {

		protected EReference reference;

		public ReferenceDialogCellEditor(Composite parent, EReference reference, int style) {
			super(parent, style);
			this.reference = reference;
		}

		@Override
		protected Object openDialogBox(Control cellEditorWindow) {
			TreeSelectorDialog dialog = new TreeSelectorDialog(cellEditorWindow.getShell());

			try {
				ModelSet modelSet = ServiceUtils.getInstance().getModelSet(getServicesRegistry());
				UmlModel umlModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
				EObject root = umlModel.lookupRoot();

				SemanticUMLContentProvider provider = new SemanticUMLContentProvider(new EObject[]{ root });
				provider.setWantedMetaclasses(Collections.singletonList(reference.getEType()));
				ITreeContentProvider wrappedProvider = ProviderHelper.encapsulateProvider(provider, modelSet, "org.eclipse.papyrus.uml.diagram.common.customization.palette"); //$NON-NLS-1$

				dialog.setContentProvider(wrappedProvider);
				dialog.setLabelProvider(getServicesRegistry().getService(LabelProviderService.class).getLabelProvider());
				if(dialog.open() == Window.OK) {
					Object[] result = dialog.getResult();
					if(result.length == 0) {
						return null;
					}

					if(result[0] instanceof EObject) {
						return result[0];
					}
				}
			} catch (NotFoundException ex) { //UML Root element not found
				Activator.log.error(ex);
			} catch (ServiceException ex) { //Service registry not found
				Activator.log.error(ex);
			}
			return null;
		}
	}
}
