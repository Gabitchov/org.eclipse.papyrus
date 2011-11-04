<?xml version="1.0" encoding="ASCII"?>
<xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:di="http://www.eclipse.org/papyrus/0.7.0/sashdi" xmlns:org.eclipse.papyrus.table.instance.papyrustableinstance="http://www.eclipse.org/Papyrus/Table/0.8.0/papyrustableinstance" xmlns:tableinstance="http://www.eclipse.org/EMF_Facet/ModelCellEditor/0.1.0/tableinstance" xmlns:tableinstance2="http://www.eclipse.org/EMF_Facet/Table/0.1.0/tableinstance2" xmlns:uicustom="http://www.eclipse.org/EmfFacet/infra/browser/custom/0.8">
  <di:SashWindowsMngr>
    <pageList>
      <availablePage>
        <emfPageIdentifier href="model.notation#_8N4C4Aa-EeGLTf5WTnj-wA"/>
      </availablePage>
      <availablePage>
        <emfPageIdentifier href="model.notation#_8RmsUAa-EeGLTf5WTnj-wA"/>
      </availablePage>
      <availablePage>
        <emfPageIdentifier href="model.notation#_8RwdUga-EeGLTf5WTnj-wA"/>
      </availablePage>
      <availablePage>
        <emfPageIdentifier href="model.notation#_8RwdVAa-EeGLTf5WTnj-wA"/>
      </availablePage>
      <availablePage emfPageIdentifier="/1"/>
      <availablePage emfPageIdentifier="/3"/>
    </pageList>
    <sashModel currentSelection="/0/@sashModel/@windows.0/@children.0">
      <windows>
        <children xsi:type="di:TabFolder">
          <children>
            <emfPageIdentifier href="model.notation#_8N4C4Aa-EeGLTf5WTnj-wA"/>
          </children>
          <children>
            <emfPageIdentifier href="model.notation#_8RmsUAa-EeGLTf5WTnj-wA"/>
          </children>
          <children>
            <emfPageIdentifier href="model.notation#_8RwdUga-EeGLTf5WTnj-wA"/>
          </children>
          <children>
            <emfPageIdentifier href="model.notation#_8RwdVAa-EeGLTf5WTnj-wA"/>
          </children>
          <children emfPageIdentifier="/1"/>
          <children emfPageIdentifier="/3"/>
        </children>
      </windows>
    </sashModel>
  </di:SashWindowsMngr>
  <org.eclipse.papyrus.table.instance.papyrustableinstance:PapyrusTableInstance name="AllocationTable" type="PapyrusAllocationTable" table="/2"/>
  <tableinstance2:TableInstance2 description="Table Description">
    <tableConfiguration href="../../plugin/org.eclipse.papyrus.sysml.table.allocation/resources/allocate.tableconfiguration2#/"/>
    <customizations href="#/2/@localCustomizations.0"/>
    <customizations href="#/2/@localCustomizations.1"/>
    <customizations href="emffacet:/customization/SysMLDefaultExplorerCustomization#/"/>
    <context href="model.uml#_8G4DAAa-EeGLTf5WTnj-wA"/>
    <columns xsi:type="tableinstance:DefaultLabelColumn"/>
    <columns xsi:type="tableinstance:MetaClassColumn"/>
    <columns xsi:type="tableinstance:EContainerColumn"/>
    <localCustomizations metamodelURI="http://www.eclipse.org/emf/2002/Ecore">
      <types metaclassName="ecore.EModelElement">
        <references referenceName="eAnnotations">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
    </localCustomizations>
    <localCustomizations metamodelURI="http://www.eclipse.org/uml2/3.0.0/UML" allQuerySetsAvailable="false">
      <types metaclassName="uml.Element">
        <references referenceName="ownedElement">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="owner">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedComment">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.NamedElement">
        <attributes attributeName="name">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <attributes attributeName="visibility">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <attributes attributeName="qualifiedName">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <references referenceName="clientDependency">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="namespace">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="nameExpression">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.ParameterableElement">
        <references referenceName="owningTemplateParameter">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="templateParameter">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.Relationship">
        <references referenceName="relatedElement">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.DirectedRelationship">
        <references referenceName="source">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="target">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.Abstraction">
        <references referenceName="mapping">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
    </localCustomizations>
  </tableinstance2:TableInstance2>
  <org.eclipse.papyrus.table.instance.papyrustableinstance:PapyrusTableInstance name="RequirementTable" type="PapyrusRequirementTable" table="/4"/>
  <tableinstance2:TableInstance2 description="Table Description">
    <tableConfiguration href="../../plugin/org.eclipse.papyrus.sysml.table.requirement/resources/requirements.tableconfiguration2#/"/>
    <customizations href="#/4/@localCustomizations.0"/>
    <customizations href="#/4/@localCustomizations.1"/>
    <customizations href="#/4/@localCustomizations.2"/>
    <customizations href="emffacet:/customization/SysMLDefaultExplorerCustomization#/"/>
    <context href="model.uml#_8G4DAAa-EeGLTf5WTnj-wA"/>
    <columns xsi:type="tableinstance:DefaultLabelColumn"/>
    <columns xsi:type="tableinstance:MetaClassColumn" isHidden="true"/>
    <columns xsi:type="tableinstance:EContainerColumn" isHidden="true"/>
    <localCustomizations metamodelURI="http://www.eclipse.org/emf/2002/Ecore">
      <types metaclassName="ecore.EModelElement">
        <references referenceName="eAnnotations">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
    </localCustomizations>
    <localCustomizations metamodelURI="http://www.eclipse.org/uml2/3.0.0/UML" allQuerySetsAvailable="false">
      <types metaclassName="uml.Element">
        <references referenceName="ownedElement">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="owner">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedComment">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.NamedElement">
        <attributes attributeName="name">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <attributes attributeName="visibility">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <attributes attributeName="qualifiedName">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <references referenceName="clientDependency">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="namespace">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="nameExpression">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.Namespace">
        <references referenceName="elementImport">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="packageImport">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedRule">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="member">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="importedMember">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedMember">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.RedefinableElement">
        <attributes attributeName="isLeaf">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <references referenceName="redefinedElement">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="redefinitionContext">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.ParameterableElement">
        <references referenceName="owningTemplateParameter">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="templateParameter">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.Type">
        <references referenceName="package">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.TemplateableElement">
        <references referenceName="templateBinding">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedTemplateSignature">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.Classifier">
        <attributes attributeName="isAbstract">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <references referenceName="generalization">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="powertypeExtent">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="feature">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="inheritedMember">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="redefinedClassifier">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="general">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="substitution">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="attribute">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="representation">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="collaborationUse">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedUseCase">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="useCase">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.StructuredClassifier">
        <references referenceName="ownedAttribute">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="part">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="role">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedConnector">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.EncapsulatedClassifier">
        <references referenceName="ownedPort">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.BehavioredClassifier">
        <references referenceName="ownedBehavior">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="classifierBehavior">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="interfaceRealization">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedTrigger">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
      <types metaclassName="uml.Class">
        <attributes attributeName="isActive">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </attributes>
        <references referenceName="nestedClassifier">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedOperation">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="superClass">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="ownedReception">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
        <references referenceName="extension">
          <customizedFeatures>
            <defaultValue xsi:type="uicustom:StaticFeatureValue" value="false"/>
          </customizedFeatures>
        </references>
      </types>
    </localCustomizations>
    <localCustomizations metamodelURI="http://www.eclipse.org/papyrus/sysml/requirements/SysMLRequirementsFacetSet.facetSet" allQuerySetsAvailable="false"/>
    <facets2 href="http://www.eclipse.org/papyrus/sysml/requirements/SysMLRequirementsFacetSet.facetSet#//Requirement"/>
  </tableinstance2:TableInstance2>
</xmi:XMI>
