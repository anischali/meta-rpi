#! /bin/bash


video_device="$1"
stream_uri="$2"


ffmpeg -f v4l2 -framerate 25 -video_size 640x480 -i ${video_device} -f rtsp -rtsp_transport tcp ${stream_uri} 2> /dev/null;