#!/bin/sh
#
#All rights reserved. This program and the accompanying materials
#are made available under the terms of the Eclipse Public License v1.0
#which accompanies this distribution, and is available at
#http://www.eclipse.org/legal/epl-v10.html
# Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and Implementation
# Ansgar Radermacher (CEA-LIST) ansgar.radermarcher@cea.fr - Initial API and Implementation


#this function create a psf file in $generated_psf_folder
#this function takes arguments : 
#        - the first argument is the psf file name without its extension
#        - the others arguments are the path of the repository to download 
create_psf_file(){
	beginningString='<project reference="0.9.3,'
	endString='"/>'
	endProvider='</provider>'
	beginWorkingSet='<workingSets editPageId="org.eclipse.jdt.ui.JavaWorkingSetPage"'
	endWorkingSet='</workingSets>'
	fileName=$1
	psf_ssh_file_name=$fileName"_svn_ssh.psf"
	wgetLog=$psf_workspace"/logfile.log"	
	shift
	#create an array for the path
	declare -a paths
	for path in "$@"
	do
		paths[${#paths[*]}]=$path #add the path to the end of the array
	shift
	done
	

	#we do the download 
	mkdir $svn
	cd $svn	
	for path in ${paths[@]}
	do
		wget -r -np -A .project $path -o $wgetLog -nv
	done
	rm $wgetLog
	find -depth -type d -empty -exec rmdir {} \;


#---firstly we create the svn+ssh file
#---begin the XML file
	echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>">>$generated_psf_folder/$psf_ssh_file_name
	echo "<psf version=\"2.0\">">>$generated_psf_folder/$psf_ssh_file_name
	echo "<provider id=\"org.tigris.subversion.subclipse.core.svnnature\">">>$generated_psf_folder/$psf_ssh_file_name

#---Fill the file with the projects to download
#see http://forum.ubuntu-fr.org/post.php?tid=932861 for FOLDERNAME
	for FULL_PATH_FOLDER in `find . -name ".project"`
		do
			FOLDERNAME=$(echo $FULL_PATH_FOLDER | grep -oE "[^/]*/[^/]*$" )
			echo $beginningString$FULL_PATH_FOLDER','$FOLDERNAME$endString>>$generated_psf_folder/$psf_ssh_file_name
	done
	echo $endProvider>>$generated_psf_folder/$psf_ssh_file_name

	#Create the Working Set

	# --- all files
	find .  > allFiles
	# --- filter those ending with .project (and preceding folders)
	grep  -B 1 ".*\/\.project" allFiles > dotProjectFiles

	#--- iterate on the diff to create the WorkingSets
	for folder in `diff allFiles dotProjectFiles | grep "\<" | grep ".\/dev.eclipse.org" | cut -d " " -f 2`
		do
			first=1
			for subFolder in `ls $folder/*/.project 2> /dev/null` #sed "s/\/.project//g"`
				do
					if [ "$first" = 1 ];
					then
						#remove the name of the source folder (sometimes useful, sometimes useless)
						layerName=$folder
						for path in ${paths[@]}
							do
							   	sourceFolderName=`echo ${path/http:\//.}` #replace "http:/" by "."
								sourceFolderName=`echo ${sourceFolderName%?}` #remove the last character which is a "/"
								layerName=`echo ${layerName/$sourceFolderName/}`
								if [ -z $layerName ];#if null, the project is not in a layer
								then
								   layerName=$(echo $sourceFolderName | grep -oE "[^/]*/*$" )
								   break
								fi;
						done
						
						
						#if the first char is /, we remove it
						if [[ `echo ${layerName} | cut -c1` = '/' ]];
						then
							layerName=`echo $layerName | cut -b 1-1 --complement`;
						fi;
						#replace all / by a .
						layerName=`echo ${layerName//\//.}`
						echo '<workingSets editPageId="org.eclipse.jdt.ui.JavaWorkingSetPage" id="'$workingSetId'" label="'$layerName'" name="'$layerName'">' >> $generated_psf_folder/$psf_ssh_file_name
						workingSetId=$((workingSetId +1))
						first=0;
					fi;
				subFolderName=$(echo $subFolder | grep -oE "[^/]*/[^/]*$" )	
				echo '<item elementID="='$subFolderName'" factoryID="org.eclipse.jdt.ui.PersistableJavaElementFactory"/>' >> $generated_psf_folder/$psf_ssh_file_name
			done
			if [ "$first" = 0 ] ;then
				echo '</workingSets>' >> $generated_psf_folder/$psf_ssh_file_name;
			fi
	done

	#---end the XML file
	echo "</psf>">>$generated_psf_folder/$psf_ssh_file_name

	#---correct the generated psf
	#	.../myProjectName/.project -> .../myProjectName
	sed -i "s/\/.project//g" $generated_psf_folder/$psf_ssh_file_name
	#add http:\ after 0.9.3,
	sed -i "s/0\.9\.3,\./0\.9\.3,svn+ssh:\//g" $generated_psf_folder/$psf_ssh_file_name

	#---remove some created files created by this method
	rm allFiles dotProjectFiles
	cd $psf_workspace
	rm -R -f $svn
	#---copy the file to create the http file
	psf_http_file_name=$fileName"_http.psf"
	cp $generated_psf_folder/$psf_ssh_file_name $generated_psf_folder/$psf_http_file_name
	sed -i "s/svn+ssh/http/g" $generated_psf_folder/$psf_http_file_name
}


begin=$(date +'%T')
# This script downloads the folders which contains a file .project from a repository and create the psf file to download it using Eclipse
workingSetId=0

#---create the following hierarchy : 
#$HOME/psf_workspace
#$HOME/psf_workspace/svn
#$HOME/psf_workspace/generated_psf_folder
psf_workspace=$HOME/"psf_workspace"
svn=$psf_workspace/"svn"
generated_psf_folder=$psf_workspace/"generated_psf_folder"

#the path of the folder to download
extraplugins_path="http://dev.eclipse.org/svnroot/modeling/org.eclipse.mdt.papyrus/trunk/extraplugins/"
plugins_path="http://dev.eclipse.org/svnroot/modeling/org.eclipse.mdt.papyrus/trunk/plugins/"
tests_path="http://dev.eclipse.org/svnroot/modeling/org.eclipse.mdt.papyrus/trunk/tests/"
releng_path="http://dev.eclipse.org/svnroot/modeling/org.eclipse.mdt.papyrus/trunk/releng/"
features_path="http://dev.eclipse.org/svnroot/modeling/org.eclipse.mdt.papyrus/trunk/features/"
full_papyrus="http://dev.eclipse.org/svnroot/modeling/org.eclipse.mdt.papyrus/trunk/"
rm -R -f $psf_workspace

mkdir $psf_workspace
mkdir $generated_psf_folder


#--------create the extraplugin psf
create_psf_file "extraplugins" $extraplugins_path

#--------create the plugin psf
create_psf_file "plugins" $plugins_path

#--------create the tests psf
create_psf_file "tests" $tests_path

#--------create the build psf
create_psf_file "build" $releng_path $features_path

#--------full papyrus psf
create_psf_file "full_papyrus" $full_papyrus

echo "The created psf are in the folder: "$generated_psf_folder
end=$(date +'%T')
echo "began at: "$begin
echo "ended at: "$end