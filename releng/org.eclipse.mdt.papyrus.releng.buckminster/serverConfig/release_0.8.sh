#!/bin/bash -x

# This script promotes a build present in the source area to a target area, saving what is present in the target area

# Variables area
PAPYRUS_UPDATES_AREA=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates
SOURCE_SITE=$PAPYRUS_UPDATES_AREA/integration/0.8.0
TARGET_SITE=$PAPYRUS_UPDATES_AREA/milestones/0.8
SAVE_OLD_TARGET_SITE=$TARGET_SITE/old
logFile=/opt/public/modeling/mdt/papyrus/log-cronRelease
DATE=`date +%Y%m%d-%H%M`

# Script Area

# 1. Delete what is in the save area
# 2. Move what is in target into the save area
# 3. Copy what is in source into target

echo "$DATE: removing folder old" >> $logFile
rm -rvf $SAVE_OLD_TARGET_SITE >> $logFile
mkdir $SAVE_OLD_TARGET_SITE
mdir $SAVE_OLD_TARGET_SITE/features
mdir $SAVE_OLD_TARGET_SITE/plugins

echo "$DATE: moving target to save area" >> $logFile
mv -v $TARGET_SITE/features/* $SAVE_OLD_TARGET_SITE/features >> $logFile
mv -v $TARGET_SITE/plugins/* $SAVE_OLD_TARGET_SITE/plugins >> $logFile
mv -v $TARGET_SITE/* $SAVE_OLD_TARGET_SITE >> $logFile

echo "$DATE: copy source to target" >> $logFile
cp -vr $SOURCE_SITE/* $TARGET_SITE >> $logFile

echo "$DATE: done" >> $logFile