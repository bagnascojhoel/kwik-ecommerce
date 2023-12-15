This uses git submodules. When cloning, the submodules' content will not be downloaded. You need
to run `git submodule init` then `git submodule update`. Or you can just add this option to the git
clone command `--recurse-submodules`.

If you are in a different branch, and add a submodule there, when you go back to `main`, the 
submodule will not be there. You will need to do the checkout with `--recurse-submodules`.

Another way of handling this issues with submodules is to tell git to always use 
`--recurse-submodules`. You can do that with the config `git config submodule.recurse true`. This
will work for every command that accepts a `--recurse-submodules`, except the clone command.