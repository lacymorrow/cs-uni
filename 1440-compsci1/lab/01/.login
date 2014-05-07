#
# Default .login
#
umask 02
set path=(/usr/local/bin /usr/bin /usr/sbin /bin /usr/bin/X11 .)

setenv EDITOR '/usr/local/bin/vi'
setenv PAGER  '/usr/bin/less'
setenv MAILPATH "/var/spool/mail/$USER"
setenv MAIL "/var/spool/mail/$USER"
setenv TMPDIR '/tmp'

set ignoreeof
set noclobber
set notify
# limit number of processes to 75
ulimit -u 75
