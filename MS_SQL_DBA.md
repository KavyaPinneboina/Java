MS-SQL DBA

25 November 2024
10:08

	Ø Primary key
	Ø Foreign key of a table must n should be primary key of some other table
	Ø Candidate key - one or more columns that could serve as primary key (one of these is set to primary key and another is called alternate key)
	Ø Alrenate key -another candidate key which is not primary key (when user doesn't know primary key then they can search using alternate key -ex:train name and number)
	Ø Unique key
	Ø Composite key
	Ø Seconady key
	Ø Super key
	Ø Database objects
		○ Tables,views,indexes,procedures(using create command all are objects)
		○ View - create view viewname
			§ Why? - if a person wants to see only particular part of data when there are lot of entries
			§ Abstraction acquired by view(end user can't see the actual base table)
			§ Simple and complex view
		○ Inbuilt ,user defined types
		○ Index(key+ addresss of the key)
			§ Culstured -sorted form
			§ Non-clustered- non sorted form
		○ Sequence - automatic generation (random number ), auto increment, usually to generate primary key
	Ø Collection of fields - records ; collection of records - file
	Ø Properties
		○ Atomicity -transaction is treated as single (if any single manipulation fails whole transaction is rolled back and no updation in database)
		
		○ Locks - table lock,row lock, page lock
	Ø OLTP - day to day /daily current operational data
	Ø OLAP - historical data -cannot be changed
	Ø Heap - not stored in sorted manner(data is appended not sorted)
	Ø IOT table(index organized table)- sorts the data
	Ø Normalization (to avoid redundancy,update,insert anamolies(kinda errors),ambiguous) -process of organising and structure the data
		○  1NF - each table cell should contain signle value and each record should be unique value
		○ 2NF - be in 1NF and single column primary key that does not functionally dependent on any subset of candidate key relation
		   dividing the table into two tables and relating each other with primary key and foreign key(when we have composite key and non-key attributes depends on only part of composite key)
		   
		Student_ID	Course_ID	Instructor_ID	Instructor_Name	Grade
		1	101	1001	Dr. Smith	A
		2	102	1002	Dr. Brown	B
		1	102	1002	Dr. Brown	A
		3	101	1001	Dr. Smith	C
		
			To check if the relation is in 2NF, we need to identify partial dependencies:
				• The primary key is Student_ID, Course_ID.
				• The Grade is fully dependent on the entire primary key (Student_ID, Course_ID). So, there is no partial dependency for the Grade attribute.
				• However, Instructor_ID depends only on Course_ID, which is part of the composite primary key (Student_ID, Course_ID), and not the entire key. This is a partial dependency.
				• Instructor_Name depends on Instructor_ID, which in turn depends on Course_ID. Since Instructor_ID is dependent on Course_ID (a part of the primary key), this is also a partial dependency.
			Thus, the relation is not in 2NF because it has partial dependencies.
			
		○ 3NF- be in 2NF and when there is transitive dependency (a->b,b->c and a->c) - non-key attribute dependent on another non-key attribute and indirectly on primary key
			§ In order to achieve that non-key attribute directly depends on primary key we make a relationship
			EmployeeID	Name	Department	DepartmentHead	DepartmentLocation
			101	Alice	HR	John Smith	Building A
			102	Bob	IT	Mary Johnson	Building B
			103	Carol	IT	Mary Johnson	Building B
				• Primary Key: EmployeeID
				• Non-key attributes: Name, Department, DepartmentHead, DepartmentLocation
			Issue:
				• The DepartmentHead and DepartmentLocation depend on Department, not directly on EmployeeID. This is a transitive dependency because:
					○ Department → DepartmentHead (i.e., a department has a specific head),
					○ Department → DepartmentLocation (i.e., a department is located in a specific place),
					○ EmployeeID → Department (i.e., each employee is assigned to a department).
			So, we have transitive dependencies: EmployeeID → Department → DepartmentHead and EmployeeID → Department → DepartmentLocation.
			§ In the new structure:
				○ The first table now contains Department as the primary key.
				○ The second table uses EmployeeID as the primary key, and Department becomes a foreign key that references the Department table.
		Resulting Tables After Applying 3NF:
			1. Employee Table:
			EmployeeID	Name	Department
			101	Alice	HR
			102	Bob	IT
			103	Carol	IT
			2. Department Table:
			Department	DepartmentHead	DepartmentLocation
			HR	John Smith	Building A
			IT	Mary Johnson	Building B
		○ BCNF - be in 3NF and 
			§ BCNF Rule: A relation is in BCNF if, for every functional dependency A→B, the determinant A is a candidate key. This means that no non-prime attribute (an attribute not part of any candidate key) can act as a determinant for any other attribute in the relation.
			§ Student_ID	Course_ID	Instructor_ID	Instructor_Name
			1	101	1001	Dr. Smith
			2	101	1001	Dr. Smith
			3	102	1002	Dr. Brown
			4	103	1003	Dr. Clark
			5	101	1001	Dr. Smith
			§ Student_ID → Course_ID: Student_ID is a candidate key, so this is fine in BCNF.
			§ Course_ID → Instructor_ID: Course_ID is not a candidate key because it does not uniquely identify the entire row (you would need both Student_ID and Course_ID to uniquely identify each row in the relation). Since Course_ID is not a candidate key and it determines Instructor_ID, this violates BCNF.
			§ Instructor_ID → Instructor_Name: Instructor_ID is a candidate key for the Instructor table, so this functional dependency is fine in BCNF.
		Conclusion:
			• In BCNF, every determinant must be a candidate key. If a determinant is not a candidate key, then the relation violates BCNF and needs to be decomposed into smaller relations.
		○ RAID -reduntant array of independent disks 
			
	Ø T-SQL-(enhanced sql which includes loops,varibales,conditionals,stored procedures-execute batch of queries)
		○ EXAMPLE    -- Create a table for demonstration
		CREATE TABLE Employees (
		    EmployeeID INT PRIMARY KEY,
		    FirstName NVARCHAR(50),
		    LastName NVARCHAR(50),
		    Department NVARCHAR(50),
		    Salary DECIMAL(10, 2)
		);
		
		-- Insert some sample data
		INSERT INTO Employees (EmployeeID, FirstName, LastName, Department, Salary)
		VALUES
		(1, 'John', 'Doe', 'HR', 50000),
		(2, 'Jane', 'Smith', 'IT', 60000),
		(3, 'Bill', 'Johnson', 'Sales', 45000);
		
		-- Declare a variable to hold the department name
		DECLARE @Department NVARCHAR(50);
		SET @Department = 'IT';
		
		-- Declare a variable to hold the average salary
		DECLARE @AverageSalary DECIMAL(10, 2);
		
		-- Try to calculate the average salary for a department
		BEGIN TRY
		    -- Calculate the average salary for the given department
		    SELECT @AverageSalary = AVG(Salary)
		    FROM Employees
		    WHERE Department = @Department;
		    
		    -- If no rows are found, throw an error
		    IF @AverageSalary IS NULL
		    BEGIN
		        THROW 50000, 'No employees found in this department.', 1;
		    END
		
		    -- Output the average salary
		    PRINT 'Average salary in ' + @Department + ' department: ' + CAST(@AverageSalary AS NVARCHAR(50));
		
		END TRY
		BEGIN CATCH
		    -- Error handling if something goes wrong
		    PRINT 'Error: ' + ERROR_MESSAGE();
		END CATCH;
		○ If there is no value entered '0' is filled unlike sql where null is filled
	Ø MSSQL SERVER ARCHITECTURE
		○ Client server-based architecture - server response to client query(2 tier architecture-client and database on different systems)
		○ 1 tier architecture - client and database on same system
		○ Components of sql server
			• Database engine - creates and drives  relational databases
			• Analysis service(ssas)- data analysis componenet
			• Reporting services(ssrs)-  generating and deploying report
			• Integration service(ssis) - etl (extract,transform and load)
		○ Sql server architecture
			• 
			• Protocol layer-server network interface-(shared memory,tcp/ip,named pipes and tds-tabular data stream:this enables data transfer from client to server machine)
				○ Named pipes used by inter-process communication
			• Relational engine(cmd parser,optimizer and query executor)
				○ Optimizer 
					○ Phase0- trivial plan
					○ Phase1 -transaction processing plan
					○ Phase2- parallel processing and optimizations
				
			• Storage engine(file types,access method,buffer manager,plan cache and transaction manager) - responsible for storage and retrieval from storage systems disk/san
				○ Data file and log file are at disk level
				○ Buffer manager 
					○ Plan chache
					○ Data parsing
					○ Dirty page
				○ Access methid
					○ Ddl,select stament - buffer manager
					○ Ddl, non-select - transaction manager
		○ Query execution process in SQL server
			• 
			
			• 
		○ Logical storage
			• The data is organized and accessed (databses ,tables,indexes and schemas)
			• It is how users and applications interact with the data via SQL queries, regardless of the physical storage structure.
			• Data is stored in data file as data pages(8kb)
			• Types of data pages
				○ Data page
				○ Text/image
				○ Index
				○ Pfs(page free space)
				○ Bcm(bulk change map)
				○ Iam(index allocation map)
				○ Dcm(differential change map)
			• 1 extent = collention of 8 pages -The extent is the smallest unit of storage that SQL Server allocates to store data on disk.
				○ Uniform extent- single object(table) is stored in 8 pages
				○ Mixed extent -upto 8 objects can share mixed extent - each of eight pages is owned by different object
					○ Global allocation map
					○ Shared global allocation map
			• Each page has 96-byte header at the top(free space,page number,page type)
			• Row offset at end of page- stores the base location /postion/address of specific row - stored at end of page in reverse order
		○ Physical storage
			• It handles the mapping of logical objects (like tables and indexes) to physical storage locations on disk, ensuring data persistence and performance optimization.
			• Data file
				○ Physical storage(.mdf)
				○ Data files can be created together in file groups fro allocation,distribution and administration purposs
				○ Primary data file(.mdf)
					○ Data related to objects like tables,indexes,triggres .. Are stored here
					○ Every database must have atleast one primary file
				○ Secondary data file(.ndf)
					○ Optional and contains user-specific data
					○ Used to extend the storage of database
			• Log file
				○ Stores a series of log records(.ldf)
				○ Used for transaction management
				○ Transaction log is imp for disaster recovery
			• 
		○ SQL server managers
			• Buffer manager - provides access to the necessary data(soft parse/hard parse)
			• Transaction manager - used when access method concludes request is an operator with no choice
			• Log manager-it monitors all system updates via transaction logs
			• Dirty pages-stored as transaction manager processing logic
	Ø MSSQL DATABSAE CREATION
		○ Database types
			• System database
				○ Master-
				○ Msdb
				○ Model
				○ Tempdb
				○ Resource
				○ 
			• User databse
			• Add filegroup in sql server
				○ Alter databse dbname add filegroup fgname
			• Add file to filegroup name
				○ 
		○ Add log file to sql server
			• 
		○ Modfiy data file in sql server
			• 
		○ Data operations in sql server
			• Create new db
			• Add new filegroup
			• Add new datafile in primary/seconadry file
			• Change datafile size
			• Remove data files 
			• Drop database
	Ø MSSQL RECOVERY MODEL
		○ Types of recovery model
			• Simple(by default)
				○ Full /differential/file backup ,no transactional backup
				○ Point in time not supported
				○ It is used in Developing/testing 
			• Full
				○ All transactions Ddl+dml documented in transaction log file
				○ Supports point in time
				○ Data loss can be avoided
				○ Bank transactions,finacial
				○ More filegroups - to recover piecemeal of secondary file/read only file
			• Bulk logged
				○ To prevent log file growth
		○ Ways to change recovery model
			• Ssms
				○ 
			• t-sql
				○ 
				
				○ 
			• Powershell
				○ 
				
				○ 
	Ø MSSQL Index
		○ Index will have keys+address
		○ Clustered index
			• Used to sort and store the data
			• Clustered index keys serves as row finders
		○ Non-clustered index
			• Row locator is pointer to the row 
		○ Table scan
			• There is system table called sysindexes that contains the information of indexes on tables
			• If no index, then there will be one row which says that there is no index on table
			• When select query is given sql server refere 'indi/index'
			
		○ Index creation
			• 
		○ Single and composite indexes
			• If index is created on single column it is simple index
			• If index is created on conjuction of two tables it is composite table
			• Create index notedidx on emp(deptno asc,job desc)
			• Sp_helpindex emp - to find already created examples
			• Drop index indexname on objectname
		○ Index used by optimizer
			• Indexes that are well designed an reduce I/O operation and use fewer system resourses
			• Query optimizer considers all available data retrieval methods and chooses the best one
			• The approach can be table can or scan of one or more indexes if exists
			• Query optimizer scans every row in table during a table scan and extracts the row that satisfies the query requirements(it uses lot of resources and numerous disk IO operations)
			• When query optimizer uses indexes , it search the index key columns for the storage location of row data 
			• Index search is better than table search , unlike table index frequemtly have very few columns per row and rows are sorted
		○ Monitor index maintenance and update statistics
			• Remove index index fragmentation
				○ A heavily fragmented index might degrade the performance because it requires additional IO. We can prform reorg or rebuild on index based on its fragmentation values
			• Remove unused indexes
				○ An unused index also consumes storage and increases maintenance overhead
			• Below 30% fragmentation we opt for reorganize
			• Above 30% we opt for rebuild
			• Whenever we go for reorganize /rebuild -update statistics is mandatory
			• If update statistics is not performed query optimizer might produce incorrect execution plan 
		○ Index selection and query optimizer
			• Query optimizer uses indexes to produce better execution plan - index selection is the most significant approach in query optimization
			• Unused indexes should be removed
			• Sys.dm_db_index_usage_stats DMV tool: gives the existing unused indexes
	Ø MSSQL ManagingInstance
		○ An instance of the database engine is copy of sqlserver.exe executable that runs as an operating system service((copy of server files,databases and security credentials) 
		○ Each instances manages several system databases and one or more user databases.
		○ Each computer can run multiple instances of database engines
		○ 
			
		○ Multiple instances in sql server
			• Well protected from one another,don't interfere and each instance has own databases ,logins and security
			• Multiple instances gives the ability to spread load over tempdb
		○ Facts to choose multiple instance
			• Memory usage
			• Tempdb disk usage
			• Cpu usage
			• Io
			• Ease of administration
			• Cost of liecensing
			• Monitoring
		○ Steps to create multiple instances in SQL server
			• 
			
			• 
			
			• 
			
			• 
		○ Types of server
			• Database engine : core component of sql server instance ,used for storing,processing and securing
			• Analysis services - SSAS :is a multidimensional analysis tool that features OLAP , powerful data mining abilities and reporting used in business intelligence  to ease your managing data tasks
			• Reporting servives - SSRS is a reporting and visualization tool for server , and by using it , one can create ,manage and publish reports  and dashboards
			• Integration services - SSIS is fast and flexible data warehousing  tool that  can be used for data extraction and executing a wide range of data migration task
			• Azure SSIS integration runtime  is the compute infrastructure used by  azure data factory to provide the data integration capabilities across different network environments
			• 
			
			• 
			
			• 
		○ SQl server components
			• Windows authentication :this mode allows to connect through windows user account
			• SQL server aunthentication : anytime this mode is used proper login and password is required
			• Azure active directorty
				○ Universal with MFA :this mode delivers strong authentication  with a different  verification options user can choose  from - phone call,text message,smart cards  with a pin or mobile app notifications
				○ Password : use this mode connecting to sql  server instance  database  and when logged  into windows using azure AD credentials  from a domain  not combined  with azure
				○ Integrated : this mode is used when connecting to sql database  and logged into windows using azure active directory  credentials from federated domain
	Ø MSSQL Replication Overview
		○ Replication of group of techniques for transferring data and database objects between  databases while synchronizing  them to preserve consistency
		○ Replication is used to distribute data to several locations as well as remote or mobile users via local and wide area networks, dial-up connections, wireless connections, and the internet
		○ Sql server replication is used for copying and synchronizing data continuously or it can be scheduled to run at predetermined intervals
		○ There are several different replication techniques that support a variety of data synchronization approches :
			• One-way
			• One-to-many
			• Many-to-one
			• Bi-directional
			• Note :Also keep several datasets in sync with each other
		○ Transactional replication is commonly applied in server -to-server settings requiring high throughout ,such as:
			• Improving scalability and availability
			• Data warehousing and reporting
			• Integrating data from multiple sites
			• Integrating heterogeneous data
			• Offloading batch processing
		○ Main roles in replication : distributor ,publisher,subscriber
			• 
		○ Benefits of replication
			• Improves performance and reduces locking conflicts
			• High availability
			• To work with its own copy of data,each location can have own rules and procedures
		○ Snapshot replication : replicates the data exactly as it is appeared at the time of database snapshot taken
			• 
			• Advantages : 
				○ Simple to set up
				○ Low maintenance
				○ Database tables need not have primary keys
			• Disadvt: 
				○ Modifications made  to the subscriber are lost after the new snapshot
				○ Snapshot agent generates high impact when it runs
		○ Transactional replication:
			• Periodic automated replication of data from a master database  to a database replica in real time
			• 
			• Advantages:
				○ Suitable for high transactional data
				○ Requires low latency
			• Disadvantages:
				○ Setting up transactional replication can be challenging risk,especially for beginners
				○ It is prone to faults  and can be affected events such as primary key violation
		○ Peer- to-peer replication :simultaneously replicating the databse data to numerous subscribers 
			• 
			
			• 
		○ Merge applicatin : bi-directional replication that is commonly used in server-to-client  contexts  to synchronize data between database servers that are non continuously linked
			• 
			• Advantages:
				○ Let subscribers update records
				○ It allows offline subscribers to make change to data
			• Disadvantages:
				○ Setting up is risk
				○ It is prone to create conflicts between publisher and subscribers
		○ Requirements for  sql server replication
			• The following ports should be opened for inbound traffic
				○ Tcp 1433,1434,2383,2382,,135,80,443
				○ Udp 1434
				○ Before installing msmsql server,configure windows firewall and open the relevant poerts  for inbound traffic  on each host
				○ Before setting mssql replication,following softwares should be installed
					○ .net framework - a set of libraries
					○ Msmsql server-  the database server software
					○ Mssql server management studio (ssms)
		○ Terminologies in sql
			• 
			
			• 
			
			
			
		○ 
			
			
	Ø MSSQL BACKUP RECOVERY
		○ Backing up is the process of making duplicates of crucial data on computer .
		○ Process of restoring deleted or damaged data from backups is called recovery
		○ Copies of Backups should be stored in secured,off-site place
		○ Back and recovery strategy should be made and efficiently and tested properly,then only we can implement or use it 
		○ Best practice recommendations
			• Use separate storage
			• Choose appropriate recovery model
			• Design backup strategy
			• Estimate the size of full databse backup
			• Schedule bacjups
			• Test your backups
			• Verify media stability and consistency
			• Document backup/recovery strategy
			• Monitor progress with xevent
		○ Types of backups
			• Full backups
			• Differential backups
			• File backups
			• Filegroup backups
			• Partila backups
			• Copy-only backups
			• Mirror backups
			• Transaction log backups
		○ 
		
		○ 
		
		○ 
		○ Clean resources :
			• Run the following t-sql  command to remove the databse  you created , along with its backup history in the msdb databse
				○ Exec msdb.dbo.sp_delete_database_backuphistory @database_name=N'SQL TESTDB'
	Ø SQL ARCHITECTURE MANAGEMENT
		○ Sql server architecture management
			• Sql database is created with one or more data files (.mdf and .ndf) and one transaction log file(.ldf). The data files includes the schema and data ,whereas the log file records the most recent modifications
			• Data is organized into pages (8kb)
			• Sql server - read,writes and modifies
		○ Data retrieval
			• Sql server accesses data by reading a complete page from disc and storing it in memory(RAM)
			• Pages are kept in memory until they are no longer needed
			• As sql works on same data set,same data page is regularly chnaged or read
		○ Data modification
			• Sql server uses table based on rows and columns to connect data(data consistency and security)
			• After each db modification - transaction occurance,data will be saved , and a log record will be written into the transaction log . All the chnages will be written sequentially
		○ Sql server authentication and authorization
			• Supports two authentication modes
				○ Windows authentication
				○ Sql server authentication
			• 
			• Windows authentication is integrated with windows user and group accounts,making it possible to use domain or local windows account to log into sql server
			• When a windows user connects to sql server ,the db engine validates the login credentials against windows principalauthentication,eleminating the need of separate sql credentials
			• Setting up authentication:
				○ Installation time
					○ 
				○ Post installation
					○ 
		○ Sql server login
			• Security identifier (SID) is needed to map and identify a login
			• 
			• Server user is different and databse user is different 
			• 
			
			• 
			
		○ Sql server permissions
			• Server level permissions
				○ It is assigned to login and server roles
			• Database level
				○ Is is assigned to databse user and database roles
	Ø MSSQL CONFIGURATION MANAGER
		○ It is used for
			• Managing network access for sql server client computers
			• Configuring the network protocols used by sql server
			• Managing the services connected to sql server
			• 
			
			• 
			• To change sql server startup parameters
				○ 
			• To enable always on
				○ 
			• Native client configuration
				○ 
				○ Clients can connect to the sql server uing below
					○ Tcp/ip
					○ Named pipes
						◊ These are used for inter-process communication and is configured for a local area network
					○ Shared memory
						◊ Clients use the shared memory protocol to connect to sql server instance on the same server
						◊ Basic protocol and no configuration options
						
	Ø MSSQL DATABASE MAINTENANCE
		○ Database maintenance
			• A set of tasks that are all run with the intention to improve your database , these are routines meant to help performance ,free up disk space,check for data errors, check for hardware faults, update internal statistics
			• Data maintenance have four main  categories
				○ 
				○ Index defragmentation
					○ A data page in both clustered or non-clustered indexes contains pointers to previous and next page 
					○ 
					○ Logical fragmentation - the logical order of the pages does not correspond their physical order
					○ Internal fragmentation - the data pages in the index contain free space. This led to an increase in the number of logical reads during the query execution
					○ 
					○ Detecting fragmentation :sys.dm_db_index_physical_stats data management function analyse fragmentation
						◊ Avg_page_space_used_in_percent shows the average percentage of data storage space used on the page
						◊ Avg_fragmentation_in_percent - external index fragmentation
						◊ For tables with clustered indexes fragment_count  indicates  how many continuous data fragments  the index has
					○ Removing index fragmentation
						◊ Alter index all on tablename reorganize
						◊ Alter index idex_name on tablename rebuild
						◊ 
				○ Log file maintenance
					○ When maintaining a databses's  transaction log we'll often want to retrieve  information about the log so we can verify its settings or track how much log space is being used
					○ Select name,size,max_size, growth, is_percent_growth from sys.database_files where type_desc='LOG'
					○ Backing up the log file
						◊ DBCC SQLPERF - check log file details
						◊ BACKUP LOG employeeDB  TO DISK ='E:\ogBackup\employeeDB_log.bak';
					○ 
					
					○ 
				○ File/data compaction
					○ When we work with sql db, the file size both grows and shrinks. Each time the file needs more space,  it grows  by a certain increment.And as data is added to the db (as a chunk), it is saved into any spot that has enough memory to store that chunk . Unfortunately , the data is not always stored close to other data from the same table. The data itself becomes fragmented , just like the indexes
					○ To resolve this, we run what is called a ' data compaction' , which reorganizes the file by grouping all associated data together. This not only groups data together, but it can also free up space inside  the file as well, which can then be reclaimed by the os  as free disk on hard disc
				○ Integrity check
					○ For checking logical and physical integrity of the sql server database /to correct errors run - DBCC CHECKDB
					○ Below operations are performed by dbcc checkdb command
						◊ DBCC CHECKALOOC
						◊ DBCC CHECKTABLE
						◊ DBCC CHECKCATALOG
						◊ DBCC CHECKDB
					○ The commands follows below steps
						◊ Verify the allocated structures such as GAM,SGAM,PFS,IAM
						◊ Verify the table consistency and its all indexes
						◊ Finally, verify all the system catalog
				○ Components of sql server
					○ HELP
					○ FLUCHAUTHCACHE
					○ TRACEOFF
					○ FREESESSIONCACHE
					○ TRACEON
					○ FREESYSTEMCACHE
					○ CLONEDATABASE
	Ø MSSQL DATABASE MONITORING
		○ Assessing server performance is the main aim of database monitoring
		○ Inorder to avoid processes that producing tasks and follow performsnce trends, effective monitoring  entails taking frequent snapshots of current performance 
		○ Server monitor
			• The process of monitoring server's system resources , such as CPU usage ,memory consumption ,I/O ,network ,disc usage, and processes 
			• Helps in capacity planning
			• For monitoring server availability and data loss
			• Responsiveness of server
			• To understand the server capacity, user load and speed of the server
			• To detect and prevent any issues that might effect the servee proactively
			• Reason to use sql server instance and db monitoring
				○ Capacity planning
				○ Monitor current resource usage
			• A good sql server monitoring plan can help you stay on top of performance, growth, security.
		○ Sql server monitoring key areas
			• Disk activity 
			• Processor utilization
			• Memory
		○ Sql server monitoring tools
			• Sql server profiler
			• Sql server management studio reports
			• Activity monitor
			• Sql logs,system monitor
			• Database engine stores procedures
		○ Window application log
			• Realted to windows event viewer
			• System log
			• Security log
			• Application log
			• 
		○ DBCC(Database concole command)
			• The dbcc commands listed below act on read-only database snapshot that the database creates internally
				○ DBCC CHECKALLOC
				○ DBCC CHECKATALOG
				○ DBCC CHECKDB
				○ DBCC CHECKFILEGROUP
				○ DBCC CHECKTABLE
	Ø MSSQL MOVING DATA
		○ Transferring data from one db to another db
		○ 
		
		○ 
		
		○ 
		○ Data transfer using script 
			• Right-click on databse  and select task
			• Click on generate scripts
			• Select the database you want to script
			• Choose the ocject types
			• Select the tables
			• Select the output option for the script
			• Change/edit the db name to the name you wan to execute the script for
	
			
![image](https://github.com/user-attachments/assets/3e2f09fb-0114-49f7-9ad4-3fc70bbf547c)
