How to regenerate:
- launch a runtime instance of Eclipse
- open timingdiagram.gmfgen
- right-click the root element (the ResourceSet), and choose "Generate Papyrus Diagram"
- select the "src" folder, and do a regex replace of: 
    @generated\R \*/\R(public (?:abstract )?class)
  to:
    @generated\R */\R@SuppressWarnings("all")\R// disable warnings on generated code\R\1
- select the "org.eclipse.papyrus.uml.diagram.timing" project in the development Eclipse, and do "Source > Clean Up..." in the main menu (with Eclipse >= 4.3M4 or patch from Bug 394296 applied)
- with EGit, select the project and do "Team > Add to Index" so that the files don't appear as new


pay attention to these modifications in generated code:
- UMLEditPartFactory#getTextCellEditorLocator : modified in the super class instead of overridden because it is static
- CustomPaletteFactory in plugin.xml

to reset the generated src folder from git:
git checkout HEAD -- src && git clean -f src