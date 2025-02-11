LEARNINGS
  a. Types of shells
			i. Sh -secured shell
			ii. Ksh - korn shell
			iii. Csh -  supports c program
			iv. RestrictedDirectories
			/bin - binary files
			/boot - boot loader files
			/dev - device files
			/etc -system configuration files
			/home - home directories
			/lib - system libraries
			/media - mount point for removable media
			/mnt - mount point for temporary files
			/opt - optional add-on applications
			/sbin - system binaries
			/srv - service data
			/tmp - temporary files
			/usr - user programs 
			/var - variable files
			/root- root user directory
			/proc - process info
			/lost_found - misplaced data
			Ls 
			-i inode number
			-l  long format
			-R all files with sub directories
			-r reverse order
			-t time (newest first)
			-a hidden files
			-h(human readable format)
			-p appending slash to directory names
			-S sort by size
			-d list directories without contents
			--color
			-1
			Creating files
			Cat>file1
			Cat file1
			Cat file1 file2
			Cat "djhfeirufr">> file1
			Cat -n,-s(supress blanks),-v(non-printing characters),-T(tab-^I),-E(end of line -$)
			Touch file2
			Copy/move
			Mv - rename/move
			--backup - makes a backup file for destination file
			Cp same file copying
			-r -recursive
			-I - interactive
			-u - update(copies when source file is new or destination is not found)
			-a - archive (preserves file attributes)
			-v verbose
			-f - forces the copy
			Wc - word count
			-l
			-c(bytes)
			-w
			-m(chars)
			-L (length of longest line)
			Remove -rm
			-f force
			-I interactive
			-r recursive
			-d empty_directories
			Standard linux streams
			0-stdin
			1-stdout
			Stderr-2
			File permissions
			Owner/grp/other
			Read/write/execute
			Symbolic permission 
			Chmod u/g/o(+/-/=)r/w/x file/directory name(we can also use combinations like rw,wx,rwx) 
			For all at once a=rwx(ameans all)
			Using octal
			Read -4
			Write- 2
			Execute -1
			0 - no permission
			Umask is used for default permissions (0002), we can change the umask value to change default permissions for files/directories
			SUID AND GUID
			Chmod u/g+s file/directory(in ls result if 's' then there is execute permission previously , no execute permission results 'S') 
			Variables
			Etc/profile -contains mandatory thigs to be done during start of system , if not found any then it'll move to home/profile and does the same
			Environt ment variables (uses $ symbol and all in caps)
			.bash_profile/history all files in root directory
			Basic utilities
			Pr option filesname - to print (pr -2 filename ,prints in two columns)
			$mail [-s subject] [-c cc-addr] [-b bcc-addr] to-addr]
			Lpr filename - it will send file to printer
			Export SEPARMDB ="mydb"(setting/exporting  environment varible) 
			Unset env_name - to unset environmental variable
			Pies and filters
			|
			Sort filename - sorts the content of the file
			Sort -f filename - capitals are given priority
			Sort numbers - takes ascii values , use -n to sort accroding numbers(like 1,2,3,4..), -r for reverse
			Pg
			File editors
			Gedit -save n exit
			Nano editors -ctrl+o (then name then enter) to save
			Vim editors - 
			Vi -R (read only mode)
			View filename (command mode)
			Yy - copy a line
			P - paste the line
			Nyy - n number of lines copied
			Dd -delete single line
			Ndd - n number of lines deleted
			Cc/ncc - to cut the lines
			Shell scripting
			v.  shell - limits several functonalities to users
			vi. Bash - bourne again shell
		b. Basic shell scripting
			i. Commands should be in order of execution
			ii. #deyfiuhf - to comment the line
			iii. Echo to print lines on console
			iv. Read var_name --> reads from user
			v. To display the variable that has read from the user - $a
		c. Set variables
			i. Name="Kavya" ($Name ->in nextline readonly Name , we will be unable to modify the Name) 
			ii. Unset Name - will unset the varibale 
		d. Special variables
			i. $0 - holds the script/command name
			ii. $1,$2 - holds the arguments passed in command line arguments or if we wnt to run only particular command then $n
			iii. $# - holds the number of arguments passed in command line/it'll check for the all the instructions supplied to script file
			iv. $* - stores the passed varibales to script as strings ,with quites also saves as single string
			v. $@ - without quotes behvaes similar to $* ,with quotes treats as individual (\"$@\")
			vi. $?- exit status of last command executed
			vii. $$ - process id of current shell
			viii. $!- process number of last background command
		e. Shell arrays
			i. Scalar variable - each varibale contains single value
			ii. Array - single varibale contains multiple values
			iii. Name=kavya,Name=divya - it'll store only divya .in order to save both in single varibale array is used
			iv. name[0]=kavya ,name[1]= divya , name[2]=arush - echo "hello,${name[0]/[1]/[2]}"/$name[*/@](to print all) 
			v. Array=(1,2,3,4)/{"kavya","divya"..} -  echo"total elements :${#array[@]}" -gives total elemnts in an array
		f. Shell operators
			i. Arithmetic operators
				1) '+' - 'exp $a +$b' (-, \*, /, %,, =, ==, !=)
			ii. Relational operators
				1) -eq : checks if vaalue of two operands is equal or not. If yes, then condition becomes truw
				2) -ne : not equal then condition true
				3) -gt : greaterthan
				4) -lt : lesser than
				5) -ge : greater than or equl
				6) -le : lesser than or equal
			iii. Boolean operators
				1) ! : inverts the value
				2) -o : logical or
				3) -a : logical and
			iv. String operators
				1) =,!=, 
				2) -z - checks if given string length is zero -if yes true
				3) -n - true if non-zero length
				4) Str - returns false if empty string
			v. Files test operators
				1) -f : tests whether given string is file or not
				2) -d : for directory
				3) -g filename : checks if file has set groupID bit ,if yes then true
				4) -e : file exists or not
				5) -r,-w,-x : checks does file has read ,write , execution permission
		g. Shell decision making
			i. If-else
				1) If..then…….fi
				2) If…..then.…else…fi
				3) If…then…elif…..then….else….fi
			ii. Case_easc
				1) Case varibale in list …..block …another case ….block ……esac
				2) ? - checks for special character
				3)  *   - checks if user have given more than required input
			iii. Control shell loop
				1) Break
				2) Continue
		h. Shell substitution
			i. Commnad-name or $(command-name)
			ii. Running commands in script using with (`ls -l`) or directly
		i. Shell quouting mechanism - to avoid special meaning of characters(exception : `,$,','',\\)
			i. Single quote
			ii. Double quote ((exception : `,$,','',\\)
			iii. Backslash
			iv. Back quote
		j. Shell function
			hello()
			{
			        echo "hello,welocme $1 $2"
			        return 10
			}
			
			hello technical trainer
			
			ret=$?
			
			echo "value returned by function is $ret"
			
			
			func_1()
			{
			        echo "this is the first function"
			        func_2
			}
			
			func_2()
			{
			        echo "this is function 2"
			}
			
			func_1
			
	1. Manual pages
		a. Man commandname
		b. Info commanname
Help commandname![image](https://github.com/user-attachments/assets/c586cbde-dd58-47af-b3a6-8367dc280a01)
