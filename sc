#!/bin/bash

# set the path to the file you want to check
filepath="/path/to/file"

# check if the file is larger than 3GB and delete it if it is
if [ $(stat -c%s "$filepath") -gt $((3*1024*1024*1024)) ]; then
    rm "$filepath"
fi

#!/bin/bash

# set the path and filename of the file to be truncated
file_path="/path/to/file"
file_name="filename"

while true; do
    # get the size of the file in bytes
    file_size=$(stat --format="%s" "${file_path}/${file_name}")

    # check if the file size is greater than 3GB
    if [[ "$file_size" -gt 3221225472 ]]; then
        # truncate the file
        truncate -s 0 "${file_path}/${file_name}"
    fi

    # wait for 5 minutes
    sleep 300
done
