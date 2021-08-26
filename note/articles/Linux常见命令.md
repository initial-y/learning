# Linux常见命令

## ssh链接

`ssh root@地址`

## 命令

### 命令行提示

```text
-- 命令提示符
[root@iZbp18k2vy63d20ys3onymZ ~]#
```

- root: 当前用户名

> 执行`whoami`可以查看当前用户名

- @xxx: @后为主机名

> 执行`hostname`可以查看当前主机名

- ~: 表示当前为家目录

  > `root` 用户的家目录是 `/root` 普通用户的家目录在 `/home` 下

- #: 当前用户所拥有的权限

  > root用户为#, 普通用户为$

### 命令格式

命令 + 参数

- 长短参数

  ```text
  单个参数：ls -a（a 是英文 all 的缩写，表示“全部”）
  多个参数：ls -al（全部文件 + 列表形式展示）
  单个长参数：ls --all
  多个长参数：ls --reverse --all
  长短混合参数：ls --all -l
  ```

- 参数值

  ```text
  短参数：command -p 10（例如：ssh root@121.42.11.34 -p 22）
  长参数：command --paramters=10（例如：ssh root@121.42.11.34 --port=22）
  ```

## 常用快捷键

- `↑↓`键: 上下翻执行过的Linux命令;

- `Tab`键: 按一次`Tab`命令/参数补全, 按两次`Tab`列出所有可能的命令/参数;

- `ctrl + r`: **搜索**过往执行的命令;

- `history`: **查看**历史执行过的命令, 输入`! + 命令编号`即可执行历史命令;

- `ctrl + l`: 清除屏幕

  > `clear`: 也有清除屏幕的效果

- `ctrl + c` : 终止当前正在执行的命令

- `ctrl + u`: 从光标位置**剪切到行首**

- `ctrl + k`: 从光标位置**剪切到行尾**

- `ctrl + w`: 从光标位置**左侧剪切一个单词**

  > 空格也会被剪切

- `ctrl + y` : 粘贴`ctrl + u/k/w`剪切的内容

- `ctrl + a`: 光标调至命令行的**开头**

- `ctrl + e`: 光标跳至命令行的**结尾**

- `ctrl +d`: 关闭当前Shell会话

## 文件和目录

### 文件组织结构

```
-

```

### 文件路径

- `pwd`: 显示当前目录

  ```
  [root@iZbp18k2vy63d20ys3onymZ local]# pwd
  /usr/local
  ```

  ​	

- `which` : 查看命令的**可执行文件**的路径

  > `Linux` 下，每一条命令其实都对应一个可执行程序，在终端中输入命令，按回车的时候，就是执行了对应的那个程序， `which` 命令本身对应的程序也存在于 `Linux` 中。

  ```text
  [root@iZbp18k2vy63d20ys3onymZ ~]# which nginx
  /usr/sbin/nginx
  
  [root@iZbp18k2vy63d20ys3onymZ ~]# which which
  alias which='(alias; declare -f) | /usr/bin/which --tty-only --read-alias --read-functions --show-tilde --show-dot'
          /usr/bin/which
  ```

