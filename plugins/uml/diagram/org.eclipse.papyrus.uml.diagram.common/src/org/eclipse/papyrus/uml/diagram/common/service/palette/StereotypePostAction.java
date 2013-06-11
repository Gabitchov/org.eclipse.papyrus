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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.diagram.common.commands.ApplyStereotypeCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.DefferedAppliedStereotypeToDisplayCommand;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.papyrus.uml.diagram.common.ui.dialogs.PropertyEditors;
import org.eclipse.papyrus.uml.diagram.common.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Aspect action that applies stereotypes on the edit part newly created
 * 
 * /!\ WARNING use the setters and getters for manipulating the {@link #propertiesToUpdate} and {@link #valuesToProperties}
 * 
 * 
 */
public class StereotypePostAction extends ModelPostAction {

	/*
	 * the icons paths
	 */
	/** up icon path */
	protected static final String ICONS_UP = "/icons/arrow_up.gif"; //$NON-NLS-1$

	/** down icon path */
	protected static final String ICONS_DOWN = "/icons/arrow_down.gif"; //$NON-NLS-1$

	/** add icon path */
	protected static final String ICONS_ADD = "/icons/obj16/Add_16x16.gif"; //$NON-NLS-1$

	/** remove icon path */
	protected static final String ICONS_REMOVE = "/icons/delete.gif"; //$NON-NLS-1$

	/** stereotype icon path */
	protected static final String ICON_STEREOTYPE = "/icons/stereotype.gif"; //$NON-NLS-1$

	/** profile icon path */
	protected static final String ICON_PROFILE = "/icons/profile.gif"; //$NON-NLS-1$

	/** property icon path */
	protected static final String ICON_PROPERTY = "/icons/property.gif"; //$NON-NLS-1$

	/** metaclass icon path */
	protected static final String ICON_METACLASS = "/icons/Metaclass.gif"; //$NON-NLS-1$

	/** boolean icon path */
	protected static final String ICON_LITERALBOOLEAN = "/icons/LiteralBoolean.gif"; //$NON-NLS-1$

	/** integer icon path */
	protected static final String ICON_LITERALINTEGER = "/icons/LiteralInteger.gif"; //$NON-NLS-1$

	/** integer icon path */
	protected static final String ICON_LITERALREAL = "/icons/LiteralReal.gif"; //$NON-NLS-1$
	
	/** string icon path */
	protected static final String ICON_LITERALSTRING = "/icons/LiteralString.gif"; //$NON-NLS-1$

	/** unlimited natural icon path */
	protected static final String ICON_LITERALUNLIMITEDNATURAL = "/icons/LiteralUnlimitedNatural.gif"; //$NON-NLS-1$

	/** unknown icon path */
	protected static final String ICON_UNKNOWN = "/icons/Clause.gif"; //$NON-NLS-1$

	/** enumeration icon path */
	protected static final String ICON_ENUMERATION = "/icons/Enumeration.gif"; //$NON-NLS-1$

	/** datatype icon path */
	protected static final String ICON_DATATYPE = "/icons/DataType.gif"; //$NON-NLS-1$

	/** the configuration for the palette element */
	protected Configuration config;

	/**
	 * Separator for displaying the different values owned by a multi-valued
	 * property
	 */
	protected static final String SEPARATOR = ", "; //$NON-NLS-1$

	/** viewer to display stereotypes to apply */
	protected TreeViewer stereotypesViewer;

	/** entry proxy "parent" of this action when configuring the action */
	protected IPaletteEntryProxy entryProxy;

	/** editor label provider */
	protected EditorLabelProvider editorLabelProvider = new EditorLabelProvider();

	/** editor content provider */
	protected StereotypeContentProvider stereotypeContentProvider = new StereotypeContentProvider();

	/*
	 * the buttons
	 */

	/** remove button */
	protected Button removeButton;

	/** add button */
	protected Button addButton;

	/** up button */
	protected Button upButton;

	/** down button */
	protected Button downButton;

	/** string used with the upButton */
	public static final String MOVE_DOWN = "move down"; //$NON-NLS-1$

	/** string used with the downButton */
	public static final String MOVE_UP = "move up"; //$NON-NLS-1$

	/** contains the expanded nodes */
	private Object[] expandedElements = null;

	/** constant to identify the type of a Boolean property */
	final static public String UMLPrimitiveTypes_BOOLEAN = "PrimitiveTypes::Boolean"; //$NON-NLS-1$

	/** constant to identify the type of an Integer property */
	final static public String UMLPrimitiveTypes_INTEGER = "PrimitiveTypes::Integer"; //$NON-NLS-1$

	/** constant to identify the type of a String property */
	final static public String UMLPrimitiveTypes_STRING = "PrimitiveTypes::String"; //$NON-NLS-1$

	/** constant to identify the type of an Unlimited Natural property */
	final static public String UMLPrimitiveTypes_UNLIMITED_NATURAL = "PrimitiveTypes::UnlimitedNatural"; //$NON-NLS-1$

	/** constant to identify the type of an Unlimited Natural property */
	final static public String UMLPrimitiveTypes_REAL = "PrimitiveTypes::Real"; //$NON-NLS-1$
	
	/** path to the checked box image */
	protected final static String ICON_CHECKED = "/icons/complete_tsk.gif"; //$NON-NLS-1$

	/** path to the unchecked box image */
	protected final static String ICON_UNCHECKED = "/icons/incomplete_tsk.gif"; //$NON-NLS-1$

	/** the column for the stereotypes */
	private TreeViewerColumn stereotypeColumn = null;

	/** the column with the checkboxes for the runtime properties */
	private TreeViewerColumn runtimeColumn = null;

	private ArrayList<Value> savedValues;

	/**
	 * Constructor.
	 */
	public StereotypePostAction() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus checkPostCondition() {
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus checkPreCondition() {
		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.service.palette.ModelPostAction#init(org.w3c.dom.Node,
	 *      org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectActionProvider)
	 * 
	 * @param configurationNode
	 * @param factory
	 */
	@Override
	public void init(Node configurationNode, IAspectActionProvider factory) {
		super.init(configurationNode, factory);
		config = new Configuration(configurationNode);
	}

	/**
	 * @{inheritDoc
	 */
	public void save(Node parentNode) {
		if(parentNode instanceof Element) {
			config.save(parentNode);
		} else {
			Activator.log.error("parent node is not an Element", null); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getPostCommand(IAdaptable viewAdapter) {
		// so, we doesn't need to save the default values which can be modified
		// during the runtime
		config = new Configuration(config.getConfigurationNode());

		final TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();

		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand (editingDomain, "Apply stereotype");

		// Apply the required stereotypes
		final ApplyStereotypeRequest request = new ApplyStereotypeRequest(viewAdapter, config.getStereotypesToApplyQN(), true);

		cmd.add(new ApplyStereotypeCommand(editingDomain, request));
		
		// 2. display stereotypes
		cmd.add(new EMFtoGMFCommandWrapper(new DefferedAppliedStereotypeToDisplayCommand(editingDomain, viewAdapter, "")));

		AbstractTransactionalCommand setPropertiesCommand = new AbstractTransactionalCommand(editingDomain, "Set stereotype values", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				// we search the container for the object
				org.eclipse.uml2.uml.Element element = request.getElement();
				org.eclipse.uml2.uml.Element packageContainer = element;
				do {
					packageContainer = packageContainer.getOwner();
				} while(!(packageContainer instanceof org.eclipse.uml2.uml.Package) && packageContainer != null);


				config.setAppliedProfiles(((org.eclipse.uml2.uml.Package)packageContainer).getAllAppliedProfiles());

				if(config.hasRuntimeProperties()) {
					defineRuntimeProperties(config);
				}

				ArrayList<StereotypeRepresentation> stereotypes = config.getStereotypesRepresentations();
				for(StereotypeRepresentation stereotype : stereotypes) {
					final Stereotype stereotypeToEdit = stereotype.getUMLStereotype();
					ArrayList<PropertyRepresentation> properties = stereotype.getPropertiesWithValues();
					for(PropertyRepresentation property : properties) {
						if(property.hasValues()) {
							Type type = property.getType();
							final String propertyName = property.getUMLProperty().getName();
							if(type != null && propertyName != null) {
								Object newValue = null;
								if(type instanceof PrimitiveType) {
									newValue = Util.getValueFromString(property.getUMLProperty(), property.getStringValue());
								} else if(Util.isMetaclass(type)) {
									newValue = Util.retrievesMetaclassElementFromString(property.getUMLProperty(), property.getStringValue(), packageContainer);
									// property is an Enumeration
								} else if(type instanceof org.eclipse.uml2.uml.Enumeration) {
									newValue = Util.retrievesEnumerationLiteralFromString(property.getUMLProperty(), property.getStringValue(), packageContainer);
									// property is a DataType
								} else if(type instanceof org.eclipse.uml2.uml.DataType) {
									newValue = Util.getValueFromString(property.getUMLProperty(), property.getStringValue());
									// property is a Stereotype
								} else if(type instanceof Stereotype) {
									newValue = Util.retrievesStereotypedElementFromString(property.getUMLProperty(), property.getStringValue(), packageContainer);
									// property is a composite class
								} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.getUMLProperty().isMultivalued()) {
									// TODO
									newValue = null;
								} else {
									Activator.log.error("impossible to find a correct editor for the property" + property, null); //$NON-NLS-1$
								}

								if (newValue != null) {
									element.setValue(stereotypeToEdit, propertyName, newValue);
								}

							}
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};

		cmd.add(setPropertiesCommand);

		return cmd;
	}

	private void saveValues() {
		savedValues = new ArrayList<Value>();
		for(StereotypeRepresentation steRep : config.getStereotypesRepresentations()) {
			if(steRep.hasRuntimeProperties()) {
				for(PropertyRepresentation propRep : steRep.getRuntimeProperties()) {
					for(Value value : propRep.getValues()) {
						Value newVal = new Value(value);
						newVal.setPropertyRepresentation(propRep);
						savedValues.add(newVal);
					}
				}
			}
		}

	}

	private void restoreValues() {
		for(Value val : savedValues) {

		}

	}

	/**
	 * @{inheritDoc
	 */
	public Control createConfigurationComposite(Composite parent, IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		config.setAppliedProfiles(appliedProfiles);
		this.entryProxy = entryProxy;

		Composite mainComposite = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(5, false);
		mainComposite.setLayout(layout);

		Label titleLabel = new Label(mainComposite, SWT.NONE);
		titleLabel.setText("Stereotypes to Apply"); //$NON-NLS-1$
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		titleLabel.setLayoutData(data);

		addButton = new Button(mainComposite, SWT.NONE);
		addButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_ADD));
		addButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				performAddButtonPressed(stereotypesViewer);
				selectionHasChange();
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		removeButton = new Button(mainComposite, SWT.NONE);
		removeButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_REMOVE));
		removeButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				performRemoveAction(stereotypesViewer);
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		removeButton.setEnabled(false);

		upButton = new Button(mainComposite, SWT.NONE);
		upButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_UP));
		upButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				moveElement(MOVE_UP, stereotypesViewer);
				selectionHasChange();
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		upButton.setEnabled(false);

		downButton = new Button(mainComposite, SWT.NONE);
		downButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_DOWN));
		downButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				moveElement(MOVE_DOWN, stereotypesViewer);
				selectionHasChange();

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		downButton.setEnabled(false);

		// stereotype viewer creation
		stereotypesViewer = new TreeViewer(mainComposite, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = 5;

		stereotypesViewer.getControl().setLayoutData(data);
		stereotypesViewer.setContentProvider(stereotypeContentProvider);
		stereotypesViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				performSelectionChange(event);

			}
		});

		stereotypesViewer.getControl().addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {

			}

			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.F2) {
					performF2Action(stereotypesViewer);
				} else if(e.character == SWT.DEL) {
					performRemoveAction(stereotypesViewer);
				} else if(e.stateMask == SWT.CTRL && e.keyCode == 110) {// e.character=='N'
					// doesn't
					// work
					performCTRL_N_Action(e, stereotypesViewer);
				}
				selectionHasChange();
			}
		});

		/*
		 * we can't do : stereotypesViewer.addDoubleClickListener, because we
		 * can't know on which column we are to make something or nothing!
		 */
		stereotypesViewer.getControl().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
				if(stereotypeColumn != null) {
					if(e.x < stereotypeColumn.getColumn().getWidth()) {// we
						// are
						// on
						// the
						// stereotype
						// column
						performDoubleClickAction(stereotypesViewer);
					} else {// change the property value
						ViewerCell cell = runtimeColumn.getViewer().getCell(new Point(e.x, e.y));
						if(cell != null) {
							Object element = ((TreeSelection)stereotypesViewer.getSelection()).getFirstElement();
							stereotypesViewer.editElement(element, 1);
						}
					}
				}
			}
		});
		createColumn(stereotypesViewer);
		updateStereotypeViewer();
		return mainComposite;

	}

	/**
	 * Create the necessary columns to have CellEditor in the tree
	 * 
	 * @param viewer
	 *        the viewer owning the columns
	 */
	protected void createColumn(TreeViewer viewer) {
		stereotypeColumn = new TreeViewerColumn(viewer, SWT.FILL);
		stereotypeColumn.getColumn().setResizable(true);
		stereotypeColumn.getColumn().setWidth(300);
		stereotypeColumn.setLabelProvider(editorLabelProvider);
		stereotypeColumn.setEditingSupport(new AttributeEditingSupport(viewer));

		runtimeColumn = new TreeViewerColumn(viewer, SWT.CENTER);
		runtimeColumn.getColumn().setText("Runtime"); //$NON-NLS-1$
		runtimeColumn.getColumn().setResizable(true);
		runtimeColumn.getColumn().setWidth(80);
		runtimeColumn.setLabelProvider(new RuntimeLabelProvider());
		runtimeColumn.setEditingSupport(new RuntimeEditingSupport(viewer));

		viewer.getTree().setLinesVisible(true);
		viewer.getTree().setHeaderVisible(true);
	}

	/**
	 * updates the stereotype viewer set the expandedNode refresh the status
	 * button this method is called by
	 * <ul>
	 * <li>
	 * {@link #createConfigurationComposite(Composite, PaletteEntryProxy, List)}</li>
	 * <li> {@link #performAddButtonPressed(TreeViewer)} when we add or remove stereotypes</li>
	 * </ul>
	 */
	protected void updateStereotypeViewer() {
		if(stereotypesViewer != null) {
			saveExpandedNode();
			stereotypesViewer.setInput(config.getStereotypesRepresentations());
			restoreExpandedNode();
		}
	}

	/**
	 * used to force the buttons update
	 */
	protected void selectionHasChange() {
		performSelectionChange(new SelectionChangedEvent(stereotypesViewer, stereotypesViewer.getSelection()));
	}

	/**
	 * Action done when the add button is pressed
	 * 
	 * @param tree
	 * 
	 */
	protected void performAddButtonPressed(TreeViewer tree) {
		TreeSelection selection = (TreeSelection)tree.getSelection();
		Object selectedElement = selection.getFirstElement();
		if(selection != null && selection.size() == 1 && !(selectedElement instanceof StereotypeRepresentation)) {
			if(selectedElement instanceof PropertyRepresentation) {
				// We want add a value to a multi-valued property or edit a
				// value to a mono-valued property
				PropertyRepresentation prop = (PropertyRepresentation)selectedElement;
				if(prop.getUpperMultiplicity() != 1) {
					editMe(prop, null);// we add a value
				} else if(!prop.getValues().isEmpty()) { // mono-valued
					// property and the
					// valu exists
					editMe(prop, prop.getValues().get(0));
				} else {// monovalued property, the value doesn't exist
					editMe(prop, null);
				}
				tree.refresh(selectedElement);
			}
			return;
		}

		// pops-up a dialog window where users can select the additionnal
		// stereotypes to apply
		// it needs the metaclass information...
		// for this, entry Proxy should be a Palette entry proxy
		if(!(entryProxy instanceof IPaletteAspectToolEntryProxy)) {
			return;
		}

		PaletteEntry entry = ((IPaletteAspectToolEntryProxy)entryProxy).getEntry();
		if(!(entry instanceof ToolEntry)) {
			return;
		}

		// this is a PaletteAspectToolEntryProxy
		// try to find the metaclass on which the element is working
		EClass metaClass = PaletteUtil.getToolMetaclass((ToolEntry)entry);

		if(metaClass == null) {
			Activator.log.error("Impossible to find metaclass", null); //$NON-NLS-1$
			return;
		}

		// retrieve the original stereotype list from the qualified names
		List<Stereotype> stereotypeList = config.getUMLStereotypes();// retrieveStereotypesFromQualifiedNames();

		// we have all applied profiles, the list of already applied
		// stereotypes, the metaclass of the created element...
		// just have to open a selection dialog
		final CheckedTreeSelectionDialog selectionDialog = new CheckedTreeSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), editorLabelProvider, new ProfileContentProvider(metaClass));
		selectionDialog.setTitle(Messages.StereotypePostAction_StereotypeSelectionTitle);
		selectionDialog.setMessage(Messages.StereotypePostAction_StereotypeSelectionMessage);
		selectionDialog.setContainerMode(true);
		selectionDialog.setInitialElementSelections(stereotypeList);
		selectionDialog.setInput(config.getAppliedProfiles());
		selectionDialog.setExpandedElements(config.getAppliedProfiles().toArray());

		ViewerComparator comparator = new ViewerComparator();
		selectionDialog.setComparator(comparator);

		if(CheckedTreeSelectionDialog.OK == selectionDialog.open()) {
			// update the list of stereotype to apply
			Object[] result = selectionDialog.getResult();
			ArrayList<String> stereotypesToApply = new ArrayList<String>();
			for(int i = 0; i < result.length; i++) {
				if(result[i] instanceof Stereotype) {
					stereotypesToApply.add(((Stereotype)result[i]).getQualifiedName());

				}
			}
			config.setStereotypesRepresentations(stereotypesToApply);
			// it's not possible to use refresh or update here!
			updateStereotypeViewer();
		}

	}

	/**
	 * Action done when the remove button is pressed
	 * 
	 * @param viewer
	 *        the viewer on which the remove action is applied
	 */
	protected void performRemoveAction(TreeViewer viewer) {

		ITreeSelection selection = (ITreeSelection)viewer.getSelection();
		if(selection != null) {
			List<?> selectedElements = ((TreeSelection)selection).toList();
			if(sameLevelForFullSelection(selection)) {
				// all the element have the same type
				if(selection.getFirstElement() instanceof StereotypeRepresentation) {
					for(Object object : selectedElements) {
						if(object instanceof StereotypeRepresentation) {
							config.removeStereotype((StereotypeRepresentation)object);
						}
					}

				} else if(selection.getFirstElement() instanceof PropertyRepresentation) {
					// we delete the value for mono-valued property
					for(Object object : selectedElements) {
						if(object instanceof PropertyRepresentation) {
							if(!((PropertyRepresentation)object).getUMLProperty().isMultivalued()) {
								((PropertyRepresentation)object).getValues().remove(0);
							}
						}
					}
				} else if(selection.getFirstElement() instanceof Value) {
					// we remove value from a multivalued property
					for(Object object : selectedElements) {
						if(object instanceof Value) {
							((Value)object).getPropertyRepresentation().removeValue((Value)object);
						}
					}
				}
				viewer.refresh();
			}
		}
	}

	/**
	 * Action to do when the F2 key is pressed
	 * <ul>
	 * <li>open a CellEditor for the PrimitiveType and DataType</li>
	 * <li>open a popup editor for others types</li>
	 * </ul>
	 * 
	 * @param viewer
	 *        the viewer on which the F2 action is applied
	 */
	protected void performF2Action(TreeViewer viewer) {

		TreeSelection selection = (TreeSelection)viewer.getSelection();
		if((selection != null) && (selection.size() == 1)) {
			Object objectToEdit = selection.getFirstElement();
			if(objectToEdit instanceof PropertyRepresentation) {
				Property prop = ((PropertyRepresentation)objectToEdit).getUMLProperty();
				if(prop.isMultivalued() == false) {
					if((prop.getType() instanceof PrimitiveType) || (prop.getType() instanceof DataType)) {
						viewer.editElement(prop, 0);
					} else {
						// TODO
					}
				}
			} else if(objectToEdit instanceof Value) {
				PropertyRepresentation propRep = ((Value)objectToEdit).getPropertyRepresentation();
				Type type = propRep.getType();
				if(type != null) {
					if(type instanceof PrimitiveType || type instanceof DataType) {
						viewer.editElement(objectToEdit, 0);

						// the refresh is do by the cellEditor! (if the resfresh
						// is do here, there is a bug!)
						// viewer.refresh(property);
					} else {// popupEditor
						editMe(propRep, (Value)objectToEdit);
						viewer.refresh(propRep);
					}
				}
			}
		}

	}

	/**
	 * Action done when a DoubleClick is received by the tree
	 * 
	 * @param viewer
	 *        the viewer on which the DoubleClick action is applied
	 */
	protected void performDoubleClickAction(TreeViewer viewer) {

		TreeSelection selection = (TreeSelection)viewer.getSelection();
		if(selection != null && selection.size() == 1) {
			Object selectedObject = selection.getFirstElement();
			if(selectedObject instanceof StereotypeRepresentation) {
				// we expand or collapse the node
				viewer.setExpandedState(selectedObject, !viewer.getExpandedState(selectedObject));
			} else if(selectedObject instanceof PropertyRepresentation) {
				Property prop = ((PropertyRepresentation)selectedObject).getUMLProperty();
				if(prop.isMultivalued()) {
					// we expand or collapse the node
					viewer.setExpandedState(selectedObject, !viewer.getExpandedState(selectedObject));
				} else {
					// we edit a value
					if(((PropertyRepresentation)selectedObject).getValues().isEmpty()) {
						editMe((PropertyRepresentation)selectedObject, null);
					} else {
						editMe((PropertyRepresentation)selectedObject, ((PropertyRepresentation)selectedObject).getValues().get(0));
					}

					viewer.update(selectedObject, null);
				}
			} else if(selectedObject instanceof Value) {
				editMe(((Value)selectedObject).getPropertyRepresentation(), (Value)selectedObject);
				viewer.refresh(selectedObject);
			}
		}
	}

	/**
	 * Action done when the user does a CTRL^N on the tree
	 * 
	 * @param e
	 *        the KeyEvent
	 * @param viewer
	 *        the TreeViewer in which we add something
	 */
	protected void performCTRL_N_Action(KeyEvent e, TreeViewer viewer) {

		TreeSelection selection = (TreeSelection)viewer.getSelection();
		if(selection != null && selection.size() == 1) {
			Object selectedObject = selection.getFirstElement();
			if(selectedObject != null) {
				if(selectedObject instanceof PropertyRepresentation) {
					Property property = ((PropertyRepresentation)selectedObject).getUMLProperty();
					if(property.isMultivalued()) {
						// can we add a new value?
						int upperMultiplicity = property.getUpper();
						ArrayList<Value> values = ((PropertyRepresentation)selectedObject).getValues();
						if(upperMultiplicity == -1 || values.size() < upperMultiplicity) {
							editMe((PropertyRepresentation)selectedObject, null);
						} else if(values.size() == 0) {
							editMe((PropertyRepresentation)selectedObject, null);
						}
						viewer.refresh(selectedObject);
					}
				}
			}
		}
	}

	/**
	 * Set the {@link Button#setEnabled(boolean)} parameter to true or false for
	 * the buttons following the selected element in the {@link StereotypePostAction#stereotypeViewer}
	 * <ul>
	 * <li> {@link StereotypePostAction#addButton}</li>
	 * <li> {@link StereotypePostAction#removeButton}</li>
	 * <li> {@link StereotypePostAction#upButton}</li>
	 * <li> {@link StereotypePostAction#downButton}</li>
	 * </ul>
	 * 
	 * @param event
	 *        the SelectionChangeEvent
	 */
	protected void performSelectionChange(SelectionChangedEvent event) {
		ITreeSelection selection = (ITreeSelection)event.getSelection();
		int selectionSize = selection.size();
		if((selectionSize == 0) || !(sameLevelForFullSelection(selection))) {
			addButton.setEnabled(true);
			removeButton.setEnabled(false);
			upButton.setEnabled(false);
			downButton.setEnabled(false);
		} else if(selectionSize == 1) {
			Object selectedElement = selection.getFirstElement();
			// removeButton state
			if(selectedElement instanceof StereotypeRepresentation) {
				removeButton.setEnabled(true);
			} else if(selectedElement instanceof PropertyRepresentation) {
				if(((PropertyRepresentation)selectedElement).getUpperMultiplicity() == 1) {
					removeButton.setEnabled(true);
				} else {
					removeButton.setEnabled(false);
				}
			} else if(selectedElement instanceof Value) {
				removeButton.setEnabled(true);

			}

			// addButton state
			if(selectedElement instanceof StereotypeRepresentation) {
				addButton.setEnabled(true);
			} else if(selectedElement instanceof PropertyRepresentation) {
				ArrayList<Value> values = ((PropertyRepresentation)selectedElement).getValues();
				Property prop = ((PropertyRepresentation)selectedElement).getUMLProperty();
				if(!prop.isMultivalued()) {
					if(values.size() == 0) {
						addButton.setEnabled(true);
					} else {
						addButton.setEnabled(false);
					}
				} else {// multi-valued property}
					int upper = prop.getUpper();
					if(upper == -1) {
						addButton.setEnabled(true);
					} else if(values.size() < upper) {
						addButton.setEnabled(true);
					} else {
						addButton.setEnabled(false);
					}
				}
			} else if(selectedElement instanceof Value) {
				addButton.setEnabled(false);
			}
			// upButton and downButton states
			if(selectedElement instanceof StereotypeRepresentation) {
				int index = config.getStereotypesRepresentations().indexOf(selectedElement);
				if(config.getStereotypesRepresentations().size() == 1) {
					downButton.setEnabled(false);
					upButton.setEnabled(false);
				} else if(index == 0) {
					downButton.setEnabled(true);
					upButton.setEnabled(false);
				} else if(index == config.getStereotypesRepresentations().size() - 1) {
					downButton.setEnabled(false);
					upButton.setEnabled(true);
				} else {
					downButton.setEnabled(true);
					upButton.setEnabled(true);
				}
			} else if(selectedElement instanceof PropertyRepresentation) {
				downButton.setEnabled(false);
				upButton.setEnabled(false);
			} else if(selectedElement instanceof Value) {
				ArrayList<Value> valuesList = ((Value)selectedElement).getPropertyRepresentation().getValues();
				int index = valuesList.indexOf(selectedElement);
				if(valuesList.size() == 1) {
					upButton.setEnabled(false);
					downButton.setEnabled(false);
				} else if(index == 0) {
					upButton.setEnabled(false);
					downButton.setEnabled(true);
				} else if(index == valuesList.size() - 1) {
					upButton.setEnabled(true);
					downButton.setEnabled(false);
				} else {
					upButton.setEnabled(true);
					downButton.setEnabled(true);
				}
			}

		} else {// all the elements are from the same level

			List<?> selectedElements = ((TreeSelection)selection).toList();
			if(selection.getFirstElement() instanceof StereotypeRepresentation) {
				removeButton.setEnabled(true);
				upButton.setEnabled(false);
				downButton.setEnabled(false);
				addButton.setEnabled(true);
			} else

				if(selection.getFirstElement() instanceof Value) {
					removeButton.setEnabled(true);
					upButton.setEnabled(false);
					downButton.setEnabled(false);
					addButton.setEnabled(false);
				}
		}
	}

	/**
	 * move the selected element in stereotypeViewer following shiftValue
	 * 
	 * 
	 * 
	 * @param shiftValue
	 *        shiftValue can take the values :
	 *        <ul>
	 *        <li>{@link StereotypePostAction#MOVE_UP}</li>
	 *        <li>{@link StereotypePostAction#MOVE_DOWN}</li>
	 *        </ul>
	 * @param viewer
	 *        the TreeViewer in which we move elements
	 * 
	 */
	protected void moveElement(String shiftValue, TreeViewer viewer) {

		TreeSelection selection = (TreeSelection)viewer.getSelection();
		if(selection != null && selection.size() == 1) {
			Object selectedElement = selection.getFirstElement();
			if(selectedElement instanceof Value) {

				/** it's a property value */
				exchangeTwoValues(((Value)selectedElement).getPropertyRepresentation().getValues(), selectedElement, shiftValue);

				viewer.refresh(((Value)selectedElement).getPropertyRepresentation());

			} else if(selectedElement instanceof StereotypeRepresentation) {
				/** it's a stereotype */
				exchangeTwoValues(config.getStereotypesRepresentations(), selectedElement, shiftValue);
				viewer.refresh();
			}
		}
	}

	/**
	 * Exchange the selectedElement with its neighbor, in arrayList, up or down
	 * following shiftValue
	 * 
	 * 
	 * @param arrayList
	 *        the ArrayList containing the elements to move
	 * @param selectedElement
	 *        the element to move
	 * @param shiftValue
	 *        shiftValue can take the values :
	 *        <ul>
	 *        <li>{@link StereotypePostAction#MOVE_UP}</li>
	 *        <li>{@link StereotypePostAction#MOVE_DOWN}</li>
	 *        </ul>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void exchangeTwoValues(ArrayList arrayList, Object selectedElement, String shiftValue) {
		int index = getIndexOf(arrayList, selectedElement);
		/**
		 * is it possible to move the objects ?
		 */
		if(arrayList == null || arrayList.size() < 2) {
			// the list is to small
			return;
		}
		if((shiftValue.equals(MOVE_UP) && index == 0) || (shiftValue.equals(MOVE_DOWN) && arrayList.size() == (index + 1))) {
			// the selected element is already the first or the last
			return;
		}

		if(shiftValue.equals(MOVE_DOWN)) {
			arrayList.set(index, arrayList.get(index + 1));
			arrayList.set(index + 1, selectedElement);

		} else if(shiftValue.equals(MOVE_UP)) {
			arrayList.set(index, arrayList.get(index - 1));
			arrayList.set(index - 1, selectedElement);
		}
	}

	/**
	 * test if all the selected element in the selection are fron the same level
	 * 
	 * @param selection
	 * @return <ul>
	 *         <li>{@code true} if all the element are from the same level in the tree</li>
	 *         <li>{@code false if not}</li>
	 *         </ul>
	 * 
	 */
	protected boolean sameLevelForFullSelection(ITreeSelection selection) {
		// ITreeSelection selection =
		// (ITreeSelection)stereotypesViewer.getSelection();
		// we do the delete action, only if all the elements have the same level
		List<?> selectedElements = ((TreeSelection)selection).toList();
		if(!selectedElements.isEmpty()) {
			TreePath[] path = selection.getPathsFor(selectedElements.get(0));
			if(path != null) {
				// the level for the first selected Element
				int level = path[0].getSegmentCount();
				for(Object object : selectedElements) {
					path = selection.getPathsFor(object);
					if(level != path[0].getSegmentCount()) {
						/**
						 * the selection is a mixed between different types of
						 * elements
						 */
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the list of stereotypes applied by this action
	 * 
	 * @return the list of stereotypes applied by this action
	 */
	public List<String> getStereotypesToApply() {
		return config.getStereotypesToApplyQN();
	}

	/**
	 * This class provides the methods for displaying the stereotypeViewer's
	 * column. This class gives the correct Label and it's {@link Image} to
	 * display for each element
	 * 
	 * 
	 */
	protected class EditorLabelProvider extends CellLabelProvider implements ILabelProvider {

		/**
		 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
		 * 
		 * @param cell
		 */

		@Override
		public void update(ViewerCell cell) {
			cell.setText(getText(cell.getElement()));
			cell.setImage(getImage(cell.getElement()));
		}

		/**
		 * @{inheritDoc
		 */
		public String getText(Object element) {
			if(element instanceof Profile) {
				return ((Profile)element).getLabel();
			} else if(element instanceof Stereotype) {
				return ((Stereotype)element).getLabel();
			} else if(element instanceof StereotypeRepresentation) {
				return ((StereotypeRepresentation)element).getStereotypeQualifiedName();
			} else if(element instanceof Value) {
				return ((Value)element).getValue();
			} else if(element instanceof PropertyRepresentation) {
				return ((PropertyRepresentation)element).getLabel();
			}
			return element.toString();
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */

		public Image getImage(Object element) {
			if(element instanceof StereotypeRepresentation) {
				return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
			} else if(element instanceof PropertyRepresentation) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PROPERTY);
			} else if(element instanceof Value) {
				Property property = ((Value)element).getPropertyRepresentation().getUMLProperty();
				Type type = property.getType();
				if(type != null) {
					if(type instanceof PrimitiveType) {
						String typeName = type.getQualifiedName();
						// property is a boolean property

						if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
							return Activator.getPluginIconImage(Activator.ID, ICON_LITERALBOOLEAN);

							// property is a String
						} else if(UMLPrimitiveTypes_STRING.equals(typeName)) {
							return Activator.getPluginIconImage(Activator.ID, ICON_LITERALSTRING);

							// property is an Integer
						} else if(UMLPrimitiveTypes_INTEGER.equals(typeName)) {
							return Activator.getPluginIconImage(Activator.ID, ICON_LITERALINTEGER);

							// property is an unlimitedNatural
						}  else if(UMLPrimitiveTypes_REAL.equals(typeName)) {
							return Activator.getPluginIconImage(Activator.ID, ICON_LITERALREAL);

							// property is an unlimitedNatural
						} else if(UMLPrimitiveTypes_UNLIMITED_NATURAL.equals(typeName)) {
							return Activator.getPluginIconImage(Activator.ID, ICON_LITERALUNLIMITEDNATURAL);
							// property is a user primitive Type
						} else {
							// never used!
							// newVTO = new
							// UserPrimitiveTypeValueTreeObject(parent,
							// newValue, domain);
						}

						// property is a Metaclass property
					} else if(Util.isMetaclass(type)) {
						return Activator.getPluginIconImage(Activator.ID, ICON_METACLASS);

						// property is an Enumeration
					} else if(type instanceof org.eclipse.uml2.uml.Enumeration) {
						return Activator.getPluginIconImage(Activator.ID, ICON_ENUMERATION);

						// property is a DataType
					} else if(type instanceof org.eclipse.uml2.uml.DataType) {
						return Activator.getPluginIconImage(Activator.ID, ICON_DATATYPE);

						// property is a Stereotype
					} else if(type instanceof Stereotype) {
						return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);

						// property is a composite class
					} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isMultivalued()) {
						// TODO

					}
				}
			} else if(element instanceof Profile) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PROFILE);
			} else if(element instanceof Stereotype) {// it's a stereotype
				return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
			}

			return Activator.getPluginIconImage(Activator.ID, ICON_UNKNOWN);
		}
	}

	/**
	 * Content provider for the stereotype viewer
	 */
	protected class StereotypeContentProvider implements ITreeContentProvider {

		/**
		 * @{inheritDoc
		 */
		public Object[] getChildren(Object parentElement) {

			if(parentElement instanceof List<?>) {
				return ((List<?>)parentElement).toArray();
			} else if(parentElement instanceof StereotypeRepresentation) {
				return ((StereotypeRepresentation)parentElement).getPropertyRepresentations().toArray();
			} else if(parentElement instanceof PropertyRepresentation) {
				if(((PropertyRepresentation)parentElement).getUpperMultiplicity() != 1 && ((PropertyRepresentation)parentElement).getValues().size() != 0) {
					return ((PropertyRepresentation)parentElement).getValues().toArray();
				}
			}
			return new Object[0];
		}

		/**
		 * @{inheritDoc
		 */
		public Object getParent(Object element) {
			if(element instanceof Value) {
				return ((Value)element).getPropertyRepresentation();
			} else if(element instanceof PropertyRepresentation) {
				return ((PropertyRepresentation)element).getStereotypeRepresentation();
			}
			return null;
		}

		/**
		 * @{inheritDoc
		 */
		public boolean hasChildren(Object element) {
			return getChildren(element) != null && (getChildren(element).length > 0);

		}

		/**
		 * @{inheritDoc
		 */
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {

		}

		/**
		 * @{inheritDoc
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}
	}

	/**
	 * Content provider for the selection dialog
	 */
	protected class ProfileContentProvider implements ITreeContentProvider {

		/** metaclass of the element created by the tool */
		final protected EClass metaclass;

		/**
		 * Constructor.
		 * 
		 * @param metaclass
		 *        the metaclass on which stereotypes can be applied
		 */
		public ProfileContentProvider(EClass metaclass) {
			this.metaclass = metaclass;
		}

		/**
		 * @{inheritDoc
		 */
		public Object[] getChildren(Object parentElement) {
			List<org.eclipse.uml2.uml.Element> children = new ArrayList<org.eclipse.uml2.uml.Element>();
			if(parentElement instanceof Profile) {
				for(Stereotype stereotype : ((Profile)parentElement).getOwnedStereotypes()) {
					// check applicability
					boolean isValid = false;
					List<Class> metaclasses = stereotype.getAllExtendedMetaclasses();
					for(Class stMetaclass : metaclasses) {
						java.lang.Class<? extends Class> metaclassClass = stMetaclass.getClass();
						if(metaclassClass != null) {
							EClassifier metaClassifier = UMLPackage.eINSTANCE.getEClassifier(stMetaclass.getName());
							if(((EClass)metaClassifier).isSuperTypeOf(metaclass)) {
								isValid = true;
							}
						}
					}
					if(isValid) {
						children.add(stereotype);
					}
				}
			}
			return children.toArray();
		}

		/**
		 * @{inheritDoc
		 */
		public Object getParent(Object element) {
			if(element instanceof Profile) {
				return ((Profile)element).getOwner();
			} else if(element instanceof Stereotype) {
				return ((Stereotype)element).getProfile();
			}
			return null;
		}

		/**
		 * @{inheritDoc
		 */
		public boolean hasChildren(Object element) {
			return (element instanceof Profile);
		}

		/**
		 * @{inheritDoc
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof List<?>) {
				return ((List<?>)inputElement).toArray();
			}
			return new Object[0];
		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {

		}

		/**
		 * @{inheritDoc
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

	/**
	 * Give the correct editor to a property following the property type. Fill
	 * the hashmaps with the new value
	 * <ul>
	 * <li>if {@code value==null}, we add a value to a multi-valued property</li>
	 * <li>if {@code value!=null}, we modify a value</li>
	 * </ul>
	 * 
	 * @param property
	 * @param value
	 */
	public void editMe(PropertyRepresentation propRepresentation, Value valueToEdit) {

		Type type = propRepresentation.getType();
		Property property = propRepresentation.getUMLProperty();
		String value = null;
		// property is a a primitive type
		if(type instanceof PrimitiveType) {
			String typeName = type.getQualifiedName();
			// property is a boolean property
			if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
				value = PropertyEditors.BooleanEditor(property, valueToEdit);
				// property is a String

			} else if(UMLPrimitiveTypes_STRING.equals(typeName)) {
				value = PropertyEditors.StringEditor(property, valueToEdit);
				// property is a real
			} else if(UMLPrimitiveTypes_REAL.equals(typeName)) {
				value = PropertyEditors.RealEditor(property, valueToEdit);
				/** property is a user primitive Type */
			} else if(UMLPrimitiveTypes_INTEGER.equals(typeName)) {
				value = PropertyEditors.IntegerEditor(property, valueToEdit);

				// property is an unlimitedNatural
			} else if(UMLPrimitiveTypes_UNLIMITED_NATURAL.equals(typeName)) {

				value = PropertyEditors.UnlimitedNaturalEditor(property, valueToEdit);

				/** property is a user primitive Type */
			} else {
				// never used!
				// newVTO = new UserPrimitiveTypeValueTreeObject(parent,
				// newValue, domain);
			}

			// property is a Metaclass property
		} else if(Util.isMetaclass(type)) {
			value = PropertyEditors.MetaclassEditor(property, valueToEdit, config.getAppliedProfiles());

			// property is an Enumeration
		} else if(type instanceof org.eclipse.uml2.uml.Enumeration) {
			value = PropertyEditors.EnumerationEditor(property, valueToEdit);

			// property is a DataType
		} else if(type instanceof org.eclipse.uml2.uml.DataType) {

			value = PropertyEditors.DataTypeEditor(property, valueToEdit);

			// property is a Stereotype
		} else if(type instanceof Stereotype) {
			value = PropertyEditors.StereotypeEditor(property, valueToEdit, config.getAppliedProfiles());

			// property is a composite class
		} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isMultivalued()) {
			value = PropertyEditors.CompositeClassEditor(property, valueToEdit);
		} else {
			Activator.log.error("Impossible to find a correct editor for the property" + property, null); //$NON-NLS-1$
			return;
		}

		if(value == null && valueToEdit == null) {
			// nothing to do
			return;
		} else if(value == null && valueToEdit != null) {
			// we delete a value
			valueToEdit.getPropertyRepresentation().getValues().remove(valueToEdit);
		} else if(value != null && valueToEdit == null) {
			// we add a value
			propRepresentation.addValue(new Value(value));
		} else if(value != null && valueToEdit != null) {
			// we change a value
			valueToEdit.setValue(value);
		}

	}

	/**
	 * search the object in the ArrayList list, using == and not the equals
	 * method
	 * 
	 * @param list
	 * @param obj
	 * @return return the index of the object or -1 if it doesn't exist in the
	 *         list
	 */
	public int getIndexOf(ArrayList<?> list, Object obj) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == obj) {
				index = i;
			}
		}
		return index;
	}

	/**
	 * save the expanded Nodes
	 */
	protected void saveExpandedNode() {
		expandedElements = stereotypesViewer.getExpandedElements();
	}

	/**
	 * restore the expanded nodes
	 */
	protected void restoreExpandedNode() {
		if(expandedElements != null) {
			stereotypesViewer.setExpandedElements(expandedElements);
			expandedElements = null;
		}
	}

	/**
	 * Class giving cell editors for the {@link stereotypesViewer} and for the {@link RuntimePropertiesDialog#tree}
	 */
	public class AttributeEditingSupport extends EditingSupport {

		/** proposals for boolean */
		protected final String[] booleanProposals = new String[]{ "", "true", "false" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		protected TreeViewer treeViewer = null;

		/**
		 * Constructor.
		 * 
		 * @param viewer
		 *        viewer in which editors will open
		 */
		public AttributeEditingSupport(ColumnViewer viewer) {
			super(viewer);
			this.treeViewer = (TreeViewer)viewer;
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
			Type type = null;
			CellEditor editor = null;
			if(element instanceof Value) {
				type = ((Value)element).getPropertyRepresentation().getType();
			}
			if(type != null) {
				if(type instanceof PrimitiveType) {
					String typeName = type.getQualifiedName();

					// property is a boolean property
					if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
						editor = createBooleanEditor(treeViewer.getTree());

						// property is a String
					} else if(UMLPrimitiveTypes_STRING.equals(typeName)) {
						editor = new TextCellEditor(treeViewer.getTree());

						// property is an Integer
					} else if(UMLPrimitiveTypes_INTEGER.equals(typeName)) {
						editor = new TextCellEditor(treeViewer.getTree());

						// property is an unlimitedNatural
					} else if(UMLPrimitiveTypes_UNLIMITED_NATURAL.equals(typeName)) {
						editor = new TextCellEditor(treeViewer.getTree());

						// property is a user primitive Type
					} else {
						// never used!
						// newVTO = new UserPrimitiveTypeValueTreeObject(parent,
						// newValue, domain);
					}

				}
			}
			return editor;

		}

		/**
		 * Creates and return a combobox cell editor for a boolean type
		 * 
		 * @param feature
		 *        the feature to edit
		 * @return the newly created combo box cell editor
		 */
		protected CellEditor createBooleanEditor(Composite parent) {
			return new ComboBoxCellEditor(parent, booleanProposals, SWT.READ_ONLY);
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected Object getValue(Object element) {

			if(element instanceof Value) {
				Property prop = ((Value)element).getPropertyRepresentation().getUMLProperty();
				if(prop.getType() != null) {
					if(prop.getType().getQualifiedName().equals(UMLPrimitiveTypes_BOOLEAN)) {
						for(int index = 0; index < booleanProposals.length; index++) {
							if(booleanProposals[index].equals(element.toString())) {
								return index;
							}
						}
						return 0;
					}
				}
			}
			return element.toString();
		}

		/**
		 * we use the Cell Editor only to replace a value.
		 */
		@Override
		protected void setValue(Object oldValue, Object newValue) {
			// property can't be null, because, we change a value, we never
			// create a new value
			if(!"".equals(newValue)) { //$NON-NLS-1$
				if(oldValue instanceof Value) {
					Property property = ((Value)oldValue).getPropertyRepresentation().getUMLProperty();
					if(property.getType() != null) {
						if(property.getType() instanceof PrimitiveType) {

							String typeName = property.getType().getQualifiedName();
							if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
								setBooleanValue(oldValue, newValue);
							} else {
								((Value)oldValue).setValue((String)newValue);
							}
						} else {
							((Value)oldValue).setValue((String)newValue);
						}
					}
					treeViewer.refresh(oldValue);

				}
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
		protected void setBooleanValue(Object oldValue, Object newValue) {
			if(newValue == null || newValue.equals(0)) {
				((Value)oldValue).getPropertyRepresentation().getValues().remove(oldValue);
			} else if(newValue.equals(1)) {
				((Value)oldValue).setValue(booleanProposals[1]);
			} else if(newValue.equals(2)) {
				((Value)oldValue).setValue(booleanProposals[2]);
			} else {
				Activator.log.error("Impossible to set boolean value " + newValue, null); //$NON-NLS-1$
			}
		}

	}

	/**
	 * This class provides a {@link CheckboxCellEditor} for the {@link StereotypePostAction#runtimeColumn}
	 * 
	 * 
	 */
	protected class RuntimeEditingSupport extends EditingSupport {

		/** editor */
		private final CellEditor editor;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param viewer
		 *        viewer in which editors will open
		 */
		public RuntimeEditingSupport(ColumnViewer viewer) {
			super(viewer);
			editor = new CheckboxCellEditor(null, SWT.NONE);
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected boolean canEdit(Object element) {
			if(element instanceof PropertyRepresentation) {
				return true;
			}
			return false;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected Object getValue(Object element) {
			if(element instanceof PropertyRepresentation) {
				return ((PropertyRepresentation)element).isRuntime();
			}
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
		 * 
		 * @param element
		 * @param value
		 */
		@Override
		protected void setValue(Object element, Object value) {
			if(element instanceof PropertyRepresentation) {
				((PropertyRepresentation)element).setRuntime((Boolean)value);
				stereotypesViewer.update(element, null);
			}
		}
	}

	/**
	 * This class provides the methods for displaying the stereotypeViewer's
	 * column. This class gives the correct Label and it's {@link Image} to
	 * display for each element
	 * 
	 */
	protected class RuntimeLabelProvider extends CellLabelProvider implements ILabelProvider {

		/**
		 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
		 * 
		 * @param cell
		 */

		@Override
		public void update(ViewerCell cell) {
			cell.setText(getText(cell.getElement()));
			cell.setImage(getImage(cell.getElement()));
		}

		/**
		 * @{inheritDoc
		 */
		public String getText(Object element) {
			return ""; //$NON-NLS-1$
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return the image corresponding to the status (define or not at
		 *         runtime)
		 */

		public Image getImage(Object element) {
			if(element instanceof PropertyRepresentation) {
				if(((PropertyRepresentation)element).isRuntime()) {
					return Activator.getPluginIconImage(Activator.ID, ICON_CHECKED);
				}
				return Activator.getPluginIconImage(Activator.ID, ICON_UNCHECKED);

			}
			return null;
		}
	}

	/**
	 * This method does the action to define the properties defined at runtime,
	 * that's to say, open a dialog to propose editing the properties defined
	 * during the palette customisation
	 * 
	 * @param config
	 *        the configuration which contains all the applied stereotypes
	 *        with properties and values
	 * @param editPart
	 *        the edit
	 */
	protected void defineRuntimeProperties(Configuration config) {

		/*
		 * we copy the stereotype with runtime properties we copy the runtime
		 * properties (note that the values aren't not copied)
		 * 
		 * so steWithPropToEdit contains only stereotypes with only their
		 * runtime properties.
		 */

		List<StereotypeRepresentation> steWithPropToEdit = new ArrayList<StereotypeRepresentation>();
		for(StereotypeRepresentation ste : config.getStereotypesRepresentations()) {
			if(ste.hasRuntimeProperties()) {
				StereotypeRepresentation newSte = new StereotypeRepresentation(ste);
				for(PropertyRepresentation propRep : ste.getRuntimeProperties()) {
					PropertyRepresentation prop = new PropertyRepresentation(propRep);
					newSte.addProperty(prop);
				}
				steWithPropToEdit.add(newSte);
			}
		}

		RuntimePropertiesDialog dialog = new RuntimePropertiesDialog(new Shell(), steWithPropToEdit);
		dialog.open();

	}

	/**
	 * 
	 * This class provides a Dialog to define the properties values during the
	 * element creation
	 * 
	 */
	protected class RuntimePropertiesDialog extends Dialog {

		/** the dialog title */
		private String title = null;

		/** the dialog message */
		private String message = null;

		/** the viewer */
		private TreeViewer tree = null;

		/**
		 * the list containing the {@link StereotypeRepresentation} with the
		 * runtime roperties
		 */
		private List<StereotypeRepresentation> stereotypesRep;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param parent
		 * @param stereotypesList
		 */

		public RuntimePropertiesDialog(Shell parent, List<StereotypeRepresentation> steWithPropToEdit) {
			super(parent);
			this.title = Messages.StereotypePostAction_EditRuntimePropertiesTitle;
			this.message = Messages.StereotypePostAction_EditRuntimePropertiesMessage;
			this.stereotypesRep = steWithPropToEdit;
		}

		/**
		 * 
		 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
		 * 
		 * @param shell
		 */
		@Override
		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			if(title != null) {
				shell.setText(title);
			}

		}

		/**
		 * 
		 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
		 *      we remove the CANCEL Button
		 * @param parent
		 */
		@Override
		protected void createButtonsForButtonBar(Composite parent) {
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		}

		/**
		 * 
		 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
		 * 
		 * @param parent
		 * @return
		 */
		@Override
		protected Control createDialogArea(Composite parent) {
			// create composite
			Composite composite = (Composite)super.createDialogArea(parent);
			GridLayout layout = new GridLayout(5, false);
			composite.setLayout(layout);
			if(message != null) {
				Label titleLabel = new Label(composite, SWT.WRAP);
				titleLabel.setText(message);
				GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
				titleLabel.setLayoutData(data);
			}

			downButton = new Button(composite, SWT.NONE);
			downButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_DOWN));
			downButton.setEnabled(false);
			downButton.addMouseListener(new MouseListener() {

				public void mouseUp(MouseEvent e) {
					moveElement(MOVE_DOWN, tree);
					runtimeSelectionHasChange();
				}

				public void mouseDown(MouseEvent e) {
				}

				public void mouseDoubleClick(MouseEvent e) {
				}
			});

			upButton = new Button(composite, SWT.NONE);
			upButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_UP));
			upButton.setEnabled(false);
			upButton.addMouseListener(new MouseListener() {

				public void mouseUp(MouseEvent e) {
					moveElement(MOVE_UP, tree);
					runtimeSelectionHasChange();
				}

				public void mouseDown(MouseEvent e) {
				}

				public void mouseDoubleClick(MouseEvent e) {

				}
			});

			addButton = new Button(composite, SWT.NONE);
			addButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_ADD));
			addButton.setEnabled(false);
			addButton.addMouseListener(new MouseListener() {

				public void mouseUp(MouseEvent e) {
					// performedAddButtonRuntime(e);
					performAddButtonPressed(tree);
					tree.refresh();
					runtimeSelectionHasChange();
				}

				public void mouseDown(MouseEvent e) {

				}

				public void mouseDoubleClick(MouseEvent e) {

				}
			});

			removeButton = new Button(composite, SWT.NONE);
			removeButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_REMOVE));
			removeButton.setEnabled(false);
			removeButton.addMouseListener(new MouseListener() {

				public void mouseUp(MouseEvent e) {
					performRemoveAction(tree);
					runtimeSelectionHasChange();
				}

				public void mouseDown(MouseEvent e) {

				}

				public void mouseDoubleClick(MouseEvent e) {

				}
			});

			// create the tree
			tree = new TreeViewer(parent, SWT.BORDER | SWT.MULTI);
			// tree.setContentProvider(new
			// RuntimePropertiesStereotypeContentProvider());
			tree.setContentProvider(new StereotypeContentProvider());
			tree.getControl().setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			createColumn(tree);
			tree.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					performSelectionChangeRuntime(event);
				}
			});

			tree.addDoubleClickListener(new IDoubleClickListener() {

				public void doubleClick(DoubleClickEvent event) {

					performDoubleClickAction(tree);
					runtimeSelectionHasChange();
				}

			});

			tree.getControl().addKeyListener(new KeyListener() {

				public void keyReleased(KeyEvent e) {

				}

				public void keyPressed(KeyEvent e) {

					if(e.keyCode == SWT.F2) {
						performF2Action(tree);
					} else if(e.character == SWT.DEL) {
						performRemoveAction(tree);
					} else if(e.stateMask == SWT.CTRL && e.keyCode == 110) {// e.character=='N'
						// doesn't
						// work
						// on
						// my
						// computer
						performCTRL_N_Action(e, tree);
					}
					runtimeSelectionHasChange();
				}

			});
			updateTreeViewer();
			tree.expandAll();
			return composite;
		}

		/**
		 * create the column for the given
		 * 
		 * @param viewer
		 */
		protected void createColumn(TreeViewer viewer) {
			final TreeViewerColumn stereotypeColumn = new TreeViewerColumn(viewer, SWT.FILL);
			stereotypeColumn.getColumn().setResizable(true);
			stereotypeColumn.getColumn().setWidth(400);
			stereotypeColumn.setLabelProvider(editorLabelProvider);
			stereotypeColumn.setEditingSupport(new AttributeEditingSupport(viewer));
		}

		/**
		 * update the TreevViewer
		 */
		private void updateTreeViewer() {
			tree.setInput(stereotypesRep);
			runtimeSelectionHasChange();
		}

		/**
		 * use to force the buttons's update
		 */
		private void runtimeSelectionHasChange() {
			performSelectionChangeRuntime(new SelectionChangedEvent(this.tree, tree.getSelection()));
		}

		/**
		 * this function updates the buttons status
		 * 
		 * @param event
		 */
		protected void performSelectionChangeRuntime(SelectionChangedEvent event) {

			ITreeSelection selection = (ITreeSelection)event.getSelection();
			int selectionSize = selection.size();
			if((selectionSize == 0) || !(sameLevelForFullSelection(selection))) {
				addButton.setEnabled(true);
				removeButton.setEnabled(false);
				upButton.setEnabled(false);
				downButton.setEnabled(false);
			} else if(selectionSize == 1) {
				Object selectedElement = selection.getFirstElement();
				// removeButton state
				if(selectedElement instanceof StereotypeRepresentation) {
					removeButton.setEnabled(false);
				} else if(selectedElement instanceof PropertyRepresentation) {
					if(((PropertyRepresentation)selectedElement).getUpperMultiplicity() == 1) {
						removeButton.setEnabled(true);
					} else {
						removeButton.setEnabled(false);
					}
				} else if(selectedElement instanceof Value) {
					removeButton.setEnabled(true);

				}

				// addButton state
				if(selectedElement instanceof StereotypeRepresentation) {
					addButton.setEnabled(false);
				} else if(selectedElement instanceof PropertyRepresentation) {
					ArrayList<Value> values = ((PropertyRepresentation)selectedElement).getValues();
					Property prop = ((PropertyRepresentation)selectedElement).getUMLProperty();
					if(!prop.isMultivalued()) {
						if(values.size() == 0) {
							addButton.setEnabled(true);
						} else {
							addButton.setEnabled(false);
						}
					} else {// multi-valued property}
						int upper = prop.getUpper();
						if(upper == -1) {
							addButton.setEnabled(true);
						} else if(values.size() < upper) {
							addButton.setEnabled(true);
						} else {
							addButton.setEnabled(false);
						}
					}
				} else if(selectedElement instanceof Value) {
					addButton.setEnabled(false);
				}
				// upButton and downButton states
				if(selectedElement instanceof StereotypeRepresentation) {
					int index = stereotypesRep.indexOf(selectedElement);
					if(config.getStereotypesRepresentations().size() == 1) {
						downButton.setEnabled(false);
						upButton.setEnabled(false);
					} else if(index == 0) {
						downButton.setEnabled(true);
						upButton.setEnabled(false);
					} else if(index == stereotypesRep.indexOf(selectedElement) - 1) {
						downButton.setEnabled(false);
						upButton.setEnabled(true);
					} else {
						downButton.setEnabled(true);
						upButton.setEnabled(true);
					}
				} else if(selectedElement instanceof PropertyRepresentation) {
					downButton.setEnabled(false);
					upButton.setEnabled(false);
				} else if(selectedElement instanceof Value) {
					ArrayList<Value> valuesList = ((Value)selectedElement).getPropertyRepresentation().getValues();
					int index = valuesList.indexOf(selectedElement);
					if(valuesList.size() == 1) {
						upButton.setEnabled(false);
						downButton.setEnabled(false);
					} else if(index == 0) {
						upButton.setEnabled(false);
						downButton.setEnabled(true);
					} else if(index == valuesList.size() - 1) {
						upButton.setEnabled(true);
						downButton.setEnabled(false);
					} else {
						upButton.setEnabled(true);
						downButton.setEnabled(true);
					}
				}

			} else {// all the elements are from the same level

				if(selection.getFirstElement() instanceof StereotypeRepresentation) {
					removeButton.setEnabled(true);
					upButton.setEnabled(false);
					downButton.setEnabled(false);
					addButton.setEnabled(true);
				} else

					if(selection.getFirstElement() instanceof Value) {
						removeButton.setEnabled(true);
						upButton.setEnabled(false);
						downButton.setEnabled(false);
						addButton.setEnabled(false);
					}
			}
		}
	}
}
