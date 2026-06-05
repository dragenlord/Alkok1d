FROM ubuntu:latest
LABEL authors="KMalk"

ENTRYPOINT ["top", "-b"]