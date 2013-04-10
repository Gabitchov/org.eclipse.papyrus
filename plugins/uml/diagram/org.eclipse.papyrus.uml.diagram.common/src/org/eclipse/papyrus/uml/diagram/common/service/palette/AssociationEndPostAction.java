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
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.helper.AssociationHelper;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Aspect action that modifies association end on creation
 */
public class AssociationEndPostAction extends ModelPostAction {

	/**
	 * list of property configurations, identified by their positions in the
	 * association end list
	 */
	protected List<PropertyEndConfiguration> configurations;

	/** entry proxy "parent" of this action when configuring the action */
	protected IPaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/** viewer for the attributes to initialize */
	protected TableViewer attributeViewer;

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

	/** node name for the configuration of the association end */
	protected static final String ASSOCIATION_END_NODE_NAME = "associationEnd";

	/** attribute name for the index of the association end */
	protected static final String INDEX_ATTRIBUTE_NAME = "index";

	/** attribute name for the name of the association end */
	protected static final String NAME_ATTRIBUTE_NAME = "name";

	/** node name for the aggregation configuration of the association end */
	protected static final String AGGREGATION_NODE_NAME = "aggregation";

	/** node name for the value(s) */
	protected static final String VALUE_ATTRIBUTE_NAME = "value";

	/** node name for the multiplicity configuration of the association end */
	protected static final String MULTIPLICITY_NODE_NAME = "multiplicity";

	/** node name for the navigation configuration of the association end */
	protected static final String NAVIGABLE_NODE_NAME = "navigable";

	/** node name for the owner configuration of the association end */
	protected static final String OWNER_NODE_NAME = "owner";

	/** value of the owned by class configuration element */
	protected static final String CLASS_OWNER = "Class";

	/** value of the "navigability" configuration element */
	protected static final String NAVIGABLE_YES = "Yes";

	/** list of composites */
	protected List<PropertyEndComposite> configurationComposites = new ArrayList<PropertyEndComposite>();