- 切换和浏览目录

  - `ls`

    >常用参数:
    >
    >- `-a` 显示所有文件和目录包括隐藏的
    >- `-l` 显示详细列表
    >- `-h` 适合人类阅读的
    >- `-t` 按文件最近一次修改时间排序
    >- `-i` 显示文件的 `inode` （ `inode` 是文件内容的标识）

    ```text
    [root@iZbp18k2vy63d20ys3onymZ ~]# cd /usr/
    
    [root@iZbp18k2vy63d20ys3onymZ usr]# ls
    app  bin  games  include  lib  lib64  libexec  local  sbin  share  src  tmp
    
    [root@iZbp18k2vy63d20ys3onymZ usr]# ls -a
    .  ..  app  bin  games  include  lib  lib64  libexec  local  sbin  share  src  tmp
    
    [root@iZbp18k2vy63d20ys3onymZ usr]# ls -l
    total 160
    drwxr-xr-x    2 root root    22 May 28 10:40 app
    dr-xr-xr-x.   2 root root 32768 May 31 21:53 bin
    drwxr-xr-x.   2 root root     6 May 11  2019 games
    drwxr-xr-x.  32 root root  4096 Feb 18  2020 include
    dr-xr-xr-x.  39 root root  4096 May 27 18:26 lib
    dr-xr-xr-x.  53 root root 36864 May 31 21:53 lib64
    drwxr-xr-x.  31 root root  4096 May 27 18:26 libexec
    drwxr-xr-x.  13 root root   144 May 31 21:55 local
    dr-xr-xr-x.   2 root root 16384 Jun 22 00:36 sbin
    drwxr-xr-x. 113 root root  4096 May 31 21:53 share
    drwxr-xr-x.   4 root root    34 Feb 18  2020 src
    lrwxrwxrwx.   1 root root    10 May 11  2019 tmp -> ../var/tmp
    
    [root@iZbp18k2vy63d20ys3onymZ usr]# ls -h
    app  bin  games  include  lib  lib64  libexec  local  sbin  share  src  tmp
    
    [root@iZbp18k2vy63d20ys3onymZ usr]# ls -t
    sbin  local  bin  lib64  share  app  libexec  lib  include  src  games  tmp
    
    [root@iZbp18k2vy63d20ys3onymZ usr]# ls -i
      222726 app  16777347 bin  50493224 games  16957655 include  50331803 lib  33575047 lib64  33738529 libexec  50493228 local  33575045 sbin  50331805 share  50493568 src    106933 tmp
      
    
    [root@iZbp18k2vy63d20ys3onymZ usr]# ls -alhti
    total 160K
    33575045 dr-xr-xr-x.   2 root root  16K Jun 22 00:36 sbin
    50493228 drwxr-xr-x.  13 root root  144 May 31 21:55 local
    16777347 dr-xr-xr-x.   2 root root  32K May 31 21:53 bin
    33575047 dr-xr-xr-x.  53 root root  36K May 31 21:53 lib64
    50331805 drwxr-xr-x. 113 root root 4.0K May 31 21:53 share
      222726 drwxr-xr-x    2 root root   22 May 28 10:40 app
         142 drwxr-xr-x.  13 root root  155 May 28 10:40 .
    33738529 drwxr-xr-x.  31 root root 4.0K May 27 18:26 libexec
    50331803 dr-xr-xr-x.  39 root root 4.0K May 27 18:26 lib
         128 dr-xr-xr-x.  17 root root  244 Apr  2 10:05 ..
    16957655 drwxr-xr-x.  32 root root 4.0K Feb 18  2020 include
    50493568 drwxr-xr-x.   4 root root   34 Feb 18  2020 src
    50493224 drwxr-xr-x.   2 root root    6 May 11  2019 games
      106933 lrwxrwxrwx.   1 root root   10 May 11  2019 tmp -> ../var/tmp
    
    		
    ```

  - `cd`: 	`change directory`, 切换目录

    > cd /	--> 跳转到根目录
    > cd ~	--> 跳转到家目录, root用户家目录为`/root`, 普通用户家目录为`/home`
    > cd ..	--> 跳转到上级目录
    > cd ./home	--> 跳转到当前目录的home目录下
    > cd /home/xx--> 跳转到根目录下的home目录下的xx目录
    > cd	--> 不添加任何参数，也是回到家目录

  - `du`: 列举目录大小信息

    > 常用参数:
    >
    > - `-h` 适合人类阅读的
    > - `-a` 同时列举出目录下文件的大小信息
    > - `-s` 只显示总计大小，不显示具体信息

    ```text
    [root@iZbp18k2vy63d20ys3onymZ app]# du
    0       ./test
    78376   .
    
    [root@iZbp18k2vy63d20ys3onymZ app]# du -h
    0       ./test
    77M     .
    
    [root@iZbp18k2vy63d20ys3onymZ app]# du -a
    78376   ./halo.jar
    0       ./test
    78376   .
    
    [root@iZbp18k2vy63d20ys3onymZ app]# du -s
    78376   .
    
    ```

