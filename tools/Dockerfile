FROM centos:latest

ENV container docker

# Fix for CentOS-8 End Of Life
RUN sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-* && \
    sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-* && \
    dnf makecache && \
    dnf update -y

RUN dnf update -y && dnf install -y \
   gawk make wget tar bzip2 gzip python3 unzip perl patch libevent \
   diffutils diffstat git cpp gcc gcc-c++ glibc-devel chrpath socat \
   perl-Data-Dumper perl-Text-ParseWords perl-Thread-Queue libatomic \
   python3-pip xz which SDL-devel xterm file zstd tar cpio hostname tmux \
   lz4 ncurses ncurses-devel ncurses-base ncurses-compat-libs vim-enhanced

RUN dnf --enablerepo=powertools install -y \
   rpcgen
   
RUN pip3 install GitPython jinja2 packaging kas
ENV LANG en_US.UTF-8

# Add a custom make version because the default 4.2.1 is not supported by yocto.
RUN mkdir /root/src && pushd /root/src && wget https://ftp.gnu.org/gnu/make/make-4.3.tar.gz && \
   tar -xzvf make-4.3.tar.gz && cd make-4.3 && ./configure --prefix=/usr && make -j $(nproc) && make install && popd 
RUN rm -rf /root/src


ARG group_id=100
ARG user_id=100
ARG username=yocto

# Add the user group before adding the user
RUN groupadd -g $group_id $username

# Add the caller user to the docker without any home folder
RUN useradd -p '' -M -g $group_id -u $user_id -s /bin/bash $username -d /home/${username}