	/**
	 * Constructor.
	 */
	public AssociationEndPostAction() {
		configurations = new ArrayList<PropertyEndConfiguration>();
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void init(Node configurationNode, IAspectActionProvider factory) {
		super.init(configurationNode, factory);
		if(configurationNode == null) {
			// creates 2 default configuration property
			PropertyEndConfiguration sourceConfiguration = new PropertyEndConfiguration(0, "source");
			PropertyEndConfiguration targetConfiguration = new PropertyEndConfiguration(1, "target");
			configurations.add(sourceConfiguration);
			configurations.add(targetConfiguration);
			return;
		}
		NodeList childNodes = configurationNode.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); i++) {
			Node featureNode = childNodes.item(i);
			if(ASSOCIATION_END_NODE_NAME.equals(featureNode.getNodeName())) {
				Node indexNode = featureNode.getAttributes().getNamedItem(INDEX_ATTRIBUTE_NAME);
				Node nameNode = featureNode.getAttributes().getNamedItem(NAME_ATTRIBUTE_NAME);

				if(indexNode != null && nameNode != null) {
					Integer index = Integer.parseInt(indexNode.getNodeValue());
					PropertyEndConfiguration configuration = new PropertyEndConfiguration(index, nameNode.getNodeValue());
					// parse sub nodes (aggregation, navigation, etc.)
					NodeList subNodes = featureNode.getChildNodes();
					for(int j = 0; j < subNodes.getLength(); j++) {
						Node subNode = subNodes.item(j);
						String subNodeName = subNode.getNodeName();
						if(AGGREGATION_NODE_NAME.equals(subNodeName)) {
							Node valueNode = subNode.getAttributes().getNamedItem(VALUE_ATTRIBUTE_NAME);
							if(valueNode != null) {
								configuration.setAggregationKind(valueNode.getNodeValue());
							}
						} else if(MULTIPLICITY_NODE_NAME.equals(subNodeName)) {
							Node valueNode = subNode.getAttributes().getNamedItem(VALUE_ATTRIBUTE_NAME);
							if(valueNode != null) {
								configuration.setMultiplicity(valueNode.getNodeValue());
							}
						} else if(NAVIGABLE_NODE_NAME.equals(subNodeName)) {
							Node valueNode = subNode.getAttributes().getNamedItem(VALUE_ATTRIBUTE_NAME);
							if(valueNode != null) {
								configuration.setNavigation(valueNode.getNodeValue());
							}
						} else if(OWNER_NODE_NAME.equals(subNodeName)) {
							Node valueNode = subNode.getAttributes().getNamedItem(VALUE_ATTRIBUTE_NAME);
							if(valueNode != null) {
								configuration.setOwner(valueNode.getNodeValue());
							}
						}

					}
					configurations.add(configuration);
				} else {
					Activator.log.error("Impossible to parse the configuration node for semantic post action", null);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getPostCommand(final IAdaptable viewAdapter) {

		final TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();

		return new AbstractTransactionalCommand(editingDomain, "Modify Association End", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				View view = (View)viewAdapter.getAdapter(View.class);

				if(view != null && view.getElement() instanceof Association) {
					EObject objectToEdit = view.getElement();

					for(PropertyEndConfiguration configuration : configurations) {

						// retrieve Property... more tests to do!!
						Property property = ((Association)objectToEdit).getMemberEnds().get(configuration.getIndex());

						if(!("".equals(configuration.getOwner()))) {
							// change the owner to the specified one
							IUndoableOperation operation = AssociationHelper.createSetOwnerCommand((Association)objectToEdit, property, CLASS_OWNER.equals(configuration.getOwner()));
							if(operation != null && operation.canExecute()) {
								operation.execute(null, null);
							}
						}

						if(!("".equals(configuration.getAggregationKind()))) {
							// change the aggregation kind
							AggregationKind aggregationKind = AggregationKind.get(configuration.getAggregationKind());
							AssociationHelper.createSetAggregationCommand(property, aggregationKind).execute(null, null);
						}

						if(!("".equals(configuration.getMultiplicity()))) {
							// change the aggregation kind
							String multiplicity = configuration.getMultiplicity();
							try {
								int[] values = MultiplicityElementUtil.parseMultiplicity(multiplicity);
								if(values.length == 2) {
									AssociationHelper.createSetMultiplicityCommand(property, values[0], values[1]).execute(null, null);
								}
							} catch (NumberFormatException e) {
								Activator.log.error("Multiplicity [" + multiplicity + "] can not be parsed", e);
							}
						}

						if(!("".equals(configuration.getNavigation()))) {
							String navigation = configuration.getNavigation();
							boolean isNavigable = NAVIGABLE_YES.equals(navigation);
							AssociationHelper.createSetNavigableCommand(((Association)objectToEdit), property, isNavigable).execute(null, null);
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
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
		GridLayout layout = new GridLayout(2, true);
		mainComposite.setLayout(layout);

		Label titleLabel = new Label(mainComposite, SWT.NONE);
		titleLabel.setText("Association end properties");
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		titleLabel.setLayoutData(data);

		for(PropertyEndConfiguration configuration : configurations) {
			PropertyEndComposite composite = new PropertyEndComposite(configuration);
			composite.createComposite(mainComposite);
			configurationComposites.add(composite);
		}
		return mainComposite;
	}

	/**
	 * @{inheritDoc
	 */
	public void save(Node parentNode) {
		if(!(parentNode instanceof Element)) {
			Activator.log.error("parent node is not an Element", null);
			return;
		} else {
			// a sub node should be created for each configuration
			for(PropertyEndConfiguration configuration : configurations) {
				Element associationEndNode = ((Element)parentNode).getOwnerDocument().createElement(ASSOCIATION_END_NODE_NAME);
				associationEndNode.setAttribute(INDEX_ATTRIBUTE_NAME, configuration.getIndex() + "");
				associationEndNode.setAttribute(NAME_ATTRIBUTE_NAME, configuration.getName());

				// save child nodes, if required
				if(!"".equals(configuration.getAggregationKind())) {
					createChildNode(associationEndNode, AGGREGATION_NODE_NAME, configuration.getAggregationKind());
				}
				if(!"".equals(configuration.getMultiplicity())) {
					createChildNode(associationEndNode, MULTIPLICITY_NODE_NAME, configuration.getMultiplicity());
				}
				if(!"".equals(configuration.getNavigation())) {
					createChildNode(associationEndNode, NAVIGABLE_NODE_NAME, configuration.getNavigation());
				}
				if(!"".equals(configuration.getOwner())) {
					createChildNode(associationEndNode, OWNER_NODE_NAME, configuration.getOwner());
				}
				((Element)parentNode).appendChild(associationEndNode);
			}
		}
	}

	/**
	 * Creates a child node to the given element
	 * 
	 * @param parent
	 *        the element owner of the new child node
	 * @param tagName
	 *        the name of the child node
	 * @param value
	 *        the value of the "value" attribute node
	 */
	protected void createChildNode(Element parent, String tagName, String value) {
		Element childNode = parent.getOwnerDocument().createElement(tagName);
		childNode.setAttribute(VALUE_ATTRIBUTE_NAME, value);
		parent.appendChild(childNode);
	}

	/**
	 * Composite to configure the property end
	 */
	protected class PropertyEndComposite {

		/** list of items for the aggregation combo */
		final protected List<String> aggregationItems = Arrays.asList("", AggregationKind.NONE_LITERAL.getName(), AggregationKind.COMPOSITE_LITERAL.getName(), AggregationKind.SHARED_LITERAL.getName());

		/** list of items for the aggregation combo */
		final protected List<String> multiplicityItems = Arrays.asList("", "0..1", "1..1", "0..*", "1..*");

		/** List of items for navigation selection */
		final protected List<String> navigationItems = Arrays.asList("", NAVIGABLE_YES, "No");

		/** List of items for owner selection */
		final protected List<String> ownerItems = Arrays.asList("", CLASS_OWNER, "Association");

		/** property configuration */
		final protected PropertyEndConfiguration configuration;

		/** label for this composite */
		final protected String label;

		/** Combo for aggregation kind selection */
		protected Combo aggregationCombo;

		/** Button to select class as owner of the association end */
		protected Button ownerClassButton;

		/** Button to select association as owner of the association end */
		protected Button ownerAssociationButton;

		/** Combo for navigation selection */
		protected Combo navigationCombo;

		/** Combo for multiplicity selection */
		protected Combo multiplicityCombo;

		/** Combo for owner selection */
		protected Combo ownerCombo;

		/**
		 * Constructor.
		 * 
		 * @param index
		 *        the index of the property in the association ends list
		 */
		public PropertyEndComposite(PropertyEndConfiguration configuration) {
			this.configuration = configuration;
			label = configuration.getName();
		}

		/**
		 * Creates the composite for configuration
		 * 
		 * @param parent
		 *        the composite in which sub-composite should be created
		 */
		public void createComposite(Composite parent) {
			Group mainComposite = new Group(parent, SWT.NONE);
			mainComposite.setText("Property end " + this.label);
			GridLayout layout = new GridLayout(3, false);
			mainComposite.setLayout(layout);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
			mainComposite.setLayoutData(data);

			// aggregation elements
			Label aggregationLabel = new Label(mainComposite, SWT.NONE);
			aggregationLabel.setText("Aggregation");
			aggregationLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));

			aggregationCombo = new Combo(mainComposite, SWT.READ_ONLY);
			aggregationCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			aggregationCombo.setItems(aggregationItems.toArray(new String[]{}));
			aggregationCombo.addFocusListener(new FocusListener() {

				public void focusLost(FocusEvent e) {
					configuration.setAggregationKind(aggregationCombo.getText());
				}

				public void focusGained(FocusEvent e) {

				}
			});

			// owner elements
			Label ownerLabel = new Label(mainComposite, SWT.NONE);
			ownerLabel.setText("Owner");
			ownerLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));

			ownerCombo = new Combo(mainComposite, SWT.READ_ONLY);
			ownerCombo.setItems(ownerItems.toArray(new String[]{}));
			ownerCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			ownerCombo.addSelectionListener(new SelectionListener() {

				/**
				 * @{inheritDoc
				 */
				public void widgetSelected(SelectionEvent e) {
					String value = ((Combo)e.widget).getText();
					configuration.setOwner(value);
				}

				/**
				 * @{inheritDoc
				 */
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});

			// navigation elements
			Label navigationLabel = new Label(mainComposite, SWT.NONE);
			navigationLabel.setText("Navigable");
			navigationLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));

			navigationCombo = new Combo(mainComposite, SWT.READ_ONLY);
			navigationCombo.setItems(navigationItems.toArray(new String[]{}));
			navigationCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			navigationCombo.addSelectionListener(new SelectionListener() {

				/**
				 * @{inheritDoc
				 */
				public void widgetSelected(SelectionEvent e) {
					String value = ((Combo)e.widget).getText();
					configuration.setNavigation(value);
				}

				/**
				 * @{inheritDoc
				 */
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});

			// multiplicity elements
			Label multiplicityLabel = new Label(mainComposite, SWT.NONE);
			multiplicityLabel.setText("Multiplicity");
			multiplicityLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));

			multiplicityCombo = new Combo(mainComposite, SWT.BORDER);
			multiplicityCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			multiplicityCombo.setItems(multiplicityItems.toArray(new String[]{}));
			multiplicityCombo.addFocusListener(new FocusListener() {

				/**
				 * @{inheritDoc
				 */
				public void focusLost(FocusEvent e) {
					// check validity. open a window to ask if we should stay on
					// multiplicity combo or left.
					String newValue = multiplicityCombo.getText();
					if(isMultiplicityValid(newValue.trim())) {
						configuration.setMultiplicity(newValue.trim());
					} else {
						boolean leaveCombo = MessageDialog.openQuestion(multiplicityCombo.getShell(), "Incorrect multiplicity value", "The text [" + newValue + "] is not a valid value.\nDo you really want to leave the combo, losing your modification on multiplicity value?");
						if(!leaveCombo) {
							multiplicityCombo.setFocus();
							multiplicityCombo.setText(newValue);
						} else {
							// restore old value
							multiplicityCombo.setText(configuration.getMultiplicity());
						}
					}
				}

				/**
				 * @{inheritDoc
				 */
				public void focusGained(FocusEvent e) {

				}
			});

			update();
		}