### 浏览和创建文件

- `cat`: 一次性查看所有文件内容, 适合查看较小的文件

  > `cat nginx.conf`

- `less`: 分页显示文件内容, 适合查看大文件

  > 快捷操作:
  >
  > 空格键：前进一页（一个屏幕）；
  >
  > `b` 键：后退一页；
  >
  > 回车键：前进一行；
  >
  > `y` 键：后退一行；
  >
  > 上下键：回退或前进一行；
  >
  > `d` 键：前进半页；
  >
  > `u` 键：后退半页；
  >
  > `q` 键：停止读取文件，中止 `less` 命令；
  >
  > `=` 键：显示当前页面的内容是文件中的第几行到第几行以及一些其它关于本页内容的详细信息；
  >
  > `h` 键：显示帮助文档；
  >
  > `/` 键：进入搜索模式后，按 `n` 键跳到下一个符合项目，按 `N` 键跳到上一个符合项目，同时也可以输入正则表达式匹配。
  >
  > 更多操作可以使用`man help` 查看操作手册

- `more`: 提供逐页查看文件的功能, 与`less`相比, 提供的功能更简单基础.

  > 快捷操作: 
  >
  > - 空格键：前进一页（一个屏幕）；
  >
  > - `b` 键：后退一页；
  >
  > 参数:
  >
  > - -num 一次显示的行数
  > - -d 提示使用者，在画面下方显示 [Press space to continue, 'q' to quit.] ，如果使用者按错键，则会显示 [Press 'h' for instructions.] 而不是 '哔' 声
  > - -l 取消遇见特殊字元 ^L（送纸字元）时会暂停的功能
  > - -f 计算行数时，以实际上的行数，而非自动换行过后的行数（有些单行字数太长的会被扩展为两行或两行以上）
  > - -p 不以卷动的方式显示每一页，而是先清除萤幕后再显示内容
  > - -c 跟 -p 相似，不同的是先显示内容再清除其他旧资料
  > - -s 当遇到有连续两行以上的空白行，就代换为一行的空白行
  > - -u 不显示下引号 （根据环境变数 TERM 指定的 terminal 而有所不同）
  > - +/pattern 在每个文档显示前搜寻该字串（pattern），然后从该字串之后开始显示
  > - +num 从第 num 行开始显示

- `head` : 显示文件的头n行(默认10)

  > `head -n 100 nginx.conf`

- `tail` : 显示文件的末尾几行

  >-n: 指定行数
  >
  >-f : 会每过1秒检查下文件是否有更新内容，也可以用 `-s` 参数指定间隔时间 `tail -f -s 4 xxx.log` 

- `touch`: 创建一个文件

  > `touch test.xml`

- `mkdir`: 创建一个文件夹

  > `mkdir test`_folder
  >
  > - `-p` 递归的创建目录结构 `mkdir -p one/two/three` 

### 文件的复制和移动

- `cp` : 拷贝文件或者目录

  > cp file file_copy	--> file 是目标文件，file_copy 是拷贝出来的文件
  > cp file one	--> 把 file 文件拷贝到 one 目录下，并且文件名依然为 file
  > cp file one/file_copy	--> 把 file 文件拷贝到 one 目录下，文件名为file_copy
  > cp *.txt folder	--> 把当前目录下所有 txt 文件拷贝到 folder 目录下
  >
  > cp -r floder 递归拷贝 , 用来拷贝一整个目录 

- `mv`: **移动或重命名**文件

  > mv file one	--> 将 file 文件移动到 one 目录下
  > mv new_folder one	--> 将 new_folder 文件夹移动到one目录下
  > mv *.txt folder	--> 把当前目录下所有 txt 文件移动到 folder 目录下
  > mv file new_file	--> file 文件重命名为 new_file

### 文件的删除和链接

