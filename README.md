- Init project
- Create branch with API, Add number model
- API, add file in hunks

```
$ git add -N $file
$ git add -p
```

- Modify model to have status code, create new commit and rebase interactively


```
git add -p
git checkout -p 
git rebase -i
git stash -p
```

# I want to...

## Add only parts of the file to be staged

Use `git add -p` to select hunks or lines to be staged.

## Add only parts of the new file to be staged

First let git know that you want to add this file by calling `git add -N $fileName` (otherwise you cannot "patch" a file git didn't add previously) and then proceed with regular patch `git add -p`

```
$ git add -N $file
$ git add -p
```

During patching you can split hunks by manually editing which lines will be included.

> To remove '-' lines, make them ' ' lines (context).
> To remove '+' lines, delete them.
> Lines starting with # will be removed.
> If the patch applies cleanly, the edited hunk will immediately be marked for staging.
> If it does not apply cleanly, you will be given an opportunity to
> edit again.  If all lines of the hunk are removed, then the edit is
> aborted and the hunk is left unchanged.


## Restore parts of a file after modifying it without commit

Use `git checkout -p` to restore modified parts

## Stash parts of the file to a named stash

Use `git stash -p -m "$NAME"`

## Rebase on top of a different branch

`git rebase -i $branchName`

```

p, pick <commit> = use commit
r, reword <commit> = use commit, but edit the commit message
e, edit <commit> = use commit, but stop for amending
s, squash <commit> = use commit, but meld into previous commit
f, fixup <commit> = like "squash" but keep only the previous commit
b, break = stop here (continue rebase later with 'git rebase --continue')
d, drop <commit> = remove commit (the same as removing a line)

```

## Edit Xth recent commit

Use rebase against your HEAD, e.g.

`rebase -i HEAD~X`

And edit selected commit by changing `pick` to `edit`. You may add new files and amend them to the edited commit or split it further by calling `git reset HEAD^` and creating new
commits.

## Rebase a branch dropping merge commits 

```
git rebase -i master --reapply-cherry-picks --rebase-merges
```

## Rebase a branch (B) on top of another branch (A) while diverging from another branch (C)

If you're a C diverged from B but want to rebase onto A you
can do

```
rebase -i --onto A B C
```

## Go back in time

`git reflog` to see all your operations (the full path of your HEAD). `git reset --hard $SHA` to return to that point

## Learn what is my current HEAD

`HEAD` is a symbollic file in `.git`. Call `cat .git/HEAD` to see the ref point or a direct git object if you're in DETACHED state.

## Learn what's inside .git directory

`.git` directory contains history of all your operations (like in shell), objects, files,
configs, logs, hooks, current and previous HEAD.

To investigate `objects` directory, use `git cat-file -p $SHA-1` where `$SHA-1` stands for
hash on an interesting object or a pointer (branch name, HEAD). Hashes are stored in `object`
file tree where directory name is two first characters of the hash and contents are rest.

Objects are either `tree`s (directories) or `blobs` (files). To check the type, use `git
cat-file -t $SHA-1`

## Restore lost stuff

Use 

```
$ git fsck --full
```

to see any lost objects.