		/**
		 * update the values in the various composites, given the currently hold
		 * values
		 */
		public void update() {
			navigationCombo.select(navigationItems.indexOf(configuration.getNavigation()));
			aggregationCombo.select(aggregationItems.indexOf(configuration.getAggregationKind()));
			ownerCombo.select(ownerItems.indexOf(configuration.getOwner()));
			multiplicityCombo.setText(configuration.getMultiplicity());
		}

		/**
		 * Checks if the multiplicity is valid
		 * 
		 * @param newValue
		 *        the value to check
		 * @return true if the String represents a valid multiplicity
		 */
		private boolean isMultiplicityValid(String newValue) {
			// checks if is only a string
			if(newValue.equals("")) {
				return true;
			}
			try {
				int[] values = MultiplicityElementUtil.parseMultiplicity(newValue);
				if(values.length == 2) {
					int lower = values[0];
					int upper = values[1];

					// returns true if upper = *, otherwise, returns true if
					// upper > lower
					return (upper == -1) ? true : upper >= lower;
				}
				return false;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}

	protected class PropertyEndConfiguration {

		/** current value of the aggregation kind attribute */
		protected String aggregationKind = "";

		/** current value of the owner */
		protected String owner = "";

		/** current value for the navigation */
		protected String navigation = "";

		/** current multiplicity */
		protected String multiplicity = "";

		/** index of the property end */
		protected final int index;

		/** name of the property end */
		protected final String name;

		/**
		 * Returns the name of this configuration (the name of the property end)
		 * 
		 * @return the name of this configuration (the name of the property end)
		 */
		public String getName() {
			return name;
		}

		/**
		 * Returns the index of this configuration (the index of the property
		 * end)
		 * 
		 * @return the index of this configuration (the index of the property
		 *         end
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * Constructor.
		 * 
		 * @param index
		 *        the index of the property end
		 */
		public PropertyEndConfiguration(int index, String name) {
			this.index = index;
			this.name = name;
		}

		/**
		 * Returns the current value of aggregationKind
		 * 
		 * @return the current value of aggregationKind
		 */
		public String getAggregationKind() {
			return aggregationKind;
		}

		/**
		 * Sets the current value of aggregationKind
		 * 
		 * @param aggregationKind
		 *        the aggregationKind to set
		 */
		public void setAggregationKind(String aggregationKind) {
			this.aggregationKind = aggregationKind;
		}

		/**
		 * Returns the current value of owner
		 * 
		 * @return the current value of owner
		 */
		public String getOwner() {
			return owner;
		}

		/**
		 * Sets the current value of owner
		 * 
		 * @param owner
		 *        the owner to set
		 */
		public void setOwner(String owner) {
			this.owner = owner;
		}

		/**
		 * Returns the current value of navigation
		 * 
		 * @return the current value of navigation
		 */
		public String getNavigation() {
			return navigation;
		}

		/**
		 * Sets the current value of navigation
		 * 
		 * @param navigation
		 *        the navigation to set
		 */
		public void setNavigation(String navigation) {
			this.navigation = navigation;
		}

		/**
		 * Returns the current value of multiplicity
		 * 
		 * @return the current value of multiplicity
		 */
		public String getMultiplicity() {
			return multiplicity;
		}

		/**
		 * Sets the current value of multiplicity
		 * 
		 * @param multiplicity
		 *        the multiplicity to set
		 */
		public void setMultiplicity(String multiplicity) {
			this.multiplicity = multiplicity;
		}

	}

}
