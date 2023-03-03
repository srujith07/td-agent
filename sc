#!/bin/bash

# set the path to the file you want to check
filepath="/path/to/file"

# check if the file is larger than 3GB and delete it if it is
if [ $(stat -c%s "$filepath") -gt $((3*1024*1024*1024)) ]; then
    rm "$filepath"
fi
